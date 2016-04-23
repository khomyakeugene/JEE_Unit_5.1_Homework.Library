package com.company.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class SimpleCalculator implements Calculator {
    private static final String ADDITION_OPERATION_CODE = "+";
    private static final String SUBTRACT_OPERATION_CODE = "-";

    private HashMap<String, List<Operation>> operationMap;
    private Parser parser;

    public SimpleCalculator() {
        setParser(new SimpleParser());

        operationMap = new HashMap<>();

        initDefaultOperationList();
    }

    private void initDefaultOperationList() {
        // Addition operation for numbers
        addOperation(ADDITION_OPERATION_CODE, new NumberAddition());
        // Subtract operation for numbers
        addOperation(SUBTRACT_OPERATION_CODE, new NumberSubtract());
    }

    @Override
    public String execute(String inputExpression) {
        String result = null;

        // Parse input expression: receive operation description in <parseResult> or IllegalArgumentException
        // if <inputExpression> is invalid
        ParseResult parseResult = parser.parse(operationMap.keySet(), inputExpression);
        // Search suitable operation, always suppose that if such operation could be found more than one be more,
        // only the first one should be executed
        Optional<Operation> first = operationMap.get(parseResult.operationCode()).
                stream().filter(o -> o.isThisOperation(inputExpression, parseResult)).findFirst();
        if (first.isPresent()) {
            Operation operation = first.get();
            // Store operands
            operation.setOperands(parseResult.operandList());
            // Execute operation
            result = operation.execute();
        }

        return result;
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
