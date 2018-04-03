package com.swedbank.itacademy.leasing.demoApp.beans;

import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.customer.CustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.customer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;

public class CustomerResponse<T> extends Leasing<T> {
    private ObjectId id;
    private String idHex;
    private ApplicationStatus status;

    public CustomerResponse() {}

    public CustomerResponse(Private customer) {
        this.setLeasing(new CustomerLeasing(customer));
        PrivateCustomer privateCustomer = new PrivateCustomer(customer.getFirstName(), customer.getPersonalCode(),
                customer.getEmail(), customer.getPhoneNumber(), customer.getAddress(), customer.getLastName());
        this.setCustomer((T) privateCustomer);
        this.id = customer.getId();
        this.idHex = customer.getIdHex();
        this.status = customer.getStatus();
    }

    public CustomerResponse(Business customer) {
        this.setLeasing(new CustomerLeasing(customer));
        BusinessCustomer businessCustomer = new BusinessCustomer(customer.getCompanyName(), customer.getCompanyCode(),
                customer.getEmail(), customer.getPhoneNumber(), customer.getAddress());
        this.setCustomer((T) businessCustomer);
        this.id = customer.getId();
        this.idHex = customer.getIdHex();
        this.status = customer.getStatus();
    }

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
}
