package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.UUID;

public class adw extends adx {

    /* renamed from: a */
    public static final String f595a = "seig";

    /* renamed from: b */
    private boolean f596b;

    /* renamed from: c */
    private byte f597c;

    /* renamed from: d */
    private UUID f598d;

    /* renamed from: a */
    public String mo377a() {
        return f595a;
    }

    /* renamed from: a */
    public void mo379a(ByteBuffer byteBuffer) {
        boolean z = true;
        if (C0679nk.m12496c(byteBuffer) != 1) {
            z = false;
        }
        this.f596b = z;
        this.f597c = (byte) C0679nk.m12499f(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.f598d = afw.m895a(bArr);
    }

    /* renamed from: b */
    public ByteBuffer mo382b() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        C0681nm.m12510a(allocate, this.f596b ? 1 : 0);
        if (this.f596b) {
            C0681nm.m12521d(allocate, (int) this.f597c);
            allocate.put(afw.m896a(this.f598d));
        } else {
            allocate.put(new byte[17]);
        }
        allocate.rewind();
        return allocate;
    }

    /* renamed from: c */
    public boolean mo383c() {
        return this.f596b;
    }

    /* renamed from: a */
    public void mo381a(boolean z) {
        this.f596b = z;
    }

    /* renamed from: d */
    public byte mo384d() {
        return this.f597c;
    }

    /* renamed from: a */
    public void mo378a(int i) {
        this.f597c = (byte) i;
    }

    /* renamed from: e */
    public UUID mo385e() {
        return this.f598d;
    }

    /* renamed from: a */
    public void mo380a(UUID uuid) {
        this.f598d = uuid;
    }

    public String toString() {
        return "CencSampleEncryptionInformationGroupEntry{isEncrypted=" + this.f596b + ", ivSize=" + this.f597c + ", kid=" + this.f598d + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        adw adw = (adw) obj;
        if (this.f596b != adw.f596b || this.f597c != adw.f597c) {
            return false;
        }
        UUID uuid = this.f598d;
        UUID uuid2 = adw.f598d;
        return uuid == null ? uuid2 == null : uuid.equals(uuid2);
    }

    public int hashCode() {
        int i = (((this.f596b ? 7 : 19) * 31) + this.f597c) * 31;
        UUID uuid = this.f598d;
        return i + (uuid != null ? uuid.hashCode() : 0);
    }
}
