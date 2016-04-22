package com.company.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public abstract class EmptyOperation implements Operation {
    private int operandCount = -1;
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
        operandList.clear();
        operandList.addAll(operands);
    }

    protected int getOperandCount() {
        return operandCount;
    }

    protected ArrayList<String> getOperandList() {
        return operandList;
    }

    protected void setOperandCount(int operandCount) {
        this.operandCount = operandCount;
    }

    protected String getOperand(int index) {
        return operandList.get(index);
    }
}
