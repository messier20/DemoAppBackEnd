package com.swedbank.itacademy.leasing.demoApp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class BusinessCustomerLeasing implements Comparable<BusinessCustomerLeasing> {
    @Id
    private ObjectId id;
    private ApplicationStatus status;
    @NotNull
    private CustomerLeasing customerLeasing;
    @NotNull
    private BusinessCustomer businessCustomer;

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

    public BusinessCustomer getBusinessCustomer() {
        return businessCustomer;
    }

    public void setBusinessCustomer(BusinessCustomer businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    @Override
    public int compareTo(BusinessCustomerLeasing o) {
        return  o.getId().getTimestamp() - this.getId().getTimestamp();
    }
}