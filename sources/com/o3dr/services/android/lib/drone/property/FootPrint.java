package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.util.MathUtils;
import java.util.ArrayList;
import java.util.List;

public class FootPrint implements DroneAttribute {
    public static final Parcelable.Creator<FootPrint> CREATOR = new Parcelable.Creator<FootPrint>() {
        public FootPrint createFromParcel(Parcel parcel) {
            return new FootPrint(parcel);
        }

        public FootPrint[] newArray(int i) {
            return new FootPrint[i];
        }
    };
    private double meanGSD;
    private List<LatLong> vertex;

    public int describeContents() {
        return 0;
    }

    public FootPrint() {
        this.vertex = new ArrayList();
    }

    public FootPrint(double d, List<LatLong> list) {
        this.vertex = new ArrayList();
        this.meanGSD = d;
        this.vertex = list;
    }

    public void setMeanGSD(double d) {
        this.meanGSD = d;
    }

    public void setVertex(List<LatLong> list) {
        this.vertex = list;
    }

    public double getMeanGSD() {
        return this.meanGSD;
    }

    public List<LatLong> getVertexInGlobalFrame() {
        return this.vertex;
    }

    public double getLateralSize() {
        return (MathUtils.getDistance2D(this.vertex.get(0), this.vertex.get(1)) + MathUtils.getDistance2D(this.vertex.get(2), this.vertex.get(3))) / 2.0d;
    }

    public double getLongitudinalSize() {
        return (MathUtils.getDistance2D(this.vertex.get(0), this.vertex.get(3)) + MathUtils.getDistance2D(this.vertex.get(1), this.vertex.get(2))) / 2.0d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.meanGSD);
        parcel.writeTypedList(this.vertex);
    }

    private FootPrint(Parcel parcel) {
        this.vertex = new ArrayList();
        this.meanGSD = parcel.readDouble();
        parcel.readTypedList(this.vertex, LatLong.CREATOR);
    }
}
