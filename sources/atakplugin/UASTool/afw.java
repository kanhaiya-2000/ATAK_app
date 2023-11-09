package atakplugin.UASTool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class afw {
    /* renamed from: a */
    public static byte[] m896a(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (mostSignificantBits >>> ((7 - i) * 8)));
        }
        for (int i2 = 8; i2 < 16; i2++) {
            bArr[i2] = (byte) ((int) (leastSignificantBits >>> ((7 - i2) * 8)));
        }
        return bArr;
    }

    /* renamed from: a */
    public static UUID m895a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), wrap.getLong());
    }
}
