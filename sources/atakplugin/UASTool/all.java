package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class all extends C0791rb {

    /* renamed from: b */
    public static final String f1963b = "wvtt";

    public all() {
        super(f1963b);
    }

    /* renamed from: a */
    public void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar) {
        mo6123a(wsVar, j, ngVar);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(mo6124t());
        mo209b(writableByteChannel);
    }

    /* renamed from: b */
    public alk mo1391b() {
        return (alk) aft.m883a((C1003wo) this, alk.f1959a);
    }

    /* renamed from: d */
    public alm mo1392d() {
        return (alm) aft.m883a((C1003wo) this, alm.f1964a);
    }
}
