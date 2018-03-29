package com.swedbank.itacademy.leasing.demoApp.models.repayments;

public class Repayment {
    private String repaymentDate;
    private String remainingAmountToRepay;
    private String assetValuePaymentAmount;
    private String interestPaymentAmount;
    private String contractFee;
    private String totalPaymentAmount;

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getRemainingAmountToRepay() {
        return remainingAmountToRepay;
    }

    public void setRemainingAmountToRepay(String remainingAmountToRepay) {
        this.remainingAmountToRepay = remainingAmountToRepay;
    }

    public String getAssetValuePaymentAmount() {
        return assetValuePaymentAmount;
    }

    public void setAssetValuePaymentAmount(String assetValuePaymentAmount) {
        this.assetValuePaymentAmount = assetValuePaymentAmount;
    }

    public String getInterestPaymentAmount() {
        return interestPaymentAmount;
    }

    public void setInterestPaymentAmount(String interestPaymentAmount) {
        this.interestPaymentAmount = interestPaymentAmount;
    }

    public String getContractFee() {
        return contractFee;
    }

    public void setContractFee(String contractFee) {
        this.contractFee = contractFee;
    }

    public String getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(String totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }
}
