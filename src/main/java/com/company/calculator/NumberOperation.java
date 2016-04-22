package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public abstract class NumberOperation extends EmptyOperation implements Operation {
    private static int operandCount = -1;

    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        return Numbers.isDoubleOperation(operandCount, parseResult.operandList());
    }

    public static void setOperandCount(int operandCount) {
        NumberOperation.operandCount = operandCount;
    }
}
