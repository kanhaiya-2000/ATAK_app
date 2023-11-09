package com.google.common.base;

import atakplugin.UASTool.cih;
import atakplugin.UASTool.cij;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @cij Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z, @cij String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z, @cij String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, char c, @cij Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void checkArgument(boolean z, @cij String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, int i, @cij Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkArgument(boolean z, @cij String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, long j, @cij Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, @cij Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3, @cij Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, @cij Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object... objArr) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkState(boolean z, @cij String str, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @cij String str, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @cij String str, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkState(boolean z, @cij String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkState(boolean z, @cij String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @cij String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @cij String str, char c, @cij Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void checkState(boolean z, @cij String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @cij String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkState(boolean z, @cij String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @cij String str, int i, @cij Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkState(boolean z, @cij String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @cij String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @cij String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkState(boolean z, @cij String str, long j, @cij Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, @cij Object obj2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkState(boolean z, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3, @cij Object obj4) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @cih
    public static <T> T checkNotNull(@cih T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, char c, @cij Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), obj));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, int i, @cij Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, long j, @cij Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), obj));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, @cij Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    @cih
    public static <T> T checkNotNull(@cih T t, @cij String str, @cij Object obj, @cij Object obj2, @cij Object obj3, @cij Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, UASPoint.COTDETAIL_INDEX);
    }

    public static int checkElementIndex(int i, int i2, @cij String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badElementIndex(i, i2, str));
    }

    private static String badElementIndex(int i, int i2, @cij String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, UASPoint.COTDETAIL_INDEX);
    }

    public static int checkPositionIndex(int i, int i2, @cij String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i, i2, str));
    }

    private static String badPositionIndex(int i, int i2, @cij String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException("negative size: " + i2);
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return badPositionIndex(i2, i3, "end index");
        }
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }
}
