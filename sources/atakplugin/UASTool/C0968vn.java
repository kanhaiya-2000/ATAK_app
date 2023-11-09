package atakplugin.UASTool;

import atakplugin.UASTool.C0998wk;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: atakplugin.UASTool.vn */
class C0968vn implements C0962vk<C0964vm> {

    /* renamed from: a */
    private final C0998wk<Character> f7439a;

    /* renamed from: atakplugin.UASTool.vn$a */
    enum C0970a implements C0998wk.C0999a<Character> {
        LETTER,
        DOT,
        HYPHEN,
        PLUS,
        EOI,
        ILLEGAL;

        /* renamed from: a */
        static C0970a m14299a(Character ch) {
            for (C0970a aVar : values()) {
                if (aVar.mo6080a(ch)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    C0968vn(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is NULL or empty");
        }
        Character[] chArr = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chArr[i] = Character.valueOf(str.charAt(i));
        }
        this.f7439a = new C0998wk<>(chArr);
    }

    /* renamed from: b */
    public C0964vm mo6041a(String str) {
        return m14279a();
    }

    /* renamed from: c */
    static C0964vm m14284c(String str) {
        return new C0968vn(str).m14279a();
    }

    /* renamed from: d */
    static C0960vi m14286d(String str) {
        return new C0968vn(str).m14281b();
    }

    /* renamed from: e */
    static C0958vh m14289e(String str) {
        return new C0968vn(str).m14283c();
    }

    /* renamed from: f */
    static C0958vh m14290f(String str) {
        return new C0968vn(str).m14288e();
    }

    /* renamed from: a */
    private C0964vm m14279a() {
        C0960vi b = m14281b();
        C0958vh vhVar = C0958vh.f7422a;
        C0958vh vhVar2 = C0958vh.f7422a;
        Character b2 = m14282b(C0970a.HYPHEN, C0970a.PLUS, C0970a.EOI);
        if (C0970a.HYPHEN.mo6080a(b2)) {
            vhVar = m14283c();
            if (C0970a.PLUS.mo6080a(m14282b(C0970a.PLUS, C0970a.EOI))) {
                vhVar2 = m14288e();
            }
        } else if (C0970a.PLUS.mo6080a(b2)) {
            vhVar2 = m14288e();
        }
        m14282b(C0970a.EOI);
        return new C0964vm(b, vhVar, vhVar2);
    }

    /* renamed from: b */
    private C0960vi m14281b() {
        int parseInt = Integer.parseInt(m14292g());
        m14282b(C0970a.DOT);
        int parseInt2 = Integer.parseInt(m14292g());
        m14282b(C0970a.DOT);
        return new C0960vi(parseInt, parseInt2, Integer.parseInt(m14292g()));
    }

    /* renamed from: c */
    private C0958vh m14283c() {
        m14285c(C0970a.f7440a, C0970a.LETTER, C0970a.HYPHEN);
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(m14287d());
            if (!this.f7439a.mo6107b((T[]) new C0970a[]{C0970a.DOT})) {
                return new C0958vh((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            m14282b(C0970a.DOT);
        }
    }

    /* renamed from: d */
    private String m14287d() {
        m14296k();
        C0970a a = m14280a(C0970a.DOT, C0970a.PLUS, C0970a.EOI);
        if (this.f7439a.mo6105a(a, (T[]) new C0970a[]{C0970a.LETTER, C0970a.HYPHEN})) {
            return m14293h();
        }
        return m14292g();
    }

    /* renamed from: e */
    private C0958vh m14288e() {
        m14285c(C0970a.f7440a, C0970a.LETTER, C0970a.HYPHEN);
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(m14291f());
            if (!this.f7439a.mo6107b((T[]) new C0970a[]{C0970a.DOT})) {
                return new C0958vh((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            m14282b(C0970a.DOT);
        }
    }

    /* renamed from: f */
    private String m14291f() {
        m14296k();
        C0970a a = m14280a(C0970a.DOT, C0970a.EOI);
        if (this.f7439a.mo6105a(a, (T[]) new C0970a[]{C0970a.LETTER, C0970a.HYPHEN})) {
            return m14293h();
        }
        return m14294i();
    }

    /* renamed from: g */
    private String m14292g() {
        m14295j();
        return m14294i();
    }

    /* renamed from: h */
    private String m14293h() {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(m14282b(C0970a.f7440a, C0970a.LETTER, C0970a.HYPHEN));
        } while (this.f7439a.mo6107b((T[]) new C0970a[]{C0970a.f7440a, C0970a.LETTER, C0970a.HYPHEN}));
        return sb.toString();
    }

    /* renamed from: i */
    private String m14294i() {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(m14282b(C0970a.f7440a));
        } while (this.f7439a.mo6107b((T[]) new C0970a[]{C0970a.f7440a}));
        return sb.toString();
    }

    /* renamed from: a */
    private C0970a m14280a(C0970a... aVarArr) {
        Iterator<Character> it = this.f7439a.iterator();
        while (it.hasNext()) {
            Character next = it.next();
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    C0970a aVar = aVarArr[i];
                    if (aVar.mo6080a(next)) {
                        return aVar;
                    }
                    i++;
                }
            }
        }
        return C0970a.EOI;
    }

    /* renamed from: j */
    private void m14295j() {
        Character a = this.f7439a.mo6102a(1);
        Character a2 = this.f7439a.mo6102a(2);
        if (a != null && a.charValue() == '0' && C0970a.f7440a.mo6080a(a2)) {
            throw new C0961vj("Numeric identifier MUST NOT contain leading zeroes");
        }
    }

    /* renamed from: k */
    private void m14296k() {
        Character a = this.f7439a.mo6102a(1);
        if (C0970a.DOT.mo6080a(a) || C0970a.PLUS.mo6080a(a) || C0970a.EOI.mo6080a(a)) {
            throw new C0961vj("Identifiers MUST NOT be empty", new C0963vl(a, this.f7439a.mo6109d(), C0970a.f7440a, C0970a.LETTER, C0970a.HYPHEN));
        }
    }

    /* renamed from: b */
    private Character m14282b(C0970a... aVarArr) {
        try {
            return this.f7439a.mo6103a((T[]) aVarArr);
        } catch (C1001wm e) {
            throw new C0963vl(e);
        }
    }

    /* renamed from: c */
    private void m14285c(C0970a... aVarArr) {
        if (!this.f7439a.mo6107b((T[]) aVarArr)) {
            throw new C0963vl(this.f7439a.mo6102a(1), this.f7439a.mo6109d(), aVarArr);
        }
    }
}
