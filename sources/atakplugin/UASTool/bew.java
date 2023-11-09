package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo1538e = {"Lkotlin/jvm/internal/ByteSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"})
public final class bew extends bgg<byte[]> {

    /* renamed from: a */
    private final byte[] f2585a;

    public bew(int i) {
        super(i);
        this.f2585a = new byte[i];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2323a(byte[] bArr) {
        bfq.m6567f(bArr, "$this$getSize");
        return bArr.length;
    }

    /* renamed from: a */
    public final void mo2328a(byte b) {
        byte[] bArr = this.f2585a;
        int b2 = mo2468b();
        mo2469b(b2 + 1);
        bArr[b2] = b;
    }

    /* renamed from: a */
    public final byte[] mo2326a() {
        return (byte[]) mo2467a(this.f2585a, new byte[mo2471c()]);
    }
}
