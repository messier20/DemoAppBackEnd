package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/")

public class CustomerController {
    @RequestMapping(value = "/add-business-customer-form", method = RequestMethod.POST)
    public void addBusinessCustomerForm(@Valid @RequestBody BusinessFormsCombined businessFormsCombined) {

        System.out.println("New business customer form received.");
        System.out.println(businessFormsCombined.getBusinessCustomerForm().getEmail());
    }

    @RequestMapping(value = "/add-private-customer-form", method = RequestMethod.POST)
    public void addPrivateCustomerForm(@Valid @RequestBody PrivateFormsCombined privateFormsCombined) {

        System.out.println("New private customer form received.");
        System.out.println(privateFormsCombined.getPrivateCustomerForm().getLastName());

    }

}
