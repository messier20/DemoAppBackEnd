package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomerLeasing;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusinessCustomerRepository extends CrudRepository<BusinessCustomerLeasing, String> {
    List<BusinessCustomerLeasing> findAll();
    List<BusinessCustomerLeasing> findAllByStatus(ApplicationStatus status);
    BusinessCustomerLeasing findById(ObjectId id);
}