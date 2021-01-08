package com.serverless;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
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

        if (question.contains("which of the following numbers is the largest")) {

            LOG.info("Pasa numero");
            ArrayList<String> numbers = new ArrayList<String>();
            Matcher listNumbers = Pattern.compile("-?\\d+").matcher(question);
            while (m.find()) {
                numbers.add(matcher.group());
                LOG.info("Numero: " + matcher.group());
            }

            Collections.sort(numbers);

            LOG.info("Numeros: " + numbers);

            return numbers.get(numbers.size() - 1);
        }

        Matcher plusMatcher = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (plusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(plusMatcher.group(1)) + Integer.parseInt(plusMatcher.group(2)));
        }

        
        return teamName;
    }
}