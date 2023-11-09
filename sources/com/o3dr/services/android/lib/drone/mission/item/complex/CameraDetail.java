package com.o3dr.services.android.lib.drone.mission.item.complex;

import android.os.Parcel;
import android.os.Parcelable;

public class CameraDetail implements Parcelable {
    public static final Parcelable.Creator<CameraDetail> CREATOR = new Parcelable.Creator<CameraDetail>() {
        public CameraDetail createFromParcel(Parcel parcel) {
            return new CameraDetail(parcel);
        }

        public CameraDetail[] newArray(int i) {
            return new CameraDetail[i];
        }
    };
    private final double focalLength;
    private final boolean isInLandscapeOrientation;
    private final String name;
    private final double overlap;
    private final double sensorHeight;
    private final double sensorResolution;
    private final double sensorWidth;
    private final double sidelap;

    public int describeContents() {
        return 0;
    }

    public CameraDetail() {
        this.name = "Canon SX260";
        this.sensorWidth = 6.12d;
        this.sensorHeight = 4.22d;
        this.sensorResolution = 12.1d;
        this.focalLength = 5.0d;
        this.overlap = 50.0d;
        this.sidelap = 60.0d;
        this.isInLandscapeOrientation = true;
    }

    public CameraDetail(String str, double d, double d2, double d3, double d4, double d5, double d6, boolean z) {
        this.name = str;
        this.sensorWidth = d;
        this.sensorHeight = d2;
        this.sensorResolution = d3;
        this.focalLength = d4;
        this.overlap = d5;
        this.sidelap = d6;
        this.isInLandscapeOrientation = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CameraDetail(com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail r16) {
        /*
            r15 = this;
            r0 = r16
            java.lang.String r1 = r0.name
            double r2 = r0.sensorWidth
            double r4 = r0.sensorHeight
            double r6 = r0.sensorResolution
            double r8 = r0.focalLength
            double r10 = r0.overlap
            double r12 = r0.sidelap
            boolean r14 = r0.isInLandscapeOrientation
            r0 = r15
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail.<init>(com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail):void");
    }

    public String getName() {
        return this.name;
    }

    public double getSensorWidth() {
        return this.sensorWidth;
    }

    public double getSensorHeight() {
        return this.sensorHeight;
    }

    public double getSensorResolution() {
        return this.sensorResolution;
    }

    public double getFocalLength() {
        return this.focalLength;
    }

    public double getOverlap() {
        return this.overlap;
    }

    public double getSidelap() {
        return this.sidelap;
    }

    public boolean isInLandscapeOrientation() {
        return this.isInLandscapeOrientation;
    }

    public Double getSensorLateralSize() {
        if (this.isInLandscapeOrientation) {
            return Double.valueOf(this.sensorWidth);
        }
        return Double.valueOf(this.sensorHeight);
    }

    public Double getSensorLongitudinalSize() {
        if (this.isInLandscapeOrientation) {
            return Double.valueOf(this.sensorHeight);
        }
        return Double.valueOf(this.sensorWidth);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraDetail)) {
            return false;
        }
        CameraDetail cameraDetail = (CameraDetail) obj;
        if (Double.compare(cameraDetail.focalLength, this.focalLength) != 0 || this.isInLandscapeOrientation != cameraDetail.isInLandscapeOrientation || Double.compare(cameraDetail.overlap, this.overlap) != 0 || Double.compare(cameraDetail.sensorHeight, this.sensorHeight) != 0 || Double.compare(cameraDetail.sensorResolution, this.sensorResolution) != 0 || Double.compare(cameraDetail.sensorWidth, this.sensorWidth) != 0 || Double.compare(cameraDetail.sidelap, this.sidelap) != 0) {
            return false;
        }
        String str = this.name;
        String str2 = cameraDetail.name;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = str != null ? str.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.sensorWidth);
        long doubleToLongBits2 = Double.doubleToLongBits(this.sensorHeight);
        long doubleToLongBits3 = Double.doubleToLongBits(this.sensorResolution);
        long doubleToLongBits4 = Double.doubleToLongBits(this.focalLength);
        long doubleToLongBits5 = Double.doubleToLongBits(this.overlap);
        long doubleToLongBits6 = Double.doubleToLongBits(this.sidelap);
        return (((((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + (this.isInLandscapeOrientation ? 1 : 0);
    }

    public String toString() {
        return "CameraDetail{name='" + this.name + '\'' + ", sensorWidth=" + this.sensorWidth + ", sensorHeight=" + this.sensorHeight + ", sensorResolution=" + this.sensorResolution + ", focalLength=" + this.focalLength + ", overlap=" + this.overlap + ", sidelap=" + this.sidelap + ", isInLandscapeOrientation=" + this.isInLandscapeOrientation + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeDouble(this.sensorWidth);
        parcel.writeDouble(this.sensorHeight);
        parcel.writeDouble(this.sensorResolution);
        parcel.writeDouble(this.focalLength);
        parcel.writeDouble(this.overlap);
        parcel.writeDouble(this.sidelap);
        parcel.writeByte(this.isInLandscapeOrientation ? (byte) 1 : 0);
    }

    private CameraDetail(Parcel parcel) {
        this.name = parcel.readString();
        this.sensorWidth = parcel.readDouble();
        this.sensorHeight = parcel.readDouble();
        this.sensorResolution = parcel.readDouble();
        this.focalLength = parcel.readDouble();
        this.overlap = parcel.readDouble();
        this.sidelap = parcel.readDouble();
        this.isInLandscapeOrientation = parcel.readByte() != 0;
    }
}
