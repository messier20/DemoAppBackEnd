package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.beans.LoginResponse;
import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class OfficerLoginController {

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public LoginResponse updateBusinessCustomer(@Valid @RequestBody LoginModel loginModel) {
        System.out.println("Connection received.");

        if (loginModel.getEmail().equals("officer@blueleasing.com") && loginModel.getPassword().equals("123")) {
            return new LoginResponse(true);

        } else {
            return new LoginResponse(false);
        }
    }
}
