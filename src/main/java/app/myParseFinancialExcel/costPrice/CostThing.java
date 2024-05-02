package app.myParseFinancialExcel.costPrice;

import app.myParseFinancialExcel.annotations.NameField;

import java.math.BigDecimal;

public class CostThing {

    @NameField("Штрихкод EAN13")
    private String barcode;

    @NameField("Закупочная цена")
    private BigDecimal cost;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
