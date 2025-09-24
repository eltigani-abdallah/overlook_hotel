package com.overlook.hotel.helper;

import java.time.LocalDate;


public class Util {

    /**
     * converts dates from string YYYY-MM-DD to Date objects
     * @param dateToConvert date as a string
     * @return Date object
     */
    public static LocalDate stringToDate(String dateToConvert){

        LocalDate localDate = LocalDate.parse(dateToConvert);

        return localDate;
    }
}
