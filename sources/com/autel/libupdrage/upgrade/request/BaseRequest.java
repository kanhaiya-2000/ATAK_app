package com.autel.libupdrage.upgrade.request;

import android.util.Log;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.libupdrage.upgrade.entity.DownloadBeanInfo;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.OkHttpManager;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.callback.ResponseInterface;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.HttpMediaType;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseRequest {
    private static final String SERVER_URL = "http://app.autelrobotics.com/personal_center/index.php/Utils/checkUpgrade";
    private String TAG = "BaseRequest";
    private Gson gsonParser = new Gson();
    private Headers headers = new Headers();
    protected OkHttpManager mOkHttpManager = null;

    public BaseRequest() {
        this.headers.put("Accept", "*/*");
        this.headers.put(HttpHeaders.EXPECT, "100-continue");
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().setConnectTimeout(ConnectionType.DEFAULT_UDP_PING_PERIOD, TimeUnit.MILLISECONDS).setReadTimeout(60000, TimeUnit.MILLISECONDS).setWriteTimeout(60000, TimeUnit.MILLISECONDS).build();
        }
    }

    public <T> void request(T t, final CallbackWithOneParam<List<DownloadBeanInfo>> callbackWithOneParam) {
        this.mOkHttpManager.post(SERVER_URL, this.headers, HttpMediaType.MEDIA_TYPE_JSON, this.gsonParser.toJson((Object) t, (Type) t.getClass()), new ResponseCallBack<List<DownloadBeanInfo>>() {
            public void onSuccess(List<DownloadBeanInfo> list) {
                AutelLog.m15089i("Upgrade ", "onSuccess:" + list.toString());
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(list);
                }
            }

            public void onFailure(Throwable th) {
                AutelLog.m15084e("Upgrade ", "onFailure:" + th.getMessage());
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                }
            }

            public List<DownloadBeanInfo> convert(ResponseInterface responseInterface) {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject = new JSONObject(responseInterface.getString());
                if (jSONObject.getInt("code") == 1) {
                    JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("downloadItems");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DownloadBeanInfo downloadBeanInfo = new DownloadBeanInfo();
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        downloadBeanInfo.setItemmodule(jSONObject2.getInt("endpoint"));
                        downloadBeanInfo.setItemsize(jSONObject2.getLong("itemsize"));
                        downloadBeanInfo.setItemurl(jSONObject2.getString("itemurl"));
                        downloadBeanInfo.setItemmd5(jSONObject2.getString("itemmd5"));
                        downloadBeanInfo.setRelease_notes(jSONObject2.getString("release_notes"));
                        downloadBeanInfo.setHeader_info(jSONObject2.getString("header_info"));
                        downloadBeanInfo.setPackage_version(jSONObject2.getString("package_version"));
                        arrayList.add(downloadBeanInfo);
                    }
                }
                return arrayList;
            }
        });
    }

    public void downloadFile(String str, String str2, ResponseCallBack<File> responseCallBack) {
        this.mOkHttpManager.download(str, str2, responseCallBack);
    }

    public <T> T getObject(String str, Class<T> cls) {
        try {
            return this.gsonParser.fromJson(str, cls);
        } catch (Exception e) {
            Log.d("MessageParser", "Message Parser Exception------->> " + e.getMessage());
            e.printStackTrace();
            throw new Exception(AutelError.COMMON_PARSER_PARAMETER_FAILED.getDescription());
        }
    }
}
