package com.o3dr.services.android.lib.drone.calibration.magnetometer;

import android.os.Parcel;
import android.os.Parcelable;

public class MagnetometerCalibrationProgress implements Parcelable {
    public static final Parcelable.Creator<MagnetometerCalibrationProgress> CREATOR = new Parcelable.Creator<MagnetometerCalibrationProgress>() {
        public MagnetometerCalibrationProgress createFromParcel(Parcel parcel) {
            return new MagnetometerCalibrationProgress(parcel);
        }

        public MagnetometerCalibrationProgress[] newArray(int i) {
            return new MagnetometerCalibrationProgress[i];
        }
    };
    private int compassId;
    private int completionPercentage;
    private float directionX;
    private float directionY;
    private float directionZ;

    public int describeContents() {
        return 0;
    }

    public MagnetometerCalibrationProgress() {
    }

    public MagnetometerCalibrationProgress(int i, int i2, float f, float f2, float f3) {
        this.compassId = i;
        this.completionPercentage = i2;
        this.directionX = f;
        this.directionY = f2;
        this.directionZ = f3;
    }

    public int getCompassId() {
        return this.compassId;
    }

    public void setCompassId(byte b) {
        this.compassId = b;
    }

    public int getCompletionPercentage() {
        return this.completionPercentage;
    }

    public void setCompletionPercentage(byte b) {
        this.completionPercentage = b;
    }

    public float getDirectionX() {
        return this.directionX;
    }

    public void setDirectionX(float f) {
        this.directionX = f;
    }

    public float getDirectionY() {
        return this.directionY;
    }

    public void setDirectionY(float f) {
        this.directionY = f;
    }

    public float getDirectionZ() {
        return this.directionZ;
    }

    public void setDirectionZ(float f) {
        this.directionZ = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.compassId);
        parcel.writeInt(this.completionPercentage);
        parcel.writeFloat(this.directionX);
        parcel.writeFloat(this.directionY);
        parcel.writeFloat(this.directionZ);
    }

    private MagnetometerCalibrationProgress(Parcel parcel) {
        this.compassId = parcel.readInt();
        this.completionPercentage = parcel.readInt();
        this.directionX = parcel.readFloat();
        this.directionY = parcel.readFloat();
        this.directionZ = parcel.readFloat();
    }
}
