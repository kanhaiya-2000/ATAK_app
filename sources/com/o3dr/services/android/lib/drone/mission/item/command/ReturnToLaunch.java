package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class ReturnToLaunch extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<ReturnToLaunch> CREATOR = new Parcelable.Creator<ReturnToLaunch>() {
        public ReturnToLaunch createFromParcel(Parcel parcel) {
            return new ReturnToLaunch(parcel);
        }

        public ReturnToLaunch[] newArray(int i) {
            return new ReturnToLaunch[i];
        }
    };
    private double returnAltitude;

    public ReturnToLaunch() {
        super(MissionItemType.RETURN_TO_LAUNCH);
    }

    public ReturnToLaunch(ReturnToLaunch returnToLaunch) {
        this();
        this.returnAltitude = returnToLaunch.returnAltitude;
    }

    public double getReturnAltitude() {
        return this.returnAltitude;
    }

    public void setReturnAltitude(double d) {
        this.returnAltitude = d;
    }

    public String toString() {
        return "ReturnToLaunch{returnAltitude=" + this.returnAltitude + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ReturnToLaunch) && super.equals(obj) && Double.compare(((ReturnToLaunch) obj).returnAltitude, this.returnAltitude) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.returnAltitude);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.returnAltitude);
    }

    private ReturnToLaunch(Parcel parcel) {
        super(parcel);
        this.returnAltitude = parcel.readDouble();
    }

    public MissionItem clone() {
        return new ReturnToLaunch(this);
    }
}
