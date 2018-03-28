package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.BusinessCustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateCustomerLeasing;
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

    public String addPrivateCustomerLeasing(@Valid PrivateCustomerLeasing privateCustomerLeasing) {
        privateCustomerLeasing.setId(new ObjectId());
        privateCustomerRepository.save(privateCustomerLeasing);
        return privateCustomerLeasing.getId().toString();
    }

    public String addBusinessCustomerLeasing(@Valid BusinessCustomerLeasing businessCustomerLeasing) {
        businessCustomerLeasing.setId(new ObjectId());
        businessCustomerRepository.save(businessCustomerLeasing);
        return businessCustomerLeasing.getId().toString();
    }

    public PrivateCustomerLeasing getPrivateCustomerLeasingById(ObjectId id) {
        return privateCustomerRepository.findById(id);
    }

    public BusinessCustomerLeasing getBusinessCustomerLeasingById(ObjectId id) {
        return businessCustomerRepository.findById(id);
    }
}
