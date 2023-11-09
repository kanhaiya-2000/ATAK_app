package indago.datastructures;

import atakplugin.UASTool.aot;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, mo1538e = {"Lindago/datastructures/Vector3;", "", "x", "", "y", "z", "(DDD)V", "getX", "()D", "getY", "getZ", "component1", "component2", "component3", "computeMagnitude", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class Vector3 {

    /* renamed from: x */
    private final double f8614x;

    /* renamed from: y */
    private final double f8615y;

    /* renamed from: z */
    private final double f8616z;

    public Vector3() {
        this(0.0d, 0.0d, 0.0d, 7, (bfd) null);
    }

    public static /* synthetic */ Vector3 copy$default(Vector3 vector3, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = vector3.f8614x;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = vector3.f8615y;
        }
        double d5 = d2;
        if ((i & 4) != 0) {
            d3 = vector3.f8616z;
        }
        return vector3.copy(d4, d5, d3);
    }

    public final double component1() {
        return this.f8614x;
    }

    public final double component2() {
        return this.f8615y;
    }

    public final double component3() {
        return this.f8616z;
    }

    public final Vector3 copy(double d, double d2, double d3) {
        return new Vector3(d, d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vector3)) {
            return false;
        }
        Vector3 vector3 = (Vector3) obj;
        return Double.compare(this.f8614x, vector3.f8614x) == 0 && Double.compare(this.f8615y, vector3.f8615y) == 0 && Double.compare(this.f8616z, vector3.f8616z) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f8614x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f8615y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f8616z);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public String toString() {
        return "Vector3(x=" + this.f8614x + ", y=" + this.f8615y + ", z=" + this.f8616z + ")";
    }

    public Vector3(double d, double d2, double d3) {
        this.f8614x = d;
        this.f8615y = d2;
        this.f8616z = d3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Vector3(double r7, double r9, double r11, int r13, atakplugin.UASTool.bfd r14) {
        /*
            r6 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r7
        L_0x0009:
            r7 = r13 & 2
            if (r7 == 0) goto L_0x000f
            r4 = r0
            goto L_0x0010
        L_0x000f:
            r4 = r9
        L_0x0010:
            r7 = r13 & 4
            if (r7 == 0) goto L_0x0016
            r12 = r0
            goto L_0x0017
        L_0x0016:
            r12 = r11
        L_0x0017:
            r7 = r6
            r8 = r2
            r10 = r4
            r7.<init>(r8, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: indago.datastructures.Vector3.<init>(double, double, double, int, atakplugin.UASTool.bfd):void");
    }

    public final double getX() {
        return this.f8614x;
    }

    public final double getY() {
        return this.f8615y;
    }

    public final double getZ() {
        return this.f8616z;
    }

    public final double computeMagnitude() {
        double d = this.f8614x;
        double d2 = this.f8615y;
        double d3 = (d * d) + (d2 * d2);
        double d4 = this.f8616z;
        return Math.sqrt(d3 + (d4 * d4));
    }
}
