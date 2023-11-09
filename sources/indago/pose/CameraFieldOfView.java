package indago.pose;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, mo1538e = {"Lindago/pose/CameraFieldOfView;", "", "gimbalAzimuth", "", "gimbalRoll", "gimbalElevation", "snapshotFov", "Lindago/pose/FieldOfView;", "videoFov", "zoomLevel", "", "(DDDLindago/pose/FieldOfView;Lindago/pose/FieldOfView;I)V", "getGimbalAzimuth", "()D", "getGimbalElevation", "getGimbalRoll", "getSnapshotFov", "()Lindago/pose/FieldOfView;", "getVideoFov", "getZoomLevel", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "indago"})
public final class CameraFieldOfView {
    private final double gimbalAzimuth;
    private final double gimbalElevation;
    private final double gimbalRoll;
    private final FieldOfView snapshotFov;
    private final FieldOfView videoFov;
    private final int zoomLevel;

    public static /* synthetic */ CameraFieldOfView copy$default(CameraFieldOfView cameraFieldOfView, double d, double d2, double d3, FieldOfView fieldOfView, FieldOfView fieldOfView2, int i, int i2, Object obj) {
        CameraFieldOfView cameraFieldOfView2 = cameraFieldOfView;
        return cameraFieldOfView.copy((i2 & 1) != 0 ? cameraFieldOfView2.gimbalAzimuth : d, (i2 & 2) != 0 ? cameraFieldOfView2.gimbalRoll : d2, (i2 & 4) != 0 ? cameraFieldOfView2.gimbalElevation : d3, (i2 & 8) != 0 ? cameraFieldOfView2.snapshotFov : fieldOfView, (i2 & 16) != 0 ? cameraFieldOfView2.videoFov : fieldOfView2, (i2 & 32) != 0 ? cameraFieldOfView2.zoomLevel : i);
    }

    public final double component1() {
        return this.gimbalAzimuth;
    }

    public final double component2() {
        return this.gimbalRoll;
    }

    public final double component3() {
        return this.gimbalElevation;
    }

    public final FieldOfView component4() {
        return this.snapshotFov;
    }

    public final FieldOfView component5() {
        return this.videoFov;
    }

    public final int component6() {
        return this.zoomLevel;
    }

    public final CameraFieldOfView copy(double d, double d2, double d3, FieldOfView fieldOfView, FieldOfView fieldOfView2, int i) {
        FieldOfView fieldOfView3 = fieldOfView;
        bfq.m6567f(fieldOfView3, "snapshotFov");
        FieldOfView fieldOfView4 = fieldOfView2;
        bfq.m6567f(fieldOfView4, "videoFov");
        return new CameraFieldOfView(d, d2, d3, fieldOfView3, fieldOfView4, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CameraFieldOfView) {
                CameraFieldOfView cameraFieldOfView = (CameraFieldOfView) obj;
                if (Double.compare(this.gimbalAzimuth, cameraFieldOfView.gimbalAzimuth) == 0 && Double.compare(this.gimbalRoll, cameraFieldOfView.gimbalRoll) == 0 && Double.compare(this.gimbalElevation, cameraFieldOfView.gimbalElevation) == 0 && bfq.m6552a((Object) this.snapshotFov, (Object) cameraFieldOfView.snapshotFov) && bfq.m6552a((Object) this.videoFov, (Object) cameraFieldOfView.videoFov)) {
                    if (this.zoomLevel == cameraFieldOfView.zoomLevel) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.gimbalAzimuth);
        long doubleToLongBits2 = Double.doubleToLongBits(this.gimbalRoll);
        long doubleToLongBits3 = Double.doubleToLongBits(this.gimbalElevation);
        int i = ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
        FieldOfView fieldOfView = this.snapshotFov;
        int i2 = 0;
        int hashCode = (i + (fieldOfView != null ? fieldOfView.hashCode() : 0)) * 31;
        FieldOfView fieldOfView2 = this.videoFov;
        if (fieldOfView2 != null) {
            i2 = fieldOfView2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.zoomLevel;
    }

    public String toString() {
        return "CameraFieldOfView(gimbalAzimuth=" + this.gimbalAzimuth + ", gimbalRoll=" + this.gimbalRoll + ", gimbalElevation=" + this.gimbalElevation + ", snapshotFov=" + this.snapshotFov + ", videoFov=" + this.videoFov + ", zoomLevel=" + this.zoomLevel + ")";
    }

    public CameraFieldOfView(double d, double d2, double d3, FieldOfView fieldOfView, FieldOfView fieldOfView2, int i) {
        bfq.m6567f(fieldOfView, "snapshotFov");
        bfq.m6567f(fieldOfView2, "videoFov");
        this.gimbalAzimuth = d;
        this.gimbalRoll = d2;
        this.gimbalElevation = d3;
        this.snapshotFov = fieldOfView;
        this.videoFov = fieldOfView2;
        this.zoomLevel = i;
    }

    public final double getGimbalAzimuth() {
        return this.gimbalAzimuth;
    }

    public final double getGimbalRoll() {
        return this.gimbalRoll;
    }

    public final double getGimbalElevation() {
        return this.gimbalElevation;
    }

    public final FieldOfView getSnapshotFov() {
        return this.snapshotFov;
    }

    public final FieldOfView getVideoFov() {
        return this.videoFov;
    }

    public final int getZoomLevel() {
        return this.zoomLevel;
    }
}
