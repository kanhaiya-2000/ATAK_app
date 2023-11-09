package atakplugin.UASTool;

import java.util.concurrent.TimeUnit;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo1538e = {"Lkotlin/time/MonoClock;", "Lkotlin/time/AbstractLongClock;", "Lkotlin/time/Clock;", "()V", "read", "", "toString", "", "kotlin-stdlib"})
public final class bpx extends bpj implements bpl {

    /* renamed from: a */
    public static final bpx f3138a = new bpx();

    public String toString() {
        return "Clock(System.nanoTime())";
    }

    private bpx() {
        super(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo2951a() {
        return System.nanoTime();
    }
}
