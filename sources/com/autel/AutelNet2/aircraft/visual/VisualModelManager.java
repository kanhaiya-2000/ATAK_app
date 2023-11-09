package com.autel.AutelNet2.aircraft.visual;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ObstacleAvoidance;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ViewpointInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualHeartInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ObstacleAvoidancePacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ObstacleAvoidanceParamterPacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.ViewpointPacket;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message.VisualHeartPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportGoalArea;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportOrbitInfo;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.UploadGoalArea;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.VisualWarningInfoImpl;
import com.autel.AutelNet2.aircraft.visual.tracking.message.OrbitStatusPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.OrbitTargetAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.ReportGoalAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.UploadGoalAreaPacket;
import com.autel.AutelNet2.aircraft.visual.tracking.message.VisualEventPacket;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.TrackingDispatch;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.visual.TargetArea;
import com.autel.common.camera.visual.TrackingArea;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.camera.visual.VisualAction;
import com.autel.common.camera.visual.VisualOrbitParams;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import java.util.concurrent.ConcurrentHashMap;

public class VisualModelManager extends BaseController<Integer> {
    private static final short REGISTER_MESSAGE_TYPE_IFLY_RADAR_INFO = 2307;
    private static final short REGISTER_MESSAGE_TYPE_PASS_THOUGH_TRACK = 1547;
    private static final short REGISTER_TRACKING_IFLY_EVENT = 2306;
    private static final String TAG = "VisualModelManager";
    private final ConcurrentHashMap<String, CallbackWithOneParam<ObstacleAvoidance>> mObstacleAvoidanceListeners;
    private final ConcurrentHashMap<String, CallbackWithOneParam<ReportOrbitInfo>> mOrbitReportListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<UploadGoalArea>> mOrbitTargetAreaListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<UploadGoalArea>> mTrackingListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<ReportGoalArea>> mTrackingReportListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<ViewpointInfo>> mViewpointListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<VisualHeartInfo>> mVisualHeartListener;
    private final ConcurrentHashMap<String, CallbackWithOneParam<VisualWarningInfoImpl>> mVisualWarningListener;

    private VisualModelManager() {
        this.mOrbitReportListener = new ConcurrentHashMap<>();
        this.mTrackingReportListener = new ConcurrentHashMap<>();
        this.mTrackingListener = new ConcurrentHashMap<>();
        this.mOrbitTargetAreaListener = new ConcurrentHashMap<>();
        this.mVisualHeartListener = new ConcurrentHashMap<>();
        this.mViewpointListener = new ConcurrentHashMap<>();
        this.mVisualWarningListener = new ConcurrentHashMap<>();
        this.mObstacleAvoidanceListeners = new ConcurrentHashMap<>();
        init();
    }

    public static VisualModelManager instance() {
        return TrackingStatusHolder.s_instance;
    }

    private static class TrackingStatusHolder {
        /* access modifiers changed from: private */
        public static final VisualModelManager s_instance = new VisualModelManager();

