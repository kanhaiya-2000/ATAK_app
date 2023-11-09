package atakplugin.UASTool;

import java.util.Map;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, mo1538e = {"Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"})
public enum bnc {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    

    /* renamed from: u */
    public static final C0200a f2990u = null;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public static final aon f2992x = null;

    /* renamed from: w */
    private final int f2993w;

    private bnc(int i) {
        this.f2993w = i;
    }

    /* renamed from: a */
    public final int mo2815a() {
        return this.f2993w;
    }

    static {
        f2990u = new C0200a((bfd) null);
        f2992x = aoo.m2492a(bnd.f2995a);
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, mo1538e = {"Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bnc$a */
    public static final class C0200a {

        /* renamed from: a */
        static final /* synthetic */ bjr[] f2994a = null;

        static {
            f2994a = new bjr[]{bgp.m6707a((bgk) new bgl(bgp.m6715b(C0200a.class), "directionalityMap", "getDirectionalityMap()Ljava/util/Map;"))};
        }

        /* renamed from: a */
        private final Map<Integer, bnc> m7726a() {
            aon b = bnc.f2992x;
            C0200a aVar = bnc.f2990u;
            bjr bjr = f2994a[0];
            return (Map) b.mo1522b();
        }

        private C0200a() {
        }

        public /* synthetic */ C0200a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bnc mo2816a(int i) {
            bnc bnc = m7726a().get(Integer.valueOf(i));
            if (bnc != null) {
                return bnc;
            }
            throw new IllegalArgumentException("Directionality #" + i + " is not defined.");
        }
    }
}
