package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class NumberAddition implements Operation {
    private final static int OPERANDS_COUNT = 2;

    @Override
    public void addOperand(String operand) {

    }

    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        return Numbers.isDoubleOperation(OPERANDS_COUNT, parseResult.operandList());
    }

    @Override
    public String execute() {
        return null;
    }
}
