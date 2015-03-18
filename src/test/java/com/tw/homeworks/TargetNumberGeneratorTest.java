package com.tw.homeworks;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TargetNumberGeneratorTest
{
    private TargetNumberGenerator targetNumberGenerator;

    @Before
    public void setUp() throws Exception
    {
        targetNumberGenerator = new TargetNumberGenerator();

    }

    @Test
    public void should_return_target_number_with_length_4()
    {
        //when
        String targetNumber = targetNumberGenerator.generate();

        //then
        assertThat(targetNumber.length(), is(4));
    }

    @Test
    public void should_return_target_number_with_no_duplication_number()
    {
        //when
        String targetNumber = targetNumberGenerator.generate();

        //then
        assertThat(hasDuplication(targetNumber), is(false));
    }

    @Test
    public void should_return_target_number_all_is_number_at_every_position()
    {
        //when
        String targetNumber = targetNumberGenerator.generate();

        //then
        assertThat(isAllNumber(targetNumber), is(true));
    }

    @Test
    public void should_not_all_is_the_same_result()
    {
        ArrayList<String> targets = new ArrayList<String>();
        //when
        targets.add(targetNumberGenerator.generate());
        targets.add(targetNumberGenerator.generate());
        targets.add(targetNumberGenerator.generate());
        targets.add(targetNumberGenerator.generate());
        targets.add(targetNumberGenerator.generate());

        //then
        assertThat(isAllSame(targets), is(false));
    }

    private Boolean isAllSame(ArrayList<String> targets)
    {
        for (int i = 0; i < targets.size() - 1; i++) {
            if (!(targets.get(i).equals(targets.get(i + 1)))) {
                return false;
            }
        }
        return true;
    }


    private Boolean isAllNumber(String targetNumber)
    {
        for (int i = 0; i < 4; i++) {
            if (!(targetNumber.charAt(i) >= '0' && targetNumber.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    private Boolean hasDuplication(String targetNumber)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (targetNumber.charAt(i) == targetNumber.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
