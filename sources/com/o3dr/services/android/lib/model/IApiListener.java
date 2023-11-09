package com.o3dr.services.android.lib.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.o3dr.services.android.lib.drone.connection.ConnectionResult;

public interface IApiListener extends IInterface {
    int getApiVersionCode();

    int getClientVersionCode();

    void onConnectionFailed(ConnectionResult connectionResult);

    public static abstract class Stub extends Binder implements IApiListener {
        private static final String DESCRIPTOR = "com.o3dr.services.android.lib.model.IApiListener";
        static final int TRANSACTION_getApiVersionCode = 1;
        static final int TRANSACTION_getClientVersionCode = 3;
        static final int TRANSACTION_onConnectionFailed = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IApiListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IApiListener)) {
                return new Proxy(iBinder);
            }
            return (IApiListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int apiVersionCode = getApiVersionCode();
                parcel2.writeNoException();
                parcel2.writeInt(apiVersionCode);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onConnectionFailed(parcel.readInt() != 0 ? ConnectionResult.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                int clientVersionCode = getClientVersionCode();
                parcel2.writeNoException();
                parcel2.writeInt(clientVersionCode);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IApiListener {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int getApiVersionCode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onConnectionFailed(ConnectionResult connectionResult) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (connectionResult != null) {
                        obtain.writeInt(1);
                        connectionResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public int getClientVersionCode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
