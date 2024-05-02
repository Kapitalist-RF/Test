package app.myParseFinancialExcel.myFinancialReportFinal.operationForUniversal;


import app.myParseFinancialExcel.interfaceOperationForArticleWB.OperationForBaseGeneralMyReport;
import app.myParseFinancialExcel.myArticleWB.BaseArticleWB;
import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;

public class OperationForLogisticAndTransferred implements OperationForBaseGeneralMyReport {


    @Override
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {

        if(baseGeneralItems.getBaseGeneralItems() == null) {
            return false;
        }

        for(GeneralInfoItems generalInfoItems : baseGeneralItems.getBaseGeneralItems()) {

            generalInfoItems.setTotalAmountForLogistics(generalInfoItems.getSalesLogistics().add(generalInfoItems.getReturnLogistics()));

            generalInfoItems.setTransferredSellerAfterDeductionAllExpenses(generalInfoItems.getTransferredSeller()
                    .subtract(generalInfoItems.getTotalAmountForLogistics())
                    .subtract(generalInfoItems.getTotalFine()));
        }
        return true;
    }
}
