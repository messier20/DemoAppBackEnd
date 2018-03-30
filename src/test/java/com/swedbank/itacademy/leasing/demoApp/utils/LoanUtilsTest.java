package com.swedbank.itacademy.leasing.demoApp.utils;

import com.swedbank.itacademy.leasing.demoApp.constants.RepaymentRounding;
import com.swedbank.itacademy.leasing.demoApp.models.repayments.Repayment;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class LoanUtilsTest implements RepaymentRounding{
    private BigDecimal leaseInterest;
    private BigDecimal periodsPerYear;
    private BigDecimal remainingAmountToRepay;

    @Before
    public void setUp() throws Exception {
        this.periodsPerYear = new BigDecimal("12");
    }

    @Test
    public void calculateTotalPaymentAmount() throws Exception {
        Repayment repayment = new Repayment();
        repayment.setAssetValuePaymentAmount(new BigDecimal("1000"));
        repayment.setInterestPaymentAmount(new BigDecimal("100"));
        repayment.setContractFee(new BigDecimal("200"));
        assertEquals(LoanUtils.calculateTotalPaymentAmount(repayment),
                new BigDecimal("1300"));

        repayment = new Repayment();
        repayment.setAssetValuePaymentAmount(new BigDecimal("15000"));
        repayment.setInterestPaymentAmount(BigDecimal.ZERO);
        repayment.setContractFee(new BigDecimal("200"));
        assertEquals(LoanUtils.calculateTotalPaymentAmount(repayment),
                new BigDecimal("15200"));

        repayment = new Repayment();
        repayment.setAssetValuePaymentAmount(new BigDecimal("11000"));
        repayment.setInterestPaymentAmount(new BigDecimal("1000"));
        repayment.setContractFee(new BigDecimal("0"));
        assertEquals(LoanUtils.calculateTotalPaymentAmount(repayment),
                new BigDecimal("12000"));
    }

    @Test
    public void calculateMonthlyAnnuityPayment() throws Exception {

        BigDecimal leasePresentValue = new BigDecimal("3500");
        BigDecimal leaseFutureValue = new BigDecimal("1000");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("9"), periodsPerYear);
        BigDecimal leasePeriods = new BigDecimal("24");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("121.7119"));

        leasePresentValue = new BigDecimal("15000");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("4"), periodsPerYear);
        leasePeriods = new BigDecimal("36");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("442.8598"));

        leasePresentValue = new BigDecimal("999999");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("7"), periodsPerYear);
        leasePeriods = new BigDecimal("72");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("17048.9894"));

        leasePresentValue = new BigDecimal("543254");
        leaseFutureValue = BigDecimal.ZERO;
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("11"), periodsPerYear);
        leasePeriods = new BigDecimal("54");
        assertEquals(LoanUtils.calculateMonthlyAnnuityPayment(leasePresentValue, leaseFutureValue, leaseInterest, leasePeriods),
                new BigDecimal("12799.8723"));
    }

    @Test
    public void calculateInterestAmount() throws Exception {
        this.remainingAmountToRepay = new BigDecimal("10000");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("9"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("75").setScale(DECIMALS, RoundingMode.HALF_UP));

        this.remainingAmountToRepay = new BigDecimal("12345");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("4"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("41.15").setScale(DECIMALS, RoundingMode.HALF_UP));

        this.remainingAmountToRepay = new BigDecimal("323222");
        this.leaseInterest = LoanUtils.calculatePreciseInterest(new BigDecimal("3.2"), periodsPerYear);
        assertEquals(LoanUtils.calculateInterestAmount(remainingAmountToRepay, leaseInterest), new BigDecimal("861.9253").setScale(DECIMALS, RoundingMode.HALF_UP));

    }

    @Test
    public void calculateAssetValuePaymentAmount() throws Exception {

        BigDecimal monthlyPayment = new BigDecimal("1000");
        BigDecimal interestPaymentAmount = new BigDecimal("400");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("600").setScale(DECIMALS, RoundingMode.HALF_UP));

        monthlyPayment = new BigDecimal("12345.23");
        interestPaymentAmount = new BigDecimal("333.33");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("12011.9").setScale(DECIMALS, RoundingMode.HALF_UP));

        monthlyPayment = new BigDecimal("1111");
        interestPaymentAmount = new BigDecimal("1111");
        assertEquals(LoanUtils.calculateAssetValuePaymentAmount(monthlyPayment, interestPaymentAmount), new BigDecimal("0").setScale(DECIMALS, RoundingMode.HALF_UP));

    }

    @Test
    public void calculateRemainingAmountToRepay() throws Exception {

        this.remainingAmountToRepay = new BigDecimal("1000");
        BigDecimal assetValuePaymentAmount = new BigDecimal("123");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("877").setScale(DECIMALS, RoundingMode.HALF_UP));

        this.remainingAmountToRepay = new BigDecimal("1000");
        assetValuePaymentAmount = new BigDecimal("1000");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("0").setScale(DECIMALS, RoundingMode.HALF_UP));

        this.remainingAmountToRepay = new BigDecimal("1000.33");
        assetValuePaymentAmount = new BigDecimal("123.12");
        assertEquals(LoanUtils.calculateRemainingAmountToRepay(remainingAmountToRepay, assetValuePaymentAmount), new BigDecimal("877.21").setScale(DECIMALS, RoundingMode.HALF_UP));

    }

    @Test
    public void calculatePreciseInterest() throws Exception {

        BigDecimal margin = new BigDecimal("3");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.0025).setScale(INTEREST_DECIMALS, RoundingMode.HALF_UP));

        margin = new BigDecimal("3.2");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.0026666667).setScale(INTEREST_DECIMALS, RoundingMode.HALF_UP));

        margin = new BigDecimal("100");
        assertEquals(LoanUtils.calculatePreciseInterest(margin, periodsPerYear), new BigDecimal(0.0833333333).setScale(INTEREST_DECIMALS, RoundingMode.HALF_UP));
    }

}