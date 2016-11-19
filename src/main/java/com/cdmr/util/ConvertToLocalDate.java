package com.cdmr.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * ConvertToLocalDate converts a string date to local date format.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-09
 */
public class ConvertToLocalDate {

    /**
     * Method to convert string date to LocalDate
     * @param dob
     * @return LocalDate local date
     */
    public LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }
}
