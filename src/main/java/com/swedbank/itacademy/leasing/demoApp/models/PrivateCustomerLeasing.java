package com.swedbank.itacademy.leasing.demoApp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class PrivateCustomerLeasing implements Comparable<PrivateCustomerLeasing> {
    @Id
    private ObjectId id;
    @NotNull
    private ApplicationStatus status;
    @NotNull
    private CustomerLeasing customerLeasing;
    @NotNull
    private PrivateCustomer privateCustomer;

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

    public CustomerLeasing getCustomerLeasing() {
        return customerLeasing;
    }

    public void setCustomerLeasing(CustomerLeasing customerLeasing) {
        this.customerLeasing = customerLeasing;
    }

    public PrivateCustomer getPrivateCustomer() {
        return privateCustomer;
    }

    public void setPrivateCustomer(PrivateCustomer privateCustomer) {
        this.privateCustomer = privateCustomer;
    }

    @Override
    public int compareTo(PrivateCustomerLeasing o) {
        return  o.getId().getTimestamp() - this.getId().getTimestamp();
    }
}
