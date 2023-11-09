package atakplugin.UASTool;

import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/jvm/internal/ArrayByteIterator;", "Lkotlin/collections/ByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextByte", "", "kotlin-stdlib"})
final class bej extends atm {

    /* renamed from: a */
    private int f2562a;

    /* renamed from: b */
    private final byte[] f2563b;

    public bej(byte[] bArr) {
        bfq.m6567f(bArr, "array");
        this.f2563b = bArr;
    }

    public boolean hasNext() {
        return this.f2562a < this.f2563b.length;
    }

    /* renamed from: b */
    public byte mo1878b() {
        try {
            byte[] bArr = this.f2563b;
            int i = this.f2562a;
            this.f2562a = i + 1;
            return bArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f2562a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
