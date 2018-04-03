package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivateCustomerRepository extends CrudRepository<Private, String> {
    List<Private> findAll();
    List<Private> findAllByStatus(ApplicationStatus status);
    Private findById(ObjectId id);
}