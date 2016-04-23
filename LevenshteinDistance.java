package marathidocumentcorrector;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevenshteinDistance {

    public static int computeEditDistance(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

    public static Map<String, Double> printDistance(String Source1, String  Source2) {

  
            String s1 = Source1;
            String Data = Source2;
            String s2 = Data;
            double similarityOfStrings = 0.0;
            int editDistance = 0;
            if (s1.length() < s2.length()) {
                String swap = s1;
                s1 = s2;
                s2 = swap;
            }
            int bigLen = s1.length();
            editDistance = computeEditDistance(s1, s2);
            if (bigLen == 0) {
                similarityOfStrings = 1.0;
            } else {
                similarityOfStrings = (bigLen - editDistance) / (double) bigLen;
            }
            double result = similarityOfStrings * 100;
            DecimalFormat newFormat = new DecimalFormat("#.##");
            double twoDecimal = Double.valueOf(newFormat.format(result));
            System.out.println(Source + "+++" + Data + ">>>>" + twoDecimal);
        return twoDecimal;
    }
}
