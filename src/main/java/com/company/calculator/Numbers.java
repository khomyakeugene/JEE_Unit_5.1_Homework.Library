package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class Numbers {
    public static double parseNumber(String s) {
        return Double.parseDouble(s);
    }

    public static boolean isDoubleOperation(int operandCount, List<String> operandList) {
        // If <operandCount> < 0, th count of operands will not be checked
        boolean result = (operandCount < 0) || (operandList.size() == operandCount);

        if (result) {
            // Try to parse each operand as Double
            try {
                operandList.stream().forEach(Numbers::parseNumber);
            } catch (NullPointerException | NumberFormatException e) {
                result = false;
            }
        }

        return result;
    }
}
