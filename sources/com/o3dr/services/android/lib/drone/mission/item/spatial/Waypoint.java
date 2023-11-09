package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class Waypoint extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<Waypoint> CREATOR = new Parcelable.Creator<Waypoint>() {
        public Waypoint createFromParcel(Parcel parcel) {
            return new Waypoint(parcel);
        }

        public Waypoint[] newArray(int i) {
            return new Waypoint[i];
        }
    };
    private double acceptanceRadius;
    private double delay;
    private boolean orbitCCW;
    private double orbitalRadius;
    private double yawAngle;

    public Waypoint() {
        super(MissionItemType.WAYPOINT);
    }

    public Waypoint(Waypoint waypoint) {
        super((BaseSpatialItem) waypoint);
        this.delay = waypoint.delay;
        this.acceptanceRadius = waypoint.acceptanceRadius;
        this.yawAngle = waypoint.yawAngle;
        this.orbitalRadius = waypoint.orbitalRadius;
        this.orbitCCW = waypoint.orbitCCW;
    }

    public double getDelay() {
        return this.delay;
    }

    public void setDelay(double d) {
        this.delay = d;
    }

    public double getAcceptanceRadius() {
        return this.acceptanceRadius;
    }

    public void setAcceptanceRadius(double d) {
        this.acceptanceRadius = d;
    }

    public double getYawAngle() {
        return this.yawAngle;
    }

    public void setYawAngle(double d) {
        this.yawAngle = d;
    }

    public double getOrbitalRadius() {
        return this.orbitalRadius;
    }

    public void setOrbitalRadius(double d) {
        this.orbitalRadius = d;
    }

    public boolean isOrbitCCW() {
        return this.orbitCCW;
    }

    public void setOrbitCCW(boolean z) {
        this.orbitCCW = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.delay);
        parcel.writeDouble(this.acceptanceRadius);
        parcel.writeDouble(this.yawAngle);
        parcel.writeDouble(this.orbitalRadius);
        parcel.writeByte(this.orbitCCW ? (byte) 1 : 0);
    }

    private Waypoint(Parcel parcel) {
        super(parcel);
        this.delay = parcel.readDouble();
        this.acceptanceRadius = parcel.readDouble();
        this.yawAngle = parcel.readDouble();
        this.orbitalRadius = parcel.readDouble();
        this.orbitCCW = parcel.readByte() != 0;
    }

    public String toString() {
        return "Waypoint{acceptanceRadius=" + this.acceptanceRadius + ", delay=" + this.delay + ", yawAngle=" + this.yawAngle + ", orbitalRadius=" + this.orbitalRadius + ", orbitCCW=" + this.orbitCCW + ", " + super.toString() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Waypoint) || !super.equals(obj)) {
            return false;
        }
        Waypoint waypoint = (Waypoint) obj;
        if (Double.compare(waypoint.delay, this.delay) == 0 && Double.compare(waypoint.acceptanceRadius, this.acceptanceRadius) == 0 && Double.compare(waypoint.yawAngle, this.yawAngle) == 0 && Double.compare(waypoint.orbitalRadius, this.orbitalRadius) == 0 && this.orbitCCW == waypoint.orbitCCW) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.delay);
        long doubleToLongBits2 = Double.doubleToLongBits(this.acceptanceRadius);
        long doubleToLongBits3 = Double.doubleToLongBits(this.yawAngle);
        long doubleToLongBits4 = Double.doubleToLongBits(this.orbitalRadius);
        return (((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + (this.orbitCCW ? 1 : 0);
    }

    public MissionItem clone() {
        return new Waypoint(this);
    }
}
