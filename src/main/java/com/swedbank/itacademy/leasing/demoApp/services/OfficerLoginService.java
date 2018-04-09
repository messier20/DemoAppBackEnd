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

    private boolean isAuthorizedOfficer(LoginModel authenticationData) {
        if (authenticationData != null) {
            Officer authenticatedUser = officerLoginRepository.findByEmail(authenticationData.getEmail());
            return (authenticatedUser.getPassword().equals(authenticationData.getPassword()));
        } else {
            return false;
        }
    }

    public LoginResponse checkUserAuthenticity(LoginModel loggingInUser) {
        return new LoginResponse(isAuthorizedOfficer(loggingInUser));
    }

    public void addAuthenticatedUser(LoginModel userToAdd) {
        Officer dbUser = new Officer(userToAdd);

        officerLoginRepository.save(dbUser);
    }
}