        private TrackingStatusHolder() {
        }
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_VISUAL_HEART, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_COMMAND_ACK, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_SETTINGS, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 2306, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 1547, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 2307, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_QOAL_AREA, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_TRACK_AREA, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_ORBIT_STATUS, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_ORBIT_AREA, this);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket != null) {
            if (baseMsgPacket instanceof ObstacleAvoidancePacket) {
                iteratorCallback(this.mObstacleAvoidanceListeners, ((ObstacleAvoidancePacket) baseMsgPacket).getObstacleAvoidance());
            } else if (baseMsgPacket instanceof VisualEventPacket) {
                iteratorCallback(this.mVisualWarningListener, ((VisualEventPacket) baseMsgPacket).getVisualWarningInfo());
            } else if (baseMsgPacket instanceof ObstacleAvoidanceParamterPacket) {
                callbackSucc(baseMsgPacket.getType(), ((ObstacleAvoidanceParamterPacket) baseMsgPacket).getVisualSettingAckInfo());
            } else if (baseMsgPacket instanceof ViewpointPacket) {
                iteratorCallback(this.mViewpointListener, ((ViewpointPacket) baseMsgPacket).getViewpointInfo());
            } else if (baseMsgPacket instanceof VisualHeartPacket) {
                iteratorCallback(this.mVisualHeartListener, ((VisualHeartPacket) baseMsgPacket).getVisualHeartInfo());
            } else if (baseMsgPacket instanceof ReportGoalAreaPacket) {
                iteratorCallback(this.mTrackingReportListener, ((ReportGoalAreaPacket) baseMsgPacket).getReportGoalArea());
            } else if (baseMsgPacket instanceof UploadGoalAreaPacket) {
                iteratorCallback(this.mTrackingListener, ((UploadGoalAreaPacket) baseMsgPacket).getUploadGoalArea());
            } else if (baseMsgPacket instanceof OrbitTargetAreaPacket) {
                iteratorCallback(this.mOrbitTargetAreaListener, ((OrbitTargetAreaPacket) baseMsgPacket).getUploadGoalArea());
            } else if (baseMsgPacket instanceof OrbitStatusPacket) {
                iteratorCallback(this.mOrbitReportListener, ((OrbitStatusPacket) baseMsgPacket).getReportOrbitInfo());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_VISUAL_HEART);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_COMMAND_ACK);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_SETTINGS);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, 2306);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, 1547);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, 2307);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_QOAL_AREA);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_TRACK_AREA);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_ORBIT_STATUS);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_MAV_IFLY_REPORT_ORBIT_AREA);
    }

    public void setVisualDigitalZoom(int i, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setDigitalZoom(i);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_DIGITAL_ZOOM.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualTrackingFightMode(int i, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(i);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_TRACKING_MODE.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualTrackingAction(int i, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(i);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_TRACKING.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setResetVisualTrackingFightMode(CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(0);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_TRACKING_MODE.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualViewPointCoord(int i, int i2, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setTouchPointLocation(i, i2);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.SET_VIEW_POINT_COORD.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualViewPointCoord(int i, int i2, int i3, int i4, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setTouchPointLocation(i, i2, i3, i4);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.SET_VIEW_POINT_COORD.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualFlyAngle(int i, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setFlyAngle(i);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.SET_VIEW_POINT_COORD.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualResolutionAngle(int i, int i2, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setResolutionAngle(i, i2);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_SET_RESOLUTION_ANGLE.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualResolution(int i, int i2, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setResolution(i, i2);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.SET_VIEW_POINT_COORD.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualViewPointSpeed(float f, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData((int) (f * 10.0f));
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.SET_VIEW_POINT_SPEED.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualSettingSwitchblade(int i, boolean z, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(z ? 1 : 0);
        obstacleAvoidanceParamterPacket.setCommand(i);
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualSettingParams(int i, int i2, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(i2);
        obstacleAvoidanceParamterPacket.setCommand(i);
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualViewpointAction(int i, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(i);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VIEW_POINT_FLIGHT_TASK.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setTrackArea(trackingTarget);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_TRACKING_AREA.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualOrbitAction(VisualAction visualAction, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setData(visualAction.getValue());
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_ORBIT_MODEL.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualOrbitGoalArea(TargetArea targetArea, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setTargetArea(targetArea);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_ORBIT_MODEL_TARGET.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualOrbitParams(VisualOrbitParams visualOrbitParams, CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setOrbitParams(visualOrbitParams);
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_ORBIT_MODEL_HEIGHT_RADIUS.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void resetOrbitYaw(CallbackWithOneParam<VisualSettingAckInfo> callbackWithOneParam) {
        ObstacleAvoidanceParamterPacket obstacleAvoidanceParamterPacket = new ObstacleAvoidanceParamterPacket();
        obstacleAvoidanceParamterPacket.setCommand(VisualSettingSwitchblade.VISUAL_ORBIT_MODEL_RESET_YAW.getCmdValue());
        sendPacket(obstacleAvoidanceParamterPacket, callbackWithOneParam);
    }

    public void setVisualHeartListener(String str, CallbackWithOneParam<VisualHeartInfo> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str)) {
            this.mVisualHeartListener.put(str, callbackWithOneParam);
        }
    }

    public void removeVisualHeartListener(String str) {
        this.mVisualHeartListener.remove(str);
    }

    public void setTrackingReportListener(String str, CallbackWithOneParam<ReportGoalArea> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str)) {
            this.mTrackingReportListener.put(str, callbackWithOneParam);
        }
    }

    public void removeTrackingReportListener(String str) {
        this.mTrackingReportListener.remove(str);
    }

    public void setVisualOrbitReportListener(String str, CallbackWithOneParam<ReportOrbitInfo> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str)) {
            this.mOrbitReportListener.put(str, callbackWithOneParam);
        }
    }

    public void removeVisualOrbitReportListener(String str) {
        this.mOrbitReportListener.remove(str);
    }

    public void registerTrackingListener(String str, CallbackWithOneParam<UploadGoalArea> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str)) {
            this.mTrackingListener.put(str, callbackWithOneParam);
        }
    }

    public void removeTrackingListener(String str) {
        this.mTrackingListener.remove(str);
    }

    public void registerVisualOrbitTargetAreaListener(String str, CallbackWithOneParam<UploadGoalArea> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str)) {
            this.mOrbitTargetAreaListener.put(str, callbackWithOneParam);
        }
    }

    public void removeVisualOrbitTargetAreaListener(String str) {
        this.mOrbitTargetAreaListener.remove(str);
    }

    public void setTrackingListener(final CallbackWithOneParam<TrackingArea> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            TrackingDispatch.instance().registerTrackingListener((TrackingDispatch.TrackingListener) null);
        } else {
            TrackingDispatch.instance().registerTrackingListener(new TrackingDispatch.TrackingListener() {
                public void receiverData(UploadGoalArea uploadGoalArea) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(uploadGoalArea);
                    }
                }
            });
        }
    }

    public void setObstacleAvoidanceListener(String str, CallbackWithOneParam<ObstacleAvoidance> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str) && callbackWithOneParam != null && !this.mObstacleAvoidanceListeners.contains(str)) {
            this.mObstacleAvoidanceListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeObstacleAvoidanceListener(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mObstacleAvoidanceListeners.remove(str);
        }
    }

    public void setVisualWarningListener(String str, CallbackWithOneParam<VisualWarningInfoImpl> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mVisualWarningListener.put(str, callbackWithOneParam);
        }
    }

    public void removeVisualWarningListener(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVisualWarningListener.remove(str);
        }
    }

    public void setViewpointTargetAreaListener(String str, CallbackWithOneParam<ViewpointInfo> callbackWithOneParam) {
        if (!TextUtils.isEmpty(str) && callbackWithOneParam != null) {
            this.mViewpointListener.put(str, callbackWithOneParam);
        }
    }

    public void removeViewpointTargetAreaListener(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mViewpointListener.remove(str);
        }
    }
}
