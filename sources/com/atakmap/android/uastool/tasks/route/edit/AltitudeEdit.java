package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.route.UASPoint;

public class AltitudeEdit extends MultiEdit {
    private ImageButton altMinus;
    private ImageButton altPlus;
    private SeekBar altSeek;
    private TextView altTitle;
    private TextView altUnits;
    private TextView altValue;
    /* access modifiers changed from: private */
    public int altitude;
    private int maxAltmAGL;
    /* access modifiers changed from: private */
    public int minAltmAGL;
    private UASPoint point;

    static /* synthetic */ int access$008(AltitudeEdit altitudeEdit) {
        int i = altitudeEdit.altitude;
        altitudeEdit.altitude = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(AltitudeEdit altitudeEdit) {
        int i = altitudeEdit.altitude;
        altitudeEdit.altitude = i - 1;
        return i;
    }

    public AltitudeEdit(Context context) {
        super(context);
    }

    public AltitudeEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AltitudeEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, UASPoint uASPoint, int i2, int i3, boolean z) {
        super.init(z);
        this.altitude = i;
        this.point = uASPoint;
        this.minAltmAGL = i2;
        this.maxAltmAGL = i3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.altTitle = (TextView) findViewById(C1877R.C1878id.pointedit_text_alt);
        TextView textView = (TextView) findViewById(C1877R.C1878id.pointedit_units_alt);
        this.altUnits = textView;
        textView.setText("(" + UASToolDropDownReceiver.getAltitudeUnitsFormatLabel() + ")");
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.pointedit_value_alt);
        this.altValue = textView2;
        textView2.setText(String.valueOf(TasksFragment.convertAltitudeToDisplay(this.point, (float) this.altitude)));
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.pointedit_seek_alt);
        this.altSeek = seekBar;
        seekBar.setMax(this.maxAltmAGL - this.minAltmAGL);
        this.altSeek.setProgress(this.altitude - this.minAltmAGL);
        this.altSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    AltitudeEdit altitudeEdit = AltitudeEdit.this;
                    int unused = altitudeEdit.altitude = i + altitudeEdit.minAltmAGL;
                    AltitudeEdit.this.altitudeChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.pointedit_minus_alt);
        this.altMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AltitudeEdit.access$010(AltitudeEdit.this);
                AltitudeEdit.this.altitudeChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.pointedit_plus_alt);
        this.altPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AltitudeEdit.access$008(AltitudeEdit.this);
                AltitudeEdit.this.altitudeChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.pointedit_select_alt), (CheckBox) findViewById(C1877R.C1878id.pointedit_select_alt_check));
    }

    /* access modifiers changed from: private */
    public void altitudeChanged() {
        int i = this.altitude;
        int i2 = this.minAltmAGL;
        if (i > i2) {
            this.altMinus.setEnabled(true);
        } else {
            this.altitude = i2;
            this.altMinus.setEnabled(false);
        }
        int i3 = this.altitude;
        int i4 = this.maxAltmAGL;
        if (i3 < i4) {
            this.altPlus.setEnabled(true);
        } else {
            this.altitude = i4;
            this.altPlus.setEnabled(false);
        }
        this.altValue.setText(String.valueOf(TasksFragment.convertAltitudeToDisplay(this.point, (float) this.altitude)));
        this.altSeek.setProgress(this.altitude - this.minAltmAGL);
    }

    public int getAltitude() {
        return this.altitude;
    }

    public void setAltitude(int i) {
        this.altitude = i;
    }

    public void refresh() {
        TextView textView = this.altUnits;
        textView.setText("(" + TasksFragment.getSpeedUnitsToDisplay() + ")");
        this.altValue.setText(String.valueOf(TasksFragment.convertAltitudeToDisplay(this.point, (float) this.altitude)));
        this.altSeek.setProgress(this.altitude - this.minAltmAGL);
    }

    public void disable(boolean z) {
        if (z) {
            this.altTitle.setTextColor(-7829368);
            this.altUnits.setTextColor(-7829368);
            this.altValue.setTextColor(-7829368);
        } else {
            this.altTitle.setTextColor(-1);
            this.altUnits.setTextColor(-1);
            this.altValue.setTextColor(getResources().getColor(C1877R.color.lightBlue));
        }
        this.altMinus.setEnabled(!z);
        this.altSeek.setEnabled(!z);
        this.altPlus.setEnabled(!z);
    }
}
