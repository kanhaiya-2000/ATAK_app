package com.autel.sdk10.utils;

import com.autel.util.log.AutelLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {
    private DateUtils() {
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static Date string2Date(String str, String str2) {
        if (isEmpty(str)) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (ParseException e) {
            AutelLog.m15083e(e.toString());
            return null;
        }
    }

    public static String getSystemTime(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static String getSystemTimeOnlyYMD(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static Date string2Date(String str) {
        return string2Date(str, "yyyy-MM-dd");
    }

    public static Date string2DateTime(String str) {
        return string2Date(str, "yyyy-MM-dd HH:mm:ss");
    }

    public static int getTimeZoneOffset() {
        return TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000;
    }
}
