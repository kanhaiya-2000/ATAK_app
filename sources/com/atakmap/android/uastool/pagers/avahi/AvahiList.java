package com.atakmap.android.uastool.pagers.avahi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class AvahiList extends ListView {
    public AvahiList(Context context) {
        super(context);
    }

    public AvahiList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AvahiList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AvahiList(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
