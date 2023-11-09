package com.o3dr.services.android.lib.drone.mission.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;

public abstract class MissionItem implements Parcelable, Cloneable {
    private final MissionItemType type;

    public interface Command {
    }

    public interface ComplexItem<T extends MissionItem> {
        void copy(T t);
    }

    public interface SpatialItem {
        LatLongAlt getCoordinate();

        void setCoordinate(LatLongAlt latLongAlt);
    }

    public abstract MissionItem clone();

    public int describeContents() {
        return 0;
    }

    protected MissionItem(MissionItemType missionItemType) {
        this.type = missionItemType;
    }

    public MissionItemType getType() {
        return this.type;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type.ordinal());
    }

    protected MissionItem(Parcel parcel) {
        this.type = MissionItemType.values()[parcel.readInt()];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof MissionItem) && this.type == ((MissionItem) obj).type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        MissionItemType missionItemType = this.type;
        if (missionItemType != null) {
            return missionItemType.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "MissionItem{type=" + this.type + '}';
    }
}
