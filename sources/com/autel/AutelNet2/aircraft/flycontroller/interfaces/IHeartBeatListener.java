package com.autel.AutelNet2.aircraft.flycontroller.interfaces;

import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;

public interface IHeartBeatListener {
    void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, HeartBeatInfo heartBeatInfo);
}
