package com.atakmap.android.uastool.mavlink;

import android.app.Activity;
import android.content.Context;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.utils.AvahiService;
import java.util.ArrayList;
import java.util.HashMap;

public class MavlinkAvahiService extends AvahiService {
    private static ArrayList<String> services;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        services = arrayList;
        arrayList.add(AvahiService.SERVICE_TYPE_MAVLINK_TCP);
        services.add(AvahiService.SERVICE_TYPE_MAVLINK_UDP);
        services.add(AvahiService.SERVICE_TYPE_MAVLINK_UDPC);
        services.add("_axis-video._tcp");
    }

    public MavlinkAvahiService(Context context) {
        super(context, services);
        addCustomServices();
    }

    public void clear() {
        this.mServiceInfo.clear();
        addCustomServices();
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                MavlinkAvahiService.this.listChanged();
            }
        });
    }

    private void addCustomServices() {
        HashMap hashMap = new HashMap();
        hashMap.put("uri", MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI);
        this.mServiceInfo.add(new AvahiServiceInfo("Mavlink UDP", AvahiService.SERVICE_TYPE_MAVLINK_UDP, 14550, hashMap));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("uri", "rtsp://192.168.42.1/live");
        hashMap2.put("ip", "192.168.42.1");
        this.mServiceInfo.add(new AvahiServiceInfo("Anafi Wifi", AvahiService.SERVICE_TYPE_MAVLINK_UDP, 14550, hashMap2));
        this.mServiceInfo.add(new AvahiServiceInfo("Anafi USB", AvahiService.SERVICE_TYPE_MAVLINK_UDPC, 14551, hashMap2));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("uri", "rtsp://192.168.0.10:8554/H264Video");
        this.mServiceInfo.add(new AvahiServiceInfo("Herelink", AvahiService.SERVICE_TYPE_MAVLINK_UDP, 14551, hashMap3));
        HashMap hashMap4 = new HashMap();
        hashMap4.put("uri", MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI);
        hashMap4.put("uri2", "rtp://0.0.0.0:5602");
        hashMap4.put("ip", "192.168.42.10");
        this.mServiceInfo.add(new AvahiServiceInfo("Skydio X2", AvahiService.SERVICE_TYPE_MAVLINK_UDPC, 15667, hashMap4));
    }
}
