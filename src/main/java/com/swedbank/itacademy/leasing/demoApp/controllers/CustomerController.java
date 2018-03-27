package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.*;
import com.swedbank.itacademy.leasing.demoApp.services.CustomerService;
import org.bson.types.ObjectId;
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

    @RequestMapping(value = "/user/private", method = RequestMethod.POST)
    public String addPrivateCustomerForm(@Valid @RequestBody PrivateFormsCombined privateFormsCombined) {
        return customerService.addPrivateFormsCombined(privateFormsCombined);
    }

    @RequestMapping(value = "/user/business", method = RequestMethod.POST)
    public String addBusinessCustomerForm(@Valid @RequestBody BusinessFormsCombined businessFormsCombined) {
        return customerService.addBusinessFormsCombined(businessFormsCombined);
    }

    @RequestMapping(value = "/user/private/{id}", method = RequestMethod.GET)
    public PrivateFormsCombined getPrivateCustomerForm(@PathVariable("id") ObjectId id) {
        return customerService.getPrivateFormCombinedById(id);
    }

    @RequestMapping(value = "/user/private/status/{status}")
    public List<PrivateFormsCombined> getAllPosts(@PathVariable("status") ApplicationStatus status) {
        return customerService.getAllByStatus(status);
    }
}