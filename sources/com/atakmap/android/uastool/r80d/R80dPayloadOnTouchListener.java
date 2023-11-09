package com.atakmap.android.uastool.r80d;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.aeryon.java.types.Aircraft;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.concurrent.atomic.AtomicBoolean;

public class R80dPayloadOnTouchListener implements View.OnTouchListener {
    private static final String TAG = "R80dPayloadOnTouchListener";
    /* access modifiers changed from: private */
    public static final AtomicBoolean payloadStateOpened = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public R80dUASItem r80dUASItem;

    public R80dPayloadOnTouchListener(UASItem uASItem) {
        if (uASItem instanceof R80dUASItem) {
            this.r80dUASItem = (R80dUASItem) uASItem;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        int cargoLatchState = this.r80dUASItem.cargoLatchState();
        if (cargoLatchState == Aircraft.ADK_CARGO_LATCH_STATE_Open || cargoLatchState == Aircraft.ADK_CARGO_LATCH_STATE_MovingToOpened) {
            payloadStateOpened.set(true);
        } else {
            payloadStateOpened.set(false);
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.r80d_payload_slider, (ViewGroup) null);
        final AlertDialog create = new AlertDialog.Builder(MapView.getMapView().getContext()).create();
        StringBuilder sb = new StringBuilder();
        sb.append("Slide to ");
        AtomicBoolean atomicBoolean = payloadStateOpened;
        sb.append(atomicBoolean.get() ? "Close" : "Release");
        sb.append(" Payload");
        create.setTitle(sb.toString());
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final Button button = (Button) linearLayout.findViewById(C1877R.C1878id.button_r80d_payload_release);
        final Button button2 = (Button) linearLayout.findViewById(C1877R.C1878id.button_r80d_payload_close);
        Button button3 = (Button) linearLayout.findViewById(C1877R.C1878id.button_r80d_payload_cancel);
        int i = 8;
        button.setVisibility(atomicBoolean.get() ? 8 : 0);
        if (atomicBoolean.get()) {
            i = 0;
        }
        button2.setVisibility(i);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!atomicBoolean2.get()) {
                    R80dPayloadOnTouchListener.payloadStateOpened.set(true);
                    R80dPayloadOnTouchListener.this.r80dUASItem.cargoActuateLatch(Aircraft.ADK_CARGO_LATCH_STATE_Open);
                    create.dismiss();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (atomicBoolean2.get()) {
                    R80dPayloadOnTouchListener.payloadStateOpened.set(false);
                    R80dPayloadOnTouchListener.this.r80dUASItem.cargoActuateLatch(Aircraft.ADK_CARGO_LATCH_STATE_Closed);
                    create.dismiss();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        SeekBar seekBar = (SeekBar) linearLayout.findViewById(C1877R.C1878id.button_r80d_payload_slider);
        seekBar.setProgress(atomicBoolean.get() ? 1 : 0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (i == 0) {
                    atomicBoolean2.set(true);
                    if (R80dPayloadOnTouchListener.payloadStateOpened.get()) {
                        button2.setClickable(true);
                        button2.setAlpha(1.0f);
                    } else {
                        button.setClickable(false);
                        button.setAlpha(0.5f);
                    }
                }
                if (i == 1) {
                    atomicBoolean2.set(false);
                    if (!R80dPayloadOnTouchListener.payloadStateOpened.get()) {
                        button.setClickable(true);
                        button.setAlpha(1.0f);
                        return;
                    }
                    button2.setClickable(false);
                    button2.setAlpha(0.5f);
                }
            }
        });
        button2.setClickable(false);
        button.setClickable(false);
        create.setView(linearLayout);
        create.show();
        return true;
    }
}
