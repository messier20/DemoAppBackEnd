package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")

public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/add-private-customer-form", method = RequestMethod.POST)
    public String addBusinessCustomer(@Valid @RequestBody PrivateCustomer privateCustomer) {
        return customerService.addPrivateCustomer(privateCustomer);
    }

    @RequestMapping(value = "/add-business-customer-form", method = RequestMethod.POST)
    public String addBusinessCustomerForm(@Valid @RequestBody BusinessCustomer businessCustomer) {
        return customerService.addBusinessCustomer(businessCustomer);
    }
}
