package app.myParseFinancialExcel.myArticleWB;


import app.myParseFinancialExcel.annotations.ReasonForPayment;
import app.myParseFinancialExcel.myFinancialReportBaseWB.Thing;
import app.myParseFinancialExcel.annotations.DocumentType;

import java.util.List;

public class BaseArticleWB {
    @DocumentType("Продажа")
    @ReasonForPayment("Авансовая оплата за товар без движения")
    private List<Thing> saleAndAdvancePaymentForGoodsWithoutMovement;
    @DocumentType("Продажа")
    @ReasonForPayment("Возмещение издержек по перевозке")
    private List<Thing> saleAndReimbursementOfShippingCosts;
    @DocumentType("")
    @ReasonForPayment("Логистика")
    private List<Thing> saleAndLogistics;
    @DocumentType("Продажа")
    @ReasonForPayment("Продажа")
    private List<Thing> saleAndSale;
    @DocumentType("Продажа")
    @ReasonForPayment("Сторно возвратов")
    private List<Thing> saleAndCancellationOfReturns;
    @DocumentType("Продажа")
    @ReasonForPayment("Частичная компенсация брака")
    private List<Thing> saleAndPartialMarriageCompensation;
    @DocumentType("")
    @ReasonForPayment("Штрафы")
    private List<Thing> saleAndFines;
    @DocumentType("Продажа")
    @ReasonForPayment("Корректная продажа")
    private List<Thing> saleAndCorrectSale;

    @DocumentType("Возврат")
    @ReasonForPayment("Частичная компенсация брака")
    private List<Thing> returnAndPartialMarriageCompensation;
    @DocumentType("Возврат")
    @ReasonForPayment("Авансовая оплата за товар без движения")
    private List<Thing> returnAndAdvancePaymentForGoodsWithoutMovement;
    @DocumentType("Возврат")
    @ReasonForPayment("Возврат")
    private List<Thing> returnAndReturn;
    @DocumentType("Возврат")
    @ReasonForPayment("Сторно продаж")
    private List<Thing> returnAndReversalOfSales;

    public List<Thing> getSaleAndAdvancePaymentForGoodsWithoutMovement() {
        return saleAndAdvancePaymentForGoodsWithoutMovement;
    }

    public void setSaleAndAdvancePaymentForGoodsWithoutMovement(List<Thing> saleAndAdvancePaymentForGoodsWithoutMovement) {
        this.saleAndAdvancePaymentForGoodsWithoutMovement = saleAndAdvancePaymentForGoodsWithoutMovement;
    }

    public List<Thing> getSaleAndReimbursementOfShippingCosts() {
        return saleAndReimbursementOfShippingCosts;
    }

    public void setSaleAndReimbursementOfShippingCosts(List<Thing> saleAndReimbursementOfShippingCosts) {
        this.saleAndReimbursementOfShippingCosts = saleAndReimbursementOfShippingCosts;
    }

    public List<Thing> getSaleAndLogistics() {
        return saleAndLogistics;
    }

    public void setSaleAndLogistics(List<Thing> saleAndLogistics) {
        this.saleAndLogistics = saleAndLogistics;
    }

    public List<Thing> getSaleAndSale() {
        return saleAndSale;
    }

    public void setSaleAndSale(List<Thing> saleAndSale) {
        this.saleAndSale = saleAndSale;
    }

    public List<Thing> getSaleAndCancellationOfReturns() {
        return saleAndCancellationOfReturns;
    }

    public void setSaleAndCancellationOfReturns(List<Thing> saleAndCancellationOfReturns) {
        this.saleAndCancellationOfReturns = saleAndCancellationOfReturns;
    }

    public List<Thing> getSaleAndPartialMarriageCompensation() {
        return saleAndPartialMarriageCompensation;
    }

    public void setSaleAndPartialMarriageCompensation(List<Thing> saleAndPartialMarriageCompensation) {
        this.saleAndPartialMarriageCompensation = saleAndPartialMarriageCompensation;
    }

    public List<Thing> getSaleAndFines() {
        return saleAndFines;
    }

    public void setSaleAndFines(List<Thing> saleAndFines) {
        this.saleAndFines = saleAndFines;
    }

    public List<Thing> getSaleAndCorrectSale() {
        return saleAndCorrectSale;
    }

    public void setSaleAndCorrectSale(List<Thing> saleAndCorrectSale) {
        this.saleAndCorrectSale = saleAndCorrectSale;
    }

    public List<Thing> getReturnAndPartialMarriageCompensation() {
        return returnAndPartialMarriageCompensation;
    }

    public void setReturnAndPartialMarriageCompensation(List<Thing> returnAndPartialMarriageCompensation) {
        this.returnAndPartialMarriageCompensation = returnAndPartialMarriageCompensation;
    }

    public List<Thing> getReturnAndAdvancePaymentForGoodsWithoutMovement() {
        return returnAndAdvancePaymentForGoodsWithoutMovement;
    }

    public void setReturnAndAdvancePaymentForGoodsWithoutMovement(List<Thing> returnAndAdvancePaymentForGoodsWithoutMovement) {
        this.returnAndAdvancePaymentForGoodsWithoutMovement = returnAndAdvancePaymentForGoodsWithoutMovement;
    }

    public List<Thing> getReturnAndReturn() {
        return returnAndReturn;
    }

    public void setReturnAndReturn(List<Thing> returnAndReturn) {
        this.returnAndReturn = returnAndReturn;
    }

    public List<Thing> getReturnAndReversalOfSales() {
        return returnAndReversalOfSales;
    }

    public void setReturnAndReversalOfSales(List<Thing> returnAndReversalOfSales) {
        this.returnAndReversalOfSales = returnAndReversalOfSales;
    }
}
