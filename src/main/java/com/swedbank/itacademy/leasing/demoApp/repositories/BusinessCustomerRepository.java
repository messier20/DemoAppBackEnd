package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessCustomer;
import org.springframework.data.repository.CrudRepository;

public interface BusinessCustomerRepository extends CrudRepository<BusinessCustomer, String> {
}
