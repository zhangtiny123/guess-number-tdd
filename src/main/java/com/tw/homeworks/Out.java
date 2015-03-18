package com.tw.homeworks;

import java.io.PrintStream;

public class Out
{
    private PrintStream printStream;

    public Out(PrintStream printStream)
    {
        this.printStream = printStream;
    }

    public void outToConsole(String message)
    {
        printStream.println(message);
    }
}
