package com.cdmr.util;

import java.time.LocalDateTime;

/**
 * GetLocalDateTime gets the current date time in LocalDateTime format.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class GetLocalDateTime {

    /**
     * Method to get current local date and time
     * @return LocalDateTime local date and time
     */
    public LocalDateTime getCurrentDate () {
        return LocalDateTime.now();
    }
}
