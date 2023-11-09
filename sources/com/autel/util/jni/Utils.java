package com.autel.util.jni;

public class Utils {
    public static native boolean checkApp(String str);

    public static native String decryptionCode(String str);

    public static native String encryptionCode(String str);

    public static native String stringFromSign(String[] strArr);

    static {
        System.loadLibrary("AutelUtil");
    }
}
