package com.serverless;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "LosMilagrosos";

    public String answer(String question) {

        if ("".equals(question)){
            return teamName;
        }

        Matcher matcher = Pattern.compile(".*what is your name").matcher(question);
        if (matcher.matches()) {
            return teamName;
        }

        matcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
        if (matcher.matches()) {
            return String.valueOf(Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(2)));
        }

        matcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);
        if (matcher.matches()) {
            if(Integer.parseInt(matcher.group(1)) >= Integer.parseInt(matcher.group(2))){
                return matcher.group(1);
            }
            return matcher.group(2);
        }
        
        return teamName;
    }
}