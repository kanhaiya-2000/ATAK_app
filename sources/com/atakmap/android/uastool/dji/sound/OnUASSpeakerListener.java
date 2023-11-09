package com.atakmap.android.uastool.dji.sound;

public interface OnUASSpeakerListener {
    void onUASFileDeleted(boolean z, String str, String str2);

    void onUASFileRefreshComplete(boolean z, String str);

    void onUASFileStateChange(String str);

    void onUASFileUploadComplete(boolean z, String str);

    void onUASSoundPlaying(boolean z, String str, String str2);

    void onUASSoundStopped(boolean z, String str);
}
