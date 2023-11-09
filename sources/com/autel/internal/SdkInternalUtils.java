package com.autel.internal;

public class SdkInternalUtils {
    public static boolean isVersionBigger(int i, String str) {
        if (str == null) {
            return false;
        }
        try {
            char[] charArray = str.toCharArray();
            return Integer.parseInt(String.copyValueOf(new char[]{charArray[1], charArray[3], charArray[4], charArray[6], charArray[7]}, 0, 5)) >= i;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
