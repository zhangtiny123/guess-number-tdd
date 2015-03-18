package com.tw.homeworks;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OutTest
{
    @Test
    public void should_print_the_given_message()
    {
        // given
        PrintStream outStream = mock(PrintStream.class);
        Out out = new Out(outStream);
        String message = "out put function is OK!";

        //when
        out.outToConsole(message);

        //then
        verify(outStream).println("out put function is OK!");
    }
}