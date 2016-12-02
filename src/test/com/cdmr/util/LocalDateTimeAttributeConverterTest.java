package com.cdmr.util;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class LocalDateTimeAttributeConverterTest {
    LocalDateTimeAttributeConverter localDateTimeAttributeConverter = null;

    @Before
    public void setUp() throws Exception {
        localDateTimeAttributeConverter = new LocalDateTimeAttributeConverter();
    }

    @Test
    public void convertToDatabaseColumn() throws Exception {
        LocalDateTime locDateTime = LocalDateTime.now();
        Timestamp sqldatetime = localDateTimeAttributeConverter.convertToDatabaseColumn(locDateTime);
        assertNotNull("sql date time conversion failed", sqldatetime);

    }

    @Test
    public void convertToEntityAttribute() throws Exception {

        java.util.Date utilDate = new java.util.Date();


        LocalDateTime localDateTime = localDateTimeAttributeConverter.convertToEntityAttribute(new java.sql.Timestamp(utilDate.getTime()));
        assertNotNull("local date time conversion failed", localDateTime);

    }

}