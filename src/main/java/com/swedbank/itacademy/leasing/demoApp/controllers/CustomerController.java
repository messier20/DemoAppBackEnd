package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.*;
import com.swedbank.itacademy.leasing.demoApp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/")

public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/add-private-customer-form", method = RequestMethod.POST)
    public String addPrivateCustomerForm(@Valid @RequestBody PrivateFormsCombined privateFormsCombined) {
        return customerService.addPrivateFormsCombined(privateFormsCombined);
    }

    @RequestMapping(value = "/add-business-customer-form", method = RequestMethod.POST)
    public String addBusinessCustomerForm(@Valid @RequestBody BusinessFormsCombined businessFormsCombined) {
        return customerService.addBusinessFormsCombined(businessFormsCombined);
    }

    @RequestMapping(value = "/")
    public List<PrivateFormsCombined> getAllPosts() {
        return customerService.getAllPrivateFormsCombined();
    }
}