package app.myParseFinancialExcel.myFinancialReportFinal.operationForBaseGeneralItems.operationForBaseArticleWB;

import app.myParseFinancialExcel.annotations.ReasonForPayment;
import app.myParseFinancialExcel.interfaceOperationForArticleWB.OperationForBaseGeneralMyReport;
import app.myParseFinancialExcel.myFinancialReportBaseWB.Thing;
import app.myParseFinancialExcel.annotations.DocumentType;
import app.myParseFinancialExcel.annotations.NameField;
import app.myParseFinancialExcel.myArticleWB.BaseArticleWB;
import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;

import java.math.BigDecimal;
import java.util.List;

public class SaleAndPartialMarriageCompensation implements OperationForBaseGeneralMyReport {


    @Override
    @NameField("+")
    @DocumentType("Продажа")
    @ReasonForPayment("Частичная компенсация брака")
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {
        List<Thing> baseArticleWBthingsList = baseArticleWB.getSaleAndPartialMarriageCompensation();
        List<GeneralInfoItems> baseGeneralItemsList = baseGeneralItems.getBaseGeneralItems();
        GeneralInfoItems generalInfoItems = new GeneralInfoItems();

        if(baseArticleWBthingsList == null) {
            return false;
        }

        for(Thing thing : baseArticleWBthingsList) {
            generalInfoItems = generalInfoItems.thingToGeneralInfoItems(thing);
            if(baseGeneralItemsList.contains(generalInfoItems)) {
                generalInfoItems = baseGeneralItemsList.get(baseGeneralItemsList.indexOf(generalInfoItems));
                BigDecimal transferredToSellerSoldGoods = thing.getTransferredToSellerSoldGoods();
                BigDecimal result = generalInfoItems.getTransferredSeller().add(transferredToSellerSoldGoods);
                generalInfoItems.setTransferredSeller(result);
                generalInfoItems.setAmountForMarriage(generalInfoItems.getAmountForMarriage().add(transferredToSellerSoldGoods));
            } else {
                baseGeneralItemsList.add(generalInfoItems);
                BigDecimal transferredToSellerSoldGoods = thing.getTransferredToSellerSoldGoods();
                BigDecimal result = new BigDecimal(0).add(transferredToSellerSoldGoods);
                generalInfoItems.setTransferredSeller(result);
                generalInfoItems.setAmountForMarriage(new BigDecimal(0).add(transferredToSellerSoldGoods));
            }
        }
        return true;
    }
}
