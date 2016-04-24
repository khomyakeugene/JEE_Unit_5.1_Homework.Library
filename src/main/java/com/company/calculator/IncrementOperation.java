package com.company.calculator;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class IncrementOperation extends UnaryIntegerOperation implements Operation {
    @Override
    protected String calculate() {
        return Long.toString(getIntegerOperand(0)+1);
    }
}
