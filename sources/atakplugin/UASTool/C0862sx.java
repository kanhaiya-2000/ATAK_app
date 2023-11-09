package atakplugin.UASTool;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: atakplugin.UASTool.sx */
public class C0862sx {

    /* renamed from: a */
    public static final String f6527a = "binary";

    /* renamed from: b */
    public static final String f6528b = "text";

    /* renamed from: d */
    private static final int f6529d = 16384;

    /* renamed from: c */
    private String f6530c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public byte[] f6531e;

    /* renamed from: f */
    private int f6532f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public byte[] f6533g;

    /* renamed from: h */
    private String f6534h;

    /* renamed from: i */
    private StringBuilder f6535i;

    /* renamed from: j */
    private List<String> f6536j = new ArrayList();

    /* renamed from: k */
    private List<byte[]> f6537k = new ArrayList();

    public C0862sx(String str) {
        this.f6530c = str;
        if (str.equals(f6527a)) {
            this.f6531e = new byte[16384];
        } else {
            this.f6535i = new StringBuilder(16384);
        }
    }

    public C0862sx(String str, int i) {
        this.f6530c = str;
        if (str.equals(f6527a)) {
            this.f6531e = new byte[i];
        } else {
            this.f6535i = new StringBuilder(i);
        }
    }

    /* renamed from: a */
    public void mo5790a(String str) {
        this.f6534h = str;
    }

    /* renamed from: a */
    public void mo5791a(byte[] bArr) {
        this.f6533g = bArr;
    }

    /* renamed from: b */
    public synchronized void mo5794b(byte[] bArr) {
        if (bArr.length != 0) {
            if (this.f6530c.equals("text")) {
                try {
                    this.f6535i.append(new String(bArr, "UTF-8"));
                    String sb = this.f6535i.toString();
                    int indexOf = sb.indexOf(this.f6534h);
                    int i = 0;
                    while (indexOf >= 0) {
                        this.f6536j.add(sb.substring(i, this.f6534h.length() + indexOf));
                        i = this.f6534h.length() + indexOf;
                        indexOf = this.f6535i.toString().indexOf(this.f6534h, i);
                    }
                    if (i > 0) {
                        String substring = sb.substring(i, sb.length());
                        this.f6535i.setLength(0);
                        this.f6535i.append(substring);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if (this.f6530c.equals(f6527a)) {
                m13876c(bArr);
            }
        }
    }

    /* renamed from: a */
    public boolean mo5792a() {
        if (this.f6530c.equals("text")) {
            if (this.f6536j.size() > 0) {
                return true;
            }
            return false;
        } else if (this.f6537k.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    public String mo5793b() {
        if (this.f6536j.size() > 0) {
            return this.f6536j.remove(0);
        }
        return null;
    }

    /* renamed from: c */
    public byte[] mo5795c() {
        if (this.f6537k.size() > 0) {
            return this.f6537k.remove(0);
        }
        return null;
    }

    /* renamed from: c */
    private void m13876c(byte[] bArr) {
        System.arraycopy(bArr, 0, this.f6531e, this.f6532f, bArr.length);
        this.f6532f += bArr.length;
        int i = 0;
        for (int valueOf : C0206bo.m7864a(0, this.f6532f).mo2891a((C0453fz) new C0863a()).mo2918f()) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            this.f6537k.add(Arrays.copyOfRange(this.f6531e, i, valueOf2.intValue() + this.f6533g.length));
            i = valueOf2.intValue() + this.f6533g.length;
        }
        byte[] bArr2 = this.f6531e;
        if (i < bArr2.length && i > 0) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr2, i, bArr2.length);
            this.f6532f = 0;
            System.arraycopy(copyOfRange, 0, this.f6531e, 0, bArr.length);
            this.f6532f += bArr.length;
        }
    }

    /* renamed from: atakplugin.UASTool.sx$a */
    private class C0863a implements C0453fz {
        private C0863a() {
        }

        /* renamed from: a */
        public boolean mo4922a(int i) {
            if (C0862sx.this.f6531e[i] != C0862sx.this.f6533g[0]) {
                return false;
            }
            for (int i2 = 1; i2 <= C0862sx.this.f6533g.length - 1; i2++) {
                if (C0862sx.this.f6531e[i + i2] != C0862sx.this.f6533g[i2]) {
                    return false;
                }
            }
            return true;
        }
    }
}
