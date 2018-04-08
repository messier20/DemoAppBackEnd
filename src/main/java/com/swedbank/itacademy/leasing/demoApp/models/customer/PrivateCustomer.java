package com.swedbank.itacademy.leasing.demoApp.models.customer;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "private-customer")
public class PrivateCustomer extends BusinessCustomer {
    @NotNull
    private String lastName;

    public PrivateCustomer() {}

    public PrivateCustomer(String name, String code, String email,String phoneNumber, String address, String lastName) {
        super(name, code, email, phoneNumber, address);
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
