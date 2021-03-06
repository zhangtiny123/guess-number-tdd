package com.tw.homeworks;

import com.tw.homeworks.components.Answer;
import com.tw.homeworks.components.AnswerGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerTest
{
    private Answer answer;

    @Before
    public void setUp() throws Exception
    {
        AnswerGenerator generator = mock(AnswerGenerator.class);
        when(generator.generate()).thenReturn(new StringBuilder().append("1234"));
        answer = new Answer(generator);
    }

    @Test
    public void should_return_4A0B_when_input_answer_equals_to_target_number_1234()
    {
        // given
        String inputAnswer = "1234";

        //when
        String result = answer.compareWith(inputAnswer);

        //then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_return_0A4B_when_input_answer_not_equals_to_target_number_1234_at_any_position()
    {
        // given
        String inputAnswer = "4321";

        //when
        String result = answer.compareWith(inputAnswer);

        //then
        assertThat(result, is("0A4B"));
    }

    @Test
    public void should_return_2A2B_when_input_answer_is_1324_and_target_number_is_1234()
    {
        // given
        String inputAnswer = "1324";

        //when
        String result = answer.compareWith(inputAnswer);

        //then
        assertThat(result, is("2A2B"));
    }

    @Test
    public void should_return_0A0B_when_input_answer_is_5678_and_target_number_is_1234()
    {
        // given
        String inputAnswer = "5678";

        //when
        String result = answer.compareWith(inputAnswer);

        //then
        assertThat(result, is("0A0B"));
    }
}
