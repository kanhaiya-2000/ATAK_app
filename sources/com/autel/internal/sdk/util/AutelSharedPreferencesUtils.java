package com.autel.internal.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;

public final class AutelSharedPreferencesUtils {
    private AutelSharedPreferencesUtils() {
    }

    public static void setSpValueForInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static int getSpValueForInt(Context context, String str, int i) {
        return context.getSharedPreferences(str, 0).getInt(str, i);
    }

    public static void setSpValueForString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static String getSpValueForString(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str, str2);
    }

    public static void setSpValueForBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static boolean getSpValueForBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences(str, 0).getBoolean(str, z);
    }

    public static void clearSpValue(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.clear();
        edit.commit();
    }
}
