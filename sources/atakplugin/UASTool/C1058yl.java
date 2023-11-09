package atakplugin.UASTool;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/* renamed from: atakplugin.UASTool.yl */
public class C1058yl extends C1028xl {

    /* renamed from: b */
    C0737pi f7706b;

    /* renamed from: c */
    akz f7707c;

    /* renamed from: d */
    List<C1024xh> f7708d;

    public C1058yl(C1026xj xjVar) {
        super(xjVar);
        if (C0801rj.f6084d.equals(xjVar.mo13n().mo5316d().mo1476h())) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            xjVar.mo13n().mo18a(Channels.newChannel(byteArrayOutputStream));
            C0737pi piVar = (C0737pi) aft.m882a((C0695nz) new C0678nj((C1007ws) new C1011ww(byteArrayOutputStream.toByteArray())), C0737pi.f5666a);
            this.f7706b = piVar;
            ((C0801rj) piVar.mo5316d()).mo5636a(C0801rj.f6085e);
            this.f7707c = (akz) aft.m883a((C1003wo) this.f7706b, "avc./avcC");
            this.f7708d = new C1059a(xjVar.mo11l());
            return;
        }
        throw new RuntimeException("Only avc1 tracks can be converted to avc3 tracks");
    }

    /* renamed from: n */
    public C0737pi mo13n() {
        return this.f7706b;
    }

    /* renamed from: l */
    public List<C1024xh> mo11l() {
        return this.f7708d;
    }

    /* renamed from: atakplugin.UASTool.yl$a */
    private class C1059a extends AbstractList<C1024xh> {

        /* renamed from: a */
        List<C1024xh> f7709a;

        public C1059a(List<C1024xh> list) {
            this.f7709a = list;
        }

        /* renamed from: a */
        public C1024xh get(int i) {
            if (Arrays.binarySearch(C1058yl.this.mo6140b(), (long) (i + 1)) < 0) {
                return this.f7709a.get(i);
            }
            int j = C1058yl.this.f7707c.mo1223j() + 1;
            return new C1060ym(this, ByteBuffer.allocate(j), j, this.f7709a.get(i));
        }

        public int size() {
            return this.f7709a.size();
        }
    }
}
