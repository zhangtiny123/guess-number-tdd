package com.tw.homeworks;

import com.tw.homeworks.view.ConsoleOutput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameFlowTest
{
    private PrintStream output;
    private InOrder inOrder;
    private AnswerHolder answerHolder;

    @Before
    public void setUp() throws Exception
    {
        output = mock(PrintStream.class);
        inOrder = inOrder(output);

        AnswerGenerator targetNumber = mock(AnswerGenerator.class);
        when(targetNumber.generate()).thenReturn(new StringBuilder().append("1234"));
        Answer answer = new Answer(targetNumber);
        ConsoleOutput consoleOutputPut = new ConsoleOutput(output);
        answerHolder = new AnswerHolder(answer, consoleOutputPut);
    }

    @Test
    public void should_print_congratulations_when_answer_is_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1234");
        GameFlow gameFlow = new GameFlow(answerHolder, bufferedReader);

        //when
        gameFlow.start();

        //then
        inOrder.verify(output).println("Please input your guessing(6):");
        inOrder.verify(output).println("congratulations!");
    }

    @Test
    public void should_print_messages_then_congratulations_when_answer_is_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1567").thenReturn("3476").thenReturn("1234");
        GameFlow gameFlow = new GameFlow(answerHolder, bufferedReader);

        //when
        gameFlow.start();

        //then
        inOrder.verify(output).println("Please input your guessing(6):");
        inOrder.verify(output).println("1A0B");
        inOrder.verify(output).println("Please input your guessing(5):");
        inOrder.verify(output).println("0A2B");
        inOrder.verify(output).println("Please input your guessing(4):");
        inOrder.verify(output).println("congratulations!");
    }

    @Test
    public void should_print_messages_then_game_over_when_answer_is_not_correct() throws IOException
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine())
                .thenReturn("1567")
                .thenReturn("3476")
                .thenReturn("2316")
                .thenReturn("7834")
                .thenReturn("2456")
                .thenReturn("5234");
        GameFlow gameFlow = new GameFlow(answerHolder, bufferedReader);

        //when
        gameFlow.start();

        //then
        inOrder.verify(output).println("Please input your guessing(6):");
        inOrder.verify(output).println("1A0B");
        inOrder.verify(output).println("Please input your guessing(5):");
        inOrder.verify(output).println("0A2B");
        inOrder.verify(output).println("Please input your guessing(4):");
        inOrder.verify(output).println("0A3B");
        inOrder.verify(output).println("Please input your guessing(3):");
        inOrder.verify(output).println("2A0B");
        inOrder.verify(output).println("Please input your guessing(2):");
        inOrder.verify(output).println("0A2B");
        inOrder.verify(output).println("Please input your guessing(1):");
        inOrder.verify(output).println("3A0B");
        inOrder.verify(output).println("Game Over!");
    }
}
