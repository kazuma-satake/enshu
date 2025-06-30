package com.example.demo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLDetector {
    // SQLキーワードのパターン
    private static final String SQL_PATTERN = "\\b(SELECT|INSERT|UPDATE|DELETE|FROM|WHERE|AND|OR|JOIN)\\b";
    private static final Pattern pattern = Pattern.compile(SQL_PATTERN, Pattern.CASE_INSENSITIVE);

    public boolean containsSQL(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
