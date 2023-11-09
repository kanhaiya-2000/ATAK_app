package atakplugin.UASTool;

import android.util.Log;

/* renamed from: atakplugin.UASTool.sp */
public class C0841sp {

    /* renamed from: a */
    public static final String f6429a = "UTF-8";

    /* renamed from: b */
    private static final String f6430b = "sp";

    private C0841sp() {
    }

    /* renamed from: a */
    public static void m13731a(byte[] bArr, boolean z) {
        if (!z) {
            String str = f6430b;
            Log.i(str, "Data obtained from write buffer: " + new String(bArr));
            return;
        }
        String str2 = f6430b;
        Log.i(str2, "Data obtained from write buffer: " + new String(bArr));
        Log.i(str2, "Raw data from write buffer: " + C0861sw.m13871a(bArr));
        Log.i(str2, "Number of bytes obtained from write buffer: " + bArr.length);
    }

    /* renamed from: b */
    public static void m13732b(byte[] bArr, boolean z) {
        if (!z) {
            String str = f6430b;
            Log.i(str, "Data obtained pushed to write buffer: " + new String(bArr));
            return;
        }
        String str2 = f6430b;
        Log.i(str2, "Data obtained pushed to write buffer: " + new String(bArr));
        Log.i(str2, "Raw data pushed to write buffer: " + C0861sw.m13871a(bArr));
        Log.i(str2, "Number of bytes pushed from write buffer: " + bArr.length);
    }

    /* renamed from: c */
    public static void m13733c(byte[] bArr, boolean z) {
        if (!z) {
            String str = f6430b;
            Log.i(str, "Data obtained from Read buffer: " + new String(bArr));
            return;
        }
        String str2 = f6430b;
        Log.i(str2, "Data obtained from Read buffer: " + new String(bArr));
        Log.i(str2, "Raw data from Read buffer: " + C0861sw.m13871a(bArr));
        Log.i(str2, "Number of bytes obtained from Read buffer: " + bArr.length);
    }

    /* renamed from: d */
    public static void m13734d(byte[] bArr, boolean z) {
        if (!z) {
            String str = f6430b;
            Log.i(str, "Data obtained pushed to read buffer: " + new String(bArr));
            return;
        }
        String str2 = f6430b;
        Log.i(str2, "Data obtained pushed to read buffer: " + new String(bArr));
        Log.i(str2, "Raw data pushed to read buffer: " + C0861sw.m13871a(bArr));
        Log.i(str2, "Number of bytes pushed from read buffer: " + bArr.length);
    }
}
