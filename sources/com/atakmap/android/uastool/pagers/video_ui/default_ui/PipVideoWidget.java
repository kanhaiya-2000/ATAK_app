package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.math.PointD;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;
import java.io.File;

public class PipVideoWidget extends MovableWidget implements MpegStreamHandler.MpegStreamKLVListener, StatusUpdateConsumer {
    public static final String DEFAULT_UI_PIP_URI = "udp://0.0.0.0:5600";
    public static final String DEFAULT_UI_PIP_URI2 = "udp://0.0.0.0:5610";
    public static final String PREF_UI_PIP_URI = "uastool.pref_ui_pip_uri";
    public static final String PREF_UI_PIP_URI2 = "uastool.pref_ui_pip_uri2";
    public static final String TAG = "PipVideoWidget";
    /* access modifiers changed from: private */
    public RelativeLayout connectingLayout;
    /* access modifiers changed from: private */
    public RelativeLayout failedLayout;
    private boolean isInit = false;
    /* access modifiers changed from: private */
    public String lastUri;
    private ViewGroup mapViewViewGroup;
    /* access modifiers changed from: private */
    public ImageButton pipConfigureBtn;
    /* access modifiers changed from: private */
    public ImageButton pipDismissBtn;
    /* access modifiers changed from: private */
    public ImageView pipImageView;
    /* access modifiers changed from: private */
    public MpegStreamHandler pipPlayer;
    boolean pipPreviewActive = false;
    PointD pipPreviewParams = new PointD(0.0d, 0.0d);
    private Button pipReconnectBtn;
    private RelativeLayout pipVideoContainer;
    /* access modifiers changed from: private */
    public ViewGroup pipVideoView;

    public void aircraftAttitudeUpdate(double d, double d2, double d3) {
    }

