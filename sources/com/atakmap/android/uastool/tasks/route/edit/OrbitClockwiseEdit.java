package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class OrbitClockwiseEdit extends MultiEdit {
    private boolean clockwise;
    private CheckBox clockwiseCheckBox;
    private TextView clockwiseTitle;

    public void refresh() {
    }

    public OrbitClockwiseEdit(Context context) {
        super(context);
    }

    public OrbitClockwiseEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitClockwiseEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(boolean z, boolean z2) {
        super.init(z2);
        this.clockwise = z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.clockwiseTitle = (TextView) findViewById(C1877R.C1878id.orbitedit_text_clockwise);
        CheckBox checkBox = (CheckBox) findViewById(C1877R.C1878id.orbitedit_value_clockwise);
        this.clockwiseCheckBox = checkBox;
        checkBox.setChecked(this.clockwise);
        this.clockwiseCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitClockwiseEdit.this.clockwiseChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.orbitedit_select_clockwise), (CheckBox) findViewById(C1877R.C1878id.orbitedit_select_clockwise_check));
    }

    /* access modifiers changed from: private */
    public void clockwiseChanged() {
        this.clockwise = this.clockwiseCheckBox.isChecked();
    }

    public boolean getClockwise() {
        return this.clockwise;
    }

    public void setClockwise(boolean z) {
        this.clockwise = z;
    }

    public void disable(boolean z) {
        if (z) {
            this.clockwiseTitle.setTextColor(-7829368);
        } else {
            this.clockwiseTitle.setTextColor(-1);
        }
        this.clockwiseCheckBox.setEnabled(!z);
    }
}
