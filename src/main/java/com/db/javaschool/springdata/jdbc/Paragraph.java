package com.db.javaschool.springdata.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    public static String changeDateFormat(String paragraph) {
        final String regEx = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}";

        final String oldFormat = "MM/dd/yyyy";
        final String newFormat = "dd/MM/yyyy";

        StringBuffer result = new StringBuffer();
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(paragraph);
        try {
            while (matcher.find()) {
                String date = matcher.group();

                SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
                Date date1 = sdf.parse(date);
                sdf.applyPattern(newFormat);
                String newDate = sdf.format(date1);
                matcher.appendReplacement(result, newDate);
            }
            matcher.appendTail(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeDateFormat("Last time it rained was on 07/25/2013 and today is 08/09/2013."));
    }
}