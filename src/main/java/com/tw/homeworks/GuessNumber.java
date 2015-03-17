package com.tw.homeworks;

public class GuessNumber
{
    private String targetNumber;

    public GuessNumber(String targetNumber)
    {
        this.targetNumber = targetNumber;
    }

    public String guess(String inputAnswer)
    {
        int numberOfA = 0;
        int numberOfB = 0;
        for (int i = 0; i < 4; i++) {
            if (targetNumber.charAt(i) == inputAnswer.charAt(i)) {
                numberOfA++;
                continue;
            }
            for (int j = 0; j < 4; j++) {
                if ((targetNumber.charAt(i) == inputAnswer.charAt(j)) && (i != j)) {
                    numberOfB++;
                }
            }
        }
        return numberOfA + "A" + numberOfB + "B";
    }
}
