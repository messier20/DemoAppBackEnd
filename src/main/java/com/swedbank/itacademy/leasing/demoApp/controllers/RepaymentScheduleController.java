package com.swedbank.itacademy.leasing.demoApp.controllers;

import com.swedbank.itacademy.leasing.demoApp.models.repayments.LoanCalculatorInput;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.RepaymentSchedule;
import com.swedbank.itacademy.leasing.demoApp.services.RepaymentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class RepaymentScheduleController {

    private final RepaymentScheduleService repaymentScheduleService;

    @Autowired
    public RepaymentScheduleController(RepaymentScheduleService repaymentScheduleService) {
        this.repaymentScheduleService = repaymentScheduleService;
    }

    @RequestMapping(value = "/user/calculator/loan/vehicle", method = RequestMethod.POST)
    public RepaymentSchedule getRepaymentSchedule(@Valid @RequestBody LoanCalculatorInput loanCalculatorInput) {
        return repaymentScheduleService.calculateRepaymentSchedule(loanCalculatorInput);
    }

}