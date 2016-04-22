package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface Operation {
    boolean isThisOperation(String inputExpression, ParseResult parseResult);

    void setOperands(List<String> operands);

    String execute();
}

