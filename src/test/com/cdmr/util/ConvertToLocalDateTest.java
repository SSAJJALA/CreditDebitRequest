package com.cdmr.util;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class ConvertToLocalDateTest {
    ConvertToLocalDate localDate = null;

    @Before
    public void setUp() throws Exception {
        localDate = new ConvertToLocalDate();

    }
    @Test
    public void formatDate() throws Exception {
        LocalDate date = localDate.formatDate("2016-12-01");
        assertNotNull("Unable to get local date", date);

    }

}