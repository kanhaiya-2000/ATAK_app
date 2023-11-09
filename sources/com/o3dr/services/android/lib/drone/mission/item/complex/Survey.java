package com.o3dr.services.android.lib.drone.mission.item.complex;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.util.MathUtils;
import java.util.ArrayList;
import java.util.List;

public class Survey extends MissionItem implements Parcelable, MissionItem.ComplexItem<Survey> {
    public static final Parcelable.Creator<Survey> CREATOR = new Parcelable.Creator<Survey>() {
        public Survey createFromParcel(Parcel parcel) {
            return new Survey(parcel);
        }

        public Survey[] newArray(int i) {
            return new Survey[i];
        }
    };
    private List<LatLong> cameraLocations;
    private List<LatLong> gridPoints;
    private boolean isValid;
    private double polygonArea;
    private List<LatLong> polygonPoints;
    private boolean startCameraBeforeFirstWaypoint;
    private SurveyDetail surveyDetail;

    public Survey() {
        this(MissionItemType.SURVEY);
    }

    protected Survey(MissionItemType missionItemType) {
        super(missionItemType);
        SurveyDetail surveyDetail2 = new SurveyDetail();
        this.surveyDetail = surveyDetail2;
        surveyDetail2.setAltitude(50.0d);
        this.surveyDetail.setAngle(0.0d);
        this.surveyDetail.setOverlap(50.0d);
        this.surveyDetail.setSidelap(60.0d);
        this.surveyDetail.setLockOrientation(false);
        this.polygonPoints = new ArrayList();
        this.gridPoints = new ArrayList();
        this.cameraLocations = new ArrayList();
    }

    public Survey(Survey survey) {
        this();
        copy(survey);
    }

    public void copy(Survey survey) {
        this.surveyDetail = new SurveyDetail(survey.surveyDetail);
        this.polygonArea = survey.polygonArea;
        this.polygonPoints = copyPointsList(survey.polygonPoints);
        this.gridPoints = copyPointsList(survey.gridPoints);
        this.cameraLocations = copyPointsList(survey.cameraLocations);
        this.isValid = survey.isValid;
        this.startCameraBeforeFirstWaypoint = survey.startCameraBeforeFirstWaypoint;
    }

    private List<LatLong> copyPointsList(List<LatLong> list) {
        ArrayList arrayList = new ArrayList();
        for (LatLong latLong : list) {
            arrayList.add(new LatLong(latLong));
        }
        return arrayList;
    }

    public SurveyDetail getSurveyDetail() {
        return this.surveyDetail;
    }

    public void setSurveyDetail(SurveyDetail surveyDetail2) {
        this.surveyDetail = surveyDetail2;
    }

    public double getPolygonArea() {
        return this.polygonArea;
    }

    public void setPolygonArea(double d) {
        this.polygonArea = d;
    }

    public List<LatLong> getPolygonPoints() {
        return this.polygonPoints;
    }

    public void setPolygonPoints(List<LatLong> list) {
        this.polygonPoints = list;
    }

    public List<LatLong> getGridPoints() {
        return this.gridPoints;
    }

    public void setGridPoints(List<LatLong> list) {
        this.gridPoints = list;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public double getGridLength() {
        return MathUtils.getPolylineLength(this.gridPoints);
    }

    public int getNumberOfLines() {
        return this.gridPoints.size() / 2;
    }

    public List<LatLong> getCameraLocations() {
        return this.cameraLocations;
    }

    public void setCameraLocations(List<LatLong> list) {
        this.cameraLocations = list;
    }

    public boolean isStartCameraBeforeFirstWaypoint() {
        return this.startCameraBeforeFirstWaypoint;
    }

    public void setStartCameraBeforeFirstWaypoint(boolean z) {
        this.startCameraBeforeFirstWaypoint = z;
    }

    public int getCameraCount() {
        return getCameraLocations().size();
    }

    public String toString() {
        return "Survey{cameraLocations=" + this.cameraLocations + ", surveyDetail=" + this.surveyDetail + ", polygonArea=" + this.polygonArea + ", polygonPoints=" + this.polygonPoints + ", gridPoints=" + this.gridPoints + ", isValid=" + this.isValid + ", startCameraBeforeFirstWaypoint=" + this.startCameraBeforeFirstWaypoint + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Survey) || !super.equals(obj)) {
            return false;
        }
        Survey survey = (Survey) obj;
        if (Double.compare(survey.polygonArea, this.polygonArea) != 0 || this.isValid != survey.isValid || this.startCameraBeforeFirstWaypoint != survey.startCameraBeforeFirstWaypoint) {
            return false;
        }
        SurveyDetail surveyDetail2 = this.surveyDetail;
        if (surveyDetail2 == null ? survey.surveyDetail != null : !surveyDetail2.equals(survey.surveyDetail)) {
            return false;
        }
        List<LatLong> list = this.polygonPoints;
        if (list == null ? survey.polygonPoints != null : !list.equals(survey.polygonPoints)) {
            return false;
        }
        List<LatLong> list2 = this.gridPoints;
        if (list2 == null ? survey.gridPoints != null : !list2.equals(survey.gridPoints)) {
            return false;
        }
        List<LatLong> list3 = this.cameraLocations;
        List<LatLong> list4 = survey.cameraLocations;
        if (list3 != null) {
            if (!list3.equals(list4)) {
                return false;
            }
            return true;
        } else if (list4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        SurveyDetail surveyDetail2 = this.surveyDetail;
        int i = 0;
        int hashCode2 = surveyDetail2 != null ? surveyDetail2.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.polygonArea);
        int i2 = (((hashCode + hashCode2) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        List<LatLong> list = this.polygonPoints;
        int hashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<LatLong> list2 = this.gridPoints;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<LatLong> list3 = this.cameraLocations;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return ((((hashCode4 + i) * 31) + (this.isValid ? 1 : 0)) * 31) + (this.startCameraBeforeFirstWaypoint ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.surveyDetail, 0);
        parcel.writeDouble(this.polygonArea);
        parcel.writeTypedList(this.polygonPoints);
        parcel.writeTypedList(this.gridPoints);
        parcel.writeTypedList(this.cameraLocations);
        parcel.writeByte(this.isValid ? (byte) 1 : 0);
        parcel.writeByte(this.startCameraBeforeFirstWaypoint ? (byte) 1 : 0);
    }

    protected Survey(Parcel parcel) {
        super(parcel);
        SurveyDetail surveyDetail2 = new SurveyDetail();
        this.surveyDetail = surveyDetail2;
        surveyDetail2.setAltitude(50.0d);
        this.surveyDetail.setAngle(0.0d);
        this.surveyDetail.setOverlap(50.0d);
        this.surveyDetail.setSidelap(60.0d);
        boolean z = false;
        this.surveyDetail.setLockOrientation(false);
        this.polygonPoints = new ArrayList();
        this.gridPoints = new ArrayList();
        this.cameraLocations = new ArrayList();
        this.surveyDetail = (SurveyDetail) parcel.readParcelable(SurveyDetail.class.getClassLoader());
        this.polygonArea = parcel.readDouble();
        parcel.readTypedList(this.polygonPoints, LatLong.CREATOR);
        parcel.readTypedList(this.gridPoints, LatLong.CREATOR);
        parcel.readTypedList(this.cameraLocations, LatLong.CREATOR);
        this.isValid = parcel.readByte() != 0;
        this.startCameraBeforeFirstWaypoint = parcel.readByte() != 0 ? true : z;
    }

    public MissionItem clone() {
        return new Survey(this);
    }
}
