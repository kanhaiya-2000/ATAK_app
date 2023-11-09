package com.atakmap.android.uastool.evo;

import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.UASToolFragment;

public class EvoSettingsScreen extends SettingsScreen {
    public EvoSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = EvoSettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
