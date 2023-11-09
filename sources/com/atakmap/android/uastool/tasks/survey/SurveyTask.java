package com.atakmap.android.uastool.tasks.survey;

import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoPoint;

public class SurveyTask extends UASTask {
    private static final String TAG = "SurveyTask";
    private static final int TASKTYPEICON = 2130968712;

    public String getDescription() {
        return "survey task";
    }

    public SurveyTask() {
        super(UASTask.COTDETAIL_UID, UASTask.COTDETAIL_USER, UASTask.COTDETAIL_NAME, "platform", UASTask.PRIORITY.NORMAL, UASTask.TASKTYPE.SURVEY, UASTask.STATE.STORED, C1877R.drawable.task_survey, String.valueOf(-1));
    }

    public CotDetail toCot() {
        UASToolDropDownReceiver.toast("Survey task has not yet implemented toCot()", 0);
        return null;
    }

    public GeoPoint getFocusPoint() {
        return GeoPoint.ZERO_POINT;
    }
}
