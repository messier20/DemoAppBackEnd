package com.swedbank.itacademy.leasing.demoApp.repositories.models;

import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.PrivateCustomer;

import javax.validation.constraints.NotNull;

public class Private extends Customer {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String personalCode;

    public Private() {}

    public Private(Leasing<PrivateCustomer> customerLeasing) {
        super(customerLeasing);
        this.firstName = customerLeasing.getCustomer().getName();
        this.lastName = customerLeasing.getCustomer().getLastName();
        this.personalCode = customerLeasing.getCustomer().getCode();
        this.setEmail(customerLeasing.getCustomer().getEmail());
        this.setPhoneNumber(customerLeasing.getCustomer().getPhoneNumber());
        this.setAddress(customerLeasing.getCustomer().getAddress());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }
}
