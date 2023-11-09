package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class adq extends adr {

    /* renamed from: a */
    int f576a;

    /* renamed from: b */
    int f577b;

    /* renamed from: c */
    int f578c;

    /* renamed from: d */
    String f579d;

    /* renamed from: e */
    int f580e;

    /* renamed from: f */
    int f581f;

    /* renamed from: g */
    int f582g;

    /* renamed from: h */
    int f583h;

    /* renamed from: i */
    int f584i;

    /* renamed from: j */
    List<adn> f585j = new ArrayList();

    /* renamed from: k */
    List<ado> f586k = new ArrayList();

    /* renamed from: l */
    List<adh> f587l = new ArrayList();

    /* renamed from: m */
    private int f588m;

    /* renamed from: a */
    public void mo294a(ByteBuffer byteBuffer) {
        int i;
        int d = C0679nk.m12497d(byteBuffer);
        this.f588m = (65472 & d) >> 6;
        this.f576a = (d & 63) >> 5;
        this.f577b = (d & 31) >> 4;
        int k = mo314k() - 2;
        if (this.f576a == 1) {
            int f = C0679nk.m12499f(byteBuffer);
            this.f578c = f;
            this.f579d = C0679nk.m12494a(byteBuffer, f);
            i = k - (this.f578c + 1);
        } else {
            this.f580e = C0679nk.m12499f(byteBuffer);
            this.f581f = C0679nk.m12499f(byteBuffer);
            this.f582g = C0679nk.m12499f(byteBuffer);
            this.f583h = C0679nk.m12499f(byteBuffer);
            this.f584i = C0679nk.m12499f(byteBuffer);
            i = k - 5;
            if (i > 2) {
                adh a = ads.m574a(-1, byteBuffer);
                i -= a.mo314k();
                if (a instanceof adn) {
                    this.f585j.add((adn) a);
                } else {
                    this.f587l.add(a);
                }
            }
        }
        if (i > 2) {
            adh a2 = ads.m574a(-1, byteBuffer);
            if (a2 instanceof ado) {
                this.f586k.add((ado) a2);
            } else {
                this.f587l.add(a2);
            }
        }
    }

    public String toString() {
        return "InitialObjectDescriptor" + "{objectDescriptorId=" + this.f588m + ", urlFlag=" + this.f576a + ", includeInlineProfileLevelFlag=" + this.f577b + ", urlLength=" + this.f578c + ", urlString='" + this.f579d + '\'' + ", oDProfileLevelIndication=" + this.f580e + ", sceneProfileLevelIndication=" + this.f581f + ", audioProfileLevelIndication=" + this.f582g + ", visualProfileLevelIndication=" + this.f583h + ", graphicsProfileLevelIndication=" + this.f584i + ", esDescriptors=" + this.f585j + ", extensionDescriptors=" + this.f586k + ", unknownDescriptors=" + this.f587l + '}';
    }
}
