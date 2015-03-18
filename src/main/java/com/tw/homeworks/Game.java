package com.tw.homeworks;

public class Game
{
    private final GuessNumber guessNumber;
    private Out out;

    public Game(GuessNumber guessNumber, Out out)
    {

        this.guessNumber = guessNumber;
        this.out = out;
    }

    public void playWith(String inputNumber)
    {
        String guessResult = guessNumber.guess(inputNumber);
        if (guessResult.equals("4A0B")) {
            out.outToConsole("congratulations!");
        } else {
            out.outToConsole(guessResult);
        }
    }
}
