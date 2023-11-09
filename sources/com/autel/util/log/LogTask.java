package com.autel.util.log;

import java.text.SimpleDateFormat;

public class LogTask {
    public static final String LOG_TYPE_DEBUG = "d";
    public static final String LOG_TYPE_ERROR = "e";
    public static final String LOG_TYPE_INFO = "i";
    public static final String LOG_TYPE_WARN = "w";
    public boolean isEndLog;
    public boolean isStartLog;
    public String location;
    public String log;
    public String type;
    public String writeTime = getTime(System.currentTimeMillis());

    public LogTask(String str, String str2) {
        this.type = str;
        this.log = str2;
    }

    public String getTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }
}
