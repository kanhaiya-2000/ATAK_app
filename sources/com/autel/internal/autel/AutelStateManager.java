package com.autel.internal.autel;

import android.content.Context;
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.internal.sdk.util.AutelSharedPreferencesUtils;
import com.autel.util.jni.Utils;

public class AutelStateManager implements IAutelStateManager {
    private static final String AuthorStateTag = "AuthorStateTag";
    private volatile boolean aircraftConnected;
    private volatile AuthorityState authorityState;
    private volatile boolean cameraConnected;
    private HeartBeatStatus heartBeatStatus;
    private Context mContext;
    private volatile boolean remoteControllerConnected;

    public AutelStateManager(Context context) {
        this.mContext = context;
        this.authorityState = AuthorityState.find(changeFrom(AutelSharedPreferencesUtils.getSpValueForString(context, AuthorStateTag, "")));
    }

    private String changeFrom(String str) {
        return Utils.decryptionCode(str);
    }

    public HeartBeatStatus getHeartBeatStatus() {
        return this.heartBeatStatus;
    }

    public void setHeartBeatStatus(HeartBeatStatus heartBeatStatus2) {
        this.heartBeatStatus = heartBeatStatus2;
    }

    public boolean isRemoteControllerConnected() {
        return this.remoteControllerConnected;
    }

    public void setRemoteControllerConnected(boolean z) {
        this.remoteControllerConnected = z;
    }

    public boolean isCameraConnected() {
        return this.cameraConnected;
    }

    public void setCameraConnected(boolean z) {
        this.cameraConnected = z;
    }

    public boolean isProductConnected() {
        return this.aircraftConnected;
    }

    public void setAircraftConnected(boolean z) {
        this.aircraftConnected = z;
    }

    public boolean isSdkValidate() {
        return this.authorityState != null && !this.authorityState.levelLessThan(AuthorityState.RESTRICTED);
    }

    public AuthorityState getAuthorityState() {
        return this.authorityState;
    }

    public void setSdkValidate(AuthorityState authorityState2) {
        this.authorityState = authorityState2;
        AutelSharedPreferencesUtils.setSpValueForString(this.mContext, AuthorStateTag, changeTo());
    }

    private String changeTo() {
        return Utils.encryptionCode(this.authorityState.value());
    }
}
