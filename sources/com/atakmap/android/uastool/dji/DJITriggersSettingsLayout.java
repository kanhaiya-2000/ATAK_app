package com.atakmap.android.uastool.dji;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import java.util.Locale;

public class DJITriggersSettingsLayout extends RelativeLayout {
    public static final String SHOW_TRIGGERS_PREF = "com.atakmap.android.uastool.dji.triggersShown";
    public static final String TAG = "DJITriggersSettingsLayout";
    /* access modifiers changed from: private */
    public EditText pwmLFrequencyEdit;
    /* access modifiers changed from: private */
    public EditText pwmLPinEdit;
    /* access modifiers changed from: private */
    public EditText pwmLPulseWidthHighEdit;
    /* access modifiers changed from: private */
    public EditText pwmLPulseWidthLowEdit;
    /* access modifiers changed from: private */
    public EditText pwmRFrequencyEdit;
    /* access modifiers changed from: private */
    public EditText pwmRPinEdit;
    /* access modifiers changed from: private */
    public EditText pwmRPulseWidthHighEdit;
    /* access modifiers changed from: private */
    public EditText pwmRPulseWidthLowEdit;
    private CheckBox showTriggersCheck;

    public DJITriggersSettingsLayout(Context context) {
        super(context);
    }

    public DJITriggersSettingsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJITriggersSettingsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: private */
    public void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    public void onAttachedToWindow() {
        SharedPreferences sharedPreferences;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            sharedPreferences = UASToolDropDownReceiver.getSharedPrefs();
        } else {
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            this.pwmLPinEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_left_pin_edit);
            int pwmLPin = OnboardSdkHelper.getInstance().getPwmLPin();
            this.pwmLPinEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmLPin)}));
            this.pwmLPinEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return true;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmLPin(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPinEdit.getText().toString()));
                        return true;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid left PWM pin (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid left PWM pin (edit)", e);
                        return true;
                    }
                }
            });
            this.pwmLPinEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmLPin(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPinEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid left PWM pin (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid left PWM pin (focus): ", e);
                        }
                    }
                }
            });
            this.pwmLPinEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("IO Pin #", "Set which IO pin on the platform will be controlled by the left trigger (labeled 1).");
                    return true;
                }
            });
            this.pwmLPulseWidthLowEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_left_pw_low_edit);
            int pwmLPulseWidthLow = OnboardSdkHelper.getInstance().getPwmLPulseWidthLow();
            this.pwmLPulseWidthLowEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmLPulseWidthLow)}));
            this.pwmLPulseWidthLowEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmLPulseWidthLow(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPulseWidthLowEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid left pulse width low (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid left pulse width low (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmLPulseWidthLowEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmLPulseWidthLow(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPulseWidthLowEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid left pulse width low (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid left pulse width low (focus): ", e);
                        }
                    }
                }
            });
            this.pwmLPulseWidthLowEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("Pulse Width Low (us)", "Set the pulse width in microseconds of the low PWM signal for the left trigger (labeled 1).");
                    return true;
                }
            });
            this.pwmLPulseWidthHighEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_left_pw_high_edit);
            int pwmLPulseWidthHigh = OnboardSdkHelper.getInstance().getPwmLPulseWidthHigh();
            this.pwmLPulseWidthHighEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmLPulseWidthHigh)}));
            this.pwmLPulseWidthHighEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmLPulseWidthHigh(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPulseWidthHighEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid left pulse width high (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid left pulse width high (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmLPulseWidthHighEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmLPulseWidthHigh(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLPulseWidthHighEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid left pulse width high (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid left pulse width high (focus): ", e);
                        }
                    }
                }
            });
            this.pwmLPulseWidthHighEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("Pulse Width High (us)", "Set the pulse width in microseconds of the high PWM signal for the left trigger (labeled 1).");
                    return true;
                }
            });
            this.pwmLFrequencyEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_left_frequency_edit);
            int pwmLFrequency = OnboardSdkHelper.getInstance().getPwmLFrequency();
            this.pwmLFrequencyEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmLFrequency)}));
            this.pwmLFrequencyEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return true;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmLFrequency(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLFrequencyEdit.getText().toString()));
                        return true;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid left PWM frequency (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid left PWM frequency (edit): ", e);
                        return true;
                    }
                }
            });
            this.pwmLFrequencyEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmLFrequency(Integer.parseInt(DJITriggersSettingsLayout.this.pwmLFrequencyEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid left PWM frequency (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid left PWM frequency (focus): ", e);
                        }
                    }
                }
            });
            this.pwmLFrequencyEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("PWM Frequency (Hz)", "Set the frequency in Hz of the Pulse Width Modulation signal controlled by the left trigger (labeled 1).");
                    return true;
                }
            });
            this.pwmRPinEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_right_pin_edit);
            int pwmRPin = OnboardSdkHelper.getInstance().getPwmRPin();
            this.pwmRPinEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmRPin)}));
            this.pwmRPinEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmRPin(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPinEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid right PWM pin (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid right PWM pin (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmRPinEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmRPin(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPinEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid right PWM pin (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid right PWM pin (focus): ", e);
                        }
                    }
                }
            });
            this.pwmRPinEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("IO Pin #", "Set which IO pin on the platform will be controlled by the right trigger (labeled 2).");
                    return true;
                }
            });
            this.pwmRPulseWidthLowEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_right_pw_low_edit);
            int pwmRPulseWidthLow = OnboardSdkHelper.getInstance().getPwmRPulseWidthLow();
            this.pwmRPulseWidthLowEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmRPulseWidthLow)}));
            this.pwmRPulseWidthLowEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmRPulseWidthLow(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPulseWidthLowEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid right pulse width low (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid right pulse width low (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmRPulseWidthLowEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmRPulseWidthLow(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPulseWidthLowEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid right pulse width low (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid right pulse width low (focus): ", e);
                        }
                    }
                }
            });
            this.pwmRPulseWidthLowEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("Pulse Width Low (us)", "Set the pulse width in microseconds of the low PWM signal for the right trigger (labeled 2).");
                    return true;
                }
            });
            this.pwmRPulseWidthHighEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_right_pw_high_edit);
            int pwmRPulseWidthHigh = OnboardSdkHelper.getInstance().getPwmRPulseWidthHigh();
            this.pwmRPulseWidthHighEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmRPulseWidthHigh)}));
            this.pwmRPulseWidthHighEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmRPulseWidthHigh(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPulseWidthHighEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid right pulse width high (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid right pulse width high (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmRPulseWidthHighEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmRPulseWidthHigh(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRPulseWidthHighEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid right pulse width high (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid right pulse width high (focus): ", e);
                        }
                    }
                }
            });
            this.pwmRPulseWidthHighEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("Pulse Width High (us)", "Set the pulse width in microseconds of the high PWM signal for the right trigger (labeled 2).");
                    return true;
                }
            });
            this.pwmRFrequencyEdit = (EditText) findViewById(C1877R.C1878id.djisettings_pwm_right_frequency_edit);
            int pwmRFrequency = OnboardSdkHelper.getInstance().getPwmRFrequency();
            this.pwmRFrequencyEdit.setText(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(pwmRFrequency)}));
            this.pwmRFrequencyEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if ((i & 255) != 6) {
                        return false;
                    }
                    try {
                        OnboardSdkHelper.getInstance().setPwmRFrequency(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRFrequencyEdit.getText().toString()));
                        return false;
                    } catch (NumberFormatException e) {
                        DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                        dJITriggersSettingsLayout.toast("Invalid right PWM frequency (edit): " + e.getLocalizedMessage());
                        Log.d(DJITriggersSettingsLayout.TAG, "Invalid right PWM frequency (edit): ", e);
                        return false;
                    }
                }
            });
            this.pwmRFrequencyEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (!z) {
                        try {
                            OnboardSdkHelper.getInstance().setPwmRFrequency(Integer.parseInt(DJITriggersSettingsLayout.this.pwmRFrequencyEdit.getText().toString()));
                        } catch (NumberFormatException e) {
                            DJITriggersSettingsLayout dJITriggersSettingsLayout = DJITriggersSettingsLayout.this;
                            dJITriggersSettingsLayout.toast("Invalid right PWM frequency (focus): " + e.getLocalizedMessage());
                            Log.d(DJITriggersSettingsLayout.TAG, "Invalid right PWM frequency (focus): ", e);
                        }
                    }
                }
            });
            this.pwmRFrequencyEdit.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJITriggersSettingsLayout.this.showHelp("PWM Frequency (Hz)", "Set the frequency in Hz of the Pulse Width Modulation signal controlled by the right trigger (labeled 2).");
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }
}
