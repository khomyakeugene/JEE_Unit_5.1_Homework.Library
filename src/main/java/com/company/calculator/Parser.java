package com.company.calculator;

import java.util.Set;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface Parser {
    /**
     *
     *
     * @param operations - list of the string representative available operations
     * @param inputExpression - simple algebraic formula like "3 + 6"
     * @param delimiter - delimiter between <b>operands </b> and and between <b>operands</b> and <b>operation</b>
     * @return {@link com.company.calculator.ParseResult}-object contained string which represents "name" of <b>operation</b>
     * and {@link java.util.List}-list of String-presented <b>operands</b>
     *
     */
    ParseResult parse(Set<String> operations, String inputExpression, char delimiter);

    /**
     *
     *
     * @param operations - list of the string representative available operations
     * @param inputData - simple algebraic formula like "3 + 6"
     * @return {@link com.company.calculator.ParseResult}-object contained string which represents "name" of <b>operation</b>
     * and {@link java.util.List}-list of String-presented <b>operands</b>
     *
     * This method is using <i>default</i> delimiter defined by developer
     *
     */
    ParseResult parse(Set<String> operations, String inputData);
}
