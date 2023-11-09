package com.atakmap.android.uastool.generic;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import java.util.UUID;

public class GenericUASItem extends UASItem {
    public static final String DETAIL_TAG = "_Generic";
    public static final String DISPLAY_NAME = "Generic";

    public boolean isStale() {
        return false;
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public GenericUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public GenericUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (GenericSettingsScreen) layoutInflater.inflate(C1877R.layout.generic_settings_layout, (ViewGroup) null);
    }

    public void updateStatusData() {
        super.updateStatusData();
    }

    public String getVideoUrl() {
        if (isConnected()) {
            return UASToolDropDownReceiver.getSharedPrefs().getString(GenericPrefHandler.PREF_VIDEO_SRC_URI, "");
        }
        return super.getVideoUrl();
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        final String string = sharedPrefs.getString(GenericPrefHandler.PREF_COT_DEST_IP, (String) null);
        String string2 = sharedPrefs.getString(GenericPrefHandler.PREF_COT_DEST_PORT, (String) null);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            try {
                final int parseInt = Integer.parseInt(string2);
                CoordinatedTime coordinatedTime = new CoordinatedTime();
                CotEvent cotEvent = new CotEvent();
                cotEvent.setVersion("2.0");
                cotEvent.setUID(UUID.randomUUID().toString());
                cotEvent.setTime(coordinatedTime);
                cotEvent.setStart(coordinatedTime);
                cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
                cotEvent.setHow("m-g");
                cotEvent.setType(UASToolConstants.UAS_HOME_TYPE);
                cotEvent.setPoint(new CotPoint(geoPoint));
                CotDetail cotDetail = new CotDetail();
                cotEvent.setDetail(cotDetail);
                CotDetail cotDetail2 = new CotDetail("control");
                cotDetail2.setAttribute("entity", "AEROCOMPUTERS-*");
                cotDetail2.setAttribute(FlightLogger.LOCS_COMMAND, "SetTarget");
                cotDetail.addChild(cotDetail2);
                final byte[] bytes = cotEvent.toString().getBytes();
                new Thread(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038 A[SYNTHETIC, Splitter:B:18:0x0038] */
                    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r7 = this;
                            r0 = 0
                            java.lang.String r1 = r1     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            java.net.DatagramPacket r2 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            byte[] r3 = r7     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            int r4 = r3.length     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            int r5 = r0     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            r2.<init>(r3, r4, r1, r5)     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            r1.<init>()     // Catch:{ Exception -> 0x0024, all -> 0x001f }
                            r1.send(r2)     // Catch:{ Exception -> 0x001d }
                        L_0x0019:
                            r1.close()     // Catch:{ Exception -> 0x0034 }
                            goto L_0x0034
                        L_0x001d:
                            r0 = move-exception
                            goto L_0x0028
                        L_0x001f:
                            r1 = move-exception
                            r6 = r1
                            r1 = r0
                            r0 = r6
                            goto L_0x0036
                        L_0x0024:
                            r1 = move-exception
                            r6 = r1
                            r1 = r0
                            r0 = r6
                        L_0x0028:
                            java.lang.String r2 = com.atakmap.android.uastool.generic.GenericUASItem.TAG     // Catch:{ all -> 0x0035 }
                            java.lang.String r3 = "Could not send message to "
                            com.atakmap.coremap.log.Log.d(r2, r3, r0)     // Catch:{ all -> 0x0035 }
                            if (r1 == 0) goto L_0x0034
                            goto L_0x0019
                        L_0x0034:
                            return
                        L_0x0035:
                            r0 = move-exception
                        L_0x0036:
                            if (r1 == 0) goto L_0x003b
                            r1.close()     // Catch:{ Exception -> 0x003b }
                        L_0x003b:
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.generic.GenericUASItem.C15011.run():void");
                    }
                }).start();
            } catch (Exception unused) {
            }
        }
    }
}
