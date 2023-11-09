package com.autel.sdk.album;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.AlbumParameterRangeManager;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.sdk.album.p003rx.RxAutelAlbum;
import java.io.File;
import java.util.List;

public interface AutelAlbum {
    void deleteFMCMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void deleteFMCMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void deleteMedia(MediaInfo mediaInfo, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void deleteMedia(List<MediaInfo> list, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void getFMCMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void getFMCMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void getFMCVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam);

    void getMedia(int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    void getMedia(AlbumType albumType, int i, int i2, CallbackWithOneParam<List<MediaInfo>> callbackWithOneParam);

    AlbumParameterRangeManager getParameterRangeManager();

    void getVideoResolutionFromHttpHeader(MediaInfo mediaInfo, CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam);

    VideoResolutionAndFps getVideoResolutionFromLocalFile(File file);

    RxAutelAlbum toRx();
}
