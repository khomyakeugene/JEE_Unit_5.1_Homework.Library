package com.company.calculator;

import java.util.Set;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface Parser {
    /**
     *
     *
     * @param operationCodes - list of the string representative of codes (like "+", "-", "sqrt" etc.) of available operations
     * @param inputExpression - simple algebraic formula like "3 + 6"
     * @param delimiter - delimiter between <b>operands </b> and and between <b>operands</b> and <b>operationCode</b>
     * @return {@link com.company.calculator.ParseResult}-object contained string which represents "code" of <b>operationCode</b>
     * and {@link java.util.List}-list of String-presented <b>operands</b>
     *
     * Parses <b>inputExpression</b> to split to operands with checking if the available operationCode code is presented there
     * Throws exception if it is impossible to recognize the operationCode
     *
     */
    ParseResult parse(Set<String> operationCodes, String inputExpression, char delimiter);

    /**
     *
     *
     * @param operations - list of the string representative available operations
     * @param inputExpression - simple algebraic formula like "3 + 6"
     * @return {@link com.company.calculator.ParseResult}-object contained string which represents "name" of <b>operationCode</b>
     * and {@link java.util.List}-list of String-presented <b>operands</b>
     *
     * This method is using <i>default</i> delimiter defined by developer
     *
     */
    ParseResult parse(Set<String> operations, String inputExpression);
}
