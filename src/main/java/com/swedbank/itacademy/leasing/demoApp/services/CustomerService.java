package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.BusinessCustomerRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.PrivateCustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CustomerService {
    private final PrivateCustomerRepository privateCustomerRepository;
    private final BusinessCustomerRepository businessCustomerRepository;

    @Autowired
    public CustomerService(PrivateCustomerRepository privateCustomerRepository, BusinessCustomerRepository businessCustomerRepository) {
        this.privateCustomerRepository = privateCustomerRepository;
        this.businessCustomerRepository = businessCustomerRepository;
    }

    public String addPrivateCustomer(@Valid PrivateCustomer privateCustomer) {
        privateCustomer.setId(new ObjectId());
        privateCustomerRepository.save(privateCustomer);
        return privateCustomer.getId().toString();
    }

    public String addBusinessCustomer(@Valid BusinessCustomer businessCustomer) {
        businessCustomer.setId(new ObjectId());
        businessCustomerRepository.save(businessCustomer);
        return businessCustomer.getId().toString();
    }
}
