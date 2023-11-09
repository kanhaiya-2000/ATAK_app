package com.autel.internal.camera.product;

import android.util.Log;
import com.autel.camera.communication.CameraConnection;
import com.autel.camera.protocol.AutelCameraConnectManager;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.AutelVersionService;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.camera.BaseCameraService4Initialize;
import com.autel.internal.camera.CameraFactory;
import com.autel.internal.camera.UnknownCamera;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.util.log.AutelLog;

public class CameraManager implements CameraManagerService {
    private static CameraManager instance = null;
    public static final String setCameraInitTAG = "setCameraInitTAG";
    /* access modifiers changed from: private */
    public CallbackWithTwoParams<CameraProduct, AutelBaseCamera> cameraConnectListener;
    /* access modifiers changed from: private */
    public volatile AutelBaseCamera currentCamera;
    /* access modifiers changed from: private */
    public volatile CameraProduct currentCameraType = CameraProduct.UNKNOWN;
    private boolean hasInit;
    private AutelListenerManager listenerManager = new AutelListenerManager();
    /* access modifiers changed from: private */
    public IAutelStateManager stateManager;

    private CameraManager() {
    }

    public static CameraManager instance() {
        if (instance == null) {
            synchronized (CameraManager.class) {
                if (instance == null) {
                    instance = new CameraManager();
                }
            }
        }
        return instance;
    }

    private synchronized BaseCameraService4Initialize connectMyCamera(CameraProduct cameraProduct) {
        BaseCameraService4Initialize createCameraServer4Initialize;
        createCameraServer4Initialize = CameraFactory.createCameraServer4Initialize(cameraProduct, this.listenerManager);
        if (this.hasInit && createCameraServer4Initialize != null) {
            createCameraServer4Initialize.init(this.stateManager);
            if (cameraProduct == CameraProduct.R12) {
                createCameraServer4Initialize.connect(AutelServiceVersion.SERVICE_10);
            } else {
                createCameraServer4Initialize.connect(AutelServiceVersion.SERVICE_20);
            }
        }
        return createCameraServer4Initialize;
    }

    public void setCameraChangeListener(CallbackWithTwoParams<CameraProduct, AutelBaseCamera> callbackWithTwoParams) {
        this.cameraConnectListener = callbackWithTwoParams;
        if (callbackWithTwoParams != null && this.hasInit) {
            synchronized (this.currentCameraType) {
                Log.v("camera_connect11", "setCameraChangeListener currentCameraType " + this.currentCameraType + " class " + this);
                connectStateChanged(this.currentCameraType);
            }
        }
    }

    public void init(IAutelStateManager iAutelStateManager) {
        this.hasInit = true;
        this.stateManager = iAutelStateManager;
        AutelCameraConnectManager.instance().setCameraConnectStatusListener(new CallbackWithTwoParams<CameraProduct, ConnectConnectStatus>() {
            public void onSuccess(CameraProduct cameraProduct, ConnectConnectStatus connectConnectStatus) {
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "camera connect to  " + cameraProduct + " camera state " + connectConnectStatus);
                if (connectConnectStatus == ConnectConnectStatus.CONNECTED || connectConnectStatus == ConnectConnectStatus.DISCONNECT || connectConnectStatus == ConnectConnectStatus.ERROR) {
                    if (CameraManager.this.stateManager != null) {
                        CameraManager.this.stateManager.setCameraConnected(connectConnectStatus == ConnectConnectStatus.CONNECTED);
                    }
                    synchronized (CameraManager.this.currentCameraType) {
                        CameraManager.this.connectStateChanged(cameraProduct);
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                if (CameraManager.this.cameraConnectListener != null) {
                    CameraManager.this.cameraConnectListener.onFailure(autelError);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void connectStateChanged(CameraProduct cameraProduct) {
        Log.v("camera_connect1", "connectStateChanged " + cameraProduct + "class " + this);
        AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "camera connect from " + this.currentCameraType + " to  " + cameraProduct);
        if (this.currentCameraType != cameraProduct) {
            Log.v("camera_connect11", " connectStateChanged product " + cameraProduct + " currentCameraType " + this.currentCameraType);
            this.currentCamera = connectMyCamera(cameraProduct);
            this.currentCameraType = cameraProduct;
            Log.v("camera_connect11", " connectStateChanged product " + cameraProduct + " currentCameraType " + this.currentCameraType);
        }
        disconnectCamera();
    }

    public void connect(AutelServiceVersion autelServiceVersion) {
        AutelLog.m15082d("AbsTcpConnection", "CameraManager zfa----------connect");
        CameraConnection.instance().connect();
    }

    public void disconnect() {
        AutelLog.m15082d("AbsTcpConnection", "CameraManager zfa----------disconnect");
        CameraConnection.instance().disconnect();
    }

    private void disconnectCamera() {
        final CallbackWithTwoParams<CameraProduct, AutelBaseCamera> callbackWithTwoParams = this.cameraConnectListener;
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "camera connectStateChanged cameraConnectListener " + CameraManager.this.cameraConnectListener);
                CallbackWithTwoParams callbackWithTwoParams = callbackWithTwoParams;
                if (callbackWithTwoParams != null) {
                    callbackWithTwoParams.onSuccess(CameraManager.this.currentCameraType == null ? CameraProduct.UNKNOWN : CameraManager.this.currentCameraType, CameraManager.this.currentCamera == null ? new UnknownCamera() : CameraManager.this.currentCamera);
                }
            }
        });
    }

    public void destroy() {
        this.hasInit = false;
        disconnectCamera();
        this.stateManager = null;
        this.cameraConnectListener = null;
        this.listenerManager.clear();
        AutelLog.m15082d("AbsTcpConnection", " CameraManager destroy disconnect");
        AutelCameraConnectManager.instance().setCameraConnectStatusListener((CallbackWithTwoParams<CameraProduct, ConnectConnectStatus>) null);
        if (this.currentCamera != null) {
            ((AutelVersionService) this.currentCamera).destroy();
        }
        instance = null;
    }

    private void connectOnFail() {
        Log.v("camera_connect1", "connectOnFail  ");
        final AutelError checkError = checkError();
        if (this.cameraConnectListener != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    boolean z = checkError == AutelError.SDK_HAS_NOT_CONNECT_TO_CAMERA;
                    if (checkError != null && !z) {
                        CameraManager.this.cameraConnectListener.onFailure(checkError);
                    }
                }
            });
        }
    }

    private AutelError checkError() {
        IAutelStateManager iAutelStateManager;
        if (!this.hasInit || (iAutelStateManager = this.stateManager) == null) {
            return AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        }
        if (!iAutelStateManager.isSdkValidate()) {
            return AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        }
        if (!this.stateManager.isCameraConnected()) {
            return AutelError.SDK_HAS_NOT_CONNECT_TO_CAMERA;
        }
        return null;
    }
}
