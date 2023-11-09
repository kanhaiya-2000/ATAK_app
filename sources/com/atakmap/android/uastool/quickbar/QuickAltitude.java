package com.atakmap.android.uastool.quickbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.DJIReflector;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.quickbar.Quickbar;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.maps.coords.GeoPoint;

public class QuickAltitude extends RelativeLayout {
    private static final String TAG = "QuickAltitude";
    private Button altFormatButton;
    private ImageButton altMinus;
    private ImageButton altPlus;
    private SeekBar altSeek;
    private TextView altText;
    private TextView altTitle;
    private Button altUnitsButton;
    private TextView altValue;
    /* access modifiers changed from: private */
    public int altitude_mAGL;
    private Button cancelButton;
    private boolean doOrbit;
    private boolean doSpeed;
    private boolean isTakeoff;
    private int maxAlt_mAGL;
    private int maxOrbitRadius_m;
    private int maxSpeed_mps;
    /* access modifiers changed from: private */
    public int minAlt_mAGL;
    /* access modifiers changed from: private */
    public int minOrbitRadius_m;
    /* access modifiers changed from: private */
    public int minSpeed_mps;
    private Button okButton;
    private Quickbar.QuickBarQuickTaskCallback okTaskCallback;
    /* access modifiers changed from: private */
    public boolean orbitClockwise;
    /* access modifiers changed from: private */
    public Button orbitDirectionButton;
    private ImageButton orbitMinus;
    private ImageButton orbitPlus;
    /* access modifiers changed from: private */
    public int orbitRadius_m;
    private SeekBar orbitSeek;
    private TextView orbitValue;
    private Quickbar quickBar;
    private ImageButton speedMinus;
    private ImageButton speedPlus;
    private SeekBar speedSeek;
    private TextView speedValue;
    /* access modifiers changed from: private */
    public int speed_mps;
    private UASItem uasItem;

    static /* synthetic */ int access$108(QuickAltitude quickAltitude) {
        int i = quickAltitude.altitude_mAGL;
        quickAltitude.altitude_mAGL = i + 1;
        return i;
    }

    static /* synthetic */ int access$110(QuickAltitude quickAltitude) {
        int i = quickAltitude.altitude_mAGL;
        quickAltitude.altitude_mAGL = i - 1;
        return i;
    }

    static /* synthetic */ int access$408(QuickAltitude quickAltitude) {
        int i = quickAltitude.speed_mps;
        quickAltitude.speed_mps = i + 1;
        return i;
    }

    static /* synthetic */ int access$410(QuickAltitude quickAltitude) {
        int i = quickAltitude.speed_mps;
        quickAltitude.speed_mps = i - 1;
        return i;
    }

    static /* synthetic */ int access$908(QuickAltitude quickAltitude) {
        int i = quickAltitude.orbitRadius_m;
        quickAltitude.orbitRadius_m = i + 1;
        return i;
    }

    static /* synthetic */ int access$910(QuickAltitude quickAltitude) {
        int i = quickAltitude.orbitRadius_m;
        quickAltitude.orbitRadius_m = i - 1;
        return i;
    }

    public QuickAltitude(Context context) {
        super(context);
    }

    public QuickAltitude(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QuickAltitude(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(UASItem uASItem, Quickbar quickbar, Quickbar.QuickBarQuickTaskCallback quickBarQuickTaskCallback) {
        this.uasItem = uASItem;
        if (uASItem.readyToTakeoff()) {
            this.minAlt_mAGL = (int) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_AGL_MIN, 5.0d);
        } else {
            this.minAlt_mAGL = 0;
        }
        this.maxAlt_mAGL = (int) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_AGL_MAX, 500.0d);
        this.quickBar = quickbar;
        this.okTaskCallback = quickBarQuickTaskCallback;
        int i = this.minAlt_mAGL;
        if (i == 0) {
            this.isTakeoff = false;
            this.altitude_mAGL = convertHAEToAGL(uASItem.getGeoPoint().getAltitude());
            return;
        }
        this.isTakeoff = true;
        this.altitude_mAGL = i;
    }

    public void init_speed() {
        this.doSpeed = true;
        UASItem uASItem = this.uasItem;
        this.maxSpeed_mps = (int) UASItem.getCapabilityValueDouble(uASItem, uASItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, 12.0d);
        UASItem uASItem2 = this.uasItem;
        this.minSpeed_mps = (int) UASItem.getCapabilityValueDouble(uASItem2, uASItem2.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, 2.0d);
        UASItem uASItem3 = this.uasItem;
        this.speed_mps = (int) UASItem.getCapabilityValueDouble(uASItem3, uASItem3.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 12.0d);
    }

