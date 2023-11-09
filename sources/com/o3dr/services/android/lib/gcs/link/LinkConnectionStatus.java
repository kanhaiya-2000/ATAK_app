package com.o3dr.services.android.lib.gcs.link;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class LinkConnectionStatus implements Parcelable {
    public static final int ADDRESS_IN_USE = -6;
    public static final String CONNECTED = "CONNECTED";
    public static final String CONNECTING = "CONNECTING";
    public static final Parcelable.Creator<LinkConnectionStatus> CREATOR = new Parcelable.Creator<LinkConnectionStatus>() {
        public LinkConnectionStatus createFromParcel(Parcel parcel) {
            return new LinkConnectionStatus(parcel);
        }

        public LinkConnectionStatus[] newArray(int i) {
            return new LinkConnectionStatus[i];
        }
    };
    public static final String DISCONNECTED = "DISCONNECTED";
    public static final String EXTRA_CONNECTION_TIME = "extra_connection_time";
    public static final String EXTRA_ERROR_CODE = "extra_error_code";
    public static final String EXTRA_ERROR_MSG = "extra_error_message";
    public static final String FAILED = "FAILED";
    public static final int INVALID_CREDENTIALS = -4;
    public static final int LINK_UNAVAILABLE = -2;
    public static final int PERMISSION_DENIED = -3;
    public static final int SYSTEM_UNAVAILABLE = -1;
    public static final int TIMEOUT = -5;
    public static final int UNKNOWN = -7;
    private final Bundle mExtras;
    private final String mStatusCode;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FailureCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusCode {
    }

    public int describeContents() {
        return 0;
    }

    public LinkConnectionStatus(String str, Bundle bundle) {
        this.mStatusCode = str;
        this.mExtras = bundle;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStatusCode);
        parcel.writeBundle(this.mExtras);
    }

    private LinkConnectionStatus(Parcel parcel) {
        this.mStatusCode = parcel.readString();
        this.mExtras = parcel.readBundle();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkConnectionStatus linkConnectionStatus = (LinkConnectionStatus) obj;
        String str = this.mStatusCode;
        if (str == null ? linkConnectionStatus.mStatusCode != null : !str.equals(linkConnectionStatus.mStatusCode)) {
            return false;
        }
        Bundle bundle = this.mExtras;
        Bundle bundle2 = linkConnectionStatus.mExtras;
        if (bundle != null) {
            if (!bundle.equals(bundle2)) {
                return false;
            }
            return true;
        } else if (bundle2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mStatusCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Bundle bundle = this.mExtras;
        if (bundle != null) {
            i = bundle.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ConnectionResult{mStatusCode='" + this.mStatusCode + '\'' + ", mExtras=" + this.mExtras + '}';
    }

    public static LinkConnectionStatus newFailedConnectionStatus(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_ERROR_CODE, i);
        bundle.putString(EXTRA_ERROR_MSG, str);
        return new LinkConnectionStatus(FAILED, bundle);
    }
}
