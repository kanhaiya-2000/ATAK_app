package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class UIScalePicker extends RelativeLayout {
    public static final String TAG = "UIScalePicker";
    private SeekBar seekBar;
    private int valueInt;
    /* access modifiers changed from: private */
    public TextView valueText;

    public UIScalePicker(Context context) {
        super(context);
    }

    public UIScalePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UIScalePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.valueText = (TextView) findViewById(C1877R.C1878id.scale_value_text);
        if (!isInEditMode()) {
            String string = UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_UI_SCALE, UIPreferenceFragment.DEFAULT_UI_SCALE);
            this.valueInt = Integer.parseInt(string);
            this.valueText.setText(string);
        }
        SeekBar seekBar2 = (SeekBar) findViewById(C1877R.C1878id.scale_seek);
        this.seekBar = seekBar2;
        seekBar2.setMax(50);
        this.seekBar.setProgress(this.valueInt - 50);
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    int i2 = i + 50;
                    UIScalePicker.this.valueText.setText(String.valueOf(i2));
                    UIScalePicker.this.setScale(i2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setScale(int i) {
        UIPreferenceFragment.setScale(i);
    }
}
