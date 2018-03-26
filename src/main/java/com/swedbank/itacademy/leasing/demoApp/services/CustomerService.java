package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessFormsCombined;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateFormsCombined;
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
    public CustomerService(PrivateCustomerRepository privateCustomerRepository,
                           BusinessCustomerRepository businessCustomerRepository) {
        this.privateCustomerRepository = privateCustomerRepository;
        this.businessCustomerRepository = businessCustomerRepository;
    }

    public String addPrivateFormsCombined(@Valid PrivateFormsCombined privateFormsCombined) {
        privateFormsCombined.setId(new ObjectId());
        privateCustomerRepository.save(privateFormsCombined);
        return privateFormsCombined.getId().toString();
    }

    public String addBusinessFormsCombined(@Valid BusinessFormsCombined businessFormsCombined) {
        businessFormsCombined.setId(new ObjectId());
        businessCustomerRepository.save(businessFormsCombined);
        return businessFormsCombined.getId().toString();
    }

}
