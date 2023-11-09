package com.o3dr.services.android.lib.model;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.IMavlinkObserver;
import com.o3dr.services.android.lib.model.IObserver;
import com.o3dr.services.android.lib.model.action.Action;

public interface IDroneApi extends IInterface {
    void addAttributesObserver(IObserver iObserver);

    void addMavlinkObserver(IMavlinkObserver iMavlinkObserver);

    void executeAction(Action action, ICommandListener iCommandListener);

    void executeAsyncAction(Action action, ICommandListener iCommandListener);

    Bundle getAttribute(String str);

    void performAction(Action action);

    void performAsyncAction(Action action);

    void removeAttributesObserver(IObserver iObserver);

    void removeMavlinkObserver(IMavlinkObserver iMavlinkObserver);

    public static abstract class Stub extends Binder implements IDroneApi {
        private static final String DESCRIPTOR = "com.o3dr.services.android.lib.model.IDroneApi";
        static final int TRANSACTION_addAttributesObserver = 4;
        static final int TRANSACTION_addMavlinkObserver = 6;
        static final int TRANSACTION_executeAction = 8;
        static final int TRANSACTION_executeAsyncAction = 9;
        static final int TRANSACTION_getAttribute = 1;
        static final int TRANSACTION_performAction = 2;
        static final int TRANSACTION_performAsyncAction = 3;
        static final int TRANSACTION_removeAttributesObserver = 5;
        static final int TRANSACTION_removeMavlinkObserver = 7;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDroneApi asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDroneApi)) {
                return new Proxy(iBinder);
            }
            return (IDroneApi) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                Action action = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        Bundle attribute = getAttribute(parcel.readString());
                        parcel2.writeNoException();
                        if (attribute != null) {
                            parcel2.writeInt(1);
                            attribute.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            action = Action.CREATOR.createFromParcel(parcel);
                        }
                        performAction(action);
                        parcel2.writeNoException();
                        if (action != null) {
                            parcel2.writeInt(1);
                            action.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            action = Action.CREATOR.createFromParcel(parcel);
                        }
                        performAsyncAction(action);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        addAttributesObserver(IObserver.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        removeAttributesObserver(IObserver.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        addMavlinkObserver(IMavlinkObserver.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        removeMavlinkObserver(IMavlinkObserver.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            action = Action.CREATOR.createFromParcel(parcel);
                        }
                        executeAction(action, ICommandListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        if (action != null) {
                            parcel2.writeInt(1);
                            action.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            action = Action.CREATOR.createFromParcel(parcel);
                        }
                        executeAsyncAction(action, ICommandListener.Stub.asInterface(parcel.readStrongBinder()));
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IDroneApi {
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

            public Bundle getAttribute(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void performAction(Action action) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (action != null) {
                        obtain.writeInt(1);
                        action.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        action.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void performAsyncAction(Action action) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (action != null) {
                        obtain.writeInt(1);
                        action.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void addAttributesObserver(IObserver iObserver) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObserver != null ? iObserver.asBinder() : null);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void removeAttributesObserver(IObserver iObserver) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObserver != null ? iObserver.asBinder() : null);
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void addMavlinkObserver(IMavlinkObserver iMavlinkObserver) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMavlinkObserver != null ? iMavlinkObserver.asBinder() : null);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void removeMavlinkObserver(IMavlinkObserver iMavlinkObserver) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMavlinkObserver != null ? iMavlinkObserver.asBinder() : null);
                    this.mRemote.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void executeAction(Action action, ICommandListener iCommandListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (action != null) {
                        obtain.writeInt(1);
                        action.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iCommandListener != null ? iCommandListener.asBinder() : null);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        action.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void executeAsyncAction(Action action, ICommandListener iCommandListener) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (action != null) {
                        obtain.writeInt(1);
                        action.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iCommandListener != null ? iCommandListener.asBinder() : null);
                    this.mRemote.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
