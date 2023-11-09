package com.o3dr.services.android.lib.model;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.o3dr.services.android.lib.model.IApiListener;
import com.o3dr.services.android.lib.model.IDroneApi;

public interface IDroidPlannerServices extends IInterface {
    int getApiVersionCode();

    Bundle[] getConnectedApps(String str);

    int getServiceVersionCode();

    IDroneApi registerDroneApi(IApiListener iApiListener, String str);

    void releaseDroneApi(IDroneApi iDroneApi);

    public static abstract class Stub extends Binder implements IDroidPlannerServices {
        private static final String DESCRIPTOR = "com.o3dr.services.android.lib.model.IDroidPlannerServices";
        static final int TRANSACTION_getApiVersionCode = 3;
        static final int TRANSACTION_getConnectedApps = 5;
        static final int TRANSACTION_getServiceVersionCode = 1;
        static final int TRANSACTION_registerDroneApi = 4;
        static final int TRANSACTION_releaseDroneApi = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDroidPlannerServices asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDroidPlannerServices)) {
                return new Proxy(iBinder);
            }
            return (IDroidPlannerServices) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int serviceVersionCode = getServiceVersionCode();
                parcel2.writeNoException();
                parcel2.writeInt(serviceVersionCode);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                releaseDroneApi(IDroneApi.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                int apiVersionCode = getApiVersionCode();
                parcel2.writeNoException();
                parcel2.writeInt(apiVersionCode);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                IDroneApi registerDroneApi = registerDroneApi(IApiListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                if (registerDroneApi != null) {
                    iBinder = registerDroneApi.asBinder();
                } else {
                    iBinder = null;
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle[] connectedApps = getConnectedApps(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedArray(connectedApps, 1);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IDroidPlannerServices {
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

            public int getServiceVersionCode() {
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

            public void releaseDroneApi(IDroneApi iDroneApi) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDroneApi != null ? iDroneApi.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getApiVersionCode() {
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

            public IDroneApi registerDroneApi(IApiListener iApiListener, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iApiListener != null ? iApiListener.asBinder() : null);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return IDroneApi.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle[] getConnectedApps(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle[]) obtain2.createTypedArray(Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
