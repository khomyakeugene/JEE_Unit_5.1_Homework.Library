package com.company.calculator;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface Operation<T> {
    void addOperand(T operand);

    T execute();
}

