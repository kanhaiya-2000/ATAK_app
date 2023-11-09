package com.atakmap.android.uastool.pagers.joystick_ui;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UIConstants;

public class JoystickUIButton extends ImageButton {
    public static final String TAG = "JoystickUIButton";
    private Drawable background;
    protected boolean isDanger = false;
    protected boolean isOn = false;
    protected boolean isPending = false;

    public void updateSize() {
    }

    public JoystickUIButton(Context context) {
        super(context);
    }

    public JoystickUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JoystickUIButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.background = getBackground();
        }
    }

    public void init() {
        updateSize();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        super.setSelected(false);
        super.setActivated(false);
        if (z) {
            setColorFilter((ColorFilter) null);
        } else {
            setColorFilter(UIConstants.COLOR_DISABLED, PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setOn(boolean z) {
        super.setEnabled(true);
        super.setSelected(z);
        super.setActivated(false);
        this.isOn = z;
        if (z) {
            setColorFilter(UIConstants.COLOR_ON, PorterDuff.Mode.MULTIPLY);
        } else {
            setColorFilter((ColorFilter) null);
        }
    }

    public void setPending(boolean z) {
        super.setEnabled(true);
        super.setSelected(false);
        super.setActivated(z);
        this.isPending = z;
        if (z) {
            setColorFilter(UIConstants.COLOR_PENDING, PorterDuff.Mode.MULTIPLY);
        } else {
            setColorFilter((ColorFilter) null);
        }
    }

    public void setDanger(boolean z) {
        super.setEnabled(true);
        super.setSelected(z);
        super.setActivated(z);
        this.isDanger = z;
        if (z) {
            setColorFilter(UIConstants.COLOR_DANGER, PorterDuff.Mode.MULTIPLY);
        } else {
            setColorFilter((ColorFilter) null);
        }
    }
}
