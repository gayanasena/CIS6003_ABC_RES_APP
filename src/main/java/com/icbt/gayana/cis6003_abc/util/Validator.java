package com.icbt.gayana.cis6003_abc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // Check if a string is not null and not empty
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validate phone number (example for 10-digit phone number)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }

    // Check if a number is within a certain range
    public static boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }


}
