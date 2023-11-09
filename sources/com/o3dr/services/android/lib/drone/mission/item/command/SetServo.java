package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class SetServo extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<SetServo> CREATOR = new Parcelable.Creator<SetServo>() {
        public SetServo createFromParcel(Parcel parcel) {
            return new SetServo(parcel);
        }

        public SetServo[] newArray(int i) {
            return new SetServo[i];
        }
    };
    private int channel;
    private int pwm;

    public SetServo() {
        super(MissionItemType.SET_SERVO);
    }

    public SetServo(SetServo setServo) {
        this();
        this.pwm = setServo.pwm;
        this.channel = setServo.channel;
    }

    public int getPwm() {
        return this.pwm;
    }

    public void setPwm(int i) {
        this.pwm = i;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public String toString() {
        return "SetServo{channel=" + this.channel + ", pwm=" + this.pwm + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetServo) || !super.equals(obj)) {
            return false;
        }
        SetServo setServo = (SetServo) obj;
        if (this.pwm == setServo.pwm && this.channel == setServo.channel) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.pwm) * 31) + this.channel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.pwm);
        parcel.writeInt(this.channel);
    }

    private SetServo(Parcel parcel) {
        super(parcel);
        this.pwm = parcel.readInt();
        this.channel = parcel.readInt();
    }

    public MissionItem clone() {
        return new SetServo(this);
    }
}
