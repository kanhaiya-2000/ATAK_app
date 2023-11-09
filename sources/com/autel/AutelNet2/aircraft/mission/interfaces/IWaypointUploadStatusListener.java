package com.autel.AutelNet2.aircraft.mission.interfaces;

public interface IWaypointUploadStatusListener {
    void onEnd(boolean z);

    void onStart();

    void onTimeOut();

    void onUploading(int i);
}
