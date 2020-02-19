package com;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
  //  MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is Sad Mood");

    @Test
    public void givenMoodShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMoodShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }
}
