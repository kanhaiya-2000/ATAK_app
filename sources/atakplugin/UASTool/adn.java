package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@adm(mo342a = {3})
public class adn extends adh {

    /* renamed from: n */
    private static Logger f559n = Logger.getLogger(adn.class.getName());

    /* renamed from: a */
    int f560a;

    /* renamed from: b */
    int f561b;

    /* renamed from: c */
    int f562c;

    /* renamed from: d */
    int f563d;

    /* renamed from: e */
    int f564e;

    /* renamed from: f */
    int f565f = 0;

    /* renamed from: g */
    String f566g;

    /* renamed from: h */
    int f567h;

    /* renamed from: i */
    int f568i;

    /* renamed from: j */
    int f569j;

    /* renamed from: k */
    adk f570k;

    /* renamed from: l */
    adu f571l;

    /* renamed from: m */
    List<adh> f572m = new ArrayList();

    public adn() {
        this.f537Z = 3;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        this.f560a = C0679nk.m12497d(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        int i = f >>> 7;
        this.f561b = i;
        this.f562c = (f >>> 6) & 1;
        this.f563d = (f >>> 5) & 1;
        this.f564e = f & 31;
        if (i == 1) {
            this.f568i = C0679nk.m12497d(byteBuffer);
        }
        if (this.f562c == 1) {
            int f2 = C0679nk.m12499f(byteBuffer);
            this.f565f = f2;
            this.f566g = C0679nk.m12494a(byteBuffer, f2);
        }
        if (this.f563d == 1) {
            this.f569j = C0679nk.m12497d(byteBuffer);
        }
        while (byteBuffer.remaining() > 1) {
            adh a = ads.m574a(-1, byteBuffer);
            if (a instanceof adk) {
                this.f570k = (adk) a;
            } else if (a instanceof adu) {
                this.f571l = (adu) a;
            } else {
                this.f572m.add(a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        int i = this.f561b > 0 ? 5 : 3;
        if (this.f562c > 0) {
            i += this.f565f + 1;
        }
        if (this.f563d > 0) {
            i += 2;
        }
        int k = i + this.f570k.mo314k() + this.f571l.mo314k();
        if (this.f572m.size() <= 0) {
            return k;
        }
        throw new RuntimeException(" Doesn't handle other descriptors yet");
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[mo314k()]);
        C0681nm.m12521d(wrap, 3);
        mo311a(wrap, mo292a());
        C0681nm.m12514b(wrap, this.f560a);
        C0681nm.m12521d(wrap, (this.f561b << 7) | (this.f562c << 6) | (this.f563d << 5) | (this.f564e & 31));
        if (this.f561b > 0) {
            C0681nm.m12514b(wrap, this.f568i);
        }
        if (this.f562c > 0) {
            C0681nm.m12521d(wrap, this.f565f);
            C0681nm.m12523d(wrap, this.f566g);
        }
        if (this.f563d > 0) {
            C0681nm.m12514b(wrap, this.f569j);
        }
        ByteBuffer b = this.f570k.mo295b();
        ByteBuffer b2 = this.f571l.mo295b();
        wrap.put(b.array());
        wrap.put(b2.array());
        return wrap;
    }

    /* renamed from: c */
    public adk mo349c() {
        return this.f570k;
    }

    /* renamed from: a */
    public void mo345a(adk adk) {
        this.f570k = adk;
    }

    /* renamed from: d */
    public adu mo351d() {
        return this.f571l;
    }

    /* renamed from: a */
    public void mo346a(adu adu) {
        this.f571l = adu;
    }

    /* renamed from: e */
    public List<adh> mo353e() {
        return this.f572m;
    }

    /* renamed from: f */
    public int mo356f() {
        return this.f569j;
    }

    /* renamed from: a */
    public void mo344a(int i) {
        this.f569j = i;
    }

    /* renamed from: g */
    public int mo358g() {
        return this.f560a;
    }

    /* renamed from: b */
    public void mo348b(int i) {
        this.f560a = i;
    }

    /* renamed from: h */
    public int mo360h() {
        return this.f561b;
    }

    /* renamed from: c */
    public void mo350c(int i) {
        this.f561b = i;
    }

    /* renamed from: l */
    public int mo364l() {
        return this.f562c;
    }

    /* renamed from: d */
    public void mo352d(int i) {
        this.f562c = i;
    }

    /* renamed from: m */
    public int mo365m() {
        return this.f563d;
    }

    /* renamed from: e */
    public void mo354e(int i) {
        this.f563d = i;
    }

    /* renamed from: n */
    public int mo366n() {
        return this.f564e;
    }

    /* renamed from: f */
    public void mo357f(int i) {
        this.f564e = i;
    }

    /* renamed from: o */
    public int mo367o() {
        return this.f565f;
    }

    /* renamed from: g */
    public void mo359g(int i) {
        this.f565f = i;
    }

    /* renamed from: p */
    public String mo368p() {
        return this.f566g;
    }

    /* renamed from: a */
    public void mo347a(String str) {
        this.f566g = str;
    }

    /* renamed from: q */
    public int mo369q() {
        return this.f567h;
    }

    /* renamed from: h */
    public void mo361h(int i) {
        this.f567h = i;
    }

    /* renamed from: r */
    public int mo370r() {
        return this.f568i;
    }

    /* renamed from: i */
    public void mo363i(int i) {
        this.f568i = i;
    }

    public String toString() {
        return "ESDescriptor" + "{esId=" + this.f560a + ", streamDependenceFlag=" + this.f561b + ", URLFlag=" + this.f562c + ", oCRstreamFlag=" + this.f563d + ", streamPriority=" + this.f564e + ", URLLength=" + this.f565f + ", URLString='" + this.f566g + '\'' + ", remoteODFlag=" + this.f567h + ", dependsOnEsId=" + this.f568i + ", oCREsId=" + this.f569j + ", decoderConfigDescriptor=" + this.f570k + ", slConfigDescriptor=" + this.f571l + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        adn adn = (adn) obj;
        if (this.f562c != adn.f562c || this.f565f != adn.f565f || this.f568i != adn.f568i || this.f560a != adn.f560a || this.f569j != adn.f569j || this.f563d != adn.f563d || this.f567h != adn.f567h || this.f561b != adn.f561b || this.f564e != adn.f564e) {
            return false;
        }
        String str = this.f566g;
        if (str == null ? adn.f566g != null : !str.equals(adn.f566g)) {
            return false;
        }
        adk adk = this.f570k;
        if (adk == null ? adn.f570k != null : !adk.equals(adn.f570k)) {
            return false;
        }
        List<adh> list = this.f572m;
        if (list == null ? adn.f572m != null : !list.equals(adn.f572m)) {
            return false;
        }
        adu adu = this.f571l;
        adu adu2 = adn.f571l;
        return adu == null ? adu2 == null : adu.equals(adu2);
    }

    public int hashCode() {
        int i = ((((((((((this.f560a * 31) + this.f561b) * 31) + this.f562c) * 31) + this.f563d) * 31) + this.f564e) * 31) + this.f565f) * 31;
        String str = this.f566g;
        int i2 = 0;
        int hashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.f567h) * 31) + this.f568i) * 31) + this.f569j) * 31;
        adk adk = this.f570k;
        int hashCode2 = (hashCode + (adk != null ? adk.hashCode() : 0)) * 31;
        adu adu = this.f571l;
        int hashCode3 = (hashCode2 + (adu != null ? adu.hashCode() : 0)) * 31;
        List<adh> list = this.f572m;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }
}
