package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.UUID;

public class aen extends aeh {

    /* renamed from: b */
    public static UUID f703b = UUID.fromString("00000000-0000-0000-0000-000000000000");

    /* renamed from: c */
    ByteBuffer f704c;

    static {
        aeh.f649a.put(f703b, aen.class);
    }

    /* renamed from: a */
    public UUID mo457a() {
        return f703b;
    }

    /* renamed from: a */
    public void mo458a(ByteBuffer byteBuffer) {
        this.f704c = byteBuffer;
    }

    /* renamed from: b */
    public ByteBuffer mo459b() {
        return this.f704c;
    }
}
