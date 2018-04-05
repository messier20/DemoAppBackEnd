package com.swedbank.itacademy.leasing.demoApp.beans;

public class LoginResponse {
    private Boolean hasLoggedIn;

    public LoginResponse(Boolean hasLoggedIn) {
        this.hasLoggedIn = hasLoggedIn;
    }

    public Boolean getHasLoggedIn() {
        return hasLoggedIn;
    }

    public void setHasLoggedIn(Boolean hasLoggedIn) {
        this.hasLoggedIn = hasLoggedIn;
    }
}
