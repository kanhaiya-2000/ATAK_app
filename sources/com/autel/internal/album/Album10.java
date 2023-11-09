package com.autel.internal.album;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.album.AlbumParameterRangeManager;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.sdk.album.p003rx.RxAutelAlbum;
import com.autel.sdk10.AutelNet.AutelAblum.AutelAblumRequestManager_V_FaceLess;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Album10 implements AlbumService {
    public void connect() {
    }

    public void deleteFMCMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
    }

    public void deleteFMCMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void getFMCMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
    }

    public void getFMCMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
    }

    public void getFMCVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
    }

    public void getMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxAutelAlbum toRx() {
        return null;
    }

    public void getMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AutelAblumRequestManager_V_FaceLess.getInstance().requestMediaList(AlbumType.ALL, i, i2, callbackWithOneParam);
        }
    }

    public void deleteMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (list != null) {
            AutelAblumRequestManager_V_FaceLess.getInstance().deleteAlbumMedia(list, callbackWithOneParam);
        } else if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumParamsNullError("media list to be deleted should not be null"));
        }
    }

    public void deleteMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (mediaInfo != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediaInfo);
            deleteMedia((List<MediaInfo>) arrayList, callbackWithOneParam);
        } else if (callbackWithOneParam != null) {
            callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumParamsNullError(" autelAlbumMedia to be deleted should not be null"));
        }
    }

    public void getVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            if (mediaInfo == null) {
                callbackWithOneParam.onFailure(AutelErrorUtil.createAlbumParamsNullError("albumMedia should not be null"));
            }
            AutelAblumRequestManager_V_FaceLess.getInstance().getVideoResolutionInfo(mediaInfo, callbackWithOneParam);
        }
    }

    public VideoResolutionAndFps getVideoResolutionFromLocalFile(File file) {
        return AutelAblumRequestManager_V_FaceLess.getInstance().getVideoResolutionInfo(file);
    }

    public AlbumParameterRangeManager getParameterRangeManager() {
        return new AlbumParameterRangeManager() {
            public RangePair<Integer> getMediaCountRange() {
                return new RangePair<Integer>() {
                    public Integer getValueFrom() {
                        return 0;
                    }

                    public Integer getValueTo() {
                        return 500;
                    }
                };
            }
        };
    }
}
