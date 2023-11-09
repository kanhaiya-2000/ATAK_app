package com.atakmap.android.uastool.pagers.observer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.video.b;
import com.atakmap.android.video.d;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.partech.mobilevid.SharedGLSurfaceView;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;
import java.util.concurrent.TimeUnit;

public class ObserverControlFragment extends ControlFragment implements StatusUpdateConsumer {
    /* access modifiers changed from: private */
    public static final String TAG = "ObserverControlFragment";
    /* access modifiers changed from: private */
    public ObserverFmvComponent fmvComponent = null;

    public void mediaStreamExtentsUpdate(long j, long j2) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.observer_control_layout, (ViewGroup) null);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.observer_main_layout);
        this.failedLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.failed);
        this.connectingLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.connecting);
        this.videoDisconnectOverlay = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.video_disconnect_overlay);
        showScreen(ControlFragment.Screen.CONNECTING);
        this.videoReconnectBtn = (Button) this.layoutView.findViewById(C1877R.C1878id.video_try_connect);
        this.videoReconnectBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ObserverControlFragment.this.gotUASConnection();
            }
        });
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.dispose();
        }
        ObserverFmvComponent observerFmvComponent2 = (ObserverFmvComponent) this.layoutView.findViewById(C1877R.C1878id.ImageView01);
        this.fmvComponent = observerFmvComponent2;
        observerFmvComponent2.setStatusUpdateConsumer(this);
        this.fmvComponent.registerMapView(MapView.getMapView());
        this.arOverlayView = (ArOverlayView) this.layoutView.findViewById(C1877R.C1878id.ar_overlay_view);
        this.arOverlayView.setIsOperator(false);
        this.uiLayout = (RelativeLayout) this.layoutView.findViewById(C1877R.C1878id.ui_layout);
        return this.layoutView;
    }

    public void pause() {
        Log.d(TAG, "Pause called");
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.pause();
        }
    }

    public void resume() {
        Log.d(TAG, "Resume called");
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.resume();
        }
    }

    public void onDestroyView() {
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.destroyConnection();
        }
        if (this.osdScheduler != null) {
            this.osdScheduler.shutdownNow();
        }
        super.onDestroyView();
    }

    public void setParentPager(UASToolPager uASToolPager) {
        this.parentPager = uASToolPager;
    }

    public void callsignChanged(String str) {
        updateArCallsign();
    }

    public void gotUASConnection() {
        super.gotUASConnection();
        startPreview();
    }

    public void lostUASConnection() {
        super.lostUASConnection();
        showScreen(ControlFragment.Screen.FAILED);
    }

    private void startPreview() {
        startOSD();
        if (this.selectedUASItem != null) {
            final String videoUrl = this.selectedUASItem.getVideoUrl();
            new Thread() {
                public void run() {
                    String str = videoUrl;
                    if (str != null && !str.isEmpty()) {
                        ObserverControlFragment.this.showScreen(ControlFragment.Screen.CONNECTING);
                        b a = d.a(ObserverControlFragment.this.selectedUASItem.getCallsign(), videoUrl);
                        if (a != null) {
                            a.b(ObserverControlFragment.this.selectedUASItem.getUid());
                            a.c(20000);
                            a.e(1);
                            if (ObserverControlFragment.this.fmvComponent.load(a)) {
                                ObserverControlFragment.this.fmvComponent.setUASItem(ObserverControlFragment.this.selectedUASItem);
                                ObserverControlFragment.this.showScreen(ControlFragment.Screen.VIDEO);
                                ObserverControlFragment.this.fmvComponent.resume();
                                return;
                            }
                            ObserverControlFragment.this.showScreen(ControlFragment.Screen.FAILED);
                        }
                    }
                }
            }.start();
        }
    }

    public void stopPreview() {
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.destroyConnection();
        }
        stopOSD();
        lostUASConnection();
    }

    private void updateArCallsign() {
        if (this.selectedUASItem != null) {
            UASToolDropDownReceiver.getInstance().getObserverArOverlay().setDroneCallsign(this.selectedUASItem.getCallsign());
        }
    }

    /* access modifiers changed from: protected */
    public void startOSD() {
        this.osdSchedulerHandle = this.osdScheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    if (ObserverControlFragment.this.fmvComponent == null || ObserverControlFragment.this.selectedUASItem == null || ObserverControlFragment.this.videoUI == null || !ObserverControlFragment.this.videoUI.isOSDVisible()) {
                        Log.d(ObserverControlFragment.TAG, "Unable to update OSD - preview or reflector is null");
                    } else {
                        ObserverControlFragment.this.videoUI.updateOSD();
                    }
                } catch (Exception e) {
                    Log.d(ObserverControlFragment.TAG, "OSD Scheduler Exception: ", e);
                }
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    public void stopOSD() {
        if (this.osdSchedulerHandle != null) {
            this.osdSchedulerHandle.cancel(false);
            this.osdSchedulerHandle = null;
        }
    }

    public void setUASItem(UASItem uASItem) {
        if (uASItem != null) {
            if (this.selectedUASItem != null && !this.selectedUASItem.equals(uASItem)) {
                stopPreview();
            }
            super.setUASItem(uASItem);
            updateArCallsign();
            return;
        }
        UASToolDropDownReceiver.toast("UAS not connected or selected", 1);
    }

    public boolean onBackPressed() {
        if (!UASToolDropDownReceiver.getInstance().isFullscreenVideo()) {
            return super.onBackPressed();
        }
        UASToolDropDownReceiver.getInstance().resizeHalf();
        return true;
    }

    public void setCurrentRemoteTask(String str) {
        this.selectedUASItem.currentRemoteTask = str;
    }

    public void handleWaitingTasks(CotEvent cotEvent) {
        String uid = cotEvent.getUID();
        TaskResponse.RESPONSETYPE fromValue = TaskResponse.RESPONSETYPE.fromValue(cotEvent.getType());
        if (this.selectedUASItem.waitingForLtclcTaskResponse == null || !this.selectedUASItem.waitingForLtclcTaskResponse.equals(uid)) {
            switch (C16414.f8399x31ef10e1[fromValue.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    if (this.selectedUASItem.currentRemoteTask != null && this.selectedUASItem.currentRemoteTask.equals(uid)) {
                        UASToolDropDownReceiver.toast("TASK ENDED BY OPERATOR " + this.selectedUASItem.currentRemoteTask);
                        this.selectedUASItem.currentRemoteTask = null;
                        this.selectedUASItem.setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
                        return;
                    } else if (this.selectedUASItem.currentLtclcTask != null && this.selectedUASItem.currentLtclcTask.equals(uid)) {
                        this.selectedUASItem.currentLtclcTask = null;
                        onGimbalControlChanged(false);
                        this.selectedUASItem.currentRemoteTask = null;
                        this.selectedUASItem.setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
                        UASToolDropDownReceiver.toast("Gimbal Control disabled", 1);
                        return;
                    } else {
                        return;
                    }
                case 4:
                    UASToolDropDownReceiver.toast("Operator is executing task");
                    return;
                case 5:
                    UASToolDropDownReceiver.toast("Operator is holding task");
                    return;
                case 6:
                    UASToolDropDownReceiver.toast("Operator has accepted task");
                    return;
                case 7:
                    UASToolDropDownReceiver.toast("Operator has received task");
                    return;
                default:
                    UASToolDropDownReceiver.toast("Received unknown task response");
                    return;
            }
        } else {
            switch (C16414.f8399x31ef10e1[fromValue.ordinal()]) {
                case 1:
                    this.selectedUASItem.waitingForLtclcTaskResponse = null;
                    onGimbalControlChanged(false);
                    UASToolDropDownReceiver.toast("Operator completed task successfully");
                    return;
                case 2:
                    this.selectedUASItem.waitingForLtclcTaskResponse = null;
                    this.selectedUASItem.currentLtclcTask = null;
                    onGimbalControlChanged(false);
                    UASToolDropDownReceiver.toast("Operator denied task");
                    return;
                case 3:
                    this.selectedUASItem.waitingForLtclcTaskResponse = null;
                    this.selectedUASItem.currentLtclcTask = null;
                    onGimbalControlChanged(false);
                    if (cotEvent.getUID().equals(this.selectedUASItem.currentLtclcTask)) {
                        UASToolDropDownReceiver.toast("Running quickstop");
                        this.selectedUASItem.quickStop();
                        return;
                    }
                    UASToolDropDownReceiver.toast("Operator cancelled task");
                    onGimbalControlChanged(false);
                    return;
                case 4:
                    this.selectedUASItem.waitingForLtclcTaskResponse = null;
                    onGimbalControlChanged(true);
                    this.selectedUASItem.currentLtclcTask = uid;
                    UASToolDropDownReceiver.toast("Gimbal Control enabled, tap video or long-press on SPI to move gimbal", 1);
                    UASToolDropDownReceiver.onObserverUasItemStatusChanged();
                    return;
                case 5:
                    UASToolDropDownReceiver.toast("Operator is holding task");
                    return;
                case 6:
                    UASToolDropDownReceiver.toast("Operator has accepted task");
                    return;
                case 7:
                    UASToolDropDownReceiver.toast("Operator has received task");
                    return;
                default:
                    UASToolDropDownReceiver.toast("Received unknown task response");
                    return;
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.observer.ObserverControlFragment$4 */
    /* synthetic */ class C16414 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$TaskResponse$RESPONSETYPE */
        static final /* synthetic */ int[] f8399x31ef10e1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE[] r0 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8399x31ef10e1 = r0
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.DENIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.CANCELLED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.EXECUTING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.HOLDING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.ACCEPTED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8399x31ef10e1     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.tasks.TaskResponse$RESPONSETYPE r1 = com.atakmap.android.uastool.tasks.TaskResponse.RESPONSETYPE.DELIVERYRECEIPT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.observer.ObserverControlFragment.C16414.<clinit>():void");
        }
    }

    public void onPageSelected() {
        super.onPageSelected();
    }

    public void mediaEOF() {
        Log.d(TAG, "End of media");
        stopPreview();
    }

    public void mediaFatalError(String str) {
        String str2 = TAG;
        Log.e(str2, "Error decoding media: " + str);
        stopPreview();
    }

    public void resizeFull() {
        this.fmvComponent.setVisibility(4);
        this.fmvComponent.setVisibility(0);
        super.resizeFull();
    }

    public void resizeHalf() {
        super.resizeHalf();
    }

    public ObserverFmvComponent getFmvComponent() {
        return this.fmvComponent;
    }

    public Bitmap getPreviewSnapshot(boolean z, boolean z2) {
        int i;
        int i2;
        Bitmap bitmap;
        int i3;
        Bitmap bitmap2;
        SharedGLSurfaceView findViewById = this.mainView.findViewById(C1877R.C1878id.video_glsurface);
        if (findViewById == null) {
            UASToolDropDownReceiver.toast("Mapshot failed: missing preview window.", 1);
        } else if (findViewById.getSourceWidth() > 0 && findViewById.getSourceHeight() > 0) {
            Bitmap bitmap3 = findViewById.getBitmap();
            if (!z && !z2) {
                return bitmap3;
            }
            int width = bitmap3.getWidth();
            int height = bitmap3.getHeight();
            int i4 = 0;
            if (z2) {
                bitmap = UASToolDropDownReceiver.loadBitmapFromView(getArOverlay());
                i2 = bitmap.getWidth();
                i = bitmap.getHeight();
            } else {
                bitmap = null;
                i2 = 0;
                i = 0;
            }
            if (z) {
                Bitmap bitmap4 = getVideoUI().getBitmap();
                int width2 = bitmap4.getWidth();
                i3 = bitmap4.getHeight();
                int i5 = width2;
                bitmap2 = bitmap4;
                i4 = i5;
            } else {
                bitmap2 = null;
                i3 = 0;
            }
            int max = Math.max(i4, Math.max(i2, width));
            int max2 = Math.max(i3, Math.max(i, width));
            Bitmap createBitmap = Bitmap.createBitmap(max, max2, bitmap3.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap3, width < max ? ((float) (max - width)) * 0.5f : 0.0f, height < max2 ? ((float) (max2 - height)) * 0.5f : 0.0f, (Paint) null);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, i2 < max ? ((float) (max - i2)) * 0.5f : 0.0f, i < max2 ? ((float) (max2 - i)) * 0.5f : 0.0f, (Paint) null);
            }
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, i4 < max ? ((float) (max - i4)) * 0.5f : 0.0f, i3 < max2 ? ((float) (max2 - i3)) * 0.5f : 0.0f, (Paint) null);
            }
            return createBitmap;
        }
        return null;
    }

    public void setShowing(boolean z) {
        ObserverFmvComponent observerFmvComponent = this.fmvComponent;
        if (observerFmvComponent != null) {
            observerFmvComponent.setShowing(z);
        }
    }

    public void startObserving() {
        showScreen(ControlFragment.Screen.CONNECTING);
        setShowing(true);
        gotUASConnection();
    }

    public void stopObserving() {
        setShowing(false);
        stopPreview();
    }

    public boolean previewSnapshotReady() {
        SharedGLSurfaceView findViewById = this.mainView.findViewById(C1877R.C1878id.video_glsurface);
        return findViewById != null && findViewById.getSourceWidth() > 0 && findViewById.getSourceHeight() > 0;
    }
}
