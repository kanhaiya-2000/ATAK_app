package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: atakplugin.UASTool.yi */
public class C1055yi extends C1018xc {

    /* renamed from: d */
    SortedMap<Long, byte[]> f7700d = new C1056yj(this);

    /* renamed from: e */
    private C1027xk f7701e = new C1027xk();

    /* renamed from: a */
    public List<C0693ny.C0694a> mo6139a() {
        return null;
    }

    /* renamed from: b */
    public long[] mo6140b() {
        return null;
    }

    /* renamed from: c */
    public List<C0735ph.C0736a> mo6141c() {
        return null;
    }

    public void close() {
    }

    /* renamed from: d */
    public C0746pq mo6142d() {
        return null;
    }

    /* renamed from: p */
    public String mo15p() {
        return "data";
    }

    public C1055yi(Map<Long, byte[]> map) {
        super(aas.f154b);
        this.f7700d = new TreeMap(map);
        this.f7701e.mo6182b(new Date());
        this.f7701e.mo6177a(new Date());
        this.f7701e.mo6174a(1000);
        this.f7701e.mo6176a("eng");
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        LinkedList linkedList = new LinkedList();
        for (byte[] wrap : this.f7700d.values()) {
            linkedList.add(new C1025xi(ByteBuffer.wrap(wrap)));
        }
        return linkedList;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        C0737pi piVar = new C0737pi();
        aas aas = new aas();
        aas.mo204a(1);
        piVar.mo170a((C0688nt) aas);
        return piVar;
    }

    /* renamed from: m */
    public long[] mo12m() {
        LinkedList linkedList = new LinkedList(this.f7700d.keySet());
        Collections.sort(linkedList);
        long[] jArr = new long[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            jArr[i] = ((Long) linkedList.get(i)).longValue() - 0;
        }
        return jArr;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7701e;
    }
}
