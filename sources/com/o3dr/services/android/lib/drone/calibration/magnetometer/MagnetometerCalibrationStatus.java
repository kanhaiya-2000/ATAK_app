package com.o3dr.services.android.lib.drone.calibration.magnetometer;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagnetometerCalibrationStatus implements DroneAttribute {
    public static final Parcelable.Creator<MagnetometerCalibrationStatus> CREATOR = new Parcelable.Creator<MagnetometerCalibrationStatus>() {
        public MagnetometerCalibrationStatus createFromParcel(Parcel parcel) {
            return new MagnetometerCalibrationStatus(parcel);
        }

        public MagnetometerCalibrationStatus[] newArray(int i) {
            return new MagnetometerCalibrationStatus[i];
        }
    };
    private boolean calibrationCancelled;
    private final Map<Integer, MagnetometerCalibrationProgress> calibrationProgressTracker;
    private final Map<Integer, MagnetometerCalibrationResult> calibrationResultTracker;
    private final List<Integer> compassList;

    public int describeContents() {
        return 0;
    }

    public MagnetometerCalibrationStatus() {
        this.calibrationProgressTracker = new HashMap();
        this.calibrationResultTracker = new HashMap();
        this.compassList = new ArrayList();
    }

    public void addCalibrationProgress(MagnetometerCalibrationProgress magnetometerCalibrationProgress) {
        if (magnetometerCalibrationProgress != null) {
            int compassId = magnetometerCalibrationProgress.getCompassId();
            this.calibrationProgressTracker.put(Integer.valueOf(compassId), magnetometerCalibrationProgress);
            this.compassList.add(Integer.valueOf(compassId));
        }
    }

    public void addCalibrationResult(MagnetometerCalibrationResult magnetometerCalibrationResult) {
        if (magnetometerCalibrationResult != null) {
            int compassId = magnetometerCalibrationResult.getCompassId();
            this.calibrationResultTracker.put(Integer.valueOf(magnetometerCalibrationResult.getCompassId()), magnetometerCalibrationResult);
            this.compassList.add(Integer.valueOf(compassId));
        }
    }

    public List<Integer> getCompassIds() {
        return this.compassList;
    }

    public MagnetometerCalibrationProgress getCalibrationProgress(int i) {
        return this.calibrationProgressTracker.get(Integer.valueOf(i));
    }

    public MagnetometerCalibrationResult getCalibrationResult(int i) {
        return this.calibrationResultTracker.get(Integer.valueOf(i));
    }

    public boolean isCalibrationCancelled() {
        return this.calibrationCancelled;
    }

    public void setCalibrationCancelled(boolean z) {
        this.calibrationCancelled = z;
    }

    public boolean isCalibrationComplete() {
        for (Integer containsKey : this.compassList) {
            if (!this.calibrationResultTracker.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(new ArrayList(this.calibrationProgressTracker.values()));
        parcel.writeTypedList(new ArrayList(this.calibrationResultTracker.values()));
        parcel.writeByte(this.calibrationCancelled ? (byte) 1 : 0);
    }

    private MagnetometerCalibrationStatus(Parcel parcel) {
        this.calibrationProgressTracker = new HashMap();
        this.calibrationResultTracker = new HashMap();
        this.compassList = new ArrayList();
        ArrayList<MagnetometerCalibrationProgress> arrayList = new ArrayList<>();
        parcel.readTypedList(arrayList, MagnetometerCalibrationProgress.CREATOR);
        for (MagnetometerCalibrationProgress addCalibrationProgress : arrayList) {
            addCalibrationProgress(addCalibrationProgress);
        }
        ArrayList<MagnetometerCalibrationResult> arrayList2 = new ArrayList<>();
        parcel.readTypedList(arrayList2, MagnetometerCalibrationResult.CREATOR);
        for (MagnetometerCalibrationResult addCalibrationResult : arrayList2) {
            addCalibrationResult(addCalibrationResult);
        }
        this.calibrationCancelled = parcel.readByte() != 0;
    }
}
