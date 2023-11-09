package com.o3dr.services.android.lib.drone.mission.item.complex;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.mission.item.spatial.BaseSpatialItem;
import java.util.ArrayList;
import java.util.List;

public class StructureScanner extends BaseSpatialItem implements Parcelable, MissionItem.ComplexItem<StructureScanner> {
    public static final Parcelable.Creator<StructureScanner> CREATOR = new Parcelable.Creator<StructureScanner>() {
        public StructureScanner createFromParcel(Parcel parcel) {
            return new StructureScanner(parcel);
        }

        public StructureScanner[] newArray(int i) {
            return new StructureScanner[i];
        }
    };
    private boolean crossHatch;
    private double heightStep;
    private List<LatLong> path;
    private double radius;
    private int stepsCount;
    private SurveyDetail surveyDetail;

    public StructureScanner() {
        super(MissionItemType.STRUCTURE_SCANNER);
        this.radius = 10.0d;
        this.heightStep = 5.0d;
        this.stepsCount = 2;
        this.crossHatch = false;
        this.surveyDetail = new SurveyDetail();
        this.path = new ArrayList();
    }

    public StructureScanner(StructureScanner structureScanner) {
        super((BaseSpatialItem) structureScanner);
        this.radius = 10.0d;
        this.heightStep = 5.0d;
        this.stepsCount = 2;
        this.crossHatch = false;
        this.surveyDetail = new SurveyDetail();
        this.path = new ArrayList();
        copy(structureScanner);
    }

    public void copy(StructureScanner structureScanner) {
        this.radius = structureScanner.radius;
        this.heightStep = structureScanner.heightStep;
        this.stepsCount = structureScanner.stepsCount;
        this.crossHatch = structureScanner.crossHatch;
        this.surveyDetail = new SurveyDetail(structureScanner.surveyDetail);
        this.path = copyPointsList(structureScanner.path);
    }

    private List<LatLong> copyPointsList(List<LatLong> list) {
        ArrayList arrayList = new ArrayList();
        for (LatLong latLong : list) {
            arrayList.add(new LatLong(latLong));
        }
        return arrayList;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public double getHeightStep() {
        return this.heightStep;
    }

    public void setHeightStep(double d) {
        this.heightStep = d;
    }

    public int getStepsCount() {
        return this.stepsCount;
    }

    public void setStepsCount(int i) {
        this.stepsCount = i;
    }

    public boolean isCrossHatch() {
        return this.crossHatch;
    }

    public void setCrossHatch(boolean z) {
        this.crossHatch = z;
    }

    public SurveyDetail getSurveyDetail() {
        return this.surveyDetail;
    }

    public void setSurveyDetail(SurveyDetail surveyDetail2) {
        this.surveyDetail = surveyDetail2;
    }

    public List<LatLong> getPath() {
        return this.path;
    }

    public void setPath(List<LatLong> list) {
        this.path = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.radius);
        parcel.writeDouble(this.heightStep);
        parcel.writeInt(this.stepsCount);
        parcel.writeByte(this.crossHatch ? (byte) 1 : 0);
        parcel.writeParcelable(this.surveyDetail, 0);
        parcel.writeTypedList(this.path);
    }

    private StructureScanner(Parcel parcel) {
        super(parcel);
        this.radius = 10.0d;
        this.heightStep = 5.0d;
        this.stepsCount = 2;
        boolean z = false;
        this.crossHatch = false;
        this.surveyDetail = new SurveyDetail();
        this.path = new ArrayList();
        this.radius = parcel.readDouble();
        this.heightStep = parcel.readDouble();
        this.stepsCount = parcel.readInt();
        this.crossHatch = parcel.readByte() != 0 ? true : z;
        this.surveyDetail = (SurveyDetail) parcel.readParcelable(SurveyDetail.class.getClassLoader());
        parcel.readTypedList(this.path, LatLong.CREATOR);
    }

    public String toString() {
        return "StructureScanner{crossHatch=" + this.crossHatch + ", radius=" + this.radius + ", heightStep=" + this.heightStep + ", stepsCount=" + this.stepsCount + ", surveyDetail=" + this.surveyDetail + ", path=" + this.path + ", " + super.toString() + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StructureScanner) || !super.equals(obj)) {
            return false;
        }
        StructureScanner structureScanner = (StructureScanner) obj;
        if (Double.compare(structureScanner.radius, this.radius) != 0 || Double.compare(structureScanner.heightStep, this.heightStep) != 0 || this.stepsCount != structureScanner.stepsCount || this.crossHatch != structureScanner.crossHatch) {
            return false;
        }
        SurveyDetail surveyDetail2 = this.surveyDetail;
        if (surveyDetail2 == null ? structureScanner.surveyDetail != null : !surveyDetail2.equals(structureScanner.surveyDetail)) {
            return false;
        }
        List<LatLong> list = this.path;
        List<LatLong> list2 = structureScanner.path;
        if (list != null) {
            if (!list.equals(list2)) {
                return false;
            }
            return true;
        } else if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.radius);
        long doubleToLongBits2 = Double.doubleToLongBits(this.heightStep);
        int i = ((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.stepsCount) * 31) + (this.crossHatch ? 1 : 0)) * 31;
        SurveyDetail surveyDetail2 = this.surveyDetail;
        int i2 = 0;
        int hashCode2 = (i + (surveyDetail2 != null ? surveyDetail2.hashCode() : 0)) * 31;
        List<LatLong> list = this.path;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public MissionItem clone() {
        return new StructureScanner(this);
    }
}
