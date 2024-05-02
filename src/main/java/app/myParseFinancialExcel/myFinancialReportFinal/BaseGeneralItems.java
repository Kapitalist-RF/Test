package app.myParseFinancialExcel.myFinancialReportFinal;

import app.myParseFinancialExcel.annotations.NameField;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseGeneralItems {

    @NameField("Стоимость платной приемки")
    private BigDecimal acceptanceFeeBD = new BigDecimal(0);
    @NameField("Прочие удержания")
    private BigDecimal otherDeductionsBD = new BigDecimal(0);
    @NameField("Стоимость хранения")
    private BigDecimal storageCostBD = new BigDecimal(0);
    @NameField("Доплаты")
    private BigDecimal surchargesBD = new BigDecimal(0);

    @NameField("Итого к оплате")
    private BigDecimal transferredSellerAfterDeductionAllExpensesAll = new BigDecimal(0);

    @NameField("ЧП после вычета себестоимости и налога")
    private BigDecimal netProfitAll = new BigDecimal(0);

    private String nameFinalFileExcelStr;

    private List<GeneralInfoItems> baseGeneralItems = new ArrayList<>();

    public List<GeneralInfoItems> getBaseGeneralItems() {
        return baseGeneralItems;
    }

    public BaseGeneralItems () {

    }

    public BaseGeneralItems(BigDecimal acceptanceFeeBD, BigDecimal otherDeductionsBD, BigDecimal storageCostBD, BigDecimal surchargesBD, String nameFinalFileExcelStr) {
        this.acceptanceFeeBD = acceptanceFeeBD;
        this.otherDeductionsBD = otherDeductionsBD;
        this.storageCostBD = storageCostBD;
        this.surchargesBD = surchargesBD;
        if(nameFinalFileExcelStr.isEmpty()) {
            this.nameFinalFileExcelStr = "Temp";
        } else {
            this.nameFinalFileExcelStr = nameFinalFileExcelStr;
        }
    }

    public void setBaseGeneralItems(List<GeneralInfoItems> baseGeneralItems) {
        this.baseGeneralItems = baseGeneralItems;
    }

    public BigDecimal getAcceptanceFeeBD() {
        return acceptanceFeeBD;
    }

    public void setAcceptanceFeeBD(BigDecimal acceptanceFeeBD) {
        this.acceptanceFeeBD = acceptanceFeeBD;
    }

    public BigDecimal getOtherDeductionsBD() {
        return otherDeductionsBD;
    }

    public void setOtherDeductionsBD(BigDecimal otherDeductionsBD) {
        this.otherDeductionsBD = otherDeductionsBD;
    }

    public BigDecimal getStorageCostBD() {
        return storageCostBD;
    }

    public void setStorageCostBD(BigDecimal storageCostBD) {
        this.storageCostBD = storageCostBD;
    }

    public BigDecimal getSurchargesBD() {
        return surchargesBD;
    }

    public void setSurchargesBD(BigDecimal surchargesBD) {
        this.surchargesBD = surchargesBD;
    }

    public String getNameFinalFileExcelStr() {
        return nameFinalFileExcelStr;
    }

    public void setNameFinalFileExcelStr(String nameFinalFileExcelStr) {
        this.nameFinalFileExcelStr = nameFinalFileExcelStr;
    }

    public BigDecimal getTransferredSellerAfterDeductionAllExpensesAll() {
        return transferredSellerAfterDeductionAllExpensesAll;
    }

    public void setTransferredSellerAfterDeductionAllExpensesAll(BigDecimal transferredSellerAfterDeductionAllExpensesAll) {
        this.transferredSellerAfterDeductionAllExpensesAll = transferredSellerAfterDeductionAllExpensesAll;
    }

    public BigDecimal getNetProfitAll() {
        return netProfitAll;
    }

    public void setNetProfitAll(BigDecimal netProfitAll) {
        this.netProfitAll = netProfitAll;
    }

    public void transferredSellerAfterDeductionAllExpensesAllSum () {
        for (GeneralInfoItems generalItem : baseGeneralItems) {
            this.transferredSellerAfterDeductionAllExpensesAll = this.getTransferredSellerAfterDeductionAllExpensesAll()
                    .add(generalItem.getTransferredSellerAfterDeductionAllExpenses());
        }
        this.transferredSellerAfterDeductionAllExpensesAll = this.transferredSellerAfterDeductionAllExpensesAll
                .subtract(surchargesBD)
                .subtract(storageCostBD)
                .subtract(acceptanceFeeBD)
                .subtract(otherDeductionsBD);
    }

    public void netProfitAllSum () {
        for (GeneralInfoItems generalItem : baseGeneralItems) {
            this.netProfitAll = this.getNetProfitAll()
                    .add(generalItem.getNetProfit());
        }
    }
}
