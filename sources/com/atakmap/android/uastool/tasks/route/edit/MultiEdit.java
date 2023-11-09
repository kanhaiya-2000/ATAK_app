package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

public abstract class MultiEdit extends RelativeLayout {
    protected boolean isMulti;
    protected CheckBox multiCheck;

    public abstract void disable(boolean z);

    public abstract void refresh();

    public MultiEdit(Context context) {
        super(context);
    }

    public MultiEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MultiEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(boolean z) {
        this.isMulti = z;
    }

    /* access modifiers changed from: protected */
    public void setUpMulti(RelativeLayout relativeLayout, CheckBox checkBox) {
        this.multiCheck = checkBox;
        checkBox.setChecked(false);
        if (this.isMulti) {
            relativeLayout.setVisibility(0);
            disable(true);
            this.multiCheck.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MultiEdit multiEdit = MultiEdit.this;
                    multiEdit.disable(!multiEdit.multiCheck.isChecked());
                }
            });
            return;
        }
        relativeLayout.setVisibility(8);
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public boolean isSelected() {
        return this.multiCheck.isChecked();
    }

    public boolean isMultiSelected() {
        return isMulti() && isSelected();
    }
}
