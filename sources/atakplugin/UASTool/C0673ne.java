package atakplugin.UASTool;

import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.ne */
class C0673ne extends ThreadLocal<ByteBuffer> {

    /* renamed from: a */
    final /* synthetic */ C0672nd f5332a;

    C0673ne(C0672nd ndVar) {
        this.f5332a = ndVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
