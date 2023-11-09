package com.autel.camera.protocol.protocol10.engine;

import android.text.format.Time;
import com.autel.camera.communication.tcp.CameraController;
import com.autel.camera.protocol.protocol10.enums.AutelCameraParam;
import com.autel.camera.protocol.protocol10.enums.AutelCameraType;
import com.autel.camera.utils.DateUtils;
import com.autel.common.camera.media.ExposureMode;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import com.autel.util.log.AutelLog;

public class CameraCommandMsgFactory {
    private static final int CAMERA_MSGID_FORMAT_SDCARD = 4;
    private static final int CAMERA_MSGID_GET_CURRENT_VIDEO_TIME = 1808;
    private static final int CAMERA_MSGID_RESET = 1539;
    private static final int CAMERA_MSGID_SETTING = 3;
    private static final int CAMERA_MSGID_SETUP = 2;
    private static final int CAMERA_MSGID_START_SESSION = 257;
    private static final int CAMERA_MSGID_START_VIDEO = 513;
    private static final int CAMERA_MSGID_STATUS = 3;
    private static final int CAMERA_MSGID_STOP_TIMPLASE = 770;
    private static final int CAMERA_MSGID_STOP_VIDEO = 514;
    private static final int CAMERA_MSGID_TAKEN_PHOTO = 769;

    private CameraCommandMsgFactory() {
    }

    public static CameraCommandMessage createCameraToken() {
        return new CameraCommandMessage(0, CAMERA_MSGID_START_SESSION, (String) null, (String) null);
    }

    public static CameraCommandMessage createCameraStatus() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 3, (String) null, AutelCameraParam.CAMERA_PARAM_STATUS.value());
    }

    public static CameraCommandMessage createCameraSetting() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 3, (String) null, AutelCameraParam.CAMERA_PARAM_SETTING.value());
    }

    public static CameraCommandMessage createCameraCurrentDate() {
        Time time = new Time();
        time.setToNow();
        String str = time.format("%Y-%m-%d %H:%M:%S") + ":" + DateUtils.getTimeZoneOffset();
        AutelLog.m15084e("Tag", "setting currentTime:" + str);
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_CAMERA_CLOCK.value(), str);
    }

    public static CameraCommandMessage createCameraSpotMeter(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_LOCATION_METER.value(), str);
    }

    public static CameraCommandMessage createCameraTakenPhoto() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), CAMERA_MSGID_TAKEN_PHOTO, (String) null, (String) null);
    }

    public static CameraCommandMessage createCameraStartVideo() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 513, (String) null, (String) null);
    }

    public static CameraCommandMessage createCameraStopVideo() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), CAMERA_MSGID_STOP_VIDEO, (String) null, (String) null);
    }

    public static CameraCommandMessage createCameraStopTimplase() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), CAMERA_MSGID_STOP_TIMPLASE, (String) null, (String) null);
    }

    public static CameraCommandMessage createCameraCurrentVideoTime() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), CAMERA_MSGID_GET_CURRENT_VIDEO_TIME, (String) null, (String) null);
    }

    public static CameraCommandMessage createSetCameraSetting(String str, String str2) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, str, str2);
    }

    public static CameraCommandMessage createSetCameraMode(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_MODE.value(), str);
    }

    public static CameraCommandMessage createSetCameraAELock(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_AE_LOCK.value(), str);
    }

    public static CameraCommandMessage createSetCameraEV(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_EV.value(), str);
    }

    public static CameraCommandMessage createSetCameraIso(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_ISO.value(), str);
    }

    public static CameraCommandMessage createSetCameraShutter(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_SHUTTER.value(), str);
    }

    public static CameraCommandMessage createSetCameraPhotoSize(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_PHOTO_SIZE.value(), str);
    }

    public static CameraCommandMessage createSetCameraPhotoStyle(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_S_STYLE.value(), str);
    }

    public static CameraCommandMessage createSetCameraWB(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_P_WB.value(), str);
    }

    public static CameraCommandMessage createSetCameraColor(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_S_COLOR.value(), str);
    }

    public static CameraCommandMessage createSetCameraVideoSize(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_V_RESOLUTION.value(), str);
    }

    public static CameraCommandMessage createSetCameraPhotoType(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_P_TYPE.value(), str);
    }

    public static CameraCommandMessage createSetCameraVideoType(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_V_TYPE.value(), str);
    }

    public static CameraCommandMessage createSetCameraSystem(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_S_SYSTEM_TYPE.value(), str);
    }

    public static CameraCommandMessage createSetCameraVideoSubtitle(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_SUBTITLE_SWITCH.value(), str);
    }

    public static CameraCommandMessage createSetCamera3DDenoise(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_S_MCTF.value(), str);
    }

    public static CameraCommandMessage createSetCameraFlicker(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraParam.CAMERA_PARAM_P_FLICKER.value(), str);
    }

    public static CameraCommandMessage createSetCameraSettingByType(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, str, (String) null);
    }

    public static CameraCommandMessage createFormatSDcard() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 4, (String) null, AutelCameraType.CAMERA_TYPE_D.value());
    }

    public static CameraCommandMessage createCameraBurstNum(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_BURST_NUM.value(), str);
    }

    public static CameraCommandMessage createTimelapseNum(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_TIMELAPSE_NUM.value(), str);
    }

    public static CameraCommandMessage createAebNum(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_P_AEBNUM.value(), str);
    }

    public static CameraCommandMessage createCameraReset() {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), CAMERA_MSGID_RESET, (String) null, AutelCameraType.CAMERA_TYPE_D.value());
    }

    public static CameraCommandMessage createCameraHisto(AutelSwitchState autelSwitchState) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_S_HISTO.value(), autelSwitchState.value());
    }

    public static CameraCommandMessage createCameraGear(ExposureMode exposureMode) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_CAPTURE_MODE.value(), exposureMode.value10());
    }

    public static CameraCommandMessage createCameraZoomFactor(String str) {
        return new CameraCommandMessage(CameraController.instance().getTcpCameraToken(), 2, AutelCameraType.CAMERA_TYPE_ZOOMFACTOR.value(), str);
    }
}
