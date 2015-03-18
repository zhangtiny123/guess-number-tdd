package com.tw.homeworks;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswerGeneratorTest
{
    public static final int ANSWER_LENGTH = 4;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception
    {
        answerGenerator = new AnswerGenerator(new Random());

    }

    @Test
    public void should_return_target_number_with_length_4()
    {
        //when
        StringBuilder targetNumber = answerGenerator.generate();

        //then
        assertThat(targetNumber.length(), is(4));
    }

    @Test
    public void should_return_target_number_with_no_duplication_number()
    {
        //when
        StringBuilder targetNumber = answerGenerator.generate();

        //then
        assertThat(hasDuplication(targetNumber), is(false));
    }

    @Test
    public void should_return_target_number_all_is_number_at_every_position()
    {
        //when
        StringBuilder targetNumber = answerGenerator.generate();

        //then
        assertThat(isAllNumber(targetNumber), is(true));
    }

    @Test
    public void should_not_all_is_the_same_result()
    {
        ArrayList<StringBuilder> targets = new ArrayList<StringBuilder>();
        //when
        targets.add(answerGenerator.generate());
        targets.add(answerGenerator.generate());
        targets.add(answerGenerator.generate());
        targets.add(answerGenerator.generate());
        targets.add(answerGenerator.generate());

        //then
        assertThat(isAllSame(targets), is(false));
    }

    private Boolean isAllSame(ArrayList<StringBuilder> targets)
    {
        for (int i = 0; i < targets.size() - 1; i++) {
            if (!(targets.get(i).equals(targets.get(i + 1)))) {
                return false;
            }
        }
        return true;
    }


    private Boolean isAllNumber(StringBuilder targetNumber)
    {
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (!(targetNumber.charAt(i) >= '0' && targetNumber.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    private Boolean hasDuplication(StringBuilder targetNumber)
    {
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            for (int j = i + 1; j < ANSWER_LENGTH; j++) {
                if (targetNumber.charAt(i) == targetNumber.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
