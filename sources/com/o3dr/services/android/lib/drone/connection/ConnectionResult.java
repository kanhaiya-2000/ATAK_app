package com.o3dr.services.android.lib.drone.connection;

import android.os.Parcel;
import android.os.Parcelable;

public final class ConnectionResult implements Parcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new Parcelable.Creator<ConnectionResult>() {
        public ConnectionResult createFromParcel(Parcel parcel) {
            return new ConnectionResult(parcel);
        }

        public ConnectionResult[] newArray(int i) {
            return new ConnectionResult[i];
        }
    };
    private final int mErrorCode;
    private final String mErrorMessage;

    public int describeContents() {
        return 0;
    }

    public ConnectionResult(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mErrorMessage);
    }

    private ConnectionResult(Parcel parcel) {
        this.mErrorCode = parcel.readInt();
        this.mErrorMessage = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (this.mErrorCode != connectionResult.mErrorCode) {
            return false;
        }
        String str = this.mErrorMessage;
        String str2 = connectionResult.mErrorMessage;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        int i = this.mErrorCode * 31;
        String str = this.mErrorMessage;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ConnectionResult{mErrorCode=" + this.mErrorCode + ", mErrorMessage='" + this.mErrorMessage + '\'' + '}';
    }
}
