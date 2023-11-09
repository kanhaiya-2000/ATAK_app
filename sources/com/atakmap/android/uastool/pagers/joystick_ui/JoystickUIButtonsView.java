package com.atakmap.android.uastool.pagers.joystick_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UIConstants;
import com.atakmap.android.uastool.plugin.C1877R;

public class JoystickUIButtonsView extends JoystickUIBase {
    private static final String BACKWARD = "backward";
    private static final String DOWN = "down";
    private static final String FORWARD = "forward";
    private static final String PANLEFT = "panleft";
    private static final String PANRIGHT = "panright";
    public static final String TAG = "JoystickUIButtonsView";

    /* renamed from: UP */
    private static final String f8398UP = "up";
    private static final String YAWLEFT = "yawleft";
    private static final String YAWRIGHT = "yawright";
    /* access modifiers changed from: private */
    public JoystickUIButton backwardButton;
    private final View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View view) {
            JoystickUIButtonsView.this.killAlphaAnim();
            boolean unused = JoystickUIButtonsView.this.resetButtons();
            String str = (String) view.getTag();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1390959882:
                    if (str.equals(JoystickUIButtonsView.YAWLEFT)) {
                        c = 0;
                        break;
                    }
                    break;
                case -796870108:
                    if (str.equals(JoystickUIButtonsView.PANLEFT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -677145915:
                    if (str.equals(JoystickUIButtonsView.FORWARD)) {
                        c = 2;
                        break;
                    }
                    break;
                case -164422387:
                    if (str.equals(JoystickUIButtonsView.YAWRIGHT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 3739:
                    if (str.equals(JoystickUIButtonsView.f8398UP)) {
                        c = 4;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals(JoystickUIButtonsView.DOWN)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1072491423:
                    if (str.equals(JoystickUIButtonsView.PANRIGHT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 2121976803:
                    if (str.equals(JoystickUIButtonsView.BACKWARD)) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    JoystickUIButtonsView.this.onYawLeft();
                    break;
                case 1:
                    JoystickUIButtonsView.this.onPanLeft();
                    break;
                case 2:
                    JoystickUIButtonsView.this.onForward();
                    break;
                case 3:
                    JoystickUIButtonsView.this.onYawRight();
                    break;
                case 4:
                    JoystickUIButtonsView.this.onUp();
                    break;
                case 5:
                    JoystickUIButtonsView.this.onDown();
                    break;
                case 6:
                    JoystickUIButtonsView.this.onPanRight();
                    break;
                case 7:
                    JoystickUIButtonsView.this.onBackward();
                    break;
            }
            JoystickUIButtonsView.this.startAlphaAnim();
        }
    };
    /* access modifiers changed from: private */
    public JoystickUIButton downButton;
    /* access modifiers changed from: private */
    public JoystickUIButton forwardButton;
    private GestureDetector gestureDetector;
    private final View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            JoystickUIButton joystickUIButton;
            JoystickUIButtonsView.this.killAlphaAnim();
            boolean z = ((JoystickUIButton) view).isOn;
            boolean unused = JoystickUIButtonsView.this.resetButtons();
            String str = (String) view.getTag();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1390959882:
                    if (str.equals(JoystickUIButtonsView.YAWLEFT)) {
                        c = 0;
                        break;
                    }
                    break;
                case -796870108:
                    if (str.equals(JoystickUIButtonsView.PANLEFT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -677145915:
                    if (str.equals(JoystickUIButtonsView.FORWARD)) {
                        c = 2;
                        break;
                    }
                    break;
                case -164422387:
                    if (str.equals(JoystickUIButtonsView.YAWRIGHT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 3739:
                    if (str.equals(JoystickUIButtonsView.f8398UP)) {
                        c = 4;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals(JoystickUIButtonsView.DOWN)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1072491423:
                    if (str.equals(JoystickUIButtonsView.PANRIGHT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 2121976803:
                    if (str.equals(JoystickUIButtonsView.BACKWARD)) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    joystickUIButton = JoystickUIButtonsView.this.yawLeftButton;
                    JoystickUIButtonsView.this.onYawLeftHold(!z);
                    break;
                case 1:
                    joystickUIButton = JoystickUIButtonsView.this.panLeftButton;
                    JoystickUIButtonsView.this.onPanLeftHold(!z);
                    break;
                case 2:
                    joystickUIButton = JoystickUIButtonsView.this.forwardButton;
                    JoystickUIButtonsView.this.onForwardHold(!z);
                    break;
                case 3:
                    joystickUIButton = JoystickUIButtonsView.this.yawRightButton;
                    JoystickUIButtonsView.this.onYawRightHold(!z);
                    break;
                case 4:
                    joystickUIButton = JoystickUIButtonsView.this.upButton;
                    JoystickUIButtonsView.this.onUpHold(!z);
                    break;
                case 5:
                    joystickUIButton = JoystickUIButtonsView.this.downButton;
                    JoystickUIButtonsView.this.onDownHold(!z);
                    break;
                case 6:
                    joystickUIButton = JoystickUIButtonsView.this.panRightButton;
                    JoystickUIButtonsView.this.onPanRightHold(!z);
                    break;
                case 7:
                    joystickUIButton = JoystickUIButtonsView.this.backwardButton;
                    JoystickUIButtonsView.this.onBackwardHold(!z);
                    break;
                default:
                    joystickUIButton = null;
                    break;
            }
            JoystickUIButtonsView.this.startAlphaAnim();
            return joystickUIButton != null;
        }
    };
    /* access modifiers changed from: private */
    public JoystickUIButton panLeftButton;
    /* access modifiers changed from: private */
    public JoystickUIButton panRightButton;
    /* access modifiers changed from: private */
    public JoystickUIButton upButton;
    /* access modifiers changed from: private */
    public JoystickUIButton yawLeftButton;
    /* access modifiers changed from: private */
    public JoystickUIButton yawRightButton;

    private GestureDetector getNewGestureDetector(Context context) {
        return new GestureDetector(context, new GestureListener());
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        private GestureListener() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            JoystickUIButtonsView.this.toast("Fling");
            return true;
        }
    }

    public JoystickUIButtonsView(Context context) {
        super(context);
    }

    public JoystickUIButtonsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JoystickUIButtonsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            JoystickUIButton joystickUIButton = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_up_button);
            this.upButton = joystickUIButton;
            joystickUIButton.setTag(f8398UP);
            this.upButton.setOnClickListener(this.clickListener);
            this.upButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton2 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_forward_button);
            this.forwardButton = joystickUIButton2;
            joystickUIButton2.setTag(FORWARD);
            this.forwardButton.setOnClickListener(this.clickListener);
            this.forwardButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton3 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_down_button);
            this.downButton = joystickUIButton3;
            joystickUIButton3.setTag(DOWN);
            this.downButton.setOnClickListener(this.clickListener);
            this.downButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton4 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_backward_button);
            this.backwardButton = joystickUIButton4;
            joystickUIButton4.setTag(BACKWARD);
            this.backwardButton.setOnClickListener(this.clickListener);
            this.backwardButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton5 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_yaw_left_button);
            this.yawLeftButton = joystickUIButton5;
            joystickUIButton5.setTag(YAWLEFT);
            this.yawLeftButton.setOnClickListener(this.clickListener);
            this.yawLeftButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton6 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_pan_left_button);
            this.panLeftButton = joystickUIButton6;
            joystickUIButton6.setTag(PANLEFT);
            this.panLeftButton.setOnClickListener(this.clickListener);
            this.panLeftButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton7 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_yaw_right_button);
            this.yawRightButton = joystickUIButton7;
            joystickUIButton7.setTag(YAWRIGHT);
            this.yawRightButton.setOnClickListener(this.clickListener);
            this.yawRightButton.setOnLongClickListener(this.longClickListener);
            JoystickUIButton joystickUIButton8 = (JoystickUIButton) findViewById(C1877R.C1878id.bh3_joystick_pan_right_button);
            this.panRightButton = joystickUIButton8;
            joystickUIButton8.setTag(PANRIGHT);
            this.panRightButton.setOnClickListener(this.clickListener);
            this.panRightButton.setOnLongClickListener(this.longClickListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void init(UASItem uASItem) {
        this.upButton.init();
        this.forwardButton.init();
        this.downButton.init();
        this.backwardButton.init();
        this.yawLeftButton.init();
        this.panLeftButton.init();
        this.yawRightButton.init();
        this.panRightButton.init();
        super.init(uASItem);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ((RelativeLayout.LayoutParams) JoystickUIButtonsView.this.getLayoutParams()).setMargins(UIConstants.JOYSTICK_BUTTONS_LEFT_OFFSET_FULL, UIConstants.JOYSTICK_BUTTONS_TOP_OFFSET_FULL, 0, UIConstants.JOYSTICK_BUTTONS_BOTTOM_OFFSET_FULL);
                JoystickUIButtonsView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void enableTouches(boolean z) {
        if (z) {
            this.upButton.setOnClickListener(this.clickListener);
            this.upButton.setOnLongClickListener(this.longClickListener);
            this.forwardButton.setOnClickListener(this.clickListener);
            this.forwardButton.setOnLongClickListener(this.longClickListener);
            this.downButton.setOnClickListener(this.clickListener);
            this.downButton.setOnLongClickListener(this.longClickListener);
            this.backwardButton.setOnClickListener(this.clickListener);
            this.backwardButton.setOnLongClickListener(this.longClickListener);
            this.yawLeftButton.setOnClickListener(this.clickListener);
            this.yawLeftButton.setOnLongClickListener(this.longClickListener);
            this.panLeftButton.setOnClickListener(this.clickListener);
            this.panLeftButton.setOnLongClickListener(this.longClickListener);
            this.yawRightButton.setOnClickListener(this.clickListener);
            this.yawRightButton.setOnLongClickListener(this.longClickListener);
            this.panRightButton.setOnClickListener(this.clickListener);
            this.panRightButton.setOnLongClickListener(this.longClickListener);
            return;
        }
        this.upButton.setOnClickListener((View.OnClickListener) null);
        this.upButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.forwardButton.setOnClickListener((View.OnClickListener) null);
        this.forwardButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.downButton.setOnClickListener((View.OnClickListener) null);
        this.downButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.backwardButton.setOnClickListener((View.OnClickListener) null);
        this.backwardButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.yawLeftButton.setOnClickListener((View.OnClickListener) null);
        this.yawLeftButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.panLeftButton.setOnClickListener((View.OnClickListener) null);
        this.panLeftButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.yawRightButton.setOnClickListener((View.OnClickListener) null);
        this.yawRightButton.setOnLongClickListener((View.OnLongClickListener) null);
        this.panRightButton.setOnClickListener((View.OnClickListener) null);
        this.panRightButton.setOnLongClickListener((View.OnLongClickListener) null);
    }

    /* access modifiers changed from: private */
    public boolean resetButtons() {
        boolean z;
        if (this.upButton.isOn) {
            onUpHold(false);
            z = true;
        } else {
            z = false;
        }
        if (this.forwardButton.isOn) {
            onForwardHold(false);
            z = true;
        }
        if (this.downButton.isOn) {
            onDownHold(false);
            z = true;
        }
        if (this.backwardButton.isOn) {
            onBackwardHold(false);
            z = true;
        }
        if (this.yawLeftButton.isOn) {
            onYawLeftHold(false);
            z = true;
        }
        if (this.panLeftButton.isOn) {
            onPanLeftHold(false);
            z = true;
        }
        if (this.yawRightButton.isOn) {
            onYawRightHold(false);
            z = true;
        }
        if (!this.panRightButton.isOn) {
            return z;
        }
        onPanRightHold(false);
        return true;
    }

    /* access modifiers changed from: private */
    public void onUp() {
        if (this.uasItem != null) {
            this.uasItem.joystickUpIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onUpHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickUpCont(z);
        } else {
            toast("Null UASItem");
        }
        this.forwardButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onForward() {
        if (this.uasItem != null) {
            this.uasItem.joystickForwardIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onForwardHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickForwardCont(z);
        } else {
            toast("Null UASItem");
        }
        this.forwardButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onDown() {
        if (this.uasItem != null) {
            this.uasItem.joystickDownIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onDownHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickDownCont(z);
        } else {
            toast("Null UASItem");
        }
        this.backwardButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onBackward() {
        if (this.uasItem != null) {
            this.uasItem.joystickBackwardIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onBackwardHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickBackwardCont(z);
        } else {
            toast("Null UASItem");
        }
        this.backwardButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onYawLeft() {
        if (this.uasItem != null) {
            this.uasItem.joystickYawLeftIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onYawLeftHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickYawLeftCont(z);
        } else {
            toast("Null UASItem");
        }
        this.yawLeftButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onPanLeft() {
        if (this.uasItem != null) {
            this.uasItem.joystickPanLeftIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onPanLeftHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickPanLeftCont(z);
        } else {
            toast("Null UASItem");
        }
        this.panLeftButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onYawRight() {
        if (this.uasItem != null) {
            this.uasItem.joystickYawRightIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onYawRightHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickYawRightCont(z);
        } else {
            toast("Null UASItem");
        }
        this.yawRightButton.setOn(z);
    }

    /* access modifiers changed from: private */
    public void onPanRight() {
        if (this.uasItem != null) {
            this.uasItem.joystickPanRightIncr();
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: private */
    public void onPanRightHold(boolean z) {
        if (this.uasItem != null) {
            this.uasItem.joystickPanRightCont(z);
        } else {
            toast("Null UASItem");
        }
        this.panRightButton.setOn(z);
    }
}
