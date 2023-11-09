package com.autel.internal.autel;

import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;

public interface IAutelStateManager {
    AuthorityState getAuthorityState();

    HeartBeatStatus getHeartBeatStatus();

    boolean isCameraConnected();

    boolean isProductConnected();

    boolean isRemoteControllerConnected();

    boolean isSdkValidate();

    void setAircraftConnected(boolean z);

    void setCameraConnected(boolean z);

    void setRemoteControllerConnected(boolean z);
}
