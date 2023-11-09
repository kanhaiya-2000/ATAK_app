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
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.util.ae;

public class OrbitSpeedEdit extends MultiEdit {
    private int linearSpeedUnits = -1;
    private int maxSpeed;
    /* access modifiers changed from: private */
    public int minSpeed;
    private OrbitRadiusEdit orbitRadiusEdit;
    private Context pluginContext;
    /* access modifiers changed from: private */
    public int speed;
    private ImageButton speedMinus;
    private ImageButton speedPlus;
    private SeekBar speedSeek;
    private TextView speedTitle;
    private TextView speedUnits;
    private TextView speedValue;
    private String unitsType;

    static /* synthetic */ int access$008(OrbitSpeedEdit orbitSpeedEdit) {
        int i = orbitSpeedEdit.speed;
        orbitSpeedEdit.speed = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(OrbitSpeedEdit orbitSpeedEdit) {
        int i = orbitSpeedEdit.speed;
        orbitSpeedEdit.speed = i - 1;
        return i;
    }

    public OrbitSpeedEdit(Context context) {
        super(context);
    }

    public OrbitSpeedEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitSpeedEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, int i2, int i3, String str, boolean z) {
        super.init(z);
        if (i <= 0) {
            i = 1;
        }
        this.speed = i;
        if (i2 <= 0) {
            i2 = 1;
        }
        this.minSpeed = i2;
        this.maxSpeed = i3;
        this.unitsType = str;
        this.pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
        try {
            this.linearSpeedUnits = Integer.parseInt(UASToolDropDownReceiver.getInstance().getAtakPrefs().getString("speed_unit_pref", "0"));
        } catch (Exception unused) {
            this.linearSpeedUnits = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.speedTitle = (TextView) findViewById(C1877R.C1878id.orbitedit_text_speed);
        TextView textView = (TextView) findViewById(C1877R.C1878id.orbitedit_units_speed);
        this.speedUnits = textView;
        textView.setText("(" + getUnitsString() + ")");
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.orbitedit_value_speed);
        this.speedValue = textView2;
        textView2.setText(convertSpeedToDisplay(this.speed));
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.orbitedit_seek_speed);
        this.speedSeek = seekBar;
        seekBar.setMax(this.maxSpeed - this.minSpeed);
        this.speedSeek.setProgress(this.speed - this.minSpeed);
        this.speedSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    OrbitSpeedEdit orbitSpeedEdit = OrbitSpeedEdit.this;
                    int unused = orbitSpeedEdit.speed = i + orbitSpeedEdit.minSpeed;
                    OrbitSpeedEdit.this.speedChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.orbitedit_minus_speed);
        this.speedMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitSpeedEdit.access$010(OrbitSpeedEdit.this);
                OrbitSpeedEdit.this.speedChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.orbitedit_plus_speed);
        this.speedPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitSpeedEdit.access$008(OrbitSpeedEdit.this);
                OrbitSpeedEdit.this.speedChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.orbitedit_select_speed), (CheckBox) findViewById(C1877R.C1878id.orbitedit_select_speed_check));
    }

    private String getUnitsString() {
        String str = this.unitsType;
        if (str == null) {
            return "";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -2049342683) {
            if (hashCode == -140551742 && str.equals(OrbitPoint.ORBITSPEED_UNITS_ANGULAR)) {
                c = 1;
            }
        } else if (str.equals(OrbitPoint.ORBITSPEED_UNITS_LINEAR)) {
            c = 0;
        }
        if (c != 0) {
            return this.pluginContext.getResources().getString(C1877R.string.orbitspeed_units_angular);
        }
        return getLinearUnitsString();
    }

    public String getUnitsType() {
        return this.unitsType;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getMinSpeed() {
        return this.minSpeed;
    }

    public String getLinearUnitsString() {
        int i = this.linearSpeedUnits;
        if (i == -1) {
            return "";
        }
        return i != 0 ? this.pluginContext.getResources().getString(C1877R.string.orbitspeed_units_linear_metric) : this.pluginContext.getResources().getString(C1877R.string.orbitspeed_units_linear_imperial);
    }

    private String convertSpeedToDisplay(int i) {
        double d = (double) i;
        if (Double.isNaN(d) || i == 0) {
            return "-";
        }
        OrbitRadiusEdit orbitRadiusEdit2 = this.orbitRadiusEdit;
        if (orbitRadiusEdit2 == null) {
            return ae.a().a(d);
        }
        int circumference = (int) orbitRadiusEdit2.getCircumference();
        if (OrbitPoint.ORBITSPEED_UNITS_ANGULAR.equals(this.unitsType)) {
            int angularToLinear = angularToLinear(i);
            return ((double) (360 / i)) + "s - " + ae.a().a((double) angularToLinear);
        } else if (!OrbitPoint.ORBITSPEED_UNITS_LINEAR.equals(this.unitsType)) {
            return ae.a().a(d);
        } else {
            int i2 = circumference / i;
            return i2 + "s - " + ae.a().a(d);
        }
    }

    public void speedChanged() {
        int i = this.speed;
        int i2 = this.minSpeed;
        int i3 = this.maxSpeed;
        if (OrbitPoint.ORBITSPEED_UNITS_ANGULAR.equals(this.unitsType)) {
            i = angularToLinear(this.speed);
            i3 = linearToAngular(this.maxSpeed);
            i2 = linearToAngular(this.minSpeed);
        }
        if (i > this.minSpeed) {
            this.speedMinus.setEnabled(true);
        } else {
            this.speed = i2;
            this.speedMinus.setEnabled(false);
        }
        if (i < this.maxSpeed) {
            this.speedPlus.setEnabled(true);
        } else {
            this.speed = i3;
            this.speedPlus.setEnabled(false);
        }
        this.speedValue.setText(convertSpeedToDisplay(this.speed));
        this.speedSeek.setProgress(this.speed - this.minSpeed);
        OrbitRadiusEdit orbitRadiusEdit2 = this.orbitRadiusEdit;
        if (orbitRadiusEdit2 != null) {
            orbitRadiusEdit2.speedChanged();
        }
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public void refresh() {
        this.speedValue.setText(convertSpeedToDisplay(this.speed));
        this.speedSeek.setProgress(this.speed - this.minSpeed);
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

    public void setOrbitRadiusEdit(OrbitRadiusEdit orbitRadiusEdit2) {
        this.orbitRadiusEdit = orbitRadiusEdit2;
    }

    private int angularToLinear(int i) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.round(this.orbitRadiusEdit.getCircumference() / ((double) (360 / i)));
    }

    private int linearToAngular(int i) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.round(360.0d / (this.orbitRadiusEdit.getCircumference() / ((double) i)));
    }
}
