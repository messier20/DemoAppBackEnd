package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessCustomerForm;
import com.swedbank.itacademy.leasing.demoApp.models.CustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateCustomerForm;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/")

public class CustomerController {
    @RequestMapping(value = "/add-business-customer-form", method = RequestMethod.POST)
    public String addBusinessCustomerForm(@Valid @RequestBody CustomerLeasing customerLeasingForm,
                                          @Valid @RequestBody BusinessCustomerForm businessCustomerForm) {

        //return objectid
    }

    @RequestMapping(value = "/add-private-customer-form", method = RequestMethod.POST)
    public String addPrivateCustomerForm(@Valid @RequestBody CustomerLeasing customerLeasingForm,
                                         @Valid @RequestBody PrivateCustomerForm privateCustomerForm) {
        //return
    }




}
