package com.tw.homeworks;

import java.util.Random;

public class AnswerGenerator
{
    public static final int RANGE = 10;
    public static final int LENGTH = 4;
    private final Random random;

    public AnswerGenerator(Random random)
    {
        this.random = random;
    }

    public StringBuilder generate()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            String singleNumber;
            do {
                singleNumber = String.valueOf(random.nextInt(RANGE));
            } while (stringBuilder.indexOf(singleNumber) != -1);
            stringBuilder.append(singleNumber);
        }
        return stringBuilder;
    }
}
