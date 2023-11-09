package com.o3dr.services.android.lib.mavlink;

import android.os.Parcel;
import android.os.Parcelable;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;

public class MavlinkMessageWrapper implements Parcelable {
    public static final Parcelable.Creator<MavlinkMessageWrapper> CREATOR = new Parcelable.Creator<MavlinkMessageWrapper>() {
        public MavlinkMessageWrapper createFromParcel(Parcel parcel) {
            return new MavlinkMessageWrapper(parcel);
        }

        public MavlinkMessageWrapper[] newArray(int i) {
            return new MavlinkMessageWrapper[i];
        }
    };
    private MAVLinkMessage mavLinkMessage;

    public int describeContents() {
        return 0;
    }

    public MavlinkMessageWrapper(MAVLinkMessage mAVLinkMessage) {
        this.mavLinkMessage = mAVLinkMessage;
    }

    public MAVLinkMessage getMavLinkMessage() {
        return this.mavLinkMessage;
    }

    public void setMavLinkMessage(MAVLinkMessage mAVLinkMessage) {
        this.mavLinkMessage = mAVLinkMessage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.mavLinkMessage);
    }

    private MavlinkMessageWrapper(Parcel parcel) {
        this.mavLinkMessage = (MAVLinkMessage) parcel.readSerializable();
    }
}
