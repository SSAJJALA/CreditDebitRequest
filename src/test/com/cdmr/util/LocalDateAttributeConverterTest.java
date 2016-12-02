package com.cdmr.util;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


import static org.junit.Assert.*;

/**
 * Created by student on 12/1/16.
 */
public class LocalDateAttributeConverterTest {
    LocalDateAttributeConverter localDateConverted = null;
    @Test
    public void convertToDatabaseColumn() throws Exception {
        localDateConverted = new LocalDateAttributeConverter();
    }

    @Test
    public void convertToEntityAttribute() throws Exception {
        Date sqldate = localDateConverted.convertToDatabaseColumn(LocalDate.now());

        /**
        Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        Date sqlDate = new Date(utilDate.getTime());

        LocalDate localDate = localDateConverted.convertToEntityAttribute(sqlDate);

        assertNotNull("local date conversion failed", localDate);
         **/
        assertNotNull("sql date conversion failed", sqldate);

    }

}