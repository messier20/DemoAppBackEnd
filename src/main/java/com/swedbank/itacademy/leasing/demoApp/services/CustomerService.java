package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.beans.UpdateResponse;
import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;
import com.swedbank.itacademy.leasing.demoApp.models.customer.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.customer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.customer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.leasingOfficer.LoginModel;
import com.swedbank.itacademy.leasing.demoApp.models.email.EmailMsg;
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

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerService {
    private final PrivateCustomerRepository privatePrivateCustomerRepository;
    private BusinessCustomerRepository businessCustomerRepository;
    private final EmailService emailService;
    private OfficerLoginRepository officerLoginRepository;

    @Autowired
    public CustomerService(PrivateCustomerRepository privatePrivateCustomerRepository,
                           BusinessCustomerRepository businessCustomerRepository,
                           OfficerLoginRepository officerLoginRepository,
                           EmailService emailService) {

        this.privatePrivateCustomerRepository = privatePrivateCustomerRepository;
        this.businessCustomerRepository = businessCustomerRepository;
        this.officerLoginRepository = officerLoginRepository;
        this.emailService = emailService;
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

    public ObjectIdContainer addPrivateCustomer(Leasing<PrivateCustomer> customer) throws IOException, MessagingException {
        Private dbObject = new Private(customer);
        if (CustomerUtils.isCustomerValid(dbObject)) {
            privatePrivateCustomerRepository.save(dbObject);
            String msg = "<p>Hi <b>" + dbObject.getFirstName() + "</b>!</p><p>Thank You for choosing us!<br>This is application id: <b>" +
                    dbObject.getIdHex() + "</b>. You can use it to <a href=\"https://leasing-app-front.herokuapp.com\">" +
                    "check application status.</a></p><p>Blue Leasing</p>";

            emailService.sendEmail(new EmailMsg(dbObject.getEmail(), "Application status id", msg));

            return CustomerUtils.addIdToContainer(dbObject.getId());
        }
        return new ObjectIdContainer();
    }

    public UpdateResponse updatePrivateCustomer(ObjectId id, CustomerResponse<Private> customer) throws IOException, MessagingException {
        if (isAuthorizedOfficer(customer.getLoginModel())) {
            Private p = privatePrivateCustomerRepository.findById(id);
            p.setStatus(customer.getStatus());
            privatePrivateCustomerRepository.save(p);
            String msg = "<p>Hi <b>" + p.getFirstName() + "</b>!</p><p>Your application status has been changed.</p><p>Blue Leasing</p>";

            emailService.sendEmail(new EmailMsg(p.getEmail(), "Status update", msg));
            return new UpdateResponse(p.getId().toString(), p.getStatus());

        }

        return new UpdateResponse();

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

    public ObjectIdContainer addBusinessCustomer(Leasing<BusinessCustomer> customer) throws IOException, MessagingException {
        Business dbObject = new Business(customer);
        boolean xAx = CustomerUtils.isCustomerValid(dbObject);
        if (CustomerUtils.isCustomerValid(dbObject)) {
            businessCustomerRepository.save(dbObject);
            String msg = "<p>Hi <b>" + dbObject.getCompanyName() + "</b>!</p><p>Thank You for choosing us!<br>This is application id: <b>" +
                    dbObject.getIdHex() + "</b>. You can use it to <a href=\"https://leasing-app-front.herokuapp.com\">" +
                    "check application status.</a></p><p>Blue Leasing</p>";

            emailService.sendEmail(new EmailMsg(dbObject.getEmail(), "Application status id", msg));
            return CustomerUtils.addIdToContainer(dbObject.getId());
        }
        return new ObjectIdContainer();
    }

    public UpdateResponse updateBusinessCustomer(ObjectId id, CustomerResponse<Business> customer) throws IOException, MessagingException {
        if (isAuthorizedOfficer(customer.getLoginModel())) {
            Business b = businessCustomerRepository.findById(id);
            b.setStatus(customer.getStatus());
            businessCustomerRepository.save(b);

            String msg = "<p>Hi <b>" + b.getCompanyName() + "</b>!</p><p>Your application status has been changed.</p><p>Blue Leasing</p>";

            emailService.sendEmail(new EmailMsg(b.getEmail(), "Status update", msg));

            return new UpdateResponse(b.getId().toString(), b.getStatus());

        }

        return new UpdateResponse();

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

        }

        return new ArrayList<CustomerResponse>();

    }

    private boolean isAuthorizedOfficer(LoginModel authenticationData) {
        Officer authenticatedUser = officerLoginRepository.findByEmail(authenticationData.getEmail());
        return (authenticatedUser.getPassword().equals(authenticationData.getPassword()));
    }
}





