package com.autel.sdk10.AutelNet.AutelMission.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_current;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import com.autel.sdk10.AutelNet.AutelMission.utils.TransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaypointMissionInfoInternalParser extends AutelWaypointRealTimeInfoInternal {
    private static WaypointMissionInfoInternalParser instance_;
    private final int RespondtIimeOut = MAV_CMD.MAV_CMD_DO_VTOL_TRANSITION;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AutelMissionInterface.IWaypointRealtimeInfoListener> WpRealTimeInfoListenerMaps = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public AutelMissionInterface.ICurrentWaypointMissionRequestListener iRequestCurrentWaypointMissionListener;
    /* access modifiers changed from: private */
    public AutelMissionInterface.IWaypointUploadStatusListener iWaypointUploadStatusListener;
    /* access modifiers changed from: private */
    public boolean isRequestCurrentWaypointMissioning = false;
    /* access modifiers changed from: private */
    public boolean isWaypointUploading = false;
    private ArrayList<msg_mission_item> mission = new ArrayList<>();
    private List<Waypoint> mission_Autel_waypoints = new ArrayList();
    private ExecutorService requestTimeOutThreadPool = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public long respondTime_Request;
    /* access modifiers changed from: private */
    public long respondTime_Upload;
    private ExecutorService uploadTimeOutThreadPool = Executors.newSingleThreadExecutor();
    private int waypointCount;

    public static WaypointMissionInfoInternalParser getInstance_() {
        if (instance_ == null) {
            instance_ = new WaypointMissionInfoInternalParser();
        }
        return instance_;
    }

    private WaypointMissionInfoInternalParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = mAVLinkMessage.msgid;
        if (i == 39) {
            this.respondTime_Request = System.currentTimeMillis();
            msg_mission_item msg_mission_item = (msg_mission_item) mAVLinkMessage;
            short s = msg_mission_item.seq;
            if (this.mission.size() == s) {
                this.mission.add(msg_mission_item);
            }
            if (this.iRequestCurrentWaypointMissionListener != null) {
                int size = this.mission.size();
                int i2 = this.waypointCount;
                if (size < i2) {
                    this.iRequestCurrentWaypointMissionListener.onDownloadWaypointInfo(s, i2);
                    return;
                }
                this.mission_Autel_waypoints = TransformUtils.msg_mission_item2WaypointList(this.mission);
                this.iRequestCurrentWaypointMissionListener.onEndRequest(TransformUtils.msg_mission_item2WaypointList(this.mission));
                this.isRequestCurrentWaypointMissioning = false;
            }
        } else if (i == 40) {
            this.respondTime_Upload = System.currentTimeMillis();
            AutelMissionInterface.IWaypointUploadStatusListener iWaypointUploadStatusListener2 = this.iWaypointUploadStatusListener;
            if (iWaypointUploadStatusListener2 != null) {
                iWaypointUploadStatusListener2.onUploadWaypoint(((msg_mission_request) mAVLinkMessage).seq);
            }
        } else if (i == 44) {
            this.respondTime_Request = System.currentTimeMillis();
            msg_mission_count msg_mission_count = (msg_mission_count) mAVLinkMessage;
            this.waypointCount = msg_mission_count.count;
            AutelMissionInterface.ICurrentWaypointMissionRequestListener iCurrentWaypointMissionRequestListener = this.iRequestCurrentWaypointMissionListener;
            if (iCurrentWaypointMissionRequestListener != null) {
                iCurrentWaypointMissionRequestListener.onRecWaypointCount(msg_mission_count.count);
            }
        } else if (i == 47) {
            this.respondTime_Upload = System.currentTimeMillis();
            AutelMissionInterface.IWaypointUploadStatusListener iWaypointUploadStatusListener3 = this.iWaypointUploadStatusListener;
            if (iWaypointUploadStatusListener3 != null) {
                iWaypointUploadStatusListener3.onEndUpload(true);
            }
            this.isWaypointUploading = false;
        } else if (i == 221) {
            parseMsg((mavlink_msg_mission_new_current) mAVLinkMessage);
            callbackRealTimeInfo(this);
        }
    }

    public void setIRequestCurrentWaypointMissionListener(AutelMissionInterface.ICurrentWaypointMissionRequestListener iCurrentWaypointMissionRequestListener) {
        this.iRequestCurrentWaypointMissionListener = iCurrentWaypointMissionRequestListener;
        if (iCurrentWaypointMissionRequestListener != null) {
            if (!this.isRequestCurrentWaypointMissioning) {
                clearAllData();
                startCheckRequestTimeOut();
            }
            this.iRequestCurrentWaypointMissionListener.onStartRequest(this.isRequestCurrentWaypointMissioning);
            this.isRequestCurrentWaypointMissioning = true;
            return;
        }
        this.isRequestCurrentWaypointMissioning = false;
    }

    private void startCheckRequestTimeOut() {
        this.requestTimeOutThreadPool.execute(new Runnable() {
            public void run() {
                try {
                    long unused = WaypointMissionInfoInternalParser.this.respondTime_Request = System.currentTimeMillis();
                    Thread.sleep(100);
                    while (WaypointMissionInfoInternalParser.this.isRequestCurrentWaypointMissioning && WaypointMissionInfoInternalParser.this.iRequestCurrentWaypointMissionListener != null) {
                        Thread.sleep(100);
                        if (System.currentTimeMillis() - WaypointMissionInfoInternalParser.this.respondTime_Request > 3000) {
                            WaypointMissionInfoInternalParser.this.iRequestCurrentWaypointMissionListener.onTimeOut();
                            long unused2 = WaypointMissionInfoInternalParser.this.respondTime_Request = System.currentTimeMillis();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setIWaypointUploadStatusListener(List<Waypoint> list, AutelMissionInterface.IWaypointUploadStatusListener iWaypointUploadStatusListener2) {
        this.mission_Autel_waypoints = list;
        this.iWaypointUploadStatusListener = iWaypointUploadStatusListener2;
        if (iWaypointUploadStatusListener2 != null) {
            startCheckUploadTimeOut();
            this.iWaypointUploadStatusListener.onStartUpload(this.isWaypointUploading);
            this.isWaypointUploading = true;
        }
    }

    public void clearIWaypointUploadStatusListener() {
        this.iWaypointUploadStatusListener = null;
        this.isWaypointUploading = false;
    }

    private void startCheckUploadTimeOut() {
        this.uploadTimeOutThreadPool.execute(new Runnable() {
            public void run() {
                try {
                    long unused = WaypointMissionInfoInternalParser.this.respondTime_Upload = System.currentTimeMillis();
                    Thread.sleep(100);
                    while (WaypointMissionInfoInternalParser.this.isWaypointUploading && WaypointMissionInfoInternalParser.this.iWaypointUploadStatusListener != null) {
                        Thread.sleep(100);
                        if (System.currentTimeMillis() - WaypointMissionInfoInternalParser.this.respondTime_Upload > 3000) {
                            WaypointMissionInfoInternalParser.this.iWaypointUploadStatusListener.onTimeOut();
                            long unused2 = WaypointMissionInfoInternalParser.this.respondTime_Upload = System.currentTimeMillis();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addRealTimeWaypointInfoListener(String str, AutelMissionInterface.IWaypointRealtimeInfoListener iWaypointRealtimeInfoListener) {
        this.WpRealTimeInfoListenerMaps.put(str, iWaypointRealtimeInfoListener);
    }

    public void removeRealTimeWaypointInfoListener(String str) {
        this.WpRealTimeInfoListenerMaps.remove(str);
    }

    private void callbackRealTimeInfo(final AutelWaypointRealTimeInfoInternal autelWaypointRealTimeInfoInternal) {
        if (!this.WpRealTimeInfoListenerMaps.isEmpty()) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    for (AutelMissionInterface.IWaypointRealtimeInfoListener onWaypointRealtimeInfo : WaypointMissionInfoInternalParser.this.WpRealTimeInfoListenerMaps.values()) {
                        onWaypointRealtimeInfo.onWaypointRealtimeInfo(autelWaypointRealTimeInfoInternal);
                    }
                }
            });
        }
    }

    private void parseMsg(mavlink_msg_mission_new_current mavlink_msg_mission_new_current) {
        short s = mavlink_msg_mission_new_current.seq;
        if (s >= 0 && s < this.mission_Autel_waypoints.size()) {
            setVelocitySpeed(mavlink_msg_mission_new_current.velocity_sp);
            setSeq(s);
            if (this.mission_Autel_waypoints.size() > 0 && this.mission_Autel_waypoints.get(s) != null) {
                setNextWaypointCoord(this.mission_Autel_waypoints.get(s).getAutelCoordinate3D());
            }
        }
    }

    private void clearAllData() {
        this.waypointCount = 0;
        this.mission.clear();
        this.mission_Autel_waypoints.clear();
        this.respondTime_Request = 0;
        this.respondTime_Upload = 0;
    }

    public CurrentMissionState getCurrentMissionState() {
        return MissionStateParser.getInstance_().getCurrentMissionState();
    }
}
