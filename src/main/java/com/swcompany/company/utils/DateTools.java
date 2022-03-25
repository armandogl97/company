package com.swcompany.company.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

    public static final SimpleDateFormat DB_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static int returnYear(String sDate) {
        try {
            Date date = DB_FORMAT.parse(sDate);
            return Integer.parseInt(sDate.substring(0,3));
        } catch (ParseException e) {
            throw new NullPointerException();
        }
    }

}