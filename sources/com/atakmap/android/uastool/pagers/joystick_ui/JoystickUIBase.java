package com.atakmap.android.uastool.pagers.joystick_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public abstract class JoystickUIBase extends RelativeLayout {
    public static final String TAG = "JoystickUIBase";
    protected AlphaAnimation alphaAnim;
    protected Context pluginContext;
    protected UASItem uasItem;

    /* access modifiers changed from: protected */
    public abstract void enableTouches(boolean z);

    /* access modifiers changed from: protected */
    public long getAnimDelay() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public long getAnimDuration() {
        return 2000;
    }

    /* access modifiers changed from: protected */
    public float getAnimEndAlpha() {
        return 0.4f;
    }

    /* access modifiers changed from: protected */
    public float getAnimStartAlpha() {
        return 1.0f;
    }

    public JoystickUIBase(Context context) {
        super(context);
        this.pluginContext = context;
    }

    public JoystickUIBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    public JoystickUIBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pluginContext = context;
    }

    public static JoystickUIBase getJoystickUI() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_JOYSTICK_VIRTUAL_TYPE, "Dual Sticks");
        string.hashCode();
        int i = !string.equals("Dual Sticks") ? !string.equals("Buttons") ? -1 : C1877R.layout.joystick_ui_buttons_layout : C1877R.layout.joystick_ui_sticks_layout;
        if (i >= 0) {
            return (JoystickUIBase) PluginLayoutInflater.inflate(UASToolDropDownReceiver.getInstance().getPluginContext(), i, (ViewGroup) null);
        }
        UASToolDropDownReceiver.toast("Unable to get virtual joystick layout");
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAlphaAnim();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        killAlphaAnim();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            enableTouches(true);
            startAlphaAnim();
        } else {
            enableTouches(false);
            killAlphaAnim();
        }
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                JoystickUIBase.this.invalidate();
            }
        });
    }

    public void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    public void init(UASItem uASItem) {
        this.uasItem = uASItem;
    }

    /* access modifiers changed from: protected */
    public void createAlphaAnim() {
        if (this.alphaAnim != null) {
            killAlphaAnim();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(getAnimStartAlpha(), getAnimEndAlpha());
        this.alphaAnim = alphaAnimation;
        alphaAnimation.setDuration(getAnimDuration());
        this.alphaAnim.setStartOffset(getAnimDelay());
        this.alphaAnim.setFillAfter(true);
    }

    /* access modifiers changed from: protected */
    public void startAlphaAnim() {
        AlphaAnimation alphaAnimation = this.alphaAnim;
        if (alphaAnimation == null) {
            createAlphaAnim();
        } else {
            alphaAnimation.reset();
        }
        startAnimation(this.alphaAnim);
    }

    /* access modifiers changed from: protected */
    public void killAlphaAnim() {
        AlphaAnimation alphaAnimation = this.alphaAnim;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.alphaAnim = null;
        }
    }
}
