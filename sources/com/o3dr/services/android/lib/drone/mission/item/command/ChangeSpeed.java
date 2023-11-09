package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class ChangeSpeed extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<ChangeSpeed> CREATOR = new Parcelable.Creator<ChangeSpeed>() {
        public ChangeSpeed createFromParcel(Parcel parcel) {
            return new ChangeSpeed(parcel);
        }

        public ChangeSpeed[] newArray(int i) {
            return new ChangeSpeed[i];
        }
    };
    private double speed;

    public ChangeSpeed() {
        super(MissionItemType.CHANGE_SPEED);
    }

    public ChangeSpeed(ChangeSpeed changeSpeed) {
        super(MissionItemType.CHANGE_SPEED);
        this.speed = changeSpeed.speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public String toString() {
        return "ChangeSpeed{speed=" + this.speed + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ChangeSpeed) && super.equals(obj) && Double.compare(((ChangeSpeed) obj).speed, this.speed) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.speed);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.speed);
    }

    private ChangeSpeed(Parcel parcel) {
        super(parcel);
        this.speed = parcel.readDouble();
    }

    public MissionItem clone() {
        return new ChangeSpeed(this);
    }
}
