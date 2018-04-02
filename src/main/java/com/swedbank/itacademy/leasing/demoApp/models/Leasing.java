package com.swedbank.itacademy.leasing.demoApp.models;

public class Leasing<T> {
    private CustomerLeasing leasing;
    private T customer;


    public CustomerLeasing getLeasing() {
        return leasing;
    }

    public void setLeasing(CustomerLeasing leasing) {
        this.leasing = leasing;
    }

    public T getCustomer() {
        return customer;
    }

    public void setCustomer(T customer) {
        this.customer = customer;
    }
}
