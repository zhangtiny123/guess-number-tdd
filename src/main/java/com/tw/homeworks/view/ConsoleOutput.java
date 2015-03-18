package com.tw.homeworks.view;

import java.io.PrintStream;

public class ConsoleOutput
{
    private PrintStream printStream;

    public ConsoleOutput(PrintStream printStream)
    {
        this.printStream = printStream;
    }

    public void outToConsole(String message)
    {
        printStream.println(message);
    }
}
