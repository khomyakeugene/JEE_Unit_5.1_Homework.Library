package com.company.calculator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 23.04.2016.
 */
public abstract class NumberTest extends OperationTest {
    protected static boolean onlyIntegerValues = false;

    protected String operand_1;;
    protected String operand_2;

    protected abstract double calcExpected(double operand_1, double  operand_2);

    @Override
    protected void initOperands() {
        operand_1 = onlyIntegerValues ? Util.generateIntegerNumber() : Util.generateNumber();
        operand_2 = onlyIntegerValues ? Util.generateIntegerNumber() : Util.generateNumber();

        operands.add(operand_1);
        operands.add(operand_2);
    }

    @Override
    protected String expectedResult() {
        return Numbers.numberConversation(Double.toString(
                calcExpected(Double.parseDouble(operand_1), Double.parseDouble(operand_2))));
    }
}
