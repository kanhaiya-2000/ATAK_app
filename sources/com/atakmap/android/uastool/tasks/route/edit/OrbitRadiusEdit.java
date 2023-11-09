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
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class OrbitRadiusEdit extends MultiEdit {
    private int maxRadiusM;
    /* access modifiers changed from: private */
    public int minRadiusM;
    private ArrayList<OrbitPoint> orbitPoints;
    private OrbitSpeedEdit orbitSpeedEdit;
    /* access modifiers changed from: private */
    public int radius;
    private ImageButton radiusMinus;
    private ImageButton radiusPlus;
    private SeekBar radiusSeek;
    private TextView radiusTitle;
    private TextView radiusUnits;
    private TextView radiusValue;
    private RouteTask routeTask;

    static /* synthetic */ int access$008(OrbitRadiusEdit orbitRadiusEdit) {
        int i = orbitRadiusEdit.radius;
        orbitRadiusEdit.radius = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(OrbitRadiusEdit orbitRadiusEdit) {
        int i = orbitRadiusEdit.radius;
        orbitRadiusEdit.radius = i - 1;
        return i;
    }

    public OrbitRadiusEdit(Context context) {
        super(context);
    }

    public OrbitRadiusEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitRadiusEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(int i, int i2, int i3, boolean z, RouteTask routeTask2, ArrayList<OrbitPoint> arrayList) {
        super.init(z);
        this.radius = i;
        this.minRadiusM = i2;
        this.maxRadiusM = i3;
        this.routeTask = routeTask2;
        this.orbitPoints = arrayList;
    }

    public void init(int i, int i2, int i3, boolean z, RouteTask routeTask2, OrbitPoint orbitPoint) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(orbitPoint);
        init(i, i2, i3, z, routeTask2, (ArrayList<OrbitPoint>) arrayList);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.radiusTitle = (TextView) findViewById(C1877R.C1878id.orbitedit_text_radius);
        TextView textView = (TextView) findViewById(C1877R.C1878id.orbitedit_units_radius);
        this.radiusUnits = textView;
        textView.setText("(" + TasksFragment.getRangeUnitsToDisplay() + ")");
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.orbitedit_value_radius);
        this.radiusValue = textView2;
        textView2.setText(String.valueOf(TasksFragment.convertRangeToDisplay((double) this.radius)));
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.orbitedit_seek_radius);
        this.radiusSeek = seekBar;
        seekBar.setMax(this.maxRadiusM - this.minRadiusM);
        this.radiusSeek.setProgress(this.radius - this.minRadiusM);
        this.radiusSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    OrbitRadiusEdit orbitRadiusEdit = OrbitRadiusEdit.this;
                    int unused = orbitRadiusEdit.radius = i + orbitRadiusEdit.minRadiusM;
                    OrbitRadiusEdit.this.radiusChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.orbitedit_minus_radius);
        this.radiusMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitRadiusEdit.access$010(OrbitRadiusEdit.this);
                OrbitRadiusEdit.this.radiusChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.orbitedit_plus_radius);
        this.radiusPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OrbitRadiusEdit.access$008(OrbitRadiusEdit.this);
                OrbitRadiusEdit.this.radiusChanged();
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.orbitedit_select_radius), (CheckBox) findViewById(C1877R.C1878id.orbitedit_select_radius_check));
    }

    /* access modifiers changed from: private */
    public void radiusChanged() {
        speedChanged();
        OrbitSpeedEdit orbitSpeedEdit2 = this.orbitSpeedEdit;
        if (orbitSpeedEdit2 != null) {
            orbitSpeedEdit2.speedChanged();
        }
    }

    public void speedChanged() {
        int maxOrbitRadius = getMaxOrbitRadius(this.maxRadiusM);
        int maxOrbitRadius2 = getMaxOrbitRadius(this.minRadiusM);
        if (this.radius > maxOrbitRadius2) {
            this.radiusMinus.setEnabled(true);
        } else {
            this.radius = maxOrbitRadius2;
            this.radiusMinus.setEnabled(false);
        }
        if (this.radius < maxOrbitRadius) {
            this.radiusPlus.setEnabled(true);
        } else {
            this.radius = maxOrbitRadius;
            this.radiusPlus.setEnabled(false);
        }
        this.radiusValue.setText(String.valueOf(TasksFragment.convertRangeToDisplay((double) this.radius)));
        this.radiusSeek.setProgress(this.radius - this.minRadiusM);
        Iterator<OrbitPoint> it = this.orbitPoints.iterator();
        while (it.hasNext()) {
            it.next().setOrbitRadius((float) this.radius);
        }
        RouteTask routeTask2 = this.routeTask;
        if (routeTask2 != null && routeTask2.isViewing()) {
            if (this.isMulti) {
                this.routeTask.view((UASPoint) null, false);
            } else {
                this.routeTask.view(this.orbitPoints.get(0), false);
            }
        }
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public double getCircumference() {
        return ((double) this.radius) * 6.283185307179586d;
    }

    public void refresh() {
        TextView textView = this.radiusUnits;
        textView.setText("(" + TasksFragment.getRangeUnitsToDisplay() + ")");
        this.radiusValue.setText(String.valueOf(TasksFragment.convertRangeToDisplay((double) this.radius)));
        this.radiusSeek.setProgress(this.radius - this.minRadiusM);
    }

    public void disable(boolean z) {
        if (z) {
            this.radiusTitle.setTextColor(-7829368);
            this.radiusUnits.setTextColor(-7829368);
            this.radiusValue.setTextColor(-7829368);
        } else {
            this.radiusTitle.setTextColor(-1);
            this.radiusUnits.setTextColor(-1);
            this.radiusValue.setTextColor(getResources().getColor(C1877R.color.lightBlue));
        }
        this.radiusMinus.setEnabled(!z);
        this.radiusSeek.setEnabled(!z);
        this.radiusPlus.setEnabled(!z);
    }

    public void setOrbitSpeedEdit(OrbitSpeedEdit orbitSpeedEdit2) {
        this.orbitSpeedEdit = orbitSpeedEdit2;
    }

    public int getMaxOrbitRadius(int i) {
        OrbitSpeedEdit orbitSpeedEdit2 = this.orbitSpeedEdit;
        if (orbitSpeedEdit2 == null || !OrbitPoint.ORBITSPEED_UNITS_ANGULAR.equals(orbitSpeedEdit2.getUnitsType())) {
            return i;
        }
        double maxSpeed = ((double) this.orbitSpeedEdit.getMaxSpeed()) / ((1.0d / (360.0d / ((double) this.orbitSpeedEdit.getSpeed()))) * 6.283185307179586d);
        return maxSpeed < ((double) i) ? (int) maxSpeed : i;
    }

    public int getMinOrbitRadius(int i) {
        OrbitSpeedEdit orbitSpeedEdit2 = this.orbitSpeedEdit;
        if (orbitSpeedEdit2 == null || !OrbitPoint.ORBITSPEED_UNITS_ANGULAR.equals(orbitSpeedEdit2.getUnitsType())) {
            return i;
        }
        double minSpeed = ((double) this.orbitSpeedEdit.getMinSpeed()) / ((1.0d / (360.0d / ((double) this.orbitSpeedEdit.getSpeed()))) * 6.283185307179586d);
        return minSpeed > ((double) i) ? (int) minSpeed : i;
    }
}
