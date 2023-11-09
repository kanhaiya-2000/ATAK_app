package com.autel.sdk;

public class AutelSdkConfig {
    /* access modifiers changed from: private */
    public String appKey;
    /* access modifiers changed from: private */
    public boolean postOnUi;
    /* access modifiers changed from: private */
    public VersionDetect versionDetect = VersionDetect.ALL;

    public enum VersionDetect {
        ONLY_G1,
        ONLY_G2,
        ALL
    }

    public boolean isPostOnUi() {
        return this.postOnUi;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public VersionDetect getVersionDetect() {
        return this.versionDetect;
    }

    public static class AutelSdkConfigBuilder {
        private String appKey = "";
        private boolean postOnUi;
        private VersionDetect versionDetect = VersionDetect.ALL;

        public AutelSdkConfigBuilder setPostOnUi(boolean z) {
            this.postOnUi = z;
            return this;
        }

        public AutelSdkConfigBuilder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public AutelSdkConfigBuilder setVersionDetect(VersionDetect versionDetect2) {
            this.versionDetect = versionDetect2;
            return this;
        }

        public AutelSdkConfig create() {
            AutelSdkConfig autelSdkConfig = new AutelSdkConfig();
            String unused = autelSdkConfig.appKey = this.appKey;
            VersionDetect unused2 = autelSdkConfig.versionDetect = this.versionDetect;
            boolean unused3 = autelSdkConfig.postOnUi = this.postOnUi;
            return autelSdkConfig;
        }
    }
}
