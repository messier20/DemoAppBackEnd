package com.swedbank.itacademy.leasing.demoApp.beans;

import com.swedbank.itacademy.leasing.demoApp.models.customer.ApplicationStatus;

public class UpdateResponse extends ObjectIdContainer {
    private ApplicationStatus status;

    public UpdateResponse() {}

    public UpdateResponse(String id, ApplicationStatus status) {
        this.setId(id);
        this.status = status;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}

