package com.autel.internal.sdk.heartbeat;

import com.autel.common.product.AutelProductInfo;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;

public interface IAutelHeartBeatListener {
    void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, AutelProductInfo autelProductInfo);
}
