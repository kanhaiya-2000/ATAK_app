package com.o3dr.services.android.lib.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;

public interface IMavlinkObserver extends IInterface {
    void onMavlinkMessageReceived(MavlinkMessageWrapper mavlinkMessageWrapper);

    public static abstract class Stub extends Binder implements IMavlinkObserver {
        private static final String DESCRIPTOR = "com.o3dr.services.android.lib.model.IMavlinkObserver";
        static final int TRANSACTION_onMavlinkMessageReceived = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMavlinkObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMavlinkObserver)) {
                return new Proxy(iBinder);
            }
            return (IMavlinkObserver) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onMavlinkMessageReceived(parcel.readInt() != 0 ? MavlinkMessageWrapper.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IMavlinkObserver {
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

            public void onMavlinkMessageReceived(MavlinkMessageWrapper mavlinkMessageWrapper) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (mavlinkMessageWrapper != null) {
                        obtain.writeInt(1);
                        mavlinkMessageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
