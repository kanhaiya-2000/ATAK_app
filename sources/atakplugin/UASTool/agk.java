package atakplugin.UASTool;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

public class agk extends age {

    /* renamed from: B */
    boolean f1119B = false;

    /* renamed from: M */
    boolean f1120M = false;

    /* renamed from: N */
    boolean f1121N = true;

    /* renamed from: O */
    String f1122O = "";

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
    public /* bridge */ /* synthetic */ void mo709a(byte[] bArr, byte[] bArr2) {
        super.mo709a(bArr, bArr2);
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

    /* renamed from: a */
    public void mo656a(boolean z) {
        this.f1119B = z;
    }

    /* renamed from: b */
    public void mo710b(boolean z) {
        this.f1120M = z;
    }

    /* renamed from: d */
    public void mo802d(boolean z) {
        this.f1121N = z;
    }

    /* renamed from: c */
    public void mo801c(String str) {
        this.f1122O = str;
    }

    /* renamed from: d */
    public void mo669d() {
        air p = mo686p();
        try {
            if (this.f1119B) {
                new aip().mo1014a(p, this);
            }
            if (this.f1120M) {
                new aij().mo1014a(p, this);
            }
            new ain().mo1023a(p, this, this.f1122O, this.f1121N);
            if (this.f910q.f1234a != null) {
                this.f911r = new Thread(this);
                Thread thread = this.f911r;
                thread.setName("Subsystem for " + p.f1475P);
                if (p.f1472M) {
                    this.f911r.setDaemon(p.f1472M);
                }
                this.f911r.start();
            }
        } catch (Exception e) {
            if (e instanceof ahj) {
                throw ((ahj) e);
            } else if (e instanceof Throwable) {
                throw new ahj("ChannelSubsystem", e);
            } else {
                throw new ahj("ChannelSubsystem");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
        this.f910q.mo855a(mo686p().f1467F);
        this.f910q.mo857a(mo686p().f1468G);
    }

    /* renamed from: c */
    public void mo800c(OutputStream outputStream) {
        mo663b(outputStream);
    }

    /* renamed from: u */
    public InputStream mo718u() {
        return mo675g();
    }
}
