package com.atakmap.android.uastool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.atakmap.android.uastool.pagers.UASToolFragment;

public abstract class UASToolScreen extends LinearLayout {
    protected static String TAG = "UASToolScreen";
    protected UASToolFragment myParentFragment;
    protected final Context pluginContext;
    protected UASItem uasItem;

    public void refresh() {
    }

    public UASToolScreen(Context context) {
        super(context);
        this.pluginContext = context;
    }

    public UASToolScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    public UASToolScreen(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pluginContext = context;
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        this.uasItem = uASItem;
        this.myParentFragment = uASToolFragment;
    }

    public Context getPluginContext() {
        return this.pluginContext;
    }

    public void destroy() {
        setVisibility(4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UASToolScreen) || ((UASToolScreen) obj) != this) {
            return false;
        }
        return true;
    }
}
