package com.company.calculator;

import org.junit.BeforeClass;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class NumberAdditionTest extends NumberTest {
    @BeforeClass
    public static void setUpClass() throws Exception {
        numberOperation = new NumberAddition();
    }

    @Override
    protected double calcExpected(double operand_1, double operand_2) {
        return operand_1 + operand_2;
    }
}