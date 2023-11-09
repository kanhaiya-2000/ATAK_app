package com.atakmap.android.uastool.pagers.observer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.widget.FrameLayout;
import com.atakmap.android.importexport.b;
import com.atakmap.android.importexport.y;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.aw;
import com.atakmap.android.maps.e;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.UASItemUtils;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.conversion.EGM96;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.partech.mobilevid.SharedGLSurfaceView;
import com.partech.mobilevid.SurfaceVideoConsumer;
import com.partech.mobilevid.e;
import com.partech.pgscmedia.MediaException;
import com.partech.pgscmedia.MediaFormat;
import com.partech.pgscmedia.MediaProcessor;
import com.partech.pgscmedia.VideoMediaFormat;
import com.partech.pgscmedia.consumers.KLVConsumer;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;
import com.partech.pgscmedia.frameaccess.MediaMetadataDecoder;
import indago.serialization.JsonValueConstants;
import java.io.File;

public class ObserverFmvComponent extends FrameLayout implements KLVConsumer {
    private static final long METADATA_TIME_GUARD = 200;
    private static final String TAG = "FmvComponent";
    private static final String TEMP_DIR = ("tools" + File.separatorChar + "videotmp");
    private e assoc = null;
    private double corner1lat;
    private double corner1lon;
    private double corner2lat;
    private double corner2lon;
    private double corner3lat;
    private double corner3lon;
    private double corner4lat;
    private double corner4lon;
    private StatusUpdateConsumer currentStatusConsumer = null;
    private boolean fileBased = false;
    private aw fourCornersPolygon = null;
    private double frameElevation;
    private double frameHAE;
    private double frameLatitude;
    private double frameLongitude;
    private ao frameMarker = null;
    /* access modifiers changed from: private */
    public SharedGLSurfaceView glView;
    protected b mCotEventMarshal;
    /* access modifiers changed from: private */
    public MapView mapView;
    private MediaMetadataDecoder metadataDecoder;
    private String platformDesignator = null;
    private double platformHeadingAngle;
    private double platformPitchAngle;
    private String platformTail = null;
    /* access modifiers changed from: private */
    public MediaProcessor processor;
    private final Object processorLock = new Object();
    protected UASItem selectedUASItem;
    private double sensorAltitude;
    private double sensorEllipsoidHeight;
    private double sensorHFOV;
    private double sensorLatitude;
    private double sensorLongitude;
    private ao sensorMarker = null;
    private double sensorRelativeAzimuth;
    private double sensorRelativeElevation;
    private double sensorRoll;
    private double sensorVFOV;
    /* access modifiers changed from: private */
    public Surface sourceSurface;
    private final Object surfaceLock = new Object();
    /* access modifiers changed from: private */
    public SurfaceVideoConsumer surfaceVideoConsumer;
    private File tmpDir;

    public void dispose() {
    }

    static {
        try {
            MediaProcessor.PGSCMediaInit(MapView.getMapView().getContext().getApplicationContext());
        } catch (MediaException e) {
            Log.e(TAG, "Error when initializing native components for video player", e);
            throw new RuntimeException(e);
        }
    }

    public ObserverFmvComponent(Context context) {
        super(context);
        init(context);
    }

    public ObserverFmvComponent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ObserverFmvComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(C1877R.layout.observer_video, this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        SurfaceVideoConsumer surfaceVideoConsumer2 = new SurfaceVideoConsumer();
        this.surfaceVideoConsumer = surfaceVideoConsumer2;
        surfaceVideoConsumer2.a(new SurfaceVideoConsumer.b() {
            /* renamed from: a */
            public void mo9282a(final int i, final int i2) {
                ObserverFmvComponent.this.mapView.post(new Runnable() {
                    public void run() {
                        ObserverFmvComponent.this.glView.a(i, i2);
                    }
                });
            }
        });
        SharedGLSurfaceView findViewById = findViewById(C1877R.C1878id.video_glsurface);
        this.glView = findViewById;
        findViewById.setVisibility(8);
        this.glView.a(new e.a() {
            /* renamed from: a */
            public void mo9284a() {
            }

            /* renamed from: a */
            public void mo9286a(String str) {
            }

            /* renamed from: a */
            public void mo9285a(SurfaceTexture surfaceTexture) {
                ObserverFmvComponent.this.changeOutput(surfaceTexture);
                ObserverFmvComponent.this.surfaceVideoConsumer.a(ObserverFmvComponent.this.sourceSurface);
                if (ObserverFmvComponent.this.processor != null && !ObserverFmvComponent.this.processor.isProcessing()) {
                    ObserverFmvComponent.this.processor.prefetch();
                }
            }
        });
        this.glView.setYUV(true);
    }

    /* access modifiers changed from: private */
    public void changeOutput(SurfaceTexture surfaceTexture) {
        synchronized (this.surfaceLock) {
            Surface surface = this.sourceSurface;
            if (surface != null) {
                surface.release();
            }
            this.sourceSurface = new Surface(surfaceTexture);
        }
    }

    public void setShowing(boolean z) {
        Log.v(TAG, "Notified that this component is visible: " + z);
        if (z) {
            this.glView.onResume();
            this.glView.setVisibility(0);
            return;
        }
        this.glView.onPause();
        this.glView.setVisibility(8);
    }

