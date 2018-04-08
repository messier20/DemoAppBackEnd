package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.beans.UpdateResponse;
import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import com.swedbank.itacademy.leasing.demoApp.services.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
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
    @RequestMapping(value = "/user/private", method = RequestMethod.GET)
    public List<CustomerResponse<Private>> getPrivateCustomerLeasing() {
        return customerService.getAllPrivateCustomerLeasing();
    }

    @RequestMapping(value = "/user/private/{id}", method = RequestMethod.GET)
    public CustomerResponse<Private> getPrivateCustomerLeasingById(@PathVariable("id") ObjectId id) {
        return customerService.getPrivateCustomerLeasingById(id);
    }

    @RequestMapping(value = "/user/private/status/{status}", method = RequestMethod.GET)
    public List<CustomerResponse<Private>> getAllPrivateCustomerLeasingByStatus(
            @PathVariable("status") ApplicationStatus status) {
        return customerService.getAllPrivateCustomerLeasingByStatus(status);
    }

    @RequestMapping(value = "/user/private", method = RequestMethod.POST)
    public ObjectIdContainer addPrivateCustomerLeasing(@Valid @RequestBody Leasing<PrivateCustomer> customer) throws IOException, MessagingException {
        return customerService.addPrivateCustomer(customer);
    }

    @RequestMapping(value = "/user/private/update/{id}", method = RequestMethod.PUT)
    public UpdateResponse updatePrivateCustomer(@Valid @RequestBody CustomerResponse<Private> customer,
                                                 @PathVariable("id") ObjectId id) throws IOException, MessagingException {
        return customerService.updatePrivateCustomer(id, customer);
    }

    // business
    @RequestMapping(value = "/user/business", method = RequestMethod.GET)
    public List<CustomerResponse<Business>> getBusinessCustomerLeasing() {
        return customerService.getAllBusinessCustomerLeasing();
    }

    @RequestMapping(value = "/user/business/{id}", method = RequestMethod.GET)
    public CustomerResponse<Business> getBusinessCustomerLeasingById(@PathVariable("id") ObjectId id) {
        return customerService.getBusinessCustomerLeasingById(id);
    }

    @RequestMapping(value = "/user/business/status/{status}", method = RequestMethod.GET)
    public List<CustomerResponse<Business>> getAllBusinessCustomerLeasingByStatus(
            @PathVariable("status") ApplicationStatus status) {
        return customerService.getAllBusinessCustomerLeasingByStatus(status);
    }

    @RequestMapping(value = "/user/business", method = RequestMethod.POST)
    public ObjectIdContainer addBusinessCustomerLeasing(@Valid @RequestBody Leasing<BusinessCustomer> customer) throws IOException, MessagingException {
        return customerService.addBusinessCustomer(customer);
    }

    @RequestMapping(value = "/user/business/update/{id}", method = RequestMethod.PUT)
    public UpdateResponse updateBusinessCustomer(@Valid @RequestBody CustomerResponse<Business> customer,
                                                 @PathVariable("id") ObjectId id) throws IOException, MessagingException {
        return customerService.updateBusinessCustomer(id, customer);
    }

    // private + business
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}






















