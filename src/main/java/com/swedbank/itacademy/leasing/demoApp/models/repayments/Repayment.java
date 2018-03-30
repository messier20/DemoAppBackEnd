package com.swedbank.itacademy.leasing.demoApp.models.repayments;

import java.math.BigDecimal;

public class Repayment {
    private String repaymentDate;
    private BigDecimal remainingAmountToRepay;
    private BigDecimal assetValuePaymentAmount;
    private BigDecimal interestPaymentAmount;
    private BigDecimal contractFee;
    private BigDecimal totalPaymentAmount;

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getRemainingAmountToRepay() {
        return remainingAmountToRepay;
    }

    public void setRemainingAmountToRepay(BigDecimal remainingAmountToRepay) {
        this.remainingAmountToRepay = remainingAmountToRepay;
    }

    public BigDecimal getAssetValuePaymentAmount() {
        return assetValuePaymentAmount;
    }

    public void setAssetValuePaymentAmount(BigDecimal assetValuePaymentAmount) {
        this.assetValuePaymentAmount = assetValuePaymentAmount;
    }

    public BigDecimal getInterestPaymentAmount() {
        return interestPaymentAmount;
    }

    public void setInterestPaymentAmount(BigDecimal interestPaymentAmount) {
        this.interestPaymentAmount = interestPaymentAmount;
    }

    public BigDecimal getContractFee() {
        return contractFee;
    }

    public void setContractFee(BigDecimal contractFee) {
        this.contractFee = contractFee;
    }

    public BigDecimal getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }
}
