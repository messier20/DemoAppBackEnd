package com.swedbank.itacademy.leasing.demoApp.models.businesscustomer;

import javax.validation.constraints.*;

public class BusinessCustomer {
    @NotNull
    private String name;
    @NotNull
    private String code;
    @Email @NotNull
    private String email;
    @NotNull
    @Pattern(regexp="(\\+\\d{10,15})")
    private String phoneNumber;
    @NotNull
    private String address;

    public BusinessCustomer() {}

    public BusinessCustomer(@NotNull String name, @NotNull String code, @Email @NotNull String email,
                            @NotNull @Pattern(regexp = "(\\+\\d{10,15})") String phoneNumber,
                            @NotNull String address) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
