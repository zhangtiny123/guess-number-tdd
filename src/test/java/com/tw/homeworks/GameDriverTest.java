package com.tw.homeworks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameDriverTest
{
    private PrintStream out;
    private InOrder inOrder;
    private Game game;

    @Before
    public void setUp() throws Exception
    {
        out = mock(PrintStream.class);
        inOrder = inOrder(out);

        TargetNumberGenerator targetNumber = mock(TargetNumberGenerator.class);
        when(targetNumber.generate()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(targetNumber);
        Out outPut = new Out(out);
        game = new Game(guessNumber, outPut);
    }

    @Test
    public void should_print_congratulations_when_answer_is_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1234");
        GameDriver gameDriver = new GameDriver(game, bufferedReader);

        //when
        gameDriver.start();

        //then
        inOrder.verify(out).println("Please input your guessing(6):");
        inOrder.verify(out).println("congratulations!");
    }

    @Test
    public void should_print_messages_then_congratulations_when_answer_is_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1567").thenReturn("3476").thenReturn("1234");
        GameDriver gameDriver = new GameDriver(game, bufferedReader);

        //when
        gameDriver.start();

        //then
        inOrder.verify(out).println("Please input your guessing(6):");
        inOrder.verify(out).println("1A0B");
        inOrder.verify(out).println("Please input your guessing(5):");
        inOrder.verify(out).println("0A2B");
        inOrder.verify(out).println("Please input your guessing(4):");
        inOrder.verify(out).println("congratulations!");
    }

    @Test
    public void should_print_messages_then_game_over_when_answer_is_not_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1567").thenReturn("3476").thenReturn("2316").thenReturn(
                "7834").thenReturn("2456").thenReturn("5234");
        GameDriver gameDriver = new GameDriver(game, bufferedReader);

        //when
        gameDriver.start();

        //then
        inOrder.verify(out).println("Please input your guessing(6):");
        inOrder.verify(out).println("1A0B");
        inOrder.verify(out).println("Please input your guessing(5):");
        inOrder.verify(out).println("0A2B");
        inOrder.verify(out).println("Please input your guessing(4):");
        inOrder.verify(out).println("0A3B");
        inOrder.verify(out).println("Please input your guessing(3):");
        inOrder.verify(out).println("2A0B");
        inOrder.verify(out).println("Please input your guessing(2):");
        inOrder.verify(out).println("0A2B");
        inOrder.verify(out).println("Please input your guessing(1):");
        inOrder.verify(out).println("3A0B");
        inOrder.verify(out).println("Game Over!");
    }
}
