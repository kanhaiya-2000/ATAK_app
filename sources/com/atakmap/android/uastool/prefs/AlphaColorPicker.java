package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class AlphaColorPicker extends LinearLayout {
    private static final int SEEK_MAX = 255;
    private SeekBar alphaSeek;
    private SeekBar blueSeek;
    private RelativeLayout colorLayout;
    private SeekBar greenSeek;
    private SeekBar redSeek;

    public AlphaColorPicker(Context context) {
        super(context);
        _init(Color.argb(127, 255, 255, 255));
    }

    public AlphaColorPicker(Context context, int i) {
        super(context);
        _init(i);
    }

    private void _init(int i) {
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(550, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(10, 0, 10, 10);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 0.75f;
        relativeLayout.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, 0, 0, 10);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(0);
        TextView textView = new TextView(getContext());
        textView.setText("R");
        SeekBar seekBar = new SeekBar(getContext());
        this.redSeek = seekBar;
        seekBar.setMax(255);
        this.redSeek.setProgress(Color.red(i));
        this.redSeek.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.redSeek.setOnSeekBarChangeListener(new ProgressChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlphaColorPicker.this.updateColor();
            }
        });
        linearLayout3.addView(textView);
        linearLayout3.addView(this.redSeek);
        LinearLayout linearLayout4 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(0, 0, 0, 10);
        linearLayout4.setLayoutParams(layoutParams4);
        linearLayout4.setGravity(17);
        linearLayout4.setOrientation(0);
        TextView textView2 = new TextView(getContext());
        textView2.setText("G");
        SeekBar seekBar2 = new SeekBar(getContext());
        this.greenSeek = seekBar2;
        seekBar2.setMax(255);
        this.greenSeek.setProgress(Color.green(i));
        this.greenSeek.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.greenSeek.setOnSeekBarChangeListener(new ProgressChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlphaColorPicker.this.updateColor();
            }
        });
        linearLayout4.addView(textView2);
        linearLayout4.addView(this.greenSeek);
        LinearLayout linearLayout5 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(0, 0, 0, 10);
        linearLayout5.setLayoutParams(layoutParams5);
        linearLayout5.setGravity(17);
        linearLayout5.setOrientation(0);
        TextView textView3 = new TextView(getContext());
        textView3.setText("B");
        SeekBar seekBar3 = new SeekBar(getContext());
        this.blueSeek = seekBar3;
        seekBar3.setMax(255);
        this.blueSeek.setProgress(Color.blue(i));
        this.blueSeek.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.blueSeek.setOnSeekBarChangeListener(new ProgressChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlphaColorPicker.this.updateColor();
            }
        });
        linearLayout5.addView(textView3);
        linearLayout5.addView(this.blueSeek);
        LinearLayout linearLayout6 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.setMargins(0, 0, 0, 10);
        linearLayout6.setLayoutParams(layoutParams6);
        linearLayout6.setGravity(17);
        linearLayout6.setOrientation(0);
        TextView textView4 = new TextView(getContext());
        textView4.setText("A");
        SeekBar seekBar4 = new SeekBar(getContext());
        this.alphaSeek = seekBar4;
        seekBar4.setMax(255);
        this.alphaSeek.setProgress(Color.alpha(i));
        this.alphaSeek.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.alphaSeek.setOnSeekBarChangeListener(new ProgressChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlphaColorPicker.this.updateColor();
            }
        });
        linearLayout6.addView(textView4);
        linearLayout6.addView(this.alphaSeek);
        linearLayout2.addView(linearLayout3);
        linearLayout2.addView(linearLayout4);
        linearLayout2.addView(linearLayout5);
        linearLayout2.addView(linearLayout6);
        relativeLayout.addView(linearLayout2);
        linearLayout.addView(relativeLayout);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -1);
        layoutParams7.weight = 0.25f;
        layoutParams7.setMargins(5, 5, 5, 5);
        relativeLayout2.setLayoutParams(layoutParams7);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.setBackground(ContextCompat.getDrawable(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.drawable.alpha_back));
        relativeLayout2.addView(frameLayout);
        this.colorLayout = new RelativeLayout(getContext());
        this.colorLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.colorLayout.setBackgroundColor(i);
        frameLayout.addView(this.colorLayout);
        linearLayout.addView(relativeLayout2);
        addView(linearLayout);
    }

    public final int getColor() {
        return Color.argb(this.alphaSeek.getProgress(), this.redSeek.getProgress(), this.greenSeek.getProgress(), this.blueSeek.getProgress());
    }

    /* access modifiers changed from: private */
    public void updateColor() {
        this.colorLayout.setBackgroundColor(Color.argb(this.alphaSeek.getProgress(), this.redSeek.getProgress(), this.greenSeek.getProgress(), this.blueSeek.getProgress()));
    }

    private static abstract class ProgressChangeListener implements SeekBar.OnSeekBarChangeListener {
        public abstract void onProgressChanged(SeekBar seekBar, int i, boolean z);

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        private ProgressChangeListener() {
        }
    }
}
