package com.company.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public abstract class EmptyOperation implements Operation {
    private ArrayList<String> operandList = new ArrayList<>();

    @Override
    public abstract boolean isThisOperation(String inputExpression, ParseResult parseResult);

    @Override
    public abstract String execute();

    @Override
    public void addOperand(String operand) {
        operandList.add(operand);
    }

    @Override
    public void addOperands(List<String> operands) {
        operandList.addAll(operands);
    }

    protected ArrayList<String> getOperandList() {
        return operandList;
    }
}
