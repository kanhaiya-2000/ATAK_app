package com.autel.sdk10.AutelNet.AutelAblum;

import android.util.Log;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.downloader.bean.DownloadTask;
import com.autel.internal.sdk.album.AlbumMediaItem;
import com.autel.internal.sdk.camera.base.AutelCamProCamera;
import com.autel.internal.sdk.camera.base.AutelCameraDevice;
import com.autel.internal.sdk.camera.base.AutelVideoResolutionInternal;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.sdk10.AutelNet.AutelAblum.bean.AlbumMediaInfo;
import com.autel.util.log.AutelLog;
import com.autel.util.okhttp.OkHttpManager;
import com.autel.util.okhttp.callback.ResponseCallBack;
import com.autel.util.okhttp.callback.ResponseInterface;
import com.autel.util.okhttp.model.FormParams;
import com.autel.util.okhttp.model.Headers;
import com.autel.util.okhttp.model.HttpMediaType;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AutelAblumRequestManager_V_FaceLess {
    private static AutelAblumRequestManager_V_FaceLess mInstance;
    /* access modifiers changed from: private */
    public Gson albumGson = new Gson();
    private AutelCameraDevice curAutelCameraDevice = new AutelCamProCamera();
    private OkHttpManager mOkHttpManager;

    private AutelAblumRequestManager_V_FaceLess() {
    }

    public static AutelAblumRequestManager_V_FaceLess getInstance() {
        if (mInstance == null) {
            synchronized (AutelAblumRequestManager_V_FaceLess.class) {
                if (mInstance == null) {
                    mInstance = new AutelAblumRequestManager_V_FaceLess();
                }
            }
        }
        return mInstance;
    }

    public void requestMediaList(AlbumType albumType, int i, int i2, final CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (this.curAutelCameraDevice == null) {
            callbackWithOneParam.onFailure(AutelError.ALBUM_CAMERA_NOT_FIND);
            return;
        }
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        this.mOkHttpManager.get(this.curAutelCameraDevice.getUrlFileList(), (Headers) null, buildScanParams(i, i2, albumType), new ResponseCallBack<List<MediaInfo>>() {
            public void onSuccess(List<MediaInfo> list) {
                Log.d("Album", "onSuccess:" + list.size());
                callbackWithOneParam.onSuccess(list);
            }

            public void onFailure(Throwable th) {
                Log.d("Album", "rcv onFailure:" + th.getMessage());
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
            }

            public List<MediaInfo> convert(ResponseInterface responseInterface) {
                Log.d("Album", "rcv msg:" + responseInterface.getString());
                AlbumMediaInfo albumMediaInfo = (AlbumMediaInfo) AutelAblumRequestManager_V_FaceLess.this.albumGson.fromJson(responseInterface.getString(), AlbumMediaInfo.class);
                ArrayList arrayList = new ArrayList();
                if (albumMediaInfo.pathlist == null) {
                    return arrayList;
                }
                for (AlbumMediaItem next : albumMediaInfo.pathlist) {
                    next.initPath(false);
                    arrayList.add(next);
                }
                return arrayList;
            }
        });
    }

    public void deleteAlbumMedia(final List<MediaInfo> list, final CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        String str = "";
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (MediaInfo next : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DownloadTask.PATH, ((AlbumMediaItem) next).getPath());
                jSONObject2.put(UASPoint.COTDETAIL_INDEX, ((AlbumMediaItem) next).index + str);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("count", list.size() + str);
            jSONObject.put("pathlist", jSONArray);
            str = "DelInfo=" + jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.mOkHttpManager.post(this.curAutelCameraDevice.getUrlFileList(), (Headers) null, HttpMediaType.MEDIA_TYPE_JSON, str, new ResponseCallBack<List<MediaInfo>>() {
            public void onSuccess(List<MediaInfo> list) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(list);
                }
            }

            public void onFailure(Throwable th) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
                }
            }

            public List<MediaInfo> convert(ResponseInterface responseInterface) {
                if (responseInterface.getCode() == 200) {
                    return null;
                }
                throw new Exception(responseInterface.getString());
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.autel.common.camera.media.VideoResolutionAndFps getVideoResolutionInfo(java.io.File r6) {
        /*
            r5 = this;
            com.autel.internal.sdk.camera.base.AutelVideoResolutionInternal r0 = new com.autel.internal.sdk.camera.base.AutelVideoResolutionInternal
            r0.<init>()
            if (r6 == 0) goto L_0x0056
            boolean r1 = r6.exists()
            if (r1 != 0) goto L_0x000e
            goto L_0x0056
        L_0x000e:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0038 }
            r6 = 40
            byte[] r1 = new byte[r6]     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            int r3 = r2.read(r1)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r3 != r6) goto L_0x002c
            r6 = 20
            byte r6 = r1[r6]     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r4 = 21
            r3.<init>(r1, r4, r6)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r5.initResolution(r0, r3)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
        L_0x002c:
            r2.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0030:
            r6 = move-exception
            r1 = r2
            goto L_0x004b
        L_0x0033:
            r6 = move-exception
            r1 = r2
            goto L_0x0039
        L_0x0036:
            r6 = move-exception
            goto L_0x004b
        L_0x0038:
            r6 = move-exception
        L_0x0039:
            r6.printStackTrace()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0046:
            com.autel.common.camera.media.VideoResolutionAndFps r6 = r0.getResolutionAndFps()
            return r6
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            throw r6
        L_0x0056:
            com.autel.common.camera.media.VideoResolutionAndFps r6 = r0.getResolutionAndFps()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelAblum.AutelAblumRequestManager_V_FaceLess.getVideoResolutionInfo(java.io.File):com.autel.common.camera.media.VideoResolutionAndFps");
    }

    public void getVideoResolutionInfo(MediaInfo mediaInfo, final CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        this.mOkHttpManager.get(mediaInfo.getSmallThumbnail(), (Headers) null, new ResponseCallBack<AutelVideoResolutionInternal>() {
            public void onSuccess(AutelVideoResolutionInternal autelVideoResolutionInternal) {
                callbackWithOneParam.onSuccess(autelVideoResolutionInternal.getResolutionAndFps());
            }

            public void onFailure(Throwable th) {
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
            }

            public AutelVideoResolutionInternal convert(ResponseInterface responseInterface) {
                AutelVideoResolutionInternal autelVideoResolutionInternal = new AutelVideoResolutionInternal();
                String head = responseInterface.getHead("FileInfo");
                if (head != null) {
                    AutelAblumRequestManager_V_FaceLess.this.initResolution(autelVideoResolutionInternal, (String) new JSONObject(head).get("resolution"));
                    return autelVideoResolutionInternal;
                }
                throw new Exception("no resolution data can find");
            }
        });
    }

    /* access modifiers changed from: private */
    public void initResolution(AutelVideoResolutionInternal autelVideoResolutionInternal, String str) {
        if (autelVideoResolutionInternal != null && str != null) {
            String[] split = str.split("p");
            if (split.length == 2) {
                VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                videoResolutionAndFps.resolution = VideoResolution.find(split[0]);
                videoResolutionAndFps.fps = VideoFps.find("p" + split[1]);
                autelVideoResolutionInternal.setResolutionAndFps(videoResolutionAndFps);
            }
        }
    }

    private FormParams buildScanParams(int i, int i2, AlbumType albumType) {
        FormParams formParams = new FormParams();
        formParams.addForm("offset", i + "");
        formParams.addForm("count", i2 + "");
        formParams.addForm("type", albumType.value() + "");
        Log.d("Album", "send msg----->>> :" + formParams.getParamString());
        return formParams;
    }

    public void requestFMCMediaList(AlbumType albumType, int i, int i2, final CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (this.curAutelCameraDevice == null) {
            callbackWithOneParam.onFailure(AutelError.ALBUM_CAMERA_NOT_FIND);
            return;
        }
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        this.mOkHttpManager.get(this.curAutelCameraDevice.getFMCUrlFileList(), (Headers) null, buildScanParams(i, i2, albumType), new ResponseCallBack<List<MediaInfo>>() {
            public void onSuccess(List<MediaInfo> list) {
                Log.d("Album", "onSuccess:" + list.size());
                callbackWithOneParam.onSuccess(list);
            }

            public void onFailure(Throwable th) {
                Log.d("Album", "rcv onFailure:" + th.getMessage());
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
            }

            public List<MediaInfo> convert(ResponseInterface responseInterface) {
                Log.d("Album", "rcv msg:" + responseInterface.getString());
                AlbumMediaInfo albumMediaInfo = (AlbumMediaInfo) AutelAblumRequestManager_V_FaceLess.this.albumGson.fromJson(responseInterface.getString(), AlbumMediaInfo.class);
                ArrayList arrayList = new ArrayList();
                if (albumMediaInfo.pathlist == null) {
                    return arrayList;
                }
                for (AlbumMediaItem next : albumMediaInfo.pathlist) {
                    next.initPath(true);
                    arrayList.add(next);
                }
                return arrayList;
            }
        });
    }

    public void deleteFMCAlbumMedia(final List<MediaInfo> list, final CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        String str = "";
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (MediaInfo next : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(DownloadTask.PATH, ((AlbumMediaItem) next).getPath());
                jSONObject2.put(UASPoint.COTDETAIL_INDEX, ((AlbumMediaItem) next).index + str);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("count", list.size() + str);
            jSONObject.put("pathlist", jSONArray);
            str = "DelInfo=" + jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str2 = str;
        AutelLog.m15082d("Album", "delete fmc path = " + this.curAutelCameraDevice.getFMCUrlFileList() + " params=" + str2);
        this.mOkHttpManager.post(this.curAutelCameraDevice.getFMCUrlFileList(), (Headers) null, HttpMediaType.MEDIA_TYPE_JSON, str2, new ResponseCallBack<List<MediaInfo>>() {
            public void onSuccess(List<MediaInfo> list) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(list);
                }
            }

            public void onFailure(Throwable th) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
                }
            }

            public List<MediaInfo> convert(ResponseInterface responseInterface) {
                if (responseInterface.getCode() == 200) {
                    return null;
                }
                throw new Exception(responseInterface.getString());
            }
        });
    }

    public void getFMCVideoResolutionInfo(MediaInfo mediaInfo, final CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (this.mOkHttpManager == null) {
            this.mOkHttpManager = new OkHttpManager.Builder().build();
        }
        this.mOkHttpManager.get(mediaInfo.getSmallThumbnail(), (Headers) null, new ResponseCallBack<AutelVideoResolutionInternal>() {
            public void onSuccess(AutelVideoResolutionInternal autelVideoResolutionInternal) {
                callbackWithOneParam.onSuccess(autelVideoResolutionInternal.getResolutionAndFps());
            }

            public void onFailure(Throwable th) {
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumHttpFetchError(th.getMessage()));
            }

            public AutelVideoResolutionInternal convert(ResponseInterface responseInterface) {
                AutelVideoResolutionInternal autelVideoResolutionInternal = new AutelVideoResolutionInternal();
                String head = responseInterface.getHead("FileInfo");
                if (head != null) {
                    AutelAblumRequestManager_V_FaceLess.this.initResolution(autelVideoResolutionInternal, (String) new JSONObject(head).get("resolution"));
                    return autelVideoResolutionInternal;
                }
                throw new Exception("no resolution data can find");
            }
        });
    }
}
