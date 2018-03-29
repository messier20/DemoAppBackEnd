package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.beans.UpdateResponse;
import com.swedbank.itacademy.leasing.demoApp.models.*;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomerLeasing;
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

    @RequestMapping(value = "/user/private", method = RequestMethod.GET)
    public List<PrivateCustomerLeasing> getPrivateCustomerLeasing() {
        return customerService.getAllPrivateCustomerLeasing();
    }

    @RequestMapping(value = "/user/business", method = RequestMethod.GET)
    public List<BusinessCustomerLeasing> getBusinessCustomerLeasing() {
        return customerService.getAllBusinessCustomerLeasing();
    }

    @RequestMapping(value = "/user/private", method = RequestMethod.POST)
    public ObjectIdContainer addPrivateCustomerLeasing(@Valid @RequestBody PrivateCustomerLeasing privateCustomerLeasing) {
        privateCustomerLeasing.setStatus(ApplicationStatus.PENDING);
        return customerService.addPrivateCustomerLeasing(privateCustomerLeasing);
    }

    @RequestMapping(value = "/user/business", method = RequestMethod.POST)
    public ObjectIdContainer addBusinessCustomerLeasing(@Valid @RequestBody BusinessCustomerLeasing businessCustomerLeasing) {
        businessCustomerLeasing.setStatus(ApplicationStatus.PENDING);
        return customerService.addBusinessCustomerLeasing(businessCustomerLeasing);
    }

    @RequestMapping(value = "/user/private/{id}", method = RequestMethod.GET)
    public PrivateCustomerLeasing getPrivateCustomerLeasingById(@PathVariable("id") ObjectId id) {
        return customerService.getPrivateCustomerLeasingById(id);
    }

    @RequestMapping(value = "/user/business/{id}", method = RequestMethod.GET)
    public BusinessCustomerLeasing getBusinessCustomerLeasingById(@PathVariable("id") ObjectId id) {
        return customerService.getBusinessCustomerLeasingById(id);
    }

    @RequestMapping(value = "/user/private/status/{status}", method = RequestMethod.GET)
    public List<PrivateCustomerLeasing> getAllPrivateCustomerLeasingByStatus(@PathVariable("status") ApplicationStatus status) {
        return customerService.getAllPrivateCustomerLeasingByStatus(status);
    }

    @RequestMapping(value = "/user/business/status/{status}", method = RequestMethod.GET)
    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasingByStatus(@PathVariable("status") ApplicationStatus status) {
        return customerService.getAllBusinessCustomerLeasingByStatus(status);
    }

    @RequestMapping(value = "/user/private/update/{id}", method = RequestMethod.PUT)
    public UpdateResponse updatePrivateCustomerStatus(@Valid @RequestBody PrivateCustomerLeasing customer,
                                                      @PathVariable("id") ObjectId id) {
        return customerService.updatePrivateCustomer(id, customer);
    }

    @RequestMapping(value = "/user/business/update/{id}", method = RequestMethod.PUT)
    public UpdateResponse updateBusinessCustomer(@Valid @RequestBody BusinessCustomerLeasing customer,
                                                 @PathVariable("id") ObjectId id) {
        return customerService.updateBusinessCustomer(id, customer);
    }
}