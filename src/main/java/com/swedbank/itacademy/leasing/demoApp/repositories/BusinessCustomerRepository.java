package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.BusinessFormsCombined;
import org.springframework.data.repository.CrudRepository;

public interface BusinessCustomerRepository extends CrudRepository<BusinessFormsCombined, String> {
}
