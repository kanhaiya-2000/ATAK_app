package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@adm(mo342a = {4})
public class adk extends adh {

    /* renamed from: k */
    private static Logger f547k = Logger.getLogger(adk.class.getName());

    /* renamed from: a */
    int f548a;

    /* renamed from: b */
    int f549b;

    /* renamed from: c */
    int f550c;

    /* renamed from: d */
    int f551d;

    /* renamed from: e */
    long f552e;

    /* renamed from: f */
    long f553f;

    /* renamed from: g */
    adl f554g;

    /* renamed from: h */
    adg f555h;

    /* renamed from: i */
    List<adt> f556i = new ArrayList();

    /* renamed from: j */
    byte[] f557j;

    public adk() {
        this.f537Z = 4;
    }

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        int k;
        this.f548a = C0679nk.m12499f(byteBuffer);
        int f = C0679nk.m12499f(byteBuffer);
        this.f549b = f >>> 2;
        this.f550c = (f >> 1) & 1;
        this.f551d = C0679nk.m12496c(byteBuffer);
        this.f552e = C0679nk.m12495b(byteBuffer);
        this.f553f = C0679nk.m12495b(byteBuffer);
        while (byteBuffer.remaining() > 2) {
            int position = byteBuffer.position();
            adh a = ads.m574a(this.f548a, byteBuffer);
            int position2 = byteBuffer.position() - position;
            Logger logger = f547k;
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(position2);
            sb.append(", size: ");
            sb.append(a != null ? Integer.valueOf(a.mo314k()) : null);
            logger.finer(sb.toString());
            if (a != null && position2 < (k = a.mo314k())) {
                byte[] bArr = new byte[(k - position2)];
                this.f557j = bArr;
                byteBuffer.get(bArr);
            }
            if (a instanceof adl) {
                this.f554g = (adl) a;
            } else if (a instanceof adg) {
                this.f555h = (adg) a;
            } else if (a instanceof adt) {
                this.f556i.add((adt) a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo292a() {
        adg adg = this.f555h;
        int i = 0;
        int k = (adg == null ? 0 : adg.mo314k()) + 13;
        adl adl = this.f554g;
        if (adl != null) {
            i = adl.mo314k();
        }
        int i2 = k + i;
        for (adt k2 : this.f556i) {
            i2 += k2.mo314k();
        }
        return i2;
    }

    /* renamed from: b */
    public ByteBuffer mo295b() {
        ByteBuffer allocate = ByteBuffer.allocate(mo314k());
        C0681nm.m12521d(allocate, this.f537Z);
        mo311a(allocate, mo292a());
        C0681nm.m12521d(allocate, this.f548a);
        C0681nm.m12521d(allocate, (this.f549b << 2) | (this.f550c << 1) | 1);
        C0681nm.m12510a(allocate, this.f551d);
        C0681nm.m12515b(allocate, this.f552e);
        C0681nm.m12515b(allocate, this.f553f);
        adl adl = this.f554g;
        if (adl != null) {
            allocate.put(adl.mo295b());
        }
        adg adg = this.f555h;
        if (adg != null) {
            allocate.put(adg.mo295b());
        }
        for (adt b : this.f556i) {
            allocate.put(b.mo295b());
        }
        return (ByteBuffer) allocate.rewind();
    }

    /* renamed from: c */
    public adl mo328c() {
        return this.f554g;
    }

    /* renamed from: a */
    public void mo325a(adl adl) {
        this.f554g = adl;
    }

    /* renamed from: d */
    public adg mo330d() {
        return this.f555h;
    }

    /* renamed from: a */
    public void mo324a(adg adg) {
        this.f555h = adg;
    }

    /* renamed from: e */
    public List<adt> mo332e() {
        return this.f556i;
    }

    /* renamed from: f */
    public int mo333f() {
        return this.f548a;
    }

    /* renamed from: a */
    public void mo322a(int i) {
        this.f548a = i;
    }

    /* renamed from: g */
    public int mo334g() {
        return this.f549b;
    }

    /* renamed from: b */
    public void mo326b(int i) {
        this.f549b = i;
    }

    /* renamed from: h */
    public int mo335h() {
        return this.f550c;
    }

    /* renamed from: c */
    public void mo329c(int i) {
        this.f550c = i;
    }

    /* renamed from: l */
    public int mo336l() {
        return this.f551d;
    }

    /* renamed from: d */
    public void mo331d(int i) {
        this.f551d = i;
    }

    /* renamed from: m */
    public long mo337m() {
        return this.f552e;
    }

    /* renamed from: a */
    public void mo323a(long j) {
        this.f552e = j;
    }

    /* renamed from: n */
    public long mo338n() {
        return this.f553f;
    }

    /* renamed from: b */
    public void mo327b(long j) {
        this.f553f = j;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.f548a);
        sb.append(", streamType=");
        sb.append(this.f549b);
        sb.append(", upStream=");
        sb.append(this.f550c);
        sb.append(", bufferSizeDB=");
        sb.append(this.f551d);
        sb.append(", maxBitRate=");
        sb.append(this.f552e);
        sb.append(", avgBitRate=");
        sb.append(this.f553f);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.f554g);
        sb.append(", audioSpecificInfo=");
        sb.append(this.f555h);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.f557j;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(C0677ni.m12484a(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List<adt> list = this.f556i;
        if (list == null) {
            str = "null";
        } else {
            str = Arrays.asList(new List[]{list}).toString();
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
