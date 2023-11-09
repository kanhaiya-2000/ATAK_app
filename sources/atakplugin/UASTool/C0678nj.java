package atakplugin.UASTool;

import java.io.Closeable;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.channels.WritableByteChannel;

@C1016xa
/* renamed from: atakplugin.UASTool.nj */
public class C0678nj extends C1005wq implements Closeable {

    /* renamed from: a */
    private static afp f5335a = afp.m867a(C0678nj.class);

    public C0678nj(String str) {
        this((C1007ws) new C1009wu(new File(str)));
    }

    public C0678nj(C1007ws wsVar) {
        this(wsVar, new C0683no(new String[0]));
    }

    public C0678nj(C1007ws wsVar, C0675ng ngVar) {
        mo6123a(wsVar, wsVar.mo5651a(), ngVar);
    }

    /* renamed from: a */
    public static byte[] m12488a(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m12487a(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 4));
        }
        try {
            return new String(bArr2, bxz.f4229a);
        } catch (UnsupportedEncodingException e) {
            throw new Error("Required character encoding is missing", e);
        }
    }

    /* renamed from: a */
    public long mo5105a() {
        return mo6130u();
    }

    /* renamed from: b */
    public C0723ox mo5107b() {
        for (C0688nt next : mo36c()) {
            if (next instanceof C0723ox) {
                return (C0723ox) next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo5106a(WritableByteChannel writableByteChannel) {
        mo209b(writableByteChannel);
    }

    public void close() {
        this.f7522t.close();
    }

    public String toString() {
        return "model(" + this.f7522t.toString() + ")";
    }
}
