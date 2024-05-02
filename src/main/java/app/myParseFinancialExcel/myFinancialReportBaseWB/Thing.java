package app.myParseFinancialExcel.myFinancialReportBaseWB;

import app.myParseFinancialExcel.annotations.NameField;

import java.math.BigDecimal;
import java.util.Calendar;

public class Thing {

    public Thing(){

    }

    @NameField("№")
    private BigDecimal number;
    @NameField("Номер поставки")
    private BigDecimal deliveryNumber;
    @NameField("Предмет")
    private String item;
    @NameField("Код номенклатуры")
    private BigDecimal itemCode;
    @NameField("Бренд")
    private String brand;
    @NameField("Артикул поставщика")
    private String supplierSKU;
    @NameField("Размер")
    private String size;
    @NameField("Баркод")
    private String barcode;
    @NameField("Тип документа")
    private String documentType;
    @NameField("Обоснование для оплаты")
    private String reasonForPayment;
    @NameField("Дата заказа покупателем")
    private Calendar buyerOrderDate;
    @NameField("Дата продажи")
    private Calendar dateOfSale;
    @NameField("Кол-во")
    private BigDecimal quantitySale;
    @NameField("Цена розничная")
    private BigDecimal retailPrice;
    @NameField("Вайлдберриз реализовал Товар (Пр)")
    private BigDecimal WBSoldGoodsPr;
    @NameField("Согласованный продуктовый дисконт, %")
    private BigDecimal agreedProductDiscount;
    @NameField("Промокод %")
    private BigDecimal promoCode;
    @NameField("Итоговая согласованная скидка")
    private BigDecimal totalDiscount;
    @NameField("Цена розничная с учетом согласованной скидки")
    private BigDecimal retailPriceWithDiscount;
    @NameField("Скидка постоянного Покупателя (СПП)")
    private BigDecimal loyalCustomerDiscountSPP;
    @NameField("Размер кВВ, %")
    private BigDecimal sizeKVV;
    @NameField("Размер  кВВ без НДС, % Базовый")
    private BigDecimal sizeKVVWithoutVAT;
    @NameField("Итоговый кВВ без НДС, %")
    private BigDecimal sizeFinalKVVWithoutVAT;
    @NameField("Вознаграждение с продаж до вычета услуг поверенного, без НДС")
    private BigDecimal salesCommissionWWithoutVAT;
    @NameField("Возмещение за выдачу и возврат товаров на ПВЗ")
    private BigDecimal reimbursementForTheIssuancePP;
    @NameField("Возмещение издержек по эквайрингу")
    private BigDecimal reimbursementOfAcquiringCosts;
    @NameField("Вознаграждение Вайлдберриз (ВВ), без НДС")
    private BigDecimal WBRewardBBWithoutVAT;
    @NameField("НДС с Вознаграждения Вайлдберриз")
    private BigDecimal VATWithWBRewards;
    @NameField("К перечислению Продавцу за реализованный Товар")
    private BigDecimal transferredToSellerSoldGoods;
    @NameField("Количество доставок")
    private BigDecimal countOfDeliveries;
    @NameField("Количество возврата")
    private BigDecimal returnQuantity;
    @NameField("Услуги по доставке товара покупателю")
    private BigDecimal servicesForDeliveryGoodsToBuyer;
    @NameField("Общая сумма штрафов")
    private BigDecimal totalFine;
    @NameField("Виды логистики, штрафов и доплат")
    private String typesOfLogisticsFinesAndSurcharges;
    @NameField("Склад")
    private String stock;
    @NameField("Страна")
    private String country;

