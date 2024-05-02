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

public class SaleAndLogistics implements OperationForBaseGeneralMyReport {


    /**
     * К клиенту при продаже
     * К клиенту при отмене
     * От клиента при отмене
     * От клиента при возврате
     * Возврат своего товара (К продавцу)
     * */
    @Override
    @NameField("-")
    @DocumentType("")
    @ReasonForPayment("Логистика")
    public boolean operationForBaseGeneralMyReport(BaseArticleWB baseArticleWB, BaseGeneralItems baseGeneralItems) {

        List<Thing> baseArticleWBthingsList = baseArticleWB.getSaleAndLogistics();
        List<GeneralInfoItems> baseGeneralItemsList = baseGeneralItems.getBaseGeneralItems();
        GeneralInfoItems generalInfoItems = new GeneralInfoItems();

        if(baseArticleWBthingsList == null) {
            return false;
        }

        String toTheCustomerInTheSale = "К клиенту при продаже";
        String toTheCustomerUponCancellation = "К клиенту при отмене";
        String fromClientOnCancellation = "От клиента при отмене";
        String fromCustomerOnReturn = "От клиента при возврате";

        for(Thing thing : baseArticleWBthingsList) {
            generalInfoItems = generalInfoItems.thingToGeneralInfoItems(thing);
            BigDecimal thingCountOfDeliveries = thing.getCountOfDeliveries();
            BigDecimal thingReturnQuantity = thing.getReturnQuantity();
            BigDecimal thingServicesForDeliveryGoodsToBuyer = thing.getServicesForDeliveryGoodsToBuyer();
            if(baseGeneralItemsList.contains(generalInfoItems)) {

                generalInfoItems = baseGeneralItemsList.get(baseGeneralItemsList.indexOf(generalInfoItems));

                if(!thingCountOfDeliveries.equals(new BigDecimal(0))) {
                    generalInfoItems.setOrdersPCS(generalInfoItems.getOrdersPCS().add(thingCountOfDeliveries));
                    generalInfoItems.setSalesLogistics(generalInfoItems.getSalesLogistics().add(thingServicesForDeliveryGoodsToBuyer));
                } else if(!thingReturnQuantity.equals(new BigDecimal(0))) {
                    generalInfoItems.setReturnPCS(generalInfoItems.getReturnPCS().add(thingReturnQuantity));
                    generalInfoItems.setReturnLogistics(generalInfoItems.getReturnLogistics().add(thingServicesForDeliveryGoodsToBuyer));
                } else {
                    System.out.println("All 0" + " " + thing);
                }

            } else {
                baseGeneralItemsList.add(generalInfoItems);
                if(!thingCountOfDeliveries.equals(new BigDecimal(0))) {
                    generalInfoItems.setOrdersPCS(thingCountOfDeliveries);
                    generalInfoItems.setSalesLogistics(thingServicesForDeliveryGoodsToBuyer);
                    generalInfoItems.setReturnPCS(new BigDecimal(0));
                    generalInfoItems.setReturnLogistics(new BigDecimal(0));
                } else if(!thingReturnQuantity.equals(new BigDecimal(0))) {
                    generalInfoItems.setReturnPCS(thingReturnQuantity);
                    generalInfoItems.setReturnLogistics(thingServicesForDeliveryGoodsToBuyer);
                    generalInfoItems.setOrdersPCS(new BigDecimal(0));
                    generalInfoItems.setSalesLogistics(new BigDecimal(0));
                } else {
                    System.out.println("All 0" + " " + thing);
                }

            }
        }
        return true;
    }
}
