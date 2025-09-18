package com.overlook.hotel.backend.model.classes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Tools {

    /**
     * converts dates from string YYYY-MM-DD to Date objects
     * @param dateToConvert date as a string
     * @return Date object
     */
    public static Date stringToDate(String dateToConvert){

        LocalDate localDate = LocalDate.parse(dateToConvert);
        Date convertedDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return convertedDate;
    }
}
