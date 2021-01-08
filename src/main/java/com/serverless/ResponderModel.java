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
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Matcher listNumbers = Pattern.compile("-?\\d+").matcher(question);
            while (listNumbers.find()) {
                numbers.add(Integer.parseInt(listNumbers.group()));
                LOG.info("Numero: " + listNumbers.group());
            }

            int maxNumber = Collections.max(numbers);

            return String.valueOf(maxNumber);
        }

        Matcher plusMatcher = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (plusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(plusMatcher.group(1)) + Integer.parseInt(plusMatcher.group(2)));
        }

        Matcher multMatcher = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(question);
        if (multMatcher.matches()) {
            return String.valueOf(Integer.parseInt(multMatcher.group(1)) * Integer.parseInt(multMatcher.group(2)));
        }

        Matcher squareNumber = Pattern.compile(".* which of the following numbers is both a square and a cube: (\\d+), (\\d+)").matcher(question);
        if (squareNumber.matches()) {

            double sqrt=Math.sqrt(Integer.parseInt(squareNumber.group(1)));
            double cbrt=Math.cbrt(Integer.parseInt(squareNumber.group(1)));
            if((sqrt - Math.floor(sqrt)) == 0 && (cbrt - Math.floor(cbrt) == 0) ){
                return squareNumber.group(1);
            }else
            {
                return  squareNumber.group(2);
            }
        }

        return teamName;
    }
}