package com.o3dr.services.android.lib.drone.mission.item.complex;

import android.os.Parcel;
import android.os.Parcelable;

public class SurveyDetail implements Parcelable {
    public static final Parcelable.Creator<SurveyDetail> CREATOR = new Parcelable.Creator<SurveyDetail>() {
        public SurveyDetail createFromParcel(Parcel parcel) {
            return new SurveyDetail(parcel);
        }

        public SurveyDetail[] newArray(int i) {
            return new SurveyDetail[i];
        }
    };
    private double altitude;
    private double angle;
    private CameraDetail cameraDetail;
    private boolean lockOrientation;
    private double overlap;
    private double sidelap;

    public int describeContents() {
        return 0;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double d) {
        this.angle = d;
    }

    public double getOverlap() {
        return this.overlap;
    }

    public void setOverlap(double d) {
        this.overlap = d;
    }

    public double getSidelap() {
        return this.sidelap;
    }

    public void setSidelap(double d) {
        this.sidelap = d;
    }

    public CameraDetail getCameraDetail() {
        return this.cameraDetail;
    }

    public void setCameraDetail(CameraDetail cameraDetail2) {
        this.cameraDetail = cameraDetail2;
    }

    public boolean getLockOrientation() {
        return this.lockOrientation;
    }

    public void setLockOrientation(boolean z) {
        this.lockOrientation = z;
    }

    public double getLateralFootPrint() {
        return (this.altitude * this.cameraDetail.getSensorLateralSize().doubleValue()) / this.cameraDetail.getFocalLength();
    }

    public double getLongitudinalFootPrint() {
        return (this.altitude * this.cameraDetail.getSensorLongitudinalSize().doubleValue()) / this.cameraDetail.getFocalLength();
    }

    public double getGroundResolution() {
        return ((((this.altitude * this.cameraDetail.getSensorLateralSize().doubleValue()) / this.cameraDetail.getFocalLength()) * ((this.altitude * this.cameraDetail.getSensorLongitudinalSize().doubleValue()) / this.cameraDetail.getFocalLength())) / (this.cameraDetail.getSensorResolution() * 1000.0d)) / 10000.0d;
    }

    public double getLongitudinalPictureDistance() {
        return getLongitudinalFootPrint() * (1.0d - (this.overlap * 0.01d));
    }

    public double getLateralPictureDistance() {
        return getLateralFootPrint() * (1.0d - (this.sidelap * 0.01d));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.altitude);
        parcel.writeDouble(this.angle);
        parcel.writeDouble(this.overlap);
        parcel.writeDouble(this.sidelap);
        parcel.writeParcelable(this.cameraDetail, 0);
        parcel.writeByte(this.lockOrientation ? (byte) 1 : 0);
    }

    public SurveyDetail() {
    }

    public SurveyDetail(SurveyDetail surveyDetail) {
        this.altitude = surveyDetail.altitude;
        this.angle = surveyDetail.angle;
        this.overlap = surveyDetail.overlap;
        this.sidelap = surveyDetail.sidelap;
        this.lockOrientation = surveyDetail.lockOrientation;
        this.cameraDetail = surveyDetail.cameraDetail == null ? null : new CameraDetail(surveyDetail.cameraDetail);
    }

    private SurveyDetail(Parcel parcel) {
        this.altitude = parcel.readDouble();
        this.angle = parcel.readDouble();
        this.overlap = parcel.readDouble();
        this.sidelap = parcel.readDouble();
        this.cameraDetail = (CameraDetail) parcel.readParcelable(CameraDetail.class.getClassLoader());
        this.lockOrientation = parcel.readByte() != 0;
    }
}