    public void init_orbit(GeoPoint geoPoint) {
        UASItem uASItem;
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        this.doOrbit = true;
        UASItem uASItem2 = this.uasItem;
        this.maxOrbitRadius_m = (int) UASItem.getCapabilityValueDouble(uASItem2, uASItem2.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, 500.0d);
        UASItem uASItem3 = this.uasItem;
        this.minOrbitRadius_m = (int) UASItem.getCapabilityValueDouble(uASItem3, uASItem3.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, 5.0d);
        UASItem uASItem4 = this.uasItem;
        this.orbitRadius_m = (int) UASItem.getCapabilityValueDouble(uASItem4, uASItem4.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, 10.0d);
        if (geoPoint == null || (uASItem = this.uasItem) == null || uASItem.getGeoPoint() == null || geoPoint.distanceTo(this.uasItem.getGeoPoint()) >= 10000.0d) {
            this.orbitRadius_m = sharedPrefs.getInt(UASToolPreferenceFragment.QUICKTASK_PREF_ORBIT_RADIUS, this.orbitRadius_m);
        } else {
            this.orbitRadius_m = (int) geoPoint.distanceTo(this.uasItem.getGeoPoint());
        }
        int i = this.orbitRadius_m;
        if (i < 0) {
            this.orbitClockwise = false;
            this.orbitRadius_m = i * -1;
            return;
        }
        this.orbitClockwise = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        String str;
        String str2;
        String str3;
        super.onAttachedToWindow();
        LinearLayout linearLayout = (LinearLayout) findViewById(C1877R.C1878id.quickalt_layout);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(C1877R.C1878id.quickspeed_layout);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(C1877R.C1878id.quickorbit_layout);
        if (this.isTakeoff) {
            str3 = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_takeoff_title);
            str2 = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_takeoff_text);
            str = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_takeoff_button);
        } else {
            str3 = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_title);
            str2 = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_text);
            str = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_button);
        }
        if (this.doOrbit) {
            str3 = "Orbit";
            str = "Do Orbit";
        }
        TextView textView = (TextView) findViewById(C1877R.C1878id.quickalt_title);
        this.altTitle = textView;
        textView.setText(str3);
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.quickalt_text);
        this.altText = textView2;
        textView2.setText(str2);
        TextView textView3 = (TextView) findViewById(C1877R.C1878id.quickalt_value);
        this.altValue = textView3;
        textView3.setText(String.valueOf(convertAGLToDisplay((float) this.altitude_mAGL)));
        int i = 0;
        linearLayout2.setVisibility(this.doSpeed ? 0 : 8);
        linearLayout3.setVisibility(this.doOrbit ? 0 : 8);
        if (this.doOrbit) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        Button button = (Button) findViewById(C1877R.C1878id.quickalt_units);
        this.altUnitsButton = button;
        button.setText(this.quickBar.getAltUnitsString());
        this.altUnitsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.this.toggleAltUnits();
            }
        });
        Button button2 = (Button) findViewById(C1877R.C1878id.quickalt_format);
        this.altFormatButton = button2;
        button2.setText(this.quickBar.getAltFormatString());
        this.altFormatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.this.toggleAltFormat();
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.quickalt_seek);
        this.altSeek = seekBar;
        seekBar.setMax(this.maxAlt_mAGL - this.minAlt_mAGL);
        this.altSeek.setProgress(this.altitude_mAGL - this.minAlt_mAGL);
        this.altSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    QuickAltitude quickAltitude = QuickAltitude.this;
                    int unused = quickAltitude.altitude_mAGL = i + quickAltitude.minAlt_mAGL;
                    QuickAltitude.this.altitudeChanged();
                }
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.quickalt_minus);
        this.altMinus = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$110(QuickAltitude.this);
                QuickAltitude.this.altitudeChanged();
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.quickalt_plus);
        this.altPlus = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$108(QuickAltitude.this);
                QuickAltitude.this.altitudeChanged();
            }
        });
        TextView textView4 = (TextView) findViewById(C1877R.C1878id.quickspeed_value);
        this.speedValue = textView4;
        textView4.setText(String.valueOf(convertAGLToDisplay((float) this.speed_mps)));
        SeekBar seekBar2 = (SeekBar) findViewById(C1877R.C1878id.quickspeed_seek);
        this.speedSeek = seekBar2;
        seekBar2.setMax(this.maxSpeed_mps - this.minSpeed_mps);
        this.speedSeek.setProgress(this.speed_mps - this.minSpeed_mps);
        this.speedSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    QuickAltitude quickAltitude = QuickAltitude.this;
                    int unused = quickAltitude.speed_mps = i + quickAltitude.minSpeed_mps;
                    QuickAltitude.this.speedChanged();
                }
            }
        });
        ImageButton imageButton3 = (ImageButton) findViewById(C1877R.C1878id.quickspeed_minus);
        this.speedMinus = imageButton3;
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$410(QuickAltitude.this);
                QuickAltitude.this.speedChanged();
            }
        });
        ImageButton imageButton4 = (ImageButton) findViewById(C1877R.C1878id.quickspeed_plus);
        this.speedPlus = imageButton4;
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$408(QuickAltitude.this);
                QuickAltitude.this.speedChanged();
            }
        });
        Button button3 = (Button) findViewById(C1877R.C1878id.quickorbit_direction);
        this.orbitDirectionButton = button3;
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude quickAltitude = QuickAltitude.this;
                boolean unused = quickAltitude.orbitClockwise = !quickAltitude.orbitClockwise;
                QuickAltitude.this.orbitDirectionButton.setText(QuickAltitude.this.orbitClockwise ? "CW" : "CCW");
            }
        });
        this.orbitDirectionButton.setText(this.orbitClockwise ? "CW" : "CCW");
        TextView textView5 = (TextView) findViewById(C1877R.C1878id.quickorbit_value);
        this.orbitValue = textView5;
        textView5.setText(Utils.formatRange((double) this.orbitRadius_m));
        SeekBar seekBar3 = (SeekBar) findViewById(C1877R.C1878id.quickorbit_seek);
        this.orbitSeek = seekBar3;
        seekBar3.setMax(this.maxOrbitRadius_m - this.minOrbitRadius_m);
        this.orbitSeek.setProgress(this.orbitRadius_m - this.minOrbitRadius_m);
        this.orbitSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    QuickAltitude quickAltitude = QuickAltitude.this;
                    int unused = quickAltitude.orbitRadius_m = i + quickAltitude.minOrbitRadius_m;
                    QuickAltitude.this.orbitChanged();
                }
            }
        });
        ImageButton imageButton5 = (ImageButton) findViewById(C1877R.C1878id.quickorbit_minus);
        this.orbitMinus = imageButton5;
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$910(QuickAltitude.this);
                QuickAltitude.this.orbitChanged();
            }
        });
        ImageButton imageButton6 = (ImageButton) findViewById(C1877R.C1878id.quickorbit_plus);
        this.orbitPlus = imageButton6;
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.access$908(QuickAltitude.this);
                QuickAltitude.this.orbitChanged();
            }
        });
        Button button4 = (Button) findViewById(C1877R.C1878id.quickalt_cancel);
        this.cancelButton = button4;
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.this.cancel();
            }
        });
        Button button5 = (Button) findViewById(C1877R.C1878id.quickalt_ok);
        this.okButton = button5;
        button5.setText(str);
        this.okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuickAltitude.this.m15066ok();
            }
        });
        this.altValue.setText(String.valueOf(convertAGLToDisplay((float) this.altitude_mAGL)));
        this.altSeek.setProgress(this.altitude_mAGL - this.minAlt_mAGL);
        this.speedValue.setText(String.valueOf(ae.a().a((double) this.speed_mps)));
        this.speedSeek.setProgress(this.speed_mps - this.minSpeed_mps);
        this.orbitValue.setText(Utils.formatRange((double) this.orbitRadius_m));
        this.orbitSeek.setProgress(this.orbitRadius_m - this.minOrbitRadius_m);
    }

    /* access modifiers changed from: private */
    public void toggleAltUnits() {
        this.quickBar.toggleAltUnits();
        this.altUnitsButton.setText(this.quickBar.getAltUnitsString());
        this.altValue.setText(String.valueOf(convertAGLToDisplay((float) this.altitude_mAGL)));
    }

    /* access modifiers changed from: protected */
    public void toggleAltFormat() {
        this.quickBar.toggleAltFormat();
        this.altFormatButton.setText(this.quickBar.getAltFormatString());
        this.altValue.setText(String.valueOf(convertAGLToDisplay((float) this.altitude_mAGL)));
    }

    /* access modifiers changed from: private */
    public void altitudeChanged() {
        int i = this.altitude_mAGL;
        int i2 = this.minAlt_mAGL;
        if (i > i2) {
            this.altMinus.setEnabled(true);
        } else {
            this.altitude_mAGL = i2;
            this.altMinus.setEnabled(false);
        }
        int i3 = this.altitude_mAGL;
        int i4 = this.maxAlt_mAGL;
        if (i3 < i4) {
            this.altPlus.setEnabled(true);
        } else {
            this.altitude_mAGL = i4;
            this.altPlus.setEnabled(false);
        }
        if (!this.isTakeoff) {
            if (this.altitude_mAGL == 0) {
                this.altTitle.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_title));
                this.altText.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_text));
                this.okButton.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_button));
            } else {
                this.altTitle.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_alt_title));
                this.altText.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_alt_text));
                this.okButton.setText(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_alt_button));
            }
        }
        this.altValue.setText(String.valueOf(convertAGLToDisplay((float) this.altitude_mAGL)));
        this.altSeek.setProgress(this.altitude_mAGL - this.minAlt_mAGL);
    }

    /* access modifiers changed from: private */
    public void speedChanged() {
        this.speedValue.setText(String.valueOf(ae.a().a((double) this.speed_mps)));
        this.speedSeek.setProgress(this.speed_mps - this.minSpeed_mps);
    }

    /* access modifiers changed from: private */
    public void orbitChanged() {
        this.orbitValue.setText(Utils.formatRange((double) this.orbitRadius_m));
        this.orbitSeek.setProgress(this.orbitRadius_m - this.minOrbitRadius_m);
    }

    public int getAltitude() {
        return this.altitude_mAGL;
    }

    public void setAltitude(int i) {
        this.altitude_mAGL = i;
    }

    /* access modifiers changed from: private */
    public void cancel() {
        this.quickBar.cancelAltitude();
    }

    /* access modifiers changed from: private */
    /* renamed from: ok */
    public void m15066ok() {
        if (this.okButton.getText().equals(UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.quickalt_land_button))) {
            this.altitude_mAGL = 0;
        }
        if (this.doOrbit) {
            SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
            edit.putInt(UASToolPreferenceFragment.QUICKTASK_PREF_ORBIT_RADIUS, this.orbitRadius_m * (this.orbitClockwise ? 1 : -1));
            edit.apply();
        }
        Quickbar.QuickBarQuickTaskCallback quickBarQuickTaskCallback = this.okTaskCallback;
        if (quickBarQuickTaskCallback != null) {
            quickBarQuickTaskCallback.onTaskComplete(this.isTakeoff, (double) this.altitude_mAGL, (double) this.orbitRadius_m, this.orbitClockwise);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int convertAGLToDisplay(float r7) {
        /*
            r6 = this;
            com.atakmap.android.uastool.UASItem r0 = r6.uasItem
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r0.getGeoPoint()
            if (r0 == 0) goto L_0x007a
            com.atakmap.android.uastool.quickbar.Quickbar r1 = r6.quickBar
            java.lang.String r1 = r1.getAltFormatString()
            java.lang.String r2 = "HAL"
            boolean r1 = r1.equals(r2)
            r2 = -1
            if (r1 == 0) goto L_0x0019
            double r0 = (double) r7
            goto L_0x0050
        L_0x0019:
            com.atakmap.android.uastool.quickbar.Quickbar r1 = r6.quickBar
            java.lang.String r1 = r1.getAltFormatString()
            int r3 = r1.hashCode()
            r4 = 71276(0x1166c, float:9.9879E-41)
            if (r3 == r4) goto L_0x0038
            r4 = 76646(0x12b66, float:1.07404E-40)
            if (r3 == r4) goto L_0x002e
            goto L_0x0042
        L_0x002e:
            java.lang.String r3 = "MSL"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0042
            r1 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r3 = "HAE"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0042
            r1 = 1
            goto L_0x0043
        L_0x0042:
            r1 = -1
        L_0x0043:
            if (r1 == 0) goto L_0x004a
            double r0 = r0.getAltitude()
            goto L_0x004e
        L_0x004a:
            double r0 = com.atakmap.coremap.maps.conversion.EGM96.getMSL(r0)
        L_0x004e:
            double r3 = (double) r7
            double r0 = r0 + r3
        L_0x0050:
            com.atakmap.android.uastool.quickbar.Quickbar r7 = r6.quickBar
            java.lang.String r7 = r7.getAltUnitsString()
            r7.hashCode()
            java.lang.String r3 = "m"
            boolean r3 = r7.equals(r3)
            r4 = 4614570213464309537(0x400a3f28fca37f21, double:3.280839895)
            if (r3 != 0) goto L_0x006d
            java.lang.String r3 = "ft"
            boolean r7 = r7.equals(r3)
            goto L_0x006f
        L_0x006d:
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x006f:
            boolean r7 = java.lang.Double.isNaN(r0)
            if (r7 == 0) goto L_0x0076
            return r2
        L_0x0076:
            double r4 = r4 * r0
            int r7 = (int) r4
            return r7
        L_0x007a:
            int r7 = (int) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.quickbar.QuickAltitude.convertAGLToDisplay(float):int");
    }

    private int convertHAEToAGL(double d) {
        return (int) (d - DJIReflector.getDTEDElevation(this.uasItem.getGeoPoint().getLatitude(), this.uasItem.getGeoPoint().getLongitude()).doubleValue());
    }
}
