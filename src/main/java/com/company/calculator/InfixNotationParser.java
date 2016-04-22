package com.company.calculator;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Yevhen on 21.04.2016.
 */
public class InfixNotationParser implements Parser {
    private static final String IMPOSSIBLE_TO_RECOGNIZE_OPERATION_CODE_PATTERN =
            "It is impossible to recognize available operation code in the expression\n   \"%s\".\n" +
                    "Only such operation codes are known: %s";
    private static final String THERE_ARE_NO_OPERANDS_PATTERN =
            "There are no operands in the expression\n   \"%s\"";
    private static final String MORE_THAN_ONE_AVAILABLE_OPERATION_CODES_ARE_FOUND_PATTERN =
            "More than one available operation codes \"%s\" are found in the expression\n   \"%s\"";

    private static final char DEFAULT_DELIMITER = ' ';

    @Override
    public ParseResult parse(Set<String> operationCodes, String inputExpression, char delimiter) {
        // Get operand list as a List
        ArrayList<String> operandList = new ArrayList<>(Arrays.asList(inputExpression.split(Character.toString(delimiter))));
        // In case that <delimiter> is not space character and the leading and(or) trailing whitespace could be presented
        // in the inputExpression
        operandList.forEach(s -> s = s.trim());

        // Try to find operation by code in the <operandList>
        final Stream<String> stringStream = operationCodes.stream().filter(operandList::contains);
        final Optional<String> first = stringStream.findFirst();
        // Check if available operation code is presented there (use the "first.isPresent()" to avoid
        // from corresponding inspection warning)
        String operationCode = first.isPresent() ? first.get() : null;
        // Firstly, <operator type> is not recognized
        OperatorType operatorType = OperatorType.NOT_RECOGNIZED;

        // If operation code is not found, ...
        if (operationCode == null) {
            // ... try to process operands to search unary operator
        } else {
            // Check that there should be only one available operation code
            if (stringStream.count() > 1) {
                throw new IllegalArgumentException(String.format(MORE_THAN_ONE_AVAILABLE_OPERATION_CODES_ARE_FOUND_PATTERN,
                        Arrays.toString(stringStream.toArray()), inputExpression));
            }
            // Try to detect <operator type>
            if (operandList.indexOf(operationCode) > 0) {
                operatorType = OperatorType.BINARY;
            }
            // Delete <operation code> from operands list
            operandList.remove(operationCode);
        }

        // Check if operation code is presented
        if (operationCode == null) {
            throw new IllegalArgumentException(String.format(IMPOSSIBLE_TO_RECOGNIZE_OPERATION_CODE_PATTERN,
                    inputExpression, Arrays.toString(operationCodes.toArray())));
        }
        // Check if at least one operand is presented
        if (operandList.isEmpty()) {
            throw new IllegalArgumentException(String.format(THERE_ARE_NO_OPERANDS_PATTERN, inputExpression));
        }

        return new SimpleParseResult(operationCode, operatorType, operandList);
    }

    @Override
    public ParseResult parse(Set<String> operations, String inputExpression) {
        return parse(operations, inputExpression, DEFAULT_DELIMITER) ;
    }
}
