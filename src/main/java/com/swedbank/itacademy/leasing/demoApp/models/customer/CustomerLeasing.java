package com.swedbank.itacademy.leasing.demoApp.models.customer;

import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerLeasing {
    @NotNull
    private CustomerType customerType;
    @NotNull
    private String assetType;
    @NotNull
    private String carBrand;
    @NotNull
    private String carModel;
    @NotNull
    private String manufacturedDate;
    @NotNull
    private BigDecimal enginePower;
    @NotNull
    private BigDecimal assetPrice;
    @NotNull
    private BigDecimal advancePaymentPercentage;
    @NotNull
    private String advancePaymentAmount;
    @NotNull
    private Integer leasePeriodInMonths;
    @NotNull
    private BigDecimal margin;
    @NotNull
    private String contractFee;
    @NotNull
    private Integer paymentDate;

    public CustomerLeasing() {}

    public CustomerLeasing(Private customer) {
        this.customerType = customer.getCustomerType();
        this.assetType = customer.getAssetType();
        this.carBrand = customer.getCarBrand();
        this.carModel = customer.getCarModel();
        this.manufacturedDate = customer.getManufacturedDate();
        this.enginePower = customer.getEnginePower();
        this.assetPrice = customer.getAssetPrice();
        this.advancePaymentPercentage = customer.getAdvancePaymentPercentage();
        this.advancePaymentAmount = customer.getAdvancePaymentAmount();
        this.leasePeriodInMonths = customer.getLeasePeriodInMonths();
        this.margin = customer.getMargin();
        this.contractFee = customer.getContractFee();
        this.paymentDate = customer.getPaymentDate();
    }

    public CustomerLeasing(Business customer) {
        this.customerType = customer.getCustomerType();
        this.assetType = customer.getAssetType();
        this.carBrand = customer.getCarBrand();
        this.carModel = customer.getCarModel();
        this.manufacturedDate = customer.getManufacturedDate();
        this.enginePower = customer.getEnginePower();
        this.assetPrice = customer.getAssetPrice();
        this.advancePaymentPercentage = customer.getAdvancePaymentPercentage();
        this.advancePaymentAmount = customer.getAdvancePaymentAmount();
        this.leasePeriodInMonths = customer.getLeasePeriodInMonths();
        this.margin = customer.getMargin();
        this.contractFee = customer.getContractFee();
        this.paymentDate = customer.getPaymentDate();
    }

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

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
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

    public String getContractFee() {
        return contractFee;
    }

    public void setContractFee(String contractFee) {
        this.contractFee = contractFee;
    }

    public Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate) {
        this.paymentDate = paymentDate;
    }
}
