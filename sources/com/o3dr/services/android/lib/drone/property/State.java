package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class State implements DroneAttribute {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() {
        public State createFromParcel(Parcel parcel) {
            return new State(parcel);
        }

        public State[] newArray(int i) {
            return new State[i];
        }
    };
    public static final int INVALID_MAVLINK_VERSION = -1;
    private static final String TAG = "State";
    private boolean armed;
    private String autopilotErrorId;
    private String calibrationStatus;
    private EkfStatus ekfStatus;
    private long flightStartTime;
    private boolean isConnected;
    private boolean isFlying;
    private boolean isTelemetryLive;
    private int mavlinkVersion;
    private VehicleMode vehicleMode;
    private final JSONObject vehicleUid;
    private Vibration vehicleVibration;

    public int describeContents() {
        return 0;
    }

    public State() {
        this.mavlinkVersion = -1;
        this.vehicleMode = VehicleMode.UNKNOWN;
        this.ekfStatus = new EkfStatus();
        this.vehicleVibration = new Vibration();
        this.vehicleUid = new JSONObject();
    }

    public State(boolean z, VehicleMode vehicleMode2, boolean z2, boolean z3, String str, int i, String str2, long j, EkfStatus ekfStatus2, boolean z4, Vibration vibration) {
        this.mavlinkVersion = -1;
        this.vehicleMode = VehicleMode.UNKNOWN;
        this.ekfStatus = new EkfStatus();
        this.vehicleVibration = new Vibration();
        this.vehicleUid = new JSONObject();
        this.isConnected = z;
        this.armed = z2;
        this.isFlying = z3;
        this.flightStartTime = j;
        this.autopilotErrorId = str;
        this.mavlinkVersion = i;
        this.calibrationStatus = str2;
        if (ekfStatus2 != null) {
            this.ekfStatus = ekfStatus2;
        }
        if (vehicleMode2 != null) {
            this.vehicleMode = vehicleMode2;
        }
        this.isTelemetryLive = z4;
        if (vibration != null) {
            this.vehicleVibration = vibration;
        }
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void setConnected(boolean z) {
        this.isConnected = z;
    }

    public void setArmed(boolean z) {
        this.armed = z;
    }

    public void setFlying(boolean z) {
        this.isFlying = z;
    }

    public void setCalibrationStatus(String str) {
        this.calibrationStatus = str;
    }

    public void setVehicleMode(VehicleMode vehicleMode2) {
        this.vehicleMode = vehicleMode2;
    }

    public void setMavlinkVersion(int i) {
        this.mavlinkVersion = i;
    }

    public boolean isArmed() {
        return this.armed;
    }

    public boolean isFlying() {
        return this.isFlying;
    }

    public VehicleMode getVehicleMode() {
        return this.vehicleMode;
    }

    public String getAutopilotErrorId() {
        return this.autopilotErrorId;
    }

    public void setAutopilotErrorId(String str) {
        this.autopilotErrorId = str;
    }

    public boolean isWarning() {
        return TextUtils.isEmpty(this.autopilotErrorId);
    }

    public boolean isCalibrating() {
        return this.calibrationStatus != null;
    }

    public void setCalibration(String str) {
        this.calibrationStatus = str;
    }

    public String getCalibrationStatus() {
        return this.calibrationStatus;
    }

    public int getMavlinkVersion() {
        return this.mavlinkVersion;
    }

    public long getFlightStartTime() {
        return this.flightStartTime;
    }

    public void setFlightStartTime(long j) {
        this.flightStartTime = j;
    }

    public boolean isTelemetryLive() {
        return this.isTelemetryLive;
    }

    public void setIsTelemetryLive(boolean z) {
        this.isTelemetryLive = z;
    }

    public EkfStatus getEkfStatus() {
        return this.ekfStatus;
    }

    public Vibration getVehicleVibration() {
        return this.vehicleVibration;
    }

    public JSONObject getVehicleUid() {
        return this.vehicleUid;
    }

    public void addToVehicleUid(String str, String str2) {
        try {
            this.vehicleUid.put(str, str2);
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isConnected ? (byte) 1 : 0);
        parcel.writeByte(this.armed ? (byte) 1 : 0);
        parcel.writeByte(this.isFlying ? (byte) 1 : 0);
        parcel.writeString(this.calibrationStatus);
        parcel.writeParcelable(this.vehicleMode, 0);
        parcel.writeString(this.autopilotErrorId);
        parcel.writeInt(this.mavlinkVersion);
        parcel.writeLong(this.flightStartTime);
        parcel.writeParcelable(this.ekfStatus, 0);
        parcel.writeByte(this.isTelemetryLive ? (byte) 1 : 0);
        parcel.writeParcelable(this.vehicleVibration, 0);
        parcel.writeString(this.vehicleUid.toString());
    }

    private State(Parcel parcel) {
        JSONObject jSONObject;
        this.mavlinkVersion = -1;
        this.vehicleMode = VehicleMode.UNKNOWN;
        this.ekfStatus = new EkfStatus();
        this.vehicleVibration = new Vibration();
        boolean z = true;
        this.isConnected = parcel.readByte() != 0;
        this.armed = parcel.readByte() != 0;
        this.isFlying = parcel.readByte() != 0;
        this.calibrationStatus = parcel.readString();
        this.vehicleMode = (VehicleMode) parcel.readParcelable(VehicleMode.class.getClassLoader());
        this.autopilotErrorId = parcel.readString();
        this.mavlinkVersion = parcel.readInt();
        this.flightStartTime = parcel.readLong();
        this.ekfStatus = (EkfStatus) parcel.readParcelable(EkfStatus.class.getClassLoader());
        this.isTelemetryLive = parcel.readByte() == 0 ? false : z;
        this.vehicleVibration = (Vibration) parcel.readParcelable(Vibration.class.getClassLoader());
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        this.vehicleUid = jSONObject;
    }
}
