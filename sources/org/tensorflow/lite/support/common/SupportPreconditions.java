package org.tensorflow.lite.support.common;

import atakplugin.UASTool.cix;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.util.Objects;

public final class SupportPreconditions {
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t, "The object reference is null.");
        return t;
    }

    public static <T> T checkNotNull(T t, @cix Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String checkNotEmpty(String str) {
        if (str != null && str.length() != 0) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null.");
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (str != null && str.length() != 0) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @cix Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, UASPoint.COTDETAIL_INDEX);
    }

    public static int checkElementIndex(int i, int i2, @cix String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badElementIndex(i, i2, str));
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, @cix Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    private static String badElementIndex(int i, int i2, @cix String str) {
        if (i < 0) {
            return String.format("%s (%s) must not be negative", new Object[]{str, Integer.valueOf(i)});
        } else if (i2 >= 0) {
            return String.format("%s (%s) must be less than size (%s)", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    private SupportPreconditions() {
        throw new AssertionError("SupportPreconditions is Uninstantiable.");
    }
}
