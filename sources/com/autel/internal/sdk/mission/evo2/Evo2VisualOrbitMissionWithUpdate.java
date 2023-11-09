package com.autel.internal.sdk.mission.evo2;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.camera.visual.TargetArea;
import com.autel.common.mission.evo2.Evo2VisualOrbitMission;
import com.autel.common.mission.evo2.RotateDirect;

public class Evo2VisualOrbitMissionWithUpdate extends Evo2VisualOrbitMission {
    private UpdateListener updateListener;

    public interface UpdateListener {
        void lockTarget(TargetArea targetArea, CallbackWithNoParam callbackWithNoParam);

        void resetOrbitYaw(CallbackWithNoParam callbackWithNoParam);

        void setOrbitParams(float f, float f2, float f3, RotateDirect rotateDirect, CallbackWithNoParam callbackWithNoParam);

        void unlockTarget(CallbackWithNoParam callbackWithNoParam);
    }

    public void setUpdateListener(UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public void lockTarget(TargetArea targetArea, CallbackWithNoParam callbackWithNoParam) {
        this.mTrackingTarget = targetArea;
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

    public void resetOrbitYaw(CallbackWithNoParam callbackWithNoParam) {
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.resetOrbitYaw(callbackWithNoParam);
        }
    }

    public void setOrbitHeight(int i, int i2, int i3, RotateDirect rotateDirect, CallbackWithNoParam callbackWithNoParam) {
        UpdateListener updateListener2 = this.updateListener;
        if (updateListener2 != null) {
            updateListener2.setOrbitParams((float) i, (float) i2, (float) i3, rotateDirect, callbackWithNoParam);
        }
    }
}
