package com.autel.camera.communication.http.events;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.camera.CameraManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.Histogram;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraAllSettingsWithParser;
import com.autel.camera.protocol.protocol20.entity.CameraDeviceStatus;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.interfaces.base.BaseCameraService;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.CameraProduct;
import com.autel.common.error.AutelError;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.base.BaseCameraData;
import com.autel.internal.sdk.camera.data.model.CameraXB008Data;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.utils.MessageParser;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CameraMessageDisPatcher<T> {
    private static final String TAG = "MessageDisPatcher";
    private final int STATUS_REQUESTING;
    private final int STATUS_REQUEST_FAILED;
    private final int STATUS_REQUEST_SUC;
    private BaseCameraService baseCameraService;
    private boolean isInit;
    private ConcurrentHashMap<String, CallbackWithOneParam<T>> listenerManager;
    private final ConcurrentHashMap<String, IConnectionListener> mConnectionListeners;
    private MessageParser mMessageParser;
    /* access modifiers changed from: private */
    public final AtomicInteger mRequestDeviceStatus;
    /* access modifiers changed from: private */
    public final AtomicInteger mRequestSystemTimeStatus;

    public void onDisPatchPacket(String str) {
    }

    private CameraMessageDisPatcher() {
        this.baseCameraService = CameraFactory.getCameraProduct(BaseCamera20.class);
        this.listenerManager = new ConcurrentHashMap<>();
        this.mConnectionListeners = new ConcurrentHashMap<>();
        this.STATUS_REQUESTING = 0;
        this.STATUS_REQUEST_SUC = 1;
        this.STATUS_REQUEST_FAILED = 2;
        this.mRequestDeviceStatus = new AtomicInteger(2);
        this.mRequestSystemTimeStatus = new AtomicInteger(2);
        this.mMessageParser = new MessageParser();
        initHandler();
    }

    public static CameraMessageDisPatcher instance() {
        return CameraMessageDisPatcherHolder.s_instance;
    }

    private static class CameraMessageDisPatcherHolder {
        /* access modifiers changed from: private */
        public static final CameraMessageDisPatcher s_instance = new CameraMessageDisPatcher();

        private CameraMessageDisPatcherHolder() {
        }
    }

    public void resetData() {
        this.isInit = false;
        this.mRequestDeviceStatus.set(2);
        this.mRequestSystemTimeStatus.set(2);
    }

    private void initHandler() {
        CameraManager2.instance().setCameraEventsListener(TAG, new CallbackWithOneParam<String>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(String str) {
                CameraMessageDisPatcher.this.processPacket(str);
            }
        });
    }

    public void registerReceiveListener(String str, CallbackWithOneParam<T> callbackWithOneParam) {
        this.listenerManager.put(str, callbackWithOneParam);
    }

    public void unRegisterReceiveListener(String str) {
        this.listenerManager.remove(str);
    }

    /* access modifiers changed from: private */
    public void processPacket(String str) {
        HashMap<String, String> parserJson = this.mMessageParser.parserJson(str);
        if (parserJson != null && parserJson.size() != 0) {
            try {
                process(parserJson);
            } catch (Exception e) {
                e.printStackTrace();
                AutelLog.m15084e(TAG, "ProcessPacketTask Exception----->>> " + e.getMessage());
            }
        }
    }

    private void process(HashMap<String, String> hashMap) {
        CameraEvents cameraEvents;
        String str;
        String str2 = hashMap.get(CameraParamsConfig.param_SetShutter_Type);
        String str3 = hashMap.get("Data");
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            HashMap<String, String> parserJson = this.mMessageParser.parserJson(str3);
            str2.hashCode();
            if (str2.equals(CameraConstant20.HISTOGRAM)) {
                Object object = this.mMessageParser.getObject(str3, Histogram.class);
                str = CameraConstant20.CameraHistogramListener;
                cameraEvents = object;
            } else if (!str2.equals(CameraConstant20.SYSTEM_STATUS)) {
                CameraEvents cameraEvents2 = new CameraEvents();
                cameraEvents2.setType(str2);
                cameraEvents2.setMap(parserJson);
                updateEvents(str2, parserJson);
                str = CameraConstant20.CameraEventsListener;
                cameraEvents = cameraEvents2;
            } else {
                Object object2 = this.mMessageParser.getObject(str3, CameraSystemStatus.class);
                updateCameraStatus((CameraSystemStatus) object2);
                if (!PacketDisPatcher.getInstance().isUpgrading()) {
                    requestCamera20();
                }
                str = CameraConstant20.SystemStatusListener;
                cameraEvents = object2;
            }
            dispatchPacket(str, cameraEvents);
        }
    }

    private void updateEvents(String str, HashMap<String, String> hashMap) {
        BaseCameraData baseCameraData = CameraModelDataManager.instance().getBaseCameraData();
        if (!CameraConstant20.CAMERA_TYPE_SDCARD_STATUS.equalsIgnoreCase(str)) {
            return;
        }
        if (baseCameraData instanceof CameraXB008Data) {
            CameraXB008Data.instance().setCardStatus(hashMap.get(CameraConstant20.CAMERA_TYPE_SDCARD_STATUS));
        } else if (baseCameraData instanceof CameraXB015Data) {
            CameraXB015Data.instance().setCardStatus(hashMap.get(CameraConstant20.CAMERA_TYPE_SDCARD_STATUS));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = r2.listenerManager.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dispatchPacket(java.lang.String r3, final java.lang.Object r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.autel.common.CallbackWithOneParam<T>> r0 = r2.listenerManager
            java.lang.Object r3 = r0.get(r3)
            if (r3 == 0) goto L_0x0017
            com.autel.internal.sdk.product.datapost.MsgPostManager r0 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()
            com.autel.camera.communication.http.events.CameraMessageDisPatcher$2 r1 = new com.autel.camera.communication.http.events.CameraMessageDisPatcher$2
            r1.<init>(r3, r4)
            r0.post(r1)
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.communication.http.events.CameraMessageDisPatcher.dispatchPacket(java.lang.String, java.lang.Object):void");
    }

    private void updateCameraStatus(CameraSystemStatus cameraSystemStatus) {
        CameraManager.instance().setCameraModel(cameraSystemStatus.getCameraType());
        if (!this.isInit) {
            this.isInit = true;
            initModeData();
        }
        CameraAllSettingsWithParser.instance().putCameraStatusValue(cameraSystemStatus);
    }

    public void registerConnectListener(String str, IConnectionListener iConnectionListener) {
        if (!this.mConnectionListeners.containsKey(str) && iConnectionListener != null) {
            AutelLog.m15090w("xxxx", "camera registerConnectListener " + str);
            this.mConnectionListeners.put(str, iConnectionListener);
        }
    }

    public void unRegisterConnectListener(String str) {
        AutelLog.m15090w("xxxx", "camera unRegisterConnectListener " + str);
        this.mConnectionListeners.remove(str);
    }

    private void notifyConnected() {
        boolean z = this.baseCameraService.getProduct() == CameraProduct.UNKNOWN;
        AutelLog.debug_i(TAG, "camera notifyConnected " + z + " mConnectionListeners " + this.mConnectionListeners.size());
        if (!z) {
            for (IConnectionListener onConnectStatus : this.mConnectionListeners.values()) {
                onConnectStatus.onConnectStatus(ConnectConnectStatus.CONNECTED);
            }
        }
    }

    private void initModeData() {
        CameraXB015Data instance = CameraXB015Data.instance();
        int i = C22725.$SwitchMap$com$autel$common$camera$CameraProduct[this.baseCameraService.getProduct().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            instance = CameraXB015Data.instance();
        }
        AutelLog.debug_i("camera", "current camera:" + instance);
        CameraModelDataManager.instance().setBaseCameraData(instance);
    }

    /* renamed from: com.autel.camera.communication.http.events.CameraMessageDisPatcher$5 */
    /* synthetic */ class C22725 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$CameraProduct;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.autel.common.camera.CameraProduct[] r0 = com.autel.common.camera.CameraProduct.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$CameraProduct = r0
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XB015     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT701     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT705     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT706     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x003e }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.R12     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.communication.http.events.CameraMessageDisPatcher.C22725.<clinit>():void");
        }
    }

    private void requestCamera20() {
        if (this.mRequestDeviceStatus.compareAndSet(2, 0)) {
            AutelLog.debug_i(TAG, "requestCamera20 getCameraDeviceStatus ----->>> ");
            this.baseCameraService.getCameraDeviceStatus(new CallbackWithOneParam<CameraDeviceStatus>() {
                public void onSuccess(CameraDeviceStatus cameraDeviceStatus) {
                    if (cameraDeviceStatus != null) {
                        AutelLog.debug_i(CameraMessageDisPatcher.TAG, "getCameraDeviceStatus- getSensorStatus ---->>> " + cameraDeviceStatus.getSensorStatus());
                        if (cameraDeviceStatus == null || cameraDeviceStatus.getSensorStatus() != 1) {
                            CameraMessageDisPatcher.this.mRequestDeviceStatus.set(2);
                        } else {
                            CameraMessageDisPatcher.this.mRequestDeviceStatus.set(1);
                        }
                    }
                }

                public void onFailure(AutelError autelError) {
                    AutelLog.debug_i(CameraMessageDisPatcher.TAG, "getCameraDeviceStatus- onFailure ---->>> " + autelError.getDescription());
                    CameraMessageDisPatcher.this.mRequestDeviceStatus.set(2);
                }
            });
        }
        if (this.mRequestDeviceStatus.get() == 1 && this.mRequestSystemTimeStatus.compareAndSet(2, 0)) {
            AutelLog.m15090w(TAG, "getCameraDeviceStatus setCameraCurrentData----->>> ");
            setCameraCurrentData();
        }
    }

    private void setCameraCurrentData() {
        this.mRequestSystemTimeStatus.set(1);
        notifyConnected();
        this.baseCameraService.setCameraCurrentDate(new CallbackWithNoParam() {
            public void onSuccess() {
                CameraMessageDisPatcher.this.mRequestSystemTimeStatus.set(1);
                AutelLog.m15082d(CameraMessageDisPatcher.TAG, "setCameraCurrentDate success ");
            }

            public void onFailure(AutelError autelError) {
                CameraMessageDisPatcher.this.mRequestSystemTimeStatus.set(2);
            }
        });
    }
}
