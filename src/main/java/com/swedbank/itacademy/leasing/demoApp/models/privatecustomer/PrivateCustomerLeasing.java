package com.swedbank.itacademy.leasing.demoApp.models.privatecustomer;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.CustomerLeasing;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class PrivateCustomerLeasing implements Comparable<PrivateCustomerLeasing> {
    @Id
    private ObjectId id;
    private String idHex;
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

    public String getIdHex() {
        return idHex;
    }

    public void setIdHex(String idHex) {
        this.idHex = idHex;
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
