package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.PerimeterScreen;
import com.atakmap.android.uastool.utils.Utils;

public class GimbalPitchEdit extends MultiEdit {
    /* access modifiers changed from: private */
    public int defaultGimbalPitch;
    /* access modifiers changed from: private */
    public Integer gimbalPitch;
    private EditText gimbalPitchEdit;
    private CheckBox gimbalPitchEnable;
    private TextView gimblePitchBounds;
    private TextView gimblePitchLabel;

    public void refresh() {
    }

    public GimbalPitchEdit(Context context) {
        super(context);
    }

    public GimbalPitchEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GimbalPitchEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, Integer num, boolean z) {
        super.init(z);
        this.defaultGimbalPitch = i;
        this.gimbalPitch = num;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gimblePitchLabel = (TextView) findViewById(C1877R.C1878id.gimbal_pitch_label);
        this.gimblePitchBounds = (TextView) findViewById(C1877R.C1878id.gimbal_pitch_bounds);
        this.gimbalPitchEdit = (EditText) findViewById(C1877R.C1878id.gimbal_pitch);
        CheckBox checkBox = (CheckBox) findViewById(C1877R.C1878id.gimbal_pitch_enable);
        this.gimbalPitchEnable = checkBox;
        if (this.gimbalPitch != null) {
            checkBox.setChecked(true);
            this.gimbalPitchEdit.setText(String.valueOf(this.gimbalPitch));
        } else {
            checkBox.setChecked(false);
        }
        this.gimbalPitchEdit.setFilters(new InputFilter[]{new PerimeterScreen.InputFilterMinMax("0", "90")});
        this.gimbalPitchEdit.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    Integer unused = GimbalPitchEdit.this.gimbalPitch = null;
                } else {
                    Integer unused2 = GimbalPitchEdit.this.gimbalPitch = Integer.valueOf(Utils.parseInt(editable.toString(), GimbalPitchEdit.this.defaultGimbalPitch));
                }
            }
        });
        this.gimbalPitchEdit.setEnabled(this.gimbalPitchEnable.isChecked());
        this.gimbalPitchEnable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GimbalPitchEdit.this.lambda$onAttachedToWindow$0$GimbalPitchEdit(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$onAttachedToWindow$0$GimbalPitchEdit(CompoundButton compoundButton, boolean z) {
        this.gimbalPitchEdit.setEnabled(z);
        if (this.gimbalPitchEdit.getText().length() == 0) {
            this.gimbalPitchEdit.setText(String.valueOf(this.defaultGimbalPitch));
        }
        if (!z) {
            this.gimblePitchLabel.setTextColor(-7829368);
            this.gimblePitchBounds.setTextColor(-7829368);
            return;
        }
        this.gimblePitchLabel.setTextColor(-1);
        this.gimblePitchBounds.setTextColor(-1);
    }

    public void disable(boolean z) {
        this.gimbalPitchEnable.setEnabled(!z);
        this.gimbalPitchEdit.setEnabled(this.gimbalPitchEnable.isChecked());
        if (z || !this.gimbalPitchEnable.isChecked()) {
            this.gimblePitchLabel.setTextColor(-7829368);
            this.gimblePitchBounds.setTextColor(-7829368);
            return;
        }
        this.gimblePitchLabel.setTextColor(-1);
        this.gimblePitchBounds.setTextColor(-1);
    }

    public Integer getGimbalPitch() {
        return this.gimbalPitch;
    }

    public void setGimbalPitch(Integer num) {
        this.gimbalPitch = num;
    }
}
