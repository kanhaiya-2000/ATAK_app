package com.aeryon.java.types;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceInfo {
    private static final Map<String, DeviceInfo> instancesBySerial = new ConcurrentHashMap();
    private String additionalProperty;
    private String[] capabilities;
    private ADK_DEVICE_TYPE deviceType = ADK_DEVICE_TYPE.Unknown;
    private String host;
    private String name;
    private Long pointer = null;
    private String serial;
    private AdkVersion version;

    public enum ADK_DEVICE_TYPE {
        Unknown,
        Aircraft,
        BaseStation
    }

    private native void destroyDeviceInfo(long j);

    public Long getPointer() {
        return this.pointer;
    }

    public DeviceInfo(AdkVersion adkVersion, int i, String str, String str2, String str3, String[] strArr, String str4, long j) {
        this.version = adkVersion;
        if (i == 1) {
            this.deviceType = ADK_DEVICE_TYPE.Aircraft;
        } else if (i != 2) {
            this.deviceType = ADK_DEVICE_TYPE.Unknown;
        } else {
            this.deviceType = ADK_DEVICE_TYPE.BaseStation;
        }
        this.name = str;
        this.host = str2;
        this.serial = str3;
        this.capabilities = strArr;
        this.additionalProperty = str4;
        this.pointer = Long.valueOf(j);
    }

    public void finalize() {
        destroy();
    }

    public void destroy() {
        synchronized (this.pointer) {
            Long l = this.pointer;
            if (l != null) {
                destroyDeviceInfo(l.longValue());
                this.pointer = null;
            }
        }
    }

    public AdkVersion getVersion() {
        return this.version;
    }

    public ADK_DEVICE_TYPE getDeviceType() {
        return this.deviceType;
    }

    public String getName() {
        return this.name;
    }

    public String getHost() {
        return this.host;
    }

    public String getSerial() {
        return this.serial;
    }

    public String[] getCapabilities() {
        return this.capabilities;
    }

    public String getAdditionalProperty() {
        return this.additionalProperty;
    }

    public Aircraft getAircraft() {
        Aircraft aircraft = null;
        if (this.deviceType != ADK_DEVICE_TYPE.Aircraft) {
            return null;
        }
        synchronized (this.pointer) {
            if (this.pointer != null) {
                aircraft = Aircraft.getAircraft(this);
            }
        }
        return aircraft;
    }

    public String toString() {
        return toJson();
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\n");
        sb.append("\"version\" : \"");
        sb.append(this.version);
        sb.append("\",");
        sb.append("\n");
        sb.append("\"ADK_DEVICE_TYPE\" : \"");
        sb.append(this.deviceType.name());
        sb.append("\",");
        sb.append("\n");
        sb.append("\"name\" : \"");
        sb.append(this.name);
        sb.append("\",");
        sb.append("\n");
        sb.append("\"host\" : \"");
        sb.append(this.host);
        sb.append("\",");
        sb.append("\n");
        sb.append("\"serial\" : \"");
        sb.append(this.serial);
        sb.append("\",");
        sb.append("\n");
        sb.append("\"capabilities\" : [\n");
        for (String append : this.capabilities) {
            sb.append("\"");
            sb.append(append);
            sb.append("\",");
            sb.append("\n");
        }
        sb.append("],");
        sb.append("\n");
        sb.append("\"additional_property\" : \"");
        sb.append(this.additionalProperty);
        sb.append("\",");
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }
}
