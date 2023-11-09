package com.o3dr.services.android.lib.drone.mission;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.util.ArrayList;
import java.util.List;

public class Mission implements DroneAttribute {
    public static final Parcelable.Creator<Mission> CREATOR = new Parcelable.Creator<Mission>() {
        public Mission createFromParcel(Parcel parcel) {
            return new Mission(parcel);
        }

        public Mission[] newArray(int i) {
            return new Mission[i];
        }
    };
    private int currentMissionItem;
    private final List<MissionItem> missionItemsList;

    public int describeContents() {
        return 0;
    }

    public Mission() {
        this.missionItemsList = new ArrayList();
    }

    public void addMissionItem(MissionItem missionItem) {
        this.missionItemsList.add(missionItem);
    }

    public void addMissionItem(int i, MissionItem missionItem) {
        this.missionItemsList.add(i, missionItem);
    }

    public void removeMissionItem(MissionItem missionItem) {
        this.missionItemsList.remove(missionItem);
    }

    public void removeMissionItem(int i) {
        this.missionItemsList.remove(i);
    }

    public void clear() {
        this.missionItemsList.clear();
    }

    public MissionItem getMissionItem(int i) {
        return this.missionItemsList.get(i);
    }

    public List<MissionItem> getMissionItems() {
        return this.missionItemsList;
    }

    public int getCurrentMissionItem() {
        return this.currentMissionItem;
    }

    public void setCurrentMissionItem(int i) {
        this.currentMissionItem = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mission)) {
            return false;
        }
        Mission mission = (Mission) obj;
        if (this.currentMissionItem != mission.currentMissionItem) {
            return false;
        }
        return this.missionItemsList.equals(mission.missionItemsList);
    }

    public int hashCode() {
        return (this.currentMissionItem * 31) + this.missionItemsList.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.currentMissionItem);
        ArrayList arrayList = new ArrayList(this.missionItemsList.size());
        if (!this.missionItemsList.isEmpty()) {
            for (MissionItem next : this.missionItemsList) {
                arrayList.add(next.getType().storeMissionItem(next));
            }
        }
        parcel.writeTypedList(arrayList);
    }

    private Mission(Parcel parcel) {
        this.missionItemsList = new ArrayList();
        this.currentMissionItem = parcel.readInt();
        ArrayList<Bundle> arrayList = new ArrayList<>();
        parcel.readTypedList(arrayList, Bundle.CREATOR);
        if (!arrayList.isEmpty()) {
            for (Bundle restoreMissionItemFromBundle : arrayList) {
                this.missionItemsList.add(MissionItemType.restoreMissionItemFromBundle(restoreMissionItemFromBundle));
            }
        }
    }
}
