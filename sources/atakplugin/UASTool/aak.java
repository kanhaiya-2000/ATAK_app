package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class aak extends ame {

    /* renamed from: a */
    aah f21a;

    /* renamed from: b */
    aae f22b;

    /* renamed from: c */
    aai f23c;

    /* renamed from: d */
    aag f24d;

    /* renamed from: e */
    aaf f25e;

    public aak() {
        super("vtcc");
    }

    /* renamed from: f */
    public long mo19f() {
        aah aah = this.f21a;
        long j = 0;
        long f = (aah != null ? aah.mo19f() : 0) + 8;
        aae aae = this.f22b;
        long f2 = f + (aae != null ? aae.mo19f() : 0);
        aai aai = this.f23c;
        long f3 = f2 + (aai != null ? aai.mo19f() : 0);
        aag aag = this.f24d;
        long f4 = f3 + (aag != null ? aag.mo19f() : 0);
        aaf aaf = this.f25e;
        if (aaf != null) {
            j = aaf.mo19f();
        }
        return f4 + j;
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12515b(allocate, mo19f());
        allocate.put(C0678nj.m12488a(mo1476h()));
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        aah aah = this.f21a;
        if (aah != null) {
            aah.mo18a(writableByteChannel);
        }
        aae aae = this.f22b;
        if (aae != null) {
            aae.mo18a(writableByteChannel);
        }
        aai aai = this.f23c;
        if (aai != null) {
            aai.mo18a(writableByteChannel);
        }
        aag aag = this.f24d;
        if (aag != null) {
            aag.mo18a(writableByteChannel);
        }
        aaf aaf = this.f25e;
        if (aaf != null) {
            aaf.mo18a(writableByteChannel);
        }
    }

    /* renamed from: a */
    public aah mo20a() {
        return this.f21a;
    }

    /* renamed from: a */
    public void mo24a(aah aah) {
        this.f21a = aah;
    }

    /* renamed from: b */
    public aae mo26b() {
        return this.f22b;
    }

    /* renamed from: a */
    public void mo21a(aae aae) {
        this.f22b = aae;
    }

    /* renamed from: c */
    public aai mo27c() {
        return this.f23c;
    }

    /* renamed from: a */
    public void mo25a(aai aai) {
        this.f23c = aai;
    }

    /* renamed from: d */
    public aag mo28d() {
        return this.f24d;
    }

    /* renamed from: a */
    public void mo23a(aag aag) {
        this.f24d = aag;
    }

    /* renamed from: i */
    public aaf mo29i() {
        return this.f25e;
    }

    /* renamed from: a */
    public void mo22a(aaf aaf) {
        this.f25e = aaf;
    }
}
