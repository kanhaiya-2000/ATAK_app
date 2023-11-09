package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;

public abstract class MovableWidget extends BackgroundWidget {
    public static final String TAG = "MovableWidget";
    protected Boolean isLocked;
    protected boolean isMovable;
    private final View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            MovableWidget.this.setMovable(true);
            if (MovableWidget.this.isMovable) {
                MovableWidget.this.checkSnap(true);
            }
            return true;
        }
    };
    protected float offsetX;
    protected float offsetY;
    protected int radius;

    public MovableWidget(Context context) {
        super(context);
    }

    public MovableWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MovableWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                return false;
                            }
                        } else if (!MovableWidget.this.isMovable) {
                            return false;
                        } else {
                            view.setTranslationX(motionEvent.getRawX() - MovableWidget.this.offsetX);
                            view.setTranslationY(motionEvent.getRawY() - MovableWidget.this.offsetY);
                            MovableWidget.this.checkSnap(false);
                            return true;
                        }
                    }
                    if (MovableWidget.this.isMovable) {
                        MovableWidget.this.checkSnap(false);
                        MovableWidget.this.setSavedPosition(false);
                    }
                    MovableWidget.this.setMovable(false);
                    return false;
                }
                MovableWidget.this.offsetX = motionEvent.getRawX() - view.getTranslationX();
                MovableWidget.this.offsetY = motionEvent.getRawY() - view.getTranslationY();
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener((View.OnTouchListener) null);
        setOnLongClickListener((View.OnLongClickListener) null);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.radius = (int) ((VideoUIView.SCALE * 7.0f) + 0.5f);
        super.init(videoUIView, uASItem);
        updateLock();
        setMovable(false);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        if (str.equals(UIPreferenceFragment.PREF_UI_LOCKED)) {
            updateLock();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSnap(false);
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (MovableWidget.this.isFullScreen()) {
                        MovableWidget movableWidget = MovableWidget.this;
                        movableWidget.setTranslationX(movableWidget.getSavedPositionX());
                        MovableWidget movableWidget2 = MovableWidget.this;
                        movableWidget2.setTranslationY(movableWidget2.getSavedPositionY());
                        return;
                    }
                    MovableWidget.this.setTranslationX(0.0f);
                    MovableWidget.this.setTranslationY(0.0f);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void checkSnap(final boolean z) {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (MovableWidget.this.backDrawable == null) {
                        return;
                    }
                    if (z) {
                        MovableWidget.this.backDrawable.setCornerRadius((float) MovableWidget.this.radius);
                        return;
                    }
                    float x = MovableWidget.this.getX();
                    float y = MovableWidget.this.getY();
                    float width = (float) MovableWidget.this.getWidth();
                    float height = (float) MovableWidget.this.getHeight();
                    float x2 = MovableWidget.this.videoUIView.getX();
                    float y2 = MovableWidget.this.videoUIView.getY();
                    float width2 = (float) MovableWidget.this.videoUIView.getWidth();
                    float height2 = (float) MovableWidget.this.videoUIView.getHeight();
                    float[] fArr = {(float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius, (float) MovableWidget.this.radius};
                    float f = (float) 15;
                    if (x < f) {
                        MovableWidget movableWidget = MovableWidget.this;
                        movableWidget.setTranslationX((float) (-movableWidget.getLeft()));
                        fArr[0] = 0.0f;
                        fArr[1] = 0.0f;
                        fArr[6] = 0.0f;
                        fArr[7] = 0.0f;
                    }
                    if (y < f) {
                        MovableWidget movableWidget2 = MovableWidget.this;
                        movableWidget2.setTranslationY((float) (-movableWidget2.getTop()));
                        fArr[0] = 0.0f;
                        fArr[1] = 0.0f;
                        fArr[2] = 0.0f;
                        fArr[3] = 0.0f;
                    }
                    float f2 = x2 + width2;
                    if (x + width > f2 - f) {
                        MovableWidget movableWidget3 = MovableWidget.this;
                        movableWidget3.setTranslationX(f2 - ((float) movableWidget3.getRight()));
                        fArr[2] = 0.0f;
                        fArr[3] = 0.0f;
                        fArr[4] = 0.0f;
                        fArr[5] = 0.0f;
                    }
                    float f3 = y2 + height2;
                    if (y + height > f3 - f) {
                        MovableWidget movableWidget4 = MovableWidget.this;
                        movableWidget4.setTranslationY(f3 - ((float) movableWidget4.getBottom()));
                        fArr[4] = 0.0f;
                        fArr[5] = 0.0f;
                        fArr[6] = 0.0f;
                        fArr[7] = 0.0f;
                    }
                    MovableWidget.this.backDrawable.setCornerRadii(fArr);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void updateLock() {
        Boolean valueOf = Boolean.valueOf(UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_LOCKED, UIPreferenceFragment.DEFAULT_UI_LOCKED.booleanValue()));
        this.isLocked = valueOf;
        if (valueOf.booleanValue()) {
            setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            setOnLongClickListener(this.longClickListener);
        }
    }

    /* access modifiers changed from: protected */
    public void setMovable(final boolean z) {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (MovableWidget.this.videoUIView.isFullScreen()) {
                        MovableWidget.this.isMovable = z;
                        if (MovableWidget.this.isMovable) {
                            MovableWidget.this.backDrawable.setColor(Color.argb(255, Color.red(MovableWidget.this.backColor), Color.green(MovableWidget.this.backColor), Color.blue(MovableWidget.this.backColor)));
                        } else {
                            MovableWidget.this.backDrawable.setColor(MovableWidget.this.backColor);
                        }
                    } else if (this instanceof PopupWidget) {
                        MovableWidget.this.backDrawable.setColor(MovableWidget.this.backColor);
                    } else {
                        MovableWidget.this.backDrawable.setColor(MovableWidget.this.backColor);
                    }
                }
            });
        }
    }

    public void setSavedPosition() {
        setSavedPosition(false);
    }

    public void setSavedPosition(boolean z) {
        if ((this.videoUIView.isFullScreen() || z) && !isInEditMode()) {
            SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
            String simpleName = getClass().getSimpleName();
            edit.putFloat(UIPreferenceFragment.PREFIX_UI_TRANS_X + simpleName, getTranslationX());
            edit.putFloat(UIPreferenceFragment.PREFIX_UI_TRANS_Y + simpleName, getTranslationY());
            edit.apply();
        }
    }

    public float getSavedPositionX() {
        if (isInEditMode()) {
            return 0.0f;
        }
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        String simpleName = getClass().getSimpleName();
        return sharedPrefs.getFloat(UIPreferenceFragment.PREFIX_UI_TRANS_X + simpleName, 0.0f);
    }

    public float getSavedPositionY() {
        if (isInEditMode()) {
            return 0.0f;
        }
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        String simpleName = getClass().getSimpleName();
        return sharedPrefs.getFloat(UIPreferenceFragment.PREFIX_UI_TRANS_Y + simpleName, 0.0f);
    }

    public void setColor(final int i) {
        this.backColor = i;
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                MovableWidget.this.backDrawable.setColor(i);
            }
        });
    }
}
