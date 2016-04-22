package com.company.calculator;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class BinaryNumberOperation extends NumberOperation implements Operation {
    private final static int OPERANDS_COUNT = 2;

    public BinaryNumberOperation() {
        setOperandCount(OPERANDS_COUNT);
    }
}
