package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class aal extends ame {
    /* renamed from: f */
    public long mo19f() {
        return 8;
    }

    public aal() {
        super("vtte");
    }

    /* renamed from: a */
    public void mo18a(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        C0681nm.m12515b(allocate, mo19f());
        allocate.put(C0678nj.m12488a(mo1476h()));
        writableByteChannel.write((ByteBuffer) allocate.rewind());
    }
}
