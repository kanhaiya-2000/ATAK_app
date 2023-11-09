package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class LookAtPointEdit extends MultiEdit {
    private boolean lookAtPoint;
    private CheckBox lookCheckBox;
    private TextView lookTitle;

    public void refresh() {
    }

    public LookAtPointEdit(Context context) {
        super(context);
    }

    public LookAtPointEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LookAtPointEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(boolean z, boolean z2) {
        super.init(z2);
        this.lookAtPoint = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.lookTitle = (TextView) findViewById(C1877R.C1878id.pointedit_text_look);
        CheckBox checkBox = (CheckBox) findViewById(C1877R.C1878id.pointedit_value_look);
        this.lookCheckBox = checkBox;
        checkBox.setChecked(this.lookAtPoint);
        this.lookCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LookAtPointEdit.this.lookChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.pointedit_select_look), (CheckBox) findViewById(C1877R.C1878id.pointedit_select_look_check));
    }

    /* access modifiers changed from: private */
    public void lookChanged() {
        this.lookAtPoint = this.lookCheckBox.isChecked();
    }

    public boolean getLookAtPoint() {
        return this.lookAtPoint;
    }

    public void setLookAtPoint(boolean z) {
        this.lookAtPoint = z;
    }

    public void disable(boolean z) {
        if (z) {
            this.lookTitle.setTextColor(-7829368);
        } else {
            this.lookTitle.setTextColor(-1);
        }
        this.lookCheckBox.setEnabled(!z);
    }
}
