package com.company.calculator;

import java.util.List;

/**
 * Created by Yevhen on 21.04.2016.
 */
public interface ParseResult {
    String operation();

    List<String> operands();
}
