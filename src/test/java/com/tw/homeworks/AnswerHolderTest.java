package com.tw.homeworks;

import com.tw.homeworks.view.ConsoleOutput;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class AnswerHolderTest
{
    private PrintStream outPut;
    private AnswerHolder answerHolder;

    @Before
    public void setUp() throws Exception
    {
        AnswerGenerator generator = mock(AnswerGenerator.class);
        when(generator.generate()).thenReturn(new StringBuilder().append("1234"));
        Answer answer = new Answer(generator);
        outPut = mock(PrintStream.class);
        ConsoleOutput consoleOutput = new ConsoleOutput(outPut);
        answerHolder = new AnswerHolder(answer, consoleOutput);

    }

    @Test
    public void should_print_congratulations_when_input_is_correct() throws IOException
    {
        //when
        answerHolder.guessWith("1234");

        //then
        verify(outPut).println("congratulations!");
    }

    @Test
    public void should_print_0A4B()
    {
        //when
        answerHolder.guessWith("4321");

        //then
        verify(outPut).println("0A4B");
    }

    @Test
    public void should_print_2A2B_and_not_correct_message()
    {
        //when
        answerHolder.guessWith("1324");

        //then
        verify(outPut).println("2A2B");
    }

    @Test
    public void should_print_0A0B()
    {
        //when
        answerHolder.guessWith("5678");

        //then
        verify(outPut).println("0A0B");
    }

}
