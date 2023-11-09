package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.util.Arrays;

@aot(mo1534a = 2, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0016\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\tH\u0000\u001a\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0011H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0011H\u0000\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0011H\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\tH\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u001b\u001a\u00020\u0019*\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u001cH\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0007H\u0000\u001a\f\u0010 \u001a\u00020\u0007*\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0007*\u00020\u0001H\u0000\u001a\f\u0010\"\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\u001c\u0010#\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0007H\u0000\u001a\f\u0010%\u001a\u00020\t*\u00020\u0001H\u0000\u001a,\u0010&\u001a\u00020\u0019*\u00020\u00012\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0000\u001a,\u0010&\u001a\u00020\u0019*\u00020\u00012\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0000\u001a\u0014\u0010*\u001a\u00020\u0019*\u00020\u00012\u0006\u0010+\u001a\u00020\tH\u0000\u001a\u0014\u0010*\u001a\u00020\u0019*\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0000\u001a\u001c\u0010,\u001a\u00020\u0001*\u00020\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0000\u001a\f\u0010/\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u00100\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u00101\u001a\u00020\t*\u00020\u0001H\u0000\u001a\f\u00102\u001a\u00020\u0011*\u00020\u0001H\u0000\u001a\f\u00103\u001a\u00020\u0011*\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, mo1538e = {"COMMON_EMPTY", "Lokio/ByteString;", "getCOMMON_EMPTY", "()Lokio/ByteString;", "HEX_DIGITS", "", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonRangeEquals", "offset", "otherOffset", "byteCount", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToString", "commonUtf8", "jvm"})
public final class bxv {

    /* renamed from: a */
    private static final char[] f4227a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final bwq f4228b = bwq.f4134b.mo3963a(new byte[0]);

    /* renamed from: a */
    public static final String m10518a(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        String b = bwq.mo3924b();
        if (b != null) {
            return b;
        }
        String a = bwf.m9942a(bwq.mo3957t());
        bwq.mo3916a(a);
        return a;
    }

    /* renamed from: b */
    public static final String m10525b(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        return bvx.m9913a(bwq.mo3957t(), (byte[]) null, 1, (Object) null);
    }

    /* renamed from: c */
    public static final String m10530c(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        return bvx.m9912a(bwq.mo3957t(), bvx.m9916b());
    }

    /* renamed from: d */
    public static final String m10531d(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        char[] cArr = new char[(bwq.mo3957t().length * 2)];
        int i = 0;
        for (byte b : bwq.mo3957t()) {
            int i2 = i + 1;
            char[] cArr2 = f4227a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & Ascii.f8523SI];
        }
        return new String(cArr);
    }

    /* renamed from: e */
    public static final bwq m10532e(bwq bwq) {
        byte b;
        bfq.m6567f(bwq, "$receiver");
        int i = 0;
        while (i < bwq.mo3957t().length) {
            byte b2 = bwq.mo3957t()[i];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i++;
            } else {
                byte[] t = bwq.mo3957t();
                byte[] copyOf = Arrays.copyOf(t, t.length);
                bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new bwq(copyOf);
            }
        }
        return bwq;
    }

    /* renamed from: f */
    public static final bwq m10533f(bwq bwq) {
        byte b;
        bfq.m6567f(bwq, "$receiver");
        int i = 0;
        while (i < bwq.mo3957t().length) {
            byte b2 = bwq.mo3957t()[i];
            byte b3 = (byte) 97;
            if (b2 < b3 || b2 > (b = (byte) 122)) {
                i++;
            } else {
                byte[] t = bwq.mo3957t();
                byte[] copyOf = Arrays.copyOf(t, t.length);
                bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new bwq(copyOf);
            }
        }
        return bwq;
    }

    /* renamed from: a */
    public static final bwq m10515a(bwq bwq, int i, int i2) {
        bfq.m6567f(bwq, "$receiver");
        boolean z = true;
        if (i >= 0) {
            if (i2 <= bwq.mo3957t().length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i == 0 && i2 == bwq.mo3957t().length) {
                    return bwq;
                } else {
                    byte[] bArr = new byte[i3];
                    bwf.m9943a(bwq.mo3957t(), i, bArr, 0, i3);
                    return new bwq(bArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + bwq.mo3957t().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    /* renamed from: a */
    public static final byte m10510a(bwq bwq, int i) {
        bfq.m6567f(bwq, "$receiver");
        return bwq.mo3957t()[i];
    }

    /* renamed from: g */
    public static final int m10534g(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        return bwq.mo3957t().length;
    }

    /* renamed from: h */
    public static final byte[] m10535h(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        byte[] t = bwq.mo3957t();
        byte[] copyOf = Arrays.copyOf(t, t.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    /* renamed from: i */
    public static final byte[] m10536i(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        return bwq.mo3957t();
    }

    /* renamed from: a */
    public static final boolean m10519a(bwq bwq, int i, bwq bwq2, int i2, int i3) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bwq2, "other");
        return bwq2.mo3918a(i2, bwq.mo3957t(), i, i3);
    }

    /* renamed from: a */
    public static final boolean m10520a(bwq bwq, int i, byte[] bArr, int i2, int i3) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bArr, "other");
        return i >= 0 && i <= bwq.mo3957t().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && bwg.m9953a(bwq.mo3957t(), i, bArr, i2, i3);
    }

    /* renamed from: a */
    public static final boolean m10521a(bwq bwq, bwq bwq2) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bwq2, "prefix");
        return bwq.mo3917a(0, bwq2, 0, bwq2.mo3951n());
    }

    /* renamed from: a */
    public static final boolean m10523a(bwq bwq, byte[] bArr) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bArr, "prefix");
        return bwq.mo3918a(0, bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static final boolean m10526b(bwq bwq, bwq bwq2) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bwq2, "suffix");
        return bwq.mo3917a(bwq.mo3951n() - bwq2.mo3951n(), bwq2, 0, bwq2.mo3951n());
    }

    /* renamed from: b */
    public static final boolean m10527b(bwq bwq, byte[] bArr) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bArr, "suffix");
        return bwq.mo3918a(bwq.mo3951n() - bArr.length, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static final int m10512a(bwq bwq, byte[] bArr, int i) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bArr, "other");
        int length = bwq.mo3957t().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!bwg.m9953a(bwq.mo3957t(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    /* renamed from: a */
    public static final boolean m10522a(bwq bwq, Object obj) {
        bfq.m6567f(bwq, "$receiver");
        if (obj == bwq) {
            return true;
        }
        if (obj instanceof bwq) {
            bwq bwq2 = (bwq) obj;
            return bwq2.mo3951n() == bwq.mo3957t().length && bwq2.mo3918a(0, bwq.mo3957t(), 0, bwq.mo3957t().length);
        }
    }

    /* renamed from: j */
    public static final int m10537j(bwq bwq) {
        bfq.m6567f(bwq, "$receiver");
        int a = bwq.mo3907a();
        if (a != 0) {
            return a;
        }
        bwq.mo3913a(Arrays.hashCode(bwq.mo3957t()));
        return bwq.mo3907a();
    }

    /* renamed from: c */
    public static final int m10528c(bwq bwq, bwq bwq2) {
        bfq.m6567f(bwq, "$receiver");
        bfq.m6567f(bwq2, "other");
        int n = bwq.mo3951n();
        int n2 = bwq2.mo3951n();
        int min = Math.min(n, n2);
        int i = 0;
        while (i < min) {
            byte d = bwq.mo3931d(i) & 255;
            byte d2 = bwq2.mo3931d(i) & 255;
            if (d == d2) {
                i++;
            } else if (d < d2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (n == n2) {
            return 0;
        }
        if (n < n2) {
            return -1;
        }
        return 1;
    }

    /* renamed from: a */
    public static final bwq m10514a() {
        return f4228b;
    }

    /* renamed from: a */
    public static final bwq m10517a(byte[] bArr) {
        bfq.m6567f(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        bfq.m6554b(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new bwq(copyOf);
    }

    /* renamed from: a */
    public static final bwq m10516a(String str) {
        bfq.m6567f(str, "$receiver");
        bwq bwq = new bwq(bwf.m9944a(str));
        bwq.mo3916a(str);
        return bwq;
    }

    /* renamed from: b */
    public static final bwq m10524b(String str) {
        bfq.m6567f(str, "$receiver");
        byte[] a = bvx.m9915a(str);
        if (a != null) {
            return new bwq(a);
        }
        return null;
    }

    /* renamed from: c */
    public static final bwq m10529c(String str) {
        bfq.m6567f(str, "$receiver");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((m10511a(str.charAt(i2)) << 4) + m10511a(str.charAt(i2 + 1)));
            }
            return new bwq(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    /* renamed from: a */
    private static final int m10511a(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: k */
    public static final String m10538k(bwq bwq) {
        bwq bwq2 = bwq;
        bfq.m6567f(bwq2, "$receiver");
        if (bwq.mo3957t().length == 0) {
            return "[size=0]";
        }
        int a = m10513a(bwq.mo3957t(), 64);
        if (a != -1) {
            String c = bwq.mo3929c();
            if (c != null) {
                String substring = c.substring(0, a);
                bfq.m6554b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String a2 = boc.m8008a(boc.m8008a(boc.m8008a(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (a < c.length()) {
                    return "[size=" + bwq.mo3957t().length + " text=" + a2 + "…]";
                }
                return "[text=" + a2 + ']';
            }
            throw new apx("null cannot be cast to non-null type java.lang.String");
        } else if (bwq.mo3957t().length <= 64) {
            return "[hex=" + bwq.mo3947j() + ']';
        } else {
            return "[size=" + bwq.mo3957t().length + " hex=" + m10515a(bwq2, 0, 64).mo3947j() + "…]";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0068, code lost:
        return -1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m10513a(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x01d7
            byte r7 = r0[r4]
            r8 = 127(0x7f, float:1.78E-43)
            r9 = 159(0x9f, float:2.23E-43)
            r10 = 31
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x0071
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0038
            if (r7 == r11) goto L_0x0038
            if (r7 < 0) goto L_0x002e
            if (r10 >= r7) goto L_0x0033
        L_0x002e:
            if (r8 <= r7) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            if (r9 < r7) goto L_0x0035
        L_0x0033:
            r6 = 1
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            if (r6 != 0) goto L_0x003a
        L_0x0038:
            if (r7 != r12) goto L_0x003b
        L_0x003a:
            return r16
        L_0x003b:
            if (r7 >= r14) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = 2
        L_0x0040:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x0043:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r7 = r4 + 1
            byte r4 = r0[r4]
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0054
            return r5
        L_0x0054:
            if (r4 == r13) goto L_0x0066
            if (r4 == r11) goto L_0x0066
            if (r4 < 0) goto L_0x005c
            if (r10 >= r4) goto L_0x0061
        L_0x005c:
            if (r8 <= r4) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            if (r9 < r4) goto L_0x0063
        L_0x0061:
            r6 = 1
            goto L_0x0064
        L_0x0063:
            r6 = 0
        L_0x0064:
            if (r6 != 0) goto L_0x0068
        L_0x0066:
            if (r4 != r12) goto L_0x0069
        L_0x0068:
            return r16
        L_0x0069:
            if (r4 >= r14) goto L_0x006d
            r4 = 1
            goto L_0x006e
        L_0x006d:
            r4 = 2
        L_0x006e:
            int r5 = r5 + r4
            r4 = r7
            goto L_0x0043
        L_0x0071:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00c3
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0080
            if (r6 != r1) goto L_0x007f
            return r5
        L_0x007f:
            return r16
        L_0x0080:
            byte r7 = r0[r4]
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x008a
            r15 = 1
            goto L_0x008b
        L_0x008a:
            r15 = 0
        L_0x008b:
            if (r15 != 0) goto L_0x0091
            if (r6 != r1) goto L_0x0090
            return r5
        L_0x0090:
            return r16
        L_0x0091:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x009c
            if (r6 != r1) goto L_0x009b
            return r5
        L_0x009b:
            return r16
        L_0x009c:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00a1
            return r5
        L_0x00a1:
            if (r3 == r13) goto L_0x00b3
            if (r3 == r11) goto L_0x00b3
            if (r3 < 0) goto L_0x00a9
            if (r10 >= r3) goto L_0x00ae
        L_0x00a9:
            if (r8 <= r3) goto L_0x00ac
            goto L_0x00b0
        L_0x00ac:
            if (r9 < r3) goto L_0x00b0
        L_0x00ae:
            r6 = 1
            goto L_0x00b1
        L_0x00b0:
            r6 = 0
        L_0x00b1:
            if (r6 != 0) goto L_0x00b5
        L_0x00b3:
            if (r3 != r12) goto L_0x00b6
        L_0x00b5:
            return r16
        L_0x00b6:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00bc
            r15 = 1
            goto L_0x00bd
        L_0x00bc:
            r15 = 2
        L_0x00bd:
            int r5 = r5 + r15
            int r4 = r4 + 2
        L_0x00c0:
            r6 = r7
            goto L_0x0008
        L_0x00c3:
            int r3 = r7 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r9 = 57343(0xdfff, float:8.0355E-41)
            if (r3 != r15) goto L_0x013e
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00d5
            if (r6 != r1) goto L_0x00d4
            return r5
        L_0x00d4:
            return r16
        L_0x00d5:
            byte r7 = r0[r4]
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r8 = r15 & 192(0xc0, float:2.69E-43)
            if (r8 != r14) goto L_0x00e1
            r8 = 1
            goto L_0x00e2
        L_0x00e1:
            r8 = 0
        L_0x00e2:
            if (r8 != 0) goto L_0x00e8
            if (r6 != r1) goto L_0x00e7
            return r5
        L_0x00e7:
            return r16
        L_0x00e8:
            byte r3 = r0[r3]
            r8 = r3 & 192(0xc0, float:2.69E-43)
            if (r8 != r14) goto L_0x00f0
            r8 = 1
            goto L_0x00f1
        L_0x00f0:
            r8 = 0
        L_0x00f1:
            if (r8 != 0) goto L_0x00f7
            if (r6 != r1) goto L_0x00f6
            return r5
        L_0x00f6:
            return r16
        L_0x00f7:
            r8 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r8
            int r8 = r15 << 6
            r3 = r3 ^ r8
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0109
            if (r6 != r1) goto L_0x0108
            return r5
        L_0x0108:
            return r16
        L_0x0109:
            if (r12 <= r3) goto L_0x010c
            goto L_0x0112
        L_0x010c:
            if (r9 < r3) goto L_0x0112
            if (r6 != r1) goto L_0x0111
            return r5
        L_0x0111:
            return r16
        L_0x0112:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0117
            return r5
        L_0x0117:
            if (r3 == r13) goto L_0x012d
            if (r3 == r11) goto L_0x012d
            if (r3 < 0) goto L_0x011f
            if (r10 >= r3) goto L_0x0128
        L_0x011f:
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 <= r3) goto L_0x0124
            goto L_0x012a
        L_0x0124:
            r6 = 159(0x9f, float:2.23E-43)
            if (r6 < r3) goto L_0x012a
        L_0x0128:
            r6 = 1
            goto L_0x012b
        L_0x012a:
            r6 = 0
        L_0x012b:
            if (r6 != 0) goto L_0x0132
        L_0x012d:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0133
        L_0x0132:
            return r16
        L_0x0133:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0139
            r15 = 1
            goto L_0x013a
        L_0x0139:
            r15 = 2
        L_0x013a:
            int r5 = r5 + r15
            int r4 = r4 + 3
            goto L_0x00c0
        L_0x013e:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x01d3
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x014a
            if (r6 != r1) goto L_0x0149
            return r5
        L_0x0149:
            return r16
        L_0x014a:
            byte r7 = r0[r4]
            int r8 = r4 + 1
            byte r8 = r0[r8]
            r15 = r8 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x0156
            r15 = 1
            goto L_0x0157
        L_0x0156:
            r15 = 0
        L_0x0157:
            if (r15 != 0) goto L_0x015d
            if (r6 != r1) goto L_0x015c
            return r5
        L_0x015c:
            return r16
        L_0x015d:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x0167
            r10 = 1
            goto L_0x0168
        L_0x0167:
            r10 = 0
        L_0x0168:
            if (r10 != 0) goto L_0x016e
            if (r6 != r1) goto L_0x016d
            return r5
        L_0x016d:
            return r16
        L_0x016e:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x0176
            r10 = 1
            goto L_0x0177
        L_0x0176:
            r10 = 0
        L_0x0177:
            if (r10 != 0) goto L_0x017d
            if (r6 != r1) goto L_0x017c
            return r5
        L_0x017c:
            return r16
        L_0x017d:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r8 = r8 << 12
            r3 = r3 ^ r8
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x0193
            if (r6 != r1) goto L_0x0192
            return r5
        L_0x0192:
            return r16
        L_0x0193:
            if (r12 <= r3) goto L_0x0196
            goto L_0x019c
        L_0x0196:
            if (r9 < r3) goto L_0x019c
            if (r6 != r1) goto L_0x019b
            return r5
        L_0x019b:
            return r16
        L_0x019c:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01a4
            if (r6 != r1) goto L_0x01a3
            return r5
        L_0x01a3:
            return r16
        L_0x01a4:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01a9
            return r5
        L_0x01a9:
            if (r3 == r13) goto L_0x01c1
            if (r3 == r11) goto L_0x01c1
            if (r3 < 0) goto L_0x01b3
            r6 = 31
            if (r6 >= r3) goto L_0x01bc
        L_0x01b3:
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 <= r3) goto L_0x01b8
            goto L_0x01be
        L_0x01b8:
            r6 = 159(0x9f, float:2.23E-43)
            if (r6 < r3) goto L_0x01be
        L_0x01bc:
            r6 = 1
            goto L_0x01bf
        L_0x01be:
            r6 = 0
        L_0x01bf:
            if (r6 != 0) goto L_0x01c6
        L_0x01c1:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x01c7
        L_0x01c6:
            return r16
        L_0x01c7:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x01cd
            r15 = 1
            goto L_0x01ce
        L_0x01cd:
            r15 = 2
        L_0x01ce:
            int r5 = r5 + r15
            int r4 = r4 + 4
            goto L_0x00c0
        L_0x01d3:
            if (r6 != r1) goto L_0x01d6
            return r5
        L_0x01d6:
            return r16
        L_0x01d7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bxv.m10513a(byte[], int):int");
    }
}
