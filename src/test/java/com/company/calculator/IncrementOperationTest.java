package com.company.calculator;

import org.junit.BeforeClass;

/**
 * Created by Yevhen on 24.04.2016.
 */
public class IncrementOperationTest extends NumberTest  {
    @BeforeClass
    public static void setUpClass() throws Exception {
        numberOperation = new IncrementOperation();
    }

    @Override
    protected double calcExpected(double operand_1, double operand_2) {
        return (long)operand_1 + 1;
    }
}