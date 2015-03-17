package com.tw.homeworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GuessNumberTest
{
    GuessNumber guessNumber;
    @Before
    public void setUp() throws Exception
    {
        String targetNumber = "1234";
        guessNumber = new GuessNumber(targetNumber);

    }

    @Test
    public void should_return_4A0B_when_input_answer_equals_to_target_number_1234(){
        
        // given
        String inputAnswer = "1234";

        //when
        String result = guessNumber.guess(inputAnswer);

        //then
        assertThat(result, is("4A0B"));
    }
    
    @Test
    public void should_return_0A4B_when_input_answer_not_equals_to_target_number_1234_at_any_position(){
        // given
        String inputAnswer = "4321";

        //when
        String result = guessNumber.guess(inputAnswer);
                
        //then
        assertThat(result, is("0A4B"));
    }
    
}
