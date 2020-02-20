package com;

import com.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMoodShouldReturnSad() {
        String mood;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodShouldReturnHappy() {
        String mood;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldReturnHappy() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void givenNullMoodShouldThrowMoodAnalysisException() {
        try{
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.EnumExceptionType.NULL_MESSAGE,e.type);
        }
    }

    @Test
    public void givenEmptyMoodShouldThrowMoodAnalysisExceptionIndicatingEmptyMood() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.EnumExceptionType.EMPTY_MESSAGE,e.type);
        }
    }
}
