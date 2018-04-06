package com.swedbank.itacademy.leasing.demoApp.utils;

import com.swedbank.itacademy.leasing.demoApp.constants.RepaymentRounding;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanUtils implements RepaymentRounding{


    public static BigDecimal calculateTotalPaymentAmount(Repayment repayment) {
        return repayment.getAssetValuePaymentAmount().add(repayment.getInterestPaymentAmount());
    }

    public static BigDecimal calculateMonthlyAnnuityPayment(BigDecimal leasePresentValue, BigDecimal leaseFutureValue, BigDecimal leaseInterest, BigDecimal leasePeriods) {
        BigDecimal numerator = leasePresentValue.subtract(leaseFutureValue
                .divide(BigDecimal.ONE.add(leaseInterest).pow(leasePeriods.intValue()), DIVISION_SCALE, RoundingMode.HALF_UP));
        BigDecimal denominator = BigDecimal.ONE.subtract(BigDecimal.ONE
                .divide(BigDecimal.ONE.add(leaseInterest).pow(leasePeriods.intValue()), DIVISION_SCALE, RoundingMode.HALF_UP))
                .divide(leaseInterest, DIVISION_SCALE, RoundingMode.HALF_UP);
        return numerator.divide(denominator, DIVISION_SCALE, RoundingMode.HALF_UP).setScale(DECIMALS, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateInterestAmount(BigDecimal remainingAmountToRepay, BigDecimal leaseInterest) {
        return remainingAmountToRepay.multiply(leaseInterest).setScale(DECIMALS, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateAssetValuePaymentAmount(BigDecimal monthlyPayment, BigDecimal interestPaymentAmount) {
        return monthlyPayment.subtract(interestPaymentAmount).setScale(DECIMALS, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateRemainingAmountToRepay(BigDecimal remainingAmountToRepay, BigDecimal assetValuePayment) {
        return remainingAmountToRepay.subtract(assetValuePayment).setScale(DECIMALS, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculatePreciseInterest(BigDecimal margin, BigDecimal periodsPerYear) {
        return margin.divide(new BigDecimal("100"), DIVISION_SCALE, RoundingMode.HALF_UP)
                .divide(periodsPerYear, DIVISION_SCALE, RoundingMode.HALF_UP).setScale(INTEREST_DECIMALS, RoundingMode.HALF_UP);
    }
}
