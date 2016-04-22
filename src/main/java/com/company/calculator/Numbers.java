package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class Numbers {
    public static boolean isDoubleOperation(int operandCount, List<String> operandList) {
        boolean result = operandList.size() == operandCount;
        if (result) {
            // Try to parse each operand as Double
            try {
                operandList.stream().forEach(Double::parseDouble);
            } catch (NullPointerException | NumberFormatException e) {
                result = false;
            }
        }

        return result;
    }
}
