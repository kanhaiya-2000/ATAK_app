package com.atakmap.android.uastool.tasks.route;

import java.util.ArrayList;
import java.util.List;

public class RouteTaskErrorList {
    public List<String> errorList = new ArrayList(0);
    public ErrorType errorType = ErrorType.NONE;

    public enum ErrorType {
        NONE(0),
        WARN(1),
        ERROR(2);
        
        int value;

        private ErrorType(int i) {
            this.value = i;
        }
    }

    public void add(String str, ErrorType errorType2) {
        this.errorList.add(str);
        setErrorType(errorType2);
    }

    public void setErrorType(ErrorType errorType2) {
        if (errorType2.value > this.errorType.value) {
            this.errorType = errorType2;
        }
    }
}
