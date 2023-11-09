package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class DoLandStart extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<DoLandStart> CREATOR = new Parcelable.Creator<DoLandStart>() {
        public DoLandStart createFromParcel(Parcel parcel) {
            return new DoLandStart(parcel);
        }

        public DoLandStart[] newArray(int i) {
            return new DoLandStart[i];
        }
    };

    public DoLandStart() {
        super(MissionItemType.DO_LAND_START);
    }

    public DoLandStart(DoLandStart doLandStart) {
        super((BaseSpatialItem) doLandStart);
    }

    private DoLandStart(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return "DoLandStart{ " + super.toString() + " }";
    }

    public MissionItem clone() {
        return new DoLandStart(this);
    }
}
