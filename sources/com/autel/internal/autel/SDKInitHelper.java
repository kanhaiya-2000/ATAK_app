package com.autel.internal.autel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.authorization.AuthorityManager;
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.internal.autel.heartbeat.HeartBeatListener;
import com.autel.internal.network.NetworkManager;
import com.autel.internal.network.interfaces.IAutelNetworkConnectionListener;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.internal.product.BaseProductImpl;
import com.autel.internal.product.ProductFactory;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.internal.video.core.decoder2.CodecManager;
import com.autel.sdk.AutelSdkConfig;
import com.autel.sdk.ProductConnectListener;
import com.autel.sdk.product.BaseProduct;
import com.autel.util.log.AutelLog;
import com.autel.video.NetWorkProxyJni;
import java.util.concurrent.atomic.AtomicBoolean;

public class SDKInitHelper {
    private static final String NETWORK_LISTENER_TAG = "networkListenerTag";
    private static final String TAG = "Autel_SDK";
    private static SDKInitHelper initHelper;
    private AtomicBoolean atached = new AtomicBoolean(false);
    private AuthorityManager authorityManager = AuthorityManager.getInstance();
    private volatile AutelServiceVersion currentVersion;
    /* access modifiers changed from: private */
    public ProductConnectListener initListener;
    /* access modifiers changed from: private */
    public volatile BaseProductImpl mBaseProduct;
    private Context mContext;
    /* access modifiers changed from: private */
    public ProductConnectionManager productConnectionManager;
    /* access modifiers changed from: private */
    public AutelStateManager stateManager;

    public static SDKInitHelper instance() {
        return initHelper;
    }

    public static void init(Context context, AutelSdkConfig.VersionDetect versionDetect) {
        if (initHelper == null) {
            synchronized (SDKInitHelper.class) {
                if (initHelper == null) {
                    initHelper = new SDKInitHelper(context, versionDetect);
                }
            }
        }
    }

