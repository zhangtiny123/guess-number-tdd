package com.tw.homeworks;

public class Game
{
    public static final String SUCCESS_MESSAGE = "congratulations!";
    public static final String SUCCESS_CODE = "4A0B";
    private final Answer answer;
    private final ConsoleOutput consoleOutput;

    public Game(Answer answer, ConsoleOutput consoleOutput)
    {

        this.answer = answer;
        this.consoleOutput = consoleOutput;
    }

    public ConsoleOutput getConsoleOutput()
    {
        return consoleOutput;
    }

    public String playWith(String inputNumber)
    {
        String guessResult = answer.compareWith(inputNumber);
        if (guessResult.equals(SUCCESS_CODE)) {
            consoleOutput.outToConsole(SUCCESS_MESSAGE);
        } else {
            consoleOutput.outToConsole(guessResult);
        }
        return guessResult;
    }
    
}
