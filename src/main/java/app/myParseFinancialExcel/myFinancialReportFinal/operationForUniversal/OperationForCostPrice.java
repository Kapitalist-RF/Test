package app.myParseFinancialExcel.myFinancialReportFinal.operationForUniversal;


import app.myParseFinancialExcel.costPrice.CostPrice;
import app.myParseFinancialExcel.interfaceOperationForArticleWB.OperationForBaseGeneralMyReport;
import app.myParseFinancialExcel.myArticleWB.BaseArticleWB;
import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;
import app.myParseFinancialExcel.costPrice.CostThing;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;


public class OperationForCostPrice implements OperationForBaseGeneralMyReport {

    private Path path;

    public OperationForCostPrice(Path path) {
        this.path = path;
    }

    @Override
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {
        CostPrice costPrice = new CostPrice();
        List<CostThing> costThingList = costPrice.readCostThings(path);

        if(baseGeneralItems.getBaseGeneralItems() == null) {
            return false;
        }

        for(GeneralInfoItems generalInfoItems : baseGeneralItems.getBaseGeneralItems()) {
            String itemBarcode = generalInfoItems.getBarcode();
            if(costThingList != null) {
                for (CostThing costThing : costThingList) {
                    String costBarcode = costThing.getBarcode();
                    if(costBarcode.equals(itemBarcode)) {
                        generalInfoItems.setCostPrice(costThing.getCost());
                    }
                }
            }
            if(generalInfoItems.getCostPrice().equals(new BigDecimal(0))) {
                generalInfoItems.setCostPrice(new BigDecimal(0));
            }
        }

        for(GeneralInfoItems generalInfoItems : baseGeneralItems.getBaseGeneralItems()) {
            generalInfoItems.setCostOfGoodsSold(generalInfoItems.getSalesPCS().multiply(generalInfoItems.getCostPrice()));
        }

        return true;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
