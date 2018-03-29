package com.swedbank.itacademy.leasing.demoApp.utils;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class LoanUtilsTest {
    private BigDecimal assetValuePaymentAmount;
    private BigDecimal interestPaymentAmount;
    private BigDecimal leaseInterest;
    private BigDecimal periodsPerYear;
    private BigDecimal remainingAmountToRepay;

    @Before
    public void setUp() throws Exception {
        this.periodsPerYear = new BigDecimal("12");
    }

    @Test
    public void calculateTotalPaymentAmount() throws Exception {

        this.assetValuePaymentAmount = new BigDecimal("1000");
        this.interestPaymentAmount = new BigDecimal("100");
        BigDecimal contractFee = new BigDecimal("200");
        assertEquals(LoanUtils.calculateTotalPaymentAmount(assetValuePaymentAmount, interestPaymentAmount, contractFee),
                new BigDecimal("1300"));

        this.assetValuePaymentAmount = new BigDecimal("15000");
        this.interestPaymentAmount = BigDecimal.ZERO;
        contractFee = new BigDecimal("200");
        assertEquals(LoanUtils.calculateTotalPaymentAmount(assetValuePaymentAmount, interestPaymentAmount, contractFee),
                new BigDecimal("15200"));

        this.assetValuePaymentAmount = new BigDecimal("11000");
        this.interestPaymentAmount = new BigDecimal("1000");
        contractFee = new BigDecimal("0");
        assertEquals(LoanUtils.calculateTotalPaymentAmount(assetValuePaymentAmount, interestPaymentAmount, contractFee),
                new BigDecimal("12000"));
    }

    @Test
    public void calculateMonthlyAnnuityPayment() throws Exception {

        BigDecimal leasePresentValue = new BigDecimal("3500");
        BigDecimal leaseFutureValue = new BigDecimal("1000");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("9"), periodsPerYear);
        BigDecimal leasePeriods = new BigDecimal("24");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("121.71"));

        leasePresentValue = new BigDecimal("15000");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("4"), periodsPerYear);
        leasePeriods = new BigDecimal("36");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("442.86"));

        leasePresentValue = new BigDecimal("999999");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("7"), periodsPerYear);
        leasePeriods = new BigDecimal("72");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("17048.99"));

        leasePresentValue = new BigDecimal("543254");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("11"), periodsPerYear);
        leasePeriods = new BigDecimal("54");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("12799.87"));
    }

    @Test
    public void calculateInterestAmount() throws Exception {
        this.remainingAmountToRepay = new BigDecimal("10000");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("9"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("75.00"));

        this.remainingAmountToRepay = new BigDecimal("12345");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("4"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("41.15"));

        this.remainingAmountToRepay = new BigDecimal("323222");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("3.2"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("861.93"));

    }

    @Test
    public void calculateAssetValuePaymentAmount() throws Exception {

        BigDecimal monthlyPayment = new BigDecimal("1000");
        this.interestPaymentAmount = new BigDecimal("400");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("600.00"));

        monthlyPayment = new BigDecimal("12345.23");
        this.interestPaymentAmount = new BigDecimal("333.33");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("12011.90"));

        monthlyPayment = new BigDecimal("1111");
        this.interestPaymentAmount = new BigDecimal("1111");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("0.00"));

    }

    @Test
    public void calculateRemainingAmountToRepay() throws Exception {

        this.remainingAmountToRepay = new BigDecimal("1000");
        this.assetValuePaymentAmount = new BigDecimal("123");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("877.00"));

        this.remainingAmountToRepay = new BigDecimal("1000");
        this.assetValuePaymentAmount = new BigDecimal("1000");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("0.00"));

        this.remainingAmountToRepay = new BigDecimal("1000.33");
        this.assetValuePaymentAmount = new BigDecimal("123.12");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("877.21"));

    }

    @Test
    public void calculatePreciseInterest() throws Exception {

        BigDecimal margin = new BigDecimal("3");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.0025).setScale(8, RoundingMode.HALF_UP));

        margin = new BigDecimal("3.2");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.00266667).setScale(8, RoundingMode.HALF_UP));

        margin = new BigDecimal("100");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.08333333).setScale(8, RoundingMode.HALF_UP));
    }

}