package com.tw.homeworks.components;

import com.tw.homeworks.config.Config;

import java.util.Random;

public class AnswerGenerator
{

    private final Random random;

    public AnswerGenerator(Random random)
    {
        this.random = random;
    }

    public StringBuilder generate()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Config.ANSWER_LENGTH; i++) {
            String singleNumber;
            do {
                singleNumber = String.valueOf(random.nextInt(Config.ANSWER_ELEMENT_RANGE));
            } while (stringBuilder.indexOf(singleNumber) != -1);
            stringBuilder.append(singleNumber);
        }
        return stringBuilder;
    }
}
