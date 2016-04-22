package com.company.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 22.04.2016.
 */
public class SimpleParseResult implements ParseResult {
    private String operationCode;
    private OperatorType operationType;
    private ArrayList operandList;

    public SimpleParseResult(String operationCode, OperatorType operationType, ArrayList operandList) {
        this.operationCode = operationCode;
        this.operationType = operationType;
        this.operandList = operandList;
    }

    @Override
    public String operationCode() {
        return null;
    }

    @Override
    public OperatorType operatorType() {
        return null;
    }

    @Override
    public List<String> operandList() {
        return null;
    }
}