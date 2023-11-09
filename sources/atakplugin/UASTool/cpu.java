package atakplugin.UASTool;

import atakplugin.UASTool.cpv;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

class cpu {

    /* renamed from: a */
    private static final String f4763a = "atakplugin.UASTool.cpu";

    /* renamed from: g */
    private static final byte[][] f4764g = {cpv.f4802ae, cpv.f4804ag, cpv.f4806ai, cpv.f4808ak};

    /* renamed from: h */
    private static final byte[][] f4765h = {cpv.f4803af, cpv.f4805ah, cpv.f4807aj, cpv.f4809al};

    /* renamed from: b */
    private final GeoPoint f4766b;

    /* renamed from: c */
    private final GeoPoint f4767c;

    /* renamed from: d */
    private final GeoPoint f4768d;

    /* renamed from: e */
    private final GeoPoint f4769e;

    /* renamed from: f */
    private final GeoPoint f4770f;

    private cpu(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3, GeoPoint geoPoint4, GeoPoint geoPoint5) {
        this.f4766b = geoPoint;
        this.f4767c = geoPoint2;
        this.f4768d = geoPoint3;
        this.f4769e = geoPoint4;
        this.f4770f = geoPoint5;
    }

    public cpu(GeoPoint geoPoint, List<GeoPoint> list) {
        this.f4766b = geoPoint;
        Iterator<GeoPoint> it = list.iterator();
        this.f4767c = it.next();
        this.f4768d = it.next();
        this.f4769e = it.next();
        this.f4770f = it.next();
        String str = f4763a;
        Log.d(str, "Created FourCorners with center: " + geoPoint);
    }

    /* renamed from: a */
    public List<cpv> mo4840a() {
        byte[] a = cpx.m11985a(this.f4766b.getLatitude());
        cpv cpv = new cpv();
        cpv.mo4853b(cpv.f4777G);
        cpv.mo4847a(cpv.C0331b.BER);
        cpv.mo4850a(a, 0, a.length);
        byte[] b = cpx.m11990b(this.f4766b.getLongitude());
        cpv cpv2 = new cpv();
        cpv2.mo4853b(cpv.f4780J);
        cpv2.mo4847a(cpv.C0331b.BER);
        cpv2.mo4850a(b, 0, b.length);
        GeoPoint[] geoPointArr = {this.f4767c, this.f4768d, this.f4769e, this.f4770f};
        Vector vector = new Vector();
        vector.add(cpv);
        vector.add(cpv2);
        for (int i = 0; i < 4; i++) {
            GeoPoint geoPoint = geoPointArr[i];
            byte[] a2 = cpx.m11985a(geoPoint.getLatitude());
            cpv cpv3 = new cpv();
            cpv3.mo4853b(f4764g[i]);
            cpv3.mo4847a(cpv.C0331b.BER);
            cpv3.mo4850a(a2, 0, a2.length);
            vector.add(cpv3);
            byte[] b2 = cpx.m11990b(geoPoint.getLongitude());
            cpv cpv4 = new cpv();
            cpv4.mo4853b(f4765h[i]);
            cpv4.mo4847a(cpv.C0331b.BER);
            cpv4.mo4850a(b2, 0, b2.length);
            vector.add(cpv4);
        }
        return vector;
    }
}
