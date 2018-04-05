package com.swedbank.itacademy.leasing.demoApp.repositories.models;

import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;

public class Officer {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public Officer() {
    }

    public Officer(LoginModel user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
