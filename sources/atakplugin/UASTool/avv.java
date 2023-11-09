package atakplugin.UASTool;

import java.util.Arrays;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0004ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0004ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001e\u0010&\u001a\u00020+*\u00020\t2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001e\u0010&\u001a\u00020.*\u00020\f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001e\u0010&\u001a\u000201*\u00020\u000f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020'05*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020+05*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020.05*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020105*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, mo1538e = {"Lkotlin/collections/UArraysKt;", "", "()V", "contentEquals", "", "Lkotlin/UByteArray;", "other", "contentEquals-kdPth3s", "([B[B)Z", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "random", "Lkotlin/UByte;", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "toTypedArray", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "kotlin-stdlib"})
@anx(mo1516a = "Provided for binary compatibility", mo1518c = any.HIDDEN)
public final class avv {

    /* renamed from: a */
    public static final avv f2323a = new avv();

    private avv() {
    }

    @bcz
    /* renamed from: a */
    public static final int m5143a(int[] iArr, bic bic) {
        bfq.m6567f(iArr, "$this$random");
        bfq.m6567f(bic, "random");
        if (!aqd.m2816c(iArr)) {
            return aqd.m2807a(iArr, bic.mo2529b(aqd.m2806a(iArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @bcz
    /* renamed from: a */
    public static final long m5146a(long[] jArr, bic bic) {
        bfq.m6567f(jArr, "$this$random");
        bfq.m6567f(bic, "random");
        if (!aqh.m2897c(jArr)) {
            return aqh.m2888a(jArr, bic.mo2529b(aqh.m2887a(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @bcz
    /* renamed from: a */
    public static final byte m5140a(byte[] bArr, bic bic) {
        bfq.m6567f(bArr, "$this$random");
        bfq.m6567f(bic, "random");
        if (!apz.m2737c(bArr)) {
            return apz.m2727a(bArr, bic.mo2529b(apz.m2728a(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @bcz
    /* renamed from: a */
    public static final short m5147a(short[] sArr, bic bic) {
        bfq.m6567f(sArr, "$this$random");
        bfq.m6567f(bic, "random");
        if (!aqn.m3004c(sArr)) {
            return aqn.m2995a(sArr, bic.mo2529b(aqn.m2994a(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @bcz
    /* renamed from: a */
    public static final boolean m5149a(int[] iArr, int[] iArr2) {
        bfq.m6567f(iArr, "$this$contentEquals");
        bfq.m6567f(iArr2, "other");
        return Arrays.equals(iArr, iArr2);
    }

    @bcz
    /* renamed from: a */
    public static final boolean m5150a(long[] jArr, long[] jArr2) {
        bfq.m6567f(jArr, "$this$contentEquals");
        bfq.m6567f(jArr2, "other");
        return Arrays.equals(jArr, jArr2);
    }

    @bcz
    /* renamed from: a */
    public static final boolean m5148a(byte[] bArr, byte[] bArr2) {
        bfq.m6567f(bArr, "$this$contentEquals");
        bfq.m6567f(bArr2, "other");
        return Arrays.equals(bArr, bArr2);
    }

    @bcz
    /* renamed from: a */
    public static final boolean m5151a(short[] sArr, short[] sArr2) {
        bfq.m6567f(sArr, "$this$contentEquals");
        bfq.m6567f(sArr2, "other");
        return Arrays.equals(sArr, sArr2);
    }

    @bcz
    /* renamed from: a */
    public static final int m5142a(int[] iArr) {
        bfq.m6567f(iArr, "$this$contentHashCode");
        return Arrays.hashCode(iArr);
    }

    @bcz
    /* renamed from: a */
    public static final int m5144a(long[] jArr) {
        bfq.m6567f(jArr, "$this$contentHashCode");
        return Arrays.hashCode(jArr);
    }

    @bcz
    /* renamed from: a */
    public static final int m5141a(byte[] bArr) {
        bfq.m6567f(bArr, "$this$contentHashCode");
        return Arrays.hashCode(bArr);
    }

    @bcz
    /* renamed from: a */
    public static final int m5145a(short[] sArr) {
        bfq.m6567f(sArr, "$this$contentHashCode");
        return Arrays.hashCode(sArr);
    }

    @bcz
    /* renamed from: b */
    public static final String m5153b(int[] iArr) {
        bfq.m6567f(iArr, "$this$contentToString");
        return ato.m4738a(bfq.m6567f(iArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (bdl) null, 56, (Object) null);
    }

    @bcz
    /* renamed from: b */
    public static final String m5154b(long[] jArr) {
        bfq.m6567f(jArr, "$this$contentToString");
        return ato.m4738a(bfq.m6567f(jArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (bdl) null, 56, (Object) null);
    }

    @bcz
    /* renamed from: b */
    public static final String m5152b(byte[] bArr) {
        bfq.m6567f(bArr, "$this$contentToString");
        return ato.m4738a(bfq.m6567f(bArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (bdl) null, 56, (Object) null);
    }

    @bcz
    /* renamed from: b */
    public static final String m5155b(short[] sArr) {
        bfq.m6567f(sArr, "$this$contentToString");
        return ato.m4738a(bfq.m6567f(sArr, "v"), ", ", "[", "]", 0, (CharSequence) null, (bdl) null, 56, (Object) null);
    }

    @bcz
    /* renamed from: c */
    public static final aqc[] m5157c(int[] iArr) {
        bfq.m6567f(iArr, "$this$toTypedArray");
        int a = aqd.m2806a(iArr);
        aqc[] aqcArr = new aqc[a];
        for (int i = 0; i < a; i++) {
            aqcArr[i] = aqc.m2770c(aqd.m2807a(iArr, i));
        }
        return aqcArr;
    }

    @bcz
    /* renamed from: c */
    public static final aqg[] m5158c(long[] jArr) {
        bfq.m6567f(jArr, "$this$toTypedArray");
        int a = aqh.m2887a(jArr);
        aqg[] aqgArr = new aqg[a];
        for (int i = 0; i < a; i++) {
            aqgArr[i] = aqg.m2851c(aqh.m2888a(jArr, i));
        }
        return aqgArr;
    }

    @bcz
    /* renamed from: c */
    public static final apy[] m5156c(byte[] bArr) {
        bfq.m6567f(bArr, "$this$toTypedArray");
        int a = apz.m2728a(bArr);
        apy[] apyArr = new apy[a];
        for (int i = 0; i < a; i++) {
            apyArr[i] = apy.m2693c(apz.m2727a(bArr, i));
        }
        return apyArr;
    }

    @bcz
    /* renamed from: c */
    public static final aqm[] m5159c(short[] sArr) {
        bfq.m6567f(sArr, "$this$toTypedArray");
        int a = aqn.m2994a(sArr);
        aqm[] aqmArr = new aqm[a];
        for (int i = 0; i < a; i++) {
            aqmArr[i] = aqm.m2960c(aqn.m2995a(sArr, i));
        }
        return aqmArr;
    }
}
