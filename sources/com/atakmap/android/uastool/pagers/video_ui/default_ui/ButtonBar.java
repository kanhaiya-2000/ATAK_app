package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class ButtonBar extends VideoWidget {
    public static final String TAG = "ButtonBar";

    public ButtonBar(Context context) {
        super(context);
    }

    public ButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static ButtonBar getVideoUIButtons(UASItem uASItem) {
        ButtonBar buttonBar;
        if (uASItem.isConnected()) {
            buttonBar = (ButtonBar) PluginLayoutInflater.inflate(UASToolDropDownReceiver.getInstance().getPluginContext(), uASItem.getVideoUIButtons(), (ViewGroup) null);
            TextView textView = (TextView) buttonBar.findViewById(C1877R.C1878id.bottom_op_title);
            if (textView != null) {
                textView.setText(uASItem.getPlatformType() + " Operator");
            }
        } else {
            buttonBar = (ButtonBar) PluginLayoutInflater.inflate(UASToolDropDownReceiver.getInstance().getPluginContext(), uASItem.getVideoUIButtons(), (ViewGroup) null);
            TextView textView2 = (TextView) buttonBar.findViewById(C1877R.C1878id.bottom_ob_title);
            if (textView2 != null) {
                textView2.setText(uASItem.getPlatformType() + " Observer");
            }
        }
        return buttonBar;
    }
}
