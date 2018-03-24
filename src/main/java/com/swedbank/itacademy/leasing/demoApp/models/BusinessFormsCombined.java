package com.swedbank.itacademy.leasing.demoApp.models;

import javax.validation.constraints.NotNull;

public class BusinessFormsCombined {

    @NotNull
    private CustomerLeasing customerLeasingForm;
    @NotNull
    private BusinessCustomerForm businessCustomerForm;

    public CustomerLeasing getCustomerLeasingForm() {
        return customerLeasingForm;
    }

    public void setCustomerLeasingForm(CustomerLeasing customerLeasingForm) {
        this.customerLeasingForm = customerLeasingForm;
    }

    public BusinessCustomerForm getBusinessCustomerForm() {
        return businessCustomerForm;
    }

    public void setBusinessCustomerForm(BusinessCustomerForm businessCustomerForm) {
        this.businessCustomerForm = businessCustomerForm;
    }
}
