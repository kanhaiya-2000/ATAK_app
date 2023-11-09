package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\f\u0010\t\u001a\u00020\u0003*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0000*\n\u0010\f\"\u00020\r2\u00020\r*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015¨\u0006\u0016"}, mo1538e = {"arraycopy", "", "src", "", "srcPos", "", "dest", "destPos", "length", "asUtf8ToByteArray", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "JvmField", "Lkotlin/jvm/JvmField;", "JvmName", "Lkotlin/jvm/JvmName;", "JvmOverloads", "Lkotlin/jvm/JvmOverloads;", "JvmStatic", "Lkotlin/jvm/JvmStatic;", "jvm"})
public final class bwf {
    /* renamed from: a */
    public static final void m9943a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        bfq.m6567f(bArr, "src");
        bfq.m6567f(bArr2, "dest");
        System.arraycopy(bArr, i, bArr2, i2, i3);
    }

    /* renamed from: a */
    public static final String m9942a(byte[] bArr) {
        bfq.m6567f(bArr, "$receiver");
        return new String(bArr, bnh.f2996a);
    }

    /* renamed from: a */
    public static final byte[] m9944a(String str) {
        bfq.m6567f(str, "$receiver");
        byte[] bytes = str.getBytes(bnh.f2996a);
        bfq.m6554b(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
