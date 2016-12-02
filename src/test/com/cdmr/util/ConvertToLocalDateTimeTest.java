package com.cdmr.util;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class ConvertToLocalDateTimeTest {

    ConvertToLocalDateTime localDateTime = null;

    @Before
    public void setUp() throws Exception {
        localDateTime = new ConvertToLocalDateTime();
    }

    @Test
    public void formatDate() throws Exception {

        LocalDateTime dateTime = localDateTime.formatDate("2016-12-01 10:15:00");
        assertNotNull("Unable to fetch local date time", dateTime);
    }

}