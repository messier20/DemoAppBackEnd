package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomerLeasing;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivateCustomerRepository extends CrudRepository<PrivateCustomerLeasing, String>{
    List<PrivateCustomerLeasing> findAll();
    List<PrivateCustomerLeasing> findAllByStatus(ApplicationStatus status);
    PrivateCustomerLeasing findById(ObjectId id);
}
