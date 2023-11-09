package com.autel.libupdrage.upgrade.request;

import com.autel.common.CallbackWithOneParam;
import com.autel.libupdrage.upgrade.entity.DownloadBeanInfo;
import com.autel.libupdrage.upgrade.entity.UpgradeBeanInfo;
import com.autel.util.okhttp.callback.ResponseCallBack;
import java.io.File;
import java.util.List;

public class UpgradeRequest extends BaseRequest {
    public void checkUpgrade(UpgradeBeanInfo upgradeBeanInfo, CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam) {
        request(upgradeBeanInfo, callbackWithOneParam);
    }

    public void downloadFile(String str, String str2, ResponseCallBack<File> responseCallBack) {
        this.mOkHttpManager.download(str, str2, responseCallBack);
    }
}
