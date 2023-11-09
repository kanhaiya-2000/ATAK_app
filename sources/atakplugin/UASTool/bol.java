package atakplugin.UASTool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000X\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\b\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u001b*\u00020\u0003H\b\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0003H\b\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0003H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010!\u001a\u00020\"*\u00020\u0003H\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\b¨\u0006$"}, mo1538e = {"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bol extends bok {
    /* renamed from: a */
    private static final String m7966a(byte b, int i) {
        String num = Integer.toString(b, bne.m7730a(bne.m7730a(i)));
        bfq.m6554b(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m7969a(short s, int i) {
        String num = Integer.toString(s, bne.m7730a(bne.m7730a(i)));
        bfq.m6554b(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m7967a(int i, int i2) {
        String num = Integer.toString(i, bne.m7730a(i2));
        bfq.m6554b(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m7968a(long j, int i) {
        String l = Long.toString(j, bne.m7730a(i));
        bfq.m6554b(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    /* renamed from: f */
    private static final boolean m7982f(String str) {
        return Boolean.parseBoolean(str);
    }

    /* renamed from: g */
    private static final byte m7983g(String str) {
        return Byte.parseByte(str);
    }

    /* renamed from: b */
    private static final byte m7972b(String str, int i) {
        return Byte.parseByte(str, bne.m7730a(i));
    }

    /* renamed from: h */
    private static final short m7984h(String str) {
        return Short.parseShort(str);
    }

    /* renamed from: c */
    private static final short m7976c(String str, int i) {
        return Short.parseShort(str, bne.m7730a(i));
    }

    /* renamed from: i */
    private static final int m7985i(String str) {
        return Integer.parseInt(str);
    }

    /* renamed from: d */
    private static final int m7977d(String str, int i) {
        return Integer.parseInt(str, bne.m7730a(i));
    }

    /* renamed from: j */
    private static final long m7986j(String str) {
        return Long.parseLong(str);
    }

    /* renamed from: e */
    private static final long m7979e(String str, int i) {
        return Long.parseLong(str, bne.m7730a(i));
    }

    /* renamed from: k */
    private static final float m7987k(String str) {
        return Float.parseFloat(str);
    }

    /* renamed from: l */
    private static final double m7988l(String str) {
        return Double.parseDouble(str);
    }

    /* renamed from: m */
    private static final BigInteger m7989m(String str) {
        return new BigInteger(str);
    }

    /* renamed from: f */
    private static final BigInteger m7981f(String str, int i) {
        return new BigInteger(str, bne.m7730a(i));
    }

    /* renamed from: d */
    public static final BigInteger m7978d(String str) {
        bfq.m6567f(str, "$this$toBigIntegerOrNull");
        return boc.m7971a(str, 10);
    }

    /* renamed from: a */
    public static final BigInteger m7971a(String str, int i) {
        bfq.m6567f(str, "$this$toBigIntegerOrNull");
        bne.m7730a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                if (bne.m7729a(str.charAt(i2), i) < 0) {
                    return null;
                }
                i2++;
            }
        } else if (bne.m7729a(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, bne.m7730a(i));
    }

    /* renamed from: n */
    private static final BigDecimal m7990n(String str) {
        return new BigDecimal(str);
    }

    /* renamed from: b */
    private static final BigDecimal m7974b(String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    /* renamed from: a */
    private static final <T> T m7965a(String str, bdl<? super String, ? extends T> bdl) {
        try {
            if (bob.f3053a.mo2865a(str)) {
                return bdl.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static final Float m7973b(String str) {
        bfq.m6567f(str, "$this$toFloatOrNull");
        try {
            if (bob.f3053a.mo2865a(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static final Double m7975c(String str) {
        bfq.m6567f(str, "$this$toDoubleOrNull");
        try {
            if (bob.f3053a.mo2865a(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static final BigDecimal m7980e(String str) {
        bfq.m6567f(str, "$this$toBigDecimalOrNull");
        try {
            if (bob.f3053a.mo2865a(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static final BigDecimal m7970a(String str, MathContext mathContext) {
        bfq.m6567f(str, "$this$toBigDecimalOrNull");
        bfq.m6567f(mathContext, "mathContext");
        try {
            if (bob.f3053a.mo2865a(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
