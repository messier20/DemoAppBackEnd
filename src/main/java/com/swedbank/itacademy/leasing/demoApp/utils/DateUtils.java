package com.swedbank.itacademy.leasing.demoApp.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String dateToString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String yyyy = "" + cal.get(Calendar.YEAR);
        String mm, dd;
        if ((cal.get(Calendar.MONTH) + 1) < 10) {
            mm = "0" + (cal.get(Calendar.MONTH) + 1);
        } else {
            mm = "" + (cal.get(Calendar.MONTH) + 1);
        }
        if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
            dd = "0" + (cal.get(Calendar.DAY_OF_MONTH));
        } else {
            dd = "" + (cal.get(Calendar.DAY_OF_MONTH));
        }

        return yyyy + "-" + mm + "-" + dd;
    }

    public static Date changeDayOfMonth(Date date, BigDecimal paymentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (paymentDate.equals(new BigDecimal("15"))) {
            cal.set(Calendar.DAY_OF_MONTH, paymentDate.intValue());
            return cal.getTime();
        } else if (cal.get(Calendar.MONTH) != Calendar.FEBRUARY) {
            cal.set(Calendar.DAY_OF_MONTH, paymentDate.intValue());
            return cal.getTime();
        } else if (cal.get(Calendar.YEAR) % 4 == 0) {
            cal.set(Calendar.DAY_OF_MONTH, 29);
            return cal.getTime();
        } else {
            cal.set(Calendar.DAY_OF_MONTH, 28);
            return cal.getTime();
        }
    }

    public static Date addMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }
}
