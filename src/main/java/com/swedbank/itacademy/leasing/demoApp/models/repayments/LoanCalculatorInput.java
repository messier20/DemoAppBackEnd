package com.swedbank.itacademy.leasing.demoApp.models.repayments;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LoanCalculatorInput {

    @NotNull
    private String customerType;
    @NotNull
    private BigDecimal assetPrice;
    @NotNull
    private BigDecimal advancePaymentPercentage;
    @NotNull
    private String advancePaymentAmount;
    @NotNull
    private BigDecimal leasePeriodInMonths;
    @NotNull
    private BigDecimal margin;
    @NotNull
    private String contractFee;
    @NotNull
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
