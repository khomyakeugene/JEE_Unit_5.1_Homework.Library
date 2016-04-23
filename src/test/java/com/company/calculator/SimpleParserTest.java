package com.company.calculator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class SimpleParserTest {
    private static final String ADDITION_OPERATION_CODE = "+";
    private static final String SUBTRACT_OPERATION_CODE = "-";
    private static final String INVALID_OPERATION_CODE = "!!";
    private static final String EXPRESSION_PATTERN = "%s %s %s";

    private static SimpleParser simpleParser = new SimpleParser();
    private static Set<String> operationCodeSet = new TreeSet<>();

    private String operand_1;
    private String operand_2;
    private String operationCode;
    private String validBinaryOperationExpression;
    private String invalidBinaryOperationExpression;

    private void generateTestData() {
        operand_1 = Util.generateOperand();
        operand_2 = Util.generateOperand();
        operationCode = Util.getRandomBoolean() ? ADDITION_OPERATION_CODE : SUBTRACT_OPERATION_CODE;

        validBinaryOperationExpression = String.format(EXPRESSION_PATTERN, operand_1, operationCode, operand_2);
        invalidBinaryOperationExpression = String.format(EXPRESSION_PATTERN, operand_1, INVALID_OPERATION_CODE, operand_2);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        operationCodeSet.add(ADDITION_OPERATION_CODE);
        operationCodeSet.add(SUBTRACT_OPERATION_CODE);
    }

    @Before
    public void setUp() throws Exception {
        generateTestData();
    }

    @Test(timeout = 1000)
    public void parseValidBinaryOperationTest() throws Exception {
        ParseResult parseResult = simpleParser.parse(operationCodeSet, validBinaryOperationExpression);

        assertEquals(operationCode, parseResult.operationCode());
        assertEquals(OperatorType.BINARY, parseResult.operatorType());
        assertArrayEquals(new String[] {operand_1, operand_2}, parseResult.operandList().toArray());
    }

    @Test(timeout = 1000, expected = IllegalArgumentException.class)
    public void parseInvalidBinaryOperationTest() throws Exception {
        ParseResult parseResult = simpleParser.parse(operationCodeSet, invalidBinaryOperationExpression);

        assertEquals(operationCode, parseResult.operationCode());
        assertArrayEquals(new String[] {operand_1, operand_2}, parseResult.operandList().toArray());
    }
}