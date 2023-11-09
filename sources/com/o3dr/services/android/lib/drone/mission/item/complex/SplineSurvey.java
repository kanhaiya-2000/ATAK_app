package com.o3dr.services.android.lib.drone.mission.item.complex;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class SplineSurvey extends Survey {
    public static final Parcelable.Creator<SplineSurvey> CREATOR = new Parcelable.Creator<SplineSurvey>() {
        public SplineSurvey createFromParcel(Parcel parcel) {
            return new SplineSurvey(parcel);
        }

        public SplineSurvey[] newArray(int i) {
            return new SplineSurvey[i];
        }
    };

    public SplineSurvey() {
        super(MissionItemType.SPLINE_SURVEY);
    }

    public SplineSurvey(Survey survey) {
        this();
        copy(survey);
    }

    public SplineSurvey(SplineSurvey splineSurvey) {
        this((Survey) splineSurvey);
    }

    private SplineSurvey(Parcel parcel) {
        super(parcel);
    }

    public String toString() {
        return "SplineSurvey{" + super.toString() + "}";
    }

    public MissionItem clone() {
        return new SplineSurvey(this);
    }
}
