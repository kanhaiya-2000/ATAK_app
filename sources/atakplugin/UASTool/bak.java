package atakplugin.UASTool;

import java.lang.reflect.Field;
import java.util.ArrayList;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo1538e = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"})
public final class bak {

    /* renamed from: a */
    private static final int f2486a = 1;

    /* renamed from: a */
    public static final StackTraceElement m6141a(bae bae) {
        int i;
        String str;
        bfq.m6567f(bae, "$this$getStackTraceElementImpl");
        baj c = m6144c(bae);
        if (c == null) {
            return null;
        }
        m6142a(1, c.mo2222a());
        int d = m6145d(bae);
        if (d < 0) {
            i = -1;
        } else {
            i = c.mo2224c()[d];
        }
        String a = bam.f2488b.mo2230a(bae);
        if (a == null) {
            str = c.mo2229h();
        } else {
            str = a + '/' + c.mo2229h();
        }
        return new StackTraceElement(str, c.mo2228g(), c.mo2223b(), i);
    }

    /* renamed from: c */
    private static final baj m6144c(bae bae) {
        return (baj) bae.getClass().getAnnotation(baj.class);
    }

    /* renamed from: d */
    private static final int m6145d(bae bae) {
        try {
            Field declaredField = bae.getClass().getDeclaredField("label");
            bfq.m6554b(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(bae);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static final void m6142a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
        }
    }

    /* renamed from: b */
    public static final String[] m6143b(bae bae) {
        bfq.m6567f(bae, "$this$getSpilledVariableFieldMapping");
        baj c = m6144c(bae);
        if (c == null) {
            return null;
        }
        m6142a(1, c.mo2222a());
        ArrayList arrayList = new ArrayList();
        int d = m6145d(bae);
        int[] f = c.mo2227f();
        int length = f.length;
        for (int i = 0; i < length; i++) {
            if (f[i] == d) {
                arrayList.add(c.mo2226e()[i]);
                arrayList.add(c.mo2225d()[i]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new apx("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
