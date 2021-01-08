package com.serverless;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "LosMilagrosos";

    private static final Logger LOG = Logger.getLogger(Handler.class);

    public String answer(String question) {

        if ("".equals(question)){
            return teamName;
        }

        Matcher matcher = Pattern.compile(".*what is your name").matcher(question);
        if (matcher.matches()) {
            return teamName;
        }

        Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
        if (sumMatcher.matches()) {
            return String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
        }

        Matcher largestMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);
        if (largestMatcher.matches()) {
            if(Integer.parseInt(largestMatcher.group(1)) >= Integer.parseInt(largestMatcher.group(2))){
                return largestMatcher.group(1);
            }
            return largestMatcher.group(2);
        }

        Matcher plusMatcher = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (plusMatcher.matches()) {
            LOG.info("**MESSAGE**: " + plusMatcher.group(1));
            LOG.info("**MESSAGE**: " + plusMatcher.group(2));
            return String.valueOf(Integer.parseInt(plusMatcher.group(1)) + Integer.parseInt(plusMatcher.group(2)));
        }

        
        return teamName;
    }
}