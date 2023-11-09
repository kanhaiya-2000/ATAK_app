package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class aad extends ame {

    /* renamed from: a */
    String f20a = "";

    public aad(String str) {
        super(str);
    }

    /* renamed from: a */
    public String mo16a() {
        return this.f20a;
    }

    /* renamed from: a */
    public void mo17a(String str) {
        this.f20a = str;
    }

    /* renamed from: f */
    public long mo19f() {
        return (long) (C0684np.m12529b(this.f20a) + 8);
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(mo19f()));
        C0681nm.m12515b(allocate, mo19f());
        allocate.put(C0678nj.m12488a(mo1476h()));
        allocate.put(C0684np.m12528a(this.f20a));
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }
}
