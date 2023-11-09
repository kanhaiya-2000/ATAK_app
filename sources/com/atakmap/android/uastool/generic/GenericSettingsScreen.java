package com.atakmap.android.uastool.generic;

import android.content.Context;
import android.util.AttributeSet;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.UASToolFragment;

public class GenericSettingsScreen extends SettingsScreen {
    public GenericSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = GenericSettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
