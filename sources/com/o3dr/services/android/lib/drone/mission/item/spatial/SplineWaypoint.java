package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class SplineWaypoint extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<SplineWaypoint> CREATOR = new Parcelable.Creator<SplineWaypoint>() {
        public SplineWaypoint createFromParcel(Parcel parcel) {
            return new SplineWaypoint(parcel);
        }

        public SplineWaypoint[] newArray(int i) {
            return new SplineWaypoint[i];
        }
    };
    private double delay;

    public SplineWaypoint() {
        super(MissionItemType.SPLINE_WAYPOINT);
    }

    public SplineWaypoint(SplineWaypoint splineWaypoint) {
        super((BaseSpatialItem) splineWaypoint);
        this.delay = splineWaypoint.delay;
    }

    public double getDelay() {
        return this.delay;
    }

    public void setDelay(double d) {
        this.delay = d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.delay);
    }

    private SplineWaypoint(Parcel parcel) {
        super(parcel);
        this.delay = parcel.readDouble();
    }

    public String toString() {
        return "SplineWaypoint{delay=" + this.delay + ", " + super.toString() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SplineWaypoint) && super.equals(obj) && Double.compare(((SplineWaypoint) obj).delay, this.delay) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.delay);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public MissionItem clone() {
        return new SplineWaypoint(this);
    }
}
