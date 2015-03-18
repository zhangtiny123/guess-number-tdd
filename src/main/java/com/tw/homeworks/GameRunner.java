package com.tw.homeworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRunner
{
    public static void main(String[] args) throws IOException
    {
        TargetNumberGenerator targetGenerator = new TargetNumberGenerator();
        GuessNumber guessNumber = new GuessNumber(targetGenerator);
        Out out = new Out(System.out);
        Game game = new Game(guessNumber, out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        GameDriver gameDriver = new GameDriver(game, bufferedReader);

        gameDriver.initialGame();
        gameDriver.start();
    }

}
