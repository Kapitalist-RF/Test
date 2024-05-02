package app.myParseFinancialExcel.myFinancialReportFinal.operationForUniversal;


import app.myParseFinancialExcel.interfaceOperationForArticleWB.OperationForBaseGeneralMyReport;
import app.myParseFinancialExcel.myArticleWB.BaseArticleWB;
import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;

import java.math.BigDecimal;

public class OperationForTaxAndNetProfit implements OperationForBaseGeneralMyReport {

    private BigDecimal tax = new BigDecimal(0);

    public OperationForTaxAndNetProfit(BigDecimal bigDecimal) {
        this.tax = bigDecimal;
    }


    @Override
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {

        if(baseGeneralItems.getBaseGeneralItems() == null) {
            return false;
        }

        for(GeneralInfoItems generalInfoItems : baseGeneralItems.getBaseGeneralItems()) {
            BigDecimal taxItem = generalInfoItems.getWBSoldGoodsPr()
                    .divide(new BigDecimal(100))
                    .multiply(tax);
            generalInfoItems.setTax(taxItem);

            generalInfoItems.setNetProfit(generalInfoItems.getTransferredSellerAfterDeductionAllExpenses()
                    .subtract(generalInfoItems.getCostOfGoodsSold())
                    .subtract(generalInfoItems.getTax()));
        }

        return true;
    }
}
