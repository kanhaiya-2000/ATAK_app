package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

public class agc extends age {

    /* renamed from: B */
    byte[] f967B = new byte[0];

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo705a(int i, int i2, int i3, int i4) {
        super.mo705a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo706a(String str, int i, int i2, int i3, int i4) {
        super.mo706a(str, i, i2, i3, i4);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo707a(String str, String str2) {
        super.mo707a(str, str2);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo708a(Hashtable hashtable) {
        super.mo708a(hashtable);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo656a(boolean z) {
        super.mo656a(z);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo709a(byte[] bArr, byte[] bArr2) {
        super.mo709a(bArr, bArr2);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo710b(boolean z) {
        super.mo710b(z);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo715c(boolean z) {
        super.mo715c(z);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo716c(byte[] bArr) {
        super.mo716c(bArr);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo717d(String str) {
        super.mo717d(str);
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    /* renamed from: d */
    public void mo669d() {
        air p = mo686p();
        try {
            mo720v();
            new aii(this.f967B).mo1014a(p, this);
            if (this.f910q.f1234a != null) {
                this.f911r = new Thread(this);
                Thread thread = this.f911r;
                thread.setName("Exec thread " + p.mo1092p());
                if (p.f1472M) {
                    this.f911r.setDaemon(p.f1472M);
                }
                this.f911r.start();
            }
        } catch (Exception e) {
            if (e instanceof ahj) {
                throw ((ahj) e);
            } else if (e instanceof Throwable) {
                throw new ahj("ChannelExec", e);
            } else {
                throw new ahj("ChannelExec");
            }
        }
    }

    /* renamed from: c */
    public void mo714c(String str) {
        this.f967B = aji.m1820c(str);
    }

    /* renamed from: b */
    public void mo711b(byte[] bArr) {
        this.f967B = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
        this.f910q.mo855a(mo686p().f1467F);
        this.f910q.mo857a(mo686p().f1468G);
    }

    /* renamed from: c */
    public void mo712c(OutputStream outputStream) {
        mo663b(outputStream);
    }

    /* renamed from: c */
    public void mo713c(OutputStream outputStream, boolean z) {
        mo664b(outputStream, z);
    }

    /* renamed from: u */
    public InputStream mo718u() {
        return mo675g();
    }
}
