package com.autel.internal.album;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.AlbumParameterRangeManager;
import com.autel.common.album.AlbumType;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.common.error.RxException;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.album.AutelAlbum;
import com.autel.sdk.album.p003rx.RxAutelAlbum;
import io.reactivex.Observable;
import java.io.File;
import java.util.List;

public class RxAlbumImpl implements RxAutelAlbum {
    /* access modifiers changed from: private */
    public AutelAlbum mAlbum;

    public RxAlbumImpl(AutelAlbum autelAlbum) {
        this.mAlbum = autelAlbum;
    }

    public Observable<List<MediaInfo>> getMedia(final AlbumType albumType, final int i, final int i2) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getMedia(albumType, i, i2, new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27241.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27241.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> getMedia(final int i, final int i2) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getMedia(i, i2, new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27322.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27322.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> deleteMedia(final List<MediaInfo> list) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.deleteMedia((List<MediaInfo>) list, (CallbackWithOneParam<List<MediaInfo>>) new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27343.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27343.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> deleteMedia(final MediaInfo mediaInfo) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.deleteMedia(mediaInfo, (CallbackWithOneParam<List<MediaInfo>>) new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27364.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27364.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionFromHttpHeader(final MediaInfo mediaInfo) {
        return new RxLock<VideoResolutionAndFps>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getVideoResolutionFromHttpHeader(mediaInfo, new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C27385.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C27385.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getVideoResolutionFromLocalFile(final File file) {
        return new RxLock<VideoResolutionAndFps>() {
            /* access modifiers changed from: protected */
            public void run() {
                VideoResolutionAndFps videoResolutionFromLocalFile = RxAlbumImpl.this.mAlbum.getVideoResolutionFromLocalFile(file);
                if (videoResolutionFromLocalFile == null) {
                    setException(new RxException(AutelError.COMMAND_PARAMS_ARE_INVALID));
                } else {
                    setData(videoResolutionFromLocalFile);
                }
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> getFMCMedia(final AlbumType albumType, final int i, final int i2) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getFMCMedia(albumType, i, i2, new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27417.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27417.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<AlbumParameterRangeManager> getParameterRangeManager() {
        return new RxLock<AlbumParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                AlbumParameterRangeManager parameterRangeManager = RxAlbumImpl.this.mAlbum.getParameterRangeManager();
                if (parameterRangeManager == null) {
                    setException(new RxException(AutelError.COMMAND_FAILED));
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> getFMCMedia(final int i, final int i2) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getFMCMedia(i, i2, new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C27449.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C27449.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> deleteFMCMedia(final List<MediaInfo> list) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.deleteFMCMedia((List<MediaInfo>) list, (CallbackWithOneParam<List<MediaInfo>>) new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C272610.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C272610.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<List<MediaInfo>> deleteFMCMedia(final MediaInfo mediaInfo) {
        return new RxLock<List<MediaInfo>>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.deleteFMCMedia(mediaInfo, (CallbackWithOneParam<List<MediaInfo>>) new CallbackWithOneParam<List<MediaInfo>>() {
                    public void onSuccess(List<MediaInfo> list) {
                        C272811.this.setData(list);
                    }

                    public void onFailure(AutelError autelError) {
                        C272811.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }

    public Observable<VideoResolutionAndFps> getFMCVideoResolutionFromHttpHeader(final MediaInfo mediaInfo) {
        return new RxLock<VideoResolutionAndFps>() {
            public void run() {
                RxAlbumImpl.this.mAlbum.getFMCVideoResolutionFromHttpHeader(mediaInfo, new CallbackWithOneParam<VideoResolutionAndFps>() {
                    public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                        C273012.this.setData(videoResolutionAndFps);
                    }

                    public void onFailure(AutelError autelError) {
                        C273012.this.setException(new RxException(autelError));
                    }
                });
            }
        }.fire();
    }
}
