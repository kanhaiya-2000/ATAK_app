package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class aky extends C1002wn {

    /* renamed from: b */
    private static final /* synthetic */ can.C0296b f1767b = null;

    /* renamed from: c */
    private static final /* synthetic */ can.C0296b f1768c = null;

    /* renamed from: a */
    long[] f1769a = new long[0];

    static {
        m2044b();
    }

    /* renamed from: b */
    private static /* synthetic */ void m2044b() {
        cdj cdj = new cdj("TrackReferenceTypeBox.java", aky.class);
        f1767b = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "", "", "", "[J"), 58);
        f1768c = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "[J", "trackIds", "", "void"), 62);
    }

    public aky(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f1769a.length * 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        for (long b : this.f1769a) {
            C0681nm.m12515b(byteBuffer, b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 4) {
            this.f1769a = afs.m880a(this.f1769a, C0679nk.m12495b(byteBuffer));
        }
    }

    /* renamed from: a */
    public long[] mo1208a() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f1767b, (Object) this, (Object) this));
        return this.f1769a;
    }

    /* renamed from: a */
    public void mo1207a(long[] jArr) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f1768c, (Object) this, (Object) this, (Object) jArr));
        this.f1769a = jArr;
    }
}
