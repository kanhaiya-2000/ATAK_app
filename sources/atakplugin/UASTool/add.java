package atakplugin.UASTool;

import atakplugin.UASTool.can;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class add extends C1004wp {

    /* renamed from: c */
    private static Logger f447c = Logger.getLogger(add.class.getName());

    /* renamed from: d */
    private static final /* synthetic */ can.C0296b f448d = null;

    /* renamed from: e */
    private static final /* synthetic */ can.C0296b f449e = null;

    /* renamed from: f */
    private static final /* synthetic */ can.C0296b f450f = null;

    /* renamed from: o */
    private static final /* synthetic */ can.C0296b f451o = null;

    /* renamed from: p */
    private static final /* synthetic */ can.C0296b f452p = null;

    /* renamed from: a */
    protected adh f453a;

    /* renamed from: b */
    protected ByteBuffer f454b;

    /* renamed from: k */
    private static /* synthetic */ void mo291k() {
        cdj cdj = new cdj("AbstractDescriptorBox.java", add.class);
        f448d = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        f449e = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 58);
        f450f = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 62);
        f451o = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        f452p = cdj.mo4506a(can.f4448a, (caq) cdj.mo4523a("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 70);
    }

    static {
        mo291k();
    }

    public add(String str) {
        super(str);
    }

    /* renamed from: c */
    public ByteBuffer mo36c() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f448d, (Object) this, (Object) this));
        return this.f454b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35b(ByteBuffer byteBuffer) {
        mo6126g(byteBuffer);
        this.f454b.rewind();
        byteBuffer.put(this.f454b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo38d() {
        return (long) (this.f454b.limit() + 4);
    }

    /* renamed from: i */
    public adh mo43i() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f449e, (Object) this, (Object) this));
        return this.f453a;
    }

    /* renamed from: j */
    public String mo287j() {
        C1013wy.m14474a().mo6137a(cdj.m11376a(f450f, (Object) this, (Object) this));
        return this.f453a.toString();
    }

    /* renamed from: a */
    public void mo286a(adh adh) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f451o, (Object) this, (Object) this, (Object) adh));
        this.f453a = adh;
    }

    /* renamed from: c */
    public void mo112c(ByteBuffer byteBuffer) {
        C1013wy.m14474a().mo6137a(cdj.m11377a(f452p, (Object) this, (Object) this, (Object) byteBuffer));
        this.f454b = byteBuffer;
    }

    /* renamed from: a */
    public void mo32a(ByteBuffer byteBuffer) {
        mo6125f(byteBuffer);
        this.f454b = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.f454b.rewind();
            this.f453a = ads.m574a(-1, this.f454b);
        } catch (IOException e) {
            f447c.log(Level.WARNING, "Error parsing ObjectDescriptor", e);
        } catch (IndexOutOfBoundsException e2) {
            f447c.log(Level.WARNING, "Error parsing ObjectDescriptor", e2);
        }
    }
}
