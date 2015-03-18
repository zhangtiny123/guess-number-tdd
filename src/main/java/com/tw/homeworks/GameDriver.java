package com.tw.homeworks;

import java.io.BufferedReader;
import java.io.IOException;

public class GameDriver
{

    public static final int LEFT_TIMES = 6;
    public static final String GAME_OVER_MESSAGE = "Game Over!";
    private Game game;
    private int timeLeft;
    private BufferedReader bufferedReader;

    public GameDriver(Game game, BufferedReader bufferedReader)
    {
        this.game = game;
        this.bufferedReader = bufferedReader;
        timeLeft = LEFT_TIMES;
    }

    public void initialGame()
    {
        timeLeft = LEFT_TIMES;
    }

    public void start() throws IOException
    {
        String flag = "";
        ConsoleOutput consoleOutput = game.getConsoleOutput();
        while (gameIsNotOver(flag)) {
            consoleOutput.outToConsole(promptMessage(timeLeft));
            String inputNumber = bufferedReader.readLine();
            flag = game.playWith(inputNumber);
            timeLeft--;
        }
        if (timeLeft == 0) {
            consoleOutput.outToConsole(GAME_OVER_MESSAGE);
        }
    }

    private String promptMessage(int timeLeft) {return "Please input your guessing(" + timeLeft + "):";}

    private boolean gameIsNotOver(String flag) {return !flag.equals("4A0B") && timeLeft != 0;}
}
