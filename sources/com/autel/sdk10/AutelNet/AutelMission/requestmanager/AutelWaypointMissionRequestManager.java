package com.autel.sdk10.AutelNet.AutelMission.requestmanager;

import com.autel.common.error.AutelError;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.internal.sdk.mission.MissionStatus;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.WaypointMavLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import com.autel.sdk10.AutelNet.AutelMission.utils.TransformUtils;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftRequestManager;
import com.autel.util.log.AutelLog;
import java.util.ArrayList;
import java.util.List;

public class AutelWaypointMissionRequestManager extends BaseRequestManager {
    /* access modifiers changed from: private */
    public AutelMissionInterface.IWaypointMissionDownloadListener iWaypointMissionDownloadListener;
    /* access modifiers changed from: private */
    public AutelMissionInterface.IWaypointMissionUploadListener iWaypointMissionUploadListener;

    public void startWayPointMission(int i, AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createGoMessagePacket(i));
        waitForResponse(252, iCompletionCallbackWith);
    }

    /* renamed from: com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelWaypointMissionRequestManager$8 */
    /* synthetic */ class C50368 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$sdk$mission$MissionStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.internal.sdk.mission.MissionStatus[] r0 = com.autel.internal.sdk.mission.MissionStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$sdk$mission$MissionStatus = r0
                com.autel.internal.sdk.mission.MissionStatus r1 = com.autel.internal.sdk.mission.MissionStatus.CONTINUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$mission$MissionStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.mission.MissionStatus r1 = com.autel.internal.sdk.mission.MissionStatus.PAUSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$mission$MissionStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.sdk.mission.MissionStatus r1 = com.autel.internal.sdk.mission.MissionStatus.CANCEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelWaypointMissionRequestManager.C50368.<clinit>():void");
        }
    }

    public void setWayPointMissionStatus(MissionStatus missionStatus, final AutelCompletionCallback.ICompletionCallbackWith<MissionStatus> iCompletionCallbackWith) {
        int i = C50368.$SwitchMap$com$autel$internal$sdk$mission$MissionStatus[missionStatus.ordinal()];
        if (i == 1) {
            checkValueValid(iCompletionCallbackWith);
            startWayPointMission(5, new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
                public void onResult(Boolean bool) {
                    AutelWaypointMissionRequestManager.this.callbackResult(iCompletionCallbackWith, MissionStatus.CONTINUE);
                }

                public void onFailure(AutelError autelError) {
                    AutelWaypointMissionRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
                }
            });
        } else if (i == 2) {
            checkValueValid(iCompletionCallbackWith);
            AutelAircraftRequestManager.getAutelMissionCommonRequestManager().halt(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
                public void onResult(Integer num) {
                    AutelWaypointMissionRequestManager.this.callbackResult(iCompletionCallbackWith, MissionStatus.PAUSE);
                }

                public void onFailure(AutelError autelError) {
                    AutelWaypointMissionRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
                }
            });
        } else if (i == 3) {
            StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createControlOrbitMisssionPacket(missionStatus.getValue()));
            waitForResponse(107, iCompletionCallbackWith);
        }
    }

    public void requestCurrentWaypointMission(AutelMissionInterface.IWaypointMissionDownloadListener iWaypointMissionDownloadListener2) {
        this.iWaypointMissionDownloadListener = iWaypointMissionDownloadListener2;
        final int[] iArr = {0, 0, 0, 0};
        MissionManager.getAutelWaypointMissionInfoParser().setIRequestCurrentWaypointMissionListener(new AutelMissionInterface.ICurrentWaypointMissionRequestListener() {
            public void onStartRequest(boolean z) {
                AutelLog.m15084e("requestCurrentWaypointMission", "onStartRequest " + z);
                if (!z && AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null) {
                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWaypointsListPacket());
                }
            }

            public void onRecWaypointCount(int i) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRecWaypointCount ");
                sb.append(AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null);
                sb.append("  totalCount == ");
                sb.append(i);
                AutelLog.m15084e("requestCurrentWaypointMission", sb.toString());
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null) {
                    int[] iArr = iArr;
                    iArr[0] = 0;
                    iArr[1] = 1;
                    iArr[2] = i;
                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWayPointPacket(0));
                }
            }

            public void onDownloadWaypointInfo(final int i, final int i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onDownloadWaypointInfo ");
                sb.append(AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null);
                sb.append("  index == ");
                sb.append(i);
                sb.append("  totalCount == ");
                sb.append(i2);
                AutelLog.m15084e("requestCurrentWaypointMission", sb.toString());
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iArr[0] = 0;
                            iArr[1] = 2;
                            iArr[2] = i2;
                            iArr[3] = i + 1;
                            AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener.onProgress(((float) (i + 1)) / ((float) i2));
                        }
                    });
                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWayPointPacket(iArr[3]));
                }
            }

            public void onEndRequest(final ArrayList<Waypoint> arrayList) {
                StringBuilder sb = new StringBuilder();
                sb.append("onEndRequest ");
                sb.append(AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null);
                sb.append("  var == ");
                sb.append(arrayList.size());
                AutelLog.m15084e("requestCurrentWaypointMission", sb.toString());
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener.onProgress(1.0f);
                            StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createSendWaypointAckPacket());
                            AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener.onResult(arrayList);
                            MissionManager.getAutelWaypointMissionInfoParser().setIRequestCurrentWaypointMissionListener((AutelMissionInterface.ICurrentWaypointMissionRequestListener) null);
                        }
                    });
                }
            }

            public void onTimeOut() {
                StringBuilder sb = new StringBuilder();
                sb.append("onTimeOut ");
                sb.append(AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null);
                AutelLog.m15084e("requestCurrentWaypointMission", sb.toString());
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            if (iArr[0] < 3) {
                                int i = iArr[1];
                                if (i == 0) {
                                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWaypointsListPacket());
                                } else if (i == 1) {
                                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWayPointPacket(0));
                                } else if (i == 2) {
                                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createRequestWayPointPacket(iArr[3]));
                                }
                                int[] iArr = iArr;
                                iArr[0] = iArr[0] + 1;
                                AutelLog.m15084e("requestCurrentWaypointMission", "retry " + iArr[0]);
                                return;
                            }
                            AutelWaypointMissionRequestManager.this.iWaypointMissionDownloadListener.onResult((ArrayList<Waypoint>) null);
                            MissionManager.getAutelWaypointMissionInfoParser().setIRequestCurrentWaypointMissionListener((AutelMissionInterface.ICurrentWaypointMissionRequestListener) null);
                            AutelLog.m15084e("requestCurrentWaypointMission", "onTimeOut ");
                        }
                    });
                }
            }
        });
    }

    public void cancelRequestCurrentWaypointMission() {
        this.iWaypointMissionDownloadListener = null;
        MissionManager.getAutelWaypointMissionInfoParser().setIRequestCurrentWaypointMissionListener((AutelMissionInterface.ICurrentWaypointMissionRequestListener) null);
    }

    public void uploadWaypoint(final List<Waypoint> list, AutelMissionInterface.IWaypointMissionUploadListener iWaypointMissionUploadListener2) {
        this.iWaypointMissionUploadListener = iWaypointMissionUploadListener2;
        final int[] iArr = {0, 0, 0};
        MissionManager.getAutelWaypointMissionInfoParser().setIWaypointUploadStatusListener(list, new AutelMissionInterface.IWaypointUploadStatusListener() {
            public void onStartUpload(boolean z) {
                if (!z && AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener != null) {
                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createSendWaypointCountPacket(list.size()));
                }
            }

            public void onUploadWaypoint(final int i) {
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            int i = 0;
                            iArr[0] = 0;
                            iArr[1] = 1;
                            iArr[2] = i;
                            AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener.onProgress(((float) (i + 1)) / ((float) list.size()));
                            if (i == 0) {
                                i = 1;
                            }
                            StarLinkClientManager.getInstance_().sendMavPacket(TransformUtils.Waypoint2msg_mission_item((Waypoint) list.get(i), i, i).pack());
                        }
                    });
                }
            }

            public void onEndUpload(final boolean z) {
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener.onResult(z);
                            StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createSendWaypointAckPacket());
                            MissionManager.getAutelWaypointMissionInfoParser().clearIWaypointUploadStatusListener();
                        }
                    });
                }
            }

            public void onTimeOut() {
                if (AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener != null) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            if (iArr[0] < 3) {
                                int i = iArr[1];
                                if (i == 0) {
                                    StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.createSendWaypointCountPacket(list.size()));
                                } else if (i == 1) {
                                    StarLinkClientManager.getInstance_().sendMavPacket(TransformUtils.Waypoint2msg_mission_item((Waypoint) list.get(iArr[2])).pack());
                                }
                                int[] iArr = iArr;
                                iArr[0] = iArr[0] + 1;
                                return;
                            }
                            AutelWaypointMissionRequestManager.this.iWaypointMissionUploadListener.onResult(false);
                            MissionManager.getAutelWaypointMissionInfoParser().clearIWaypointUploadStatusListener();
                        }
                    });
                }
            }
        });
    }

    public void cancelUploadWaypoint() {
        this.iWaypointMissionUploadListener = null;
        MissionManager.getAutelWaypointMissionInfoParser().clearIWaypointUploadStatusListener();
    }

    public void addRealTimeWaypointInfoListener(String str, AutelMissionInterface.IWaypointRealtimeInfoListener iWaypointRealtimeInfoListener) {
        MissionManager.getAutelWaypointMissionInfoParser().addRealTimeWaypointInfoListener(str, iWaypointRealtimeInfoListener);
    }

    public void removeRealTimeWaypointInfoListener(String str) {
        MissionManager.getAutelWaypointMissionInfoParser().removeRealTimeWaypointInfoListener(str);
    }

    private void clearAllWaypoint() {
        StarLinkClientManager.getInstance_().sendMavPacket(WaypointMavLinkPacketFactory.clearAllWaypoint());
    }

    public synchronized void remove1TimeCallbacksFromClass(Object obj) {
        super.remove1TimeCallbacksFromClass(obj);
        String str = obj.getClass().getName() + "$";
        AutelMissionInterface.IWaypointMissionDownloadListener iWaypointMissionDownloadListener2 = this.iWaypointMissionDownloadListener;
        if (iWaypointMissionDownloadListener2 != null && iWaypointMissionDownloadListener2.getClass().getName().startsWith(str)) {
            cancelRequestCurrentWaypointMission();
        }
        AutelMissionInterface.IWaypointMissionUploadListener iWaypointMissionUploadListener2 = this.iWaypointMissionUploadListener;
        if (iWaypointMissionUploadListener2 != null && iWaypointMissionUploadListener2.getClass().getName().startsWith(str)) {
            cancelUploadWaypoint();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (i != 107) {
            if (i != 252) {
                if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iCompletionCallbackWith.onResult(Integer.valueOf((int) MissionManager.getAutelMissionInfoParser().getResult(i)));
                        }
                    });
                    return true;
                }
            } else if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        iCompletionCallbackWith.onResult(Boolean.valueOf(MissionManager.getAutelMissionInfoParser().getResult(i) == 0.0f));
                    }
                });
                return true;
            }
        } else if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    int result = (int) MissionManager.getAutelMissionInfoParser().getResult(i);
                    if (result == 2) {
                        iCompletionCallbackWith.onResult(MissionStatus.CONTINUE);
                    } else if (result == 3) {
                        iCompletionCallbackWith.onResult(MissionStatus.PAUSE);
                    } else if (result == 4) {
                        iCompletionCallbackWith.onResult(MissionStatus.CANCEL);
                    }
                }
            });
            return true;
        }
        return false;
    }
}
