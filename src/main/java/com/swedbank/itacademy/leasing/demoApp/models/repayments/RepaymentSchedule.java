package com.swedbank.itacademy.leasing.demoApp.models.repayments;

import java.util.List;

public class RepaymentSchedule {
    private List<Repayment> repaymentSchedule;

    public List<Repayment> getRepaymentSchedule() {
        return repaymentSchedule;
    }

    public void setRepaymentSchedule(List<Repayment> repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }
}
