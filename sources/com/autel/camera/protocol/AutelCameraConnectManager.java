package com.autel.camera.protocol;

import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.camera.heartbeat.heartbeat10.CameraHeartBeat10;
import com.autel.camera.heartbeat.heartbeat20.CameraHeartBeat20;
import com.autel.camera.protocol.protocol10.base.BaseCamera10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.interfaces.base.BaseCameraService;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.util.log.AutelLog;

public class AutelCameraConnectManager {
    public static final String TAG = "AutelCameraConnectManager";
    private static AutelCameraConnectManager s_instance = null;
    public static final String setCameraInitTAG = "setCameraInitTAG";
    private BaseCameraService baseCameraService10 = new BaseCamera10();
    private com.autel.camera.protocol.protocol20.interfaces.base.BaseCameraService baseCameraService20 = CameraFactory.getCameraProduct(BaseCamera20.class);
    private volatile boolean isCamera10Connect;
    private volatile boolean isCamera20Connect;

    private AutelCameraConnectManager() {
    }

    public static AutelCameraConnectManager instance() {
        if (s_instance == null) {
            s_instance = new AutelCameraConnectManager();
        }
        return s_instance;
    }

    public void setCameraConnectStatusListener(final CallbackWithTwoParams<CameraProduct, ConnectConnectStatus> callbackWithTwoParams) {
        if (callbackWithTwoParams == null) {
            CameraHeartBeat10.instance().unRegisterConnectListener("setCameraInitTAG");
            CameraHeartBeat20.instance().unRegisterConnectListener("setCameraInitTAG");
            CameraMessageDisPatcher.instance().unRegisterConnectListener("setCameraInitTAG");
            PacketDisPatcher.getInstance().setCameraHeartBeatListener((IConnectionListener) null);
            ConnectionManager2.getInstance_().unRegisterConnectListener("setCameraInitTAG");
            return;
        }
        CameraHeartBeat10.instance().registerConnectListener("setCameraInitTAG", new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                AutelCameraConnectManager.this.dealCamera10Connect(callbackWithTwoParams, connectConnectStatus);
            }
        });
        CameraMessageDisPatcher.instance().registerConnectListener("setCameraInitTAG", new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                AutelLog.m15090w("xxxx", "camera  " + connectConnectStatus);
                AutelCameraConnectManager.this.dealCamera20Connect(callbackWithTwoParams, connectConnectStatus);
            }
        });
        PacketDisPatcher.getInstance().setCameraHeartBeatListener(new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                AutelLog.m15090w("xxxx", "camera  " + connectConnectStatus);
                AutelCameraConnectManager.this.dealCamera20Connect(callbackWithTwoParams, connectConnectStatus);
            }
        });
        ConnectionManager2.getInstance_().registerConnectListener("setCameraInitTAG", new com.autel.AutelNet2.core.interfaces.IConnectionListener() {
            public void startConnect() {
            }

            public void onConnected() {
                AutelLog.m15090w("xxxx", "camera onConnected ");
            }

            public void onDisconnected() {
                AutelLog.m15090w("xxxx", "camera timeout: onDisconnected ");
                AutelCameraConnectManager.this.dealConnectError(callbackWithTwoParams);
            }

            public void onConnectError(String str) {
                AutelCameraConnectManager.this.dealConnectError(callbackWithTwoParams);
                AutelLog.m15090w("xxxx", "camera timeout: onConnectError ");
            }
        });
    }

    /* access modifiers changed from: private */
    public void dealCamera10Connect(CallbackWithTwoParams<CameraProduct, ConnectConnectStatus> callbackWithTwoParams, ConnectConnectStatus connectConnectStatus) {
        if (!this.isCamera20Connect) {
            int i = C22935.f8458xf111a7b7[connectConnectStatus.ordinal()];
            if (i == 1) {
                this.isCamera10Connect = true;
                AutelLog.m15082d(TAG, "CameraHeartBeat10 camera CONNECTED " + this.baseCameraService10.getProduct());
                CameraHeartBeat20.instance().disconnect();
                if (callbackWithTwoParams != null) {
                    callbackWithTwoParams.onSuccess(this.baseCameraService10.getProduct(), ConnectConnectStatus.CONNECTED);
                }
            } else if (i == 2 || i == 3) {
                this.isCamera10Connect = false;
                AutelCameraSettingWithParser10.instance().setCameraModel(CameraProduct.UNKNOWN.getValue());
                AutelLog.m15082d(TAG, "CameraHeartBeat10 camera DISCONNECT");
                if (callbackWithTwoParams != null) {
                    callbackWithTwoParams.onSuccess(CameraProduct.UNKNOWN, ConnectConnectStatus.DISCONNECT);
                }
            }
        }
    }

    /* renamed from: com.autel.camera.protocol.AutelCameraConnectManager$5 */
    /* synthetic */ class C22935 {

        /* renamed from: $SwitchMap$com$autel$internal$sdk$camera$base$ConnectConnectStatus */
        static final /* synthetic */ int[] f8458xf111a7b7;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.internal.sdk.camera.base.ConnectConnectStatus[] r0 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8458xf111a7b7 = r0
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8458xf111a7b7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8458xf111a7b7     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.sdk.camera.base.ConnectConnectStatus r1 = com.autel.internal.sdk.camera.base.ConnectConnectStatus.DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.protocol.AutelCameraConnectManager.C22935.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void dealConnectError(CallbackWithTwoParams<CameraProduct, ConnectConnectStatus> callbackWithTwoParams) {
        AutelLog.m15082d(TAG, "CameraHeartBeatManager20 camera DISCONNECT");
        this.isCamera20Connect = false;
        clearData();
        if (callbackWithTwoParams != null) {
            callbackWithTwoParams.onSuccess(CameraProduct.UNKNOWN, ConnectConnectStatus.DISCONNECT);
        }
    }

    /* access modifiers changed from: private */
    public void dealCamera20Connect(CallbackWithTwoParams<CameraProduct, ConnectConnectStatus> callbackWithTwoParams, ConnectConnectStatus connectConnectStatus) {
        if (!this.isCamera10Connect) {
            int i = C22935.f8458xf111a7b7[connectConnectStatus.ordinal()];
            if (i == 1) {
                this.isCamera20Connect = true;
                AutelLog.m15082d(TAG, "CameraHeartBeatManager20 camera CONNECTED");
                CameraHeartBeat10.instance().disconnect();
                if (callbackWithTwoParams != null) {
                    callbackWithTwoParams.onSuccess(this.baseCameraService20.getProduct(), ConnectConnectStatus.CONNECTED);
                }
            } else if (i == 2 || i == 3) {
                AutelLog.m15082d(TAG, "CameraHeartBeatManager20 camera DISCONNECT");
                this.isCamera20Connect = false;
                clearData();
                if (callbackWithTwoParams != null) {
                    callbackWithTwoParams.onSuccess(CameraProduct.UNKNOWN, ConnectConnectStatus.DISCONNECT);
                }
            }
        }
    }

    private void clearData() {
        CameraManager.instance().setParameterValid(false);
        CameraMessageDisPatcher.instance().resetData();
        CameraManager.instance().setCameraModel(CameraProduct.UNKNOWN.getValue());
    }
}
