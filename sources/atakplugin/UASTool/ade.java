package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.nio.ByteBuffer;

public class ade extends add {

    /* renamed from: c */
    public static final String f455c = "esds";

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f456d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f457e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f458f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f459o = null;

    static {
        m466l();
    }

    /* renamed from: l */
    private static /* synthetic */ void m466l() {
        cdj cdj = new cdj("ESDescriptorBox.java", ade.class);
        f456d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 35);
        f457e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 39);
        f458f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 44);
        f459o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 55);
    }

    public ade() {
        super(f455c);
    }

    /* renamed from: k */
    public adn mo291k() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f456d, (Object) this, (Object) this));
        return (adn) super.mo43i();
    }

    /* renamed from: a */
    public void mo288a(adn adn) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f457e, (Object) this, (Object) this, (Object) adn));
        super.mo286a((adh) adn);
    }

    public boolean equals(Object obj) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f458f, (Object) this, (Object) this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ade ade = (ade) obj;
        return this.f454b == null ? ade.f454b == null : this.f454b.equals(ade.f454b);
    }

    public int hashCode() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f459o, (Object) this, (Object) this));
        if (this.f454b != null) {
            return this.f454b.hashCode();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (mo291k().mo314k() + 4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        byteBuffer.put((ByteBuffer) mo291k().mo295b().rewind());
    }
}
