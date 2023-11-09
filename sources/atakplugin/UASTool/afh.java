package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public class afh implements ByteChannel {

    /* renamed from: a */
    ByteBuffer f854a;

    public void close() {
    }

    public boolean isOpen() {
        return true;
    }

    public afh(ByteBuffer byteBuffer) {
        this.f854a = byteBuffer;
    }

    public int read(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (this.f854a.remaining() <= 0) {
            return -1;
        }
        byteBuffer.put((ByteBuffer) this.f854a.duplicate().limit(this.f854a.position() + byteBuffer.remaining()));
        ByteBuffer byteBuffer2 = this.f854a;
        byteBuffer2.position(byteBuffer2.position() + remaining);
        return remaining;
    }

    public int write(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.f854a.put(byteBuffer);
        return remaining;
    }
}
