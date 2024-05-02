package app.myParseFinancialExcel.myFinancialReportFinal;

import app.myParseFinancialExcel.myFinancialReportBaseWB.Thing;
import app.myParseFinancialExcel.annotations.NameField;

import java.math.BigDecimal;

public class GeneralInfoItems {

    @NameField("Бренд")
    private String brand = new String();

    @NameField("Предмет")
    private String item = new String();

    @NameField("Артикул поставщика")
    private String supplierSKU = new String();

    @NameField("Размер")
    private String size = new String();

    @NameField("Наименование (Предмет, артикул, размер)")
    private String allNameSupplierSKU = new String();

    @NameField("Баркод")
    private String barcode = new String();
    @NameField("Заказы, шт.")
    private BigDecimal ordersPCS = new BigDecimal(0);

    @NameField("WB потерял товар, шт.")
    private BigDecimal WBLostGoods = new BigDecimal(0);

    @NameField("WB нашел товар, шт.")
    private BigDecimal WBFoundGoods = new BigDecimal(0);

    @NameField("Возврат, шт.")
    private BigDecimal returnPCS = new BigDecimal(0);

    @NameField("Продажи, шт.")
    private BigDecimal salesPCS = new BigDecimal(0);

    @NameField("Логистика продаж")
    private BigDecimal salesLogistics = new BigDecimal(0);

    @NameField("Логистика возвратов")
    private BigDecimal returnLogistics = new BigDecimal(0);

    @NameField("Общая сумма за логистику")
    private BigDecimal totalAmountForLogistics = new BigDecimal(0);

    @NameField("К перечислению Продавцу за реализованный Товар")
    private BigDecimal transferredSeller = new BigDecimal(0);

    @NameField("К перечислению продавцу после вычета всех расходов(логистика, штрафы)")
    private BigDecimal transferredSellerAfterDeductionAllExpenses = new BigDecimal(0);

    @NameField("Себестоимость")
    private BigDecimal costPrice = new BigDecimal(0);

    @NameField("Себестоимость проданного товара")
    private BigDecimal costOfGoodsSold = new BigDecimal(0);

    @NameField("ЧП после вычета себестоимости и налога")
    private BigDecimal netProfit = new BigDecimal(0);

    @NameField("Остаток на WB")
    private BigDecimal balanceThingsOnWB = new BigDecimal(0);

    @NameField("Вайлдберриз реализовал Товар (Пр)")
    private BigDecimal WBSoldGoodsPr = new BigDecimal(0);

    @NameField("Налог")
    private BigDecimal tax = new BigDecimal(0);

    @NameField("Брак компенсация, шт.")
    private BigDecimal marriageCompensationPCS = new BigDecimal(0);

    @NameField("Сумма за брак (компенсация)")
    private BigDecimal amountForMarriage = new BigDecimal(0);

    @NameField("Общая сумма штрафов")
    private BigDecimal totalFine = new BigDecimal(0);

