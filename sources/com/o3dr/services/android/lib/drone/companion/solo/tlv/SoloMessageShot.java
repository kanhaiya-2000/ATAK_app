package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.content.Context;
import android.os.Parcel;
import com.o3dr.android.client.C5729R;
import com.o3dr.services.android.lib.drone.property.VehicleMode;
import java.nio.ByteBuffer;

public abstract class SoloMessageShot extends TLVPacket {
    public static final int SHOT_CABLECAM = 2;
    public static final int SHOT_FOLLOW = 5;
    public static final int SHOT_FREE_FLIGHT = -1;
    public static final int SHOT_INSPECT = 100;
    public static final int SHOT_MPCC = 6;
    public static final int SHOT_ORBIT = 1;
    public static final int SHOT_PANO = 7;
    public static final int SHOT_RETURN_HOME = 10;
    public static final int SHOT_REWIND = 8;
    public static final int SHOT_SCAN = 101;
    public static final int SHOT_SELFIE = 0;
    public static final int SHOT_SURVEY = 102;
    public static final int SHOT_TRANSECT = 9;
    public static final int SHOT_ZIPLINE = 3;
    private int shotType;

    public SoloMessageShot(int i, int i2) {
        super(i, 4);
        this.shotType = i2;
    }

    public int getShotType() {
        return this.shotType;
    }

    public void setShotType(int i) {
        this.shotType = i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.shotType);
    }

    public static CharSequence getShotLabel(Context context, int i) {
        if (context == null) {
            return null;
        }
        if (i == -1) {
            return context.getText(C5729R.string.label_free_flight);
        }
        if (i == 0) {
            return context.getText(C5729R.string.label_selfie);
        }
        if (i == 1) {
            return context.getText(C5729R.string.label_orbit);
        }
        if (i != 2) {
            if (i == 3) {
                return context.getString(C5729R.string.label_zipline);
            }
            switch (i) {
                case 5:
                    return context.getText(C5729R.string.label_follow);
                case 6:
                    break;
                case 7:
                    return context.getString(C5729R.string.label_pano);
                case 8:
                    return context.getString(C5729R.string.label_rewind);
                case 9:
                    return context.getString(C5729R.string.label_transect);
                case 10:
                    return context.getString(C5729R.string.label_return_home);
                default:
                    switch (i) {
                        case 100:
                            return context.getString(C5729R.string.label_inspect);
                        case 101:
                            return context.getString(C5729R.string.label_scan);
                        case 102:
                            return context.getString(C5729R.string.label_survey);
                        default:
                            return null;
                    }
            }
        }
        return context.getText(C5729R.string.label_cable_cam);
    }

    /* renamed from: com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShot$1 */
    /* synthetic */ class C58131 {

        /* renamed from: $SwitchMap$com$o3dr$services$android$lib$drone$property$VehicleMode */
        static final /* synthetic */ int[] f8605x2b93d897;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.o3dr.services.android.lib.drone.property.VehicleMode[] r0 = com.o3dr.services.android.lib.drone.property.VehicleMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8605x2b93d897 = r0
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_LOITER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x001d }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_ALT_HOLD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_RTL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_GUIDED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x003e }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_AUTOTUNE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_POSHOLD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8605x2b93d897     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r1 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_AUTO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShot.C58131.<clinit>():void");
        }
    }

    public static CharSequence getFlightModeLabel(Context context, VehicleMode vehicleMode) {
        if (context == null || vehicleMode == null) {
            return null;
        }
        switch (C58131.f8605x2b93d897[vehicleMode.ordinal()]) {
            case 1:
                return context.getText(C5729R.string.copter_loiter_label);
            case 2:
                return context.getText(C5729R.string.copter_alt_hold_label);
            case 3:
                return context.getText(C5729R.string.copter_rtl_label);
            case 4:
                return null;
            case 5:
                return context.getText(C5729R.string.copter_auto_tune_label);
            case 6:
                return context.getText(C5729R.string.copter_pos_hold_label);
            case 7:
                return null;
            default:
                return vehicleMode.getLabel();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.shotType);
    }

    protected SoloMessageShot(Parcel parcel) {
        super(parcel);
        this.shotType = parcel.readInt();
    }
}
