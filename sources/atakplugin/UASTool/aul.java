package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, mo1538e = {"Lkotlin/collections/FloatIterator;", "", "", "()V", "next", "()Ljava/lang/Float;", "nextFloat", "kotlin-stdlib"})
public abstract class aul implements bgz, Iterator<Float> {
    /* renamed from: b */
    public abstract float mo1987b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: a */
    public final Float next() {
        return Float.valueOf(mo1987b());
    }
}
