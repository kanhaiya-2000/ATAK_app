package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.BitSet;

public class EkfStatus implements DroneAttribute {
    public static final Parcelable.Creator<EkfStatus> CREATOR = new Parcelable.Creator<EkfStatus>() {
        public EkfStatus createFromParcel(Parcel parcel) {
            return new EkfStatus(parcel);
        }

        public EkfStatus[] newArray(int i) {
            return new EkfStatus[i];
        }
    };
    private static final int FLAGS_BIT_COUNT = 16;
    private float compassVariance;
    private final BitSet flags;
    private float horizontalPositionVariance;
    private float terrainAltitudeVariance;
    private float velocityVariance;
    private float verticalPositionVariance;

    public int describeContents() {
        return 0;
    }

    public enum EkfFlags {
        EKF_ATTITUDE(1),
        EKF_VELOCITY_HORIZ(2),
        EKF_VELOCITY_VERT(4),
        EKF_POS_HORIZ_REL(8),
        EKF_POS_HORIZ_ABS(16),
        EKF_POS_VERT_ABS(32),
        EKF_POS_VERT_AGL(64),
        EKF_CONST_POS_MODE(128),
        EKF_PRED_POS_HORIZ_REL(256),
        EKF_PRED_POS_HORIZ_ABS(512);
        
        final int value;

        private EkfFlags(int i) {
            this.value = i;
        }
    }

    public EkfStatus() {
        this.flags = new BitSet(16);
    }

    public EkfStatus(int i, float f, float f2, float f3, float f4, float f5) {
        this();
        this.compassVariance = f;
        this.horizontalPositionVariance = f2;
        this.terrainAltitudeVariance = f3;
        this.velocityVariance = f4;
        this.verticalPositionVariance = f5;
        fromShortToBitSet(i);
    }

    private void fromShortToBitSet(int i) {
        EkfFlags[] values = EkfFlags.values();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.flags.set(i2, (values[i2].value & i) != 0);
        }
    }

    public float getTerrainAltitudeVariance() {
        return this.terrainAltitudeVariance;
    }

    public void setTerrainAltitudeVariance(float f) {
        this.terrainAltitudeVariance = f;
    }

    public float getVelocityVariance() {
        return this.velocityVariance;
    }

    public void setVelocityVariance(float f) {
        this.velocityVariance = f;
    }

    public float getVerticalPositionVariance() {
        return this.verticalPositionVariance;
    }

    public void setVerticalPositionVariance(float f) {
        this.verticalPositionVariance = f;
    }

    public float getHorizontalPositionVariance() {
        return this.horizontalPositionVariance;
    }

    public void setHorizontalPositionVariance(float f) {
        this.horizontalPositionVariance = f;
    }

    public float getCompassVariance() {
        return this.compassVariance;
    }

    public void setCompassVariance(float f) {
        this.compassVariance = f;
    }

    public boolean isEkfFlagSet(EkfFlags ekfFlags) {
        return this.flags.get(ekfFlags.ordinal());
    }

    public boolean isPositionOk(boolean z) {
        if (z) {
            if (!this.flags.get(EkfFlags.EKF_POS_HORIZ_ABS.ordinal()) || this.flags.get(EkfFlags.EKF_CONST_POS_MODE.ordinal())) {
                return false;
            }
            return true;
        } else if (this.flags.get(EkfFlags.EKF_POS_HORIZ_ABS.ordinal()) || this.flags.get(EkfFlags.EKF_PRED_POS_HORIZ_ABS.ordinal())) {
            return true;
        } else {
            return false;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.velocityVariance);
        parcel.writeFloat(this.horizontalPositionVariance);
        parcel.writeFloat(this.verticalPositionVariance);
        parcel.writeFloat(this.compassVariance);
        parcel.writeFloat(this.terrainAltitudeVariance);
        parcel.writeSerializable(this.flags);
    }

    private EkfStatus(Parcel parcel) {
        this.velocityVariance = parcel.readFloat();
        this.horizontalPositionVariance = parcel.readFloat();
        this.verticalPositionVariance = parcel.readFloat();
        this.compassVariance = parcel.readFloat();
        this.terrainAltitudeVariance = parcel.readFloat();
        this.flags = (BitSet) parcel.readSerializable();
    }
}
