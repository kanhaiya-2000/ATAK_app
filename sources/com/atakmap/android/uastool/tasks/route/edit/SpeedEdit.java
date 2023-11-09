package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;

public class SpeedEdit extends MultiEdit {
    private int maxSpeedMPS;
    /* access modifiers changed from: private */
    public int minSpeedMPS;
    /* access modifiers changed from: private */
    public int speed;
    private ImageButton speedMinus;
    private ImageButton speedPlus;
    private SeekBar speedSeek;
    private TextView speedTitle;
    private TextView speedUnits;
    private TextView speedValue;

    static /* synthetic */ int access$008(SpeedEdit speedEdit) {
        int i = speedEdit.speed;
        speedEdit.speed = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(SpeedEdit speedEdit) {
        int i = speedEdit.speed;
        speedEdit.speed = i - 1;
        return i;
    }

    public SpeedEdit(Context context) {
        super(context);
    }

    public SpeedEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpeedEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, int i2, int i3, boolean z) {
        super.init(z);
        this.speed = i;
        this.minSpeedMPS = i2;
        this.maxSpeedMPS = i3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.speedTitle = (TextView) findViewById(C1877R.C1878id.pointedit_text_speed);
        TextView textView = (TextView) findViewById(C1877R.C1878id.pointedit_units_speed);
        this.speedUnits = textView;
        textView.setText("(" + TasksFragment.getSpeedUnitsToDisplay() + ")");
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.pointedit_value_speed);
        this.speedValue = textView2;
        textView2.setText(String.valueOf(TasksFragment.convertSpeedToDisplay(this.speed)));
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.pointedit_seek_speed);
        this.speedSeek = seekBar;
        seekBar.setMax(this.maxSpeedMPS - this.minSpeedMPS);
        this.speedSeek.setProgress(this.speed - this.minSpeedMPS);
        this.speedSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    SpeedEdit speedEdit = SpeedEdit.this;
                    int unused = speedEdit.speed = i + speedEdit.minSpeedMPS;
                    SpeedEdit.this.speedChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.pointedit_minus_speed);
        this.speedMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SpeedEdit.access$010(SpeedEdit.this);
                SpeedEdit.this.speedChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.pointedit_plus_speed);
        this.speedPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SpeedEdit.access$008(SpeedEdit.this);
                SpeedEdit.this.speedChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.pointedit_select_speed), (CheckBox) findViewById(C1877R.C1878id.pointedit_select_speed_check));
    }

    /* access modifiers changed from: private */
    public void speedChanged() {
        int i = this.speed;
        int i2 = this.minSpeedMPS;
        if (i > i2) {
            this.speedMinus.setEnabled(true);
        } else {
            this.speed = i2;
            this.speedMinus.setEnabled(false);
        }
        int i3 = this.speed;
        int i4 = this.maxSpeedMPS;
        if (i3 < i4) {
            this.speedPlus.setEnabled(true);
        } else {
            this.speed = i4;
            this.speedPlus.setEnabled(false);
        }
        this.speedValue.setText(String.valueOf(TasksFragment.convertSpeedToDisplay(this.speed)));
        this.speedSeek.setProgress(this.speed - this.minSpeedMPS);
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public void refresh() {
        TextView textView = this.speedUnits;
        textView.setText("(" + TasksFragment.getSpeedUnitsToDisplay() + ")");
        this.speedValue.setText(String.valueOf(TasksFragment.convertSpeedToDisplay(this.speed)));
        this.speedSeek.setProgress(this.speed - this.minSpeedMPS);
    }

    public void disable(boolean z) {
        if (z) {
            this.speedTitle.setTextColor(-7829368);
            this.speedUnits.setTextColor(-7829368);
            this.speedValue.setTextColor(-7829368);
        } else {
            this.speedTitle.setTextColor(-1);
            this.speedUnits.setTextColor(-1);
            this.speedValue.setTextColor(getResources().getColor(C1877R.color.lightBlue));
        }
        this.speedMinus.setEnabled(!z);
        this.speedSeek.setEnabled(!z);
        this.speedPlus.setEnabled(!z);
    }
}
