package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class CameraTrigger extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<CameraTrigger> CREATOR = new Parcelable.Creator<CameraTrigger>() {
        public CameraTrigger createFromParcel(Parcel parcel) {
            return new CameraTrigger(parcel);
        }

        public CameraTrigger[] newArray(int i) {
            return new CameraTrigger[i];
        }
    };
    private double triggerDistance;

    public CameraTrigger() {
        super(MissionItemType.CAMERA_TRIGGER);
    }

    public CameraTrigger(CameraTrigger cameraTrigger) {
        super(MissionItemType.CAMERA_TRIGGER);
        this.triggerDistance = cameraTrigger.triggerDistance;
    }

    public double getTriggerDistance() {
        return this.triggerDistance;
    }

    public void setTriggerDistance(double d) {
        this.triggerDistance = d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CameraTrigger) && super.equals(obj) && Double.compare(((CameraTrigger) obj).triggerDistance, this.triggerDistance) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.triggerDistance);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        return "CameraTrigger{triggerDistance=" + this.triggerDistance + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.triggerDistance);
    }

    private CameraTrigger(Parcel parcel) {
        super(parcel);
        this.triggerDistance = parcel.readDouble();
    }

    public MissionItem clone() {
        return new CameraTrigger(this);
    }
}
