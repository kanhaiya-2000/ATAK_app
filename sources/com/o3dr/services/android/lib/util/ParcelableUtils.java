package com.o3dr.services.android.lib.util;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUtils {
    private ParcelableUtils() {
    }

    public static byte[] marshall(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    private static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static <T> T unmarshall(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel unmarshall = unmarshall(bArr);
        T createFromParcel = creator.createFromParcel(unmarshall);
        unmarshall.recycle();
        return createFromParcel;
    }

    private static Parcel unmarshall(byte[] bArr, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i, i2);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static <T> T unmarshall(byte[] bArr, int i, int i2, Parcelable.Creator<T> creator) {
        Parcel unmarshall = unmarshall(bArr, i, i2);
        T createFromParcel = creator.createFromParcel(unmarshall);
        unmarshall.recycle();
        return createFromParcel;
    }
}
