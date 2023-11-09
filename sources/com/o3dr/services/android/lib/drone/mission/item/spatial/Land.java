package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class Land extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<Land> CREATOR = new Parcelable.Creator<Land>() {
        public Land createFromParcel(Parcel parcel) {
            return new Land(parcel);
        }

        public Land[] newArray(int i) {
            return new Land[i];
        }
    };

    public Land() {
        super(MissionItemType.LAND, new LatLongAlt(0.0d, 0.0d, 0.0d));
    }

    public Land(Land land) {
        super((BaseSpatialItem) land);
    }

    private Land(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return "Land{ " + super.toString() + " }";
    }

    public MissionItem clone() {
        return new Land(this);
    }
}
