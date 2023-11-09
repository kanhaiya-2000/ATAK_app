package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class DoJump extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<DoJump> CREATOR = new Parcelable.Creator<DoJump>() {
        public DoJump createFromParcel(Parcel parcel) {
            return new DoJump(parcel);
        }

        public DoJump[] newArray(int i) {
            return new DoJump[i];
        }
    };
    private int repeatCount;
    private int waypoint;

    public int describeContents() {
        return 0;
    }

    public DoJump() {
        super(MissionItemType.DO_JUMP);
    }

    public DoJump(DoJump doJump) {
        this();
        this.waypoint = doJump.waypoint;
        this.repeatCount = doJump.repeatCount;
    }

    protected DoJump(Parcel parcel) {
        super(parcel);
        this.waypoint = parcel.readInt();
        this.repeatCount = parcel.readInt();
    }

    public String toString() {
        return "DoJump{repeatCount=" + this.repeatCount + ", waypoint=" + this.waypoint + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoJump) || !super.equals(obj)) {
            return false;
        }
        DoJump doJump = (DoJump) obj;
        if (this.waypoint == doJump.waypoint && this.repeatCount == doJump.repeatCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.waypoint) * 31) + this.repeatCount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.waypoint);
        parcel.writeInt(this.repeatCount);
    }

    public int getWaypoint() {
        return this.waypoint;
    }

    public void setWaypoint(int i) {
        this.waypoint = i;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(int i) {
        this.repeatCount = i;
    }

    public MissionItem clone() {
        return new DoJump(this);
    }
}
