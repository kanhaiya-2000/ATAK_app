package com.autel.sdk.album.p003rx;

import com.autel.common.album.AlbumParameterRangeManager;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import io.reactivex.Observable;
import java.io.File;
import java.util.List;

/* renamed from: com.autel.sdk.album.rx.RxAutelAlbum */
public interface RxAutelAlbum {
    Observable<List<MediaInfo>> deleteFMCMedia(MediaInfo mediaInfo);

    Observable<List<MediaInfo>> deleteFMCMedia(List<MediaInfo> list);

    Observable<List<MediaInfo>> deleteMedia(MediaInfo mediaInfo);

    Observable<List<MediaInfo>> deleteMedia(List<MediaInfo> list);

    Observable<List<MediaInfo>> getFMCMedia(int i, int i2);

    Observable<List<MediaInfo>> getFMCMedia(AlbumType albumType, int i, int i2);

    Observable<VideoResolutionAndFps> getFMCVideoResolutionFromHttpHeader(MediaInfo mediaInfo);

    Observable<List<MediaInfo>> getMedia(int i, int i2);

    Observable<List<MediaInfo>> getMedia(AlbumType albumType, int i, int i2);

    Observable<AlbumParameterRangeManager> getParameterRangeManager();

    Observable<VideoResolutionAndFps> getVideoResolutionFromHttpHeader(MediaInfo mediaInfo);

    Observable<VideoResolutionAndFps> getVideoResolutionFromLocalFile(File file);
}