    public Thing(BigDecimal number, BigDecimal deliveryNumber, String item, BigDecimal itemCode, String brand, String supplierSKU, String size, String barcode, String documentType, String reasonForPayment, Calendar buyerOrderDate, Calendar dateOfSale, BigDecimal quantitySale, BigDecimal retailPrice, BigDecimal WBSoldGoodsPr, BigDecimal agreedProductDiscount, BigDecimal promoCode, BigDecimal totalDiscount, BigDecimal retailPriceWithDiscount, BigDecimal loyalCustomerDiscountSPP, BigDecimal sizeKVV, BigDecimal sizeKVVWithoutVAT, BigDecimal sizeFinalKVVWithoutVAT, BigDecimal salesCommissionWWithoutVAT, BigDecimal reimbursementForTheIssuancePP, BigDecimal reimbursementOfAcquiringCosts, BigDecimal WBRewardBBWithoutVAT, BigDecimal VATWithWBRewards, BigDecimal transferredToSellerSoldGoods, BigDecimal countOfDeliveries, BigDecimal returnQuantity, BigDecimal servicesForDeliveryGoodsToBuyer, BigDecimal totalFine, String typesOfLogisticsFinesAndSurcharges, String stock, String country) {
        this.number = number;
        this.deliveryNumber = deliveryNumber;
        this.item = item;
        this.itemCode = itemCode;
        this.brand = brand;
        this.supplierSKU = supplierSKU;
        this.size = size;
        this.barcode = barcode;
        this.documentType = documentType;
        this.reasonForPayment = reasonForPayment;
        this.buyerOrderDate = buyerOrderDate;
        this.dateOfSale = dateOfSale;
        this.quantitySale = quantitySale;
        this.retailPrice = retailPrice;
        this.WBSoldGoodsPr = WBSoldGoodsPr;
        this.agreedProductDiscount = agreedProductDiscount;
        this.promoCode = promoCode;
        this.totalDiscount = totalDiscount;
        this.retailPriceWithDiscount = retailPriceWithDiscount;
        this.loyalCustomerDiscountSPP = loyalCustomerDiscountSPP;
        this.sizeKVV = sizeKVV;
        this.sizeKVVWithoutVAT = sizeKVVWithoutVAT;
        this.sizeFinalKVVWithoutVAT = sizeFinalKVVWithoutVAT;
        this.salesCommissionWWithoutVAT = salesCommissionWWithoutVAT;
        this.reimbursementForTheIssuancePP = reimbursementForTheIssuancePP;
        this.reimbursementOfAcquiringCosts = reimbursementOfAcquiringCosts;
        this.WBRewardBBWithoutVAT = WBRewardBBWithoutVAT;
        this.VATWithWBRewards = VATWithWBRewards;
        this.transferredToSellerSoldGoods = transferredToSellerSoldGoods;
        this.countOfDeliveries = countOfDeliveries;
        this.returnQuantity = returnQuantity;
        this.servicesForDeliveryGoodsToBuyer = servicesForDeliveryGoodsToBuyer;
        this.totalFine = totalFine;
        this.typesOfLogisticsFinesAndSurcharges = typesOfLogisticsFinesAndSurcharges;
        this.stock = stock;
        this.country = country;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(BigDecimal deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getItemCode() {
        return itemCode;
    }

    public void setItemCode(BigDecimal itemCode) {
        this.itemCode = itemCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getReasonForPayment() {
        return reasonForPayment;
    }

    public void setReasonForPayment(String reasonForPayment) {
        this.reasonForPayment = reasonForPayment;
    }

    public Calendar getBuyerOrderDate() {
        return buyerOrderDate;
    }

    public void setBuyerOrderDate(Calendar buyerOrderDate) {
        this.buyerOrderDate = buyerOrderDate;
    }

    public Calendar getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Calendar dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public BigDecimal getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(BigDecimal quantitySale) {
        this.quantitySale = quantitySale;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getWBSoldGoodsPr() {
        return WBSoldGoodsPr;
    }

    public void setWBSoldGoodsPr(BigDecimal WBSoldGoodsPr) {
        this.WBSoldGoodsPr = WBSoldGoodsPr;
    }

    public BigDecimal getAgreedProductDiscount() {
        return agreedProductDiscount;
    }

    public void setAgreedProductDiscount(BigDecimal agreedProductDiscount) {
        this.agreedProductDiscount = agreedProductDiscount;
    }

    public BigDecimal getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(BigDecimal promoCode) {
        this.promoCode = promoCode;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getRetailPriceWithDiscount() {
        return retailPriceWithDiscount;
    }

    public void setRetailPriceWithDiscount(BigDecimal retailPriceWithDiscount) {
        this.retailPriceWithDiscount = retailPriceWithDiscount;
    }

    public BigDecimal getLoyalCustomerDiscountSPP() {
        return loyalCustomerDiscountSPP;
    }

    public void setLoyalCustomerDiscountSPP(BigDecimal loyalCustomerDiscountSPP) {
        this.loyalCustomerDiscountSPP = loyalCustomerDiscountSPP;
    }

    public BigDecimal getSizeKVV() {
        return sizeKVV;
    }

    public void setSizeKVV(BigDecimal sizeKVV) {
        this.sizeKVV = sizeKVV;
    }

    public BigDecimal getSizeKVVWithoutVAT() {
        return sizeKVVWithoutVAT;
    }

    public void setSizeKVVWithoutVAT(BigDecimal sizeKVVWithoutVAT) {
        this.sizeKVVWithoutVAT = sizeKVVWithoutVAT;
    }

    public BigDecimal getSizeFinalKVVWithoutVAT() {
        return sizeFinalKVVWithoutVAT;
    }

    public void setSizeFinalKVVWithoutVAT(BigDecimal sizeFinalKVVWithoutVAT) {
        this.sizeFinalKVVWithoutVAT = sizeFinalKVVWithoutVAT;
    }

    public BigDecimal getSalesCommissionWWithoutVAT() {
        return salesCommissionWWithoutVAT;
    }

    public void setSalesCommissionWWithoutVAT(BigDecimal salesCommissionWWithoutVAT) {
        this.salesCommissionWWithoutVAT = salesCommissionWWithoutVAT;
    }

    public BigDecimal getReimbursementForTheIssuancePP() {
        return reimbursementForTheIssuancePP;
    }

    public void setReimbursementForTheIssuancePP(BigDecimal reimbursementForTheIssuancePP) {
        this.reimbursementForTheIssuancePP = reimbursementForTheIssuancePP;
    }

    public BigDecimal getReimbursementOfAcquiringCosts() {
        return reimbursementOfAcquiringCosts;
    }

    public void setReimbursementOfAcquiringCosts(BigDecimal reimbursementOfAcquiringCosts) {
        this.reimbursementOfAcquiringCosts = reimbursementOfAcquiringCosts;
    }

    public BigDecimal getWBRewardBBWithoutVAT() {
        return WBRewardBBWithoutVAT;
    }

    public void setWBRewardBBWithoutVAT(BigDecimal WBRewardBBWithoutVAT) {
        this.WBRewardBBWithoutVAT = WBRewardBBWithoutVAT;
    }

    public BigDecimal getVATWithWBRewards() {
        return VATWithWBRewards;
    }

    public void setVATWithWBRewards(BigDecimal VATWithWBRewards) {
        this.VATWithWBRewards = VATWithWBRewards;
    }

    public BigDecimal getTransferredToSellerSoldGoods() {
        return transferredToSellerSoldGoods;
    }

    public void setTransferredToSellerSoldGoods(BigDecimal transferredToSellerSoldGoods) {
        this.transferredToSellerSoldGoods = transferredToSellerSoldGoods;
    }

    public BigDecimal getCountOfDeliveries() {
        return countOfDeliveries;
    }

    public void setCountOfDeliveries(BigDecimal countOfDeliveries) {
        this.countOfDeliveries = countOfDeliveries;
    }

    public BigDecimal getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(BigDecimal returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public BigDecimal getServicesForDeliveryGoodsToBuyer() {
        return servicesForDeliveryGoodsToBuyer;
    }

    public void setServicesForDeliveryGoodsToBuyer(BigDecimal servicesForDeliveryGoodsToBuyer) {
        this.servicesForDeliveryGoodsToBuyer = servicesForDeliveryGoodsToBuyer;
    }

    public BigDecimal getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(BigDecimal totalFine) {
        this.totalFine = totalFine;
    }

    public String getTypesOfLogisticsFinesAndSurcharges() {
        return typesOfLogisticsFinesAndSurcharges;
    }

    public void setTypesOfLogisticsFinesAndSurcharges(String typesOfLogisticsFinesAndSurcharges) {
        this.typesOfLogisticsFinesAndSurcharges = typesOfLogisticsFinesAndSurcharges;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
