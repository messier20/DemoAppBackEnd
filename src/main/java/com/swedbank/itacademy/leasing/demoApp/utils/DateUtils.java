package com.swedbank.itacademy.leasing.demoApp.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
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
