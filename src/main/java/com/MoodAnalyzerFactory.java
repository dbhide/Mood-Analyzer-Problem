package com;

import com.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {

    private static Class<?> variable;

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

    public static MoodAnalyzer createMood(String s) {
        try {
            Class<?> myClass = Class.forName("com.dummy.MoodAnalyzer");
            try {
                Constructor<?> moodConstructor = myClass.getConstructor(variable);
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

    public static String invokeMethod(MoodAnalyzer obj, String methodName){
        try{
            Method declareMethod = obj.getClass().getDeclaredMethod(methodName);
            return (String) declareMethod.invoke(obj);
        }catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.NO_SUCH_METHOD, e.getMessage());
        }catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    //6.1
    public static MoodAnalyzer createMoodMethod(String message) {
        try{
            Constructor<?> moodConstructor = Class.forName("com.MoodAnalyzer").getConstructor((String.class));
            Object myObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer)myObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //7
    public static String setFieldValue(MoodAnalyzer moodAnalyzer, String message, String fieldName) {
        try{
            Field declaredField = moodAnalyzer.getClass().getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            declaredField.set(moodAnalyzer, message);
            return (String) moodAnalyzer.getClass().getMethod("analyzeMood").invoke(moodAnalyzer);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.NO_FIELD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.INVOCATION_TARGET, e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

