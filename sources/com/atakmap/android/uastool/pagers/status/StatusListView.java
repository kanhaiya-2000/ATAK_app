package com.atakmap.android.uastool.pagers.status;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.UASItem;

public class StatusListView extends ListView {
    public StatusListView(Context context) {
        super(context);
    }

    public StatusListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatusListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StatusListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public int indexOfMarker(ao aoVar) {
        StatusAdapter statusAdapter = (StatusAdapter) getAdapter();
        for (int i = 0; i < getAdapter().getCount(); i++) {
            if (((UASItem) statusAdapter.getItem(i)).isMyMarker(aoVar)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsMarker(ao aoVar) {
        StatusAdapter statusAdapter = (StatusAdapter) getAdapter();
        for (int i = 0; i < getAdapter().getCount(); i++) {
            if (((UASItem) statusAdapter.getItem(i)).isMyMarker(aoVar)) {
                return true;
            }
        }
        return false;
    }

    public void closeAll() {
        StatusAdapter statusAdapter = (StatusAdapter) getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            if (statusAdapter.getItem(i) != null) {
                statusAdapter.close(getChildAt(i), (UASItem) statusAdapter.getItem(i));
            }
        }
    }
}
