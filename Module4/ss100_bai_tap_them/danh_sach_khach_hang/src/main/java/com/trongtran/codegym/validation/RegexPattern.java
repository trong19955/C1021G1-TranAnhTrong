package com.trongtran.codegym.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {

    private static Pattern pattern;
    private static Matcher matcher;

    public static final String REGEX_CUSTOMER_ID = "^CUS-(\\d){4}$";
    public static final String REGEX_SERVICE_ID = "^SER-(\\d){4}$";
    public static final String REGEX_PHONE_NUMBER = "^(\\(84\\)\\+|0)(90|91)(\\d){7}$";
    public static final String REGEX_IDENTITY_NUMBER = "^((\\d){9}|(\\d){12})$";
    public static final String REGEX_TIME = "^(\\d){4}-(\\d){2}-(\\d){2}$";
    public static final String REGEX_POSITIVE_INTEGER = "^[1-9](\\d)*$";

    public static boolean validateDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        pattern = Pattern.compile(REGEX_TIME);
        matcher = pattern.matcher(dateOfBirth);
        boolean isRetry = false;

        if (!matcher.matches())
            isRetry = true;
        else {
            LocalDate birthday = LocalDate.parse(dateOfBirth,formatter);
            LocalDate after18Years = birthday.plusYears(18);
            LocalDate after100Years = birthday.plusYears(100);

            if (after18Years.isAfter(now) || after100Years.isBefore(now))
                isRetry = true;
        }

        return isRetry;
    }

    public static boolean validateDateContract(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean isRetry = false;

        pattern = Pattern.compile(REGEX_TIME);
        matcher = pattern.matcher(startDate);
        matcher = pattern.matcher(endDate);

        if (!matcher.matches())
            isRetry = true;
        else {
            LocalDate start = LocalDate.parse(startDate,formatter);
            LocalDate end = LocalDate.parse(endDate,formatter);

            if (start.isAfter(end))
                isRetry = true;
        }

        return isRetry;
    }

    public static boolean validateDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean isRetry = false;

        pattern = Pattern.compile(REGEX_TIME);
        matcher = pattern.matcher(date);

        if (!matcher.matches())
            isRetry = true;
        else {
            LocalDate now = LocalDate.now();
            LocalDate dateContract = LocalDate.parse(date,formatter);

            if (dateContract.isBefore(now))
                isRetry = true;
        }

        return isRetry;

    }

    public static boolean validatePositive(Double number) {
        return number > 0;
    }

    public static boolean validateIntegerPositive(Integer number) {
        return number > 0;
    }

}
