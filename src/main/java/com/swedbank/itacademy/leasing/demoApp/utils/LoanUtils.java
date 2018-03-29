package com.swedbank.itacademy.leasing.demoApp.utils;

import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;

import java.math.BigDecimal;
import java.util.Date;

public class LoanUtils {

    private static Repayment[] repaymentPlan;
    private static Repayment lastRepayment;
    private static Repayment repayment;
    private static Date lastDate;
    private static BigDecimal contractFee;
    private static BigDecimal margin;
    private static BigDecimal advancePaymentAmount;

    public static void calculateRepayments() {
        calculateFirstRepayment();
        addRepayment(repayment);
        lastRepayment = repayment;
        repayment = new Repayment();
        for (int i = 1; i <= leasingCalculator.leasePeriodInMonths; i++) {
            calculateNextRepayment();
            addRepayment(repayment);
            lastRepayment = repayment;
            repayment = new Repayment();
        }
    }

    private static void calculateFirstRepayment() {
        lastDate = DateUtils.calcFirstPaymentDate();
        repayment.setRepaymentDate(DateUtils.dateToString(lastDate));
        repayment.setRemainingAmountToRepay(leasingCalculator.assetPrice.toFixed(2));
        repayment.setAssetValuePaymentAmount(advancePaymentAmount.toFixed(2));
        repayment.setInterestPaymentAmount(Number(0).toFixed(2));
        repayment.setContractFee(leasingCalculator.contractFee);
        repayment.setTotalPaymentAmount((advancePaymentAmount+contractFee).toFixed(2));

    }

    private static void calculateNextRepayment() {
        lastDate = DateUtils.calcNextPaymentDate(lastDate, this.leasingCalculator.paymentDate);
        repayment.setRepaymentDate(DateUtils.dateToString(lastDate));
        repayment.setRemainingAmountToRepay((Number.parseFloat(lastRepayment.getRemainingAmountToRepay())
                - Number.parseFloat(lastRepayment.getAssetValuePaymentAmount())).toFixed(2));
        repayment.setAssetValuePaymentAmount();
        repayment.setInterestPaymentAmount();
        repayment.setContractFee("");
        repayment.setTotalPaymentAmount();
    }

    private static void addRepayment(Repayment repayment) {
        repaymentPlan[0] = repayment;
    }

}
