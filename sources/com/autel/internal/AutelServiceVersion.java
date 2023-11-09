package com.autel.internal;

public enum AutelServiceVersion {
    SERVICE_10("16-04-01", "1.0.0", 1),
    SERVICE_20("16-10-15", "2.0.0", 2);
    
    private String startTime;
    private int versionCode;
    private String versionName;

    private AutelServiceVersion(String str, String str2, int i) {
        this.startTime = str;
        this.versionCode = i;
        this.versionName = str2;
    }
}
