package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class OrbitCountEdit extends MultiEdit {
    /* access modifiers changed from: private */
    public int count;
    private ImageButton countMinus;
    private ImageButton countPlus;
    private SeekBar countSeek;
    private TextView countTitle;
    private TextView countValue;
    private int maxCount;
    /* access modifiers changed from: private */
    public int minCount;

    static /* synthetic */ int access$008(OrbitCountEdit orbitCountEdit) {
        int i = orbitCountEdit.count;
        orbitCountEdit.count = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(OrbitCountEdit orbitCountEdit) {
        int i = orbitCountEdit.count;
        orbitCountEdit.count = i - 1;
        return i;
    }

    public OrbitCountEdit(Context context) {
        super(context);
    }

    public OrbitCountEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitCountEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, int i2, int i3, boolean z) {
        super.init(z);
        this.count = i;
        this.minCount = i2;
        this.maxCount = i3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.countTitle = (TextView) findViewById(C1877R.C1878id.orbitedit_text_count);
        TextView textView = (TextView) findViewById(C1877R.C1878id.orbitedit_value_count);
        this.countValue = textView;
        textView.setText(String.valueOf(this.count));
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.orbitedit_seek_count);
        this.countSeek = seekBar;
        seekBar.setMax(this.maxCount - this.minCount);
        this.countSeek.setProgress(this.count - this.minCount);
        this.countSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    OrbitCountEdit orbitCountEdit = OrbitCountEdit.this;
                    int unused = orbitCountEdit.count = i + orbitCountEdit.minCount;
                    OrbitCountEdit.this.countChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.orbitedit_minus_count);
        this.countMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitCountEdit.access$010(OrbitCountEdit.this);
                OrbitCountEdit.this.countChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.orbitedit_plus_count);
        this.countPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitCountEdit.access$008(OrbitCountEdit.this);
                OrbitCountEdit.this.countChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.orbitedit_select_count), (CheckBox) findViewById(C1877R.C1878id.orbitedit_select_count_check));
    }

    /* access modifiers changed from: private */
    public void countChanged() {
        int i = this.count;
        int i2 = this.minCount;
        if (i > i2) {
            this.countMinus.setEnabled(true);
        } else {
            this.count = i2;
            this.countMinus.setEnabled(false);
        }
        int i3 = this.count;
        int i4 = this.maxCount;
        if (i3 < i4) {
            this.countPlus.setEnabled(true);
        } else {
            this.count = i4;
            this.countPlus.setEnabled(false);
        }
        this.countValue.setText(String.valueOf(this.count));
        this.countSeek.setProgress(this.count - this.minCount);
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void refresh() {
        this.countValue.setText(String.valueOf(this.count));
        this.countSeek.setProgress(this.count - this.minCount);
    }

    public void disable(boolean z) {
        if (z) {
            this.countTitle.setTextColor(-7829368);
            this.countValue.setTextColor(-7829368);
        } else {
            this.countTitle.setTextColor(-1);
            this.countValue.setTextColor(getResources().getColor(C1877R.color.lightBlue));
        }
        this.countMinus.setEnabled(!z);
        this.countSeek.setEnabled(!z);
        this.countPlus.setEnabled(!z);
    }
}
