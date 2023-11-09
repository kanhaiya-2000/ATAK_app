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

public class DJICompassCalibScreen extends UASToolScreen {
    private static final String STATUS_FAILED = "failed";
    private static final String STATUS_HORIZ = "horizontal";
    private static final String STATUS_NONE = "none";
    private static final String STATUS_NOUAS = "nouas";
    /* access modifiers changed from: private */
    public static final AtomicInteger STATUS_PERIOD_MILLIS = new AtomicInteger(500);
    private static final String STATUS_SUCCESSFUL = "successful";
    private static final String STATUS_UNKNOWN = "unknown";
    private static final String STATUS_VERT = "vertical";
    /* access modifiers changed from: private */
    public static final String TAG = DJICompassCalibScreen.class.getSimpleName();
    private Button button;
    private String cancelString;
    /* access modifiers changed from: private */
    public String currentStatus;
    private String horizString;
    private ImageView imageView;
    private TextView instructText;
    private String noUASString;
    private String startString;
    /* access modifiers changed from: private */
    public Thread statusThread = null;
    private String unknownString;
    private String vertString;
    private String waitString;
    private TextView warnText;

    public DJICompassCalibScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.currentStatus = STATUS_NONE;
        TextView textView = (TextView) findViewById(C1877R.C1878id.djicompass_warn_text);
        this.warnText = textView;
        textView.setText(this.pluginContext.getString(C1877R.string.dji_compass_warn));
        this.instructText = (TextView) findViewById(C1877R.C1878id.djicompass_instruct_text);
        this.horizString = this.pluginContext.getString(C1877R.string.dji_compass_instruct_h);
        this.vertString = this.pluginContext.getString(C1877R.string.dji_compass_instruct_v);
        this.instructText.setText(this.horizString);
        ImageView imageView2 = (ImageView) findViewById(C1877R.C1878id.djicompass_image);
        this.imageView = imageView2;
        imageView2.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.waitString = this.pluginContext.getText(C1877R.string.dji_compass_wait).toString();
        this.startString = this.pluginContext.getText(C1877R.string.dji_compass_start).toString();
        this.cancelString = this.pluginContext.getText(C1877R.string.dji_compass_cancel).toString();
        this.noUASString = this.pluginContext.getText(C1877R.string.dji_compass_nouas).toString();
        this.unknownString = this.pluginContext.getText(C1877R.string.dji_compass_unknown).toString();
        Button button2 = (Button) findViewById(C1877R.C1878id.djicompass_button);
        this.button = button2;
        button2.setText(this.waitString);
        this.button.setEnabled(false);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJICompassCalibScreen.this.onButtonPress(((Button) view).getText().toString());
            }
        });
        onCalibCancel(false);
        startUASStatusCheck();
    }

    /* access modifiers changed from: private */
    public void onButtonPress(String str) {
        if (str.equalsIgnoreCase(this.startString)) {
            onCalibStart();
        } else if (str.equalsIgnoreCase(this.cancelString)) {
            onCalibCancel(true);
        } else {
            UASToolDropDownReceiver.toast("Error starting compass calibration", 0);
        }
    }

    private void startUASStatusCheck() {
        if (this.statusThread == null) {
            C12232 r0 = new Thread() {
                public void run() {
                    AtomicReference atomicReference = new AtomicReference("");
                    while (!DJICompassCalibScreen.this.statusThread.isInterrupted()) {
                        try {
                            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                            if (serviceConnection != null) {
                                atomicReference.set(serviceConnection.getCompassCalibStatus());
                                DJICompassCalibScreen.this.handleCalibReply((String) atomicReference.get());
                            } else {
                                Log.e(DJICompassCalibScreen.TAG, "Status Thread no connection to ATAKGo");
                            }
                        } catch (Exception e) {
                            Log.e(DJICompassCalibScreen.TAG, "Status Thread Crash: ", e);
                        }
                        try {
                            Thread.sleep((long) DJICompassCalibScreen.STATUS_PERIOD_MILLIS.get());
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
                String access$500 = DJICompassCalibScreen.this.currentStatus;
                access$500.hashCode();
                char c = 65535;
                switch (access$500.hashCode()) {
                    case -1984141450:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_VERT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1281977283:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_FAILED)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -733631846:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_SUCCESSFUL)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -284840886:
                        if (access$500.equals("unknown")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3387192:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_NONE)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 105009670:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_NOUAS)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1387629604:
                        if (access$500.equals(DJICompassCalibScreen.STATUS_HORIZ)) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        DJICompassCalibScreen.this.setCalibVert();
                        return;
                    case 1:
                        DJICompassCalibScreen.this.setCalibFailed();
                        return;
                    case 2:
                        DJICompassCalibScreen.this.setCalibSuccess();
                        return;
                    case 3:
                        DJICompassCalibScreen.this.setCalibUnknown();
                        return;
                    case 4:
                        DJICompassCalibScreen.this.setCalibReady();
                        return;
                    case 5:
                        DJICompassCalibScreen.this.setCalibNoUAS();
                        return;
                    case 6:
                        DJICompassCalibScreen.this.setCalibHoriz();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setCalibReady() {
        this.warnText.setVisibility(0);
        this.instructText.setVisibility(8);
        this.imageView.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(1.0f);
        this.button.setText(this.startString);
        this.button.setEnabled(true);
    }

    private void onCalibStart() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.startCompassCalib();
        } else {
            UASToolDropDownReceiver.toast("Unable to start compass calibration - no connection to ATAKGo");
        }
    }

    /* access modifiers changed from: private */
    public void setCalibHoriz() {
        this.warnText.setVisibility(8);
        this.instructText.setText(this.horizString);
        this.instructText.setVisibility(0);
        this.imageView.setImageResource(C1877R.drawable.dji_compass_horiz);
        this.button.setText(this.cancelString);
    }

    /* access modifiers changed from: private */
    public void setCalibVert() {
        this.warnText.setVisibility(8);
        this.instructText.setText(this.vertString);
        this.instructText.setVisibility(0);
        this.imageView.setImageResource(C1877R.drawable.dji_compass_vert);
        this.button.setText(this.cancelString);
    }

    /* access modifiers changed from: private */
    public void setCalibSuccess() {
        UASToolDropDownReceiver.toast("Compass calibrated successfully!", 1);
    }

    /* access modifiers changed from: private */
    public void setCalibFailed() {
        UASToolDropDownReceiver.toast("Compass calibration FAILED!", 1);
    }

    /* access modifiers changed from: private */
    public void setCalibNoUAS() {
        UASToolDropDownReceiver.toast("Compass calibration FAILED - No UAS.", 1);
        this.warnText.setVisibility(0);
        this.instructText.setVisibility(8);
        this.imageView.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.button.setText(this.noUASString);
        this.button.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void setCalibUnknown() {
        UASToolDropDownReceiver.toast("Compass calibration FAILED - Unknown.", 1);
        this.warnText.setVisibility(0);
        this.instructText.setVisibility(8);
        this.imageView.setImageResource(C1877R.drawable.dji_uas_start);
        this.imageView.setAlpha(0.5f);
        this.button.setText(this.unknownString);
        this.button.setEnabled(false);
    }

    private void onCalibCancel(boolean z) {
        interruptCalib();
        if (!isInEditMode()) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.stopCompassCalib();
            } else {
                UASToolDropDownReceiver.toast("Unable to stop compass calibration - no connection to ATAKGo");
            }
        }
        if (z) {
            UASToolDropDownReceiver.toast("Compass calibration cancelled.", 1);
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
