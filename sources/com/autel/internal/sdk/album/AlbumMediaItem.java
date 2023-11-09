package com.autel.internal.sdk.album;

import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.internal.sdk.camera.base.AutelCamProCamera;
import com.autel.internal.sdk.camera.base.AutelCameraDevice;
import com.autel.util.log.AutelLog;

public class AlbumMediaItem implements MediaInfo {
    private static AutelCameraDevice camProCamera = new AutelCamProCamera();
    private String coding_type;
    private long fileSize = -1;
    public int index;
    private boolean isFlashMemoryCard;
    private String largeThumbnail;
    private VideoEncodeFormat mVideoEncodeFormat;
    private VideoResolutionAndFps mVideoResolutionAndFps;
    private String originMedia;
    public String path;
    private String pathTag;
    private String playUrl;
    private String resolution;
    private String smallThumbnail;
    private String timeStr;

    public AlbumMediaItem() {
    }

    public AlbumMediaItem(boolean z, String str) {
        this.path = str;
        this.isFlashMemoryCard = z;
        initPath(z);
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileTimeString() {
        return this.timeStr;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public String getSmallThumbnail() {
        return this.smallThumbnail;
    }

    public String getLargeThumbnail() {
        return this.largeThumbnail;
    }

    public String getOriginalMedia() {
        return this.originMedia;
    }

    public VideoResolutionAndFps getVideoResolutionAndFps() {
        String str;
        if (this.mVideoResolutionAndFps == null && (str = this.resolution) != null) {
            String[] split = str.split("p");
            if (split.length == 2) {
                VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                this.mVideoResolutionAndFps = videoResolutionAndFps;
                videoResolutionAndFps.resolution = VideoResolution.find(split[0]);
                VideoResolutionAndFps videoResolutionAndFps2 = this.mVideoResolutionAndFps;
                videoResolutionAndFps2.fps = VideoFps.find("p" + split[1]);
            }
        }
        return this.mVideoResolutionAndFps;
    }

    public VideoEncodeFormat getVideoEncodeFormat() {
        if (this.mVideoEncodeFormat == null) {
            this.mVideoEncodeFormat = VideoEncodeFormat.find(this.coding_type);
        }
        return this.mVideoEncodeFormat;
    }

    public String getVideoPlayUrl() {
        return this.playUrl;
    }

    public void setPosition(int i) {
        this.index = i;
    }

    public String getPath() {
        return this.pathTag;
    }

    public void initPath(boolean z) {
        String str = this.path;
        if (str != null) {
            String[] split = str.split("\\|");
            if (split.length >= 1 && split[0].length() > 0 && split[0].lastIndexOf(".") >= 0) {
                this.originMedia = camProCamera.getUrlOrigin() + "/" + split[0];
                String substring = split[0].substring(split[0].lastIndexOf("."));
                String substring2 = split[0].substring(0, split[0].lastIndexOf("."));
                if (substring2.contains("MIX_") || substring2.contains("IRX_")) {
                    this.playUrl = substring2 + substring;
                } else {
                    String replace = substring2.replace("DCIM", "MISC/THM").replace("MEDIA", "").replace("FTASK", "");
                    this.playUrl = replace + "_THM" + substring;
                }
                this.playUrl = camProCamera.getPlayUrlOrigin() + "/" + this.playUrl;
                StringBuilder sb = new StringBuilder();
                sb.append("playUrl:");
                sb.append(this.playUrl);
                AutelLog.m15081d(sb.toString());
                if (!z) {
                    this.smallThumbnail = camProCamera.getUrlThumb() + "?path=" + split[0] + "&type=0";
                    this.largeThumbnail = camProCamera.getUrlThumb() + "?path=" + split[0] + "&type=1";
                } else {
                    this.smallThumbnail = camProCamera.getFMCUrlThumb() + "?path=" + split[0] + "&type=0";
                    this.largeThumbnail = camProCamera.getFMCUrlThumb() + "?path=" + split[0] + "&type=1";
                }
                this.pathTag = split[0];
                if (split.length == 3) {
                    this.fileSize = Long.valueOf(split[1]).longValue();
                    this.timeStr = split[2];
                }
            }
        }
    }

    public String toString() {
        return "originMedia : " + this.originMedia + ",smallThumbnail : " + this.smallThumbnail + ",largeThumbnail : " + this.largeThumbnail + ",path : " + this.pathTag + "fileTimeString : " + this.timeStr + ",fileSize : " + this.fileSize + " resolution:" + this.resolution;
    }

    public String getCoding_type() {
        return this.coding_type;
    }

    public void setCoding_type(String str) {
        this.coding_type = str;
    }
}
