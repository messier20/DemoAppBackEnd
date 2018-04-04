package com.swedbank.itacademy.leasing.demoApp.utils;

import com.swedbank.itacademy.leasing.demoApp.beans.CustomerResponse;
import com.swedbank.itacademy.leasing.demoApp.beans.ObjectIdContainer;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Business;
import com.swedbank.itacademy.leasing.demoApp.repositories.models.Private;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {
    public static List<CustomerResponse<Private>> privatesToResponse(List<Private> privates) {
        List<CustomerResponse<Private>> responses = new ArrayList<CustomerResponse<Private>>();
        for (Private p : privates) {
            CustomerResponse<Private> r = new CustomerResponse<Private>(p);
            responses.add(r);
        }
        return responses;
    }

    public static List<CustomerResponse<Business>> businessToResponse(List<Business> businesses) {
        List<CustomerResponse<Business>> responses = new ArrayList<CustomerResponse<Business>>();
        for (Business b : businesses) {
            CustomerResponse<Business> r = new CustomerResponse<Business>(b);
            responses.add(r);
        }
        return responses;
    }

    public static ObjectIdContainer addIdToContainer(ObjectId id) {
        ObjectIdContainer idContainer = new ObjectIdContainer();
        idContainer.setId(id.toString());
        return idContainer;
    }
}
