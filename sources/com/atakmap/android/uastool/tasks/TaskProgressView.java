package com.atakmap.android.uastool.tasks;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskProgressBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskProgressListener;
import com.atakmap.android.uastool.plugin.C1877R;

public class TaskProgressView extends RelativeLayout implements TaskProgressListener {
    private TextView aboveText;
    private TextView belowText;
    /* access modifiers changed from: private */
    public TaskProgressBar progressBar;
    private TEXTMODE textMode;

    public enum TEXTMODE {
        NONE,
        ABOVE,
        BELOW
    }

    public TaskProgressView(Context context) {
        super(context);
    }

    public TaskProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TaskProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.aboveText = (TextView) findViewById(C1877R.C1878id.taskprogress_above_text);
        this.progressBar = (TaskProgressBar) findViewById(C1877R.C1878id.taskprogress_progressbar);
        this.belowText = (TextView) findViewById(C1877R.C1878id.taskprogress_below_text);
    }

    /* renamed from: com.atakmap.android.uastool.tasks.TaskProgressView$8 */
    /* synthetic */ class C21038 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$TaskProgressView$TEXTMODE */
        static final /* synthetic */ int[] f8412x1082c0a5;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.tasks.TaskProgressView$TEXTMODE[] r0 = com.atakmap.android.uastool.tasks.TaskProgressView.TEXTMODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8412x1082c0a5 = r0
                com.atakmap.android.uastool.tasks.TaskProgressView$TEXTMODE r1 = com.atakmap.android.uastool.tasks.TaskProgressView.TEXTMODE.ABOVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8412x1082c0a5     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.TaskProgressView$TEXTMODE r1 = com.atakmap.android.uastool.tasks.TaskProgressView.TEXTMODE.BELOW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.TaskProgressView.C21038.<clinit>():void");
        }
    }

    public void setTextMode(TEXTMODE textmode) {
        this.textMode = textmode;
        int i = C21038.f8412x1082c0a5[textmode.ordinal()];
        if (i == 1) {
            this.aboveText.setVisibility(0);
            this.belowText.setVisibility(8);
        } else if (i != 2) {
            this.aboveText.setVisibility(8);
            this.belowText.setVisibility(8);
        } else {
            this.aboveText.setVisibility(8);
            this.belowText.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void setText(String str) {
        int i = C21038.f8412x1082c0a5[this.textMode.ordinal()];
        if (i == 1) {
            this.aboveText.setText(str);
        } else if (i == 2) {
            this.belowText.setText(str);
        }
    }

    public void taskPrepared(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setStageCnt(i);
                TaskProgressView.this.progressBar.setProgress(0);
                TaskProgressView.this.setText(str);
                TaskProgressView.this.setVisibility(0);
                TaskProgressView.this.bringToFront();
            }
        });
    }

    public void taskStarted(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.setText(str);
            }
        });
    }

    public void taskRefused(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setProgress(0);
                TaskProgressView.this.setText(str);
            }
        });
    }

    public void taskStageStarted(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setStageProgress(i, 0);
                TaskProgressView taskProgressView = TaskProgressView.this;
                taskProgressView.setText(i + "/" + TaskProgressView.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskStageUpdate(final int i, final int i2, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setStageProgress(i, i2);
                TaskProgressView taskProgressView = TaskProgressView.this;
                taskProgressView.setText(i + "/" + TaskProgressView.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskStageCompleted(final int i, final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setStageProgress(i, 100);
                TaskProgressView taskProgressView = TaskProgressView.this;
                taskProgressView.setText(i + "/" + TaskProgressView.this.progressBar.getStageCnt() + ":  " + str);
            }
        });
    }

    public void taskFinished(final String str) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TaskProgressView.this.progressBar.setProgress(100);
                TaskProgressView.this.setText(str);
                TaskProgressView.this.setVisibility(8);
            }
        });
    }
}
