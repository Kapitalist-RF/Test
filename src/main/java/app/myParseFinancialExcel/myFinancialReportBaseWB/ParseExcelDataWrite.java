package app.myParseFinancialExcel.myFinancialReportBaseWB;

import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;
import app.myParseFinancialExcel.annotations.NameField;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParseExcelDataWrite {

    public boolean writeGeneralItemToExcel(BaseGeneralItems baseGeneralItems) {

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(baseGeneralItems.getNameFinalFileExcelStr() + ".xlsx")){

            List<String> myHeader = createHeader();

            Sheet sheet = workbook.createSheet("FinancialWB");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 4000);

            Row header = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);


            Cell headerCell = null;
            for (int i = 0; i < myHeader.size(); i++) {
                headerCell = header.createCell(i);
                headerCell.setCellValue(myHeader.get(i));
                sheet.autoSizeColumn(i);
            }

            int countRow = 1;
            for (GeneralInfoItems generalInfoItems : baseGeneralItems.getBaseGeneralItems()) {
                Field[] fields = generalInfoItems.getClass().getDeclaredFields();
                Row myRow = sheet.createRow(countRow);
                Cell myCell = null;
                for (Field field : fields) {
                    field.setAccessible(true);
                    String nameField = field.getDeclaredAnnotation(NameField.class).value();
                    for (int i = 0; i < myHeader.size(); i++) {
                        myCell = myRow.getCell(i);
                        if (myCell == null) {
                            myCell = myRow.createCell(i);
                        }

                        String headerName = myHeader.get(i);
                        if (nameField.equals(headerName)) {
                            try {
                                Type type = field.getType();
                                if (type.equals(BigDecimal.class)) {
                                    myCell.setCellValue(((BigDecimal) field.get(generalInfoItems)).doubleValue());
                                } else {
                                    myCell.setCellValue(String.valueOf(field.get(generalInfoItems)));
                                }
                                break;
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }

                }
                countRow++;
            }

            sheet = workbook.createSheet("FinancialWBINFO");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 4000);

            Row row = null;

            headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            font.setBold(true);
            headerStyle.setFont(font);

            List<String> headerTwo = createHeaderSheetTwo();
            Cell cellTwo = null;

            Field[] fields = baseGeneralItems.getClass().getDeclaredFields();
            for(int i = 0; i < headerTwo.size(); i++) {
                row = sheet.createRow(i);
                String nameHeaderTwo = headerTwo.get(i);
                cellTwo = row.createCell(0);
                cellTwo.setCellValue(nameHeaderTwo);
                for (Field field : fields) {
                    field.setAccessible(true);
                    String nameField = null;
                    try {
                        nameField = field.getDeclaredAnnotation(NameField.class).value();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(nameHeaderTwo.equals(nameField)) {
                        cellTwo = row.createCell(1);
                        cellTwo.setCellValue(((BigDecimal) field.get(baseGeneralItems)).doubleValue());
                    }
                }
            }
            workbook.write(fos);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<String> createHeader() {
        List<String> header = new ArrayList<>();
        header.add("Бренд");
        header.add("Предмет");
        header.add("Наименование (Предмет, артикул, размер)");
        header.add("Заказы, шт.");
        header.add("Возврат, шт.");
        header.add("Продажи, шт.");
        header.add("Сумма за брак (компенсация)");
        header.add("WB потерял товар, шт.");
        header.add("WB нашел товар, шт.");
        header.add("Логистика продаж");
        header.add("Логистика возвратов");
        header.add("Общая сумма за логистику");
        header.add("Общая сумма штрафов");
        header.add("К перечислению продавцу после вычета всех расходов(логистика, штрафы)");
        header.add("ЧП после вычета себестоимости и налога");
        header.add("Себестоимость проданного товара");
        header.add("Себестоимость");
        header.add("Баркод");
        return header;
    }

    public List<String> createHeaderSheetTwo() {
        List<String> header = new ArrayList<>();
        header.add("Доплаты");
        header.add("Стоимость хранения");
        header.add("Стоимость платной приемки");
        header.add("Прочие удержания");
        header.add("Итого к оплате");
        header.add("ЧП после вычета себестоимости и налога");
        return header;
    }





}
