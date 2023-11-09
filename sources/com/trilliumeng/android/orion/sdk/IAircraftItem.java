package com.trilliumeng.android.orion.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class IAircraftItem implements Parcelable {
    public static final Parcelable.Creator<IAircraftItem> CREATOR = new Parcelable.Creator<IAircraftItem>() {
        public IAircraftItem createFromParcel(Parcel parcel) {
            return new IAircraftItem(parcel);
        }

        public IAircraftItem[] newArray(int i) {
            return new IAircraftItem[i];
        }
    };
    public static final String TAG = "IAircraftItem";
    public String UID;
    public double acalt;
    public double acce;
    public double achal;
    public double acheading;
    public double aclat;
    public double acle;
    public double aclon;
    public boolean areMotorsOn;
    public double attitudePitch;
    public double attitudeRoll;
    public double attitudeYaw;
    public int battMax;
    public int battRem;
    public double battVolt;
    public String callsign;
    public double climbRate;
    public int flightTime;
    public int flightTimeRemaining;
    public boolean getThermal;
    public int goHomeBatteryPercent;
    public boolean hasGPS;
    public double homealt;
    public double homelat;
    public double homelon;
    public boolean isFlying;
    public String platformId;
    public ArrayList<Object> routePoints;
    public double sensorAzimuth;
    public double sensorElevation;
    public double sensorHFOV;
    public String sensorModel;
    public double sensorNorth;
    public double sensorRange;
    public double sensorRoll;
    public double sensorVFOV;
    public int signalQuality;
    public double slope;
    public double speed;
    public double spinPitch;
    public double spinRoll;
    public double spinYaw;
    public double[] spoiBounds;
    public double spoialt;
    public double spoilat;
    public double spoilon;

    public int describeContents() {
        return 0;
    }

    public IAircraftItem() {
        this.routePoints = new ArrayList<>();
        this.aclat = Double.NaN;
        this.aclon = Double.NaN;
        this.acalt = Double.NaN;
        this.achal = Double.NaN;
        this.acce = Double.NaN;
        this.acle = Double.NaN;
        this.acheading = Double.NaN;
        this.spoilat = Double.NaN;
        this.spoilon = Double.NaN;
        this.spoialt = Double.NaN;
        initSpoiViewBounds();
        this.homelat = Double.NaN;
        this.homelon = Double.NaN;
        this.homealt = Double.NaN;
        this.speed = Double.NaN;
        this.slope = Double.NaN;
        this.sensorAzimuth = Double.NaN;
        this.sensorElevation = Double.NaN;
        this.sensorRange = Double.NaN;
        this.sensorRoll = Double.NaN;
        this.sensorHFOV = Double.NaN;
        this.sensorVFOV = Double.NaN;
        this.sensorNorth = Double.NaN;
        this.battVolt = Double.NaN;
        this.climbRate = Double.NaN;
        this.attitudePitch = Double.NaN;
        this.attitudeRoll = Double.NaN;
        this.attitudeYaw = Double.NaN;
        this.spinPitch = Double.NaN;
        this.spinRoll = Double.NaN;
        this.spinYaw = Double.NaN;
        this.battMax = Integer.MIN_VALUE;
        this.battRem = Integer.MIN_VALUE;
        this.signalQuality = Integer.MIN_VALUE;
        this.flightTime = Integer.MIN_VALUE;
        this.goHomeBatteryPercent = Integer.MIN_VALUE;
        this.flightTimeRemaining = Integer.MIN_VALUE;
        this.hasGPS = false;
        this.areMotorsOn = false;
        this.isFlying = false;
        this.getThermal = false;
        this.UID = null;
        this.callsign = null;
        this.sensorModel = null;
        this.platformId = "generic";
    }

    public void initSpoiViewBounds() {
        double[] dArr = this.spoiBounds;
        if (dArr == null || dArr.length < 8) {
            Log.d(TAG, "Creating new SpoiViewBounds");
            this.spoiBounds = new double[8];
        }
        int i = 0;
        while (true) {
            double[] dArr2 = this.spoiBounds;
            if (i < dArr2.length) {
                dArr2[i] = Double.NaN;
                i++;
            } else {
                return;
            }
        }
    }

    public IAircraftItem(Parcel parcel) {
        this();
        this.aclat = parcel.readDouble();
        this.aclon = parcel.readDouble();
        this.acalt = parcel.readDouble();
        this.achal = parcel.readDouble();
        this.acce = parcel.readDouble();
        this.acle = parcel.readDouble();
        this.acheading = parcel.readDouble();
        this.spoilat = parcel.readDouble();
        this.spoilon = parcel.readDouble();
        this.spoialt = parcel.readDouble();
        parcel.readDoubleArray(this.spoiBounds);
        this.homelat = parcel.readDouble();
        this.homelon = parcel.readDouble();
        this.homealt = parcel.readDouble();
        this.speed = parcel.readDouble();
        this.slope = parcel.readDouble();
        this.sensorAzimuth = parcel.readDouble();
        this.sensorElevation = parcel.readDouble();
        this.sensorRange = parcel.readDouble();
        this.sensorRoll = parcel.readDouble();
        this.sensorHFOV = parcel.readDouble();
        this.sensorVFOV = parcel.readDouble();
        this.sensorNorth = parcel.readDouble();
        this.battVolt = parcel.readDouble();
        this.climbRate = parcel.readDouble();
        this.attitudePitch = parcel.readDouble();
        this.attitudeRoll = parcel.readDouble();
        this.attitudeYaw = parcel.readDouble();
        this.spinPitch = parcel.readDouble();
        this.spinRoll = parcel.readDouble();
        this.spinYaw = parcel.readDouble();
        this.battMax = parcel.readInt();
        this.battRem = parcel.readInt();
        this.signalQuality = parcel.readInt();
        this.flightTime = parcel.readInt();
        this.goHomeBatteryPercent = parcel.readInt();
        this.flightTimeRemaining = parcel.readInt();
        boolean z = false;
        this.hasGPS = parcel.readInt() == 1;
        this.areMotorsOn = parcel.readInt() == 1;
        this.isFlying = parcel.readInt() == 1;
        this.getThermal = parcel.readInt() == 1 ? true : z;
        this.UID = parcel.readString();
        this.callsign = parcel.readString();
        this.sensorModel = parcel.readString();
        this.platformId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.aclat);
        parcel.writeDouble(this.aclon);
        parcel.writeDouble(this.acalt);
        parcel.writeDouble(this.achal);
        parcel.writeDouble(this.acce);
        parcel.writeDouble(this.acle);
        parcel.writeDouble(this.acheading);
        parcel.writeDouble(this.spoilat);
        parcel.writeDouble(this.spoilon);
        parcel.writeDouble(this.spoialt);
        parcel.writeDoubleArray(this.spoiBounds);
        parcel.writeDouble(this.homelat);
        parcel.writeDouble(this.homelon);
        parcel.writeDouble(this.homealt);
        parcel.writeDouble(this.speed);
        parcel.writeDouble(this.slope);
        parcel.writeDouble(this.sensorAzimuth);
        parcel.writeDouble(this.sensorElevation);
        parcel.writeDouble(this.sensorRange);
        parcel.writeDouble(this.sensorRoll);
        parcel.writeDouble(this.sensorHFOV);
        parcel.writeDouble(this.sensorVFOV);
        parcel.writeDouble(this.sensorNorth);
        parcel.writeDouble(this.battVolt);
        parcel.writeDouble(this.climbRate);
        parcel.writeDouble(this.attitudePitch);
        parcel.writeDouble(this.attitudeRoll);
        parcel.writeDouble(this.attitudeYaw);
        parcel.writeDouble(this.spinPitch);
        parcel.writeDouble(this.spinRoll);
        parcel.writeDouble(this.spinYaw);
        parcel.writeInt(this.battMax);
        parcel.writeInt(this.battRem);
        parcel.writeInt(this.signalQuality);
        parcel.writeInt(this.flightTime);
        parcel.writeInt(this.goHomeBatteryPercent);
        parcel.writeInt(this.flightTimeRemaining);
        parcel.writeInt(this.hasGPS ? 1 : 0);
        parcel.writeInt(this.areMotorsOn ? 1 : 0);
        parcel.writeInt(this.isFlying ? 1 : 0);
        parcel.writeInt(this.getThermal ? 1 : 0);
        parcel.writeString(this.UID);
        parcel.writeString(this.callsign);
        parcel.writeString(this.sensorModel);
        parcel.writeString(this.platformId);
        parcel.writeTypedList((List) null);
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("aclat: " + this.aclat + str);
        sb.append(" aclon: " + this.aclon + str);
        sb.append(" acalt: " + this.acalt + str);
        sb.append(" achal: " + this.achal + str);
        sb.append(" acce: " + this.acce + str);
        sb.append(" acle: " + this.acle + str);
        sb.append(" acheading: " + this.acheading + str);
        sb.append(" spoilat: " + this.spoilat + str);
        sb.append(" spoilon: " + this.spoilon + str);
        sb.append(" spoialt: " + this.spoialt + str);
        sb.append(" SpoiBounds : (");
        for (int i = 0; i < this.spoiBounds.length; i++) {
            sb.append(this.spoiBounds[i] + ",");
        }
        sb.append(")" + str);
        sb.append(" homelat: " + this.homelat + str);
        sb.append(" homelon: " + this.homelon + str);
        sb.append(" homealt: " + this.homealt + str);
        sb.append(" speed: " + this.speed + str);
        sb.append(" slope: " + this.slope + str);
        sb.append(" sensorAzimuth: " + this.sensorAzimuth + str);
        sb.append(" sensorElevation: " + this.sensorElevation + str);
        sb.append(" sensorRange: " + this.sensorRange + str);
        sb.append(" sensorRoll: " + this.sensorRoll + str);
        sb.append(" sensorHFOV: " + this.sensorHFOV + str);
        sb.append(" sensorVFOV: " + this.sensorVFOV + str);
        sb.append(" sensorNorth: " + this.sensorNorth + str);
        sb.append(" battVolt: " + this.battVolt + str);
        sb.append(" climbRate: " + this.climbRate + str);
        sb.append(" attitudePitch: " + this.attitudePitch + str);
        sb.append(" attitudeRoll: " + this.attitudeRoll + str);
        sb.append(" attitudeYaw: " + this.attitudeYaw + str);
        sb.append(" spinPitch: " + this.spinPitch + str);
        sb.append(" spinRoll: " + this.spinRoll + str);
        sb.append(" spinYaw: " + this.spinYaw + str);
        sb.append(" battMax: " + this.battMax + str);
        sb.append(" battRem: " + this.battRem + str);
        sb.append(" signalQuality: " + this.signalQuality + str);
        sb.append(" flightTime: " + this.flightTime + str);
        sb.append(" goHomeBatteryPercent: " + this.goHomeBatteryPercent + str);
        sb.append(" flightTimeRemaining: " + this.flightTimeRemaining + str);
        sb.append(" hasGPS: " + this.hasGPS + str);
        sb.append(" areMotorsOn: " + this.areMotorsOn + str);
        sb.append(" isFlying: " + this.isFlying + str);
        sb.append(" getThermal: " + this.getThermal + str);
        sb.append(" UID: " + this.UID + str);
        sb.append(" callsign: " + this.callsign + str);
        sb.append(" sensorModel: " + this.sensorModel + str);
        sb.append(" platformId: " + this.platformId + str);
        return sb.toString();
    }

    public IAircraftItem copy() {
        IAircraftItem iAircraftItem = new IAircraftItem();
        iAircraftItem.aclat = this.aclat;
        iAircraftItem.aclon = this.aclon;
        iAircraftItem.acalt = this.acalt;
        iAircraftItem.achal = this.achal;
        iAircraftItem.acce = this.acce;
        iAircraftItem.acle = this.acle;
        iAircraftItem.acheading = this.acheading;
        iAircraftItem.spoilat = this.spoilat;
        iAircraftItem.spoilon = this.spoilon;
        iAircraftItem.spoialt = this.spoialt;
        iAircraftItem.spoiBounds = (double[]) this.spoiBounds.clone();
        iAircraftItem.homelat = this.homelat;
        iAircraftItem.homelon = this.homelon;
        iAircraftItem.homealt = this.homealt;
        iAircraftItem.speed = this.speed;
        iAircraftItem.slope = this.slope;
        iAircraftItem.sensorAzimuth = this.sensorAzimuth;
        iAircraftItem.sensorElevation = this.sensorElevation;
        iAircraftItem.sensorRange = this.sensorRange;
        iAircraftItem.sensorRoll = this.sensorRoll;
        iAircraftItem.sensorHFOV = this.sensorHFOV;
        iAircraftItem.sensorVFOV = this.sensorVFOV;
        iAircraftItem.sensorNorth = this.sensorNorth;
        iAircraftItem.battVolt = this.battVolt;
        iAircraftItem.climbRate = this.climbRate;
        iAircraftItem.attitudePitch = this.attitudePitch;
        iAircraftItem.attitudeRoll = this.attitudeRoll;
        iAircraftItem.attitudeYaw = this.attitudeYaw;
        iAircraftItem.spinPitch = this.spinPitch;
        iAircraftItem.spinRoll = this.spinRoll;
        iAircraftItem.spinYaw = this.spinYaw;
        iAircraftItem.battMax = this.battMax;
        iAircraftItem.battRem = this.battRem;
        iAircraftItem.signalQuality = this.signalQuality;
        iAircraftItem.flightTime = this.signalQuality;
        iAircraftItem.goHomeBatteryPercent = this.goHomeBatteryPercent;
        iAircraftItem.flightTimeRemaining = this.flightTimeRemaining;
        iAircraftItem.hasGPS = this.hasGPS;
        iAircraftItem.areMotorsOn = this.areMotorsOn;
        iAircraftItem.isFlying = this.isFlying;
        iAircraftItem.getThermal = this.getThermal;
        iAircraftItem.UID = this.UID;
        iAircraftItem.callsign = this.callsign;
        iAircraftItem.sensorModel = this.sensorModel;
        iAircraftItem.platformId = this.platformId;
        iAircraftItem.routePoints = null;
        return iAircraftItem;
    }
}
