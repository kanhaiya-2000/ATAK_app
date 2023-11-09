package com.autel.AutelNet2.aircraft.mission.interfaces;

public interface IWaypointMissionListener<T> {
    void onProgress(float f);

    void onResult(T t);
}
