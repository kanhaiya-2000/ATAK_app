package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection;

import android.util.Log;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.engine.MavlinkIpConst;

public class MavlinkUdpSocket extends MavlinkUdpConnection {
    private static MavlinkUdpSocket instance_;
    private String mUrl_Route = MavlinkIpConst.getFlyRouteAddr();
    private String mUrl_Rtsp = MavlinkIpConst.getFlyRtspAddr();

    /* access modifiers changed from: protected */
    public int loadServerPort() {
        return 14550;
    }

    public static MavlinkUdpSocket getInstance_() {
        if (instance_ == null) {
            instance_ = new MavlinkUdpSocket();
        }
        return instance_;
    }

    private MavlinkUdpSocket() {
    }

    /* access modifiers changed from: protected */
    public String GetRouteHost() {
        Log.d("MavlinkUdpSocket", "GetRouteHost url=" + this.mUrl_Route + " " + this);
        return this.mUrl_Route;
    }

    /* access modifiers changed from: protected */
    public String GetRtspHost() {
        Log.d("MavlinkUdpSocket", "GetRtspHost url=" + this.mUrl_Rtsp);
        return this.mUrl_Rtsp;
    }

    /* access modifiers changed from: protected */
    public boolean isUseUsbTransfer() {
        return AutelUSBHelper.instance().isUsbOpened();
    }
}
