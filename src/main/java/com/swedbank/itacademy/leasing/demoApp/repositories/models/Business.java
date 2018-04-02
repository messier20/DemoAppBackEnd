package com.swedbank.itacademy.leasing.demoApp.repositories.models;

import com.swedbank.itacademy.leasing.demoApp.models.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomer;

import javax.validation.constraints.NotNull;

public class Business extends Customer {
    @NotNull
    private String companyName;
    @NotNull
    private String companyCode;

    public Business(Leasing<BusinessCustomer> customer) {}

    public Business(@NotNull String companyName, @NotNull String companyCode) {
        this.companyName = companyName;
        this.companyCode = companyCode;
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
