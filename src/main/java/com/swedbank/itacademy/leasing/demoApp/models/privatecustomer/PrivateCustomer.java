package com.swedbank.itacademy.leasing.demoApp.models.privatecustomer;

import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomer;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "private-customer")
public class PrivateCustomer extends BusinessCustomer {
    @NotNull
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
