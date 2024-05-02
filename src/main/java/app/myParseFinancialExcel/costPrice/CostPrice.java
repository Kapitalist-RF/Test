package app.myParseFinancialExcel.costPrice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CostPrice {

    private List<CostThing> costThings;

    public List<CostThing> getCostThings() {
        return costThings;
    }

    public void setCostThings(List<CostThing> costThings) {
        this.costThings = costThings;
    }

    public List<CostThing> readCostThings (Path path) {
        if(path == null) {
            return null;
        }
        List<CostThing> costThings = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(path.toFile());
            XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            Row row = it.next();
            while (it.hasNext()) {
                CostThing costThing = new CostThing();
                row = it.next();
                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    CellType cellType = cell.getCellType();
                    if(cellType == CellType.STRING) {
                        costThing.setBarcode(cell.getStringCellValue());
                    } else {
                        costThing.setCost(new BigDecimal(cell.getNumericCellValue()));
                    }

                }
                costThings.add(costThing);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return costThings;
    }

}
