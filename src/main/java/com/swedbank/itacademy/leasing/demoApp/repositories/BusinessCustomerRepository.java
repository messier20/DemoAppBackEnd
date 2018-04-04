package com.swedbank.itacademy.leasing.demoApp.repositories;


import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BusinessCustomerRepository extends CrudRepository<Business, String> {
    List<Business> findAll();
    List<Business> findAllByStatus(ApplicationStatus status);
    Business findById(ObjectId id);
}