package com.autel.sdk10.utils;

import java.util.Arrays;
import java.util.Iterator;

public class AutelStringUtils {
    public static String join(Object[] objArr, CharSequence charSequence) {
        return join((Iterable<? extends Object>) Arrays.asList(objArr), charSequence);
    }

    public static String join(Iterable<? extends Object> iterable, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        if (iterable != null) {
            Iterator<? extends Object> it = iterable.iterator();
            if (it.hasNext()) {
                sb.append(String.valueOf(it.next()));
                while (it.hasNext()) {
                    sb.append(charSequence);
                    sb.append(String.valueOf(it.next()));
                }
            }
        }
        return sb.toString();
    }

    public static String fixLastSlash(String str) {
        String str2 = "/";
        if (str != null) {
            str2 = str.trim() + str2;
        }
        return (str2.length() <= 2 || str2.charAt(str2.length() - 2) != '/') ? str2 : str2.substring(0, str2.length() - 1);
    }

    public static int convertToInt(String str) {
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            i++;
        }
        int length = str.length();
        while (length > 0 && !Character.isDigit(str.charAt(length - 1))) {
            length--;
        }
        if (length > i) {
            try {
                return Integer.parseInt(str.substring(i, length));
            } catch (NumberFormatException unused) {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String generateTime(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        if (i4 > 0) {
            return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
        }
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }
}
