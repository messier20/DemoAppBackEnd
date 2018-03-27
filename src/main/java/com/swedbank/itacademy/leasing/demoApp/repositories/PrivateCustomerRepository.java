package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.models.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.PrivateFormsCombined;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrivateCustomerRepository extends CrudRepository<PrivateFormsCombined, String>{
    List<PrivateFormsCombined> findAll();
    List<PrivateFormsCombined> findAllByStatus(ApplicationStatus status);
    PrivateFormsCombined findPrivateCustomerById(ObjectId id);
}
