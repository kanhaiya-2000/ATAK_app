package com.atakmap.android.uastool.r80d;

import android.widget.TextView;
import com.aeryon.java.command.CommandStateCallback;
import com.aeryon.java.types.COMMAND_STATE;

public class R80dSettingsScreenCallback extends CommandStateCallback {
    private static final String TAG = "R80dSettingsScreenCallback";
    private final TextView fieldValue;
    private final String newValue;

    public enum R80ValueType {
        MAX_ALT,
        MAX_DIST,
        HOME_PCT,
        HOME_ALT,
        HOME_SPEED,
        LED_VALUE,
        LED_FAULT,
        FAULT_ACTION,
        COMMS_LOSS_ACTION,
        CRUISE_SPEED
    }

    public R80dSettingsScreenCallback(TextView textView, String str) {
        this.fieldValue = textView;
        this.newValue = str;
    }

    public void callback(COMMAND_STATE command_state) {
        if (command_state == COMMAND_STATE.Complete || command_state == COMMAND_STATE.Active) {
            this.fieldValue.setText(this.newValue);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0018 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019 A[SYNTHETIC, Splitter:B:13:0x0019] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void tryParseUpdate(com.aeryon.java.types.Aircraft r4, android.widget.TextView r5, java.lang.String r6, double r7, com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType r9) {
        /*
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r0 = r0 / r7
            r7 = 1
            float r8 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0011 }
            double r2 = (double) r8
            double r2 = r2 * r0
            float r8 = (float) r2
            int r0 = java.lang.Math.round(r8)     // Catch:{ Exception -> 0x0012 }
            goto L_0x0014
        L_0x0011:
            r8 = 1
        L_0x0012:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0014:
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0019
            return
        L_0x0019:
            int[] r7 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.C20501.f8411x855b9a6f     // Catch:{ Exception -> 0x00e6 }
            int r9 = r9.ordinal()     // Catch:{ Exception -> 0x00e6 }
            r7 = r7[r9]     // Catch:{ Exception -> 0x00e6 }
            switch(r7) {
                case 1: goto L_0x00d8;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00b0;
                case 4: goto L_0x00a2;
                case 5: goto L_0x008d;
                case 6: goto L_0x007b;
                case 7: goto L_0x0065;
                case 8: goto L_0x004f;
                case 9: goto L_0x0039;
                case 10: goto L_0x0026;
                default: goto L_0x0024;
            }     // Catch:{ Exception -> 0x00e6 }
        L_0x0024:
            goto L_0x00f3
        L_0x0026:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r6 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.util.ae r7 = com.atakmap.android.util.ae.a()     // Catch:{ Exception -> 0x00e6 }
            double r0 = (double) r8     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = r7.a(r0)     // Catch:{ Exception -> 0x00e6 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x00e6 }
            r4.setRecoverySpeed(r8, r6)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x0039:
            com.aeryon.java.types.FAULT_ACTION r6 = com.aeryon.java.types.FAULT_ACTION.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r7 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.aeryon.java.types.FAULT_ACTION r8 = com.aeryon.java.types.FAULT_ACTION.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x00e6 }
            r4.setCommsLossAction(r6, r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x004f:
            com.aeryon.java.types.FAULT_ACTION r6 = com.aeryon.java.types.FAULT_ACTION.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r7 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.aeryon.java.types.FAULT_ACTION r8 = com.aeryon.java.types.FAULT_ACTION.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x00e6 }
            r4.setInFlightFaultAction(r6, r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x0065:
            com.aeryon.java.types.LIGHT_FAULT_MODE r6 = com.aeryon.java.types.LIGHT_FAULT_MODE.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r7 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.aeryon.java.types.LIGHT_FAULT_MODE r8 = com.aeryon.java.types.LIGHT_FAULT_MODE.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x00e6 }
            r4.setLightFaultMode(r6, r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x007b:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r6 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.util.ae r7 = com.atakmap.android.util.ae.a()     // Catch:{ Exception -> 0x00e6 }
            double r0 = (double) r8     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = r7.a(r0)     // Catch:{ Exception -> 0x00e6 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x00e6 }
            r4.setCruiseSpeed(r8, r6)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x008d:
            com.aeryon.java.types.LIGHT_MODE r6 = com.aeryon.java.types.LIGHT_MODE.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r7 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            com.aeryon.java.types.LIGHT_MODE r8 = com.aeryon.java.types.LIGHT_MODE.fromInt(r0)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r5, r8)     // Catch:{ Exception -> 0x00e6 }
            r4.setLightMode(r6, r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x00a2:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r6 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            double r0 = (double) r8     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = com.atakmap.android.uastool.utils.Utils.formatRange(r0)     // Catch:{ Exception -> 0x00e6 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x00e6 }
            r4.setMaximumRange(r8, r6)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x00b0:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r7 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e6 }
            r8.<init>()     // Catch:{ Exception -> 0x00e6 }
            r8.append(r6)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r6 = "s"
            r8.append(r6)     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x00e6 }
            r7.<init>(r5, r6)     // Catch:{ Exception -> 0x00e6 }
            r4.setBatteryMargin(r0, r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x00ca:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r6 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            double r0 = (double) r8     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = com.atakmap.android.uastool.utils.Utils.formatAlt(r0)     // Catch:{ Exception -> 0x00e6 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x00e6 }
            r4.setMinimumSafeAltitude(r8, r6)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x00d8:
            com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback r6 = new com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback     // Catch:{ Exception -> 0x00e6 }
            double r0 = (double) r8     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r7 = com.atakmap.android.uastool.utils.Utils.formatAlt(r0)     // Catch:{ Exception -> 0x00e6 }
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x00e6 }
            r4.setMaxAltitude(r8, r6)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f3
        L_0x00e6:
            r4 = move-exception
            java.lang.String r5 = "R80dSettingsScreenCallback"
            java.lang.String r6 = "R80D, error setting Value"
            com.atakmap.coremap.log.Log.e(r5, r6, r4)
            java.lang.String r4 = "Error setting Value"
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r4)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.tryParseUpdate(com.aeryon.java.types.Aircraft, android.widget.TextView, java.lang.String, double, com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType):void");
    }

    /* renamed from: com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$1 */
    /* synthetic */ class C20501 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$r80d$R80dSettingsScreenCallback$R80ValueType */
        static final /* synthetic */ int[] f8411x855b9a6f;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType[] r0 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8411x855b9a6f = r0
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.MAX_ALT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.HOME_ALT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.HOME_PCT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.MAX_DIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.LED_VALUE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.CRUISE_SPEED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.LED_FAULT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.FAULT_ACTION     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x006c }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.COMMS_LOSS_ACTION     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8411x855b9a6f     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback$R80ValueType r1 = com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.R80ValueType.HOME_SPEED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback.C20501.<clinit>():void");
        }
    }
}
