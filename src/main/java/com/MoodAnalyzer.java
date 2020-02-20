package com;

import com.exception.MoodAnalysisException;

public class MoodAnalyzer {

    public MoodAnalyzer() {
    }

    private String message;

    public String analyzeMood(String message) {
        this.message=message;
        return analyzeMood();
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() throws MoodAnalysisException {
        try {
            if (message.contains("Sad")) {
                return "SAD";
            } else if (message.isEmpty()) {
                throw new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.EMPTY_MESSAGE, "Please Enter Valid String");
            }
            return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.EnumExceptionType.NULL_MESSAGE, "Please Enter Valid Mood");
        }
    }
}
