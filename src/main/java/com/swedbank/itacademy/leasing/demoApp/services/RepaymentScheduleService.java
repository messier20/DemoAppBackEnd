package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.repayments.LoanCalculatorInput;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.RepaymentPlan;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentScheduleService {

    public List<Repayment> getAllRepayments() {
        return new ArrayList<>();
    }

    public RepaymentPlan calculateRepaymentPlan(@Valid LoanCalculatorInput loanCalculatorInput) {
        return new RepaymentPlan();
    }
}
