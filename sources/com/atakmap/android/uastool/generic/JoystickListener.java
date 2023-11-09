package com.atakmap.android.uastool.generic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.MAVLink.enums.ESTIMATOR_STATUS_FLAGS;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.mavlink.MAVLinkUASItem;
import com.atakmap.android.uastool.prefs.ControllerPreference;
import com.atakmap.android.uastool.prefs.ControllerPreferenceFragment;
import com.atakmap.android.uastool.prefs.DJIPreferenceFragment;
import com.atakmap.android.uastool.prefs.controllersetup.ControllerConfig;
import com.atakmap.android.uastool.prefs.controllersetup.ControllerConfigStore;
import com.atakmap.coremap.log.Log;
import indago.serialization.JsonValueConstants;
import java.util.ArrayList;

public class JoystickListener implements View.OnGenericMotionListener, View.OnKeyListener {
    /* access modifiers changed from: private */
    public static final String TAG = "JoystickListener";
    private static final String USE_DIRECT_MODE_KEY = "uastool.joystick_direct_mode";
    int KEYCODE_ARM = 99;
    int KEYCODE_DISARM = 100;
    private String deviceName;
    ArrayList<KeyBind> keyBinds;
    long lastInputTime;
    SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equals(ControllerPreference.PREFERENCE_KEY)) {
                JoystickListener.this.keyBinds = ControllerPreference.loadKeyBindsFromJSON();
            } else if (str.equals(ControllerPreferenceFragment.PREF_MAVLINK_RCSTICK_MODE)) {
                JoystickListener joystickListener = JoystickListener.this;
                DJIPreferenceFragment.DJI_RCSTICK_MODE unused = joystickListener.rcStickMode = joystickListener.getRcStickMode(sharedPreferences);
            }
        }
    };

    /* renamed from: lt */
    float f8390lt;
    private final SharedPreferences prefs;
    /* access modifiers changed from: private */
    public DJIPreferenceFragment.DJI_RCSTICK_MODE rcStickMode;
    private final Thread repeatProducer;

    /* renamed from: rt */
    float f8391rt;
    /* access modifiers changed from: private */
    public final UASItem selectedUASItem;
    private boolean useDirectMode = true;

    private float clamp(float f) {
        if (f < -1.0f) {
            return -1.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public JoystickListener(UASItem uASItem) {
        this.selectedUASItem = uASItem;
        MapView.getMapView().a(this);
        MapView.getMapView().a(this);
        setDirectMode(UASToolDropDownReceiver.getSharedPrefs().getBoolean(USE_DIRECT_MODE_KEY, this.useDirectMode));
        this.keyBinds = new ArrayList<>();
        this.keyBinds = ControllerPreference.loadKeyBindsFromJSON();
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        this.prefs = sharedPrefs;
        sharedPrefs.registerOnSharedPreferenceChangeListener(this.listener);
        Thread thread = new Thread(new RepeatProducer(this));
        this.repeatProducer = thread;
        thread.start();
        this.lastInputTime = 0;
        this.rcStickMode = getRcStickMode(UASToolDropDownReceiver.getSharedPrefs());
        this.deviceName = "DEVICE_NOT_CONFIGURED";
    }

    public void dispose() {
        MapView.getMapView().b(this);
        MapView.getMapView().b(this);
        this.prefs.unregisterOnSharedPreferenceChangeListener(this.listener);
        try {
            this.repeatProducer.interrupt();
        } catch (Exception unused) {
            Log.d(TAG, "Could not interrupt RepeatProducer");
        }
    }

    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        int i = 0;
        if ((motionEvent.getSource() & 16777232) != 16777232 || motionEvent.getAction() != 2) {
            return false;
        }
        int historySize = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            processJoystickInput(motionEvent, i2);
        }
        processJoystickInput(motionEvent, -1);
        if (motionEvent.getAxisValue(16) == -1.0f) {
            for (int i3 = 0; i3 < this.keyBinds.size(); i3++) {
                if (19 == this.keyBinds.get(i3).getKey()) {
                    doFunction(this.keyBinds.get(i3).getFunction());
                }
            }
        }
        if (motionEvent.getAxisValue(16) == 1.0f) {
            for (int i4 = 0; i4 < this.keyBinds.size(); i4++) {
                if (20 == this.keyBinds.get(i4).getKey()) {
                    doFunction(this.keyBinds.get(i4).getFunction());
                }
            }
        }
        if (motionEvent.getAxisValue(15) == 1.0f) {
            for (int i5 = 0; i5 < this.keyBinds.size(); i5++) {
                if (22 == this.keyBinds.get(i5).getKey()) {
                    doFunction(this.keyBinds.get(i5).getFunction());
                }
            }
        }
        if (motionEvent.getAxisValue(15) == -1.0f) {
            for (int i6 = 0; i6 < this.keyBinds.size(); i6++) {
                if (21 == this.keyBinds.get(i6).getKey()) {
                    doFunction(this.keyBinds.get(i6).getFunction());
                }
            }
        }
        if (((double) motionEvent.getAxisValue(22)) >= 0.95d) {
            while (i < this.keyBinds.size()) {
                if (105 == this.keyBinds.get(i).getKey()) {
                    doFunction(this.keyBinds.get(i).getFunction());
                }
                i++;
            }
            return true;
        } else if (((double) motionEvent.getAxisValue(23)) < 0.95d) {
            return true;
        } else {
            while (i < this.keyBinds.size()) {
                if (104 == this.keyBinds.get(i).getKey()) {
                    doFunction(this.keyBinds.get(i).getFunction());
                }
                i++;
            }
            return true;
        }
    }

    private void setDirectMode(boolean z) {
        if (z) {
            this.KEYCODE_ARM = 99;
            this.KEYCODE_DISARM = 100;
            if (!this.useDirectMode) {
                this.useDirectMode = true;
                UASToolDropDownReceiver.getSharedPrefs().edit().putBoolean(USE_DIRECT_MODE_KEY, this.useDirectMode).apply();
                return;
            }
            return;
        }
        this.KEYCODE_ARM = 96;
        this.KEYCODE_DISARM = 97;
        if (this.useDirectMode) {
            this.useDirectMode = false;
            UASToolDropDownReceiver.getSharedPrefs().edit().putBoolean(USE_DIRECT_MODE_KEY, this.useDirectMode).apply();
        }
    }

    private void processJoystickInput(MotionEvent motionEvent, int i) {
        if (this.selectedUASItem != null) {
            this.lastInputTime = System.currentTimeMillis();
            InputDevice device = motionEvent.getDevice();
            String name = device.getName();
            if (name.isEmpty()) {
                name = "PARROT_ANAFI_MPP3";
            }
            ControllerConfig controllerConfig = ControllerConfigStore.getControllerConfig(name);
            if (!name.equals(this.deviceName) && (controllerConfig == null || controllerConfig == ControllerConfig.defaultConfig)) {
                UASToolDropDownReceiver.toast("Device does not have a valid user defined calibration; the default will be used.", 1);
                this.deviceName = name;
            }
            if (controllerConfig == null) {
                controllerConfig = ControllerConfig.defaultConfig;
            }
            setDirectMode("Logitech Logitech Dual Action".equals(device.getName()));
            float clamp = clamp(getCenteredAxis(motionEvent, device, controllerConfig.leftXAxis, i) / controllerConfig.maxLeftXValue());
            float clamp2 = clamp(getCenteredAxis(motionEvent, device, controllerConfig.rightXAxis, i) / controllerConfig.maxRightXValue());
            float clamp3 = clamp(getCenteredAxis(motionEvent, device, controllerConfig.leftYAxis, i) / controllerConfig.maxLeftYValue());
            float clamp4 = clamp(getCenteredAxis(motionEvent, device, controllerConfig.rightYAxis, i) / controllerConfig.maxRightYValue());
            this.f8391rt = getCenteredAxis(motionEvent, device, controllerConfig.rightTriggerAxis, i);
            this.f8390lt = getCenteredAxis(motionEvent, device, controllerConfig.leftTriggerAxis, i);
            if (device.getName() == null || device.getName().isEmpty()) {
                float f = this.f8390lt;
                if (((double) f) > 0.2d) {
                    this.selectedUASItem.pitchGimbalUp();
                } else if (((double) f) < -0.2d) {
                    this.selectedUASItem.pitchGimbalDown();
                }
                UASItem uASItem = this.selectedUASItem;
                if (uASItem instanceof MAVLinkUASItem) {
                    MAVLinkUASItem mAVLinkUASItem = (MAVLinkUASItem) uASItem;
                    float f2 = this.f8391rt;
                    if (((double) f2) > 0.2d) {
                        mAVLinkUASItem.setZoomStep(-1);
                    } else if (((double) f2) < -0.2d) {
                        mAVLinkUASItem.setZoomStep(1);
                    } else {
                        mAVLinkUASItem.setZoomStep(0);
                    }
                }
            } else if ("mlx_joystick".equals(device.getName())) {
                float centeredAxis = getCenteredAxis(motionEvent, device, 21, i);
                this.f8390lt = centeredAxis;
                if (((double) centeredAxis) > 0.2d) {
                    this.selectedUASItem.pitchGimbalUp();
                } else if (((double) centeredAxis) < -0.2d) {
                    this.selectedUASItem.pitchGimbalDown();
                }
            } else if ("HID 3199:f500".equals(device.getName())) {
                UASItem uASItem2 = this.selectedUASItem;
                if (uASItem2 instanceof MAVLinkUASItem) {
                    MAVLinkUASItem mAVLinkUASItem2 = (MAVLinkUASItem) uASItem2;
                    if (((double) Math.abs(this.f8391rt)) < 0.1d) {
                        this.f8391rt = 0.0f;
                    }
                    mAVLinkUASItem2.continuousZoom(this.f8391rt);
                    if (((double) Math.abs(this.f8390lt)) < 0.1d) {
                        this.f8390lt = 0.0f;
                    }
                    mAVLinkUASItem2.joystickGimbalPosition(this.f8390lt, 0.0f);
                }
            }
            this.selectedUASItem.setManualControl(applyExponentialTransform(applyModeTransform(clamp, clamp3, clamp2, clamp4)));
        }
    }

    private static float getCenteredAxis(MotionEvent motionEvent, InputDevice inputDevice, int i, int i2) {
        float f;
        InputDevice.MotionRange motionRange = inputDevice.getMotionRange(i, motionEvent.getSource());
        if (motionRange == null) {
            return 0.0f;
        }
        float flat = motionRange.getFlat();
        if (i2 < 0) {
            f = motionEvent.getAxisValue(i);
        } else {
            f = motionEvent.getHistoricalAxisValue(i, i2);
        }
        if (Math.abs(f) > flat) {
            return f;
        }
        return 0.0f;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if ((keyEvent.getSource() & ESTIMATOR_STATUS_FLAGS.ESTIMATOR_STATUS_FLAGS_ENUM_END) != 1025) {
            Log.d(TAG, "Non GAMEPAD input ignoring");
            return false;
        }
        for (int i2 = 0; i2 < this.keyBinds.size(); i2++) {
            if (i == this.keyBinds.get(i2).getKey()) {
                if (keyEvent.getAction() == 0) {
                    doFunction(this.keyBinds.get(i2).getFunction());
                }
                return true;
            }
        }
        return true;
    }

    private void doFunction(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1929137337:
                if (str.equals("POSCTL")) {
                    c = 0;
                    break;
                }
                break;
            case -1402884515:
                if (str.equals("TOGGLE ROUTE")) {
                    c = 1;
                    break;
                }
                break;
            case -1399385969:
                if (str.equals("TOGGLE VIDEO")) {
                    c = 2;
                    break;
                }
                break;
            case -826809496:
                if (str.equals("TAKEOFF")) {
                    c = 3;
                    break;
                }
                break;
            case -238707135:
                if (str.equals("ARM/DISARM")) {
                    c = 4;
                    break;
                }
                break;
            case 81482:
                if (str.equals("RTL")) {
                    c = 5;
                    break;
                }
                break;
            case 2329067:
                if (str.equals("LAND")) {
                    c = 6;
                    break;
                }
                break;
            case 156972450:
                if (str.equals("PITCH DOWN")) {
                    c = 7;
                    break;
                }
                break;
            case 523068315:
                if (str.equals("PITCH UP")) {
                    c = 8;
                    break;
                }
                break;
            case 607940754:
                if (str.equals("ZOOM IN")) {
                    c = 9;
                    break;
                }
                break;
            case 835311953:
                if (str.equals("EMERGENCY STOP")) {
                    c = 10;
                    break;
                }
                break;
            case 1555627574:
                if (str.equals("MAPSHOT")) {
                    c = 11;
                    break;
                }
                break;
            case 1588530677:
                if (str.equals("STABILIZED")) {
                    c = 12;
                    break;
                }
                break;
            case 1666300257:
                if (str.equals("ZOOM OUT")) {
                    c = 13;
                    break;
                }
                break;
            case 1933651922:
                if (str.equals("ALTCTL")) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                UASItem uASItem = this.selectedUASItem;
                if (uASItem instanceof MAVLinkUASItem) {
                    ((MAVLinkUASItem) uASItem).setMode("POSCTL");
                    return;
                }
                return;
            case 1:
                if (this.selectedUASItem.isRouteShowing()) {
                    this.selectedUASItem.hideRoute();
                    return;
                } else {
                    this.selectedUASItem.showRoute();
                    return;
                }
            case 2:
                this.selectedUASItem.toggleVideo();
                return;
            case 3:
                if (this.selectedUASItem.isFlying()) {
                    Toast.makeText(MapView.getMapView().getContext(), "UAS is already in the air", 0).show();
                    return;
                } else {
                    this.selectedUASItem.quickTakeoff(10);
                    return;
                }
            case 4:
                if (this.selectedUASItem.isFlying()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                    builder.setTitle(this.selectedUASItem.isArmed() ? "Confirm Disarming" : "Confirm Arming");
                    builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            JoystickListener.this.selectedUASItem.sendArm(!JoystickListener.this.selectedUASItem.isArmed());
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
                    return;
                }
                UASItem uASItem2 = this.selectedUASItem;
                uASItem2.sendArm(!uASItem2.isArmed());
                return;
            case 5:
                if (!this.selectedUASItem.isFlying()) {
                    Toast.makeText(MapView.getMapView().getContext(), "UAS is not in the air", 0).show();
                    return;
                } else {
                    this.selectedUASItem.quickRTH();
                    return;
                }
            case 6:
                if (!this.selectedUASItem.isFlying()) {
                    Toast.makeText(MapView.getMapView().getContext(), "UAS is not in the air", 0).show();
                    return;
                } else {
                    this.selectedUASItem.quickLanding();
                    return;
                }
            case 7:
                this.selectedUASItem.pitchGimbalDown();
                return;
            case 8:
                this.selectedUASItem.pitchGimbalUp();
                return;
            case 9:
                this.selectedUASItem.zoomIn();
                return;
            case 10:
                this.selectedUASItem.quickStop();
                return;
            case 11:
                if (UASToolDropDownReceiver.getInstance().isVisible()) {
                    ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                        public void run() {
                            UASToolDropDownReceiver.mapshotSelected(JoystickListener.this.selectedUASItem);
                        }
                    });
                    return;
                }
                return;
            case 12:
                UASItem uASItem3 = this.selectedUASItem;
                if (uASItem3 instanceof MAVLinkUASItem) {
                    ((MAVLinkUASItem) uASItem3).setMode("STABILIZED");
                    return;
                }
                return;
            case 13:
                this.selectedUASItem.zoomOut();
                return;
            case 14:
                UASItem uASItem4 = this.selectedUASItem;
                if (uASItem4 instanceof MAVLinkUASItem) {
                    ((MAVLinkUASItem) uASItem4).setMode("ALTCTL");
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: com.atakmap.android.uastool.generic.JoystickListener$5 */
    /* synthetic */ class C15075 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$prefs$DJIPreferenceFragment$DJI_RCSTICK_MODE */
        static final /* synthetic */ int[] f8392xe49c9b8b;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.prefs.DJIPreferenceFragment$DJI_RCSTICK_MODE[] r0 = com.atakmap.android.uastool.prefs.DJIPreferenceFragment.DJI_RCSTICK_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8392xe49c9b8b = r0
                com.atakmap.android.uastool.prefs.DJIPreferenceFragment$DJI_RCSTICK_MODE r1 = com.atakmap.android.uastool.prefs.DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE01     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8392xe49c9b8b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.prefs.DJIPreferenceFragment$DJI_RCSTICK_MODE r1 = com.atakmap.android.uastool.prefs.DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE02     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8392xe49c9b8b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.prefs.DJIPreferenceFragment$DJI_RCSTICK_MODE r1 = com.atakmap.android.uastool.prefs.DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE03     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.generic.JoystickListener.C15075.<clinit>():void");
        }
    }

    private float[] applyModeTransform(float f, float f2, float f3, float f4) {
        int i = C15075.f8392xe49c9b8b[this.rcStickMode.ordinal()];
        if (i == 1) {
            return new float[]{f3, f2, f, f4};
        } else if (i == 2) {
            return new float[]{f3, f4, f, f2};
        } else if (i != 3) {
            return new float[]{f3, f4, f, f2};
        } else {
            return new float[]{f, f2, f3, f4};
        }
    }

    private float[] applyExponentialTransform(float[] fArr) {
        float f;
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(ControllerPreferenceFragment.PREF_CONTROLLER_JOYSTICK_SENSITIVITY, JsonValueConstants.VERSION);
        float f2 = 0.0f;
        if (string != null) {
            try {
                f = Float.parseFloat(string);
            } catch (NumberFormatException e) {
                String str = TAG;
                Log.e(str, "Error parsing float from: " + string, e);
                f = 0.0f;
            }
            if (!Float.isNaN(f)) {
                f2 = f;
            }
        }
        if (f2 < -0.01f) {
            double d = (double) (-f2);
            float f3 = f2 + 1.0f;
            fArr[0] = (float) ((Math.pow((double) fArr[0], 3.0d) * d) + ((double) (fArr[0] * f3)));
            fArr[1] = (float) ((Math.pow((double) fArr[1], 3.0d) * d) + ((double) (fArr[1] * f3)));
            fArr[2] = (float) ((d * Math.pow((double) fArr[2], 3.0d)) + ((double) (f3 * fArr[2])));
        }
        return fArr;
    }

    /* access modifiers changed from: private */
    public DJIPreferenceFragment.DJI_RCSTICK_MODE getRcStickMode(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(ControllerPreferenceFragment.PREF_MAVLINK_RCSTICK_MODE, DJIPreferenceFragment.DJI_RCSTICK_MODE.getDefaultMode().getModeName());
        if (string.equals(DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE01.getModeName())) {
            return DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE01;
        }
        if (string.equals(DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE02.getModeName())) {
            return DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE02;
        }
        if (string.equals(DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE03.getModeName())) {
            return DJIPreferenceFragment.DJI_RCSTICK_MODE.MODE03;
        }
        return DJIPreferenceFragment.DJI_RCSTICK_MODE.getDefaultMode();
    }

    protected static class RepeatProducer implements Runnable {
        private static final float DECAY = 0.94f;
        private final JoystickListener joystickListener;

        public RepeatProducer(JoystickListener joystickListener2) {
            this.joystickListener = joystickListener2;
        }

        public void run() {
            Log.d(JoystickListener.TAG, "Starting the JoystickRepeat producer");
            while (!Thread.interrupted()) {
                try {
                    try {
                        if (((double) this.joystickListener.f8390lt) > 0.2d) {
                            this.joystickListener.selectedUASItem.pitchGimbalUp();
                        } else if (((double) this.joystickListener.f8390lt) < -0.2d) {
                            this.joystickListener.selectedUASItem.pitchGimbalDown();
                        }
                        if (System.currentTimeMillis() - this.joystickListener.lastInputTime > 1000) {
                            this.joystickListener.f8390lt *= DECAY;
                        }
                    } catch (Exception e) {
                        Log.d(JoystickListener.TAG, "Joystick could not send repeat", e);
                    }
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                    Log.d(JoystickListener.TAG, "Repeat thread interrupted");
                    return;
                }
            }
        }
    }
}
