package com.tw.homeworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GameRunner
{
    public static void main(String[] args) throws IOException
    {
        AnswerGenerator targetGenerator = new AnswerGenerator(new Random());
        Answer answer = new Answer(targetGenerator);
        ConsoleOutput consoleOutput = new ConsoleOutput(System.out);
        Game game = new Game(answer, consoleOutput);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        GameDriver gameDriver = new GameDriver(game, bufferedReader);

        gameDriver.initialGame();
        gameDriver.start();
    }

}
