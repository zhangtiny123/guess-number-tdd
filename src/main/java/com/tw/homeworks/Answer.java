package com.tw.homeworks;

public class Answer
{
    public static final int LENGTH = 4;
    public static final String successSymbol = "A";
    public static final String wrongPositionSymbol = "B";
    private StringBuilder answer;

    public Answer(AnswerGenerator answer)
    {
        this.answer = answer.generate();
    }

    public String compareWith(String inputAnswer)
    {
        int successCount = 0;
        int wrongPositionCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (answer.charAt(i) == inputAnswer.charAt(i)) {
                successCount++;
                continue;
            }
            for (int j = 0; j < LENGTH; j++) {
                if ((answer.charAt(i) == inputAnswer.charAt(j)) && (i != j)) {
                    wrongPositionCount++;
                }
            }
        }
        return successCount + successSymbol + wrongPositionCount + wrongPositionSymbol;
    }
}
