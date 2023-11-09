package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.yk */
public class C1057yk extends C1018xc {

    /* renamed from: f */
    private static afp f7703f = afp.m867a(C1057yk.class);

    /* renamed from: d */
    C1026xj[] f7704d;

    /* renamed from: e */
    C0737pi f7705e;

    /* renamed from: a */
    public static String m14742a(C1026xj... xjVarArr) {
        String str = "";
        for (C1026xj xjVar : xjVarArr) {
            str = String.valueOf(str) + xjVar.mo6144f() + " + ";
        }
        return str.substring(0, str.length() - 3);
    }

    public C1057yk(C1026xj... xjVarArr) {
        super(m14742a(xjVarArr));
        this.f7704d = xjVarArr;
        for (C1026xj xjVar : xjVarArr) {
            C0737pi piVar = this.f7705e;
            if (piVar == null) {
                C0737pi piVar2 = new C0737pi();
                this.f7705e = piVar2;
                piVar2.mo170a((C0688nt) xjVar.mo13n().mo202a(C0797rh.class).get(0));
            } else {
                this.f7705e = m14738a(piVar, xjVar.mo13n());
            }
        }
    }

    public void close() {
        for (C1026xj close : this.f7704d) {
            close.close();
        }
    }

    /* renamed from: a */
    private C0737pi m14738a(C0737pi piVar, C0737pi piVar2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            piVar.mo18a(Channels.newChannel(byteArrayOutputStream));
            piVar2.mo18a(Channels.newChannel(byteArrayOutputStream2));
            if (!Arrays.equals(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream.toByteArray())) {
                C0797rh a = m14740a(piVar.mo202a(C0797rh.class).get(0), piVar2.mo202a(C0797rh.class).get(0));
                if (a != null) {
                    piVar.mo172a((List<C0688nt>) Collections.singletonList(a));
                } else {
                    throw new IOException("Cannot merge " + piVar.mo202a(C0797rh.class).get(0) + " and " + piVar2.mo202a(C0797rh.class).get(0));
                }
            }
            return piVar;
        } catch (IOException e) {
            f7703f.mo576c(e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private C0797rh m14740a(C0797rh rhVar, C0797rh rhVar2) {
        if (!rhVar.mo1476h().equals(rhVar2.mo1476h())) {
            return null;
        }
        if ((rhVar instanceof C0801rj) && (rhVar2 instanceof C0801rj)) {
            return m14741a((C0801rj) rhVar, (C0801rj) rhVar2);
        }
        if (!(rhVar instanceof C0793rd) || !(rhVar2 instanceof C0793rd)) {
            return null;
        }
        return m14739a((C0793rd) rhVar, (C0793rd) rhVar2);
    }

    /* renamed from: a */
    private C0801rj m14741a(C0801rj rjVar, C0801rj rjVar2) {
        C0801rj rjVar3 = new C0801rj();
        if (rjVar.mo5645i() == rjVar2.mo5645i()) {
            rjVar3.mo5635a(rjVar.mo5645i());
            rjVar3.mo5640b(rjVar.mo5648l());
            if (rjVar.mo5649m() == rjVar2.mo5649m()) {
                rjVar3.mo5644e(rjVar.mo5649m());
                if (rjVar.mo5647k() == rjVar2.mo5647k()) {
                    rjVar3.mo5643d(rjVar.mo5647k());
                    if (rjVar.mo5642d() == rjVar2.mo5642d()) {
                        rjVar3.mo5641c(rjVar.mo5642d());
                        if (rjVar.mo5637b() == rjVar2.mo5637b()) {
                            rjVar3.mo5639b(rjVar.mo5637b());
                            if (rjVar.mo5646j() == rjVar2.mo5646j()) {
                                rjVar3.mo5638b(rjVar.mo5646j());
                                if (rjVar.mo5645i() == rjVar2.mo5645i()) {
                                    rjVar3.mo5635a(rjVar.mo5645i());
                                    if (rjVar.mo36c().size() == rjVar2.mo36c().size()) {
                                        Iterator<C0688nt> it = rjVar2.mo36c().iterator();
                                        for (C0688nt next : rjVar.mo36c()) {
                                            C0688nt next2 = it.next();
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            try {
                                                next.mo18a(Channels.newChannel(byteArrayOutputStream));
                                                next2.mo18a(Channels.newChannel(byteArrayOutputStream2));
                                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                    rjVar3.mo170a(next);
                                                } else if ((next instanceof add) && (next2 instanceof add)) {
                                                    add add = (add) next;
                                                    add.mo286a((adh) m14737a(add.mo43i(), ((add) next2).mo43i()));
                                                    rjVar3.mo170a(next);
                                                }
                                            } catch (IOException e) {
                                                f7703f.mo575b(e.getMessage());
                                                return null;
                                            }
                                        }
                                    }
                                    return rjVar3;
                                }
                                f7703f.mo576c("horizontal resolution differs");
                                return null;
                            }
                            f7703f.mo576c("vert resolution differs");
                            return null;
                        }
                        f7703f.mo576c("width differs");
                        return null;
                    }
                    f7703f.mo576c("height differs");
                    return null;
                }
                f7703f.mo576c("frame count differs");
                return null;
            }
            f7703f.mo576c("Depth differs");
            return null;
        }
        f7703f.mo576c("Horizontal Resolution differs");
        return null;
    }

    /* renamed from: a */
    private C0793rd m14739a(C0793rd rdVar, C0793rd rdVar2) {
        C0793rd rdVar3 = new C0793rd(rdVar2.mo1476h());
        if (rdVar.mo5595o() == rdVar2.mo5595o()) {
            rdVar3.mo5583d(rdVar.mo5595o());
            if (rdVar.mo5594n() == rdVar2.mo5594n()) {
                rdVar3.mo5580c(rdVar.mo5594n());
                if (rdVar.mo5596p() == rdVar2.mo5596p()) {
                    rdVar3.mo5585e(rdVar.mo5596p());
                    if (rdVar.mo5576b() == rdVar2.mo5576b()) {
                        rdVar3.mo5577b(rdVar.mo5576b());
                        if (rdVar.mo5592l() == rdVar2.mo5592l()) {
                            rdVar3.mo5586f(rdVar.mo5592l());
                            if (rdVar.mo5591k() == rdVar2.mo5591k()) {
                                rdVar3.mo5584e(rdVar.mo5591k());
                                if (rdVar.mo5589i() == rdVar2.mo5589i()) {
                                    rdVar3.mo5573a(rdVar.mo5589i());
                                    if (rdVar.mo5581d() == rdVar2.mo5581d()) {
                                        rdVar3.mo5579c(rdVar.mo5581d());
                                        if (rdVar.mo5593m() == rdVar2.mo5593m()) {
                                            rdVar3.mo5578b(rdVar.mo5593m());
                                            if (rdVar.mo5590j() == rdVar2.mo5590j()) {
                                                rdVar3.mo5582d(rdVar.mo5590j());
                                                if (Arrays.equals(rdVar.mo5597q(), rdVar2.mo5597q())) {
                                                    rdVar3.mo5575a(rdVar.mo5597q());
                                                    if (rdVar.mo36c().size() == rdVar2.mo36c().size()) {
                                                        Iterator<C0688nt> it = rdVar2.mo36c().iterator();
                                                        for (C0688nt next : rdVar.mo36c()) {
                                                            C0688nt next2 = it.next();
                                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                            try {
                                                                next.mo18a(Channels.newChannel(byteArrayOutputStream));
                                                                next2.mo18a(Channels.newChannel(byteArrayOutputStream2));
                                                                if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                                    rdVar3.mo170a(next);
                                                                } else if (ade.f455c.equals(next.mo1476h()) && ade.f455c.equals(next2.mo1476h())) {
                                                                    ade ade = (ade) next;
                                                                    ade.mo286a((adh) m14737a((adh) ade.mo291k(), (adh) ((ade) next2).mo291k()));
                                                                    rdVar3.mo170a(next);
                                                                }
                                                            } catch (IOException e) {
                                                                f7703f.mo575b(e.getMessage());
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    return rdVar3;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return null;
                        }
                        f7703f.mo576c("ChannelCount differ");
                    }
                    return null;
                }
                f7703f.mo576c("BytesPerSample differ");
            }
            return null;
        }
        f7703f.mo576c("BytesPerFrame differ");
        return null;
    }

    /* renamed from: a */
    private adn m14737a(adh adh, adh adh2) {
        if (!(adh instanceof adn) || !(adh2 instanceof adn)) {
            f7703f.mo576c("I can only merge ESDescriptors");
            return null;
        }
        adn adn = (adn) adh;
        adn adn2 = (adn) adh2;
        if (adn.mo364l() != adn2.mo364l()) {
            return null;
        }
        adn.mo367o();
        adn2.mo367o();
        if (adn.mo370r() != adn2.mo370r() || adn.mo358g() != adn2.mo358g() || adn.mo356f() != adn2.mo356f() || adn.mo365m() != adn2.mo365m() || adn.mo369q() != adn2.mo369q() || adn.mo360h() != adn2.mo360h()) {
            return null;
        }
        adn.mo366n();
        adn2.mo366n();
        if (adn.mo368p() != null) {
            adn.mo368p().equals(adn2.mo368p());
        } else {
            adn2.mo368p();
        }
        if (adn.mo349c() == null ? adn2.mo349c() != null : !adn.mo349c().equals(adn2.mo349c())) {
            adk c = adn.mo349c();
            adk c2 = adn2.mo349c();
            if (c.mo330d() != null && c2.mo330d() != null && !c.mo330d().equals(c2.mo330d())) {
                return null;
            }
            if (c.mo338n() != c2.mo338n()) {
                c.mo327b((c.mo338n() + c2.mo338n()) / 2);
            }
            c.mo336l();
            c2.mo336l();
            if (c.mo328c() == null ? c2.mo328c() != null : !c.mo328c().equals(c2.mo328c())) {
                return null;
            }
            if (c.mo337m() != c2.mo337m()) {
                c.mo323a(Math.max(c.mo337m(), c2.mo337m()));
            }
            if (!(c.mo332e().equals(c2.mo332e()) && c.mo333f() == c2.mo333f() && c.mo334g() == c2.mo334g() && c.mo335h() == c2.mo335h())) {
                return null;
            }
        }
        if (adn.mo353e() == null ? adn2.mo353e() != null : !adn.mo353e().equals(adn2.mo353e())) {
            return null;
        }
        if (adn.mo351d() == null ? adn2.mo351d() == null : adn.mo351d().equals(adn2.mo351d())) {
            return adn;
        }
        return null;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        ArrayList arrayList = new ArrayList();
        for (C1026xj l : this.f7704d) {
            arrayList.addAll(l.mo11l());
        }
        return arrayList;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7705e;
    }

    /* renamed from: m */
    public synchronized long[] mo12m() {
        long[] jArr;
        int i = 0;
        for (C1026xj m : this.f7704d) {
            i += m.mo12m().length;
        }
        jArr = new long[i];
        int i2 = 0;
        for (C1026xj m2 : this.f7704d) {
            long[] m3 = m2.mo12m();
            int length = m3.length;
            int i3 = 0;
            while (i3 < length) {
                jArr[i2] = m3[i3];
                i3++;
                i2++;
            }
        }
        return jArr;
    }

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        if (this.f7704d[0].mo6139a() == null || this.f7704d[0].mo6139a().isEmpty()) {
            return null;
        }
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (C1026xj a : this.f7704d) {
            linkedList.add(C0693ny.m12590b(a.mo6139a()));
        }
        LinkedList linkedList2 = new LinkedList();
        for (int[] iArr : linkedList) {
            for (int i : (int[]) r6.next()) {
                if (linkedList2.isEmpty() || ((C0693ny.C0694a) linkedList2.getLast()).mo5144b() != i) {
                    linkedList2.add(new C0693ny.C0694a(1, i));
                } else {
                    C0693ny.C0694a aVar = (C0693ny.C0694a) linkedList2.getLast();
                    aVar.mo5143a(aVar.mo5142a() + 1);
                }
            }
        }
        return linkedList2;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        if (this.f7704d[0].mo6140b() == null || this.f7704d[0].mo6140b().length <= 0) {
            return null;
        }
        int i = 0;
        for (C1026xj xjVar : this.f7704d) {
            i += xjVar.mo6140b() != null ? xjVar.mo6140b().length : 0;
        }
        long[] jArr = new long[i];
        long j = 0;
        int i2 = 0;
        for (C1026xj xjVar2 : this.f7704d) {
            if (xjVar2.mo6140b() != null) {
                long[] b = xjVar2.mo6140b();
                int length = b.length;
                int i3 = 0;
                while (i3 < length) {
                    jArr[i2] = b[i3] + j;
                    i3++;
                    i2++;
                }
            }
            j += (long) xjVar2.mo11l().size();
        }
        return jArr;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        if (this.f7704d[0].mo6141c() == null || this.f7704d[0].mo6141c().isEmpty()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (C1026xj c : this.f7704d) {
            linkedList.addAll(c.mo6141c());
        }
        return linkedList;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7704d[0].mo14o();
    }

    /* renamed from: p */
    public String mo15p() {
        return this.f7704d[0].mo15p();
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return this.f7704d[0].mo6142d();
    }
}
