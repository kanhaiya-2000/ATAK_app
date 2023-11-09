package com.atakmap.android.uastool.pagers.avahi;

import android.net.nsd.NsdServiceInfo;
import com.atakmap.coremap.log.Log;
import com.google.gson.annotations.SerializedName;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvahiServiceInfo {
    private static final String TAG = "AvahiServiceInfo";
    @SerializedName("attributes")
    private final Map<String, String> attributes;
    private InetAddress host;
    @SerializedName("ipAddress")
    private String ipAddress;
    private final AtomicBoolean isVisible = new AtomicBoolean(false);
    @SerializedName("port")
    private int port;
    @SerializedName("serviceName")
    private String serviceName;
    @SerializedName("serviceType")
    private String serviceType;

    public AvahiServiceInfo(NsdServiceInfo nsdServiceInfo) {
        this.serviceName = nsdServiceInfo.getServiceName();
        this.serviceType = nsdServiceInfo.getServiceType();
        this.port = nsdServiceInfo.getPort();
        setHost(nsdServiceInfo.getHost());
        Map<String, byte[]> attributes2 = nsdServiceInfo.getAttributes();
        this.attributes = new HashMap();
        for (String next : attributes2.keySet()) {
            byte[] bArr = nsdServiceInfo.getAttributes().get(next);
            if (bArr != null) {
                try {
                    this.attributes.put(next, new String(bArr));
                } catch (Exception e) {
                    this.attributes.put(next, "");
                    Log.e(TAG, "error adding attribute", e);
                }
            } else {
                this.attributes.put(next, "");
            }
        }
    }

    public AvahiServiceInfo(String str, String str2, int i, Map<String, String> map) {
        this.serviceName = str;
        this.serviceType = str2;
        this.port = i;
        this.attributes = map;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public InetAddress getHost() {
        return this.host;
    }

    public String getIpAddress() {
        Map<String, String> map = this.attributes;
        if (map == null || !map.containsKey("ip")) {
            return this.ipAddress;
        }
        return this.attributes.get("ip");
    }

    public void setHost(InetAddress inetAddress) {
        this.host = inetAddress;
        byte[] address = inetAddress.getAddress();
        if (address.length >= 4) {
            this.ipAddress = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(address[0] & 255), Integer.valueOf(address[1] & 255), Integer.valueOf(address[2] & 255), Integer.valueOf(address[3] & 255)});
        }
    }

    public void setHost(String str) {
        this.ipAddress = str;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public boolean isVisible() {
        return this.isVisible.get();
    }

    public void setVisible(boolean z) {
        this.isVisible.set(z);
    }
}
