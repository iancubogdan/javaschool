package com.db.javaschool.springdata.jdbc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRules {
    public static Boolean validate(String password) {
        final String regEx = "^(?!.*123).*(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{12,}$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(validate("Strong1Password")); // Strong password
        System.out.println(validate("strong1password")); // Weak password
    }
}