package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class EpmGripper extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<EpmGripper> CREATOR = new Parcelable.Creator<EpmGripper>() {
        public EpmGripper createFromParcel(Parcel parcel) {
            return new EpmGripper(parcel);
        }

        public EpmGripper[] newArray(int i) {
            return new EpmGripper[i];
        }
    };
    private boolean release;

    public EpmGripper() {
        super(MissionItemType.EPM_GRIPPER);
    }

    public EpmGripper(EpmGripper epmGripper) {
        this();
        this.release = epmGripper.release;
    }

    public boolean isRelease() {
        return this.release;
    }

    public void setRelease(boolean z) {
        this.release = z;
    }

    public String toString() {
        return "EpmGripper{release=" + this.release + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof EpmGripper) && super.equals(obj) && this.release == ((EpmGripper) obj).release) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.release ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.release ? (byte) 1 : 0);
    }

    private EpmGripper(Parcel parcel) {
        super(parcel);
        this.release = parcel.readByte() != 0;
    }

    public MissionItem clone() {
        return new EpmGripper(this);
    }
}
