package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DJIAccelCalibScreen extends UASToolScreen {
    private static final String STATUS_CALIBRATING = "calibrating";
    private static final String STATUS_FAILED = "failed";
    private static final String STATUS_NONE = "none";
    private static final String STATUS_NOUAS = "nouas";
    /* access modifiers changed from: private */
    public static final AtomicInteger STATUS_PERIOD_MILLIS = new AtomicInteger(500);
    private static final String STATUS_SUCCESSFUL = "successful";
    private static final String STATUS_UNKNOWN = "unknown";
    /* access modifiers changed from: private */
    public static final String TAG = DJIAccelCalibScreen.class.getSimpleName();
    private Button button;
    private String calibratingString;
    /* access modifiers changed from: private */
    public String currentStatus;
    private ImageView imageView;
    private String noUASString;
    private String startString;
    /* access modifiers changed from: private */
    public Thread statusThread = null;
    private String unknownString;
    private String updateInProgressString;
    private String updateStartString;
    private TextView updateText;
    private String waitString;

    public DJIAccelCalibScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.currentStatus = STATUS_NONE;
        this.updateText = (TextView) findViewById(C1877R.C1878id.djiaccel_update_text);
        this.updateStartString = this.pluginContext.getString(C1877R.string.dji_accel_update);
        this.updateInProgressString = this.pluginContext.getString(C1877R.string.dji_accel_inprogress);
        this.updateText.setText(this.updateStartString);
        ImageView imageView2 = (ImageView) findViewById(C1877R.C1878id.djiaccel_image);
        this.imageView = imageView2;
        imageView2.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.waitString = this.pluginContext.getText(C1877R.string.dji_accel_wait).toString();
        this.startString = this.pluginContext.getText(C1877R.string.dji_accel_start).toString();
        this.noUASString = this.pluginContext.getText(C1877R.string.dji_accel_nouas).toString();
        this.calibratingString = this.pluginContext.getText(C1877R.string.dji_accel_calibrating).toString();
        this.unknownString = this.pluginContext.getText(C1877R.string.dji_accel_unknown).toString();
        Button button2 = (Button) findViewById(C1877R.C1878id.djiaccel_button);
        this.button = button2;
        button2.setText(this.waitString);
        this.button.setEnabled(false);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIAccelCalibScreen.this.onButtonPress(((Button) view).getText().toString());
            }
        });
        onCalibCancel(false);
        startUASStatusCheck();
    }

    /* access modifiers changed from: private */
    public void onButtonPress(String str) {
        if (str.equalsIgnoreCase(this.startString)) {
            onCalibStart();
        } else {
            UASToolDropDownReceiver.toast("Error starting accelerometer calibration", 0);
        }
    }

    private void startUASStatusCheck() {
        if (this.statusThread == null) {
            C12062 r0 = new Thread() {
                public void run() {
                    AtomicReference atomicReference = new AtomicReference("");
                    while (!DJIAccelCalibScreen.this.statusThread.isInterrupted()) {
                        try {
                            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                            if (serviceConnection != null) {
                                atomicReference.set(serviceConnection.getAccelCalibStatus());
                                DJIAccelCalibScreen.this.handleCalibReply((String) atomicReference.get());
                            } else {
                                Log.e(DJIAccelCalibScreen.TAG, "Status Thread no connection to ATAKGo");
                            }
                        } catch (Exception e) {
                            Log.e(DJIAccelCalibScreen.TAG, "Status Thread Crash: ", e);
                        }
                        try {
                            Thread.sleep((long) DJIAccelCalibScreen.STATUS_PERIOD_MILLIS.get());
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            };
            this.statusThread = r0;
            r0.start();
            return;
        }
        Log.d(TAG, "Status thread NOT null");
    }

    /* access modifiers changed from: private */
    public void handleCalibReply(String str) {
        this.currentStatus = str;
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                String access$500 = DJIAccelCalibScreen.this.currentStatus;
                access$500.hashCode();
                char c = 65535;
                switch (access$500.hashCode()) {
                    case -1281977283:
                        if (access$500.equals(DJIAccelCalibScreen.STATUS_FAILED)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -733631846:
                        if (access$500.equals(DJIAccelCalibScreen.STATUS_SUCCESSFUL)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -284840886:
                        if (access$500.equals("unknown")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3387192:
                        if (access$500.equals(DJIAccelCalibScreen.STATUS_NONE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 105009670:
                        if (access$500.equals(DJIAccelCalibScreen.STATUS_NOUAS)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1421318596:
                        if (access$500.equals(DJIAccelCalibScreen.STATUS_CALIBRATING)) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        DJIAccelCalibScreen.this.setCalibFailed();
                        return;
                    case 1:
                        DJIAccelCalibScreen.this.setCalibSuccessful();
                        return;
                    case 2:
                        DJIAccelCalibScreen.this.setCalibUnknown();
                        return;
                    case 3:
                        DJIAccelCalibScreen.this.setCalibReady();
                        return;
                    case 4:
                        DJIAccelCalibScreen.this.setCalibNoUAS();
                        return;
                    case 5:
                        DJIAccelCalibScreen.this.setCalibCalibrating();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setCalibReady() {
        this.imageView.setAlpha(1.0f);
        this.updateText.setText(this.updateStartString);
        this.button.setText(this.startString);
        this.button.setEnabled(true);
    }

    private void onCalibStart() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.startAccelCalib();
        } else {
            UASToolDropDownReceiver.toast("Unable to start accelerometer calibration - no connection to ATAKGo");
        }
    }

    /* access modifiers changed from: private */
    public void setCalibCalibrating() {
        this.updateText.setText(this.updateInProgressString);
        this.button.setText(this.calibratingString);
        this.button.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void setCalibSuccessful() {
        UASToolDropDownReceiver.toast("Accelerometer calibrated successfully!", 1);
    }

    /* access modifiers changed from: private */
    public void setCalibFailed() {
        UASToolDropDownReceiver.toast("Accelerometer calibration FAILED!", 1);
    }

    /* access modifiers changed from: private */
    public void setCalibNoUAS() {
        UASToolDropDownReceiver.toast("Accelerometer calibration FAILED - No UAS.", 1);
        this.imageView.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.button.setText(this.noUASString);
        this.button.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void setCalibUnknown() {
        UASToolDropDownReceiver.toast("Accelerometer calibration FAILED - Unknown.", 1);
        this.imageView.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.button.setText(this.unknownString);
        this.button.setEnabled(false);
    }

    private void onCalibCancel(boolean z) {
        interruptCalib();
        if (z) {
            UASToolDropDownReceiver.toast("Accelerometer calibration cancelled.", 1);
        }
    }

    private void interruptCalib() {
        Thread thread = this.statusThread;
        if (thread != null) {
            thread.interrupt();
            this.statusThread = null;
        }
    }

    public void destroy() {
        onCalibCancel(false);
        super.destroy();
    }
}
