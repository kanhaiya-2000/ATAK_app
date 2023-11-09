package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: atakplugin.UASTool.rb */
public abstract class C0791rb extends C1003wo implements C0797rh {

    /* renamed from: a */
    protected int f6018a = 1;

    /* renamed from: a */
    public abstract void mo105a(C1007ws wsVar, ByteBuffer byteBuffer, long j, C0675ng ngVar);

    /* renamed from: a */
    public abstract void mo18a(WritableByteChannel writableByteChannel);

    protected C0791rb(String str) {
        super(str);
    }

    /* renamed from: a */
    public int mo200a() {
        return this.f6018a;
    }

    /* renamed from: a */
    public void mo204a(int i) {
        this.f6018a = i;
    }
}
