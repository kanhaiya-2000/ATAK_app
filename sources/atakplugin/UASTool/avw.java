package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000J\u0010\u0010\u0005\u001a\u00020\u0002H&ø\u0001\u0000¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, mo1538e = {"Lkotlin/collections/UByteIterator;", "", "Lkotlin/UByte;", "()V", "next", "nextUByte", "()B", "kotlin-stdlib"})
public abstract class avw implements bgz, Iterator<apy> {
    /* renamed from: a */
    public abstract byte mo1601a();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public final apy next() {
        return apy.m2693c(mo1601a());
    }
}
