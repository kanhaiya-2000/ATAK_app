package indago.pose;

import atakplugin.UASTool.aot;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo1538e = {"Lindago/pose/FieldOfView;", "", "horizontal", "", "vertical", "(DD)V", "getHorizontal", "()D", "getVertical", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class FieldOfView {
    private final double horizontal;
    private final double vertical;

    public static /* synthetic */ FieldOfView copy$default(FieldOfView fieldOfView, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = fieldOfView.horizontal;
        }
        if ((i & 2) != 0) {
            d2 = fieldOfView.vertical;
        }
        return fieldOfView.copy(d, d2);
    }

    public final double component1() {
        return this.horizontal;
    }

    public final double component2() {
        return this.vertical;
    }

    public final FieldOfView copy(double d, double d2) {
        return new FieldOfView(d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldOfView)) {
            return false;
        }
        FieldOfView fieldOfView = (FieldOfView) obj;
        return Double.compare(this.horizontal, fieldOfView.horizontal) == 0 && Double.compare(this.vertical, fieldOfView.vertical) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.horizontal);
        long doubleToLongBits2 = Double.doubleToLongBits(this.vertical);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "FieldOfView(horizontal=" + this.horizontal + ", vertical=" + this.vertical + ")";
    }

    public FieldOfView(double d, double d2) {
        this.horizontal = d;
        this.vertical = d2;
    }

    public final double getHorizontal() {
        return this.horizontal;
    }

    public final double getVertical() {
        return this.vertical;
    }
}
