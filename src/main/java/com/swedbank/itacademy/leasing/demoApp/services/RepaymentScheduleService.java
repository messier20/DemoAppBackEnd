package com.swedbank.itacademy.leasing.demoApp.services;

import com.swedbank.itacademy.leasing.demoApp.models.repayments.LoanCalculatorInput;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.RepaymentSchedule;
import com.swedbank.itacademy.leasing.demoApp.utils.DateUtils;
import com.swedbank.itacademy.leasing.demoApp.utils.LoanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepaymentScheduleService {

    public RepaymentSchedule calculateRepaymentSchedule(@Valid LoanCalculatorInput loanCalculatorInput) {

        return fillRepaymentSchedule(loanCalculatorInput);
    }

    private RepaymentSchedule fillRepaymentSchedule(LoanCalculatorInput loanCalculatorInput) {

        RepaymentSchedule repaymentSchedule = new RepaymentSchedule();
        repaymentSchedule.setRepaymentSchedule(calculateRepayments(loanCalculatorInput));
        return repaymentSchedule;
    }

    private List<Repayment> calculateRepayments(LoanCalculatorInput loanCalculatorInput) {
        List<Repayment> repayments = new ArrayList<>();
        Repayment previousRepayment;
        Repayment currentRepayment;

        BigDecimal preciseInterest = LoanUtils.calculatePreciseInterest(loanCalculatorInput.getMargin(), new BigDecimal("12"));
        BigDecimal monthlyPayment = calculateMonthlyPayment(loanCalculatorInput, preciseInterest);

        currentRepayment = calculateFirstRepayment(loanCalculatorInput);
        repayments.add(currentRepayment);

        for (int i = 1; i <= loanCalculatorInput.getLeasePeriodInMonths().intValue(); i++) {

            previousRepayment = currentRepayment;
            currentRepayment = calculateNextRepayment(previousRepayment, loanCalculatorInput.getPaymentDate(), preciseInterest, monthlyPayment);
            repayments.add(currentRepayment);
        }

        return repayments;
    }

    private BigDecimal calculateMonthlyPayment(LoanCalculatorInput loanCalculatorInput, BigDecimal preciseInterest) {
        return LoanUtils.calculateMonthlyAnnuityPayment(
                loanCalculatorInput.getAssetPrice().subtract(new BigDecimal(loanCalculatorInput.getAdvancePaymentAmount())),
                BigDecimal.ZERO,
                preciseInterest,
                loanCalculatorInput.getLeasePeriodInMonths()
        );
    }

    private Repayment calculateFirstRepayment(LoanCalculatorInput loanCalculatorInput) {
        Repayment repayment = new Repayment();

        repayment.setRepaymentDate(DateUtils.dateToString(calcNextPaymentDate(loanCalculatorInput.getPaymentDate())));
        repayment.setRemainingAmountToRepay(loanCalculatorInput.getAssetPrice());
        repayment.setAssetValuePaymentAmount(new BigDecimal(loanCalculatorInput.getAdvancePaymentAmount()));
        repayment.setInterestPaymentAmount(BigDecimal.ZERO);
        repayment.setContractFee(new BigDecimal(loanCalculatorInput.getContractFee()));
        repayment.setTotalPaymentAmount(LoanUtils.calculateTotalPaymentAmount(repayment));

        return repayment;
    }

    private Repayment calculateNextRepayment(Repayment previousRepayment, BigDecimal paymentDate, BigDecimal leaseInterest, BigDecimal monthlyPayment) {
        Repayment repayment = new Repayment();

        repayment.setRepaymentDate(DateUtils.dateToString(calcNextPaymentDate(previousRepayment.getRepaymentDate(), paymentDate)));
        repayment.setRemainingAmountToRepay(LoanUtils.calculateRemainingAmountToRepay(previousRepayment.getRemainingAmountToRepay(),
                previousRepayment.getAssetValuePaymentAmount()));
        repayment.setInterestPaymentAmount(LoanUtils.calculateInterestAmount(repayment.getRemainingAmountToRepay(), leaseInterest));

        BigDecimal tempAssetValuePayment = LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, repayment.getInterestPaymentAmount());
        if (tempAssetValuePayment.compareTo(repayment.getRemainingAmountToRepay()) > 0) {
            repayment.setAssetValuePaymentAmount(repayment.getRemainingAmountToRepay());
        } else {
            repayment.setAssetValuePaymentAmount(tempAssetValuePayment);
        }

        repayment.setContractFee(BigDecimal.ZERO);
        repayment.setTotalPaymentAmount(LoanUtils.calculateTotalPaymentAmount(repayment));

        return repayment;
    }

    private Date calcNextPaymentDate(BigDecimal paymentDate) {
        Date date = DateUtils.getCurrentDate();
        date = DateUtils.addMonth(date);
        date = DateUtils.changeDayOfMonth(date, paymentDate);
        return date;
    }

    private Date calcNextPaymentDate(String lastDate, BigDecimal paymentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(lastDate);
        } catch (ParseException ignored) {
        }
        date = DateUtils.addMonth(date);
        date = DateUtils.changeDayOfMonth(date, paymentDate);
        return date;
    }

}
