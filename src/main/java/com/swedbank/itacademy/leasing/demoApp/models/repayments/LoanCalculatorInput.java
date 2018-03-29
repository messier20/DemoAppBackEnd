package com.swedbank.itacademy.leasing.demoApp.models.repayments;

import java.math.BigDecimal;

public class LoanCalculatorInput {
    private String customerType;
    private BigDecimal assetPrice;
    private BigDecimal advancePaymentPercentage;
    private String advancePaymentAmount;
    private BigDecimal leasePeriodInMonths;
    private BigDecimal margin;
    private String contractFee;
    private BigDecimal paymentDate;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public BigDecimal getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(BigDecimal assetPrice) {
        this.assetPrice = assetPrice;
    }

    public BigDecimal getAdvancePaymentPercentage() {
        return advancePaymentPercentage;
    }

    public void setAdvancePaymentPercentage(BigDecimal advancePaymentPercentage) {
        this.advancePaymentPercentage = advancePaymentPercentage;
    }

    public String getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(String advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public BigDecimal getLeasePeriodInMonths() {
        return leasePeriodInMonths;
    }

    public void setLeasePeriodInMonths(BigDecimal leasePeriodInMonths) {
        this.leasePeriodInMonths = leasePeriodInMonths;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public String getContractFee() {
        return contractFee;
    }

    public void setContractFee(String contractFee) {
        this.contractFee = contractFee;
    }

    public BigDecimal getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(BigDecimal paymentDate) {
        this.paymentDate = paymentDate;
    }
}