    private SDKInitHelper(Context context, AutelSdkConfig.VersionDetect versionDetect) {
        Log.v("sdkInit", "SDKInitHelper " + this);
        this.stateManager = new AutelStateManager(context);
        this.mContext = context;
        AutelBaseApplication.setAppContext(context.getApplicationContext());
        this.productConnectionManager = new ProductConnectionManager(versionDetect, this.stateManager, new HeartBeatListener() {
            public void connect(AutelServiceVersion autelServiceVersion, AutelProductType autelProductType) {
                Log.v("testuuuu", "ProductConnectionManager connect  connect  connect  connect");
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "HeartBeatListener app connect to " + autelProductType);
                SDKInitHelper.this.initProduct(autelServiceVersion, autelProductType);
            }

            public void disconnect() {
                Log.v("testuuuu", "ProductConnectionManager dis  dis  dis  dis connect");
                StringBuilder sb = new StringBuilder();
                sb.append("HeartBeatListener app disconnect from ");
                sb.append(SDKInitHelper.this.mBaseProduct == null ? "null" : SDKInitHelper.this.mBaseProduct.getType());
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, sb.toString());
                SDKInitHelper.this.disconnect();
            }
        });
    }

    public void attach(String str, CallbackWithNoParam callbackWithNoParam) {
        if (this.atached.compareAndSet(false, true)) {
            checkAppKeyValid(str, callbackWithNoParam);
            NetWorkProxyJni.stopProxy();
            NetWorkProxyJni.startProxy();
            NetworkManager.getInstance(this.mContext).registerReceiver();
            setNetworkConnectionListener();
            this.mContext.startService(new Intent(this.mContext, AutelService.class));
            CodecManager.getInstance().initCodec();
        }
    }

    public void attach(AutelSdkConfig autelSdkConfig, CallbackWithNoParam callbackWithNoParam) {
        attach(autelSdkConfig.getAppKey(), callbackWithNoParam);
    }

    public void detach() {
        if (this.atached.compareAndSet(true, false)) {
            NetworkManager.getInstance(this.mContext).removeIAutelNetworkConnectionListener(NETWORK_LISTENER_TAG);
            NetworkManager.getInstance(this.mContext).unregisterReceiver();
            disconnect();
            ProductConnectionManager productConnectionManager2 = this.productConnectionManager;
            if (productConnectionManager2 != null) {
                productConnectionManager2.closeConnection();
            }
            if (this.mBaseProduct != null) {
                this.mBaseProduct.productDestroy();
                this.mBaseProduct = null;
            }
            this.initListener = null;
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "sdk init helper detach  ");
            CodecManager.getInstance().destroyCodec();
        }
    }

    public void setProductConnectListener(ProductConnectListener productConnectListener) {
        this.initListener = productConnectListener;
        if (productConnectListener != null && this.mBaseProduct != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    if (SDKInitHelper.this.initListener != null) {
                        SDKInitHelper.this.initListener.productConnected(SDKInitHelper.this.mBaseProduct);
                    }
                }
            });
        }
    }

    public BaseProduct getProduct() {
        return this.mBaseProduct;
    }

    /* access modifiers changed from: private */
    public void initProduct(AutelServiceVersion autelServiceVersion, AutelProductType autelProductType) {
        boolean z = (this.mBaseProduct != null && this.mBaseProduct.getType() == autelProductType && this.currentVersion == autelServiceVersion) ? false : true;
        Log.v("checkversion", "productChanged " + z + " currentVersion " + this.currentVersion + " productType " + autelProductType + " version " + autelServiceVersion + " mBaseProduct " + this.mBaseProduct);
        if (this.mBaseProduct != null) {
            Log.v("checkversion", "mBaseProduct " + this.mBaseProduct.getType());
        }
        this.currentVersion = autelServiceVersion;
        if (z) {
            this.mBaseProduct = ProductFactory.createProduct(autelProductType, autelServiceVersion, this.stateManager);
        }
        AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "initProduct send msg to connect  " + this.mBaseProduct);
        if (this.mBaseProduct != null) {
            this.mBaseProduct.productInit();
            this.mBaseProduct.productConnected();
            if (this.initListener != null) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "post connect msg id  " + this + " initListener " + SDKInitHelper.this.initListener);
                        if (SDKInitHelper.this.initListener != null) {
                            SDKInitHelper.this.initListener.productConnected(SDKInitHelper.this.mBaseProduct);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void disconnect() {
        final ProductConnectListener productConnectListener = this.initListener;
        if (productConnectListener != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    ProductConnectListener productConnectListener = productConnectListener;
                    if (productConnectListener != null) {
                        productConnectListener.productDisconnected();
                    }
                }
            });
        }
        if (this.mBaseProduct != null) {
            this.mBaseProduct.productDisconnect();
        }
    }

    private void checkAppKeyValid(String str, final CallbackWithNoParam callbackWithNoParam) {
        Log.v("AuthorTest", "checkAppKeyValid begin");
        this.authorityManager.startCheckKeyValidateState(this.mContext, str, new CallbackWithOneParam<AuthorityState>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(AuthorityState authorityState) {
                SDKInitHelper.this.stateManager.setSdkValidate(authorityState);
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }
        });
    }

    private void setNetworkConnectionListener() {
        NetworkManager.getInstance(this.mContext).addIAutelNetworkConnectionListener(NETWORK_LISTENER_TAG, new IAutelNetworkConnectionListener() {
            public void onWifiConnected() {
                AuthorityManager.getInstance().notifyForValidateCheck();
                Log.e(SDKInitHelper.TAG, "onWifiConnected  isUsbOpened " + AutelUSBHelper.instance().isUsbOpened());
                SDKInitHelper.this.productConnectionManager.startWifiConnection();
            }

            public void onUsbConnected() {
                Log.e(SDKInitHelper.TAG, "onUsbConnected isUsbOpened " + AutelUSBHelper.instance().isUsbOpened());
                SDKInitHelper.this.productConnectionManager.startConnection();
            }

            public void disconnect() {
                Log.e(SDKInitHelper.TAG, "disconnect");
            }
        });
    }

    public void testCheckAuthority(String str, String str2, String str3, final CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
        checkAppKeyValid(str, str2, str3, new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(SDKInitHelper.this.stateManager.getAuthorityState());
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    private void checkAppKeyValid(String str, String str2, String str3, final CallbackWithNoParam callbackWithNoParam) {
        Log.v("AuthorTest", "checkAppKeyValid begin");
        this.authorityManager.startCheckKeyValidateState(str, str2, str3, new CallbackWithOneParam<AuthorityState>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(AuthorityState authorityState) {
                SDKInitHelper.this.stateManager.setSdkValidate(authorityState);
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }
        });
    }
}
