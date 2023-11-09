package com.autel.libupdrage.upgrade.interfaces;

import com.autel.AutelNet2.aircraft.firmware.bean.UpgradeStatus;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.product.AutelProductType;
import com.autel.internal.sdk.upgrade.CallBackWithOneParamProgressFirmwareUpgrade;
import com.autel.libupdrage.upgrade.entity.DownloadBeanInfo;
import com.autel.util.okhttp.callback.ResponseCallBack;
import java.io.File;
import java.util.List;

public interface AutelUpgrade {
    void downloadUpgradeFile(String str, String str2, ResponseCallBack<File> responseCallBack);

    void requestServer(AutelProductType autelProductType, String str, CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam);

    void requestServer(String str, CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam);

    void startUpgrade(File file, String str, CallBackWithOneParamProgressFirmwareUpgrade<UpgradeStatus> callBackWithOneParamProgressFirmwareUpgrade);
}
