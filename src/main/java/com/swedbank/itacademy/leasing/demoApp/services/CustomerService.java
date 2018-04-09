package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.beans.UpdateResponse;
import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.customer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;
import com.swedbank.itacademy.leasing.demoApp.repositories.BusinessCustomerRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.OfficerLoginRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.PrivateCustomerRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Officer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import com.swedbank.itacademy.leasing.demoApp.utils.CustomerUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private final PrivateCustomerRepository privatePrivateCustomerRepository;
    private BusinessCustomerRepository businessCustomerRepository;
    private OfficerLoginRepository officerLoginRepository;

    @Autowired
    public CustomerService(PrivateCustomerRepository privatePrivateCustomerRepository,
                           BusinessCustomerRepository businessCustomerRepository,
                           OfficerLoginRepository officerLoginRepository) {

        this.privatePrivateCustomerRepository = privatePrivateCustomerRepository;
        this.businessCustomerRepository = businessCustomerRepository;
        this.officerLoginRepository = officerLoginRepository;
    }

    // private
    public List<CustomerResponse<Private>> getAllPrivateCustomerLeasing() {
        List<Private> p = privatePrivateCustomerRepository.findAll();
        Collections.sort(p);
        return CustomerUtils.privatesToResponse(p);
    }

    public CustomerResponse<Private> getPrivateCustomerLeasingById(ObjectId id) {
        Private p = privatePrivateCustomerRepository.findById(id);
        return new CustomerResponse<Private>(p);
    }

    public List<CustomerResponse<Private>> getAllPrivateCustomerLeasingByStatus(ApplicationStatus status) {
        List<Private> p = privatePrivateCustomerRepository.findAllByStatus(status);
        return CustomerUtils.privatesToResponse(p);
    }

    public ObjectIdContainer addPrivateCustomer(Leasing<PrivateCustomer> customer) {
        Private dbObject = new Private(customer);
        privatePrivateCustomerRepository.save(dbObject);
        return CustomerUtils.addIdToContainer(dbObject.getId());
    }

    public UpdateResponse updatePrivateCustomer(ObjectId id, CustomerResponse<Private> customer) {
        if (isAuthorizedOfficer(customer.getLoginModel())) {
            Private p = privatePrivateCustomerRepository.findById(id);
            p.setStatus(customer.getStatus());
            privatePrivateCustomerRepository.save(p);
            return new UpdateResponse(p.getId().toString(), p.getStatus());

        } else {
            return new UpdateResponse();
        }

    }

    // business
    public List<CustomerResponse<Business>> getAllBusinessCustomerLeasing() {
        List<Business> b = businessCustomerRepository.findAll();
        Collections.sort(b);
        return CustomerUtils.businessToResponse(b);
    }

    public CustomerResponse<Business> getBusinessCustomerLeasingById(ObjectId id) {
        Business b = businessCustomerRepository.findById(id);
        return new CustomerResponse<Business>(b);
    }

    public List<CustomerResponse<Business>> getAllBusinessCustomerLeasingByStatus(ApplicationStatus status) {
        List<Business> b = businessCustomerRepository.findAllByStatus(status);
        return CustomerUtils.businessToResponse(b);
    }

    public ObjectIdContainer addBusinessCustomer(Leasing<BusinessCustomer> customer) {
        Business dbObject = new Business(customer);
        businessCustomerRepository.save(dbObject);
        return CustomerUtils.addIdToContainer(dbObject.getId());
    }

    public UpdateResponse updateBusinessCustomer(ObjectId id, CustomerResponse<Business> customer) {
        if (isAuthorizedOfficer(customer.getLoginModel())) {
            Business b = businessCustomerRepository.findById(id);
            b.setStatus(customer.getStatus());
            businessCustomerRepository.save(b);
            return new UpdateResponse(b.getId().toString(), b.getStatus());

        } else {
            return new UpdateResponse();
        }
    }

    // private + business
    public List<CustomerResponse> getAllCustomers(LoginModel authenticationData) {

        if (isAuthorizedOfficer(authenticationData)) {
            List<CustomerResponse> responses = new ArrayList<>();
            for (Private p : privatePrivateCustomerRepository.findAll()) {
                responses.add(new CustomerResponse<Private>(p));
            }
            for (Business b : businessCustomerRepository.findAll()) {
                responses.add(new CustomerResponse<Business>(b));
            }
            Collections.sort(responses);
            return responses;

        } else {
            return new ArrayList<CustomerResponse>();
        }
    }

    private boolean isAuthorizedOfficer(LoginModel authenticationData) {
        Officer authenticatedUser = officerLoginRepository.findByEmail(authenticationData.getEmail());
        return (authenticatedUser.getPassword().equals(authenticationData.getPassword()));
    }
}





