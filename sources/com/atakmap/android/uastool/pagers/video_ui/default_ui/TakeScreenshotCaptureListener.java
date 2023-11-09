package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.graphics.Bitmap;

public interface TakeScreenshotCaptureListener {
    void onCaptureCompleted(Bitmap bitmap);

    void onCaptureFailed(String str);

    void onCaptureStarted();
}
