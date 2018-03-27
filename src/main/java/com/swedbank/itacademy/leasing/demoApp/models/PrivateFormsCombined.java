package com.swedbank.itacademy.leasing.demoApp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class PrivateFormsCombined {
    @Id
    private ObjectId id;
    @NotNull
    private ApplicationStatus status;
    @NotNull
    private CustomerLeasing customerLeasingForm;
    @NotNull
    private PrivateCustomerForm privateCustomerForm;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

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
