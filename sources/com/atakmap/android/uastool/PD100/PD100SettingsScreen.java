package com.atakmap.android.uastool.PD100;

import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.UASToolFragment;

public class PD100SettingsScreen extends SettingsScreen {
    public PD100SettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = PD100SettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
