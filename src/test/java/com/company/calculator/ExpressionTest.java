package com.company.calculator;

import org.junit.Before;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class ExpressionTest {
    protected static final String ADDITION_OPERATION_CODE = "+";
    protected static final String SUBTRACT_OPERATION_CODE = "-";
    protected static final String INVALID_OPERATION_CODE = "!!";
    private static final String EXPRESSION_PATTERN = "%s %s %s";

    protected String operand_1;
    protected String operand_2;
    protected String operationCode;
    protected String validBinaryOperationExpression;
    protected String invalidBinaryOperationExpression;

    protected void generateTestData() {
        operand_1 = Util.generateOperand();
        operand_2 = Util.generateOperand();
        operationCode = Util.getRandomBoolean() ? ADDITION_OPERATION_CODE : SUBTRACT_OPERATION_CODE;

        validBinaryOperationExpression = String.format(EXPRESSION_PATTERN, operand_1, operationCode, operand_2);
        invalidBinaryOperationExpression = String.format(EXPRESSION_PATTERN, operand_1, INVALID_OPERATION_CODE, operand_2);
    }

    @Before
    public void setUp() throws Exception {
        generateTestData();
    }
}
