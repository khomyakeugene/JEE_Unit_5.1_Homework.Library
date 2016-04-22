package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 20.04.2016.
 */
public interface Calculator {
    /**
     *
     * @param inputData is the string which represents some simple algebraic expression, for example, "1+2" or "*,5,6"
     * @return result of calculation of the <b>inputData</b>-expression
     * @throws
     */
    String execute(String inputData);

    /**
     *
     * @param signature - symbol sequence ("+", "-", "sqrt" etc.) which represents the operation
     * @param operation -
     *
     * Add <b>operation</b> associated with its <b>signature</b> to the list of the operations which can be executed
     */
    void addOperation(String signature, String typeName, Operation operation);
}
