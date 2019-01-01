package com.rissandimo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil
{
    private static final String DATE_FORMATTER = "MM.dd.yyyy";

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    public static LocalDate stringDateToLocalDate(String dateString)
    {
        return LocalDate.parse(dateString, dateTimeFormatter);
    }

    public static String localDatetoStringDate(LocalDate localDate)
    {
        return dateTimeFormatter.format(localDate);
    }
}
