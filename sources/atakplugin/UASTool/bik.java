package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, mo1538e = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"})
final class bik implements bil<Float> {

    /* renamed from: a */
    private final float f2730a;

    /* renamed from: b */
    private final float f2731b;

    /* renamed from: a */
    public boolean mo2583a(float f, float f2) {
        return f <= f2;
    }

    public bik(float f, float f2) {
        this.f2730a = f;
        this.f2731b = f2;
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2582a(((Number) comparable).floatValue());
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2576a(Comparable comparable, Comparable comparable2) {
        return mo2583a(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    /* renamed from: a */
    public Float mo2569g() {
        return Float.valueOf(this.f2730a);
    }

    /* renamed from: b */
    public Float mo2571i() {
        return Float.valueOf(this.f2731b);
    }

    /* renamed from: a */
    public boolean mo2582a(float f) {
        return f >= this.f2730a && f <= this.f2731b;
    }

    /* renamed from: e */
    public boolean mo2558e() {
        return this.f2730a > this.f2731b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bik) {
            if (!mo2558e() || !((bik) obj).mo2558e()) {
                bik bik = (bik) obj;
                if (!(this.f2730a == bik.f2730a && this.f2731b == bik.f2731b)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2558e()) {
            return -1;
        }
        return (Float.valueOf(this.f2730a).hashCode() * 31) + Float.valueOf(this.f2731b).hashCode();
    }

    public String toString() {
        return this.f2730a + ".." + this.f2731b;
    }
}
