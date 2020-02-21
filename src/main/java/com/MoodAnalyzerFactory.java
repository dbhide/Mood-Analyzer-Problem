package com;

import com.exception.MoodAnalysisException;

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

    public static MoodAnalyzer createMoodAnalyzer() {
        try {
            Class<?> myClass = Class.forName("com.MoodAnalyzer");
            try {
                Constructor<?> moodConstructor = myClass.getConstructor();
                try {
                    Object moodObject = moodConstructor.newInstance();
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

    //4.2
    public static Constructor<?> getConstructor(String param, Class constructor) {
        try {
            Class<?> moodAnalyzerClass = Class.forName(param);
            return moodAnalyzerClass.getConstructor(constructor);
        }catch (ClassNotFoundException e) {
            throw  new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.NO_SUCH_CLASS, e.getMessage());
        }catch (NoSuchMethodException e) {
            throw  new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    //4.2
    public static MoodAnalyzer createMoodAnalyzer1(String s) {
        try {
            Class<?> myClass = Class.forName("com.dummy.MoodAnalyzer");
            try {
                Constructor<?> moodConstructor = myClass.getConstructor(String.class);
                try {
                    Object moodObject = moodConstructor.newInstance();
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
