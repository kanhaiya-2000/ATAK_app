package com.o3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLong;

public class Gps implements DroneAttribute {
    public static final Parcelable.Creator<Gps> CREATOR = new Parcelable.Creator<Gps>() {
        public Gps createFromParcel(Parcel parcel) {
            return new Gps(parcel);
        }

        public Gps[] newArray(int i) {
            return new Gps[i];
        }
    };
    public static final String LOCK_2D = "2D";
    private static final int LOCK_2D_TYPE = 2;
    public static final String LOCK_3D = "3D";
    public static final String LOCK_3D_DGPS = "3D+DGPS";
    private static final int LOCK_3D_DGPS_TYPE = 4;
    public static final String LOCK_3D_RTK = "3D+RTK";
    private static final int LOCK_3D_RTK_TYPE = 5;
    private static final int LOCK_3D_TYPE = 3;
    public static final String NO_FIX = "NoFix";
    private EkfStatus ekfStatus;
    private int fixType;
    private double gpsEph;
    private LatLong position;
    private int satCount;
    private boolean vehicleArmed;

    public int describeContents() {
        return 0;
    }

    public Gps() {
    }

    public Gps(LatLong latLong, double d, int i, int i2) {
        this.position = latLong;
        this.gpsEph = d;
        this.satCount = i;
        this.fixType = i2;
    }

    public Gps(double d, double d2, double d3, int i, int i2) {
        this(new LatLong(d, d2), d3, i, i2);
    }

    public boolean isValid() {
        EkfStatus ekfStatus2 = this.ekfStatus;
        if (ekfStatus2 == null) {
            if (this.position != null) {
                return true;
            }
            return false;
        } else if (!ekfStatus2.isPositionOk(this.vehicleArmed) || this.position == null) {
            return false;
        } else {
            return true;
        }
    }

    public double getGpsEph() {
        return this.gpsEph;
    }

    public int getSatellitesCount() {
        return this.satCount;
    }

    public int getFixType() {
        return this.fixType;
    }

    public String getFixStatus() {
        int i = this.fixType;
        if (i == 2) {
            return LOCK_2D;
        }
        if (i == 3) {
            return LOCK_3D;
        }
        if (i != 4) {
            return i != 5 ? NO_FIX : LOCK_3D_RTK;
        }
        return LOCK_3D_DGPS;
    }

    public LatLong getPosition() {
        if (isValid()) {
            return this.position;
        }
        return null;
    }

    public void setGpsEph(double d) {
        this.gpsEph = d;
    }

    public void setSatCount(int i) {
        this.satCount = i;
    }

    public void setFixType(int i) {
        this.fixType = i;
    }

    public void setPosition(LatLong latLong) {
        this.position = latLong;
    }

    public void setEkfStatus(EkfStatus ekfStatus2) {
        this.ekfStatus = ekfStatus2;
    }

    public void setVehicleArmed(boolean z) {
        this.vehicleArmed = z;
    }

    public boolean has3DLock() {
        int i = this.fixType;
        return i == 3 || i == 4 || i == 5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Gps)) {
            return false;
        }
        Gps gps = (Gps) obj;
        if (this.fixType != gps.fixType || Double.compare(gps.gpsEph, this.gpsEph) != 0 || this.satCount != gps.satCount) {
            return false;
        }
        LatLong latLong = this.position;
        if (latLong == null ? gps.position != null : !latLong.equals(gps.position)) {
            return false;
        }
        if (this.vehicleArmed != gps.vehicleArmed) {
            return false;
        }
        EkfStatus ekfStatus2 = this.ekfStatus;
        EkfStatus ekfStatus3 = gps.ekfStatus;
        return ekfStatus2 == null ? ekfStatus3 == null : ekfStatus2.equals(ekfStatus3);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.gpsEph);
        int i = ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + this.satCount) * 31) + this.fixType) * 31;
        LatLong latLong = this.position;
        int i2 = 0;
        int hashCode = (((i + (latLong != null ? latLong.hashCode() : 0)) * 31) + (this.vehicleArmed ? 1 : 0)) * 31;
        EkfStatus ekfStatus2 = this.ekfStatus;
        if (ekfStatus2 != null) {
            i2 = ekfStatus2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "Gps{gpsEph=" + this.gpsEph + ", satCount=" + this.satCount + ", fixType=" + this.fixType + ", position=" + this.position + ", vehicleArmed=" + this.vehicleArmed + ", ekfStatus=" + this.ekfStatus + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.gpsEph);
        parcel.writeInt(this.satCount);
        parcel.writeInt(this.fixType);
        parcel.writeParcelable(this.position, 0);
        parcel.writeByte(this.vehicleArmed ? (byte) 1 : 0);
        parcel.writeParcelable(this.ekfStatus, 0);
    }

    private Gps(Parcel parcel) {
        this.gpsEph = parcel.readDouble();
        this.satCount = parcel.readInt();
        this.fixType = parcel.readInt();
        this.position = (LatLong) parcel.readParcelable(LatLong.class.getClassLoader());
        this.vehicleArmed = parcel.readByte() != 0;
        this.ekfStatus = (EkfStatus) parcel.readParcelable(EkfStatus.class.getClassLoader());
    }
}
