package com.autel.common.mission.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.FollowFinishedAction;
import com.autel.internal.sdk.mission.evo.EvoTrackingMissionWithUpdate;

public class EvoTrackingMission extends C2700AutelMission {
    public FollowFinishedAction finishedAction = FollowFinishedAction.RETURN_HOME;
    protected DynamicTrackMode mDynamicTrackMode = DynamicTrackMode.COMMON_MODE;
    protected TrackingTarget mTrackingTarget;

    public void unlockTarget(CallbackWithNoParam callbackWithNoParam) {
    }

    public void lockTarget(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam) {
        this.mTrackingTarget = trackingTarget;
    }

    public void switchFollowMode(DynamicTrackMode dynamicTrackMode, CallbackWithNoParam callbackWithNoParam) {
        this.mDynamicTrackMode = dynamicTrackMode;
    }

    protected EvoTrackingMission() {
    }

    public static EvoTrackingMission create() {
        return new EvoTrackingMissionWithUpdate();
    }

    public String toString() {
        return "mTrackingTarget : " + this.mTrackingTarget;
    }
}