    @NameField("Возвраты после покупки")
    private BigDecimal returnItemAfterSale = new BigDecimal(0);


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())){
            GeneralInfoItems o = (GeneralInfoItems) obj;
            if(o.getBarcode().equals(this.getBarcode())){
                return true;
            }
        }
        return false;
    }

    public GeneralInfoItems thingToGeneralInfoItems(Thing thing) {
        GeneralInfoItems generalInfoItems = new GeneralInfoItems();
        String brand = thing.getBrand();
        String item = thing.getItem();
        String size = thing.getSize();
        String supplierSKU = thing.getSupplierSKU();
        String barcode = thing.getBarcode();
        String allNameSupplierSKU = item + " " + supplierSKU + " " + size;
        generalInfoItems.setBrand(brand);
        generalInfoItems.setItem(item);
        generalInfoItems.setSize(size);
        generalInfoItems.setBarcode(barcode);
        generalInfoItems.setSupplierSKU(supplierSKU);
        generalInfoItems.setAllNameSupplierSKU(allNameSupplierSKU);
        return generalInfoItems;
    }

    public BigDecimal getReturnItemAfterSale() {
        return returnItemAfterSale;
    }

    public void setReturnItemAfterSale(BigDecimal returnItemAfterSale) {
        this.returnItemAfterSale = returnItemAfterSale;
    }

    public BigDecimal getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(BigDecimal totalFine) {
        this.totalFine = totalFine;
    }

    public BigDecimal getWBLostGoods() {
        return WBLostGoods;
    }

    public void setWBLostGoods(BigDecimal WBLostGoods) {
        this.WBLostGoods = WBLostGoods;
    }

    public BigDecimal getWBFoundGoods() {
        return WBFoundGoods;
    }

    public void setWBFoundGoods(BigDecimal WBFoundGoods) {
        this.WBFoundGoods = WBFoundGoods;
    }

    public String getAllNameSupplierSKU() {
        return allNameSupplierSKU;
    }

    public void setAllNameSupplierSKU(String allNameSupplierSKU) {
        this.allNameSupplierSKU = allNameSupplierSKU;
    }

    public BigDecimal getMarriageCompensationPCS() {
        return marriageCompensationPCS;
    }

    public void setMarriageCompensationPCS(BigDecimal marriageCompensationPCS) {
        this.marriageCompensationPCS = marriageCompensationPCS;
    }

    public BigDecimal getAmountForMarriage() {
        return amountForMarriage;
    }

    public void setAmountForMarriage(BigDecimal amountForMarriage) {
        this.amountForMarriage = amountForMarriage;
    }

    public BigDecimal getTransferredSeller() {
        return transferredSeller;
    }

    public void setTransferredSeller(BigDecimal transferredSeller) {
        this.transferredSeller = transferredSeller;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSupplierSKU() {
        return supplierSKU;
    }

    public void setSupplierSKU(String supplierSKU) {
        this.supplierSKU = supplierSKU;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getOrdersPCS() {
        return ordersPCS;
    }

    public void setOrdersPCS(BigDecimal ordersPCS) {
        this.ordersPCS = ordersPCS;
    }

    public BigDecimal getReturnPCS() {
        return returnPCS;
    }

    public void setReturnPCS(BigDecimal returnPCS) {
        this.returnPCS = returnPCS;
    }

    public BigDecimal getSalesPCS() {
        return salesPCS;
    }

    public void setSalesPCS(BigDecimal salesPCS) {
        this.salesPCS = salesPCS;
    }

    public BigDecimal getSalesLogistics() {
        return salesLogistics;
    }

    public void setSalesLogistics(BigDecimal salesLogistics) {
        this.salesLogistics = salesLogistics;
    }

    public BigDecimal getReturnLogistics() {
        return returnLogistics;
    }

    public void setReturnLogistics(BigDecimal returnLogistics) {
        this.returnLogistics = returnLogistics;
    }

    public BigDecimal getTotalAmountForLogistics() {
        return totalAmountForLogistics;
    }

    public void setTotalAmountForLogistics(BigDecimal totalAmountForLogistics) {
        this.totalAmountForLogistics = totalAmountForLogistics;
    }

    public BigDecimal getTransferredSellerAfterDeductionAllExpenses() {
        return transferredSellerAfterDeductionAllExpenses;
    }

    public void setTransferredSellerAfterDeductionAllExpenses(BigDecimal transferredSellerAfterDeductionAllExpenses) {
        this.transferredSellerAfterDeductionAllExpenses = transferredSellerAfterDeductionAllExpenses;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getCostOfGoodsSold() {
        return costOfGoodsSold;
    }

    public void setCostOfGoodsSold(BigDecimal costOfGoodsSold) {
        this.costOfGoodsSold = costOfGoodsSold;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public BigDecimal getBalanceThingsOnWB() {
        return balanceThingsOnWB;
    }

    public void setBalanceThingsOnWB(BigDecimal balanceThingsOnWB) {
        this.balanceThingsOnWB = balanceThingsOnWB;
    }

    public BigDecimal getWBSoldGoodsPr() {
        return WBSoldGoodsPr;
    }

    public void setWBSoldGoodsPr(BigDecimal WBSoldGoodsPr) {
        this.WBSoldGoodsPr = WBSoldGoodsPr;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
