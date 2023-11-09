package com.atakmap.android.uastool.pagers.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class StatusMetaList extends ListView {
    int mCnt = 0;

    public StatusMetaList(Context context) {
        super(context);
    }

    public StatusMetaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusMetaList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StatusMetaList(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
