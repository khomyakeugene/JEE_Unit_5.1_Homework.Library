package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class NumberSubtract extends BinaryNumberOperation implements Operation {
    @Override
    public String execute() {
        return Double.toString(getDoubleOperand(0) - getDoubleOperand(1));
    }
}