package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.TrackTargetArea;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingGoalArea;
import com.autel.common.camera.visual.ViewpointAction;
import java.util.List;

public interface Evo2Visual extends AutelVisual {
    void setOrbitTargetListener(CallbackWithOneParam<TrackTargetArea> callbackWithOneParam);

    void setTrackingMode(TrackingAction trackingAction, CallbackWithNoParam callbackWithNoParam);

    void setTrackingTargetListener(CallbackWithTwoParams<List<TrackingGoalArea>, Boolean> callbackWithTwoParams);

    void setViewpointAction(ViewpointAction viewpointAction, CallbackWithNoParam callbackWithNoParam);

    void setVisualResolution();

    void setVisualViewPointCoordinate(float f, float f2, CallbackWithNoParam callbackWithNoParam);
}
