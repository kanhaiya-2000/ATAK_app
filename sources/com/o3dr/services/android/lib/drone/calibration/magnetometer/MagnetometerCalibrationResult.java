package com.o3dr.services.android.lib.drone.calibration.magnetometer;

import android.os.Parcel;
import android.os.Parcelable;

public class MagnetometerCalibrationResult implements Parcelable {
    public static final Parcelable.Creator<MagnetometerCalibrationResult> CREATOR = new Parcelable.Creator<MagnetometerCalibrationResult>() {
        public MagnetometerCalibrationResult createFromParcel(Parcel parcel) {
            return new MagnetometerCalibrationResult(parcel);
        }

        public MagnetometerCalibrationResult[] newArray(int i) {
            return new MagnetometerCalibrationResult[i];
        }
    };
    private boolean autoSaved;
    private boolean calibrationSuccessful;
    private int compassId;
    private float fitness;
    private float xDiag;
    private float xOffDiag;
    private float xOffset;
    private float yDiag;
    private float yOffDiag;
    private float yOffset;
    private float zDiag;
    private float zOffDiag;
    private float zOffset;

    public int describeContents() {
        return 0;
    }

    public MagnetometerCalibrationResult() {
    }

    public MagnetometerCalibrationResult(int i, boolean z, boolean z2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.compassId = i;
        this.calibrationSuccessful = z;
        this.autoSaved = z2;
        this.fitness = f;
        this.xDiag = f5;
        this.xOffDiag = f8;
        this.xOffset = f2;
        this.yDiag = f6;
        this.yOffDiag = f9;
        this.yOffset = f3;
        this.zDiag = f7;
        this.zOffDiag = f10;
        this.zOffset = f4;
    }

    public int getCompassId() {
        return this.compassId;
    }

    public void setCompassId(byte b) {
        this.compassId = b;
    }

    public boolean isCalibrationSuccessful() {
        return this.calibrationSuccessful;
    }

    public void setCalibrationSuccessful(boolean z) {
        this.calibrationSuccessful = z;
    }

    public boolean isAutoSaved() {
        return this.autoSaved;
    }

    public void setAutoSaved(boolean z) {
        this.autoSaved = z;
    }

    public float getFitness() {
        return this.fitness;
    }

    public void setFitness(float f) {
        this.fitness = f;
    }

    public float getxDiag() {
        return this.xDiag;
    }

    public void setxDiag(float f) {
        this.xDiag = f;
    }

    public float getxOffDiag() {
        return this.xOffDiag;
    }

    public void setxOffDiag(float f) {
        this.xOffDiag = f;
    }

    public float getxOffset() {
        return this.xOffset;
    }

    public void setxOffset(float f) {
        this.xOffset = f;
    }

    public float getyDiag() {
        return this.yDiag;
    }

    public void setyDiag(float f) {
        this.yDiag = f;
    }

    public float getyOffDiag() {
        return this.yOffDiag;
    }

    public void setyOffDiag(float f) {
        this.yOffDiag = f;
    }

    public float getyOffset() {
        return this.yOffset;
    }

    public void setyOffset(float f) {
        this.yOffset = f;
    }

    public float getzDiag() {
        return this.zDiag;
    }

    public void setzDiag(float f) {
        this.zDiag = f;
    }

    public float getzOffDiag() {
        return this.zOffDiag;
    }

    public void setzOffDiag(float f) {
        this.zOffDiag = f;
    }

    public float getzOffset() {
        return this.zOffset;
    }

    public void setzOffset(float f) {
        this.zOffset = f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.compassId);
        parcel.writeFloat(this.fitness);
        parcel.writeFloat(this.xOffset);
        parcel.writeFloat(this.yOffset);
        parcel.writeFloat(this.zOffset);
        parcel.writeFloat(this.xDiag);
        parcel.writeFloat(this.yDiag);
        parcel.writeFloat(this.zDiag);
        parcel.writeFloat(this.xOffDiag);
        parcel.writeFloat(this.yOffDiag);
        parcel.writeFloat(this.zOffDiag);
        parcel.writeByte(this.autoSaved ? (byte) 1 : 0);
        parcel.writeByte(this.calibrationSuccessful ? (byte) 1 : 0);
    }

    private MagnetometerCalibrationResult(Parcel parcel) {
        this.compassId = parcel.readInt();
        this.fitness = parcel.readFloat();
        this.xOffset = parcel.readFloat();
        this.yOffset = parcel.readFloat();
        this.zOffset = parcel.readFloat();
        this.xDiag = parcel.readFloat();
        this.yDiag = parcel.readFloat();
        this.zDiag = parcel.readFloat();
        this.xOffDiag = parcel.readFloat();
        this.yOffDiag = parcel.readFloat();
        this.zOffDiag = parcel.readFloat();
        boolean z = true;
        this.autoSaved = parcel.readByte() != 0;
        this.calibrationSuccessful = parcel.readByte() == 0 ? false : z;
    }
}