    public void cornersUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
    }

    public void mediaStreamExtentsUpdate(long j, long j2) {
    }

    public void rawKLVUpdate(byte[] bArr, byte[] bArr2) {
    }

    public void sensorAttitudeUpdate(double d, double d2, double d3) {
    }

    public void sensorFovUpdate(double d, double d2) {
    }

    public void sensorLocationUpdate(double d, double d2, double d3, String str) {
    }

    public void sensorSpoiUpdate(double d, double d2, double d3, double d4) {
    }

    public PipVideoWidget(Context context) {
        super(context);
    }

    public PipVideoWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PipVideoWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "OnAttachedToWindow(), ", new Throwable());
        if (!isInEditMode()) {
            ViewGroup viewGroup = (ViewGroup) MapView.getMapView().getParent();
            this.mapViewViewGroup = viewGroup;
            viewGroup.getChildAt(0).setVisibility(8);
        }
        this.pipVideoContainer = (RelativeLayout) findViewById(C1877R.C1878id.pip_video_container);
        this.pipVideoView = (ViewGroup) findViewById(C1877R.C1878id.pip_video_screen);
        Button button = (Button) findViewById(C1877R.C1878id.pip_video_try_connect);
        this.pipReconnectBtn = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PipVideoWidget.this.reset();
            }
        });
        this.failedLayout = (RelativeLayout) findViewById(C1877R.C1878id.pip_failed);
        this.connectingLayout = (RelativeLayout) findViewById(C1877R.C1878id.pip_connecting);
        ViewGroup.LayoutParams layoutParams = this.pipVideoContainer.getLayoutParams();
        this.pipPreviewParams.y = (double) layoutParams.height;
        this.pipPreviewParams.x = (double) layoutParams.width;
        this.pipConfigureBtn = (ImageButton) findViewById(C1877R.C1878id.pip_video_configure);
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.pip_video_dismiss);
        this.pipDismissBtn = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
                edit.putBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, false);
                edit.commit();
                PipVideoWidget.this.setVisibility(4);
                PipVideoWidget.this.invalidate();
            }
        });
        this.pipConfigureBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View inflate = ((LayoutInflater) UASToolDropDownReceiver.getInstance().getPluginContext().getSystemService("layout_inflater")).inflate(C1877R.layout.video_ui_pip_video_config, (ViewGroup) null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setView(inflate);
                final EditText editText = (EditText) inflate.findViewById(C1877R.C1878id.video_ui_pip_video_uri);
                final SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
                editText.setText(sharedPrefs.getString(PipVideoWidget.PREF_UI_PIP_URI, PipVideoWidget.DEFAULT_UI_PIP_URI));
                builder.setTitle("Set PiP Video URI:");
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor edit = sharedPrefs.edit();
                        edit.putString(PipVideoWidget.PREF_UI_PIP_URI, editText.getText().toString().trim());
                        edit.commit();
                        dialogInterface.dismiss();
                        new Thread(new Runnable() {
                            public void run() {
                                if (PipVideoWidget.this.pipPreviewActive) {
                                    PipVideoWidget.this.stopPipPreview();
                                }
                                PipVideoWidget.this.enablePipPreview();
                            }
                        }).start();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
        setColor(0);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewGroup viewGroup;
        super.onDetachedFromWindow();
        stopPipPreview();
        if (!isInEditMode() && (viewGroup = this.mapViewViewGroup) != null) {
            viewGroup.getChildAt(0).setVisibility(0);
        }
    }

    public void mediaEOF() {
        Log.d(TAG, "mediaEOF()");
        this.pipPreviewActive = false;
        showScreen(ControlFragment.Screen.FAILED);
    }

    public void mediaFatalError(String str) {
        String str2 = TAG;
        Log.d(str2, "mediaFatalError(" + str + ")");
        this.pipPreviewActive = false;
        showScreen(ControlFragment.Screen.FAILED);
    }

    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (!PipVideoWidget.this.isFullScreen()) {
                        PipVideoWidget.this.setVisibility(4);
                    } else if (PipVideoWidget.this.videoUIView.isOSDVisible()) {
                        PipVideoWidget.this.setVisibility(0);
                    }
                    PipVideoWidget.this.invalidate();
                }
            });
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            showMap();
        } else {
            hideMap();
        }
    }

    private void showMap() {
        this.pipVideoView.setVisibility(0);
        enablePipPreview();
    }

    private void hideMap() {
        Log.d(TAG, "hideMap()");
        disablePipPreview();
        if (this.pipPlayer != null) {
            this.pipVideoView.setVisibility(8);
        }
    }

    private String getPrefKey() {
        return this instanceof PipVideoWidget2 ? PREF_UI_PIP_URI2 : PREF_UI_PIP_URI;
    }

    private String getPrefDef() {
        return this instanceof PipVideoWidget2 ? DEFAULT_UI_PIP_URI2 : DEFAULT_UI_PIP_URI;
    }

    /* access modifiers changed from: private */
    public void enablePipPreview() {
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        if (sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, false)) {
            String string = sharedPrefs.getString(getPrefKey(), getPrefDef());
            if (!FileSystemUtils.isEmpty(string)) {
                startPipPreview(string, (String) null);
                return;
            }
            disablePipPreview();
            setVisibility(8);
        }
    }

    private void disablePipPreview() {
        Log.d(TAG, "disablePipPreview()");
        new Thread(new Runnable() {
            public void run() {
                PipVideoWidget.this.stopPipPreview();
            }
        }).start();
    }

    public void startPipPreview(String str, String str2) {
        String str3 = TAG;
        Log.d(str3, "startPipPreview()");
        this.lastUri = str;
        if (getVisibility() != 0 || this.pipPreviewActive) {
            return;
        }
        if (str == null || str.isEmpty()) {
            Log.d(str3, "PIP Video Disabled");
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            int port = parse.getPort();
            ImageView imageView = this.pipImageView;
            if (imageView != null) {
                this.pipVideoView.removeView(imageView);
            }
            ImageView imageView2 = new ImageView(UASToolDropDownReceiver.getInstance().getPluginContext());
            this.pipImageView = imageView2;
            imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (scheme != null) {
                if (!scheme.equals("")) {
                    if (!scheme.equalsIgnoreCase("rtp")) {
                        if (!scheme.equalsIgnoreCase("265")) {
                            if (!scheme.equalsIgnoreCase("264")) {
                                if (scheme.equalsIgnoreCase("rtsp")) {
                                    this.pipPlayer = new MpegStreamHandler(str, this.pipImageView);
                                } else if (scheme.equalsIgnoreCase("udp")) {
                                    if (str2 != null && !"System Default".equals(str2)) {
                                        if (!str2.isEmpty()) {
                                            this.pipPlayer = new MpegStreamHandler(host, port, this.pipImageView, str2);
                                        }
                                    }
                                    this.pipPlayer = new MpegStreamHandler(host, port, this.pipImageView);
                                } else if (scheme.equalsIgnoreCase("http")) {
                                    this.pipPlayer = new MpegStreamHandler(str, this.pipImageView);
                                }
                                this.pipVideoView.addView(this.pipImageView);
                                new Thread(new Runnable() {
                                    public void run() {
                                        try {
                                            PipVideoWidget.this.pipPlayer.setMpegStreamKLVListener(PipVideoWidget.this);
                                            PipVideoWidget.this.pipPlayer.setStatusUpdateConsumer(PipVideoWidget.this);
                                            PipVideoWidget.this.pipPlayer.start();
                                            PipVideoWidget.this.pipPreviewActive = true;
                                            PipVideoWidget.this.showScreen(ControlFragment.Screen.CONNECTING);
                                        } catch (Exception unused) {
                                            PipVideoWidget.this.showScreen(ControlFragment.Screen.FAILED);
                                            PipVideoWidget.this.pipPreviewActive = false;
                                            PipVideoWidget.this.pipVideoView.removeView(PipVideoWidget.this.pipImageView);
                                        }
                                    }
                                }).start();
                            }
                        }
                        File createSDPFile = Reflector.createSDPFile(host, port, "atak/uas/sdp_pip", scheme);
                        if (createSDPFile != null) {
                            this.pipPlayer = new MpegStreamHandler(createSDPFile, this.pipImageView);
                        }
                        this.pipVideoView.addView(this.pipImageView);
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    PipVideoWidget.this.pipPlayer.setMpegStreamKLVListener(PipVideoWidget.this);
                                    PipVideoWidget.this.pipPlayer.setStatusUpdateConsumer(PipVideoWidget.this);
                                    PipVideoWidget.this.pipPlayer.start();
                                    PipVideoWidget.this.pipPreviewActive = true;
                                    PipVideoWidget.this.showScreen(ControlFragment.Screen.CONNECTING);
                                } catch (Exception unused) {
                                    PipVideoWidget.this.showScreen(ControlFragment.Screen.FAILED);
                                    PipVideoWidget.this.pipPreviewActive = false;
                                    PipVideoWidget.this.pipVideoView.removeView(PipVideoWidget.this.pipImageView);
                                }
                            }
                        }).start();
                    }
                }
            }
            File createSDPFile2 = Reflector.createSDPFile(host, port, "atak/uas/sdp_pip", "264");
            if (createSDPFile2 != null) {
                this.pipPlayer = new MpegStreamHandler(createSDPFile2, this.pipImageView);
            }
            this.pipVideoView.addView(this.pipImageView);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        PipVideoWidget.this.pipPlayer.setMpegStreamKLVListener(PipVideoWidget.this);
                        PipVideoWidget.this.pipPlayer.setStatusUpdateConsumer(PipVideoWidget.this);
                        PipVideoWidget.this.pipPlayer.start();
                        PipVideoWidget.this.pipPreviewActive = true;
                        PipVideoWidget.this.showScreen(ControlFragment.Screen.CONNECTING);
                    } catch (Exception unused) {
                        PipVideoWidget.this.showScreen(ControlFragment.Screen.FAILED);
                        PipVideoWidget.this.pipPreviewActive = false;
                        PipVideoWidget.this.pipVideoView.removeView(PipVideoWidget.this.pipImageView);
                    }
                }
            }).start();
        } catch (Exception e) {
            Log.e(TAG, "Could not start pip Player", e);
        }
    }

    public void stopPipPreview() {
        Log.d(TAG, "stopPipPreview()");
        try {
            MpegStreamHandler mpegStreamHandler = this.pipPlayer;
            if (mpegStreamHandler != null && this.pipPreviewActive) {
                mpegStreamHandler.stop();
                this.pipPlayer.setMpegStreamKLVListener((MpegStreamHandler.MpegStreamKLVListener) null);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error Stopping pipPreview", e);
        }
        showScreen(ControlFragment.Screen.FAILED);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (PipVideoWidget.this.pipImageView != null) {
                    PipVideoWidget.this.pipVideoView.removeView(PipVideoWidget.this.pipImageView);
                }
                ImageView unused = PipVideoWidget.this.pipImageView = null;
                PipVideoWidget.this.pipPreviewActive = false;
            }
        });
    }

    public void streamStartupFailed() {
        showScreen(ControlFragment.Screen.FAILED);
        this.pipPreviewActive = false;
    }

    public void streamStarted() {
        showScreen(ControlFragment.Screen.VIDEO);
    }

    public void reset() {
        if (this.pipPreviewActive) {
            stopPipPreview();
        } else {
            enablePipPreview();
        }
    }

    public void showScreen(final ControlFragment.Screen screen) {
        String str = TAG;
        Log.d(str, "Screen: " + screen.toString());
        MapView.getMapView().post(new Runnable() {
            public void run() {
                TextView textView = (TextView) PipVideoWidget.this.findViewById(C1877R.C1878id.pip_failed_text);
                TextView textView2 = (TextView) PipVideoWidget.this.findViewById(C1877R.C1878id.pip_progress);
                String access$400 = PipVideoWidget.this.lastUri;
                Context pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
                int i = C17979.f8405x7c048095[screen.ordinal()];
                if (i == 1) {
                    PipVideoWidget.this.connectingLayout.setVisibility(0);
                    PipVideoWidget.this.failedLayout.setVisibility(8);
                    if (access$400 != null) {
                        textView2.setText(access$400);
                    } else {
                        textView2.setText(pluginContext.getResources().getString(C1877R.string.connecting));
                    }
                    PipVideoWidget.this.connectingLayout.bringToFront();
                } else if (i == 2) {
                    PipVideoWidget.this.connectingLayout.setVisibility(8);
                    PipVideoWidget.this.failedLayout.setVisibility(8);
                    PipVideoWidget.this.pipConfigureBtn.bringToFront();
                    PipVideoWidget.this.pipDismissBtn.bringToFront();
                } else if (i == 3) {
                    PipVideoWidget.this.connectingLayout.setVisibility(8);
                    PipVideoWidget.this.failedLayout.setVisibility(0);
                    if (access$400 == null || access$400.isEmpty()) {
                        textView.setText(pluginContext.getResources().getString(C1877R.string.video_not_broadcast));
                    } else {
                        textView.setText(pluginContext.getResources().getString(C1877R.string.lost_connection));
                    }
                    PipVideoWidget.this.failedLayout.bringToFront();
                }
            }
        });
    }

    /* renamed from: com.atakmap.android.uastool.pagers.video_ui.default_ui.PipVideoWidget$9 */
    /* synthetic */ class C17979 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$ControlFragment$Screen */
        static final /* synthetic */ int[] f8405x7c048095;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.pagers.ControlFragment$Screen[] r0 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8405x7c048095 = r0
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8405x7c048095     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8405x7c048095     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.ControlFragment$Screen r1 = com.atakmap.android.uastool.pagers.ControlFragment.Screen.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.video_ui.default_ui.PipVideoWidget.C17979.<clinit>():void");
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        this.isInit = true;
    }
}
