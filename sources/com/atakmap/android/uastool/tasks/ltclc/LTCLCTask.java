package com.atakmap.android.uastool.tasks.ltclc;

import com.atakmap.android.uastool.tasks.UASTask;

public abstract class LTCLCTask extends UASTask {
    public static final String COTDETAIL_POINT = "point";
    private static final String TAG = "com.atakmap.android.uastool.tasks.ltclc.LTCLCTask";

    public LTCLCTask(String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.TASKTYPE tasktype, UASTask.STATE state, int i) {
        super(str, str2, str3, str4, priority, tasktype, state, i, String.valueOf(-1));
    }

    public String getDescription() {
        return this.user + " / " + this.platform + " / " + this.taskType.name();
    }
}
