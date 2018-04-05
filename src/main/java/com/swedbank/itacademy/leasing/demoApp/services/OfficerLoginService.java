package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.beans.LoginResponse;
import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;
import com.swedbank.itacademy.leasing.demoApp.repositories.OfficerLoginRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Officer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerLoginService {

    private final OfficerLoginRepository officerLoginRepository;

    @Autowired
    public OfficerLoginService(OfficerLoginRepository officerLoginRepository) {
        this.officerLoginRepository = officerLoginRepository;
    }

    public LoginResponse checkUserAuthenticity(LoginModel loggingInUser) {
        Officer authenticatedUser = officerLoginRepository.findByEmail(loggingInUser.getEmail());

        if(authenticatedUser.getPassword().equals(loggingInUser.getPassword())) {
            return new LoginResponse(true);
        } else {
            return new LoginResponse(false);
        }
    }

    public void addAuthenticatedUser(LoginModel userToAdd) {
        Officer dbUser = new Officer(userToAdd);

        officerLoginRepository.save(dbUser);
    }
}
