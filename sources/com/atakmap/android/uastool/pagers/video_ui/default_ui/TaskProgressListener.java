package com.atakmap.android.uastool.pagers.video_ui.default_ui;

public interface TaskProgressListener {
    void taskFinished(String str);

    void taskPrepared(int i, String str);

    void taskRefused(String str);

    void taskStageCompleted(int i, String str);

    void taskStageStarted(int i, String str);

    void taskStageUpdate(int i, int i2, String str);

    void taskStarted(String str);
}
