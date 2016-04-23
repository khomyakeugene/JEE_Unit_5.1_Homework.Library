package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public abstract class NumberOperation extends EmptyOperation implements Operation {
    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        return Numbers.isDoubleOperation(getOperandCount(), parseResult.operandList());
    }

    // Should be overridden in the descendant class
    protected abstract String calculate();

    @Override
    public final String execute() {
        return numberConversation(calculate());
    }

    public Double getDoubleOperand(int index) {
        return Double.parseDouble(getOperand(index));
    }

    private Class detectConversationClass() {
        // Suppose that <Long.class> is enough
        Class result = Long.class;
        // List of operands
        List<String> operandList = getOperandList();

        // Try to recognize <conversationClass> (just <Long> or <Double> only) which could be used further to convert
        // <calculation result> (see <numberConversation> method) to "corresponding" number-presentation;
        // it is important to not "use", if it would be possible, the fractional part.
        // Examine all the members of the <operandList>
        for (String operand : operandList) {
            if (result == Long.class) {
                // Try to use Long
                try {
                    Long.parseLong(operand);
                } catch (NullPointerException | NumberFormatException longException) {
                    // Try to use Double
                    try {
                        Double.parseDouble(operand);
                        result = Double.class;
                    } catch (NullPointerException | NumberFormatException doubleException) {
                        result = null;
                    }
                    break;
                }
            }
        }

        return result;
    }

    private String numberConversation(String number) {
        // To avoid to use the fractional part try to re-convert the result as integer (Long) if it is possible
        // Detect possible "minimum" number type of the "whole operation" and store in the field <conversationClass>
        if (detectConversationClass() == Long.class) {
            number = Long.toString((long)Double.parseDouble(number));
        }

        return number;
    }
}
