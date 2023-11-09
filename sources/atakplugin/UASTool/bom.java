package atakplugin.UASTool;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, mo1538e = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, mo1539f = "kotlin/text/StringsKt", mo1541h = 1)
class bom extends bol {
    /* renamed from: f */
    public static final Byte m7995f(String str) {
        bfq.m6567f(str, "$this$toByteOrNull");
        return boc.m7991b(str, 10);
    }

    /* renamed from: b */
    public static final Byte m7991b(String str, int i) {
        int intValue;
        bfq.m6567f(str, "$this$toByteOrNull");
        Integer d = boc.m7993d(str, i);
        if (d == null || (intValue = d.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    /* renamed from: g */
    public static final Short m7996g(String str) {
        bfq.m6567f(str, "$this$toShortOrNull");
        return boc.m7992c(str, 10);
    }

    /* renamed from: c */
    public static final Short m7992c(String str, int i) {
        int intValue;
        bfq.m6567f(str, "$this$toShortOrNull");
        Integer d = boc.m7993d(str, i);
        if (d == null || (intValue = d.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    /* renamed from: h */
    public static final Integer m7997h(String str) {
        bfq.m6567f(str, "$this$toIntOrNull");
        return boc.m7993d(str, 10);
    }

    /* renamed from: d */
    public static final Integer m7993d(String str, int i) {
        boolean z;
        int i2;
        bfq.m6567f(str, "$this$toIntOrNull");
        bne.m7730a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (charAt >= '0') {
            z = false;
            i5 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int a = bne.m7729a(str.charAt(i5), i);
            if (a < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + a) {
                return null;
            }
            i3 = i2 - a;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    /* renamed from: i */
    public static final Long m7998i(String str) {
        bfq.m6567f(str, "$this$toLongOrNull");
        return boc.m7994e(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long m7994e(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "$this$toLongOrNull"
            atakplugin.UASTool.bfq.m6567f(r0, r2)
            atakplugin.UASTool.bne.m7730a((int) r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r5 >= r6) goto L_0x0035
            if (r2 != r9) goto L_0x0026
            return r3
        L_0x0026:
            r6 = 45
            if (r5 != r6) goto L_0x002e
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x0036
        L_0x002e:
            r6 = 43
            if (r5 != r6) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            return r3
        L_0x0035:
            r9 = 0
        L_0x0036:
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r5
        L_0x003e:
            if (r4 >= r2) goto L_0x006f
            char r14 = r0.charAt(r4)
            int r14 = atakplugin.UASTool.bne.m7729a(r14, r1)
            if (r14 >= 0) goto L_0x004b
            return r3
        L_0x004b:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L_0x005b
            int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x005a
            long r12 = (long) r1
            long r12 = r7 / r12
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 >= 0) goto L_0x005b
        L_0x005a:
            return r3
        L_0x005b:
            long r5 = (long) r1
            long r10 = r10 * r5
            long r5 = (long) r14
            long r16 = r7 + r5
            int r14 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x0066
            return r3
        L_0x0066:
            long r10 = r10 - r5
            int r4 = r4 + 1
            r5 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L_0x003e
        L_0x006f:
            if (r9 == 0) goto L_0x0076
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L_0x007b
        L_0x0076:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.bom.m7994e(java.lang.String, int):java.lang.Long");
    }

    /* renamed from: j */
    public static final Void m7999j(String str) {
        bfq.m6567f(str, "input");
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }
}
