package com.cdmr.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by student on 10/10/16.
 */
public class ConvertToLocalDateTime {

    public LocalDateTime formatDate (String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formatter = formatter.withLocale(Locale.US);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        return dateTime;

    }
}
