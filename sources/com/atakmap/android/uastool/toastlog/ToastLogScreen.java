package com.atakmap.android.uastool.toastlog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.List;

public class ToastLogScreen extends UASToolScreen {
    private List<ToastLogItem> logItems;

    public ToastLogScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = ToastLogScreen.class.getSimpleName();
    }

    public void setLogs(List<ToastLogItem> list) {
        this.logItems = list;
        ((ListView) findViewById(C1877R.C1878id.toastlog_listview)).setAdapter(new ToastLogAdapter(this.pluginContext, list));
    }
}
