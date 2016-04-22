package com.company.calculator;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface Operation {
    void addOperand(String operand);

    boolean isThisOperation(String inputExpression, ParseResult parseResult);

    String execute();
}

