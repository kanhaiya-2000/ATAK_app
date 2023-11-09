package com.autel.libupdrage.upgrade.impl;

import android.os.Handler;
import android.os.Message;
import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.firmware.bean.UpgradeStatus;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeNotifyPacket;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeProgressPacket;
import com.autel.AutelNet2.aircraft.firmware.message.UpgradeStartRespPacket;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.interfaces.IConnectionListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.product.AutelProductType;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.internal.sdk.upgrade.CallBackWithOneParamProgressFirmwareUpgrade;
import com.autel.libupdrage.upgrade.entity.DownloadBeanInfo;
import com.autel.libupdrage.upgrade.entity.FirmwareUpgradeError;
import com.autel.libupdrage.upgrade.entity.ModelBean;
import com.autel.libupdrage.upgrade.entity.UpgradeBeanInfo;
import com.autel.libupdrage.upgrade.entity.WeakHandler;
import com.autel.libupdrage.upgrade.interfaces.ModelBUpgrade;
import com.autel.libupdrage.upgrade.message.UpgradeFilePacket;
import com.autel.libupdrage.upgrade.message.UpgradePacket;
import com.autel.libupdrage.upgrade.request.UpgradeRequest;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutelUpgradeImpl extends BaseController<Integer> implements ModelBUpgrade {
    private static final int ERROR_RETRY_COUNT = 1;
    private static final int SEND_UPGRADE_FILE = 6;
    private static final int SEND_UPGRADE_FILE_ERROR = 8;
    private static final int SEND_UPGRADE_FILE_RETRANSMIT = 11;
    private static final int SEND_UPGRADE_FILE_SUCCESS = 10;
    private static final int START_ERROR = 2;
    private static final int START_SUCCESS = 4;
    private static final int START_UPGRADE = 0;
    private static String TAG = "AutelUpgradeImpl";
    private CallBackWithOneParamProgressFirmwareUpgrade<UpgradeStatus> callBackListener;
    private int errorCount = 1;
    private File file;
    /* access modifiers changed from: private */
    public AtomicBoolean hasCallback;
    private String jsonHeadStr;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public UpgradeRequest request = new UpgradeRequest();

    private static class AutelUpgradeImplHandler extends WeakHandler<AutelUpgradeImpl> {
        AutelUpgradeImplHandler(AutelUpgradeImpl autelUpgradeImpl) {
            super(autelUpgradeImpl);
        }

        public void handleMessage(Message message) {
            ((AutelUpgradeImpl) getOwner()).switchHandler(message);
        }
    }

    /* access modifiers changed from: private */
    public void switchHandler(Message message) {
        int i = message.what;
        if (i == 0) {
            sendStartUpgrade(this.file, this.jsonHeadStr);
        } else if (i == 2) {
            int i2 = message.arg1;
            if (i2 == 1) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_REMOTE_BATTERY_LOW);
            } else if (i2 == 2) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_DRONE_BATTERY_LOW);
            } else if (i2 == 4) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_MOTOR_NO_CLOSE);
            } else if (i2 == 80) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_NO_SDCARD);
            } else if (i2 == 96) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_SDCARD_ERROR);
            } else if (i2 == 112) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_SDCARD_FULL);
            } else if (this.errorCount > 0) {
                sendMsg(0, 0, 0, (Object) null);
                this.errorCount--;
            } else {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED);
            }
        } else if (i == 4) {
            this.errorCount = 1;
            sendMsg(6, 0, 0, (Object) null);
        } else if (i == 6) {
            ConnectionManager2.getInstance_().registerConnectListener(TAG, new IConnectionListener() {
                public void onConnected() {
                }

                public void onDisconnected() {
                }

                public void startConnect() {
                }

                public void onConnectError(String str) {
                    AutelUpgradeImpl.this.sendMsg(8, 0, 0, (Object) null);
                }
            });
            try {
                uploadFileToRemote(new FileInputStream(this.file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (i == 8) {
            ConnectionManager2.getInstance_().stopSendFile();
            this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_SEND_FILE_FAIL);
            ConnectionManager2.getInstance_().unRegisterConnectListener(TAG);
            PacketDisPatcher.getInstance().setUpgrading(false);
        } else if (i == 10) {
            this.callBackListener.onSuccess(null);
            ConnectionManager2.getInstance_().setRetry(false);
            ConnectionManager2.getInstance_().unRegisterConnectListener(TAG);
            PacketDisPatcher.getInstance().setUpgrading(false);
        } else if (i == 11) {
            try {
                if (this.file != null) {
                    uploadFileToRemote(new FileInputStream(this.file));
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    protected AutelUpgradeImpl() {
        init();
        initHandler();
    }

    private void initHandler() {
        this.mHandler = new AutelUpgradeImplHandler(this);
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_UPGRADE_NOTIFY_PROGRESS, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_UPGRADE_START_RESP, this);
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, MsgType.AU_UPGRADE_RETRANSMIT, this);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        AutelLog.m15084e("CYK:onReceiveMessage:", "packet:" + baseMsgPacket.toString());
        if (baseMsgPacket instanceof UpgradeProgressPacket) {
            dealProgressMessage(((UpgradeProgressPacket) baseMsgPacket).getUpgradeStatus());
        } else if (baseMsgPacket instanceof UpgradeStartRespPacket) {
            if (this.hasCallback.compareAndSet(false, true)) {
                dealStartMessage(((UpgradeStartRespPacket) baseMsgPacket).getStartStatus());
            }
        } else if (baseMsgPacket instanceof UpgradeNotifyPacket) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceiveMessage:retry ");
            sb.append(baseMsgPacket.toString());
            sb.append(" seekPosition:");
            UpgradeNotifyPacket upgradeNotifyPacket = (UpgradeNotifyPacket) baseMsgPacket;
            sb.append(upgradeNotifyPacket.getSeekPosition());
            AutelLog.debug_i(HttpHeaders.UPGRADE, sb.toString());
            if (upgradeNotifyPacket.getSeekPosition() >= 0) {
                ConnectionManager2.getInstance_().stopSendFile();
                ConnectionManager2.getInstance_().setRetry(true);
                ConnectionManager2.getInstance_().setSeekPosition((long) upgradeNotifyPacket.getSeekPosition());
                sendMsg(11, upgradeNotifyPacket.getSeekPosition(), 0, (Object) null);
            }
        }
    }

    private void dealProgressMessage(UpgradeStatus upgradeStatus) {
        if (this.callBackListener != null) {
            int intValue = Integer.valueOf(upgradeStatus.getUpdateReq()).intValue();
            if (intValue == 0) {
                this.callBackListener.onProgress(upgradeStatus);
                return;
            }
            int i = intValue & 1;
            int i2 = intValue & 2;
            int i3 = intValue & 4;
            int i4 = (intValue >> 4) & 15;
            AutelLog.debug_i("dealProgressMessage:", "updateFileSendS:" + i4);
            if (i == 1) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_REMOTE_BATTERY_LOW);
            } else if (i2 == 1) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_DRONE_BATTERY_LOW);
            } else if (i3 == 1) {
                this.callBackListener.onFailure(FirmwareUpgradeError.FIRMWARE_UPGRADE_FAILED_MOTOR_NO_CLOSE);
            } else if (i4 == 3) {
                this.callBackListener.onProgress(upgradeStatus);
                sendMsg(10, 0, 0, (Object) null);
            } else if (i4 == 4) {
                sendMsg(8, 0, 0, (Object) null);
            } else if (i4 >= 9) {
                ConnectionManager2.getInstance_().setSend_sleep_time(i4);
            }
        }
    }

    private void dealStartMessage(int i) {
        if (i == 0) {
            sendMsg(4, i, 0, (Object) null);
        } else {
            sendMsg(2, i, 0, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        if (baseMsgPacket instanceof UpgradePacket) {
            return null;
        }
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_UPGRADE_NOTIFY_PROGRESS);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_UPGRADE_START_RESP);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, MsgType.AU_UPGRADE_RETRANSMIT);
    }

    public void requestServer(final String str, final CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(List<FirmwareDeviceInfo.VersionBean> list) {
                String str;
                AutelLog.m15084e("CYK:AutelUpgradeImpl.requestServer:onSuccess:", list.size() + " ");
                UpgradeBeanInfo upgradeBeanInfo = new UpgradeBeanInfo();
                ArrayList arrayList = new ArrayList();
                boolean isAircraftConnect = PacketDisPatcher.getInstance().isAircraftConnect();
                Iterator<FirmwareDeviceInfo.VersionBean> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = "V0.0.0.0";
                        break;
                    }
                    FirmwareDeviceInfo.VersionBean next = it.next();
                    if (FirmwareManager.DEV_DSP.equalsIgnoreCase(next.getComponentName())) {
                        str = next.getSoftware();
                        break;
                    }
                }
                for (FirmwareDeviceInfo.VersionBean next2 : list) {
                    if (!"V0.0.0.0".equals(next2.getSoftware()) || isAircraftConnect || !str.equalsIgnoreCase("V0.0.0.0")) {
                        ModelBean modelBean = new ModelBean();
                        modelBean.setItem(next2.getComponentName());
                        modelBean.setBootloaderVersion(next2.getBootloader());
                        modelBean.setSerialNumber(next2.getSerialNumber());
                        modelBean.setHardwareVersion(next2.getHardware());
                        modelBean.setSoftwareVersion(next2.getSoftware());
                        if (FirmwareManager.DEV_CAMERA.equalsIgnoreCase(next2.getComponentName())) {
                            modelBean.setSubtype(CameraXB015Data.instance().getDeviceModel());
                        } else {
                            modelBean.setSubtype("none");
                        }
                        arrayList.add(modelBean);
                    }
                }
                upgradeBeanInfo.setItems(arrayList);
                upgradeBeanInfo.setLanguage(str);
                upgradeBeanInfo.setDeviceType(AutelProductType.EVO.getDescription());
                AutelUpgradeImpl.this.request.checkUpgrade(upgradeBeanInfo, callbackWithOneParam);
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15084e("CYK:requestServer:", autelError.getDescription());
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void requestServer(final AutelProductType autelProductType, final String str, final CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(List<FirmwareDeviceInfo.VersionBean> list) {
                String str;
                AutelLog.m15084e("AutelUpgradeImpl.requestServer:onSuccess:", list.size() + " productType->" + autelProductType);
                UpgradeBeanInfo upgradeBeanInfo = new UpgradeBeanInfo();
                ArrayList arrayList = new ArrayList();
                boolean isAircraftConnect = PacketDisPatcher.getInstance().isAircraftConnect();
                Iterator<FirmwareDeviceInfo.VersionBean> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = "V0.0.0.0";
                        break;
                    }
                    FirmwareDeviceInfo.VersionBean next = it.next();
                    if (FirmwareManager.DEV_DSP.equalsIgnoreCase(next.getComponentName())) {
                        str = next.getSoftware();
                        break;
                    }
                }
                for (FirmwareDeviceInfo.VersionBean next2 : list) {
                    if (!"V0.0.0.0".equals(next2.getSoftware()) || isAircraftConnect || !str.equalsIgnoreCase("V0.0.0.0")) {
                        ModelBean modelBean = new ModelBean();
                        modelBean.setItem(next2.getComponentName());
                        modelBean.setBootloaderVersion(next2.getBootloader());
                        modelBean.setSerialNumber(next2.getSerialNumber());
                        modelBean.setHardwareVersion(next2.getHardware());
                        modelBean.setSoftwareVersion(next2.getSoftware());
                        if (FirmwareManager.DEV_CAMERA.equalsIgnoreCase(next2.getComponentName())) {
                            modelBean.setSubtype(CameraXB015Data.instance().getDeviceModel());
                        } else {
                            modelBean.setSubtype("none");
                        }
                        arrayList.add(modelBean);
                    }
                }
                upgradeBeanInfo.setItems(arrayList);
                upgradeBeanInfo.setLanguage(str);
                upgradeBeanInfo.setDeviceType(autelProductType.getDescription());
                AutelUpgradeImpl.this.request.checkUpgrade(upgradeBeanInfo, callbackWithOneParam);
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15084e("CYK:requestServer:", autelError.getDescription());
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void startUpgrade(File file2, String str, CallBackWithOneParamProgressFirmwareUpgrade<UpgradeStatus> callBackWithOneParamProgressFirmwareUpgrade) {
        this.callBackListener = callBackWithOneParamProgressFirmwareUpgrade;
        this.file = file2;
        this.jsonHeadStr = str;
        sendMsg(0, 0, 0, (Object) null);
    }

    private void sendStartUpgrade(File file2, String str) {
        AutelLog.m15083e("CYK:sendStartUpgrade:File:" + file2.getAbsolutePath() + "  jsonHead:" + str);
        this.hasCallback = new AtomicBoolean(false);
        this.file = file2;
        sendPacket(new UpgradePacket(str), (CallbackWithOneParam) null);
        MsgPostManager.instance().removeCallbacks();
        MsgPostManager.instance().postDelayed(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                if (AutelUpgradeImpl.this.hasCallback.compareAndSet(false, true)) {
                    AutelUpgradeImpl.this.sendMsg(2, 0, 0, (Object) null);
                }
            }
        }, 20000);
    }

    private void uploadFileToRemote(FileInputStream fileInputStream) {
        PacketDisPatcher.getInstance().setUpgrading(true);
        sendPacket(new UpgradeFilePacket(fileInputStream), (CallbackWithOneParam) null);
        AutelLog.debug_i(HttpHeaders.UPGRADE, "uploadFileToRemote:File:" + fileInputStream.toString());
    }

    /* access modifiers changed from: private */
    public void sendMsg(int i, int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        this.mHandler.sendMessage(message);
    }

    public void downloadUpgradeFile(String str, String str2, ResponseCallBack<File> responseCallBack) {
        this.request.downloadFile(str, str2, responseCallBack);
    }
}
