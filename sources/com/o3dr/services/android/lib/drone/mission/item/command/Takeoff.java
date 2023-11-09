package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class Takeoff extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<Takeoff> CREATOR = new Parcelable.Creator<Takeoff>() {
        public Takeoff createFromParcel(Parcel parcel) {
            return new Takeoff(parcel);
        }

        public Takeoff[] newArray(int i) {
            return new Takeoff[i];
        }
    };
    private double takeoffAltitude;
    private double takeoffPitch;

    public Takeoff() {
        super(MissionItemType.TAKEOFF);
    }

    public Takeoff(Takeoff takeoff) {
        this();
        this.takeoffAltitude = takeoff.takeoffAltitude;
        this.takeoffPitch = takeoff.takeoffPitch;
    }

    public double getTakeoffAltitude() {
        return this.takeoffAltitude;
    }

    public void setTakeoffAltitude(double d) {
        this.takeoffAltitude = d;
    }

    public double getTakeoffPitch() {
        return this.takeoffPitch;
    }

    public void setTakeoffPitch(double d) {
        this.takeoffPitch = d;
    }

    public String toString() {
        return "Takeoff{takeoffAltitude=" + this.takeoffAltitude + ", takeoffPitch=" + this.takeoffPitch + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Takeoff) || !super.equals(obj)) {
            return false;
        }
        Takeoff takeoff = (Takeoff) obj;
        if (Double.compare(takeoff.takeoffAltitude, this.takeoffAltitude) == 0 && Double.compare(takeoff.takeoffPitch, this.takeoffPitch) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.takeoffAltitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.takeoffPitch);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.takeoffAltitude);
        parcel.writeDouble(this.takeoffPitch);
    }

    private Takeoff(Parcel parcel) {
        super(parcel);
        this.takeoffAltitude = parcel.readDouble();
        this.takeoffPitch = parcel.readDouble();
    }

    public MissionItem clone() {
        return new Takeoff(this);
    }
}
