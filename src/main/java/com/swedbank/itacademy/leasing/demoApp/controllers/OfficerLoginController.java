package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.LoginResponse;
import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;
import com.swedbank.itacademy.leasing.demoApp.services.OfficerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class OfficerLoginController {

    private final OfficerLoginService officerLoginService;

    @Autowired
    public OfficerLoginController(OfficerLoginService officerLoginService) {
        this.officerLoginService = officerLoginService;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public LoginResponse checkUserAuthenticity(@Valid @RequestBody LoginModel loginModel) {
        return officerLoginService.checkUserAuthenticity(loginModel);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void addAuthenticatedUser(@Valid @RequestBody LoginModel userToAdd) {
        officerLoginService.addAuthenticatedUser(userToAdd);
    }

}
