package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
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
import com.autel.common.flycontroller.evo2.RTKInternal;
import com.autel.common.flycontroller.evo2.TripodParams;
import com.autel.common.mission.RealTimeInfo;
import com.autel.internal.sdk.flycontroller.FileDataType;
import com.autel.sdk.flycontroller.p007rx.RxEvo2FlyController;

public interface Evo2FlyController extends C4930AutelFlyController, Evo2Visual {
    void cancelMission(int i, CallbackWithNoParam callbackWithNoParam);

    void checkNFZ(String str, String str2, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void droneArmed(CallbackWithNoParam callbackWithNoParam);

    void droneDisarmed(CallbackWithNoParam callbackWithNoParam);

    void getATTISensitivity(CallbackWithOneParam<Float> callbackWithOneParam);

    void getBoatMode(CallbackWithOneParam<BoatMode> callbackWithOneParam);

    void getBrakeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam);

    void getGasPedalSensitivity(CallbackWithOneParam<Float> callbackWithOneParam);

    EvoFlyControllerParameterRangeManager getParameterRangeManager();

    void getPitchAndRollSenCoefficient(CallbackWithOneParam<Float> callbackWithOneParam);

    void getRtkAuthInfo(CallbackWithOneParam<AuthInfo> callbackWithOneParam);

    void getRtkCoordinateSys(CallbackWithOneParam<RtkCoordinateSystem> callbackWithOneParam);

    void getRtkRecvType(CallbackWithOneParam<RTKSignalType> callbackWithOneParam);

    void getUseRTK(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getYawStrokeSensitivity(CallbackWithOneParam<Float> callbackWithOneParam);

    boolean isSupportBoatMode();

    void sendRtkData(byte[] bArr);

    void setATTISensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setAircraftHeadingDirection(int i, CallbackWithNoParam callbackWithNoParam);

    void setBoatMode(BoatMode boatMode, CallbackWithNoParam callbackWithNoParam);

    void setBrakeSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setBreakPointMissionListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam);

    void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam);

    void setFlyControllerParameterChangedListener(CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams);

    void setGasPedalSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setMotionDelayParams(MotionDelayParams motionDelayParams, CallbackWithNoParam callbackWithNoParam);

    void setPitchAndRollSenCoefficient(float f, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setRtkCoordinateSys(RtkCoordinateSystem rtkCoordinateSystem, CallbackWithNoParam callbackWithNoParam);

    void setRtkGGAListener(CallbackWithOneParam<byte[]> callbackWithOneParam);

    void setRtkInfoListener(CallbackWithOneParam<RTKInternal> callbackWithOneParam);

    void setRtkRecvType(int i, CallbackWithNoParam callbackWithNoParam);

    void setTripodParams(TripodParams tripodParams, CallbackWithNoParam callbackWithNoParam);

    void setUseRTK(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setYawStrokeSensitivity(float f, CallbackWithOneParam<Boolean> callbackWithOneParam);

    void startCalibrationIMU(CallbackWithTwoParams<CalibrateIMUStep, CalibrateIMUStatus> callbackWithTwoParams);

    RxEvo2FlyController toRx();

    void uploadFileData(String str, FileDataType fileDataType, CallbackWithOneParamProgress<Float> callbackWithOneParamProgress);
}
