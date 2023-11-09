package com.autel.internal.sdk.mission.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.mission.evo.EvoTrackingMission;

public class EvoTrackingMissionWithUpdate extends EvoTrackingMission {
    private UpdateListener updateListener;

    public interface UpdateListener {
        void lockTarget(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam);

        void switchFollowMode(DynamicTrackMode dynamicTrackMode, CallbackWithNoParam callbackWithNoParam);

        void unlockTarget(CallbackWithNoParam callbackWithNoParam);
    }

    public void setUpdateListener(UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public void lockTarget(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam) {
        this.mTrackingTarget = trackingTarget;
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.lockTarget(this.mTrackingTarget, callbackWithNoParam);
        }
    }

    public void unlockTarget(CallbackWithNoParam callbackWithNoParam) {
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.unlockTarget(callbackWithNoParam);
        }
    }

    public void switchFollowMode(DynamicTrackMode dynamicTrackMode, CallbackWithNoParam callbackWithNoParam) {
        this.mDynamicTrackMode = dynamicTrackMode;
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.switchFollowMode(this.mDynamicTrackMode, callbackWithNoParam);
        }
    }

    public DynamicTrackMode getVisualFollowMode() {
        return this.mDynamicTrackMode;
    }
}
