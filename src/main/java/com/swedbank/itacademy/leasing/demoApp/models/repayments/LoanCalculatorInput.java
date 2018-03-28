package com.swedbank.itacademy.leasing.demoApp.models.repayments;

import java.math.BigDecimal;

public class LoanCalculatorInput {
    private String customerType;
    private BigDecimal assetPrice;
    private BigDecimal advancePaymentPercentage;
    private String advancePaymentAmount;
    private BigDecimal leasePeriodInMonths;
    private BigDecimal margin;
    private String contractFee;
    private BigDecimal paymentDate;
}
