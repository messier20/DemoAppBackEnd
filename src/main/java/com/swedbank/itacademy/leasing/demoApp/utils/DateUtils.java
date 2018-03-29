package com.swedbank.itacademy.leasing.demoApp.utils;

import java.math.BigDecimal;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String dateToString(Date date) {
        //date to string in format: yyyy-mm-dd
        return "";
    }


    public static Date setPaymentDay(Date date, BigDecimal paymentDate) {
        if (paymentDate == = 15) {
            date.setDate(paymentDate);
            return date;
        } else if (date.getMonth() != 1) {
            date.setDate(paymentDate);
            return date;
        } else if (date.getFullYear() % 4 == 0) {
            date.setDate(29);
            return date;
        } else {
            date.setDate(28);
            return date;
        }
    }

    public static Date calcFirstPaymentDate(BigDecimal paymentDate) {
        Date date = getCurrentDate();
        date = addMonthToPaymentDate(date);
        date = setPaymentDay(date, paymentDate);
        return date;
    }

    public static Date calcNextPaymentDate(Date date, BigDecimal paymentDate) {
        date = addMonthToPaymentDate(date);
        date = setPaymentDay(date, paymentDate);
        return date;
    }

    public static Date addMonthToPaymentDate(Date date) {
        date.setMonth(date.getMonth() + 1);
        return date;
    }
}
