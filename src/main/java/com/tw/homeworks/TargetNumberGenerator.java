package com.tw.homeworks;

import java.util.Random;

public class TargetNumberGenerator
{
    public String generate()
    {
        String target = "";
        for (int i = 0; i < 4; i++) {
            String singleNumber;
            do {
                singleNumber = String.valueOf(new Random().nextInt(10));
            } while (target.contains(singleNumber));
            target += singleNumber;
        }
        return target;
    }
}
