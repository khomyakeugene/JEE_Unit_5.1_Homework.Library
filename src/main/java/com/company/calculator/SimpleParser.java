package com.company.calculator;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Yevhen on 21.04.2016.
 */
public class SimpleParser implements Parser {
    private static final String IMPOSSIBLE_TO_RECOGNIZE_OPERATION_CODE_PATTERN =
            "It is impossible to recognize available operation code in the expression\n   \"%s\".\n" +
                    "Only such operation codes are known: %s";
    private static final String THERE_ARE_NO_OPERANDS_PATTERN =
            "There are no operands in the expression\n   \"%s\"";
    private static final String MORE_THAN_ONE_AVAILABLE_OPERATION_CODES_ARE_FOUND_PATTERN =
            "More than one available operation codes \"%s\" are found in the expression\n   \"%s\"";

    private static final char DEFAULT_DELIMITER = ' ';

    @Override
    public ParseResult parse(Set<String> operationCodeSet, String inputExpression, char delimiter) {
        // Get operand list as a List
        ArrayList<String> operandList = new ArrayList<>(Arrays.asList(inputExpression.split(Character.toString(delimiter))));
        // In case that <delimiter> is not space character and the leading and(or) trailing whitespace could be presented
        // in the inputExpression
        operandList.forEach(s -> s = s.trim());

        // Try to find operation by code in the <operandList>
        Stream<String> operationCodeStream = operationCodeSet.stream().filter(operandList::contains);
        final Optional<String> first = operationCodeStream.findFirst();
        // Check if available operation code is presented there (use the "first.isPresent()" to avoid
        // from corresponding inspection warning)
        String operationCode = first.isPresent() ? first.get() : null;
        // Firstly, <operator type> is not recognized
        OperatorType operatorType = OperatorType.NOT_RECOGNIZED;

        // If operation code is not found, ...
        if (operationCode == null) {
            // ... try to process operand list to search unary operator
            operationCodeStream = operandList.stream().filter(operand -> {
                final int operandLength = operand.length();
                return operationCodeSet.stream().filter(operation -> {
                    int index = operand.indexOf(operation);
                    // Unary operator can be present either in the beginning or in the end of operand
                    return (index == 0) || (index + operation.length()) == operandLength;
                }).count() > 1;
            });
        } else {
            // Try to detect <operator type>
            if (operandList.indexOf(operationCode) > 0) {
                operatorType = OperatorType.BINARY;
            }
            // Delete <operation code> from operands list
            operandList.remove(operationCode);
        }

        // Check that there should be only one available operation code
        if (operationCodeStream.count() > 1) {
            throw new IllegalArgumentException(String.format(MORE_THAN_ONE_AVAILABLE_OPERATION_CODES_ARE_FOUND_PATTERN,
                    Arrays.toString(operationCodeStream.toArray()), inputExpression));
        }

        // Check if operation code is presented
        if (operationCode == null) {
            throw new IllegalArgumentException(String.format(IMPOSSIBLE_TO_RECOGNIZE_OPERATION_CODE_PATTERN,
                    inputExpression, Arrays.toString(operationCodeSet.toArray())));
        }
        // Check if at least one operand is presented
        if (operandList.isEmpty()) {
            throw new IllegalArgumentException(String.format(THERE_ARE_NO_OPERANDS_PATTERN, inputExpression));
        }

        return new SimpleParseResult(operationCode, operatorType, operandList);
    }

    @Override
    public ParseResult parse(Set<String> operationCodeSet, String inputExpression) {
        return parse(operationCodeSet, inputExpression, DEFAULT_DELIMITER) ;
    }
}
