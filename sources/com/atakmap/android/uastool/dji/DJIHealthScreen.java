package com.atakmap.android.uastool.dji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.atakmap.android.uastool.HealthScreen;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class DJIHealthScreen extends HealthScreen {
    public static String TAG = "DJIHealthScreen";

    public DJIHealthScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((ImageButton) findViewById(C1877R.C1878id.djihealth_refresh)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIHealthScreen.this.refreshHealth();
            }
        });
    }

    /* access modifiers changed from: private */
    public void refreshHealth() {
        UASToolDropDownReceiver.toast("Refresh health not yet implemented");
    }
}
