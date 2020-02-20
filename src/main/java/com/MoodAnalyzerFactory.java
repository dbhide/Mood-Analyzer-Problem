package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> myClass = Class.forName("com.MoodAnalyzer");
            try {
                Constructor<?> moodConstructor = myClass.getConstructor(String.class);
                try {
                    Object moodObject = moodConstructor.newInstance(message);
                    MoodAnalyzer moodObject1 = (MoodAnalyzer) moodObject;
                    return moodObject1;
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
        return null;
    }
}
