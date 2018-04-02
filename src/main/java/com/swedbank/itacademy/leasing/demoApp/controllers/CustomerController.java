package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.models.*;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
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

    // private
//    @RequestMapping(value = "/user/private", method = RequestMethod.GET)
//    public List<Private> getPrivateCustomerLeasing() {
//        return customerService.getAllPrivateCustomerLeasing();
//    }
    @RequestMapping(value = "/user/private", method = RequestMethod.GET)
    public List<CustomerResponse<Private>> getPrivateCustomerLeasing() {
        return customerService.getAllPrivateCustomerLeasing();
    }

    @RequestMapping(value = "/user/private", method = RequestMethod.POST) // +
    public ObjectIdContainer addPrivateCustomerLeasing(@Valid @RequestBody Leasing<PrivateCustomer> customer) {
        return CustomerService.addCustomer(customer);
    }

//    @RequestMapping(value = "/user/private/{id}", method = RequestMethod.GET)
//    public PrivateCustomerLeasing getPrivateCustomerLeasingById(@PathVariable("id") ObjectId id) {
//        return customerService.getPrivateCustomerLeasingById(id);
//    }
//
//    @RequestMapping(value = "/user/private/status/{status}", method = RequestMethod.GET)
//    public List<PrivateCustomerLeasing> getAllPrivateCustomerLeasingByStatus(@PathVariable("status") ApplicationStatus status) {
//        return customerService.getAllPrivateCustomerLeasingByStatus(status);
//    }
//
//    @RequestMapping(value = "/user/private/update/{id}", method = RequestMethod.PUT)
//    public UpdateResponse updatePrivateCustomerStatus(@Valid @RequestBody PrivateCustomerLeasing customer,
//                                                      @PathVariable("id") ObjectId id) {
//        return customerService.updatePrivateCustomer(id, customer);
//    }

//    // business
//    @RequestMapping(value = "/user/business", method = RequestMethod.GET)
//    public List<BusinessCustomerLeasing> getBusinessCustomerLeasing() {
//        return customerService.getAllBusinessCustomerLeasing();
//    }
//
//    @RequestMapping(value = "/user/business", method = RequestMethod.POST)
//    public ObjectIdContainer addBusinessCustomerLeasing(@Valid @RequestBody BusinessCustomerLeasing businessCustomerLeasing) {
//        businessCustomerLeasing.setStatus(ApplicationStatus.PENDING);
//        return customerService.addBusinessCustomer(businessCustomerLeasing);
//    }
//
//    @RequestMapping(value = "/user/business/{id}", method = RequestMethod.GET)
//    public BusinessCustomerLeasing getBusinessCustomerLeasingById(@PathVariable("id") ObjectId id) {
//        return customerService.getBusinessCustomerLeasingById(id);
//    }
//
//    @RequestMapping(value = "/user/business/status/{status}", method = RequestMethod.GET)
//    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasingByStatus(@PathVariable("status") ApplicationStatus status) {
//        return customerService.getAllBusinessCustomerLeasingByStatus(status);
//    }
//
//    @RequestMapping(value = "/user/business/update/{id}", method = RequestMethod.PUT)
//    public UpdateResponse updateBusinessCustomer(@Valid @RequestBody BusinessCustomerLeasing customer,
//                                                 @PathVariable("id") ObjectId id) {
//        return customerService.updateBusinessCustomer(id, customer);
//    }
}