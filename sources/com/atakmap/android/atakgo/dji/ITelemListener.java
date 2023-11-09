package com.atakmap.android.atakgo.dji;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface ITelemListener extends IInterface {

    public static class Default implements ITelemListener {
        public void accessoriesChanged() {
        }

        public IBinder asBinder() {
            return null;
        }

        public void doCamerashot() {
        }

        public void doMapshot() {
        }

        public void formatInternalDone(String str) {
        }

        public void formatSDCardDone(String str) {
        }

        public boolean getUASToolLDMStatus() {
            return false;
        }

        public void onDiagnosticInfoUpdate(List<String> list) {
        }

        public void onHomeUpdate(double d, double d2) {
        }

        public void onObstacleRangeUpdate(double d) {
        }

        public void onOnboardSdkAvailable(boolean z) {
        }

        public void onPlatformConnected(String str, String str2, boolean z, float f, float f2, float f3, float f4, float f5, float f6) {
        }

        public void onPlatformDisconnected() {
        }

        public void onPositionUpdate(double d, double d2, double d3, double d4) {
        }

        public void onPwmChange(int i, int i2) {
        }

        public void onPwmSettingsInit(int i, int i2) {
        }

        public void onSensorAngleUpdate(double d, double d2, double d3) {
        }

        public void onSensorFieldOfViewUpdate(double d, double d2) {
        }

        public void onUASFileDeleted(boolean z, String str, String str2) {
        }

        public void onUASFileLoadComplete(boolean z, String str) {
        }

        public void onUASFileRefreshComplete(boolean z, String str) {
        }

        public void onUASFileStateChange(String str) {
        }

        public void onUASPairingStopped() {
        }

        public void onUASSoundPlaying(boolean z, String str, String str2) {
        }

        public void onUASSoundStopped(boolean z, String str) {
        }

        public void pushBatteryInfo(int i, int i2) {
        }

        public void taskFinished_aidl(String str, String str2) {
        }

        public void taskPrepared_aidl(int i, String str) {
        }

        public void taskRefused_aidl(String str) {
        }

        public void taskStageCompleted_aidl(int i, String str, String str2) {
        }

        public void taskStageStarted_aidl(int i, String str, String str2) {
        }

        public void taskStageUpdate_aidl(int i, int i2, String str, String str2) {
        }

        public void tryTelemUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        }
    }

    void accessoriesChanged();

    void doCamerashot();

    void doMapshot();

    void formatInternalDone(String str);

    void formatSDCardDone(String str);

    boolean getUASToolLDMStatus();

    void onDiagnosticInfoUpdate(List<String> list);

    void onHomeUpdate(double d, double d2);

    void onObstacleRangeUpdate(double d);

    void onOnboardSdkAvailable(boolean z);

    void onPlatformConnected(String str, String str2, boolean z, float f, float f2, float f3, float f4, float f5, float f6);

    void onPlatformDisconnected();

    void onPositionUpdate(double d, double d2, double d3, double d4);

    void onPwmChange(int i, int i2);

    void onPwmSettingsInit(int i, int i2);

    void onSensorAngleUpdate(double d, double d2, double d3);

    void onSensorFieldOfViewUpdate(double d, double d2);

    void onUASFileDeleted(boolean z, String str, String str2);

    void onUASFileLoadComplete(boolean z, String str);

    void onUASFileRefreshComplete(boolean z, String str);

    void onUASFileStateChange(String str);

    void onUASPairingStopped();

    void onUASSoundPlaying(boolean z, String str, String str2);

    void onUASSoundStopped(boolean z, String str);

    void pushBatteryInfo(int i, int i2);

    void taskFinished_aidl(String str, String str2);

    void taskPrepared_aidl(int i, String str);

    void taskRefused_aidl(String str);

    void taskStageCompleted_aidl(int i, String str, String str2);

    void taskStageStarted_aidl(int i, String str, String str2);

    void taskStageUpdate_aidl(int i, int i2, String str, String str2);

    void tryTelemUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7);

    public static abstract class Stub extends Binder implements ITelemListener {
        private static final String DESCRIPTOR = "com.atakmap.android.atakgo.dji.ITelemListener";
        static final int TRANSACTION_accessoriesChanged = 10;
        static final int TRANSACTION_doCamerashot = 31;
        static final int TRANSACTION_doMapshot = 30;
        static final int TRANSACTION_formatInternalDone = 19;
        static final int TRANSACTION_formatSDCardDone = 18;
        static final int TRANSACTION_getUASToolLDMStatus = 32;
        static final int TRANSACTION_onDiagnosticInfoUpdate = 23;
        static final int TRANSACTION_onHomeUpdate = 8;
        static final int TRANSACTION_onObstacleRangeUpdate = 22;
        static final int TRANSACTION_onOnboardSdkAvailable = 7;
        static final int TRANSACTION_onPlatformConnected = 9;
        static final int TRANSACTION_onPlatformDisconnected = 21;
        static final int TRANSACTION_onPositionUpdate = 1;
        static final int TRANSACTION_onPwmChange = 5;
        static final int TRANSACTION_onPwmSettingsInit = 6;
        static final int TRANSACTION_onSensorAngleUpdate = 2;
        static final int TRANSACTION_onSensorFieldOfViewUpdate = 3;
        static final int TRANSACTION_onUASFileDeleted = 14;
        static final int TRANSACTION_onUASFileLoadComplete = 13;
        static final int TRANSACTION_onUASFileRefreshComplete = 12;
        static final int TRANSACTION_onUASFileStateChange = 11;
        static final int TRANSACTION_onUASPairingStopped = 17;
        static final int TRANSACTION_onUASSoundPlaying = 15;
        static final int TRANSACTION_onUASSoundStopped = 16;
        static final int TRANSACTION_pushBatteryInfo = 20;
        static final int TRANSACTION_taskFinished_aidl = 29;
        static final int TRANSACTION_taskPrepared_aidl = 24;
        static final int TRANSACTION_taskRefused_aidl = 25;
        static final int TRANSACTION_taskStageCompleted_aidl = 28;
        static final int TRANSACTION_taskStageStarted_aidl = 26;
        static final int TRANSACTION_taskStageUpdate_aidl = 27;
        static final int TRANSACTION_tryTelemUpdate = 4;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITelemListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITelemListener)) {
                return new Proxy(iBinder);
            }
            return (ITelemListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            if (i3 != 1598968902) {
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onPositionUpdate(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 2:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onSensorAngleUpdate(parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 3:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onSensorFieldOfViewUpdate(parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 4:
                        parcel3.enforceInterface(DESCRIPTOR);
                        tryTelemUpdate(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 5:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onPwmChange(parcel.readInt(), parcel.readInt());
                        return true;
                    case 6:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onPwmSettingsInit(parcel.readInt(), parcel.readInt());
                        return true;
                    case 7:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onOnboardSdkAvailable(z);
                        return true;
                    case 8:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onHomeUpdate(parcel.readDouble(), parcel.readDouble());
                        return true;
                    case 9:
                        parcel3.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onPlatformConnected(readString, readString2, z, parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                        return true;
                    case 10:
                        parcel3.enforceInterface(DESCRIPTOR);
                        accessoriesChanged();
                        return true;
                    case 11:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onUASFileStateChange(parcel.readString());
                        return true;
                    case 12:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onUASFileRefreshComplete(z, parcel.readString());
                        return true;
                    case 13:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onUASFileLoadComplete(z, parcel.readString());
                        return true;
                    case 14:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onUASFileDeleted(z, parcel.readString(), parcel.readString());
                        return true;
                    case 15:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onUASSoundPlaying(z, parcel.readString(), parcel.readString());
                        return true;
                    case 16:
                        parcel3.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        onUASSoundStopped(z, parcel.readString());
                        return true;
                    case 17:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onUASPairingStopped();
                        return true;
                    case 18:
                        parcel3.enforceInterface(DESCRIPTOR);
                        formatSDCardDone(parcel.readString());
                        return true;
                    case 19:
                        parcel3.enforceInterface(DESCRIPTOR);
                        formatInternalDone(parcel.readString());
                        return true;
                    case 20:
                        parcel3.enforceInterface(DESCRIPTOR);
                        pushBatteryInfo(parcel.readInt(), parcel.readInt());
                        return true;
                    case 21:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onPlatformDisconnected();
                        return true;
                    case 22:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onObstacleRangeUpdate(parcel.readDouble());
                        return true;
                    case 23:
                        parcel3.enforceInterface(DESCRIPTOR);
                        onDiagnosticInfoUpdate(parcel.createStringArrayList());
                        return true;
                    case 24:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskPrepared_aidl(parcel.readInt(), parcel.readString());
                        return true;
                    case 25:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskRefused_aidl(parcel.readString());
                        return true;
                    case 26:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskStageStarted_aidl(parcel.readInt(), parcel.readString(), parcel.readString());
                        return true;
                    case 27:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskStageUpdate_aidl(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                        return true;
                    case 28:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskStageCompleted_aidl(parcel.readInt(), parcel.readString(), parcel.readString());
                        return true;
                    case 29:
                        parcel3.enforceInterface(DESCRIPTOR);
                        taskFinished_aidl(parcel.readString(), parcel.readString());
                        return true;
                    case 30:
                        parcel3.enforceInterface(DESCRIPTOR);
                        doMapshot();
                        return true;
                    case 31:
                        parcel3.enforceInterface(DESCRIPTOR);
                        doCamerashot();
                        return true;
                    case 32:
                        parcel3.enforceInterface(DESCRIPTOR);
                        boolean uASToolLDMStatus = getUASToolLDMStatus();
                        parcel2.writeNoException();
                        parcel4.writeInt(uASToolLDMStatus ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements ITelemListener {
            public static ITelemListener sDefaultImpl;
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

            public void onPositionUpdate(double d, double d2, double d3, double d4) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    double d5 = d;
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    obtain.writeDouble(d4);
                    try {
                        if (this.mRemote.transact(1, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onPositionUpdate(d, d2, d3, d4);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void onSensorAngleUpdate(double d, double d2, double d3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    if (this.mRemote.transact(2, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSensorAngleUpdate(d, d2, d3);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onSensorFieldOfViewUpdate(double d, double d2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onSensorFieldOfViewUpdate(d, d2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void tryTelemUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    obtain.writeDouble(d3);
                    obtain.writeDouble(d4);
                    obtain.writeDouble(d5);
                    obtain.writeDouble(d6);
                    obtain.writeDouble(d7);
                    if (this.mRemote.transact(4, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().tryTelemUpdate(d, d2, d3, d4, d5, d6, d7);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPwmChange(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(5, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPwmChange(i, i2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPwmSettingsInit(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(6, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPwmSettingsInit(i, i2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onOnboardSdkAvailable(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(7, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onOnboardSdkAvailable(z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onHomeUpdate(double d, double d2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    obtain.writeDouble(d2);
                    if (this.mRemote.transact(8, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onHomeUpdate(d, d2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPlatformConnected(String str, String str2, boolean z, float f, float f2, float f3, float f4, float f5, float f6) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    String str3 = str;
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    obtain.writeFloat(f3);
                    obtain.writeFloat(f4);
                    obtain.writeFloat(f5);
                    obtain.writeFloat(f6);
                    try {
                        if (this.mRemote.transact(9, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                            obtain.recycle();
                            return;
                        }
                        Stub.getDefaultImpl().onPlatformConnected(str, str2, z, f, f2, f3, f4, f5, f6);
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain.recycle();
                    throw th;
                }
            }

            public void accessoriesChanged() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().accessoriesChanged();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASFileStateChange(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(11, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASFileStateChange(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASFileRefreshComplete(boolean z, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    if (this.mRemote.transact(12, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASFileRefreshComplete(z, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASFileLoadComplete(boolean z, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    if (this.mRemote.transact(13, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASFileLoadComplete(z, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASFileDeleted(boolean z, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(14, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASFileDeleted(z, str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASSoundPlaying(boolean z, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(15, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASSoundPlaying(z, str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASSoundStopped(boolean z, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    if (this.mRemote.transact(16, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASSoundStopped(z, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onUASPairingStopped() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(17, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onUASPairingStopped();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void formatSDCardDone(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(18, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().formatSDCardDone(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void formatInternalDone(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(19, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().formatInternalDone(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void pushBatteryInfo(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(20, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().pushBatteryInfo(i, i2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onPlatformDisconnected() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(21, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onPlatformDisconnected();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onObstacleRangeUpdate(double d) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeDouble(d);
                    if (this.mRemote.transact(22, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onObstacleRangeUpdate(d);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void onDiagnosticInfoUpdate(List<String> list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(23, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().onDiagnosticInfoUpdate(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskPrepared_aidl(int i, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(24, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskPrepared_aidl(i, str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskRefused_aidl(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(25, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskRefused_aidl(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskStageStarted_aidl(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(26, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskStageStarted_aidl(i, str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskStageUpdate_aidl(int i, int i2, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(27, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskStageUpdate_aidl(i, i2, str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskStageCompleted_aidl(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(28, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskStageCompleted_aidl(i, str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void taskFinished_aidl(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(29, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().taskFinished_aidl(str, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void doMapshot() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(30, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().doMapshot();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void doCamerashot() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(31, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().doCamerashot();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public boolean getUASToolLDMStatus() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUASToolLDMStatus();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITelemListener iTelemListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iTelemListener == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iTelemListener;
                return true;
            }
        }

        public static ITelemListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
