package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Attitude implements DroneAttribute {
    public static final Parcelable.Creator<Attitude> CREATOR = new Parcelable.Creator<Attitude>() {
        public Attitude createFromParcel(Parcel parcel) {
            return new Attitude(parcel);
        }

        public Attitude[] newArray(int i) {
            return new Attitude[i];
        }
    };
    private double pitch;
    private float pitchSpeed;
    private double roll;
    private float rollSpeed;
    private double yaw;
    private float yawSpeed;

    public int describeContents() {
        return 0;
    }

    public Attitude() {
    }

    public Attitude(double d, double d2, double d3, float f, float f2, float f3) {
        this.roll = d;
        this.pitch = d2;
        this.yaw = d3;
        this.rollSpeed = f;
        this.pitchSpeed = f2;
        this.yawSpeed = f3;
    }

    public void setRoll(double d) {
        this.roll = d;
    }

    public void setPitch(double d) {
        this.pitch = d;
    }

    public void setYaw(double d) {
        this.yaw = d;
    }

    public double getRoll() {
        return this.roll;
    }

    public double getPitch() {
        return this.pitch;
    }

    public double getYaw() {
        return this.yaw;
    }

    public float getPitchSpeed() {
        return this.pitchSpeed;
    }

    public void setPitchSpeed(float f) {
        this.pitchSpeed = f;
    }

    public float getRollSpeed() {
        return this.rollSpeed;
    }

    public void setRollSpeed(float f) {
        this.rollSpeed = f;
    }

    public float getYawSpeed() {
        return this.yawSpeed;
    }

    public void setYawSpeed(float f) {
        this.yawSpeed = f;
    }

    public String toString() {
        return "Attitude{pitch=" + this.pitch + ", roll=" + this.roll + ", rollSpeed=" + this.rollSpeed + ", pitchSpeed=" + this.pitchSpeed + ", yaw=" + this.yaw + ", yawSpeed=" + this.yawSpeed + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attitude)) {
            return false;
        }
        Attitude attitude = (Attitude) obj;
        if (Double.compare(attitude.roll, this.roll) == 0 && Float.compare(attitude.rollSpeed, this.rollSpeed) == 0 && Double.compare(attitude.pitch, this.pitch) == 0 && Float.compare(attitude.pitchSpeed, this.pitchSpeed) == 0 && Double.compare(attitude.yaw, this.yaw) == 0 && Float.compare(attitude.yawSpeed, this.yawSpeed) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.roll);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        float f = this.rollSpeed;
        int i2 = 0;
        int floatToIntBits = f != 0.0f ? Float.floatToIntBits(f) : 0;
        long doubleToLongBits2 = Double.doubleToLongBits(this.pitch);
        int i3 = (((i + floatToIntBits) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        float f2 = this.pitchSpeed;
        int floatToIntBits2 = f2 != 0.0f ? Float.floatToIntBits(f2) : 0;
        long doubleToLongBits3 = Double.doubleToLongBits(this.yaw);
        int i4 = (((i3 + floatToIntBits2) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31;
        float f3 = this.yawSpeed;
        if (f3 != 0.0f) {
            i2 = Float.floatToIntBits(f3);
        }
        return i4 + i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.roll);
        parcel.writeDouble(this.pitch);
        parcel.writeDouble(this.yaw);
        parcel.writeFloat(this.rollSpeed);
        parcel.writeFloat(this.pitchSpeed);
        parcel.writeFloat(this.yawSpeed);
    }

    private Attitude(Parcel parcel) {
        this.roll = parcel.readDouble();
        this.pitch = parcel.readDouble();
        this.yaw = parcel.readDouble();
        this.rollSpeed = parcel.readFloat();
        this.pitchSpeed = parcel.readFloat();
        this.yawSpeed = parcel.readFloat();
    }
}
