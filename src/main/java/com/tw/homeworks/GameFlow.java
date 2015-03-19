package com.tw.homeworks;

import com.tw.homeworks.config.Config;
import com.tw.homeworks.view.ConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;

public class GameFlow
{
    private AnswerHolder answerHolder;
    private int timeLeft;
    private BufferedReader bufferedReader;

    public GameFlow(AnswerHolder answerHolder, BufferedReader bufferedReader)
    {
        this.answerHolder = answerHolder;
        this.bufferedReader = bufferedReader;
        timeLeft = Config.NUMBER_OF_ROUND;
    }

    public void start() throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        ConsoleOutput consoleOutput = answerHolder.getConsoleOutput();
        while (gameIsNotOver(stringBuilder)) {
            consoleOutput.outToConsole(promptMessage(timeLeft));
            String inputNumber = bufferedReader.readLine();
            stringBuilder.replace(0, stringBuilder.length(), answerHolder.guessWith(inputNumber));
            timeLeft--;
        }
        System.out.println();
        if (timeLeft == 0) {
            consoleOutput.outToConsole(Config.GAME_OVER);
        }
    }

    private String promptMessage(int timeLeft)
    {
        return "Please input your guessing(" + timeLeft + "):";
    }

    private boolean gameIsNotOver(StringBuilder stringBuilder)
    {
        return !(stringBuilder.toString().equals(Config.SUCCESS_CODE)) && timeLeft != 0;
    }
}
