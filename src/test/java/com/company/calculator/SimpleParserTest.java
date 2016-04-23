package com.company.calculator;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class SimpleParserTest extends ExpressionTest {
    private static SimpleParser simpleParser = new SimpleParser();
    private static Set<String> operationCodeSet = new TreeSet<>();

    @BeforeClass
    public static void setUpClass() throws Exception {
        operationCodeSet.add(ADDITION_OPERATION_CODE);
        operationCodeSet.add(SUBTRACT_OPERATION_CODE);
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