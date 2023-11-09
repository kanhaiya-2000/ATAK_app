package atakplugin.UASTool;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class bsp {

    /* renamed from: a */
    public static final byte[] f3582a = new byte[0];

    /* renamed from: b */
    public static final String[] f3583b = new String[0];

    /* renamed from: c */
    public static final Charset f3584c = Charset.forName("UTF-8");

    /* renamed from: d */
    public static final TimeZone f3585d = TimeZone.getTimeZone("GMT");

    /* renamed from: e */
    private static final Pattern f3586e = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private bsp() {
    }

    /* renamed from: a */
    public static void m9157a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public static boolean m9164a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static void m9158a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9161a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m9163a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9160a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m9159a(Closeable closeable, Closeable closeable2) {
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw th;
            } else {
                throw new AssertionError(th);
            }
        }
    }

    /* renamed from: a */
    public static boolean m9162a(bxr bxr, int i, TimeUnit timeUnit) {
        try {
            return m9170b(bxr, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m9170b(bxr bxr, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c = bxr.timeout().mo3990g_() ? bxr.timeout().mo3986c() - nanoTime : Long.MAX_VALUE;
        bxr.timeout().mo3983a(Math.min(c, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            bwl bwl = new bwl();
            while (bxr.mo3425a(bwl, 8192) != -1) {
                bwl.mo3769B();
            }
            if (c == bfu.f2629b) {
                bxr.timeout().mo3991h_();
            } else {
                bxr.timeout().mo3983a(nanoTime + c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c == bfu.f2629b) {
                bxr.timeout().mo3991h_();
            } else {
                bxr.timeout().mo3983a(nanoTime + c);
            }
            return false;
        } catch (Throwable th) {
            if (c == bfu.f2629b) {
                bxr.timeout().mo3991h_();
            } else {
                bxr.timeout().mo3983a(nanoTime + c);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m9151a(String str) {
        try {
            return bwq.m10200e(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).mo3947j();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static String m9169b(String str) {
        try {
            return bwq.m10200e(MessageDigest.getInstance("SHA-1").digest(str.getBytes("UTF-8"))).mo3933d();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static bwq m9149a(bwq bwq) {
        try {
            return bwq.m10200e(MessageDigest.getInstance("SHA-1").digest(bwq.mo3953p()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static bwq m9168b(bwq bwq) {
        try {
            return bwq.m10200e(MessageDigest.getInstance("SHA-256").digest(bwq.mo3953p()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public static <T> List<T> m9153a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: a */
    public static <T> List<T> m9154a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: a */
    public static ThreadFactory m9156a(String str, boolean z) {
        return new bsq(str, z);
    }

    /* renamed from: a */
    public static <T> T[] m9165a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a = m9155a(tArr, tArr2);
        return a.toArray((Object[]) Array.newInstance(cls, a.size()));
    }

    /* renamed from: a */
    private static <T> List<T> m9155a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                T t2 = tArr2[i];
                if (t.equals(t2)) {
                    arrayList.add(t2);
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m9150a(brr brr, boolean z) {
        String str;
        if (brr.mo3204i().contains(":")) {
            str = "[" + brr.mo3204i() + "]";
        } else {
            str = brr.mo3204i();
        }
        if (!z && brr.mo3205j() == brr.m8802a(brr.mo3192c())) {
            return str;
        }
        return str + ":" + brr.mo3205j();
    }

    /* renamed from: c */
    public static String m9171c(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt <= 31 || codePointAt >= 127) {
                bwl bwl = new bwl();
                bwl.mo3818b(str, 0, i);
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    bwl.mo3815b((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i += Character.charCount(codePointAt2);
                }
                return bwl.mo3887w();
            }
            i += Character.charCount(codePointAt);
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m9163a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: a */
    public static <T> int m9148a(T[] tArr, T t) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (m9164a((Object) tArr[i], (Object) t)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String[] m9166a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    /* renamed from: a */
    public static int m9145a(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    public static int m9167b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    public static String m9172c(String str, int i, int i2) {
        int a = m9145a(str, i, i2);
        return str.substring(a, m9167b(str, a, i2));
    }

    /* renamed from: a */
    public static int m9147a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    public static int m9146a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: d */
    public static String m9173d(String str) {
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !m9175f(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private static boolean m9175f(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m9174e(String str) {
        return f3586e.matcher(str).matches();
    }

    /* renamed from: a */
    public static String m9152a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
