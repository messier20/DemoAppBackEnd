package com.swedbank.itacademy.leasing.demoApp.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanUtils {

    public static BigDecimal calculateTotalPaymentAmount(BigDecimal assetValuePaymentAmount, BigDecimal interestPaymentAmount, BigDecimal contractFee) {
        return assetValuePaymentAmount.add(interestPaymentAmount.add(contractFee));
    }

    public static BigDecimal calculateMonthlyAnnuityPayment(BigDecimal leasePresentValue, BigDecimal leaseFutureValue, BigDecimal leaseInterest, BigDecimal leasePeriods) {
        BigDecimal numerator = leasePresentValue.subtract(leaseFutureValue
                .divide(BigDecimal.ONE.add(leaseInterest).pow(leasePeriods.intValue()), 20, RoundingMode.HALF_UP));
        BigDecimal denominator = BigDecimal.ONE.subtract(BigDecimal.ONE
                .divide(BigDecimal.ONE.add(leaseInterest).pow(leasePeriods.intValue()), 20, RoundingMode.HALF_UP))
                .divide(leaseInterest, 20, RoundingMode.HALF_UP);
        return numerator.divide(denominator, 20, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateInterestAmount(BigDecimal remainingAmountToRepay, BigDecimal leaseInterest) {
        return remainingAmountToRepay.multiply(leaseInterest).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateAssetValuePaymentAmount(BigDecimal monthlyPayment, BigDecimal interestPaymentAmount) {
        return monthlyPayment.subtract(interestPaymentAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateRemainingAmountToRepay(BigDecimal remainingAmountToRepay, BigDecimal assetValuePayment) {
        return remainingAmountToRepay.subtract(assetValuePayment).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculatePreciseInterest(BigDecimal margin, BigDecimal periodsPerYear) {
        return margin.divide(new BigDecimal("100"), 20, RoundingMode.HALF_UP)
                .divide(periodsPerYear, 20, RoundingMode.HALF_UP).setScale(8, RoundingMode.HALF_UP);
    }
}
