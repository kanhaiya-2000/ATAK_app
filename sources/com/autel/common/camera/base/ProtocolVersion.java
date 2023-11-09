package com.autel.common.camera.base;

public enum ProtocolVersion {
    G1("1");
    
    private String value;

    private ProtocolVersion(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static ProtocolVersion find(String str) {
        ProtocolVersion protocolVersion = G1;
        if (protocolVersion.value().equals(str)) {
        }
        return protocolVersion;
    }
}
