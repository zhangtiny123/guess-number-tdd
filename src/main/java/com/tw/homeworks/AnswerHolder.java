package com.tw.homeworks;

import com.tw.homeworks.config.Config;
import com.tw.homeworks.view.ConsoleOutput;

public class AnswerHolder
{
    private final Answer answer;
    private final ConsoleOutput consoleOutput;

    public AnswerHolder(Answer answer, ConsoleOutput consoleOutput)
    {
        this.answer = answer;
        this.consoleOutput = consoleOutput;
    }

    public ConsoleOutput getConsoleOutput()
    {
        return consoleOutput;
    }

    public String guessWith(String inputNumber)
    {
        String guessResult = answer.compareWith(inputNumber);
        if (guessResult.equals(Config.SUCCESS_CODE)) {
            consoleOutput.outToConsole(Config.SUCCESS_MESSAGE);
        } else {
            consoleOutput.outToConsole(guessResult);
        }
        return guessResult;
    }
}
