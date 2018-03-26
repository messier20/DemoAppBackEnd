package com.swedbank.itacademy.leasing.demoApp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class BusinessFormsCombined {
    @Id
    private ObjectId id;
    @NotNull
    private CustomerLeasing customerLeasingForm;
    @NotNull
    private BusinessCustomerForm businessCustomerForm;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

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
