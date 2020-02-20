package com.exception;

public class MoodAnalysisException extends RuntimeException{

    public EnumExceptionType type;

    public enum EnumExceptionType {
        EMPTY_MESSAGE, NULL_MESSAGE;
    }
    public MoodAnalysisException( EnumExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
