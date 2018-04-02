package com.swedbank.itacademy.leasing.demoApp.models.privatecustomer;

import com.swedbank.itacademy.leasing.demoApp.models.CustomerLeasing;
import javax.validation.constraints.NotNull;

public class PrivateCustomerLeasing {
    @NotNull
    private CustomerLeasing customerLeasing;
    @NotNull
    private PrivateCustomer privateCustomer;

    public PrivateCustomerLeasing() {}

    public PrivateCustomerLeasing(CustomerLeasing customerLeasing, PrivateCustomer privateCustomer) {
        this.customerLeasing = customerLeasing;
        this.privateCustomer = privateCustomer;
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
}
