package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class ResetROI extends MissionItem implements MissionItem.Command {
    public static final Parcelable.Creator<ResetROI> CREATOR = new Parcelable.Creator<ResetROI>() {
        public ResetROI createFromParcel(Parcel parcel) {
            return new ResetROI(parcel);
        }

        public ResetROI[] newArray(int i) {
            return new ResetROI[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ResetROI{}";
    }

    public ResetROI() {
        super(MissionItemType.RESET_ROI);
    }

    public ResetROI(ResetROI resetROI) {
        this();
    }

    public MissionItem clone() {
        return new ResetROI(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected ResetROI(Parcel parcel) {
        super(parcel);
    }
}
