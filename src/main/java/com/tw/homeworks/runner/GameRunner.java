package com.tw.homeworks.runner;

import com.tw.homeworks.Answer;
import com.tw.homeworks.AnswerGenerator;
import com.tw.homeworks.AnswerHolder;
import com.tw.homeworks.GameFlow;
import com.tw.homeworks.view.ConsoleOutput;

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
        AnswerHolder answerHolder = new AnswerHolder(answer, consoleOutput);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        GameFlow gameFlow = new GameFlow(answerHolder, bufferedReader);

        gameFlow.start();
    }

}
