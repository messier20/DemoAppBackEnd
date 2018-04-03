package com.swedbank.itacademy.leasing.demoApp.repositories.models;

import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;

import javax.validation.constraints.NotNull;

public class Business extends Customer {
    @NotNull
    private String companyName;
    @NotNull
    private String companyCode;

    public Business() {}

    public Business(Leasing<BusinessCustomer> customerLeasing) {
        super(customerLeasing);
        this.companyName = customerLeasing.getCustomer().getName();
        this.companyCode = customerLeasing.getCustomer().getCode();
        this.setEmail(customerLeasing.getCustomer().getEmail());
        this.setPhoneNumber(customerLeasing.getCustomer().getPhoneNumber());
        this.setAddress(customerLeasing.getCustomer().getAddress());
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
