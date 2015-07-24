package com.tw.homeworks.components;

import com.tw.homeworks.config.Config;

public class Answer
{
    private StringBuilder answer;

    public Answer(AnswerGenerator answer)
    {
        this.answer = answer.generate();
    }

    public String compareWith(String inputAnswer)
    {
        int successCount = 0;
        int wrongPositionCount = 0;
        for (int i = 0; i < Config.ANSWER_LENGTH; i++) {
            if (answer.charAt(i) == inputAnswer.charAt(i)) {
                successCount++;
                continue;
            }
            for (int j = 0; j < Config.ANSWER_LENGTH; j++) {
                if ((answer.charAt(i) == inputAnswer.charAt(j)) && (i != j)) {
                    wrongPositionCount++;
                }
            }
        }
        return successCount + Config.SUCCESS_SYMBOL + wrongPositionCount + Config.WRONG_POSITION_SYMBOL;
    }
}
