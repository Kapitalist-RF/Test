package app.myParseFinancialExcel.myFinancialReportFinal.operationForBaseGeneralItems.operationForBaseArticleWB;

import app.myParseFinancialExcel.annotations.ReasonForPayment;
import app.myParseFinancialExcel.interfaceOperationForArticleWB.OperationForBaseGeneralMyReport;
import app.myParseFinancialExcel.myArticleWB.BaseArticleWB;
import app.myParseFinancialExcel.myFinancialReportBaseWB.Thing;
import app.myParseFinancialExcel.myFinancialReportFinal.BaseGeneralItems;
import app.myParseFinancialExcel.annotations.DocumentType;
import app.myParseFinancialExcel.annotations.NameField;
import app.myParseFinancialExcel.myFinancialReportFinal.GeneralInfoItems;

import java.math.BigDecimal;
import java.util.List;

public class SaleAndFines implements OperationForBaseGeneralMyReport {


    @Override
    @NameField("-")
    @DocumentType("")
    @ReasonForPayment("Штрафы")
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {
        List<Thing> baseArticleWBthingsList = baseArticleWB.getSaleAndFines();
        List<GeneralInfoItems> baseGeneralItemsList = baseGeneralItems.getBaseGeneralItems();
        GeneralInfoItems generalInfoItems = new GeneralInfoItems();

        if(baseArticleWBthingsList == null) {
            return false;
        }

        for(Thing thing : baseArticleWBthingsList) {
            generalInfoItems = generalInfoItems.thingToGeneralInfoItems(thing);
            if(baseGeneralItemsList.contains(generalInfoItems)) {

                generalInfoItems = baseGeneralItemsList.get(baseGeneralItemsList.indexOf(generalInfoItems));
                BigDecimal totalFine = thing.getTotalFine();
                BigDecimal result = generalInfoItems.getTotalFine().add(totalFine);
                generalInfoItems.setTotalFine(result);

                BigDecimal returnPCS = thing.getReturnQuantity().add(generalInfoItems.getReturnPCS());
                generalInfoItems.setReturnPCS(returnPCS);
            } else {
                baseGeneralItemsList.add(generalInfoItems);
                BigDecimal totalFine = thing.getTotalFine();
                BigDecimal result = new BigDecimal(0).add(totalFine);
                generalInfoItems.setTotalFine(result);
                generalInfoItems.setReturnPCS(thing.getReturnQuantity());

            }
        }


        return true;
    }
}
