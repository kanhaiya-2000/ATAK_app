package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class YawCondition extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<YawCondition> CREATOR = new Parcelable.Creator<YawCondition>() {
        public YawCondition createFromParcel(Parcel parcel) {
            return new YawCondition(parcel);
        }

        public YawCondition[] newArray(int i) {
            return new YawCondition[i];
        }
    };
    private double angle;
    private double angularSpeed;
    private boolean isRelative;

    public YawCondition() {
        super(MissionItemType.YAW_CONDITION);
    }

    public YawCondition(YawCondition yawCondition) {
        this();
        this.angle = yawCondition.angle;
        this.angularSpeed = yawCondition.angularSpeed;
        this.isRelative = yawCondition.isRelative;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double d) {
        this.angle = d;
    }

    public double getAngularSpeed() {
        return this.angularSpeed;
    }

    public void setAngularSpeed(double d) {
        this.angularSpeed = d;
    }

    public boolean isRelative() {
        return this.isRelative;
    }

    public void setRelative(boolean z) {
        this.isRelative = z;
    }

    public String toString() {
        return "YawCondition{angle=" + this.angle + ", angularSpeed=" + this.angularSpeed + ", isRelative=" + this.isRelative + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YawCondition) || !super.equals(obj)) {
            return false;
        }
        YawCondition yawCondition = (YawCondition) obj;
        if (Double.compare(yawCondition.angle, this.angle) == 0 && Double.compare(yawCondition.angularSpeed, this.angularSpeed) == 0 && this.isRelative == yawCondition.isRelative) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(this.angle);
        long doubleToLongBits2 = Double.doubleToLongBits(this.angularSpeed);
        return (((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + (this.isRelative ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.angle);
        parcel.writeDouble(this.angularSpeed);
        parcel.writeByte(this.isRelative ? (byte) 1 : 0);
    }

    private YawCondition(Parcel parcel) {
        super(parcel);
        this.angle = parcel.readDouble();
        this.angularSpeed = parcel.readDouble();
        this.isRelative = parcel.readByte() != 0;
    }

    public MissionItem clone() {
        return new YawCondition(this);
    }
}
