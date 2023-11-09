package com.o3dr.services.android.lib.drone.mission.item.spatial;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public abstract class BaseSpatialItem extends MissionItem implements Parcelable, MissionItem.SpatialItem {
    private LatLongAlt coordinate;

    protected BaseSpatialItem(MissionItemType missionItemType) {
        this(missionItemType, (LatLongAlt) null);
    }

    protected BaseSpatialItem(MissionItemType missionItemType, LatLongAlt latLongAlt) {
        super(missionItemType);
        this.coordinate = latLongAlt;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected BaseSpatialItem(BaseSpatialItem baseSpatialItem) {
        this(baseSpatialItem.getType(), baseSpatialItem.coordinate == null ? null : new LatLongAlt(baseSpatialItem.coordinate));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseSpatialItem) || !super.equals(obj)) {
            return false;
        }
        LatLongAlt latLongAlt = this.coordinate;
        LatLongAlt latLongAlt2 = ((BaseSpatialItem) obj).coordinate;
        if (latLongAlt != null) {
            if (!latLongAlt.equals(latLongAlt2)) {
                return false;
            }
            return true;
        } else if (latLongAlt2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        LatLongAlt latLongAlt = this.coordinate;
        return hashCode + (latLongAlt != null ? latLongAlt.hashCode() : 0);
    }

    public String toString() {
        return "BaseSpatialItem{coordinate=" + this.coordinate + '}';
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(LatLongAlt latLongAlt) {
        this.coordinate = latLongAlt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coordinate, i);
    }

    protected BaseSpatialItem(Parcel parcel) {
        super(parcel);
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
