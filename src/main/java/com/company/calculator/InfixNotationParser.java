package com.company.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Yevhen on 21.04.2016.
 */
public class InfixNotationParser implements Parser {
    private static final char DEFAULT_DELIMITER = ' ';

    @Override
    public ParseResult parse(Set<String> operations, String inputData, char delimiter) {
        //
        ArrayList<String> operandsList = new ArrayList<>(Arrays.asList(inputData.split(Character.toString(delimiter))));
        // In case that <delimiter> is not space character and the leading and(or) trailing whitespace could be presented
        // in the inputData
        operandsList.forEach(s -> {s = s.trim();});

        // Try to find operation by code in the <operandsList>
        operandsList.stream().


        return null;
    }

    @Override
    public ParseResult parse(Set<String> operations, String inputData) {
        return parse(operations, inputData, DEFAULT_DELIMITER) ;
    }
}
