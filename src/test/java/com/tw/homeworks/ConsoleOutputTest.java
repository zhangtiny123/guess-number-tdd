package com.tw.homeworks;

import com.tw.homeworks.view.ConsoleOutput;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleOutputTest
{

    public static final String TEST_PRINT_MESSAGE = "out put function is OK!";

    @Test
    public void should_print_the_given_message()
    {
        // given
        PrintStream outStream = mock(PrintStream.class);
        ConsoleOutput consoleOutput = new ConsoleOutput(outStream);
        String message = TEST_PRINT_MESSAGE;

        //when
        consoleOutput.outToConsole(message);

        //then
        verify(outStream).println(TEST_PRINT_MESSAGE);
    }
}