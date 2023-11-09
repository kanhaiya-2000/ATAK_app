package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class RegionOfInterest extends BaseSpatialItem implements Parcelable {
    public static final Parcelable.Creator<RegionOfInterest> CREATOR = new Parcelable.Creator<RegionOfInterest>() {
        public RegionOfInterest createFromParcel(Parcel parcel) {
            return new RegionOfInterest(parcel);
        }

        public RegionOfInterest[] newArray(int i) {
            return new RegionOfInterest[i];
        }
    };

    public RegionOfInterest() {
        super(MissionItemType.REGION_OF_INTEREST);
    }

    public RegionOfInterest(RegionOfInterest regionOfInterest) {
        super((BaseSpatialItem) regionOfInterest);
    }

    private RegionOfInterest(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return "RegionOfInterest{ " + super.toString() + " }";
    }

    public MissionItem clone() {
        return new RegionOfInterest(this);
    }
}
