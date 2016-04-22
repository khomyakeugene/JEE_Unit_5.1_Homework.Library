package com.company.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class SimpleCalculator implements Calculator {
    private HashMap<String, List<Operation>> operationMap;
    private Parser parser;

    public SimpleCalculator() {
        operationMap = new HashMap<>();

        setParser(new SimpleParser());
    }

    @Override
    public String execute(String inputExpression) {
        return null;
    }

    @Override
    public void addOperation(String operationCode, Operation operation) {
        // Search operation by <operationCode>
        List<Operation> operationList = operationMap.get(operationCode);
        // If yet not presented than create
        if (operationList == null) {
            operationList = new ArrayList<>();
        }

        // Add operation
        operationList.add(operation);
        // Store new operation list
        operationMap.put(operationCode, operationList);
    }

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
