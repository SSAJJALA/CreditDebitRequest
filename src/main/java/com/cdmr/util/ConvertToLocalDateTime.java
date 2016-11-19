package com.cdmr.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * ConvertToLocalDateTime converts a string date to local datetime format.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-10
 */
public class ConvertToLocalDateTime {

    /**
     * Method to convert string date to LocalDateTime
     * @param dateTimeString
     * @return LocalDateTime local date and time
     */
    public LocalDateTime formatDate (String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formatter = formatter.withLocale(Locale.US);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        return dateTime;

    }
}
