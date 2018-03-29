package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.repayments.LoanCalculatorInput;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.RepaymentSchedule;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepaymentScheduleService {

    public List<Repayment> getAllRepayments() {
        return new ArrayList<>();
    }

    public RepaymentSchedule calculateRepaymentSchedule(@Valid LoanCalculatorInput loanCalculatorInput) {
        RepaymentSchedule rp = new RepaymentSchedule();
        Repayment r = new Repayment();
        r.setContractFee("200");
        r.setAssetValuePaymentAmount("100");
        r.setInterestPaymentAmount("150");
        r.setRemainingAmountToRepay("250");
        r.setTotalPaymentAmount("300");
        r.setRepaymentDate("2018-03-03");
        List<Repayment> rpl = new ArrayList<>();
        rpl.add(r);
        rpl.add(r);
        rp.setRepaymentSchedule(rpl);
        return rp;
    }
}
