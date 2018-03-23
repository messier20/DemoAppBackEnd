package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.documents.CustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.beans.documents.IncomingLeasingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/")

public class PrivateCustomerController {

    @RequestMapping(value = "/customerLeasingForm", method = RequestMethod.POST)
    public void addCustomerLeasingForm(@Valid @RequestBody IncomingLeasingForm customerLeasingForm) {
        System.out.println("Got a new customer leasing form");
        System.out.println(customerLeasingForm.getCarBrand() + " " + customerLeasingForm.getCarModel());
    }

}
