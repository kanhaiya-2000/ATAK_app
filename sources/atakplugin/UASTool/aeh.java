package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class aeh {

    /* renamed from: a */
    protected static Map<UUID, Class<? extends aeh>> f649a = new HashMap();

    /* renamed from: a */
    public abstract UUID mo457a();

    /* renamed from: a */
    public abstract void mo458a(ByteBuffer byteBuffer);

    /* renamed from: b */
    public abstract ByteBuffer mo459b();

    public boolean equals(Object obj) {
        throw new RuntimeException("somebody called equals on me but that's not supposed to happen.");
    }

    /* renamed from: a */
    public static aeh m677a(UUID uuid, ByteBuffer byteBuffer) {
        aeh aeh;
        Class cls = f649a.get(uuid);
        if (cls != null) {
            try {
                aeh = (aeh) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            aeh = null;
        }
        if (aeh == null) {
            aeh = new aen();
        }
        aeh.mo458a(byteBuffer);
        return aeh;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProtectionSpecificHeader");
        sb.append("{data=");
        ByteBuffer duplicate = mo459b().duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        sb.append(C0677ni.m12484a(bArr));
        sb.append('}');
        return sb.toString();
    }
}
