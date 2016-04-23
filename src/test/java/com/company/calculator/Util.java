package com.company.calculator;

import java.util.Random;

/**
 * Created by Yevhen on 23.04.2016.
 */
public class Util {
    private static final int OPERAND_UPPER_BOUND = 1000;
    private static final int DECIMAL_PRECISION = 2;

    static private Random random = new Random();

    private static double round(double value, int decimalPrecision) {
        double decimalPower = Math.pow(10, decimalPrecision);

        return Math.round(value  * decimalPower) / decimalPower;
    }

    public static double getRandomDoubleValue() {
        return round(random.nextDouble() * OPERAND_UPPER_BOUND, DECIMAL_PRECISION);
    }

    public static int getRandomInteger() {
        return random.nextInt(OPERAND_UPPER_BOUND);
    }
}
