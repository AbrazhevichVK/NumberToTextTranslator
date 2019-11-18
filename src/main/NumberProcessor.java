package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class NumberProcessor {
    public static String getTranslatedNumberAsText(String inputNumber, Map<String, String> map) {
        String resultOfTranslating = new String();
        if (inputNumber.matches("0+")) {
            resultOfTranslating = map.get(String.valueOf(0));
        } else {
            var allTriadsFromInputNumber = getTriads(inputNumber);
            ArrayList<String> textValuesOfAllTriads = getTriadsFromNumberAsText(map, allTriadsFromInputNumber);
            Collections.reverse(textValuesOfAllTriads);

            for (String partOfResult : textValuesOfAllTriads) {
                if (partOfResult == null) {
                    resultOfTranslating += partOfResult;
                } else {
                    resultOfTranslating += partOfResult + " ";
                }
            }
            return resultOfTranslating.replace("null", "").trim();
        }
        return resultOfTranslating;
    }

    private static ArrayList<String> getTriadsFromNumberAsText(Map<String, String> map, ArrayList<Integer> allTriadsFromInputNumber) {

        int degreeOfCurrentTriad = 0;
        ArrayList<String> textValuesOfAllTriads = new ArrayList<>();
        for (int currentTriadFromInputNumber : allTriadsFromInputNumber) {
            String hungreedsText;
            String tensText;
            String onesText;
            degreeOfCurrentTriad++;
            int hungreeds = currentTriadFromInputNumber / 100 * 100;
            int tens = currentTriadFromInputNumber / 10 % 10 * 10;
            int ones = currentTriadFromInputNumber % 10;
            if (tens == 10 && ones > 0) {
                tens = 0;
                ones = 10 + ones;
            }
            if (hungreeds == 0) {
                hungreedsText = null;
            } else {
                hungreedsText = map.get(String.valueOf(hungreeds));
            }
            if (tens == 0) {
                tensText = null;
            } else {
                tensText = map.get(String.valueOf(tens));
            }
            if (ones == 0) {
                onesText = null;
            } else {
                onesText = map.get(String.valueOf(ones));
            }

            var endingOfLastNumber = getEndingOfNumber(ones, degreeOfCurrentTriad);
            var textValueOfCurrentTriad = hungreedsText + " " + tensText + " " + onesText + endingOfLastNumber;
            textValueOfCurrentTriad = textValueOfCurrentTriad.replace("null", "").trim();
            if (degreeOfCurrentTriad > 1) {
                var triadName = map.get(degreeOfCurrentTriad + "triad");
                var endOfDegree = getEndOfDegree(ones, degreeOfCurrentTriad);
                if (hungreedsText == null && tensText == null && onesText == null) {
                    textValueOfCurrentTriad = null;
                } else {
                    textValueOfCurrentTriad += " " + triadName + endOfDegree;
                }
            }
            textValuesOfAllTriads.add(textValueOfCurrentTriad);
        }

        return textValuesOfAllTriads;
    }

    private static ArrayList<Integer> getTriads(String inputNumber) {

        ArrayList<Integer> allTriadsFromInputNumber = new ArrayList<Integer>();
        allTriadsFromInputNumber = getStrPartsAsInt(inputNumber, 3);
        Collections.reverse(allTriadsFromInputNumber);
        return allTriadsFromInputNumber;
    }

    private static String getEndingOfNumber(int number, int degreeOfCurrentTriad) {
        if (degreeOfCurrentTriad == 2) {
            if (number == 1) {
                return "на";
            }
            if (number == 2) {
                return "е";
            }
        } else {
            if (number == 1) {
                return "ин";
            }
            if (number == 2) {
                return "а";
            }
        }
        return "";
    }

    private static String getEndOfDegree(int number, int degreeOfCurrentTriad) {
        if (degreeOfCurrentTriad == 2) {
            switch (number) {
                case 1:
                    return "а";
                case 2:
                    return "и";
                case 3:
                    return "и";
                case 4:
                    return "и";
                default:
                    return "";
            }
        }
        switch (number) {
            case 1:
                return "";
            case 2:
                return "а";
            case 3:
                return "а";
            case 4:
                return "а";
            default:
                return "ов";
        }
    }

    private static ArrayList<Integer> getStrPartsAsInt(String string, int partitionSize) {
        ArrayList<Integer> allTriadsFromInputNumber = new ArrayList<Integer>();
        int len = string.length();
        int remDiff = len % 3;
        if (remDiff != 0) {
            allTriadsFromInputNumber.add(Integer.parseInt(string.substring(0, remDiff)));
        }
        for (int i = remDiff; i < len; i += partitionSize) {
            allTriadsFromInputNumber.add(Integer.parseInt(string.substring(i, Math.min(len, i + partitionSize))));
        }
        return allTriadsFromInputNumber;
    }
}
