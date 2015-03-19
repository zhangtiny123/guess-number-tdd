package com.tw.homeworks.runner;

import com.tw.homeworks.GameFlow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GameRunner
{
    private GameFlow gameFlow;

    public GameRunner(GameFlow gameFlow)
    {
        this.gameFlow = gameFlow;
    }

    public static void main(String[] args) throws IOException
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        GameFlow game = applicationContext.getBean(GameFlow.class);
        GameRunner runner = new GameRunner(game);
        runner.gameFlow.start();
    }
}
