package com;

import com.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        try {
            try {
                Constructor<?> constructor = Class.forName("com.MoodAnalyzer").getConstructor(String.class);
                try {
                    Object myObject = constructor.newInstance("I am in Happy Mood");
                    MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObject;
                    String mood = moodAnalyzer.analyzeMood();
                    Assert.assertEquals("HAPPY", mood);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in Happy mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMood_WhenProper_ShouldReturnObject1() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am in Happy Mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy Mood"), moodAnalyzer);
        }catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    //4.1
    @Test
    public void givenMood_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
        }catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    //4.2
    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer1("com.dummy.MoodAnalyzer.class");
        }catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.EnumExceptionType.NO_SUCH_CLASS,e.type);
        }

    }

    //4.2
    @Test
    public void test() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("com.dummy.MoodAnalyzer", int.class);
        }catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.EnumExceptionType.NO_SUCH_CLASS,e.type);
        }

    }

    //4.3
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.MoodAnalyzer", int.class);
        }catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }

    }
}

