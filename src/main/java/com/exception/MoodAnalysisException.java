package com.exception;

public class MoodAnalysisException extends RuntimeException{

    public EnumExceptionType type;

    public enum EnumExceptionType {
        EMPTY_MESSAGE, NULL_MESSAGE, NO_SUCH_CLASS, NO_SUCH_METHOD,NO_FIELD,INVOCATION_TARGET
    }
    public MoodAnalysisException( EnumExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
