package atakplugin.UASTool;

import atakplugin.UASTool.biy;
import atakplugin.UASTool.bjb;
import java.util.NoSuchElementException;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\bø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\f\u0010I\u001a\u000208*\u000208H\u0007\u001a\f\u0010I\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010J\u001a\u000208*\u0002082\u0006\u0010J\u001a\u00020KH\u0004\u001a\u0015\u0010J\u001a\u00020>*\u00020>2\u0006\u0010J\u001a\u00020LH\u0004\u001a\u001f\u0010M\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a\u001f\u0010M\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u001f\u0010M\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0004ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a\u001f\u0010M\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0004ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u0002\u0004\n\u0002\b\u0019¨\u0006V"}, mo1538e = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, mo1539f = "kotlin/ranges/URangesKt", mo1541h = 1)
class bjf {
    /* renamed from: a */
    private static final int m7244a(bja bja) {
        return bje.m7245a(bja, (bic) bic.f2709b);
    }

    /* renamed from: a */
    private static final long m7248a(bjd bjd) {
        return bje.m7249a(bjd, (bic) bic.f2709b);
    }

    /* renamed from: a */
    public static final int m7245a(bja bja, bic bic) {
        bfq.m6567f(bja, "$this$random");
        bfq.m6567f(bic, "random");
        try {
            return bie.m6988a(bic, bja);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: a */
    public static final long m7249a(bjd bjd, bic bic) {
        bfq.m6567f(bjd, "$this$random");
        bfq.m6567f(bic, "random");
        try {
            return bie.m6991a(bic, bjd);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    /* renamed from: a */
    private static final boolean m7261a(bja bja, aqc aqc) {
        bfq.m6567f(bja, "$this$contains");
        return aqc != null && bja.mo2634a(aqc.mo1603b());
    }

    /* renamed from: a */
    private static final boolean m7265a(bjd bjd, aqg aqg) {
        bfq.m6567f(bjd, "$this$contains");
        return aqg != null && bjd.mo2649a(aqg.mo1631b());
    }

    /* renamed from: a */
    public static final boolean m7259a(bja bja, byte b) {
        bfq.m6567f(bja, "$this$contains");
        return bja.mo2634a(aqc.m2761b(b & 255));
    }

    /* renamed from: a */
    public static final boolean m7263a(bjd bjd, byte b) {
        bfq.m6567f(bjd, "$this$contains");
        return bjd.mo2649a(aqg.m2843b(((long) b) & 255));
    }

    /* renamed from: a */
    public static final boolean m7264a(bjd bjd, int i) {
        bfq.m6567f(bjd, "$this$contains");
        return bjd.mo2649a(aqg.m2843b(((long) i) & 4294967295L));
    }

    /* renamed from: a */
    public static final boolean m7260a(bja bja, long j) {
        bfq.m6567f(bja, "$this$contains");
        return aqg.m2843b(j >>> 32) == 0 && bja.mo2634a(aqc.m2761b((int) j));
    }

    /* renamed from: a */
    public static final boolean m7262a(bja bja, short s) {
        bfq.m6567f(bja, "$this$contains");
        return bja.mo2634a(aqc.m2761b(s & 65535));
    }

    /* renamed from: a */
    public static final boolean m7266a(bjd bjd, short s) {
        bfq.m6567f(bjd, "$this$contains");
        return bjd.mo2649a(aqg.m2843b(((long) s) & 65535));
    }

    /* renamed from: a */
    public static final biy m7250a(byte b, byte b2) {
        return biy.f2754a.mo2632a(aqc.m2761b(b & 255), aqc.m2761b(b2 & 255), -1);
    }

    /* renamed from: a */
    public static final biy m7251a(int i, int i2) {
        return biy.f2754a.mo2632a(i, i2, -1);
    }

    /* renamed from: a */
    public static final bjb m7255a(long j, long j2) {
        return bjb.f2765a.mo2647a(j, j2, -1);
    }

    /* renamed from: a */
    public static final biy m7254a(short s, short s2) {
        return biy.f2754a.mo2632a(aqc.m2761b(s & 65535), aqc.m2761b(s2 & 65535), -1);
    }

    /* renamed from: a */
    public static final biy m7252a(biy biy) {
        bfq.m6567f(biy, "$this$reversed");
        return biy.f2754a.mo2632a(biy.mo2624b(), biy.mo2623a(), -biy.mo2625c());
    }

    /* renamed from: a */
    public static final bjb m7256a(bjb bjb) {
        bfq.m6567f(bjb, "$this$reversed");
        return bjb.f2765a.mo2647a(bjb.mo2639b(), bjb.mo2638a(), -bjb.mo2640c());
    }

    /* renamed from: a */
    public static final biy m7253a(biy biy, int i) {
        bfq.m6567f(biy, "$this$step");
        biu.m7088a(i > 0, (Number) Integer.valueOf(i));
        biy.C0173a aVar = biy.f2754a;
        int a = biy.mo2623a();
        int b = biy.mo2624b();
        if (biy.mo2625c() <= 0) {
            i = -i;
        }
        return aVar.mo2632a(a, b, i);
    }

    /* renamed from: a */
    public static final bjb m7257a(bjb bjb, long j) {
        bfq.m6567f(bjb, "$this$step");
        biu.m7088a(j > 0, (Number) Long.valueOf(j));
        bjb.C0176a aVar = bjb.f2765a;
        long a = bjb.mo2638a();
        long b = bjb.mo2639b();
        if (bjb.mo2640c() <= 0) {
            j = -j;
        }
        return aVar.mo2647a(a, b, j);
    }

    /* renamed from: b */
    public static final bja m7267b(byte b, byte b2) {
        byte b3 = b2 & 255;
        if (bfq.m6533a((int) b3, 0) <= 0) {
            return bja.f2763b.mo2637a();
        }
        return new bja(aqc.m2761b(b & 255), aqc.m2761b(aqc.m2761b(b3) - 1), (bfd) null);
    }

    /* renamed from: b */
    public static final bja m7268b(int i, int i2) {
        if (aqu.m3027a(i2, 0) <= 0) {
            return bja.f2763b.mo2637a();
        }
        return new bja(i, aqc.m2761b(i2 - 1), (bfd) null);
    }

    /* renamed from: b */
    public static final bjd m7270b(long j, long j2) {
        if (aqu.m3028a(j2, 0) <= 0) {
            return bjd.f2773b.mo2652a();
        }
        return new bjd(j, aqg.m2843b(j2 - aqg.m2843b(((long) 1) & 4294967295L)), (bfd) null);
    }

    /* renamed from: b */
    public static final bja m7269b(short s, short s2) {
        short s3 = s2 & 65535;
        if (bfq.m6533a((int) s3, 0) <= 0) {
            return bja.f2763b.mo2637a();
        }
        return new bja(aqc.m2761b(s & 65535), aqc.m2761b(aqc.m2761b(s3) - 1), (bfd) null);
    }

    /* renamed from: c */
    public static final int m7272c(int i, int i2) {
        return aqu.m3027a(i, i2) < 0 ? i2 : i;
    }

    /* renamed from: c */
    public static final long m7273c(long j, long j2) {
        return aqu.m3028a(j, j2) < 0 ? j2 : j;
    }

    /* renamed from: c */
    public static final byte m7271c(byte b, byte b2) {
        return bfq.m6533a((int) b & 255, (int) b2 & 255) < 0 ? b2 : b;
    }

    /* renamed from: c */
    public static final short m7274c(short s, short s2) {
        return bfq.m6533a((int) s & 65535, (int) 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: d */
    public static final int m7276d(int i, int i2) {
        return aqu.m3027a(i, i2) > 0 ? i2 : i;
    }

    /* renamed from: d */
    public static final long m7277d(long j, long j2) {
        return aqu.m3028a(j, j2) > 0 ? j2 : j;
    }

    /* renamed from: d */
    public static final byte m7275d(byte b, byte b2) {
        return bfq.m6533a((int) b & 255, (int) b2 & 255) > 0 ? b2 : b;
    }

    /* renamed from: d */
    public static final short m7278d(short s, short s2) {
        return bfq.m6533a((int) s & 65535, (int) 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: a */
    public static final int m7242a(int i, int i2, int i3) {
        if (aqu.m3027a(i2, i3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + aqc.m2757a(i3) + " is less than minimum " + aqc.m2757a(i2) + '.');
        } else if (aqu.m3027a(i, i2) < 0) {
            return i2;
        } else {
            return aqu.m3027a(i, i3) > 0 ? i3 : i;
        }
    }

    /* renamed from: a */
    public static final long m7246a(long j, long j2, long j3) {
        if (aqu.m3028a(j2, j3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + aqg.m2838a(j3) + " is less than minimum " + aqg.m2838a(j2) + '.');
        } else if (aqu.m3028a(j, j2) < 0) {
            return j2;
        } else {
            return aqu.m3028a(j, j3) > 0 ? j3 : j;
        }
    }

    /* renamed from: a */
    public static final byte m7241a(byte b, byte b2, byte b3) {
        byte b4 = b2 & 255;
        byte b5 = b3 & 255;
        if (bfq.m6533a((int) b4, (int) b5) <= 0) {
            byte b6 = b & 255;
            if (bfq.m6533a((int) b6, (int) b4) < 0) {
                return b2;
            }
            return bfq.m6533a((int) b6, (int) b5) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + apy.m2680a(b3) + " is less than minimum " + apy.m2680a(b2) + '.');
    }

    /* renamed from: a */
    public static final short m7258a(short s, short s2, short s3) {
        short s4 = s2 & 65535;
        short s5 = s3 & 65535;
        if (bfq.m6533a((int) s4, (int) s5) <= 0) {
            short s6 = 65535 & s;
            if (bfq.m6533a((int) s6, (int) s4) < 0) {
                return s2;
            }
            return bfq.m6533a((int) s6, (int) s5) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + aqm.m2947a(s3) + " is less than minimum " + aqm.m2947a(s2) + '.');
    }

    /* renamed from: a */
    public static final int m7243a(int i, bim<aqc> bim) {
        bfq.m6567f(bim, "range");
        if (bim instanceof bil) {
            return ((aqc) biu.m7131a(aqc.m2770c(i), (bil) bim)).mo1603b();
        }
        if (bim.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bim + '.');
        } else if (aqu.m3027a(i, bim.mo2569g().mo1603b()) < 0) {
            return bim.mo2569g().mo1603b();
        } else {
            return aqu.m3027a(i, bim.mo2571i().mo1603b()) > 0 ? bim.mo2571i().mo1603b() : i;
        }
    }

    /* renamed from: a */
    public static final long m7247a(long j, bim<aqg> bim) {
        bfq.m6567f(bim, "range");
        if (bim instanceof bil) {
            return ((aqg) biu.m7131a(aqg.m2851c(j), (bil) bim)).mo1631b();
        }
        if (bim.mo2558e()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + bim + '.');
        } else if (aqu.m3028a(j, bim.mo2569g().mo1631b()) < 0) {
            return bim.mo2569g().mo1631b();
        } else {
            return aqu.m3028a(j, bim.mo2571i().mo1631b()) > 0 ? bim.mo2571i().mo1631b() : j;
        }
    }
}
