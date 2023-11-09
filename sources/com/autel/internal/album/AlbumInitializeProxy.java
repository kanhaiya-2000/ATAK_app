package com.autel.internal.album;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.RangePair;
import com.autel.common.album.AlbumParameterRangeManager;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.sdk.album.p003rx.RxAutelAlbum;
import java.io.File;
import java.util.List;

public class AlbumInitializeProxy extends AutelInitializeProxy implements AlbumService4Initialize {
    private AlbumService albumService;
    private RxAlbumImpl rxAlbum;

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void getMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            RangePair<Integer> mediaCountRange = getParameterRangeManager().getMediaCountRange();
            if (i2 <= mediaCountRange.getValueTo().intValue() && i2 >= mediaCountRange.getValueFrom().intValue()) {
                this.albumService.getMedia(i, i2, callbackWithOneParam);
            } else if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void deleteMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(list, (FailedCallback) callbackWithOneParam)) {
            this.albumService.deleteMedia(list, callbackWithOneParam);
        }
    }

    public void deleteMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(mediaInfo, (FailedCallback) callbackWithOneParam)) {
            this.albumService.deleteMedia(mediaInfo, callbackWithOneParam);
        }
    }

    public void getVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(mediaInfo, (FailedCallback) callbackWithOneParam)) {
            this.albumService.getVideoResolutionFromHttpHeader(mediaInfo, callbackWithOneParam);
        }
    }

    public VideoResolutionAndFps getVideoResolutionFromLocalFile(File file) {
        if (this.albumService == null || failedCallback(file, (FailedCallback) null)) {
            return null;
        }
        return this.albumService.getVideoResolutionFromLocalFile(file);
    }

    public AlbumParameterRangeManager getParameterRangeManager() {
        return this.albumService.getParameterRangeManager();
    }

    public void getMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            RangePair<Integer> mediaCountRange = getParameterRangeManager().getMediaCountRange();
            if (i2 <= mediaCountRange.getValueTo().intValue() && i2 >= mediaCountRange.getValueFrom().intValue()) {
                this.albumService.getMedia(albumType, i, i2, callbackWithOneParam);
            } else if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getFMCMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            RangePair<Integer> mediaCountRange = getParameterRangeManager().getMediaCountRange();
            if (i2 <= mediaCountRange.getValueTo().intValue() && i2 >= mediaCountRange.getValueFrom().intValue()) {
                this.albumService.getFMCMedia(albumType, i, i2, callbackWithOneParam);
            } else if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void getFMCMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            RangePair<Integer> mediaCountRange = getParameterRangeManager().getMediaCountRange();
            if (i2 <= mediaCountRange.getValueTo().intValue() && i2 >= mediaCountRange.getValueFrom().intValue()) {
                this.albumService.getFMCMedia(i, i2, callbackWithOneParam);
            } else if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
            }
        }
    }

    public void deleteFMCMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(list, (FailedCallback) callbackWithOneParam)) {
            this.albumService.deleteFMCMedia(list, callbackWithOneParam);
        }
    }

    public void deleteFMCMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(mediaInfo, (FailedCallback) callbackWithOneParam)) {
            this.albumService.deleteFMCMedia(mediaInfo, callbackWithOneParam);
        }
    }

    public void getFMCVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && !failedCallback(mediaInfo, (FailedCallback) callbackWithOneParam)) {
            this.albumService.getFMCVideoResolutionFromHttpHeader(mediaInfo, callbackWithOneParam);
        }
    }

    public RxAutelAlbum toRx() {
        if (this.rxAlbum == null) {
            this.rxAlbum = new RxAlbumImpl(this);
        }
        return this.rxAlbum;
    }

    private boolean failedCallback(File file, FailedCallback failedCallback) {
        if (file != null) {
            return false;
        }
        if (failedCallback == null) {
            return true;
        }
        failedCallback.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        return true;
    }

    private boolean failedCallback(MediaInfo mediaInfo, FailedCallback failedCallback) {
        if (mediaInfo != null) {
            return false;
        }
        if (failedCallback == null) {
            return true;
        }
        failedCallback.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        return true;
    }

    private boolean failedCallback(List<MediaInfo> list, FailedCallback failedCallback) {
        if (list != null) {
            return false;
        }
        if (failedCallback == null) {
            return true;
        }
        failedCallback.onFailure(AutelError.ALBUM_PARAMS_ARE_NULL);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isCameraConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_CAMERA : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        AlbumService createAlbum = AlbumFactory.createAlbum(autelServiceVersion);
        this.albumService = createAlbum;
        return createAlbum;
    }
}
