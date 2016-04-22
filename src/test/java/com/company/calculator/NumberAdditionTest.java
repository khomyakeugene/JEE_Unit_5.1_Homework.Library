package com.company.calculator;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class NumberAdditionTest {
    private NumberAddition numberAddition = new NumberAddition();

    @org.junit.Test
    public void executeDoubleTest() throws Exception {
        double doubleOperand_1 = Util.getRandomDoubleValue();
        double doubleOperand_2 = Util.getRandomDoubleValue();

        ArrayList<String> operands = new ArrayList<>();
        operands.add(Double.toString(doubleOperand_1));
        operands.add(Double.toString(doubleOperand_2));
        numberAddition.setOperands(operands);

        assertEquals(Double.toString(doubleOperand_1 + doubleOperand_2), numberAddition.execute());
    }

    @org.junit.Test
    public void executeIntegerTest() throws Exception {
        int intOperand_1 = Util.getRandomInteger();
        int intOperand_2 = Util.getRandomInteger();

        ArrayList<String> operands = new ArrayList<>();
        operands.add(Integer.toString(intOperand_1));
        operands.add(Integer.toString(intOperand_2));
        numberAddition.setOperands(operands);

        assertEquals(Integer.toString(intOperand_1 + intOperand_2), numberAddition.execute());
    }
}