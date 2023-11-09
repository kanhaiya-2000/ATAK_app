package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.os.Parcel;
import android.os.Parcelable;

public class ThermalData implements Parcelable {
    public static final Parcelable.Creator<ThermalData> CREATOR = new Parcelable.Creator<ThermalData>() {
        public ThermalData createFromParcel(Parcel parcel) {
            return new ThermalData(parcel);
        }

        public ThermalData[] newArray(int i) {
            return new ThermalData[i];
        }
    };
    public static final String TAG = "ThermalData";
    public float aveTemp;
    public float maxTemp;
    public float maxX;
    public float maxY;
    public float minTemp;
    public float minX;
    public float minY;
    public String tempUnitsLabel;

    public int describeContents() {
        return 0;
    }

    public ThermalData() {
        this.aveTemp = Float.NaN;
        this.minTemp = Float.NaN;
        this.maxTemp = Float.NaN;
        this.tempUnitsLabel = null;
        this.minX = Float.NaN;
        this.minY = Float.NaN;
        this.maxX = Float.NaN;
        this.maxY = Float.NaN;
    }

    public ThermalData(Parcel parcel) {
        this();
        this.aveTemp = parcel.readFloat();
        this.minTemp = parcel.readFloat();
        this.maxTemp = parcel.readFloat();
        this.tempUnitsLabel = parcel.readString();
        this.minX = parcel.readFloat();
        this.minY = parcel.readFloat();
        this.maxX = parcel.readFloat();
        this.maxY = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.aveTemp);
        parcel.writeFloat(this.minTemp);
        parcel.writeFloat(this.maxTemp);
        parcel.writeString(this.tempUnitsLabel);
        parcel.writeFloat(this.minX);
        parcel.writeFloat(this.minY);
        parcel.writeFloat(this.maxX);
        parcel.writeFloat(this.maxY);
    }

    public String toString() {
        return "aveTemp: " + this.aveTemp + " minTemp: " + this.minTemp + " maxTemp: " + this.maxTemp + " units: " + this.tempUnitsLabel + " minX: " + this.minX + " minY: " + this.minY + " maxX: " + this.maxX + " maxY: " + this.maxY;
    }

    public ThermalData copy() {
        ThermalData thermalData = new ThermalData();
        thermalData.aveTemp = this.aveTemp;
        thermalData.minTemp = this.minTemp;
        thermalData.maxTemp = this.maxTemp;
        thermalData.tempUnitsLabel = this.tempUnitsLabel;
        thermalData.minX = this.minX;
        thermalData.minY = this.minY;
        thermalData.maxTemp = this.maxTemp;
        thermalData.maxX = this.maxX;
        thermalData.maxY = this.maxY;
        return thermalData;
    }
}
