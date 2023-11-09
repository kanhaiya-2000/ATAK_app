package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

public class Type implements DroneAttribute {
    public static final Parcelable.Creator<Type> CREATOR = new Parcelable.Creator<Type>() {
        public Type createFromParcel(Parcel parcel) {
            return new Type(parcel);
        }

        public Type[] newArray(int i) {
            return new Type[i];
        }
    };
    public static final int TYPE_COPTER = 2;
    public static final int TYPE_PLANE = 1;
    public static final int TYPE_ROVER = 10;
    public static final int TYPE_UNKNOWN = -1;
    private int droneType;
    private Firmware firmware;
    private String firmwareVersion;

    public int describeContents() {
        return 0;
    }

    public enum Firmware {
        ARDU_PLANE("ArduPlane"),
        ARDU_COPTER("ArduCopter"),
        APM_ROVER("APMRover");
        
        private final String label;

        private Firmware(String str) {
            this.label = str;
        }

        public String getLabel() {
            return this.label;
        }
    }

    public Type() {
        this.droneType = -1;
    }

    public Type(int i, String str) {
        this.droneType = -1;
        this.droneType = i;
        this.firmwareVersion = str;
        this.firmware = getTypeFirmware(i);
    }

    private static Firmware getTypeFirmware(int i) {
        if (i == 1) {
            return Firmware.ARDU_PLANE;
        }
        if (i == 2) {
            return Firmware.ARDU_COPTER;
        }
        if (i != 10) {
            return null;
        }
        return Firmware.APM_ROVER;
    }

    public int getDroneType() {
        return this.droneType;
    }

    public Firmware getFirmware() {
        return this.firmware;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setDroneType(int i) {
        this.droneType = i;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public void setFirmware(Firmware firmware2) {
        this.firmware = firmware2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.droneType);
        parcel.writeString(this.firmwareVersion);
        parcel.writeInt(-1);
    }

    private Type(Parcel parcel) {
        this(parcel.readInt(), parcel.readString());
        parcel.readInt();
    }
}
