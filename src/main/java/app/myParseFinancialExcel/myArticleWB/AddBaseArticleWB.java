package app.myParseFinancialExcel.myArticleWB;

import app.myParseFinancialExcel.annotations.DocumentType;
import app.myParseFinancialExcel.annotations.ReasonForPayment;
import app.myParseFinancialExcel.myFinancialReportBaseWB.BaseThings;
import app.myParseFinancialExcel.myFinancialReportBaseWB.Thing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AddBaseArticleWB {

    public BaseArticleWB addBaseArticleWB(BaseThings baseThings) {
        BaseArticleWB baseArticleWB = new BaseArticleWB();
        List<List<Thing>> listListThings = new ArrayList<>();
        Field[] fieldsListThings = baseArticleWB.getClass().getDeclaredFields();
        for(Thing thing : baseThings.getThingsList()) {
            String DT = thing.getDocumentType();
            String RFP = thing.getReasonForPayment();
            for (Field field : fieldsListThings) {
                field.setAccessible(true);
                try {
                    if(field.get(baseArticleWB) == null) {
                        field.set(baseArticleWB, new ArrayList<Thing>());
                    }
                    String fieldDT = field.getAnnotation(DocumentType.class).value();
                    String fieldRFP = field.getAnnotation(ReasonForPayment.class).value();
                    if(DT.equals(fieldDT) && RFP.equals(fieldRFP)) {
                        ((List<Thing>) field.get(baseArticleWB)).add(thing);
                        break;
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }


            }
        }
        return baseArticleWB;
    }

}
