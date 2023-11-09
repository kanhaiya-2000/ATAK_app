package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import java.nio.ByteBuffer;
import java.util.List;

public class TLVMessageParser {
    private static final String TAG = "TLVMessageParser";

    public static List<TLVPacket> parseTLVPacket(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return parseTLVPacket(ByteBuffer.wrap(bArr));
    }

    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v50 */
    /* JADX WARNING: type inference failed for: r4v51 */
    /* JADX WARNING: type inference failed for: r7v6, types: [com.o3dr.services.android.lib.drone.companion.solo.tlv.ControllerMessageInputReport] */
    /* JADX WARNING: type inference failed for: r4v52 */
    /* JADX WARNING: type inference failed for: r4v53 */
    /* JADX WARNING: type inference failed for: r6v11, types: [com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloCableCamWaypoint] */
    /* JADX WARNING: type inference failed for: r5v27, types: [com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageLocation] */
    /* JADX WARNING: type inference failed for: r4v54 */
    /* JADX WARNING: type inference failed for: r4v55 */
    /* JADX WARNING: type inference failed for: r4v56 */
    /* JADX WARNING: type inference failed for: r4v57 */
    /* JADX WARNING: type inference failed for: r4v58 */
    /* JADX WARNING: type inference failed for: r4v59 */
    /* JADX WARNING: type inference failed for: r4v60 */
    /* JADX WARNING: type inference failed for: r5v28, types: [com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloReturnHomeLocationMessage] */
    /* JADX WARNING: type inference failed for: r4v61 */
    /* JADX WARNING: type inference failed for: r4v62 */
    /* JADX WARNING: type inference failed for: r4v63 */
    /* JADX WARNING: type inference failed for: r4v64 */
    /* JADX WARNING: type inference failed for: r4v65 */
    /* JADX WARNING: type inference failed for: r4v66 */
    /* JADX WARNING: type inference failed for: r4v67 */
    /* JADX WARNING: type inference failed for: r4v68 */
    /* JADX WARNING: type inference failed for: r4v69 */
    /* JADX WARNING: type inference failed for: r4v70 */
    /* JADX WARNING: type inference failed for: r4v71 */
    /* JADX WARNING: type inference failed for: r4v72 */
    /* JADX WARNING: type inference failed for: r4v73 */
    /* JADX WARNING: type inference failed for: r4v74 */
    /* JADX WARNING: type inference failed for: r4v75 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket> parseTLVPacket(java.nio.ByteBuffer r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r14 != 0) goto L_0x0008
            return r0
        L_0x0008:
            int r1 = r14.limit()
            if (r1 > 0) goto L_0x000f
            return r0
        L_0x000f:
            java.nio.ByteOrder r1 = r14.order()
            java.nio.ByteOrder r2 = com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket.TLV_BYTE_ORDER
            r14.order(r2)
            r2 = -1
        L_0x0019:
            int r3 = r14.remaining()     // Catch:{ BufferUnderflowException -> 0x024e }
            r4 = 8
            if (r3 < r4) goto L_0x0264
            int r2 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r3 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r4 = r14.remaining()     // Catch:{ BufferUnderflowException -> 0x024e }
            java.lang.String r5 = TAG     // Catch:{ BufferUnderflowException -> 0x024e }
            java.lang.String r6 = "Received message %d of with value of length %d. Remaining buffer size is %d"
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ BufferUnderflowException -> 0x024e }
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ BufferUnderflowException -> 0x024e }
            r7[r8] = r9     // Catch:{ BufferUnderflowException -> 0x024e }
            r8 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)     // Catch:{ BufferUnderflowException -> 0x024e }
            r7[r8] = r9     // Catch:{ BufferUnderflowException -> 0x024e }
            r8 = 2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            r7[r8] = r9     // Catch:{ BufferUnderflowException -> 0x024e }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ BufferUnderflowException -> 0x024e }
            android.util.Log.d(r5, r6)     // Catch:{ BufferUnderflowException -> 0x024e }
            if (r3 <= r4) goto L_0x0054
            goto L_0x0264
        L_0x0054:
            r4 = 0
            r14.mark()     // Catch:{ BufferUnderflowException -> 0x024e }
            r5 = 28
            if (r2 == r5) goto L_0x022f
            r5 = 119(0x77, float:1.67E-43)
            if (r2 == r5) goto L_0x0229
            r5 = 2003(0x7d3, float:2.807E-42)
            if (r2 == r5) goto L_0x0212
            r5 = 5001(0x1389, float:7.008E-42)
            if (r2 == r5) goto L_0x0203
            r5 = 5003(0x138b, float:7.01E-42)
            if (r2 == r5) goto L_0x01f8
            r5 = 5009(0x1391, float:7.019E-42)
            if (r2 == r5) goto L_0x01e8
            r5 = 10101(0x2775, float:1.4155E-41)
            if (r2 == r5) goto L_0x01e2
            r5 = 10201(0x27d9, float:1.4295E-41)
            if (r2 == r5) goto L_0x01dc
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r5) goto L_0x01cb
            r5 = 1001(0x3e9, float:1.403E-42)
            if (r2 == r5) goto L_0x01b0
            switch(r2) {
                case 0: goto L_0x019e;
                case 1: goto L_0x019e;
                case 2: goto L_0x018a;
                case 3: goto L_0x0183;
                case 4: goto L_0x016f;
                case 5: goto L_0x014e;
                case 6: goto L_0x014e;
                case 7: goto L_0x0147;
                default: goto L_0x0083;
            }     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x0083:
            switch(r2) {
                case 19: goto L_0x0140;
                case 20: goto L_0x0134;
                case 21: goto L_0x012a;
                case 22: goto L_0x0123;
                case 23: goto L_0x011c;
                case 24: goto L_0x0115;
                case 25: goto L_0x010e;
                case 26: goto L_0x00fa;
                default: goto L_0x0086;
            }     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x0086:
            switch(r2) {
                case 50: goto L_0x00f3;
                case 51: goto L_0x00ec;
                case 52: goto L_0x00e5;
                case 53: goto L_0x00de;
                case 54: goto L_0x00d7;
                case 55: goto L_0x00d0;
                case 56: goto L_0x00c9;
                case 57: goto L_0x00c2;
                default: goto L_0x0089;
            }     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x0089:
            switch(r2) {
                case 5005: goto L_0x00bb;
                case 5006: goto L_0x00b4;
                case 5007: goto L_0x00ad;
                default: goto L_0x008c;
            }     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x008c:
            switch(r2) {
                case 10001: goto L_0x00a6;
                case 10002: goto L_0x009f;
                case 10003: goto L_0x0098;
                case 10004: goto L_0x0091;
                default: goto L_0x008f;
            }     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x008f:
            goto L_0x0234
        L_0x0091:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectMoveVehicle r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectMoveVehicle     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x0098:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectMoveGimbal r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectMoveGimbal     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x009f:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectSetWaypoint r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectSetWaypoint     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00a6:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectStart r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect.SoloInspectStart     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00ad:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRequestState r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRequestState     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00b4:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproStateV2 r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproStateV2     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00bb:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproState r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproState     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00c2:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineAttach r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineAttach     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00c9:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineDurations r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineDurations     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00d0:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePathSettings r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePathSettings     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00d7:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePlaybackStatus r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePlaybackStatus     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00de:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineSeek r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineSeek     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00e5:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePoint r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePoint     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00ec:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePlay r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplinePlay     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00f3:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineRecord r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc.SoloSplineRecord     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x00fa:
            double r6 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            double r8 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r10 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloReturnHomeLocationMessage r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloReturnHomeLocationMessage     // Catch:{ BufferUnderflowException -> 0x024e }
            r5 = r4
            r5.<init>(r6, r8, r10)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x010e:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPanoStatus r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPanoStatus     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x0115:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloRewindOptions r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloRewindOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x011c:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloZiplineOptions r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloZiplineOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x0123:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPanoOptions r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPanoOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x012a:
            int r4 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloShotError r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloShotError     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((int) r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x013d
        L_0x0134:
            float r4 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloShotOptions r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloShotOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((float) r4)     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x013d:
            r4 = r5
            goto L_0x0234
        L_0x0140:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloFollowOptions r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloFollowOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x0147:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPause r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloPause     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x014e:
            int r4 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r5 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r6 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r7 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            r8 = 5
            if (r2 != r8) goto L_0x0167
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingGetter r8 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingGetter     // Catch:{ BufferUnderflowException -> 0x024e }
            r8.<init>(r4, r5, r6, r7)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x016c
        L_0x0167:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter r8 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloButtonSettingSetter     // Catch:{ BufferUnderflowException -> 0x024e }
            r8.<init>(r4, r5, r6, r7)     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x016c:
            r4 = r8
            goto L_0x0234
        L_0x016f:
            short r4 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            short r5 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r6 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloCableCamOptions r7 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloCableCamOptions     // Catch:{ BufferUnderflowException -> 0x024e }
            r7.<init>((int) r4, (int) r5, (float) r6)     // Catch:{ BufferUnderflowException -> 0x024e }
            r4 = r7
            goto L_0x0234
        L_0x0183:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageRecordPosition r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageRecordPosition     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x018a:
            double r6 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            double r8 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r10 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageLocation r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageLocation     // Catch:{ BufferUnderflowException -> 0x024e }
            r5 = r4
            r5.<init>(r6, r8, r10)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x019e:
            int r4 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            if (r2 != 0) goto L_0x01aa
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotGetter r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotGetter     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((int) r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x013d
        L_0x01aa:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotSetter r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotSetter     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((int) r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x013d
        L_0x01b0:
            double r7 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            double r9 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r11 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r12 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            float r13 = r14.getFloat()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloCableCamWaypoint r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloCableCamWaypoint     // Catch:{ BufferUnderflowException -> 0x024e }
            r6 = r4
            r6.<init>(r7, r9, r11, r12, r13)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x01cb:
            byte[] r4 = new byte[r3]     // Catch:{ BufferUnderflowException -> 0x024e }
            r14.get(r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotManagerError r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageShotManagerError     // Catch:{ BufferUnderflowException -> 0x024e }
            java.lang.String r6 = new java.lang.String     // Catch:{ BufferUnderflowException -> 0x024e }
            r6.<init>(r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((java.lang.String) r6)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x013d
        L_0x01dc:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.survey.SoloSurveyStart r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.survey.SoloSurveyStart     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x01e2:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.scan.SoloScanStart r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.scan.SoloScanStart     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x01e8:
            short r4 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            r5 = 4
            byte[] r5 = new byte[r5]     // Catch:{ BufferUnderflowException -> 0x024e }
            r14.get(r5)     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetExtendedRequest r6 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetExtendedRequest     // Catch:{ BufferUnderflowException -> 0x024e }
            r6.<init>(r4, r5)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0210
        L_0x01f8:
            int r4 = r14.getInt()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRecord r5 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRecord     // Catch:{ BufferUnderflowException -> 0x024e }
            r5.<init>((int) r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x013d
        L_0x0203:
            short r4 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            short r5 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetRequest r6 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetRequest     // Catch:{ BufferUnderflowException -> 0x024e }
            r6.<init>(r4, r5)     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x0210:
            r4 = r6
            goto L_0x0234
        L_0x0212:
            double r8 = r14.getDouble()     // Catch:{ BufferUnderflowException -> 0x024e }
            short r10 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            short r11 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            short r12 = r14.getShort()     // Catch:{ BufferUnderflowException -> 0x024e }
            com.o3dr.services.android.lib.drone.companion.solo.tlv.ControllerMessageInputReport r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.ControllerMessageInputReport     // Catch:{ BufferUnderflowException -> 0x024e }
            r7 = r4
            r7.<init>(r8, r10, r11, r12)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x0229:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloFollowOptionsV2 r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloFollowOptionsV2     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>((java.nio.ByteBuffer) r14)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0234
        L_0x022f:
            com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloZiplineLock r4 = new com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloZiplineLock     // Catch:{ BufferUnderflowException -> 0x024e }
            r4.<init>()     // Catch:{ BufferUnderflowException -> 0x024e }
        L_0x0234:
            if (r4 == 0) goto L_0x0241
            int r5 = r4.getMessageLength()     // Catch:{ BufferUnderflowException -> 0x024e }
            if (r5 != r3) goto L_0x0241
            r0.add(r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0019
        L_0x0241:
            r14.reset()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r4 = r14.position()     // Catch:{ BufferUnderflowException -> 0x024e }
            int r4 = r4 + r3
            r14.position(r4)     // Catch:{ BufferUnderflowException -> 0x024e }
            goto L_0x0019
        L_0x024e:
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Invalid data for tlv packet of type "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.e(r3, r2)
        L_0x0264:
            r14.order(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageParser.parseTLVPacket(java.nio.ByteBuffer):java.util.List");
    }

    private TLVMessageParser() {
    }
}
