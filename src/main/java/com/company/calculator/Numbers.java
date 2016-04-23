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
                operandList.stream().forEach(Double::parseDouble);
            } catch (NullPointerException | NumberFormatException e) {
                result = false;
            }
        }

        return result;
    }

    public static Class detectConversationClass(String operand) {
        Class result;

        try {
            Long.parseLong(operand);
            result = Long.class;
        } catch (NullPointerException | NumberFormatException longException) {
            // Try to use Double
            try {
                Double.parseDouble(operand);
                result = Double.class;
            } catch (NullPointerException | NumberFormatException doubleException) {
                result = null;
            }
        }

        return result;
    }

    public static Class detectConversationClass(String[] operands) {
        // Suppose that <Long.class> is enough
        Class result = Long.class;

        // Try to recognize <conversationClass> (just <Long> or <Double> only) which could be used further to convert
        // <calculation result> (see <numberConversation> method) to "corresponding" number-presentation;
        // it is important to not "use", if it would be possible, the fractional part.
        // Examine all the members of the <operandList>
        for (String operand : operands) {
            result = Numbers.detectConversationClass(operand);
            if (result == null || result == Double.class) {
                break;
            }
        }

        return result;
    }

    public static String numberConversation(String number, String[] operands) {
        // Detect possible "minimum" number type of the "whole operation" and store in the field <conversationClass>
        if (detectConversationClass(operands) == Long.class) {
            // To avoid to use the fractional part try to re-convert the result as integer (Long) if it is possible
            number = Long.toString((long)Double.parseDouble(number));
        }

        return number;
    }
}
