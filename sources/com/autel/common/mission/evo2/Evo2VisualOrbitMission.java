package com.autel.common.mission.evo2;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.camera.visual.TargetArea;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.FollowFinishedAction;
import com.autel.internal.sdk.mission.evo2.Evo2VisualOrbitMissionWithUpdate;

public class Evo2VisualOrbitMission extends C2700AutelMission {
    protected RotateDirect direct;
    public FollowFinishedAction finishedAction = FollowFinishedAction.RETURN_HOME;
    protected int height;
    protected TargetArea mTrackingTarget;
    protected int radius;
    protected int speed;

    public void resetOrbitYaw(CallbackWithNoParam callbackWithNoParam) {
    }

    public void unlockTarget(CallbackWithNoParam callbackWithNoParam) {
    }

    public void lockTarget(TargetArea targetArea, CallbackWithNoParam callbackWithNoParam) {
        this.mTrackingTarget = targetArea;
    }

    public void setOrbitHeight(int i, int i2, int i3, RotateDirect rotateDirect, CallbackWithNoParam callbackWithNoParam) {
        this.height = i;
        this.radius = i2;
        this.speed = i3;
        this.direct = rotateDirect;
    }

    protected Evo2VisualOrbitMission() {
    }

    public static Evo2VisualOrbitMission create() {
        return new Evo2VisualOrbitMissionWithUpdate();
    }

    public String toString() {
        return "mTrackingTarget : " + this.mTrackingTarget;
    }
}
