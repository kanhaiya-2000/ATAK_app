package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class VideoUIButton extends ImageButton {
    public static final String TAG = "VideoUIButton";
    protected Drawable fullBackground;
    protected RelativeLayout.LayoutParams fullLayoutParams;
    protected Drawable halfBackground;
    protected RelativeLayout.LayoutParams halfLayoutParams;

    public VideoUIButton(Context context) {
        super(context);
    }

    public VideoUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoUIButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.fullBackground = getContext().getResources().getDrawable(C1877R.drawable.video_ui_button_selector_full).mutate();
            this.halfBackground = getContext().getResources().getDrawable(C1877R.drawable.video_ui_button_selector_half).mutate();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            this.fullLayoutParams = layoutParams;
            layoutParams.width = UIConstants.BUTTON_SIZE_FULL;
            this.fullLayoutParams.height = UIConstants.BUTTON_SIZE_FULL;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fullLayoutParams);
            this.halfLayoutParams = layoutParams2;
            layoutParams2.width = UIConstants.BUTTON_SIZE_HALF;
            this.halfLayoutParams.height = UIConstants.BUTTON_SIZE_HALF;
        }
        updateSize();
    }

    public void init() {
        updateSize();
    }

    public void updateSize() {
        if (!isInEditMode() && this.halfLayoutParams != null) {
            MapView.getMapView().post(new Runnable() {
                public void run() {
                    if (UASToolDropDownReceiver.getInstance().isFullscreenVideo()) {
                        VideoUIButton videoUIButton = VideoUIButton.this;
                        videoUIButton.setBackground(videoUIButton.fullBackground);
                        VideoUIButton videoUIButton2 = VideoUIButton.this;
                        videoUIButton2.setLayoutParams(videoUIButton2.fullLayoutParams);
                    } else {
                        VideoUIButton videoUIButton3 = VideoUIButton.this;
                        videoUIButton3.setBackground(videoUIButton3.halfBackground);
                        VideoUIButton videoUIButton4 = VideoUIButton.this;
                        videoUIButton4.setLayoutParams(videoUIButton4.halfLayoutParams);
                    }
                    VideoUIButton.this.invalidate();
                }
            });
        }
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
        if (z) {
            setColorFilter(UIConstants.COLOR_DANGER, PorterDuff.Mode.MULTIPLY);
        } else {
            setColorFilter((ColorFilter) null);
        }
    }

    public static BitmapDrawable getButtonWithText(String str) {
        Bitmap decodeResource = BitmapFactory.decodeResource(UASToolDropDownReceiver.getInstance().getPluginContext().getResources(), C1877R.drawable.btn_buttonbar_template);
        Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth(), decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        String trim = str.trim();
        if (trim.length() > 4) {
            trim = trim.substring(0, 4);
        }
        int length = trim.length();
        if (length == 0 || length == 1) {
            paint.setTextSize(520.0f);
        } else if (length != 2) {
            if (length != 3) {
                paint.setTextSize(220.0f);
            } else {
                paint.setTextSize(320.0f);
            }
            paint.setARGB(255, 255, 255, 255);
            paint.setStyle(Paint.Style.FILL);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawBitmap(decodeResource, 0.0f, 0.0f, (Paint) null);
            Rect rect = new Rect();
            paint.getTextBounds(trim, 0, trim.length(), rect);
            canvas.drawText(trim, (float) (decodeResource.getWidth() / 2), (float) ((decodeResource.getHeight() / 2) + (rect.height() / 2)), paint);
            return new BitmapDrawable(createBitmap);
        }
        paint.setTextSize(420.0f);
        paint.setARGB(255, 255, 255, 255);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, (Paint) null);
        Rect rect2 = new Rect();
        paint.getTextBounds(trim, 0, trim.length(), rect2);
        canvas.drawText(trim, (float) (decodeResource.getWidth() / 2), (float) ((decodeResource.getHeight() / 2) + (rect2.height() / 2)), paint);
        return new BitmapDrawable(createBitmap);
    }
}
