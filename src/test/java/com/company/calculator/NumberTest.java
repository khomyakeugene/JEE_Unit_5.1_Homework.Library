package com.company.calculator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 23.04.2016.
 */
public abstract class NumberTest {
    protected static NumberOperation numberOperation;

    protected abstract double calcExpected(double operand_1, double  operand_2);

    private String calcExpected(String operand_1, String operand_2) {
        return Numbers.numberConversation(Double.toString(
                calcExpected(Double.parseDouble(operand_1), Double.parseDouble(operand_2))));
    }


    @org.junit.Test(timeout = 1000)
    public void executeTest() throws Exception {
        String operand_1 = Util.generateOperand();
        String operand_2 = Util.generateOperand();

        ArrayList<String> operands = new ArrayList<>();
        operands.add(operand_1);
        operands.add(operand_2);
        numberOperation.setOperands(operands);

        assertEquals(calcExpected(operand_1, operand_2), numberOperation.execute());
    }
}
