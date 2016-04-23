package com.company.calculator;

import org.junit.BeforeClass;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class NumberSubtractTest  extends NumberTest {
    @BeforeClass
    public static void setUp() throws Exception {
        numberOperation = new NumberSubtract();
    }

    @Override
    protected int calcIntExpected(int operand_1, int operand_2) {
        return operand_1 - operand_2;
    }

    @Override
    protected double calcDoubleExpected(double operand_1, double operand_2) {
        return operand_1 - operand_2;
    }
}