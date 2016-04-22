package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class NumberOperation implements Operation {
    private static int operandCount = -1;

    @Override
    public void addOperand(String operand) {

    }

    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        return Numbers.isDoubleOperation(operandCount, parseResult.operandList());
    }

    @Override
    public String execute() {
        return null;
    }

    public static void setOperandCount(int operandCount) {
        NumberOperation.operandCount = operandCount;
    }
}
