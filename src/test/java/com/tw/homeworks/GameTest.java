package com.tw.homeworks;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest
{
    private PrintStream outPut;
    private Game game;

    @Before
    public void setUp() throws Exception
    {
        TargetNumberGenerator generator = mock(TargetNumberGenerator.class);
        when(generator.generate()).thenReturn("1234");
        GuessNumber guessNumber = new GuessNumber(generator);
        outPut = mock(PrintStream.class);
        Out out = new Out(outPut);
        game = new Game(guessNumber, out);

    }

    @Test
    public void should_print_congratulations_when_input_is_correct() throws IOException
    {
        //when
        game.playWith("1234");

        //then
        verify(outPut).println("congratulations!");
    }

    @Test
    public void should_print_0A4B()
    {
        //when
        game.playWith("4321");

        //then
        verify(outPut).println("0A4B");
    }

    @Test
    public void should_print_2A2B_and_not_correct_message()
    {
        //when
        game.playWith("1324");

        //then
        verify(outPut).println("2A2B");
    }

    @Test
    public void should_print_0A0B()
    {
        //when
        game.playWith("5678");

        //then
        verify(outPut).println("0A0B");
    }

}
