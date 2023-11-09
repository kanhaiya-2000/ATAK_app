package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.AuthInfo;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.CalibrateIMUStatus;
import com.autel.common.flycontroller.CalibrateIMUStep;
import com.autel.common.flycontroller.FmuParameterEvent;
import com.autel.common.flycontroller.RTKSignalType;
import com.autel.common.flycontroller.RtkCoordinateSystem;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.evo2.MotionDelayParams;
import com.autel.common.flycontroller.evo2.TripodParams;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.internal.sdk.flycontroller.FileDataType;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.flycontroller.rx.RxEvo2FlyController */
public interface RxEvo2FlyController extends RxAutelFlyController, RxEvo2Visual {
    Observable<Boolean> cancelMission(int i);

    Observable<Boolean> checkNFZ(String str, String str2);

    Observable<Boolean> droneArmed();

    Observable<Boolean> droneDisarmed();

    Observable<Float> getATTISensitivity();

    Observable<BoatMode> getBoatMode();

    Observable<Float> getBrakeSensitivity();

    Observable<Float> getGasPedalSensitivity();

    Observable<EvoFlyControllerParameterRangeManager> getParameterRangeManager();

    Observable<Float> getPitchAndRollSenCoefficient();

    Observable<RtkCoordinateSystem> getRTKCoordinateSys();

    Observable<RTKSignalType> getRTKRecvType();

    Observable<AuthInfo> getRtkAuthInfo();

    Observable<Boolean> getUseRTK();

    Observable<Float> getYawStrokeSensitivity();

    boolean isSupportBoatMode();

    Observable<VisualSettingInfo> isVisualSettingEnable();

    Observable<Boolean> setATTISensitivity(float f);

    Observable<Boolean> setAircraftHeadingDirection(int i);

    Observable<Boolean> setBoatMode(BoatMode boatMode);

    Observable<Boolean> setBrakeSensitivity(float f);

    void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam);

    void setFlyControllerParameterChangedListener(CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams);

    Observable<Boolean> setGasPedalSensitivity(float f);

    Observable<Boolean> setMotionDelayParams(MotionDelayParams motionDelayParams);

    Observable<Boolean> setPitchAndRollSenCoefficient(float f);

    Observable<Boolean> setRTKCoordinateSys(RtkCoordinateSystem rtkCoordinateSystem);

    Observable<Boolean> setRTKRecvType(int i);

    void setRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam);

    Observable<Boolean> setTripodParams(TripodParams tripodParams);

    Observable<Boolean> setUseRTK(boolean z);

    void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam);

    Observable<Boolean> setYawStrokeSensitivity(float f);

    void startCalibrationIMU(CallbackWithTwoParams<CalibrateIMUStep, CalibrateIMUStatus> callbackWithTwoParams);

    Observable<Float> uploadFileData(String str, FileDataType fileDataType);
}
