package com.swedbank.itacademy.leasing.demoApp.models;

import javax.validation.constraints.NotNull;

public class PrivateFormsCombined {

    @NotNull
    private CustomerLeasing customerLeasingForm;
    @NotNull
    private PrivateCustomerForm privateCustomerForm;

    public CustomerLeasing getCustomerLeasingForm() {
        return customerLeasingForm;
    }

    public void setCustomerLeasingForm(CustomerLeasing customerLeasingForm) {
        this.customerLeasingForm = customerLeasingForm;
    }

    public PrivateCustomerForm getPrivateCustomerForm() {
        return privateCustomerForm;
    }

    public void setPrivateCustomerForm(PrivateCustomerForm privateCustomerForm) {
        this.privateCustomerForm = privateCustomerForm;
    }
}
