package com.swedbank.itacademy.leasing.demoApp.constants;

import java.math.BigDecimal;

public interface CustomerConstants {
    BigDecimal minEnginePower = new BigDecimal(1);
    BigDecimal maxEnginePower = new BigDecimal(9999);
    BigDecimal minPrivateAssetPrice = new BigDecimal(5000);
    BigDecimal minBusinessAssetPrice = new BigDecimal(10000);
    BigDecimal maxAssetPrice = new BigDecimal(9999999);
    BigDecimal minAdvancePaymentPercentage = new BigDecimal(10);
    BigDecimal maxAdvancePaymentPercentage = new BigDecimal(100);
    BigDecimal minMargin = new BigDecimal(3.2);
    BigDecimal maxMargin = new BigDecimal(100);
}
