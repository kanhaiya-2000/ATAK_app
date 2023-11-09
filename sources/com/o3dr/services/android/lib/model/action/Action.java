package com.o3dr.services.android.lib.model.action;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Action implements Parcelable {
    public static final Parcelable.Creator<Action> CREATOR = new Parcelable.Creator<Action>() {
        public Action createFromParcel(Parcel parcel) {
            return new Action(parcel);
        }

        public Action[] newArray(int i) {
            return new Action[i];
        }
    };
    private Bundle data;
    private String type;

    public int describeContents() {
        return 0;
    }

    public Action(String str) {
        this.type = str;
        this.data = null;
    }

    public Action(String str, Bundle bundle) {
        this.type = str;
        this.data = bundle;
    }

    public String getType() {
        return this.type;
    }

    public Bundle getData() {
        return this.data;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeBundle(this.data);
    }

    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readString();
        this.data = parcel.readBundle();
    }

    private Action(Parcel parcel) {
        readFromParcel(parcel);
    }
}