    public void registerMapView(MapView mapView2) {
        this.mapView = mapView2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|(2:16|17)|18|19|(1:21)) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b9, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00bc, code lost:
        setupTmpDir();
        r2 = com.atakmap.android.video.b.b(r14);
        com.atakmap.coremap.log.Log.v(TAG, "Create processor for URL: addr = " + r2 + " tmpDir = " + r13.tmpDir);
        r13.processor = new com.partech.pgscmedia.MediaProcessor(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01d4, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        com.atakmap.coremap.log.Log.d(TAG, "invalid file", r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01dd, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r4 = r13.processor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01e0, code lost:
        if (r4 == null) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r5 = r13.currentStatusConsumer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e6, code lost:
        if (r5 != null) goto L_0x01e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e8, code lost:
        r4.setStatusUpdateConsumer(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01eb, code lost:
        r4 = r13.processor.getTrackInfo();
        r5 = r4.length;
        r6 = 0;
        r7 = false;
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01f5, code lost:
        if (r6 < r5) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01f7, code lost:
        r9 = r4[r6];
        com.atakmap.coremap.log.Log.d(TAG, "discovered track: " + r9.type);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0219, code lost:
        setupVideo(r9);
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x022e, code lost:
        setupKLV(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0231, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0232, code lost:
        if (r8 == false) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0237, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x023a, code lost:
        if (r7 != false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x023d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r13.processor.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0243, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0247, code lost:
        r14 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r2 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00ac */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2 A[Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023c A[SYNTHETIC, Splitter:B:81:0x023c] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x023e A[SYNTHETIC, Splitter:B:84:0x023e] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0247 A[ExcHandler: MediaException (e com.partech.pgscmedia.MediaException), Splitter:B:5:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean load(com.atakmap.android.video.b r14) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.processorLock
            monitor-enter(r0)
            r13.destroyConnection()     // Catch:{ all -> 0x0251 }
            r1 = 0
            r13.fileBased = r1     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int[] r2 = com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent.C16475.$SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.android.video.b$a r3 = r14.j()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r3 = r3.ordinal()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r2 = r2[r3]     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r3 = 1
            switch(r2) {
                case 1: goto L_0x01b6;
                case 2: goto L_0x00eb;
                case 3: goto L_0x0080;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00bc;
                case 6: goto L_0x00bc;
                case 7: goto L_0x00bc;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00bc;
                case 10: goto L_0x001c;
                default: goto L_0x0019;
            }     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
        L_0x0019:
            r2 = 0
            goto L_0x01de
        L_0x001c:
            r13.setupTmpDir()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r5 = com.atakmap.android.video.b.b(r14)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r2 = "FmvComponent"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = "create processor for RTSP: addr = "
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.append(r5)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = " tmpDir = "
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.io.File r6 = r13.tmpDir     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = " buffer: "
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r6 = r14.l()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = " timeout: "
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r6 = r14.k()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = " reliable: "
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r6 = r14.m()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r6 != r3) goto L_0x0061
            r6 = 1
            goto L_0x0062
        L_0x0061:
            r6 = 0
        L_0x0062:
            r4.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = r4.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r2, r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaProcessor r2 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r6 = r14.k()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r7 = r14.l()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8 = 0
            java.io.File r9 = r13.tmpDir     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.processor = r2     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            goto L_0x00b9
        L_0x0080:
            int r2 = r14.h()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = r14.f()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r5 = ":"
            boolean r5 = r4.contains(r5)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r5 == 0) goto L_0x00ac
            java.lang.String r5 = r14.f()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = ":"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ Exception -> 0x00ac }
            r4 = r5[r1]     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = r14.f()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = ":"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ Exception -> 0x00ac }
            r5 = r5[r3]     // Catch:{ Exception -> 0x00ac }
            int r2 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            java.io.File r2 = com.atakmap.android.uastool.Reflector.createSDPFile(r4, r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r2 == 0) goto L_0x00bc
            com.partech.pgscmedia.MediaProcessor r4 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.<init>(r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.processor = r4     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
        L_0x00b9:
            r2 = 1
            goto L_0x01de
        L_0x00bc:
            r13.setupTmpDir()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r2 = com.atakmap.android.video.b.b(r14)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = "FmvComponent"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r5.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = "Create processor for URL: addr = "
            r5.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r5.append(r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r6 = " tmpDir = "
            r5.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.io.File r6 = r13.tmpDir     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r5.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r5 = r5.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r4, r5)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaProcessor r4 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4.<init>(r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.processor = r4     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            goto L_0x00b9
        L_0x00eb:
            java.lang.String r2 = r14.f()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r2 == 0) goto L_0x0108
            int r4 = r2.length()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = "0.0.0.0"
            boolean r4 = r2.equals(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r4 != 0) goto L_0x0107
            java.lang.String r4 = "127.0.0.1"
            boolean r4 = r2.equals(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r4 == 0) goto L_0x0108
        L_0x0107:
            r2 = 0
        L_0x0108:
            r5 = r2
            int r6 = r14.h()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.setupTmpDir()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r2 = r14.l()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r7 = r14.k()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = "FmvComponent"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = "Create processor for UDP: host = "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r5)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = " and port = "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r6)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = " tmpDir = "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.io.File r9 = r13.tmpDir     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r8 = r8.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r4, r8)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = "FmvComponent"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = "Create processor for UDP: buffer = "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r8 = r8.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r4, r8)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = "FmvComponent"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = "Network buffer: "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r2)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r9 = " timeout: "
            r8.append(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8.append(r7)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r8 = r8.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r4, r8)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = r14.g()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r8 = com.atakmap.comms.j.b(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r8 != 0) goto L_0x0184
            if (r4 == 0) goto L_0x0184
            java.lang.String r8 = com.atakmap.comms.j.c(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
        L_0x0184:
            r11 = r8
            java.lang.String r8 = "FmvComponent"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r9.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r10 = "preferred mac address: "
            r9.append(r10)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r9.append(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = " resolved to address: "
            r9.append(r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r9.append(r11)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r4 = r9.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.v(r8, r4)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r2 != 0) goto L_0x01a8
            r2 = -1
            r8 = -1
            goto L_0x01a9
        L_0x01a8:
            r8 = r2
        L_0x01a9:
            com.partech.pgscmedia.MediaProcessor r2 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r9 = 0
            java.io.File r10 = r13.tmpDir     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.processor = r2     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            goto L_0x00b9
        L_0x01b6:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            java.lang.String r4 = r14.i()     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            java.lang.String r4 = com.atakmap.coremap.filesystem.FileSystemUtils.validityScan(r4)     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            boolean r4 = r2.exists()     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            if (r4 == 0) goto L_0x0019
            com.partech.pgscmedia.MediaProcessor r4 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            r13.processor = r4     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            r13.fileBased = r3     // Catch:{ IOException -> 0x01d4, MediaException -> 0x0247 }
            goto L_0x00b9
        L_0x01d4:
            r14 = move-exception
            java.lang.String r2 = "FmvComponent"
            java.lang.String r3 = "invalid file"
            com.atakmap.coremap.log.Log.d(r2, r3, r14)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            monitor-exit(r0)     // Catch:{ all -> 0x0251 }
            return r1
        L_0x01de:
            com.partech.pgscmedia.MediaProcessor r4 = r13.processor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r4 != 0) goto L_0x01e4
            monitor-exit(r0)     // Catch:{ all -> 0x0251 }
            return r1
        L_0x01e4:
            com.partech.pgscmedia.consumers.StatusUpdateConsumer r5 = r13.currentStatusConsumer     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r5 == 0) goto L_0x01eb
            r4.setStatusUpdateConsumer(r5)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
        L_0x01eb:
            com.partech.pgscmedia.MediaProcessor r4 = r13.processor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaFormat[] r4 = r4.getTrackInfo()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            int r5 = r4.length     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x01f5:
            if (r6 >= r5) goto L_0x023a
            r9 = r4[r6]     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r10 = "FmvComponent"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r11.<init>()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r12 = "discovered track: "
            r11.append(r12)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaFormat$Type r12 = r9.type     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r11.append(r12)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            java.lang.String r11 = r11.toString()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.atakmap.coremap.log.Log.d(r10, r11)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r7 != 0) goto L_0x0220
            com.partech.pgscmedia.MediaFormat$Type r10 = r9.type     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaFormat$Type r11 = com.partech.pgscmedia.MediaFormat.Type.FORMAT_VIDEO     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r10 != r11) goto L_0x0220
            r7 = r9
            com.partech.pgscmedia.VideoMediaFormat r7 = (com.partech.pgscmedia.VideoMediaFormat) r7     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r13.setupVideo(r7)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r7 = 1
        L_0x0220:
            boolean r10 = r14.b()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r10 != 0) goto L_0x0232
            if (r8 != 0) goto L_0x0232
            com.partech.pgscmedia.MediaFormat$Type r10 = r9.type     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            com.partech.pgscmedia.MediaFormat$Type r11 = com.partech.pgscmedia.MediaFormat.Type.FORMAT_KLV     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            if (r10 != r11) goto L_0x0232
            r13.setupKLV(r9)     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r8 = 1
        L_0x0232:
            if (r8 == 0) goto L_0x0237
            if (r7 == 0) goto L_0x0237
            goto L_0x023a
        L_0x0237:
            int r6 = r6 + 1
            goto L_0x01f5
        L_0x023a:
            if (r7 != 0) goto L_0x023e
            monitor-exit(r0)     // Catch:{ all -> 0x0251 }
            return r1
        L_0x023e:
            com.partech.pgscmedia.MediaProcessor r14 = r13.processor     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r14.start()     // Catch:{ MediaException -> 0x0247, IOException -> 0x0245 }
            r1 = r2
            goto L_0x024f
        L_0x0245:
            r14 = move-exception
            goto L_0x0248
        L_0x0247:
            r14 = move-exception
        L_0x0248:
            java.lang.String r2 = "FmvComponent"
            java.lang.String r3 = "Error occurred loading video"
            com.atakmap.coremap.log.Log.e(r2, r3, r14)     // Catch:{ all -> 0x0251 }
        L_0x024f:
            monitor-exit(r0)     // Catch:{ all -> 0x0251 }
            return r1
        L_0x0251:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0251 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent.load(com.atakmap.android.video.b):boolean");
    }

    public void setStatusUpdateConsumer(StatusUpdateConsumer statusUpdateConsumer) {
        this.currentStatusConsumer = statusUpdateConsumer;
        MediaProcessor mediaProcessor = this.processor;
        if (mediaProcessor != null) {
            mediaProcessor.setStatusUpdateConsumer(statusUpdateConsumer);
        }
    }

    public void resume() {
        MediaProcessor mediaProcessor = this.processor;
        if (mediaProcessor != null) {
            mediaProcessor.start();
        }
    }

    public void pause() {
        MediaProcessor mediaProcessor = this.processor;
        if (mediaProcessor != null) {
            mediaProcessor.stop();
        }
    }

    private void setupKLV(MediaFormat mediaFormat) {
        this.processor.setKLVConsumer(mediaFormat.trackNum, this);
        this.metadataDecoder = new MediaMetadataDecoder();
        setupMetadataDisplay();
    }

    private void setupMetadataDisplay() {
        this.sensorLatitude = Double.NaN;
        this.sensorLongitude = Double.NaN;
        this.sensorAltitude = Double.NaN;
        this.frameLatitude = Double.NaN;
        this.frameLongitude = Double.NaN;
        this.platformTail = null;
        this.platformDesignator = null;
    }

    private void setupVideo(VideoMediaFormat videoMediaFormat) {
        this.processor.setVideoConsumer(videoMediaFormat.trackNum, this.surfaceVideoConsumer);
    }

    private void setupTmpDir() {
        File file = new File(MapView.getMapView().getContext().getFilesDir(), TEMP_DIR);
        if (!file.exists() && !file.mkdirs()) {
            Log.d(TAG, "could not create: " + file);
        }
        File createTempFile = File.createTempFile("stream", (String) null, file);
        this.tmpDir = createTempFile;
        FileSystemUtils.delete(createTempFile);
        if (!this.tmpDir.mkdirs()) {
            Log.d(TAG, "could not create: " + this.tmpDir);
        }
    }

    private void cleanTmpDirs() {
        File file = new File(MapView.getMapView().getContext().getFilesDir(), TEMP_DIR);
        if (file.exists()) {
            FileSystemUtils.deleteDirectory(file, true);
        }
    }

    public void setScale(float f) {
        this.glView.setScale(f);
    }

    public void setPanOffset(int i, int i2) {
        this.glView.setPanOffset(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f2, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0236, code lost:
        r2 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mediaKLVData(com.partech.pgscmedia.frameaccess.KLVData r15) {
        /*
            r14 = this;
            com.partech.pgscmedia.frameaccess.MediaMetadataDecoder r0 = r14.metadataDecoder
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = 0
            r0.decode(r15)     // Catch:{ Exception -> 0x0010 }
            com.partech.pgscmedia.frameaccess.MediaMetadataDecoder r15 = r14.metadataDecoder     // Catch:{ Exception -> 0x0010 }
            java.util.Map r15 = r15.getCurrentItems()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0019
        L_0x0010:
            r15 = move-exception
            java.lang.String r0 = "FmvComponent"
            java.lang.String r2 = "error occurred during klv decoding"
            com.atakmap.coremap.log.Log.d(r0, r2, r15)
            r15 = r1
        L_0x0019:
            if (r15 != 0) goto L_0x001c
            return
        L_0x001c:
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r14.corner4lat = r2
            r14.corner3lat = r2
            r14.corner2lat = r2
            r14.corner1lat = r2
            com.atakmap.android.uastool.UASItem r0 = r14.selectedUASItem
            monitor-enter(r0)
            java.util.Set r15 = r15.entrySet()     // Catch:{ all -> 0x0378 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x0378 }
            r2 = 0
            r3 = 0
        L_0x0033:
            boolean r4 = r15.hasNext()     // Catch:{ all -> 0x0378 }
            r5 = 1
            if (r4 == 0) goto L_0x0261
            java.lang.Object r4 = r15.next()     // Catch:{ all -> 0x0378 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0378 }
            if (r4 == 0) goto L_0x0033
            java.lang.Object r6 = r4.getKey()     // Catch:{ all -> 0x0378 }
            if (r6 == 0) goto L_0x0033
            int[] r6 = com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent.C16475.f8400x595b2200     // Catch:{ all -> 0x0378 }
            java.lang.Object r7 = r4.getKey()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r7 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs) r7     // Catch:{ all -> 0x0378 }
            int r7 = r7.ordinal()     // Catch:{ all -> 0x0378 }
            r6 = r6[r7]     // Catch:{ all -> 0x0378 }
            switch(r6) {
                case 1: goto L_0x024d;
                case 2: goto L_0x0239;
                case 3: goto L_0x0224;
                case 4: goto L_0x0211;
                case 5: goto L_0x01fe;
                case 6: goto L_0x01ea;
                case 7: goto L_0x01d6;
                case 8: goto L_0x01c2;
                case 9: goto L_0x01ae;
                case 10: goto L_0x019a;
                case 11: goto L_0x0186;
                case 12: goto L_0x0172;
                case 13: goto L_0x015e;
                case 14: goto L_0x014a;
                case 15: goto L_0x0136;
                case 16: goto L_0x0126;
                case 17: goto L_0x00f5;
                case 18: goto L_0x0059;
                case 19: goto L_0x00e0;
                case 20: goto L_0x00cd;
                case 21: goto L_0x00ba;
                case 22: goto L_0x00a7;
                case 23: goto L_0x0094;
                case 24: goto L_0x0081;
                case 25: goto L_0x006e;
                case 26: goto L_0x005a;
                default: goto L_0x0059;
            }     // Catch:{ all -> 0x0378 }
        L_0x0059:
            goto L_0x0033
        L_0x005a:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner4lon = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x006e:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner4lat = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x0081:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner3lon = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x0094:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner3lat = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x00a7:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner2lon = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x00ba:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner2lat = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x00cd:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner1lon = r3     // Catch:{ all -> 0x0378 }
            goto L_0x00f2
        L_0x00e0:
            java.lang.Object r3 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r3 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r3     // Catch:{ all -> 0x0378 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r3 = (java.lang.Double) r3     // Catch:{ all -> 0x0378 }
            double r3 = r3.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.corner1lat = r3     // Catch:{ all -> 0x0378 }
        L_0x00f2:
            r3 = 1
            goto L_0x0033
        L_0x00f5:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0378 }
            r14.platformTail = r4     // Catch:{ all -> 0x0378 }
            com.atakmap.android.maps.ao r5 = r14.sensorMarker     // Catch:{ all -> 0x0378 }
            if (r5 == 0) goto L_0x010a
            setTitle(r5, r4)     // Catch:{ all -> 0x0378 }
        L_0x010a:
            com.atakmap.android.maps.ao r4 = r14.frameMarker     // Catch:{ all -> 0x0378 }
            if (r4 == 0) goto L_0x0033
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0378 }
            r5.<init>()     // Catch:{ all -> 0x0378 }
            java.lang.String r6 = r14.platformTail     // Catch:{ all -> 0x0378 }
            r5.append(r6)     // Catch:{ all -> 0x0378 }
            java.lang.String r6 = "-SPI"
            r5.append(r6)     // Catch:{ all -> 0x0378 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0378 }
            setTitle(r4, r5)     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x0126:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0378 }
            r14.platformDesignator = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x0136:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorRoll = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x014a:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorVFOV = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x015e:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorRelativeElevation = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x0172:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorRelativeAzimuth = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x0186:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorHFOV = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x019a:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorEllipsoidHeight = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x01ae:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.frameElevation = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x01c2:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.frameHAE = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x01d6:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.frameLongitude = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x01ea:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.frameLatitude = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x01fe:
            java.lang.Object r2 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r2 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r2     // Catch:{ all -> 0x0378 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ all -> 0x0378 }
            double r6 = r2.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorAltitude = r6     // Catch:{ all -> 0x0378 }
            goto L_0x0236
        L_0x0211:
            java.lang.Object r2 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r2 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r2     // Catch:{ all -> 0x0378 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ all -> 0x0378 }
            double r6 = r2.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorLongitude = r6     // Catch:{ all -> 0x0378 }
            goto L_0x0236
        L_0x0224:
            java.lang.Object r2 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r2 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r2     // Catch:{ all -> 0x0378 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ all -> 0x0378 }
            double r6 = r2.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.sensorLatitude = r6     // Catch:{ all -> 0x0378 }
        L_0x0236:
            r2 = 1
            goto L_0x0033
        L_0x0239:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.platformPitchAngle = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x024d:
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            com.partech.pgscmedia.frameaccess.DecodedMetadataItem r4 = (com.partech.pgscmedia.frameaccess.DecodedMetadataItem) r4     // Catch:{ all -> 0x0378 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0378 }
            java.lang.Double r4 = (java.lang.Double) r4     // Catch:{ all -> 0x0378 }
            double r4 = r4.doubleValue()     // Catch:{ all -> 0x0378 }
            r14.platformHeadingAngle = r4     // Catch:{ all -> 0x0378 }
            goto L_0x0033
        L_0x0261:
            com.partech.pgscmedia.frameaccess.MediaMetadataDecoder r15 = r14.metadataDecoder     // Catch:{ all -> 0x0378 }
            r15.clear()     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x026a
            if (r3 == 0) goto L_0x0376
        L_0x026a:
            com.atakmap.android.uastool.UASToolDropDownReceiver r15 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()     // Catch:{ all -> 0x0378 }
            com.atakmap.android.uastool.pagers.video_ui.ArOverlayView r15 = r15.getObserverArOverlay()     // Catch:{ all -> 0x0378 }
            double r2 = r14.sensorLatitude     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0299
            double r2 = r14.sensorLongitude     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0299
            double r2 = r14.sensorAltitude     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0299
            com.atakmap.coremap.maps.coords.GeoPoint r2 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x0378 }
            double r7 = r14.sensorLatitude     // Catch:{ all -> 0x0378 }
            double r9 = r14.sensorLongitude     // Catch:{ all -> 0x0378 }
            double r11 = r14.sensorAltitude     // Catch:{ all -> 0x0378 }
            r6 = r2
            r6.<init>(r7, r9, r11)     // Catch:{ all -> 0x0378 }
            r15.setDronePosition(r2)     // Catch:{ all -> 0x0378 }
        L_0x0299:
            double r2 = r14.corner1lat     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner1lon     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner2lat     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner2lon     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner3lat     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner3lon     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner4lat     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            double r2 = r14.corner4lon     // Catch:{ all -> 0x0378 }
            boolean r2 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r2 != 0) goto L_0x0373
            com.atakmap.map.elevation.ElevationManager$b r1 = new com.atakmap.map.elevation.ElevationManager$b     // Catch:{ all -> 0x0378 }
            r1.<init>()     // Catch:{ all -> 0x0378 }
            r1.e = r5     // Catch:{ all -> 0x0378 }
            r1.g = r5     // Catch:{ all -> 0x0378 }
            double r2 = r14.corner1lat     // Catch:{ all -> 0x0378 }
            double r4 = r14.corner1lon     // Catch:{ all -> 0x0378 }
            double r2 = com.atakmap.map.elevation.ElevationManager.a(r2, r4, r1)     // Catch:{ all -> 0x0378 }
            com.atakmap.coremap.maps.coords.GeoPoint r11 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x0378 }
            double r5 = r14.corner1lat     // Catch:{ all -> 0x0378 }
            double r7 = r14.corner1lon     // Catch:{ all -> 0x0378 }
            boolean r4 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r4 != 0) goto L_0x02f7
            goto L_0x02f9
        L_0x02f7:
            double r2 = r14.frameElevation     // Catch:{ all -> 0x0378 }
        L_0x02f9:
            r9 = r2
            r4 = r11
            r4.<init>(r5, r7, r9)     // Catch:{ all -> 0x0378 }
            double r2 = r14.corner2lat     // Catch:{ all -> 0x0378 }
            double r4 = r14.corner2lon     // Catch:{ all -> 0x0378 }
            double r2 = com.atakmap.map.elevation.ElevationManager.a(r2, r4, r1)     // Catch:{ all -> 0x0378 }
            com.atakmap.coremap.maps.coords.GeoPoint r12 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x0378 }
            double r5 = r14.corner2lat     // Catch:{ all -> 0x0378 }
            double r7 = r14.corner2lon     // Catch:{ all -> 0x0378 }
            boolean r4 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r4 != 0) goto L_0x0313
            goto L_0x0315
        L_0x0313:
            double r2 = r14.frameElevation     // Catch:{ all -> 0x0378 }
        L_0x0315:
            r9 = r2
            r4 = r12
            r4.<init>(r5, r7, r9)     // Catch:{ all -> 0x0378 }
            double r2 = r14.corner3lat     // Catch:{ all -> 0x0378 }
            double r4 = r14.corner3lon     // Catch:{ all -> 0x0378 }
            double r2 = com.atakmap.map.elevation.ElevationManager.a(r2, r4, r1)     // Catch:{ all -> 0x0378 }
            com.atakmap.coremap.maps.coords.GeoPoint r13 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x0378 }
            double r5 = r14.corner3lat     // Catch:{ all -> 0x0378 }
            double r7 = r14.corner3lon     // Catch:{ all -> 0x0378 }
            boolean r4 = java.lang.Double.isNaN(r2)     // Catch:{ all -> 0x0378 }
            if (r4 != 0) goto L_0x032f
            goto L_0x0331
        L_0x032f:
            double r2 = r14.frameElevation     // Catch:{ all -> 0x0378 }
        L_0x0331:
            r9 = r2
            r4 = r13
            r4.<init>(r5, r7, r9)     // Catch:{ all -> 0x0378 }
            double r2 = r14.corner4lat     // Catch:{ all -> 0x0378 }
            double r4 = r14.corner4lon     // Catch:{ all -> 0x0378 }
            double r1 = com.atakmap.map.elevation.ElevationManager.a(r2, r4, r1)     // Catch:{ all -> 0x0378 }
            com.atakmap.coremap.maps.coords.GeoPoint r10 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ all -> 0x0378 }
            double r4 = r14.corner4lat     // Catch:{ all -> 0x0378 }
            double r6 = r14.corner4lon     // Catch:{ all -> 0x0378 }
            boolean r3 = java.lang.Double.isNaN(r1)     // Catch:{ all -> 0x0378 }
            if (r3 != 0) goto L_0x034b
            goto L_0x034d
        L_0x034b:
            double r1 = r14.frameElevation     // Catch:{ all -> 0x0378 }
        L_0x034d:
            r8 = r1
            r3 = r10
            r3.<init>(r4, r6, r8)     // Catch:{ all -> 0x0378 }
            com.atakmap.android.uastool.utils.FieldOfView r1 = new com.atakmap.android.uastool.utils.FieldOfView     // Catch:{ all -> 0x0378 }
            r1.<init>()     // Catch:{ all -> 0x0378 }
            com.atakmap.math.PointD r2 = com.atakmap.android.uastool.utils.FieldOfView.geoPointToPointD(r11)     // Catch:{ all -> 0x0378 }
            r1.f8422tl = r2     // Catch:{ all -> 0x0378 }
            com.atakmap.math.PointD r2 = com.atakmap.android.uastool.utils.FieldOfView.geoPointToPointD(r12)     // Catch:{ all -> 0x0378 }
            r1.f8423tr = r2     // Catch:{ all -> 0x0378 }
            com.atakmap.math.PointD r2 = com.atakmap.android.uastool.utils.FieldOfView.geoPointToPointD(r13)     // Catch:{ all -> 0x0378 }
            r1.f8421br = r2     // Catch:{ all -> 0x0378 }
            com.atakmap.math.PointD r2 = com.atakmap.android.uastool.utils.FieldOfView.geoPointToPointD(r10)     // Catch:{ all -> 0x0378 }
            r1.f8420bl = r2     // Catch:{ all -> 0x0378 }
            r15.setFieldOfView(r1)     // Catch:{ all -> 0x0378 }
            goto L_0x0376
        L_0x0373:
            r15.setFieldOfView(r1)     // Catch:{ all -> 0x0378 }
        L_0x0376:
            monitor-exit(r0)     // Catch:{ all -> 0x0378 }
            return
        L_0x0378:
            r15 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0378 }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent.mediaKLVData(com.partech.pgscmedia.frameaccess.KLVData):void");
    }

    /* renamed from: com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent$5 */
    /* synthetic */ class C16475 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol;

        /* renamed from: $SwitchMap$com$partech$pgscmedia$frameaccess$DecodedMetadataItem$MetadataItemIDs */
        static final /* synthetic */ int[] f8400x595b2200;

        /* JADX WARNING: Can't wrap try/catch for region: R(73:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(3:91|92|94)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(3:91|92|94)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(3:91|92|94)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(3:91|92|94)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(78:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|(3:91|92|94)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(80:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|94) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|94) */
        /* JADX WARNING: Can't wrap try/catch for region: R(82:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|94) */
        /* JADX WARNING: Can't wrap try/catch for region: R(84:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|94) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0149 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0153 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x015d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0167 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0171 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x017b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0185 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x018f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0199 */
        static {
            /*
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs[] r0 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8400x595b2200 = r0
                r1 = 1
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r2 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_HEADING_ANGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x001d }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r3 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_PITCH_ANGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r4 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_LATITUDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r5 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_LONGITUDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x003e }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r6 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_TRUE_ALTITUDE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r7 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_LATITUDE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r8 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_LONGITUDE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r9 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_HEIGHT_ABOVE_ELLIPSOID     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x006c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r10 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_ELEVATION     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_ELLIPSOID_HEIGHT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_HORIZONTAL_FIELD_OF_VIEW     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r12 = 11
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_AZIMUTH_ANGLE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12 = 12
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x009c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_ELEVATION_ANGLE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r12 = 13
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_VERTICAL_FIELD_OF_VIEW     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r12 = 14
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_ROLL_ANGLE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r12 = 15
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_DESIGNATION     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r12 = 16
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_TAIL_NUMBER     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r12 = 17
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_TARGET_WIDTH     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r12 = 18
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_1     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r12 = 19
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_1     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r12 = 20
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_2     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r12 = 21
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_2     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r12 = 22
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_3     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r12 = 23
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_3     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r12 = 24
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x012c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_4     // Catch:{ NoSuchFieldError -> 0x012c }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r12 = 25
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r10 = f8400x595b2200     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r11 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_4     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r12 = 26
                r10[r11] = r12     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                com.atakmap.android.video.b$a[] r10 = com.atakmap.android.video.b.a.values()
                int r10 = r10.length
                int[] r10 = new int[r10]
                $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol = r10
                com.atakmap.android.video.b$a r11 = com.atakmap.android.video.b.a.h     // Catch:{ NoSuchFieldError -> 0x0149 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0149 }
                r10[r11] = r1     // Catch:{ NoSuchFieldError -> 0x0149 }
            L_0x0149:
                int[] r1 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x0153 }
                com.atakmap.android.video.b$a r10 = com.atakmap.android.video.b.a.b     // Catch:{ NoSuchFieldError -> 0x0153 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0153 }
                r1[r10] = r0     // Catch:{ NoSuchFieldError -> 0x0153 }
            L_0x0153:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x015d }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.j     // Catch:{ NoSuchFieldError -> 0x015d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015d }
            L_0x015d:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x0167 }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.a     // Catch:{ NoSuchFieldError -> 0x0167 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0167 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0167 }
            L_0x0167:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x0171 }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.i     // Catch:{ NoSuchFieldError -> 0x0171 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0171 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0171 }
            L_0x0171:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x017b }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.d     // Catch:{ NoSuchFieldError -> 0x017b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x017b }
            L_0x017b:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x0185 }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.e     // Catch:{ NoSuchFieldError -> 0x0185 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0185 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0185 }
            L_0x0185:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x018f }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.g     // Catch:{ NoSuchFieldError -> 0x018f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x018f }
            L_0x018f:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x0199 }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.f     // Catch:{ NoSuchFieldError -> 0x0199 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0199 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0199 }
            L_0x0199:
                int[] r0 = $SwitchMap$com$atakmap$android$video$ConnectionEntry$Protocol     // Catch:{ NoSuchFieldError -> 0x01a3 }
                com.atakmap.android.video.b$a r1 = com.atakmap.android.video.b.a.c     // Catch:{ NoSuchFieldError -> 0x01a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a3 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x01a3 }
            L_0x01a3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent.C16475.<clinit>():void");
        }
    }

    private static void setTitle(ao aoVar, String str) {
        aoVar.setTitle(str);
        aoVar.setMetaString(FlightLogger.LOG_CALLSIGN, str);
    }

    public boolean isDestroyed() {
        return this.processor == null;
    }

    public void destroyConnection() {
        final MediaProcessor mediaProcessor = this.processor;
        if (mediaProcessor != null) {
            this.processor = null;
            new Thread(new Runnable() {
                public void run() {
                    mediaProcessor.stop();
                    mediaProcessor.destroy();
                }
            }, "video-resource-reaper").start();
        }
        MediaMetadataDecoder mediaMetadataDecoder = this.metadataDecoder;
        if (mediaMetadataDecoder != null) {
            mediaMetadataDecoder.clear();
            this.metadataDecoder = null;
        }
        b bVar = this.mCotEventMarshal;
        if (bVar != null) {
            y.b(bVar);
        }
        this.corner1lat = Double.NaN;
        this.corner1lon = Double.NaN;
        this.corner2lat = Double.NaN;
        this.corner2lon = Double.NaN;
        this.corner3lat = Double.NaN;
        this.corner3lon = Double.NaN;
        this.corner4lat = Double.NaN;
        this.corner4lon = Double.NaN;
        cleanTmpDirs();
        if (this.sensorMarker != null) {
            this.mapView.getRootGroup().g(this.sensorMarker);
            this.sensorMarker.setMetaBoolean("removable", true);
            this.sensorMarker = null;
        }
        ao aoVar = this.frameMarker;
        if (aoVar != null) {
            ag group = aoVar.getGroup();
            if (group != null) {
                Log.d(TAG, "removing the frame marker from the screen");
                group.g(this.frameMarker);
            }
            this.frameMarker.setMetaBoolean("removable", true);
            this.frameMarker = null;
        }
        if (this.fourCornersPolygon != null) {
            this.mapView.getRootGroup().g(this.fourCornersPolygon);
            this.fourCornersPolygon.setMetaBoolean("removable", true);
            this.fourCornersPolygon = null;
        }
        if (this.assoc != null) {
            this.mapView.getRootGroup().g(this.assoc);
            this.assoc = null;
        }
        post(new Runnable() {
            public void run() {
                ObserverFmvComponent.this.glView.c();
            }
        });
    }

    public boolean processCOTSensor(CotEvent cotEvent) {
        CotEvent cotEvent2 = cotEvent;
        if (cotEvent2 != null && cotEvent.getUID().equals(this.selectedUASItem.getUid()) && cotEvent.getType().equals(UASToolConstants.UAS_ROTARY_TYPE) && !Double.isNaN(this.sensorLatitude) && !Double.isNaN(this.sensorLatitude) && !Double.isNaN(this.sensorAltitude)) {
            cotEvent2.setPoint(new CotPoint(new GeoPoint(this.sensorLatitude, this.sensorLongitude, EGM96.getHAE(this.sensorLatitude, this.sensorLongitude, this.sensorAltitude), GeoPoint.AltitudeReference.HAE)));
        }
        return false;
    }

    public boolean processCOT4Corners(CotEvent cotEvent) {
        CotEvent cotEvent2 = cotEvent;
        if (cotEvent2 == null) {
            return false;
        }
        if ((this.selectedUASItem.getCallsign() + "." + this.selectedUASItem.getUid() + ".SPI1").equals(cotEvent.getUID()) && cotEvent.getType().equals("b-m-p-s-p-i")) {
            if (!Double.isNaN(this.frameLatitude) && !Double.isNaN(this.frameLatitude) && !Double.isNaN(this.frameElevation)) {
                cotEvent2.setPoint(new CotPoint(new GeoPoint(this.frameLatitude, this.frameLongitude, EGM96.getHAE(this.frameLatitude, this.frameLongitude, this.frameElevation), GeoPoint.AltitudeReference.HAE)));
            }
            if (!Double.isNaN(this.corner1lat) && !Double.isNaN(this.corner1lon) && !Double.isNaN(this.corner2lat) && !Double.isNaN(this.corner2lon) && !Double.isNaN(this.corner3lat) && !Double.isNaN(this.corner3lon) && !Double.isNaN(this.corner4lat) && !Double.isNaN(this.corner4lon)) {
                CotDetail detail = cotEvent.getDetail();
                if (detail == null) {
                    detail = new CotDetail();
                }
                CotDetail firstChildByName = detail.getFirstChildByName(0, "shape)");
                if (firstChildByName == null) {
                    firstChildByName = new CotDetail("shape");
                    detail.addChild(firstChildByName);
                }
                CotDetail firstChildByName2 = firstChildByName.getFirstChildByName(0, "polyline");
                if (firstChildByName2 != null) {
                    firstChildByName.removeChild(firstChildByName2);
                }
                CotDetail cotDetail = new CotDetail("polyline");
                cotDetail.addChild(polylinePoint(this.corner1lat, this.corner1lon));
                cotDetail.addChild(polylinePoint(this.corner2lat, this.corner2lon));
                cotDetail.addChild(polylinePoint(this.corner3lat, this.corner3lon));
                cotDetail.addChild(polylinePoint(this.corner4lat, this.corner4lon));
                cotDetail.setAttribute("closed", "true");
                firstChildByName.addChild(cotDetail);
            }
        }
        return false;
    }

    private static CotDetail polylinePoint(double d, double d2) {
        CotDetail cotDetail = new CotDetail("vertex");
        cotDetail.setAttribute("hae", JsonValueConstants.VERSION);
        cotDetail.setAttribute(FlightLogger.LOCS_LATITUDE, UASItemUtils.getString(Double.valueOf(d)));
        cotDetail.setAttribute(FlightLogger.LOCS_LONGITUDE, UASItemUtils.getString(Double.valueOf(d2)));
        return cotDetail;
    }

    public void setUASItem(UASItem uASItem) {
        this.selectedUASItem = uASItem;
    }
}
