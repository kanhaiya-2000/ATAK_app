package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;

public class SetRelay extends MissionItem implements Parcelable, MissionItem.Command {
    public static final Parcelable.Creator<SetRelay> CREATOR = new Parcelable.Creator<SetRelay>() {
        public SetRelay createFromParcel(Parcel parcel) {
            return new SetRelay(parcel);
        }

        public SetRelay[] newArray(int i) {
            return new SetRelay[i];
        }
    };
    private boolean enabled;
    private int relayNumber;

    public SetRelay() {
        super(MissionItemType.SET_RELAY);
    }

    public SetRelay(SetRelay setRelay) {
        this();
        this.relayNumber = setRelay.relayNumber;
        this.enabled = setRelay.enabled;
    }

    public int getRelayNumber() {
        return this.relayNumber;
    }

    public void setRelayNumber(int i) {
        this.relayNumber = i;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public MissionItem clone() {
        return new SetRelay(this);
    }

    public String toString() {
        return "SetRelay{enabled=" + this.enabled + ", relayNumber=" + this.relayNumber + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetRelay) || !super.equals(obj)) {
            return false;
        }
        SetRelay setRelay = (SetRelay) obj;
        if (this.relayNumber == setRelay.relayNumber && this.enabled == setRelay.enabled) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.relayNumber) * 31) + (this.enabled ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.relayNumber);
        parcel.writeByte(this.enabled ? (byte) 1 : 0);
    }

    private SetRelay(Parcel parcel) {
        super(parcel);
        this.relayNumber = parcel.readInt();
        this.enabled = parcel.readByte() != 0;
    }
}
