package com.swedbank.itacademy.leasing.demoApp.models.customer;

import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Document(collection = "private-customer")
public class PrivateCustomer extends BusinessCustomer {
    @NotNull
    private String lastName;

    public PrivateCustomer() {}

    public PrivateCustomer(@NotNull String name, @NotNull String code, @Email @NotNull String email,
                           @NotNull @Pattern(regexp = "(\\+\\d{10,15})") String phoneNumber,
                           @NotNull String address, @NotNull String lastName) {
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
