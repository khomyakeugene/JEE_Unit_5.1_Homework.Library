package com.company.calculator;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 24.04.2016.
 */
public abstract class OperationTest {
    private static Operation operation;
    protected ArrayList<String> operands = new ArrayList<>();

    protected static void setOperation(Operation operation) {
        OperationTest.operation = operation;
    }

    protected abstract void initOperands();

    protected abstract String expectedResult();

    @org.junit.Test(timeout = 1000)
    public void executeTest() throws Exception {
        initOperands();
        operation.setOperands(operands);
        assertEquals(expectedResult(), operation.execute());
    }
}
