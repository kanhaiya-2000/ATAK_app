package atakplugin.UASTool;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

class aac implements C1024xh {

    /* renamed from: a */
    ByteBuffer f19a;

    aac() {
        aal aal = new aal();
        ByteBuffer allocate = ByteBuffer.allocate(afi.m847a(aal.mo19f()));
        this.f19a = allocate;
        try {
            aal.mo18a(new afh(allocate));
            this.f19a.rewind();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public void mo8a(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(this.f19a.duplicate());
    }

    /* renamed from: a */
    public long mo7a() {
        return (long) this.f19a.remaining();
    }

    /* renamed from: b */
    public ByteBuffer mo9b() {
        return this.f19a.duplicate();
    }
}
