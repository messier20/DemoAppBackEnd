package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomerLeasing;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Customer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository<T extends Customer> extends CrudRepository<T, String> {
    List<T> findAll();
    List<T> findAllByStatus(ApplicationStatus status);
    T findById(ObjectId id);
}