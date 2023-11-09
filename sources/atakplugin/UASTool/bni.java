package atakplugin.UASTool;

import java.nio.charset.Charset;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¨\u0006\u0004"}, mo1538e = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"})
public final class bni {
    /* renamed from: a */
    private static final Charset m7757a(String str) {
        Charset forName = Charset.forName(str);
        bfq.m6554b(forName, "Charset.forName(charsetName)");
        return forName;
    }
}
