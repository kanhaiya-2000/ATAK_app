package com.autel.sdk.product;

import com.autel.common.product.AutelProductType;
import com.autel.sdk.album.AutelAlbum;
import com.autel.sdk.battery.C4928AutelBattery;
import com.autel.sdk.camera.AutelCameraManager;
import com.autel.sdk.dsp.C4929AutelDsp;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.gimbal.C4931AutelGimbal;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;
import com.autel.sdk.video.AutelCodec;

public interface BaseProduct {
    AutelAlbum getAlbum();

    C4928AutelBattery getBattery();

    AutelCameraManager getCameraManager();

    AutelCodec getCodec();

    C4929AutelDsp getDsp();

    C4930AutelFlyController getFlyController();

    C4931AutelGimbal getGimbal();

    MissionManager getMissionManager();

    C4932AutelRemoteController getRemoteController();

    AutelProductType getType();
}
