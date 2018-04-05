package com.swedbank.itacademy.leasing.demoApp.repositories;

import com.swedbank.itacademy.leasing.demoApp.repositories.models.Officer;
import org.springframework.data.repository.CrudRepository;

public interface OfficerLoginRepository extends CrudRepository<Officer, String> {
    Officer findByEmail(String email);
}
