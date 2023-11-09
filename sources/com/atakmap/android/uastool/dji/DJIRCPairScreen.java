package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.plugin.C1877R;

public class DJIRCPairScreen extends UASToolScreen {
    private static final String TAG = "DJIRCPairScreen";
    /* access modifiers changed from: private */
    public Button button;
    /* access modifiers changed from: private */
    public final int disabledColor;
    /* access modifiers changed from: private */
    public final int enabledColor;
    /* access modifiers changed from: private */
    public TextView helpText;
    /* access modifiers changed from: private */
    public STATE state;

    enum STATE {
        PAIRING("PAIRING", "Press the binding button on UAS", "Cancel"),
        UNKNOWN("UNKNOWN", "", "Start Pairing");
        
        private final String buttonText;
        private final String helpText;
        private final String stateName;

        private STATE(String str, String str2, String str3) {
            this.stateName = str;
            this.helpText = str2;
            this.buttonText = str3;
        }

        public String getStateName() {
            return this.stateName;
        }

        public String getHelpText() {
            return this.helpText;
        }

        public String getButtonText() {
            return this.buttonText;
        }

        public static STATE fromString(String str) {
            if (str == null) {
                return null;
            }
            for (STATE state : values()) {
                if (state.stateName.equalsIgnoreCase(str)) {
                    return state;
                }
            }
            return null;
        }
    }

    public DJIRCPairScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enabledColor = context.getResources().getColor(C1877R.color.lightBlue);
        this.disabledColor = context.getResources().getColor(C1877R.color.darker_gray);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    return DJIRCPairScreen.this.onBackButton();
                }
                return false;
            }
        });
        this.helpText = (TextView) findViewById(C1877R.C1878id.djircpair_help_text);
        Button button2 = (Button) findViewById(C1877R.C1878id.djircpair_button);
        this.button = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIRCPairScreen.this.onButtonPress(((Button) view).getText().toString());
            }
        });
        updateState(STATE.UNKNOWN);
    }

    private static void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    private void updateState(STATE state2) {
        this.state = state2;
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    DJIRCPairScreen.this.helpText.setText(DJIRCPairScreen.this.state.getHelpText());
                    DJIRCPairScreen.this.button.setText(DJIRCPairScreen.this.state.getButtonText());
                    DJIRCPairScreen.this.button.setEnabled(false);
                    DJIRCPairScreen.this.button.setBackgroundColor(DJIRCPairScreen.this.disabledColor);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            DJIRCPairScreen.this.button.setEnabled(true);
                            DJIRCPairScreen.this.button.setBackgroundColor(DJIRCPairScreen.this.enabledColor);
                        }
                    }, 2000);
                }
            });
        }
    }

    /* renamed from: com.atakmap.android.uastool.dji.DJIRCPairScreen$5 */
    /* synthetic */ class C12535 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$dji$DJIRCPairScreen$STATE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.dji.DJIRCPairScreen$STATE[] r0 = com.atakmap.android.uastool.dji.DJIRCPairScreen.STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$dji$DJIRCPairScreen$STATE = r0
                com.atakmap.android.uastool.dji.DJIRCPairScreen$STATE r1 = com.atakmap.android.uastool.dji.DJIRCPairScreen.STATE.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$dji$DJIRCPairScreen$STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.dji.DJIRCPairScreen$STATE r1 = com.atakmap.android.uastool.dji.DJIRCPairScreen.STATE.PAIRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIRCPairScreen.C12535.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void onButtonPress(String str) {
        int i = C12535.$SwitchMap$com$atakmap$android$uastool$dji$DJIRCPairScreen$STATE[this.state.ordinal()];
        if (i == 1) {
            updateState(STATE.PAIRING);
            startPairing();
        } else if (i == 2) {
            updateState(STATE.UNKNOWN);
            stopPairing();
        }
    }

    private void startPairing() {
        if (!isInEditMode()) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.startRCPairing();
            } else {
                toast("Unable to start controller pairing - no connection to UAS");
            }
        }
    }

    private void stopPairing() {
        if (!isInEditMode()) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.stopRCPairing();
            } else {
                toast("Unable to stop controller pairing - no connection to UAS");
            }
        }
    }

    public void onUASPairingStopped() {
        updateState(STATE.UNKNOWN);
    }

    /* access modifiers changed from: private */
    public boolean onBackButton() {
        if (this.state.equals(STATE.PAIRING)) {
            alertCloseWhilePairing();
            return true;
        }
        closeScreen();
        return true;
    }

    private void alertCloseWhilePairing() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Pairing");
        builder.setMessage("You are currently pairing the controller. Please wait until finished to close this screen or press Cancel.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    private void closeScreen() {
        this.myParentFragment.removeCurrentScreen();
    }
}
