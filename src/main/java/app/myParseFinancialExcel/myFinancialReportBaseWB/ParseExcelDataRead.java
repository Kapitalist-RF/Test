package app.myParseFinancialExcel.myFinancialReportBaseWB;

import app.myParseFinancialExcel.annotations.NameField;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class ParseExcelDataRead {

    public List<Thing> parseThings(Path path) {
        List<Thing> thingList = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(path.toFile());
            XSSFWorkbook workbook = new XSSFWorkbook(file)){
            XSSFSheet sheet = workbook.getSheetAt(0);
            int countRows = countRows(sheet);
            int countCells = countCells(sheet);
            Row rowName = sheet.getRow(0);
            for (int i = 1; i < countRows; i++) {
                Thing thing = new Thing();
                Field[] fields = thing.getClass().getDeclaredFields();
                for(Field field : fields) {
                    String nameAnnotation = field.getAnnotation(NameField.class).value();
                    for(int y = 0; y < countCells; y++) {
                        Cell cell = rowName.getCell(y);
                        String rowNameString = cell.getStringCellValue();
                        if(rowNameString.equals(nameAnnotation)){
                            Row myRow = sheet.getRow(i);
                            Cell myCell = myRow.getCell(y);
                            if(myCell == null) {
                                if(nameAnnotation.equals("Тип документа")) {
                                    field.setAccessible(true);
                                    field.set(thing, "");
                                }
                                break;
                            }
                            CellType cellType = myCell.getCellType();
                            if(cellType == CellType.STRING) {
                                field.setAccessible(true);
                                String regex = "\\d{4,}-\\d{2,}-\\d{2,}";
                                String myString = myCell.getStringCellValue();
                                if(Pattern.matches(regex, myString)) {
                                    String[] myCalendars = myString.split("-");
                                    if(myCalendars.length != 0) {
                                        Calendar calendar = new GregorianCalendar(Integer.parseInt(myCalendars[0]),
                                                Integer.parseInt(myCalendars[1]),Integer.parseInt(myCalendars[2]));
                                        try {
                                            field.set(thing, calendar);
                                        } catch (Exception e) {
                                            System.out.println(Arrays.toString(myCalendars));
                                        }

                                    }
                                } else {
                                    if(field.getType().equals(Calendar.class)) {
                                        String temp = myCell.getStringCellValue();
                                        System.out.println(temp);
                                    } else if (field.getType().equals(BigDecimal.class)) {
                                        System.out.println("BG");
                                        field.set(thing, new BigDecimal(0));
                                    } else {
                                        field.set(thing, myCell.getStringCellValue());
                                    }
                                }
                            } else if (cellType == CellType.NUMERIC) {
                                field.setAccessible(true);
                                if (DateUtil.isCellDateFormatted(myCell)) {
                                    field.set(thing, myCell.getDateCellValue());
                                } else {
                                    if(field.getType().isPrimitive()) {
                                        field.set(thing, (int) myCell.getNumericCellValue());
                                    } else {
                                        field.set(thing, new BigDecimal(myCell.getNumericCellValue()));
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                thingList.add(thing);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return thingList;
    }

    public int countRows(XSSFSheet sheet) {
        int result = 0;
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()){
            result++;
            rowIterator.next();
        }
        return result;
    }

    public int countCells(XSSFSheet sheet) {
        int result = 0;
        Row row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()){
            result++;
            cellIterator.next();
        }
        return result;
    }



}
