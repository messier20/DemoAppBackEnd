package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.models.Leasing;
import com.swedbank.itacademy.leasing.demoApp.models.businesscustomer.BusinessCustomer;
import com.swedbank.itacademy.leasing.demoApp.models.privatecustomer.PrivateCustomer;
import com.swedbank.itacademy.leasing.demoApp.repositories.CustomerRepository;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private static CustomerRepository<Private> privateCustomerRepo;
    private static CustomerRepository<Business> businessCustomerRepo;


    @Autowired
    public CustomerService(CustomerRepository<Private> privateCustomerRepo,
                           CustomerRepository<Business> businessCustomerRepo) {
        CustomerService.privateCustomerRepo = privateCustomerRepo;
        CustomerService.businessCustomerRepo = businessCustomerRepo;
    }

    // private
//    public List<Private> getAllPrivateCustomerLeasing() {
//        List<Private> privates = privateCustomerRepository.findAll();
//
//        //List<PrivateCustomerLeasing> privateCustomerLeasings = privateCustomerRepository.findAll();
//        //Collections.sort(privateCustomerLeasings);
//        return privates;
//    }

//    public List<PrivateCustomerLeasing> getAllPrivateCustomerLeasingByStatus(ApplicationStatus status) {
//        return null; //privateCustomerRepository.findAllByStatus(status);
//    }
//
//    public PrivateCustomerLeasing getPrivateCustomerLeasingById(ObjectId id) {
//        return null; //privateCustomerRepository.findById(id);
//    }
//
//    public UpdateResponse updatePrivateCustomer(ObjectId id, @Valid PrivateCustomerLeasing customer) {
////        PrivateCustomerLeasing leasing = privateCustomerRepository.findById(id);
////        leasing.setStatus(customer.getStatus());
////        privateCustomerRepository.save(leasing);
//        return null;//new UpdateResponse(leasing.getId().toString(), leasing.getStatus());
//    }

    // business
//    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasing() {
//        List<BusinessCustomerLeasing> businessCustomerLeasings = businessCustomerRepository.findAll();
//        Collections.sort(businessCustomerLeasings);
//        return businessCustomerLeasings;
//    }
//
//    public List<BusinessCustomerLeasing> getAllBusinessCustomerLeasingByStatus(ApplicationStatus status) {
//        return businessCustomerRepository.findAllByStatus(status);
//    }
//
//    public ObjectIdContainer addBusinessCustomer(@Valid BusinessCustomerLeasing businessCustomerLeasing) {
//
//        businessCustomerLeasing.setId(new ObjectId());
//        businessCustomerLeasing.setIdHex(businessCustomerLeasing.getId().toString());
//        businessCustomerRepository.save(businessCustomerLeasing);
//
//        return addIdToContainer(businessCustomerLeasing.getId());
//    }
//
//    public BusinessCustomerLeasing getBusinessCustomerLeasingById(ObjectId id) {
//        return businessCustomerRepository.findById(id);
//    }
//
//    public UpdateResponse updateBusinessCustomer(ObjectId id, @Valid BusinessCustomerLeasing customer) {
//        BusinessCustomerLeasing leasing = businessCustomerRepository.findById(id);
//        leasing.setStatus(customer.getStatus());
//        businessCustomerRepository.save(leasing);
//        return new UpdateResponse(leasing.getId().toString(), leasing.getStatus());
//    }
    public List<CustomerResponse<Private>> getAllPrivateCustomerLeasing() {
        List<Private> privates = privateCustomerRepo.findAll();
        List<CustomerResponse<Private>> responses = new ArrayList<CustomerResponse<Private>>();
        for (Private p : privates) {
            CustomerResponse<Private> r = new CustomerResponse<Private>(p);
            responses.add(r);
        }
        return responses;
    }

    public static <T> ObjectIdContainer addCustomer(Leasing<T> customer) {
        if (customer.getCustomer() instanceof PrivateCustomer) {
            @SuppressWarnings("unchecked")
            Private dbObject = new Private((Leasing<PrivateCustomer>) customer);
            privateCustomerRepo.save(dbObject);
            return addIdToContainer(dbObject.getId());
        }
        if (customer.getCustomer() instanceof BusinessCustomer) {
            @SuppressWarnings("unchecked")
            Business dbObject = new Business((Leasing<BusinessCustomer>) customer);
            businessCustomerRepo.save(dbObject);
            return addIdToContainer(dbObject.getId());
        }
        return null;
    }

    // utils
    private static ObjectIdContainer addIdToContainer(ObjectId id) {
        ObjectIdContainer idContainer = new ObjectIdContainer();
        idContainer.setId(id.toString());
        return idContainer;
    }
}
















