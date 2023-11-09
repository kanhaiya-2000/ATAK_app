package atakplugin.UASTool;

import android.hardware.usb.UsbRequest;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.sz */
public class C0865sz extends UsbRequest {

    /* renamed from: a */
    static final String f6539a = "mBuffer";

    /* renamed from: b */
    static final String f6540b = "mLength";

    public boolean queue(ByteBuffer byteBuffer, int i) {
        try {
            Field declaredField = UsbRequest.class.getDeclaredField(f6539a);
            Field declaredField2 = UsbRequest.class.getDeclaredField(f6540b);
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField.set(this, byteBuffer);
            declaredField2.set(this, Integer.valueOf(i));
            return super.queue(byteBuffer, i);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
