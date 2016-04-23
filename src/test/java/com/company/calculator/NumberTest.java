package com.company.calculator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 23.04.2016.
 */
public abstract class NumberTest {
    private final static int ATTEMPT_COUNT = 10;
    protected static NumberOperation numberOperation;

    protected abstract int calcIntExpected(int operand_1, int  operand_2);

    protected abstract double calcDoubleExpected(double operand_1, double  operand_2);


    private void executeDoubleTest() throws Exception {
        double operand_1 = Util.getRandomDoubleValue();
        double operand_2 = Util.getRandomDoubleValue();

        ArrayList<String> operands = new ArrayList<>();
        operands.add(Double.toString(operand_1));
        operands.add(Double.toString(operand_2));
        numberOperation.setOperands(operands);

        assertEquals(Double.toString(calcDoubleExpected(operand_1, operand_2)), numberOperation.execute());
    }

    private void executeIntegerTest() throws Exception {
        int operand_1 = Util.getRandomInteger();
        int operand_2 = Util.getRandomInteger();

        ArrayList<String> operands = new ArrayList<>();
        operands.add(Integer.toString(operand_1));
        operands.add(Integer.toString(operand_2));
        numberOperation.setOperands(operands);

        assertEquals(Integer.toString(calcIntExpected(operand_1, operand_2)), numberOperation.execute());
    }

    @org.junit.Test
    public void executeTest() throws Exception {
        for (int i = 0; i < ATTEMPT_COUNT; i++) {
            executeIntegerTest();
            executeDoubleTest();
        }
    }
}
