package com.atakmap.android.uastool.prefs;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.controllersetup.ControllerSetupVM;
import com.atakmap.android.uastool.prefs.controllersetup.ControllerSetupView;
import indago.serialization.JsonValueConstants;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

public class ControllerPreferenceFragment extends ni {
    private static final int DEFAULT_RC_MODE = 2;
    public static final String PREF_CONTROLLER_JOYSTICK_SENSITIVITY = "uastool.controller.pref_joystick_sensitivity";
    public static final String PREF_CONTROLLER_MAPPING = "uastool.controller.mapping";
    public static final String PREF_MAVLINK_RCSTICK_MODE = "uastool.controller.pref_rcstick_mode";
    public static AlertDialog rcStickModeDialog;
    private static Context staticPluginContext;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.bluetooth.device.action.ACL_CONNECTED".equals(action)) {
                "android.bluetooth.device.action.ACL_DISCONNECTED".equals(action);
            }
        }
    };
    /* access modifiers changed from: private */
    public Thread calibrationCycleHandler;
    /* access modifiers changed from: private */
    public AlertDialog controllerButtonConfig;
    private AlertDialog controllerJoystickConfig;
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equals(ControllerPreferenceFragment.PREF_CONTROLLER_JOYSTICK_SENSITIVITY)) {
                ControllerPreferenceFragment controllerPreferenceFragment = ControllerPreferenceFragment.this;
                controllerPreferenceFragment.platformJoystickChanged(controllerPreferenceFragment.sharedPrefs.getString(ControllerPreferenceFragment.PREF_CONTROLLER_JOYSTICK_SENSITIVITY, JsonValueConstants.VERSION));
            }
        }
    };
    /* access modifiers changed from: private */
    public SharedPreferences sharedPrefs;

    public ControllerPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.controller_preference);
    }

    public ControllerPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.controller_preference);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        ControllerPreferenceFragment.super.onCreate((Bundle) null);
        this.sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        findPreference(PREF_MAVLINK_RCSTICK_MODE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                ControllerPreferenceFragment.this.showRCStickModes();
                return true;
            }
        });
        String[] strArr = {JsonValueConstants.VERSION, "-0.25", "-0.5", "-0.75"};
        ListPreference listPreference = (ListPreference) findPreference(PREF_CONTROLLER_JOYSTICK_SENSITIVITY);
        listPreference.setEntries(new String[]{"Twitchy (Default)", "Average", "Sluggish", "Lethargic"});
        listPreference.setEntryValues(strArr);
        findPreference(PREF_CONTROLLER_MAPPING).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                ControllerPreferenceFragment.this.createControllerDialog();
                return true;
            }
        });
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    public enum CONT_RCSTICK_MODE {
        MODE01(1, "Mode 1", C1877R.drawable.dji_rc_mode01),
        MODE02(2, "Mode 2", C1877R.drawable.dji_rc_mode02),
        MODE03(3, "Mode 3", C1877R.drawable.dji_rc_mode03);
        
        private final int modeDrawableId;
        public final String modeName;
        private final int modeType;

        private CONT_RCSTICK_MODE(int i, String str, int i2) {
            this.modeType = i;
            this.modeName = str;
            this.modeDrawableId = i2;
        }

        public int getModeType() {
            return this.modeType;
        }

        public String getModeName() {
            return this.modeName;
        }

        public int getModeDrawableId() {
            return this.modeDrawableId;
        }

        public static CONT_RCSTICK_MODE getDefaultMode() {
            return MODE02;
        }

        public String toString() {
            return this.modeName;
        }

        public static CONT_RCSTICK_MODE fromString(String str) {
            if (str == null) {
                return null;
            }
            for (CONT_RCSTICK_MODE cont_rcstick_mode : values()) {
                if (cont_rcstick_mode.modeName.equalsIgnoreCase(str)) {
                    return cont_rcstick_mode;
                }
            }
            return null;
        }

        public static CONT_RCSTICK_MODE fromType(int i) {
            if (i < 0) {
                return null;
            }
            for (CONT_RCSTICK_MODE cont_rcstick_mode : values()) {
                if (cont_rcstick_mode.modeType == i) {
                    return cont_rcstick_mode;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void platformJoystickChanged(String str) {
        ((ListPreference) findPreference(PREF_CONTROLLER_JOYSTICK_SENSITIVITY)).setValue(str);
    }

    /* access modifiers changed from: private */
    public void createControllerDialog() {
        final ControllerPreference controllerPreference = (ControllerPreference) LayoutInflater.from(this.g).inflate(C1877R.layout.controller_preference_layout, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(controllerPreference);
        builder.setPositiveButton(this.g.getString(C1877R.string.save_btn), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setNeutralButton(this.g.getString(C1877R.string.reset_to_default), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setNegativeButton(this.g.getString(C1877R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog create = builder.create();
        this.controllerButtonConfig = create;
        create.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return controllerPreference.getJoystickPreferenceListener().onKey(controllerPreference, i, keyEvent);
            }
        });
        this.controllerButtonConfig.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                Button button = ControllerPreferenceFragment.this.controllerButtonConfig.getButton(-1);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        controllerPreference.saveKeyBinds();
                        ControllerPreferenceFragment.this.controllerButtonConfig.dismiss();
                    }
                });
                button.setOnGenericMotionListener(controllerPreference.getJoystickPreferenceListener());
                ControllerPreferenceFragment.this.controllerButtonConfig.findViewById(C1877R.C1878id.controller_setup_btn).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (ControllerSetupVM.getInstance() != null) {
                            ControllerSetupVM.getInstance().reset();
                        }
                        ControllerPreferenceFragment.this.setupControllerJoystickCalibrator(ControllerPreferenceFragment.this.g).show();
                    }
                });
                Button button2 = ControllerPreferenceFragment.this.controllerButtonConfig.getButton(-3);
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        controllerPreference.resetKeyBindingTable();
                    }
                });
                button2.setOnGenericMotionListener(controllerPreference.getJoystickPreferenceListener());
                Button button3 = ControllerPreferenceFragment.this.controllerButtonConfig.getButton(-2);
                button3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ControllerPreferenceFragment.this.controllerButtonConfig.dismiss();
                    }
                });
                button3.setOnGenericMotionListener(controllerPreference.getJoystickPreferenceListener());
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.controllerButtonConfig.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.controllerButtonConfig.show();
        this.controllerButtonConfig.getWindow().setAttributes(layoutParams);
    }

    /* access modifiers changed from: private */
    public AlertDialog setupControllerJoystickCalibrator(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(LayoutInflater.from(context).inflate(C1877R.layout.controller_setup, (ViewGroup) null));
        builder.setPositiveButton(context.getString(C1877R.string.controller_setup_start), (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(context.getString(C1877R.string.controller_setup_cancel), (DialogInterface.OnClickListener) null);
        builder.setNeutralButton("Next/Skip", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        this.controllerJoystickConfig = create;
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            private final String TAG = "Joystick Calibrator";

            public void onShow(final DialogInterface dialogInterface) {
                AlertDialog alertDialog = (AlertDialog) dialogInterface;
                final ControllerSetupView controllerSetupView = (ControllerSetupView) alertDialog.findViewById(C1877R.C1878id.controller_drawable);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                Thread unused = ControllerPreferenceFragment.this.calibrationCycleHandler = new Thread() {
                    public void run() {
                        while (!atomicBoolean.get()) {
                            controllerSetupView.postInvalidate();
                            if (ControllerSetupVM.getInstance().finishedCalibrating()) {
                                break;
                            }
                            float f = 0.0f;
                            MotionEvent lastEvent = ControllerSetupVM.getInstance().getLastEvent();
                            if (lastEvent != null) {
                                f = Math.abs(lastEvent.getAxisValue(ControllerSetupVM.getInstance().getAxis(lastEvent)));
                            }
                            if (f > 0.6f) {
                                controllerSetupView.setupGuidanceMessage = "Return to center/zero";
                                Log.d("Joystick Calibrator", "Waiting for stick to return to center/zero");
                                try {
                                    sleep(250);
                                } catch (InterruptedException unused) {
                                    Log.d("Joystick Calibrator", "calibrationCycleHandler Thread Interrupted");
                                    if (atomicBoolean.get()) {
                                        break;
                                    }
                                    ControllerSetupVM.getInstance().nextStep();
                                    controllerSetupView.postInvalidate();
                                }
                            } else {
                                while (true) {
                                    if (atomicBoolean.get()) {
                                        break;
                                    } else if (ControllerSetupVM.getInstance().finishedCalibrating()) {
                                        atomicBoolean.set(true);
                                        break;
                                    } else {
                                        try {
                                            if (ControllerSetupVM.getInstance().getCalibrationStep() == 0) {
                                                controllerSetupView.setupGuidanceMessage = "Move all controls to center/zero. Press Next/Skip";
                                            } else {
                                                controllerSetupView.setupGuidanceMessage = "Move the controls to the blue marker";
                                            }
                                            Log.d("Joystick Calibrator", "Waiting to test");
                                            sleep(1500);
                                            MotionEvent lastEvent2 = ControllerSetupVM.getInstance().getLastEvent();
                                            if (lastEvent2 != null && Math.abs(lastEvent2.getAxisValue(ControllerSetupVM.getInstance().getAxis(lastEvent2))) > 0.6f) {
                                                break;
                                            }
                                        } catch (InterruptedException unused2) {
                                            Log.d("Joystick Calibrator", "calibrationCycleHandler Thread Interrupted");
                                            if (atomicBoolean.get()) {
                                                break;
                                            }
                                            ControllerSetupVM.getInstance().nextStep();
                                            controllerSetupView.postInvalidate();
                                        }
                                    }
                                }
                                if (atomicBoolean.get()) {
                                    break;
                                }
                                ControllerSetupVM.getInstance().processControllerMotion();
                                ControllerSetupVM.getInstance().nextStep();
                            }
                        }
                        if (ControllerSetupVM.getInstance().finishedCalibrating()) {
                            if (ControllerSetupVM.getInstance().writeConfiguration()) {
                                UASToolDropDownReceiver.toast("Controller Configuration Updated", 0);
                            } else {
                                Log.d("Joystick Calibrator", "Unable to write controller configuration. Default may be used if no configuration exists.");
                            }
                        }
                        Log.d("Joystick Config Thread", "Exiting normally!");
                        ControllerPreferenceFragment.this.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                if (((AlertDialog) dialogInterface).isShowing()) {
                                    dialogInterface.dismiss();
                                }
                            }
                        });
                    }
                };
                alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ((AlertDialog) dialogInterface).getButton(-3).setEnabled(true);
                        ControllerSetupVM.getInstance().reset();
                        ControllerSetupVM.getInstance().resetControllerData();
                        ControllerSetupVM.getInstance().startCalibration();
                        view.setEnabled(false);
                        ControllerPreferenceFragment.this.calibrationCycleHandler.start();
                    }
                });
                ControllerPreferenceFragment.this.calibrationCycleHandler.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread thread, Throwable th) {
                        ControllerSetupVM.getInstance().reset();
                        ControllerSetupVM.getInstance().resetControllerData();
                        try {
                            atomicBoolean.set(true);
                            thread.interrupt();
                        } catch (SecurityException unused) {
                            Log.d("Joystick Calibrator", "Unable to interrupt controller calibration thread");
                        }
                    }
                });
                alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        ((AlertDialog) dialogInterface).getButton(-2).callOnClick();
                    }
                });
                alertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (ControllerPreferenceFragment.this.calibrationCycleHandler.isAlive()) {
                            try {
                                atomicBoolean.set(true);
                                ControllerPreferenceFragment.this.calibrationCycleHandler.interrupt();
                            } catch (SecurityException unused) {
                                Log.d("Joystick Calibrator", "Unable to interrupt controller calibration thread");
                            }
                        }
                        ControllerSetupVM.getInstance().reset();
                        ControllerSetupVM.getInstance().resetControllerData();
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.getButton(-3).setEnabled(false);
                alertDialog.getButton(-3).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            atomicBoolean.set(false);
                            ControllerPreferenceFragment.this.calibrationCycleHandler.interrupt();
                        } catch (SecurityException unused) {
                            Log.d("Joystick Calibrator", "Unable to interrupt controller calibration thread");
                        }
                    }
                });
                controllerSetupView.postInvalidate();
            }
        });
        this.controllerJoystickConfig.setCanceledOnTouchOutside(true);
        this.controllerJoystickConfig.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                ((AlertDialog) dialogInterface).getButton(-2).callOnClick();
            }
        });
        return this.controllerJoystickConfig;
    }

    public void showRCStickModes() {
        hideRCStickModes();
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());
        builder.setTitle("RC Joystick Mode");
        ListView listView = new ListView(this.g);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        listView.setAdapter(new ControllerStickModeAdapter(this.g, CONT_RCSTICK_MODE.fromString(this.sharedPrefs.getString(PREF_MAVLINK_RCSTICK_MODE, CONT_RCSTICK_MODE.getDefaultMode().modeName))));
        builder.setView(listView);
        AlertDialog create = builder.create();
        rcStickModeDialog = create;
        create.setCanceledOnTouchOutside(true);
        rcStickModeDialog.show();
    }

    public static void hideRCStickModes() {
        AlertDialog alertDialog = rcStickModeDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void onDestroy() {
        AlertDialog alertDialog = this.controllerJoystickConfig;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.controllerButtonConfig;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        hideRCStickModes();
        ControllerPreferenceFragment.super.onDestroy();
    }
}
