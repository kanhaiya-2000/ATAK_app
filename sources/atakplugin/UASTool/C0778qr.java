package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.qr */
public class C0778qr {

    /* renamed from: a */
    private byte f5885a;

    /* renamed from: b */
    private byte f5886b;

    /* renamed from: c */
    private byte f5887c;

    /* renamed from: d */
    private byte f5888d;

    /* renamed from: e */
    private byte f5889e;

    /* renamed from: f */
    private byte f5890f;

    /* renamed from: g */
    private boolean f5891g;

    /* renamed from: h */
    private int f5892h;

    public C0778qr() {
    }

    public C0778qr(ByteBuffer byteBuffer) {
        long b = C0679nk.m12495b(byteBuffer);
        this.f5885a = (byte) ((int) ((-268435456 & b) >> 28));
        this.f5886b = (byte) ((int) ((201326592 & b) >> 26));
        this.f5887c = (byte) ((int) ((50331648 & b) >> 24));
        this.f5888d = (byte) ((int) ((12582912 & b) >> 22));
        this.f5889e = (byte) ((int) ((3145728 & b) >> 20));
        this.f5890f = (byte) ((int) ((917504 & b) >> 17));
        this.f5891g = ((bxn.f4206a & b) >> 16) > 0;
        this.f5892h = (int) (b & 65535);
    }

    /* renamed from: a */
    public void mo5458a(ByteBuffer byteBuffer) {
        C0681nm.m12515b(byteBuffer, ((long) (this.f5885a << Ascii.f8517FS)) | 0 | ((long) (this.f5886b << Ascii.SUB)) | ((long) (this.f5887c << Ascii.CAN)) | ((long) (this.f5888d << Ascii.SYN)) | ((long) (this.f5889e << Ascii.DC4)) | ((long) (this.f5890f << 17)) | ((long) ((this.f5891g ? 1 : 0) << true)) | ((long) this.f5892h));
    }

    /* renamed from: a */
    public int mo5455a() {
        return this.f5885a;
    }

    /* renamed from: a */
    public void mo5457a(int i) {
        this.f5885a = (byte) i;
    }

    /* renamed from: b */
    public byte mo5460b() {
        return this.f5886b;
    }

    /* renamed from: a */
    public void mo5456a(byte b) {
        this.f5886b = b;
    }

    /* renamed from: c */
    public int mo5462c() {
        return this.f5887c;
    }

    /* renamed from: b */
    public void mo5461b(int i) {
        this.f5887c = (byte) i;
    }

    /* renamed from: d */
    public int mo5464d() {
        return this.f5888d;
    }

    /* renamed from: c */
    public void mo5463c(int i) {
        this.f5888d = (byte) i;
    }

    /* renamed from: e */
    public int mo5466e() {
        return this.f5889e;
    }

    /* renamed from: d */
    public void mo5465d(int i) {
        this.f5889e = (byte) i;
    }

    /* renamed from: f */
    public int mo5469f() {
        return this.f5890f;
    }

    /* renamed from: e */
    public void mo5467e(int i) {
        this.f5890f = (byte) i;
    }

    /* renamed from: g */
    public boolean mo5471g() {
        return this.f5891g;
    }

    /* renamed from: a */
    public void mo5459a(boolean z) {
        this.f5891g = z;
    }

    /* renamed from: h */
    public int mo5472h() {
        return this.f5892h;
    }

    /* renamed from: f */
    public void mo5470f(int i) {
        this.f5892h = i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + this.f5885a + ", isLeading=" + this.f5886b + ", depOn=" + this.f5887c + ", isDepOn=" + this.f5888d + ", hasRedundancy=" + this.f5889e + ", padValue=" + this.f5890f + ", isDiffSample=" + this.f5891g + ", degradPrio=" + this.f5892h + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0778qr qrVar = (C0778qr) obj;
        return this.f5886b == qrVar.f5886b && this.f5885a == qrVar.f5885a && this.f5892h == qrVar.f5892h && this.f5887c == qrVar.f5887c && this.f5889e == qrVar.f5889e && this.f5888d == qrVar.f5888d && this.f5891g == qrVar.f5891g && this.f5890f == qrVar.f5890f;
    }

    public int hashCode() {
        return (((((((((((((this.f5885a * Ascii.f8526US) + this.f5886b) * 31) + this.f5887c) * 31) + this.f5888d) * 31) + this.f5889e) * 31) + this.f5890f) * 31) + (this.f5891g ? 1 : 0)) * 31) + this.f5892h;
    }
}
