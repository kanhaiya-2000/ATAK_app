package atakplugin.UASTool;

import atakplugin.UASTool.C0693ny;
import atakplugin.UASTool.C0735ph;
import atakplugin.UASTool.C0798ri;
import atakplugin.UASTool.aem;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: atakplugin.UASTool.zf */
public class C1084zf extends C1018xc {

    /* renamed from: d */
    C1027xk f7859d = new C1027xk();

    /* renamed from: e */
    C0737pi f7860e = new C0737pi();

    /* renamed from: f */
    List<C1085a> f7861f = new LinkedList();

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
        return "sbtl";
    }

    /* renamed from: i */
    public List<C1085a> mo6316i() {
        return this.f7861f;
    }

    public C1084zf() {
        super("subtiles");
        C0798ri riVar = new C0798ri(C0798ri.f6064b);
        riVar.mo204a(1);
        riVar.mo5603a(new C0798ri.C0800b());
        riVar.mo5602a(new C0798ri.C0799a());
        this.f7860e.mo170a((C0688nt) riVar);
        aem aem = new aem();
        aem.mo498a((List<aem.C0019a>) Collections.singletonList(new aem.C0019a(1, "Serif")));
        riVar.mo170a((C0688nt) aem);
        this.f7859d.mo6182b(new Date());
        this.f7859d.mo6177a(new Date());
        this.f7859d.mo6174a(1000);
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        LinkedList linkedList = new LinkedList();
        long j = 0;
        for (C1085a next : this.f7861f) {
            int i = ((next.f7862a - j) > 0 ? 1 : ((next.f7862a - j) == 0 ? 0 : -1));
            if (i > 0) {
                linkedList.add(new C1025xi(ByteBuffer.wrap(new byte[2])));
            } else if (i < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(next.f7864c.getBytes("UTF-8").length);
                dataOutputStream.write(next.f7864c.getBytes("UTF-8"));
                dataOutputStream.close();
                linkedList.add(new C1025xi(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())));
                j = next.f7863b;
            } catch (IOException unused) {
                throw new Error("VM is broken. Does not support UTF-8");
            }
        }
        return linkedList;
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7860e;
    }

    /* renamed from: m */
    public long[] mo12m() {
        ArrayList<Long> arrayList = new ArrayList<>();
        long j = 0;
        for (C1085a next : this.f7861f) {
            long j2 = next.f7862a - j;
            int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i > 0) {
                arrayList.add(Long.valueOf(j2));
            } else if (i < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            arrayList.add(Long.valueOf(next.f7863b - next.f7862a));
            j = next.f7863b;
        }
        long[] jArr = new long[arrayList.size()];
        int i2 = 0;
        for (Long longValue : arrayList) {
            jArr[i2] = longValue.longValue();
            i2++;
        }
        return jArr;
    }

    /* renamed from: o */
    public C1027xk mo14o() {
        return this.f7859d;
    }

    /* renamed from: atakplugin.UASTool.zf$a */
    public static class C1085a {

        /* renamed from: a */
        long f7862a;

        /* renamed from: b */
        long f7863b;

        /* renamed from: c */
        String f7864c;

        public C1085a(long j, long j2, String str) {
            this.f7862a = j;
            this.f7863b = j2;
            this.f7864c = str;
        }

        /* renamed from: a */
        public long mo6317a() {
            return this.f7862a;
        }

        /* renamed from: b */
        public String mo6318b() {
            return this.f7864c;
        }

        /* renamed from: c */
        public long mo6319c() {
            return this.f7863b;
        }
    }
}
