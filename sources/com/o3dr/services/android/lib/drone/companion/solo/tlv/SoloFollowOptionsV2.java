package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloFollowOptionsV2 extends SoloFollowOptions {
    public static final Parcelable.Creator<SoloFollowOptionsV2> CREATOR = new Parcelable.Creator<SoloFollowOptionsV2>() {
        public SoloFollowOptionsV2 createFromParcel(Parcel parcel) {
            return new SoloFollowOptionsV2(parcel);
        }

        public SoloFollowOptionsV2[] newArray(int i) {
            return new SoloFollowOptionsV2[i];
        }
    };
    public static final int FOLLOW_PREFERENCE_FREE_LOOK = 1;
    public static final int FOLLOW_PREFERENCE_LEASH = 2;
    public static final int FOLLOW_PREFERENCE_NONE = -1;
    public static final int FOLLOW_PREFERENCE_ORBIT = 0;
    private int followPreference;

    public @interface FollowPreference {
    }

    public SoloFollowOptionsV2() {
        this(0.0f, true, -1);
    }

    public SoloFollowOptionsV2(float f, boolean z, int i) {
        super(119, 12, f, z);
        this.followPreference = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloFollowOptionsV2(float f, int i, int i2) {
        this(f, i != 1 ? false : true, i2);
    }

    SoloFollowOptionsV2(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getInt(), byteBuffer.getInt());
    }

    public int getFollowPreference() {
        return this.followPreference;
    }

    public void setFollowPreference(int i) {
        this.followPreference = i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        super.getMessageValue(byteBuffer);
        byteBuffer.putInt(this.followPreference);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.followPreference);
    }

    protected SoloFollowOptionsV2(Parcel parcel) {
        super(parcel);
        this.followPreference = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj) || this.followPreference != ((SoloFollowOptionsV2) obj).followPreference) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.followPreference;
    }

    public String toString() {
        return "SoloFollowOptionsV2{followPreference=" + this.followPreference + '}';
    }
}
