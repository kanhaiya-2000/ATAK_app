package atakplugin.UASTool;

import java.util.Hashtable;

public class agj extends age {
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

    agj() {
        this.f987F = true;
    }

    /* renamed from: d */
    public void mo669d() {
        air p = mo686p();
        try {
            mo720v();
            new ail().mo1014a(p, this);
            if (this.f910q.f1234a != null) {
                this.f911r = new Thread(this);
                Thread thread = this.f911r;
                thread.setName("Shell for " + p.f1475P);
                if (p.f1472M) {
                    this.f911r.setDaemon(p.f1472M);
                }
                this.f911r.start();
            }
        } catch (Exception e) {
            if (e instanceof ahj) {
                throw ((ahj) e);
            } else if (e instanceof Throwable) {
                throw new ahj("ChannelShell", e);
            } else {
                throw new ahj("ChannelShell");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo659b() {
        this.f910q.mo855a(mo686p().f1467F);
        this.f910q.mo857a(mo686p().f1468G);
    }
}
