package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail;
import java.util.ArrayList;
import java.util.List;

public class CameraProxy implements DroneAttribute {
    public static final Parcelable.Creator<CameraProxy> CREATOR = new Parcelable.Creator<CameraProxy>() {
        public CameraProxy createFromParcel(Parcel parcel) {
            return new CameraProxy(parcel);
        }

        public CameraProxy[] newArray(int i) {
            return new CameraProxy[i];
        }
    };
    private List<CameraDetail> availableCameraInfos;
    private CameraDetail cameraDetail;
    private FootPrint currentFieldOfView;
    private List<FootPrint> footPrints;

    public int describeContents() {
        return 0;
    }

    public CameraProxy(CameraDetail cameraDetail2, FootPrint footPrint, List<FootPrint> list, List<CameraDetail> list2) {
        this.footPrints = new ArrayList();
        this.availableCameraInfos = new ArrayList();
        this.cameraDetail = cameraDetail2;
        this.currentFieldOfView = footPrint;
        this.footPrints = list;
        this.availableCameraInfos = list2;
    }

    public CameraDetail getCameraDetail() {
        return this.cameraDetail;
    }

    public List<FootPrint> getFootPrints() {
        return this.footPrints;
    }

    public FootPrint getLastFootPrint() {
        List<FootPrint> list = this.footPrints;
        return list.get(list.size() - 1);
    }

    public FootPrint getCurrentFieldOfView() {
        return this.currentFieldOfView;
    }

    public List<CameraDetail> getAvailableCameraInfos() {
        return this.availableCameraInfos;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.cameraDetail, 0);
        parcel.writeTypedList(this.footPrints);
        parcel.writeParcelable(this.currentFieldOfView, 0);
        parcel.writeTypedList(this.availableCameraInfos);
    }

    private CameraProxy(Parcel parcel) {
        this.footPrints = new ArrayList();
        this.availableCameraInfos = new ArrayList();
        this.cameraDetail = (CameraDetail) parcel.readParcelable(CameraDetail.class.getClassLoader());
        parcel.readTypedList(this.footPrints, FootPrint.CREATOR);
        this.currentFieldOfView = (FootPrint) parcel.readParcelable(FootPrint.class.getClassLoader());
        parcel.readTypedList(this.availableCameraInfos, CameraDetail.CREATOR);
    }
}
