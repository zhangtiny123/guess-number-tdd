package com.tw.homeworks;

import java.io.BufferedReader;
import java.io.IOException;

public class GameDriver
{

    private Game game;
    private int timeLeft;
    private BufferedReader bufferedReader;

    public GameDriver(Game game, BufferedReader bufferedReader)
    {
        this.game = game;
        this.bufferedReader = bufferedReader;
        timeLeft = 6;
    }

    public void initialGame()
    {
        timeLeft = 6;
    }

    public void start() throws IOException
    {
        String flag = "";
        Out out = game.getOut();
        while (!flag.equals("4A0B") && timeLeft != 0) {
            out.outToConsole("Please input your guessing(" + timeLeft + "):");
            String inputNumber = bufferedReader.readLine();
            flag = game.playWith(inputNumber);
            timeLeft--;
        }
        if (timeLeft == 0) {
            out.outToConsole("Game Over!");
        }
    }
}
