package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Vibration implements DroneAttribute {
    public static final Parcelable.Creator<Vibration> CREATOR = new Parcelable.Creator<Vibration>() {
        public Vibration createFromParcel(Parcel parcel) {
            return new Vibration(parcel);
        }

        public Vibration[] newArray(int i) {
            return new Vibration[i];
        }
    };
    private long firstAccelClipping;
    private long secondAccelClipping;
    private long thirdAccelClipping;
    private float vibrationX;
    private float vibrationY;
    private float vibrationZ;

    public int describeContents() {
        return 0;
    }

    public Vibration() {
    }

    public Vibration(long j, long j2, long j3, float f, float f2, float f3) {
        this.firstAccelClipping = j;
        this.secondAccelClipping = j2;
        this.thirdAccelClipping = j3;
        this.vibrationX = f;
        this.vibrationY = f2;
        this.vibrationZ = f3;
    }

    public long getFirstAccelClipping() {
        return this.firstAccelClipping;
    }

    public void setFirstAccelClipping(long j) {
        this.firstAccelClipping = j;
    }

    public long getSecondAccelClipping() {
        return this.secondAccelClipping;
    }

    public void setSecondAccelClipping(long j) {
        this.secondAccelClipping = j;
    }

    public long getThirdAccelClipping() {
        return this.thirdAccelClipping;
    }

    public void setThirdAccelClipping(long j) {
        this.thirdAccelClipping = j;
    }

    public float getVibrationX() {
        return this.vibrationX;
    }

    public void setVibrationX(float f) {
        this.vibrationX = f;
    }

    public float getVibrationY() {
        return this.vibrationY;
    }

    public void setVibrationY(float f) {
        this.vibrationY = f;
    }

    public float getVibrationZ() {
        return this.vibrationZ;
    }

    public void setVibrationZ(float f) {
        this.vibrationZ = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vibration)) {
            return false;
        }
        Vibration vibration = (Vibration) obj;
        if (Float.compare(vibration.vibrationX, this.vibrationX) == 0 && Float.compare(vibration.vibrationY, this.vibrationY) == 0 && Float.compare(vibration.vibrationZ, this.vibrationZ) == 0 && this.firstAccelClipping == vibration.firstAccelClipping && this.secondAccelClipping == vibration.secondAccelClipping && this.thirdAccelClipping == vibration.thirdAccelClipping) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        float f = this.vibrationX;
        int i = 0;
        int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.vibrationY;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.vibrationZ;
        if (f3 != 0.0f) {
            i = Float.floatToIntBits(f3);
        }
        long j = this.firstAccelClipping;
        long j2 = this.secondAccelClipping;
        long j3 = this.thirdAccelClipping;
        return ((((((floatToIntBits2 + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "Vibration{firstAccelClipping=" + this.firstAccelClipping + ", vibrationX=" + this.vibrationX + ", vibrationY=" + this.vibrationY + ", vibrationZ=" + this.vibrationZ + ", secondAccelClipping=" + this.secondAccelClipping + ", thirdAccelClipping=" + this.thirdAccelClipping + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.vibrationX);
        parcel.writeFloat(this.vibrationY);
        parcel.writeFloat(this.vibrationZ);
        parcel.writeLong(this.firstAccelClipping);
        parcel.writeLong(this.secondAccelClipping);
        parcel.writeLong(this.thirdAccelClipping);
    }

    protected Vibration(Parcel parcel) {
        this.vibrationX = parcel.readFloat();
        this.vibrationY = parcel.readFloat();
        this.vibrationZ = parcel.readFloat();
        this.firstAccelClipping = parcel.readLong();
        this.secondAccelClipping = parcel.readLong();
        this.thirdAccelClipping = parcel.readLong();
    }
}
