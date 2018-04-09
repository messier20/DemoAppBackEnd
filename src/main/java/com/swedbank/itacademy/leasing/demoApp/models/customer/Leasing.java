package com.swedbank.itacademy.leasing.demoApp.models.customer;

import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;

import javax.validation.constraints.NotNull;

public class Leasing<T> {
    @NotNull
    private LoginModel loginModel;
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

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
}
