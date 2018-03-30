package com.swedbank.itacademy.leasing.demoApp.utils;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {
    private Date date;

    @Before
    public void setUp() throws Exception {
        this.date = new Date();
    }

    @Test
    public void dateToString() throws Exception {
        assertEquals(DateUtils.dateToString(date), "2018-03-29");
    }

    @Test
    public void changeDayOfMonth() throws Exception {
        Date testDate = DateUtils.changeDayOfMonth(date, new BigDecimal("15"));
        assertEquals(DateUtils.dateToString(testDate), "2018-03-15");
    }

    @Test
    public void addMonth() throws Exception {
        Date testDate = DateUtils.addMonth(date);
        assertEquals(DateUtils.dateToString(testDate), "2018-04-29");
    }

}