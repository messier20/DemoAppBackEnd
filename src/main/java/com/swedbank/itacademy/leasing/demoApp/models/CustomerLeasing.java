package com.swedbank.itacademy.leasing.demoApp.models;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerLeasing {
    private CustomerType customerType;
    private String assetType;
    private String carBrand;
    private String carModel;
    private Date manufacturedDate;
    private BigDecimal enginePower;
    private BigDecimal assetPrice;
    private Integer advancePaymentPercentage;
    private BigDecimal advancePaymentAmount;
    private Integer leasePeriodInMonths;
    private BigDecimal margin;
    private BigDecimal contractFee;
    private Integer paymentDate;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public BigDecimal getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(BigDecimal enginePower) {
        this.enginePower = enginePower;
    }

    public BigDecimal getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(BigDecimal assetPrice) {
        this.assetPrice = assetPrice;
    }

    public Integer getAdvancePaymentPercentage() {
        return advancePaymentPercentage;
    }

    public void setAdvancePaymentPercentage(Integer advancePaymentPercentage) {
        this.advancePaymentPercentage = advancePaymentPercentage;
    }

    public BigDecimal getAdvancePaymentAmount() {
        return advancePaymentAmount;
    }

    public void setAdvancePaymentAmount(BigDecimal advancePaymentAmount) {
        this.advancePaymentAmount = advancePaymentAmount;
    }

    public Integer getLeasePeriodInMonths() {
        return leasePeriodInMonths;
    }

    public void setLeasePeriodInMonths(Integer leasePeriodInMonths) {
        this.leasePeriodInMonths = leasePeriodInMonths;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public BigDecimal getContractFee() {
        return contractFee;
    }

    public void setContractFee(BigDecimal contractFee) {
        this.contractFee = contractFee;
    }

    public Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate) {
        this.paymentDate = paymentDate;
    }
}
