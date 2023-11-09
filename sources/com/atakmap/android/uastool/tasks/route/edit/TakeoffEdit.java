package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class TakeoffEdit extends MultiEdit {
    private boolean takeoff;
    private CheckBox takeoffCheckBox;
    private TextView takeoffTitle;

    public void refresh() {
    }

    public TakeoffEdit(Context context) {
        super(context);
    }

    public TakeoffEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TakeoffEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(boolean z, boolean z2) {
        super.init(z2);
        this.takeoff = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.takeoffTitle = (TextView) findViewById(C1877R.C1878id.pointedit_text_takeoff);
        CheckBox checkBox = (CheckBox) findViewById(C1877R.C1878id.pointedit_value_takeoff);
        this.takeoffCheckBox = checkBox;
        checkBox.setChecked(this.takeoff);
        this.takeoffCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TakeoffEdit.this.takeoffChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.pointedit_select_takeoff), (CheckBox) findViewById(C1877R.C1878id.pointedit_select_takeoff_check));
    }

    /* access modifiers changed from: private */
    public void takeoffChanged() {
        this.takeoff = this.takeoffCheckBox.isChecked();
    }

    public boolean getTakeoff() {
        return this.takeoff;
    }

    public void setTakeoff(boolean z) {
        this.takeoff = z;
    }

    public void disable(boolean z) {
        if (z) {
            this.takeoffTitle.setTextColor(-7829368);
        } else {
            this.takeoffTitle.setTextColor(-1);
        }
        this.takeoffCheckBox.setEnabled(!z);
    }
}
