package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public abstract class NumberOperation extends EmptyOperation implements Operation {
    @Override
    public boolean isThisOperation(String inputExpression, ParseResult parseResult) {
        return Numbers.isDoubleOperation(getOperandCount(), parseResult.operandList());
    }

    protected Double getDoubleOperand(int index) {
        return Double.parseDouble(getOperand(index));
    }
}
