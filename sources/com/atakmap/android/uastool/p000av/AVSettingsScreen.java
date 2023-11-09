package com.atakmap.android.uastool.p000av;

import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.UASToolFragment;

/* renamed from: com.atakmap.android.uastool.av.AVSettingsScreen */
public class AVSettingsScreen extends SettingsScreen {
    public AVSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = AVSettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
