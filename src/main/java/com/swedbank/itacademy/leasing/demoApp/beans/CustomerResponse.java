package com.swedbank.itacademy.leasing.demoApp.beans;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.CustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;

public class CustomerResponse<T> extends Leasing<T> {
    private ObjectId id;
    private String idHex;
    private ApplicationStatus status;

    public CustomerResponse(Private customer) {
        this.setLeasing(new CustomerLeasing(customer));
        PrivateCustomer privateCustomer = new PrivateCustomer(customer.getFirstName(), customer.getPersonalCode(),
                customer.getEmail(), customer.getPhoneNumber(), customer.getAddress(), customer.getLastName());
        this.setCustomer((T) privateCustomer);
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
}
