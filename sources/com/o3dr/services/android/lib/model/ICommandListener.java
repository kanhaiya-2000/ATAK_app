package com.o3dr.services.android.lib.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ICommandListener extends IInterface {
    void onError(int i);

    void onSuccess();

    void onTimeout();

    public static abstract class Stub extends Binder implements ICommandListener {
        private static final String DESCRIPTOR = "com.o3dr.services.android.lib.model.ICommandListener";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;
        static final int TRANSACTION_onTimeout = 3;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICommandListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICommandListener)) {
                return new Proxy(iBinder);
            }
            return (ICommandListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onError(parcel.readInt());
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onTimeout();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements ICommandListener {
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

            public void onSuccess() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onTimeout() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
