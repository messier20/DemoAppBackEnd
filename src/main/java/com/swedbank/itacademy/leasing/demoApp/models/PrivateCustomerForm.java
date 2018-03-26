package com.swedbank.itacademy.leasing.demoApp.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "private-customer")
public class PrivateCustomerForm extends BusinessCustomerForm {
    @NotNull
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
