package com.atakmap.android.uastool.dji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.atakmap.android.atakgo.dji.IDjiAtakInterface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.coremap.log.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class OnboardSdkHelper {
    private static final int DEFAULT_PWM_L_FREQUENCY = 50;
    private static final int DEFAULT_PWM_L_PIN = 3;
    private static final int DEFAULT_PWM_L_PW_HIGH = 2000;
    private static final int DEFAULT_PWM_L_PW_LOW = 1000;
    private static final int DEFAULT_PWM_R_FREQUENCY = 50;
    private static final int DEFAULT_PWM_R_PIN = 4;
    private static final int DEFAULT_PWM_R_PW_HIGH = 2000;
    private static final int DEFAULT_PWM_R_PW_LOW = 1000;
    private static final boolean DEFAULT_TRIGGERS_ENABLED = true;
    private static final String PREF_STORE_ID = "com.atakmap.android.uastool.dji.OnboardSdkHelper";
    private static final String PWM_L_FREQUENCY_ID = "pwmLFrequency";
    private static final String PWM_L_PIN_ID = "pwmLPin";
    private static final String PWM_L_PW_HIGH_ID = "pwmLPWHigh";
    private static final String PWM_L_PW_LOW_ID = "pwmLPWLow";
    private static final String PWM_R_FREQUENCY_ID = "pwmRFrequency";
    private static final String PWM_R_PIN_ID = "pwmRPin";
    private static final String PWM_R_PW_HIGH_ID = "pwmRPWHigh";
    private static final String PWM_R_PW_LOW_ID = "pwmRPWLow";
    /* access modifiers changed from: private */
    public static final String TAG = "com.atakmap.android.uastool.dji.OnboardSdkHelper";
    private static OnboardSdkHelper instance;
    private final SharedPreferences preferences;
    private final AtomicBoolean pwmInitialized = new AtomicBoolean(false);
    private final AtomicInteger pwmLFrequency;
    private final AtomicInteger pwmLPin;
    private final AtomicInteger pwmLPulseWidthHigh;
    private final AtomicInteger pwmLPulseWidthLow;
    private final AtomicInteger pwmRFrequency;
    private final AtomicInteger pwmRPin;
    private final AtomicInteger pwmRPulseWidthHigh;
    private final AtomicInteger pwmRPulseWidthLow;
    /* access modifiers changed from: private */
    public final AtomicBoolean triggerLHighNext = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final AtomicBoolean triggerRHighNext = new AtomicBoolean(true);
    private final AtomicBoolean triggersEnabled;

    private OnboardSdkHelper() {
        IDjiAtakInterface service;
        SharedPreferences sharedPreferences = MapView.getMapView().getContext().getSharedPreferences("com.atakmap.android.uastool.dji.OnboardSdkHelper", 0);
        this.preferences = sharedPreferences;
        this.pwmLPin = new AtomicInteger(sharedPreferences.getInt(PWM_L_PIN_ID, 3));
        this.pwmLFrequency = new AtomicInteger(sharedPreferences.getInt(PWM_L_FREQUENCY_ID, 50));
        this.pwmLPulseWidthLow = new AtomicInteger(sharedPreferences.getInt(PWM_L_PW_LOW_ID, 1000));
        this.pwmLPulseWidthHigh = new AtomicInteger(sharedPreferences.getInt(PWM_L_PW_HIGH_ID, 2000));
        this.pwmRPin = new AtomicInteger(sharedPreferences.getInt(PWM_R_PIN_ID, 4));
        this.pwmRFrequency = new AtomicInteger(sharedPreferences.getInt(PWM_R_FREQUENCY_ID, 50));
        this.pwmRPulseWidthLow = new AtomicInteger(sharedPreferences.getInt(PWM_R_PW_LOW_ID, 1000));
        this.pwmRPulseWidthHigh = new AtomicInteger(sharedPreferences.getInt(PWM_R_PW_HIGH_ID, 2000));
        this.triggersEnabled = new AtomicBoolean(true);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (!(serviceConnection == null || (service = serviceConnection.getService()) == null)) {
            try {
                service.checkOnboardSdkAvailable();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to check onboard sdk availability ", e);
            }
        }
        initPwm();
    }

    public static synchronized OnboardSdkHelper getInstance() {
        OnboardSdkHelper onboardSdkHelper;
        synchronized (OnboardSdkHelper.class) {
            if (instance == null) {
                instance = new OnboardSdkHelper();
            }
            onboardSdkHelper = instance;
        }
        return onboardSdkHelper;
    }

    private void setPreferenceInt(String str, int i) {
        SharedPreferences.Editor edit = this.preferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void setPwmLPin(int i) {
        this.pwmLPin.set(i);
        initPwm();
        setPreferenceInt(PWM_L_PIN_ID, i);
    }

    public int getPwmLPin() {
        return this.pwmLPin.get();
    }

    public void setPwmRPin(int i) {
        this.pwmRPin.set(i);
        initPwm();
        setPreferenceInt(PWM_R_PIN_ID, i);
    }

    public int getPwmRPin() {
        return this.pwmRPin.get();
    }

    public void setPwmLFrequency(int i) {
        this.pwmLFrequency.set(i);
        initPwm();
        setPreferenceInt(PWM_L_FREQUENCY_ID, i);
    }

    public int getPwmLFrequency() {
        return this.pwmLFrequency.get();
    }

    public void setPwmRFrequency(int i) {
        this.pwmRFrequency.set(i);
        initPwm();
        setPreferenceInt(PWM_R_FREQUENCY_ID, i);
    }

    public int getPwmRFrequency() {
        return this.pwmRFrequency.get();
    }

    public void initPwm() {
        IDjiAtakInterface service;
        this.pwmInitialized.set(false);
        if (getOnboardSdkEnabled()) {
            String str = TAG;
            Log.d(str, "initPwm");
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
                try {
                    int pwmLPin2 = getPwmLPin();
                    int pwmLFrequency2 = getPwmLFrequency();
                    Log.d(str, "initPwmSettingsAidl");
                    service.initPwmSettings(pwmLPin2, pwmLFrequency2);
                    int pwmRPin2 = getPwmRPin();
                    int pwmRFrequency2 = getPwmRFrequency();
                    Log.d(str, "initPwmSettingsAidl");
                    service.initPwmSettings(pwmRPin2, pwmRFrequency2);
                } catch (RemoteException e) {
                    Log.w(TAG, "Failed to init pwm R: ", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPwm(int i, int i2) {
        IDjiAtakInterface service;
        String str = TAG;
        Log.d(str, "setPwm");
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
            try {
                if (!this.pwmInitialized.get()) {
                    initPwm();
                }
                Log.d(str, "setPwmAidl");
                service.setPwm(i, i2);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to init pwm L: ", e);
            }
        }
    }

    public int getPwmLPulseWidthHigh() {
        return this.pwmLPulseWidthHigh.get();
    }

    public void setPwmLPulseWidthHigh(int i) {
        this.pwmLPulseWidthHigh.set(i);
        setPreferenceInt(PWM_L_PW_HIGH_ID, i);
    }

    public int getPwmLPulseWidthLow() {
        return this.pwmLPulseWidthLow.get();
    }

    public void setPwmLPulseWidthLow(int i) {
        this.pwmLPulseWidthLow.set(i);
        setPreferenceInt(PWM_L_PW_LOW_ID, i);
    }

    public int getPwmRPulseWidthHigh() {
        return this.pwmRPulseWidthHigh.get();
    }

    public void setPwmRPulseWidthHigh(int i) {
        this.pwmRPulseWidthHigh.set(i);
        setPreferenceInt(PWM_R_PW_HIGH_ID, i);
    }

    public int getPwmRPulseWidthLow() {
        return this.pwmRPulseWidthLow.get();
    }

    public void setPwmRPulseWidthLow(int i) {
        this.pwmRPulseWidthLow.set(i);
        setPreferenceInt(PWM_R_PW_LOW_ID, i);
    }

    public boolean getOnboardSdkEnabled() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getOnboardSdkAvailable();
        }
        return false;
    }

    public boolean getTriggersEnabled() {
        return this.triggersEnabled.get();
    }

    public void actuateLeftTrigger() {
        actuateTrigger(true);
    }

    public void actuateRightTrigger() {
        actuateTrigger(false);
    }

    private void actuateTrigger(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3;
        if (z) {
            i3 = getPwmLPin();
            z2 = this.triggerLHighNext.get();
            i2 = getPwmLPulseWidthHigh();
            i = getPwmLPulseWidthLow();
        } else {
            i3 = getPwmRPin();
            z2 = this.triggerRHighNext.get();
            i2 = getPwmRPulseWidthHigh();
            i = getPwmRPulseWidthLow();
        }
        final int i4 = i3;
        final boolean z3 = z2;
        final int i5 = i2;
        final int i6 = i;
        if (this.pwmInitialized.get()) {
            AlertDialog.Builder title = new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Trigger Confirmation");
            StringBuilder sb = new StringBuilder();
            sb.append("Selecting 'Yes' will set ");
            sb.append(z ? "ONE (LEFT)" : "TWO (RIGHT)");
            sb.append(" Trigger's PWM actuator ");
            sb.append(z3 ? "HIGH" : "LOW");
            sb.append(" (at value ");
            sb.append(z3 ? i5 : i6);
            sb.append(").  Are you sure you want to do that?");
            final boolean z4 = z;
            title.setMessage(sb.toString()).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    int i2;
                    if (z3) {
                        i2 = i5;
                    } else {
                        i2 = i6;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwm(i4, i2);
                        boolean z = false;
                        if (z4) {
                            AtomicBoolean access$100 = OnboardSdkHelper.this.triggerLHighNext;
                            if (!z3) {
                                z = true;
                            }
                            access$100.set(z);
                            return;
                        }
                        AtomicBoolean access$200 = OnboardSdkHelper.this.triggerRHighNext;
                        if (!z3) {
                            z = true;
                        }
                        access$200.set(z);
                    } catch (Exception e) {
                        UASToolDropDownReceiver.toast("Error setting pwm: " + e.getMessage(), 1);
                        Log.w(OnboardSdkHelper.TAG, "Trigger problem: ", e);
                    }
                }
            }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
            return;
        }
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Trigger Confirmation").setMessage("PWM is still initializing, please wait...").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                OnboardSdkHelper.this.initPwm();
            }
        }).show();
    }

    public void setPwmInitialized(boolean z) {
        this.pwmInitialized.set(z);
    }
}
