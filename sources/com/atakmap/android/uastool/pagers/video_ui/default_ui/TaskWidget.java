package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class TaskWidget extends MovableWidget implements TaskProgressListener {
    public static final String TAG = "TaskWidget";
    /* access modifiers changed from: private */
    public TextView aboveText;
    /* access modifiers changed from: private */
    public TextView belowText;
    /* access modifiers changed from: private */
    public TaskProgressBar progressBar;
    /* access modifiers changed from: private */
    public TEXTMODE textMode;

    public enum TEXTMODE {
        NONE,
        ABOVE,
        BELOW
    }

    public TaskWidget(Context context) {
        super(context);
    }

    public TaskWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.halfLayoutParams.width = (int) (((float) this.fullLayoutParams.width) * 1.0f);
        }
        this.aboveText = (TextView) findViewById(C1877R.C1878id.taskprogress_above_text);
        this.progressBar = (TaskProgressBar) findViewById(C1877R.C1878id.taskprogress_progressbar);
        this.belowText = (TextView) findViewById(C1877R.C1878id.taskprogress_below_text);
        setTextMode(TEXTMODE.NONE);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.uasItem != null && this.uasItem.supportsTaskProgress()) {
            this.uasItem.removeTaskListener(this);
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        if (uASItem.supportsTaskProgress()) {
            uASItem.addTaskListener(this);
            setTextMode(TEXTMODE.ABOVE);
        }
    }

    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (TaskWidget.this.isFullScreen()) {
                        TaskWidget.this.setTextMode(TEXTMODE.ABOVE);
                        TaskWidget.this.progressBar.setBarHeight(16);
                        TaskWidget.this.aboveText.setTextSize(12.0f);
                        TaskWidget.this.belowText.setTextSize(12.0f);
                        TaskWidget taskWidget = TaskWidget.this;
                        taskWidget.setPadding(taskWidget.fullStartPad, TaskWidget.this.fullTopPad, TaskWidget.this.fullEndPad, TaskWidget.this.fullBottomPad);
                    } else {
                        TaskWidget.this.setTextMode(TEXTMODE.NONE);
                        TaskWidget.this.progressBar.setBarHeight(14);
                        TaskWidget.this.aboveText.setTextSize(10.0f);
                        TaskWidget.this.belowText.setTextSize(10.0f);
                        TaskWidget.this.setPadding(UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF);
                    }
                    TaskWidget.this.invalidate();
                }
            });
        }
    }

    public void setVisibility(int i) {
        if (this.uasItem == null || !this.uasItem.supportsTaskProgress() || this.uasItem.getCurrentTask() == null) {
            super.setVisibility(8);
        } else {
            super.setVisibility(i);
        }
    }

    public void setTextMode(final TEXTMODE textmode) {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    TEXTMODE unused = TaskWidget.this.textMode = textmode;
                    int i = C181411.f8406xd7854d53[TaskWidget.this.textMode.ordinal()];
                    if (i == 1) {
                        TaskWidget.this.aboveText.setVisibility(0);
                        TaskWidget.this.belowText.setVisibility(8);
                    } else if (i != 2) {
                        TaskWidget.this.aboveText.setVisibility(8);
                        TaskWidget.this.belowText.setVisibility(8);
                    } else {
                        TaskWidget.this.aboveText.setVisibility(8);
                        TaskWidget.this.belowText.setVisibility(0);
                    }
                }
            });
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget$11 */
    /* synthetic */ class C181411 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$video_ui$default_ui$TaskWidget$TEXTMODE */
        static final /* synthetic */ int[] f8406xd7854d53;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget$TEXTMODE[] r0 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget.TEXTMODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8406xd7854d53 = r0
                com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget$TEXTMODE r1 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget.TEXTMODE.ABOVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8406xd7854d53     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget$TEXTMODE r1 = com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget.TEXTMODE.BELOW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskWidget.C181411.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void setText(final String str) {
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    int i = C181411.f8406xd7854d53[TaskWidget.this.textMode.ordinal()];
                    if (i == 1) {
                        TaskWidget.this.aboveText.setText(str);
                    } else if (i == 2) {
                        TaskWidget.this.belowText.setText(str);
                    }
                }
            });
        }
    }

    public void taskPrepared(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setStageCnt(i);
                TaskWidget.this.progressBar.setProgress(0);
                TaskWidget.this.setText(str);
                TaskWidget.this.setVisibility(0);
                TaskWidget.this.bringToFront();
            }
        });
    }

    public void taskStarted(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.setText(str);
            }
        });
    }

    public void taskRefused(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setProgress(0);
                TaskWidget.this.setText(str);
                TaskWidget.this.setVisibility(8);
            }
        });
    }

    public void taskStageStarted(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setStageProgress(i, 0);
                TaskWidget taskWidget = TaskWidget.this;
                taskWidget.setText(i + "/" + TaskWidget.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskStageUpdate(final int i, final int i2, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setStageProgress(i, i2);
                TaskWidget taskWidget = TaskWidget.this;
                taskWidget.setText(i + "/" + TaskWidget.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskStageCompleted(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setStageProgress(i, 100);
                TaskWidget taskWidget = TaskWidget.this;
                taskWidget.setText(i + "/" + TaskWidget.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskFinished(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskWidget.this.progressBar.setProgress(100);
                TaskWidget.this.setText(str);
                TaskWidget.this.setVisibility(8);
            }
        });
    }
}
