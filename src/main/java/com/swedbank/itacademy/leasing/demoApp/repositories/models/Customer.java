package com.swedbank.itacademy.leasing.demoApp.repositories.models;

import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.customer.CustomerType;
import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Customer<T> implements Comparable<Customer<T>> {
    @Id
    private ObjectId id;
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
    private String contractFee;
    @NotNull
    private BigDecimal margin;
    @NotNull
    private Integer leasePeriodInMonths;
    @NotNull
    private Integer paymentDate;

    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;

    @NotNull
    private ApplicationStatus status;

    @NotNull
    private String idHex;


    public Customer() {}

    public Customer(Leasing<T> customerLeasing) {
        if (customerLeasing.getCustomer() instanceof Private) {
            Private p = (Private) customerLeasing.getCustomer();
            this.email = p.getEmail();
            this.phoneNumber = p.getPhoneNumber();
            this.address = p.getAddress();
        }
        else if (customerLeasing.getCustomer() instanceof Business) {
            Business b = (Business) customerLeasing.getCustomer();
            this.email = b.getEmail();
            this.phoneNumber = b.getPhoneNumber();
            this.address = b.getAddress();
        }
        this.id = new ObjectId();
        this.customerType = customerLeasing.getLeasing().getCustomerType();
        this.assetType = customerLeasing.getLeasing().getAssetType();
        this.carBrand = customerLeasing.getLeasing().getCarBrand();
        this.carModel = customerLeasing.getLeasing().getCarModel();
        this.manufacturedDate = customerLeasing.getLeasing().getManufacturedDate();
        this.enginePower = customerLeasing.getLeasing().getEnginePower();
        this.assetPrice = customerLeasing.getLeasing().getAssetPrice();
        this.advancePaymentPercentage = customerLeasing.getLeasing().getAdvancePaymentPercentage();
        this.advancePaymentAmount = customerLeasing.getLeasing().getAdvancePaymentAmount();
        this.contractFee = customerLeasing.getLeasing().getContractFee();
        this.margin = customerLeasing.getLeasing().getMargin();
        this.leasePeriodInMonths = customerLeasing.getLeasing().getLeasePeriodInMonths();
        this.paymentDate = customerLeasing.getLeasing().getPaymentDate();
        this.status = ApplicationStatus.PENDING;
        this.idHex = id.toString();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getContractFee() {
        return contractFee;
    }

    public void setContractFee(String contractFee) {
        this.contractFee = contractFee;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public Integer getLeasePeriodInMonths() {
        return leasePeriodInMonths;
    }

    public void setLeasePeriodInMonths(Integer leasePeriodInMonths) {
        this.leasePeriodInMonths = leasePeriodInMonths;
    }

    public Integer getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Integer paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getIdHex() {
        return idHex;
    }

    public void setIdHex(String idHex) {
        this.idHex = idHex;
    }

    @Override
    public int compareTo(Customer<T> o) {
        return this.getId().getTimestamp() - o.getId().getTimestamp();
    }
}
