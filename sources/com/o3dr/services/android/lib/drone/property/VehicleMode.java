package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public enum VehicleMode implements DroneAttribute {
    PLANE_MANUAL(0, 1, "Manual"),
    PLANE_CIRCLE(1, 1, "Circle"),
    PLANE_STABILIZE(2, 1, "Stabilize"),
    PLANE_TRAINING(3, 1, "Training"),
    PLANE_ACRO(4, 1, "Acro"),
    PLANE_FLY_BY_WIRE_A(5, 1, "FBW A"),
    PLANE_FLY_BY_WIRE_B(6, 1, "FBW B"),
    PLANE_CRUISE(7, 1, "Cruise"),
    PLANE_AUTOTUNE(8, 1, "Autotune"),
    PLANE_AUTO(10, 1, "Auto"),
    PLANE_RTL(11, 1, "RTL"),
    PLANE_LOITER(12, 1, "Loiter"),
    PLANE_GUIDED(15, 1, "Guided"),
    COPTER_STABILIZE(0, 2, "Stabilize"),
    COPTER_ACRO(1, 2, "Acro"),
    COPTER_ALT_HOLD(2, 2, "Alt Hold"),
    COPTER_AUTO(3, 2, "Auto"),
    COPTER_GUIDED(4, 2, "Guided"),
    COPTER_LOITER(5, 2, "Loiter"),
    COPTER_RTL(6, 2, "RTL"),
    COPTER_CIRCLE(7, 2, "Circle"),
    COPTER_LAND(9, 2, "Land"),
    COPTER_DRIFT(11, 2, "Drift"),
    COPTER_SPORT(13, 2, "Sport"),
    COPTER_FLIP(14, 2, "Flip"),
    COPTER_AUTOTUNE(15, 2, "Autotune"),
    COPTER_POSHOLD(16, 2, "PosHold"),
    COPTER_BRAKE(17, 2, "Brake"),
    ROVER_MANUAL(0, 10, "Manual"),
    ROVER_LEARNING(2, 10, "Learning"),
    ROVER_STEERING(3, 10, "Steering"),
    ROVER_HOLD(4, 10, "Hold"),
    ROVER_AUTO(10, 10, "Auto"),
    ROVER_RTL(11, 10, "RTL"),
    ROVER_GUIDED(15, 10, "Guided"),
    ROVER_INITIALIZING(16, 10, "Initializing"),
    UNKNOWN(-1, -1, "Unknown");
    
    public static final Parcelable.Creator<VehicleMode> CREATOR = null;
    private final int droneType;
    private final String label;
    private final int mode;

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Parcelable.Creator<VehicleMode>() {
            public VehicleMode createFromParcel(Parcel parcel) {
                return VehicleMode.valueOf(parcel.readString());
            }

            public VehicleMode[] newArray(int i) {
                return new VehicleMode[i];
            }
        };
    }

    private VehicleMode(int i, int i2, String str) {
        this.mode = i;
        this.droneType = i2;
        this.label = str;
    }

    public int getMode() {
        return this.mode;
    }

    public int getDroneType() {
        return this.droneType;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        return getLabel();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    public static List<VehicleMode> getVehicleModePerDroneType(int i) {
        VehicleMode[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (VehicleMode vehicleMode : values) {
            if (vehicleMode.getDroneType() == i) {
                arrayList.add(vehicleMode);
            }
        }
        return arrayList;
    }
}
