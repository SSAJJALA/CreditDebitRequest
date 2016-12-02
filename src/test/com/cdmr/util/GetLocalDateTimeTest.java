package com.cdmr.util;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class GetLocalDateTimeTest {
    GetLocalDateTime currentDateTime = null;

    @Before
    public void setUp() throws Exception {
        currentDateTime = new GetLocalDateTime();
    }
    @Test
    public void getCurrentDate() throws Exception {
        LocalDateTime localDateTime = currentDateTime.getCurrentDate();
        assertNotNull("unable to get current date and time", localDateTime);
    }

}