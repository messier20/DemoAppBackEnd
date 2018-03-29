package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.repositories.BusinessCustomerRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.PrivateCustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

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

    public List<PrivateCustomerLeasing> getAllPrivateCustomerLeasing() {
        List<PrivateCustomerLeasing> privateCustomerLeasings = privateCustomerRepository.findAll();
        Collections.sort(privateCustomerLeasings);
        return privateCustomerLeasings;
    }

    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasing() {
        List<BusinessCustomerLeasing> businessCustomerLeasings = businessCustomerRepository.findAll();
        Collections.sort(businessCustomerLeasings);
        return businessCustomerLeasings;
    }

    public List<PrivateCustomerLeasing> getAllPrivateCustomerLeasingByStatus(ApplicationStatus status) {
        return privateCustomerRepository.findAllByStatus(status);
    }

    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasingByStatus(ApplicationStatus status) {
        return businessCustomerRepository.findAllByStatus(status);
    }

    public ObjectIdContainer addPrivateCustomerLeasing(@Valid PrivateCustomerLeasing privateCustomerLeasing) {
        privateCustomerLeasing.setId(new ObjectId());
        privateCustomerRepository.save(privateCustomerLeasing);

        ObjectIdContainer idContainer = new ObjectIdContainer();
        idContainer.setId(privateCustomerLeasing.getId().toString());
        return idContainer;
    }

    public ObjectIdContainer addBusinessCustomerLeasing(@Valid BusinessCustomerLeasing businessCustomerLeasing) {
        businessCustomerLeasing.setId(new ObjectId());
        businessCustomerRepository.save(businessCustomerLeasing);

        ObjectIdContainer idContainer = new ObjectIdContainer();
        idContainer.setId(businessCustomerLeasing.getId().toString());
        return idContainer;
    }

    public PrivateCustomerLeasing getPrivateCustomerLeasingById(ObjectId id) {
        return privateCustomerRepository.findById(id);
    }

    public BusinessCustomerLeasing getBusinessCustomerLeasingById(ObjectId id) {
        return businessCustomerRepository.findById(id);
    }
}
