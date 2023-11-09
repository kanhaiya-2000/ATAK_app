package com.aeryon.java.types;

public class AdkVersion {
    private final long build;
    private final int major;
    private final int minor;
    private final int revision;
    private final String versionString;

    public AdkVersion(int i, int i2, int i3, long j) {
        this.major = i;
        this.minor = i2;
        this.revision = i3;
        this.build = j;
        this.versionString = i + "." + i2 + "." + i3 + "." + j;
    }

    public String toString() {
        return this.versionString;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdkVersion)) {
            return false;
        }
        return this.versionString.equals(((AdkVersion) obj).toString());
    }
}
