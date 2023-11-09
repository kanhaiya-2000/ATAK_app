package com.atakmap.android.uastool;

import android.os.Environment;
import android.view.Surface;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.pagers.ImageViewRenderer;
import com.atakmap.android.video.i;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.io.IOProviderFactory;
import com.atakmap.coremap.loader.NativeLoader;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.partech.mobilevid.SurfaceVideoConsumer;
import com.partech.pgscmedia.MediaException;
import com.partech.pgscmedia.MediaFormat;
import com.partech.pgscmedia.MediaProcessor;
import com.partech.pgscmedia.VideoMediaFormat;
import com.partech.pgscmedia.consumers.KLVConsumer;
import com.partech.pgscmedia.consumers.MediaConsumer;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;
import com.partech.pgscmedia.consumers.VideoConsumer;
import com.partech.pgscmedia.frameaccess.DecodedMetadataItem;
import com.partech.pgscmedia.frameaccess.KLVData;
import com.partech.pgscmedia.frameaccess.MediaMetadataDecoder;
import com.partech.pgscmedia.frameaccess.VideoFrameData;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Map;

public class MpegStreamHandler implements KLVConsumer, MediaConsumer, Runnable {
    private static final int NETWORK_TIMEOUT = 12000;
    private static final String TAG = "MpegStreamHandler";
    private static final String TEMP_DIR = "MpegStreamTmp";
    public static final String VIDEO_DIRNAME = ("tools" + File.separatorChar + "videos");
    private static final CoordinatedTime.SimpleDateFormatThread recDateFormatter = new CoordinatedTime.SimpleDateFormatThread("yyyyMMMdd_HHmmss", LocaleUtil.getCurrent());
    private static final CoordinatedTime.SimpleDateFormatThread recdirDateFormatter = new CoordinatedTime.SimpleDateFormatThread("yyyyMMMdd", LocaleUtil.getCurrent());
    /* access modifiers changed from: private */
    public int NETWORK_BUFTIME = -1;
    private StatusUpdateConsumer currentStatusConsumer = null;
    private boolean isRunning;
    private final MediaMetadataDecoder metadataDecoder = new MediaMetadataDecoder();
    private MpegStreamKLVListener mpegStreamKLVListener = null;
    private final ImageView outputImageView;
    private final Surface outputSurface;
    /* access modifiers changed from: private */
    public MediaProcessor processor;
    private boolean recordSupported;
    private OutputStream recordingStream = null;
    /* access modifiers changed from: private */
    public File sdpFile;
    private boolean shouldRun;
    /* access modifiers changed from: private */
    public String sourceAddress;
    /* access modifiers changed from: private */
    public int sourcePort;
    /* access modifiers changed from: private */
    public final int sourceTimeout;
    /* access modifiers changed from: private */
    public String sourceUri;
    /* access modifiers changed from: private */
    public String srcNetwork;
    private Thread thread;
    /* access modifiers changed from: private */
    public File tmpDir;
    private VideoConsumer videoConsumer;

    public interface MpegStreamKLVListener {
        void aircraftAttitudeUpdate(double d, double d2, double d3);

        void cornersUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

        void rawKLVUpdate(byte[] bArr, byte[] bArr2);

        void sensorAttitudeUpdate(double d, double d2, double d3);

        void sensorFovUpdate(double d, double d2);

        void sensorLocationUpdate(double d, double d2, double d3, String str);

        void sensorSpoiUpdate(double d, double d2, double d3, double d4);

        void streamStarted();

        void streamStartupFailed();
    }

    static {
        try {
            NativeLoader.loadLibrary("gnustl_shared");
            MediaProcessor.PGSCMediaInit(MapView.getMapView().getContext().getApplicationContext());
        } catch (MediaException e) {
            Log.e(TAG, "Error when initializing native components for video player", e);
            throw new RuntimeException(e);
        }
    }

    public MpegStreamHandler(String str, int i, Surface surface) {
        this.sourceAddress = str;
        this.sourcePort = i;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputSurface = surface;
        this.outputImageView = null;
    }

    public MpegStreamHandler(String str, int i, ImageView imageView) {
        this.sourceAddress = str;
        this.sourcePort = i;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputImageView = imageView;
        this.outputSurface = null;
    }

    public MpegStreamHandler(String str, Surface surface) {
        this.sourceUri = str;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputSurface = surface;
        this.outputImageView = null;
    }

    public MpegStreamHandler(String str, ImageView imageView) {
        this.sourceUri = str;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputImageView = imageView;
        this.outputSurface = null;
    }

    public MpegStreamHandler(String str, int i, Surface surface, String str2) {
        this.sourceAddress = str;
        this.sourcePort = i;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputSurface = surface;
        this.srcNetwork = str2;
        this.outputImageView = null;
    }

    public MpegStreamHandler(String str, int i, ImageView imageView, String str2) {
        this.sourceAddress = str;
        this.sourcePort = i;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputImageView = imageView;
        this.srcNetwork = str2;
        this.outputSurface = null;
    }

    public MpegStreamHandler(File file, Surface surface) {
        this.sdpFile = file;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputSurface = surface;
        this.outputImageView = null;
    }

    public void setNetworkBufferMs(int i) {
        this.NETWORK_BUFTIME = i;
    }

    public MpegStreamHandler(File file, ImageView imageView) {
        this.sdpFile = file;
        this.sourceTimeout = NETWORK_TIMEOUT;
        this.outputImageView = imageView;
        this.outputSurface = null;
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.shouldRun = true;
            Thread thread2 = new Thread(this);
            this.thread = thread2;
            thread2.setPriority(5);
            this.thread.start();
            return;
        }
        throw new RuntimeException("Media already started!");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|(2:6|7)|8|9|39) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r3 = this;
            java.lang.String r0 = "MpegStreamHandler"
            java.lang.String r1 = "Stop()"
            com.atakmap.coremap.log.Log.d(r0, r1)
            com.partech.pgscmedia.consumers.VideoConsumer r0 = r3.videoConsumer     // Catch:{ all -> 0x004a }
            boolean r0 = r0 instanceof com.atakmap.android.uastool.pagers.ImageViewRenderer     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0029
            java.lang.Thread r0 = r3.thread     // Catch:{ all -> 0x004a }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x001a
            java.lang.Thread r0 = r3.thread     // Catch:{ Exception -> 0x001a }
            r0.wait()     // Catch:{ Exception -> 0x001a }
        L_0x001a:
            com.partech.pgscmedia.MediaProcessor r0 = r3.processor     // Catch:{ Exception -> 0x0020 }
            r0.destroy()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r0 = move-exception
            java.lang.String r1 = "MpegStreamHandler"
            java.lang.String r2 = "error"
            com.atakmap.coremap.log.Log.d(r1, r2, r0)     // Catch:{ all -> 0x004a }
        L_0x0028:
            return
        L_0x0029:
            monitor-enter(r3)     // Catch:{ all -> 0x004a }
        L_0x002a:
            boolean r0 = r3.isRunning     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0042
            r0 = 0
            r3.shouldRun = r0     // Catch:{ all -> 0x0047 }
            java.lang.Thread r0 = r3.thread     // Catch:{ all -> 0x0047 }
            r0.interrupt()     // Catch:{ all -> 0x0047 }
            r3.wait()     // Catch:{ InterruptedException -> 0x003a }
            goto L_0x002a
        L_0x003a:
            java.lang.String r0 = "MpegStreamHandler"
            java.lang.String r1 = "Interrupted Exception!"
            com.atakmap.coremap.log.Log.d(r0, r1)     // Catch:{ all -> 0x0047 }
            goto L_0x002a
        L_0x0042:
            r0 = 0
            r3.thread = r0     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            goto L_0x0052
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0047 }
            throw r0     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            java.lang.String r1 = "MpegStreamHandler"
            java.lang.String r2 = "Error Stopping Stream"
            com.atakmap.coremap.log.Log.d(r1, r2, r0)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.MpegStreamHandler.stop():void");
    }

    public void mediaKLVData(KLVData kLVData) {
        double d;
        double d2;
        double d3;
        MpegStreamKLVListener mpegStreamKLVListener2;
        MpegStreamKLVListener mpegStreamKLVListener3;
        MpegStreamKLVListener mpegStreamKLVListener4;
        MpegStreamKLVListener mpegStreamKLVListener5;
        MpegStreamKLVListener mpegStreamKLVListener6;
        MpegStreamKLVListener mpegStreamKLVListener7 = this.mpegStreamKLVListener;
        if (mpegStreamKLVListener7 != null) {
            try {
                mpegStreamKLVListener7.rawKLVUpdate(kLVData.getKey(), kLVData.getValue());
                this.metadataDecoder.decode(kLVData);
                Map currentItems = this.metadataDecoder.getCurrentItems();
                String str = "";
                String str2 = str;
                double d4 = Double.NaN;
                double d5 = Double.NaN;
                double d6 = Double.NaN;
                double d7 = Double.NaN;
                double d8 = Double.NaN;
                double d9 = Double.NaN;
                double d10 = Double.NaN;
                double d11 = Double.NaN;
                double d12 = Double.NaN;
                double d13 = Double.NaN;
                double d14 = Double.NaN;
                double d15 = Double.NaN;
                double d16 = Double.NaN;
                double d17 = Double.NaN;
                double d18 = Double.NaN;
                double d19 = Double.NaN;
                double d20 = Double.NaN;
                double d21 = Double.NaN;
                double d22 = Double.NaN;
                double d23 = Double.NaN;
                double d24 = Double.NaN;
                double d25 = Double.NaN;
                double d26 = Double.NaN;
                String str3 = str2;
                for (Map.Entry entry : currentItems.entrySet()) {
                    switch (C11334.f8364x595b2200[((DecodedMetadataItem.MetadataItemIDs) entry.getKey()).ordinal()]) {
                        case 1:
                            d4 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 2:
                            d5 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 3:
                            d9 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 4:
                            if (!str.isEmpty()) {
                                break;
                            } else {
                                str = (String) ((DecodedMetadataItem) entry.getValue()).getValue();
                                break;
                            }
                        case 5:
                            if (!str3.isEmpty()) {
                                break;
                            } else {
                                str3 = (String) ((DecodedMetadataItem) entry.getValue()).getValue();
                                break;
                            }
                        case 6:
                            if (!str2.isEmpty()) {
                                break;
                            } else {
                                str2 = (String) ((DecodedMetadataItem) entry.getValue()).getValue();
                                break;
                            }
                        case 7:
                            d10 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 8:
                            d8 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 9:
                            d11 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 10:
                            d13 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 11:
                            d12 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 12:
                            d14 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 13:
                            d15 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 14:
                            d23 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 15:
                            d24 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 16:
                            d25 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 17:
                            d26 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 18:
                            d16 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 19:
                            d18 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 20:
                            d17 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 21:
                            d19 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 22:
                            d20 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 23:
                            d21 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 24:
                            d22 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 25:
                            d6 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                        case 26:
                            d7 = ((Double) ((DecodedMetadataItem) entry.getValue()).getValue()).doubleValue();
                            break;
                    }
                }
                this.metadataDecoder.clear();
                if (currentItems.size() != 0) {
                    if (Double.isNaN(d4) || Double.isNaN(d5) || (mpegStreamKLVListener6 = this.mpegStreamKLVListener) == null) {
                        d = d6;
                    } else {
                        d = d6;
                        mpegStreamKLVListener6.sensorLocationUpdate(d4, d5, d9, str2);
                    }
                    if (Double.isNaN(d10) || Double.isNaN(d8) || (mpegStreamKLVListener5 = this.mpegStreamKLVListener) == null) {
                        d2 = d7;
                    } else {
                        d2 = d7;
                        mpegStreamKLVListener5.sensorSpoiUpdate(d10, d8, d11, d13);
                    }
                    if (!Double.isNaN(d16) && !Double.isNaN(d25) && !Double.isNaN(d23) && !Double.isNaN(d14) && !Double.isNaN(d12) && !Double.isNaN(d15) && !Double.isNaN(d24) && !Double.isNaN(d26) && (mpegStreamKLVListener4 = this.mpegStreamKLVListener) != null) {
                        mpegStreamKLVListener4.cornersUpdate(d12, d14, d15, d23, d24, d25, d26, d16);
                    }
                    if (Double.isNaN(d18) || Double.isNaN(d17) || Double.isNaN(d19)) {
                        d3 = d2;
                        MpegStreamKLVListener mpegStreamKLVListener8 = this.mpegStreamKLVListener;
                        if (mpegStreamKLVListener8 != null) {
                            mpegStreamKLVListener8.aircraftAttitudeUpdate(0.0d, 0.0d, 0.0d);
                            this.mpegStreamKLVListener.sensorAttitudeUpdate(0.0d, 0.0d, 0.0d);
                        }
                    } else {
                        MpegStreamKLVListener mpegStreamKLVListener9 = this.mpegStreamKLVListener;
                        if (mpegStreamKLVListener9 != null) {
                            d3 = d2;
                            mpegStreamKLVListener9.aircraftAttitudeUpdate(d19, d17, d18);
                        } else {
                            d3 = d2;
                        }
                        if (!Double.isNaN(d20) && !Double.isNaN(d21) && !Double.isNaN(d22) && (mpegStreamKLVListener3 = this.mpegStreamKLVListener) != null) {
                            mpegStreamKLVListener3.sensorAttitudeUpdate(d19 + d22, d17 + d21, d18 + (d20 % 360.0d));
                        }
                    }
                    if (!Double.isNaN(d3) && !Double.isNaN(d) && (mpegStreamKLVListener2 = this.mpegStreamKLVListener) != null) {
                        mpegStreamKLVListener2.sensorFovUpdate(d, d3);
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "KLV error - ", e);
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.MpegStreamHandler$4 */
    /* synthetic */ class C11334 {

        /* renamed from: $SwitchMap$com$partech$pgscmedia$frameaccess$DecodedMetadataItem$MetadataItemIDs */
        static final /* synthetic */ int[] f8364x595b2200;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(3:51|52|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|54) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs[] r0 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8364x595b2200 = r0
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_LATITUDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x001d }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_LONGITUDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_TRUE_ALTITUDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_DESIGNATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x003e }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_MISSION_ID     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_TAIL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_LATITUDE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_LONGITUDE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x006c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_ELEVATION     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_FRAME_CENTER_HEIGHT_ABOVE_ELLIPSOID     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_1     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_1     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x009c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_2     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_2     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_3     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_3     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LATITUDE_POINT_4     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_CORNER_LONGITUDE_POINT_4     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_HEADING_ANGLE     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_PITCH_ANGLE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_PLATFORM_ROLL_ANGLE     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_AZIMUTH_ANGLE     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_ELEVATION_ANGLE     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_RELATIVE_ROLL_ANGLE     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x012c }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_HORIZONTAL_FIELD_OF_VIEW     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = f8364x595b2200     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.partech.pgscmedia.frameaccess.DecodedMetadataItem$MetadataItemIDs r1 = com.partech.pgscmedia.frameaccess.DecodedMetadataItem.MetadataItemIDs.METADATA_ITEMID_SENSOR_VERTICAL_FIELD_OF_VIEW     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.MpegStreamHandler.C11334.<clinit>():void");
        }
    }

    public void run() {
        StatusUpdateConsumer statusUpdateConsumer;
        MpegStreamKLVListener mpegStreamKLVListener2;
        boolean z = true;
        try {
            Thread thread2 = new Thread(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.atakmap.comms.j$a} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r11 = this;
                        java.lang.String r0 = "rtsp://"
                        java.lang.String r1 = "MpegStreamHandler"
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        r2.setupTmpDir()     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.sourceAddress     // Catch:{ Exception -> 0x0164 }
                        java.net.InetAddress r2 = java.net.InetAddress.getByName(r2)     // Catch:{ Exception -> 0x0164 }
                        boolean r2 = r2.isMulticastAddress()     // Catch:{ Exception -> 0x0164 }
                        r3 = 0
                        if (r2 == 0) goto L_0x005b
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.srcNetwork     // Catch:{ Exception -> 0x0164 }
                        if (r2 == 0) goto L_0x005b
                        java.util.List r2 = com.atakmap.comms.j.a()     // Catch:{ Exception -> 0x0164 }
                        java.util.Iterator r4 = r2.iterator()     // Catch:{ Exception -> 0x0164 }
                        r5 = r3
                    L_0x002b:
                        boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x0164 }
                        if (r6 == 0) goto L_0x0047
                        java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.comms.j$a r6 = (com.atakmap.comms.j.a) r6     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r7 = r6.b     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r8 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r8 = r8.srcNetwork     // Catch:{ Exception -> 0x0164 }
                        boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0164 }
                        if (r7 == 0) goto L_0x002b
                        r5 = r6
                        goto L_0x002b
                    L_0x0047:
                        boolean r4 = r2.isEmpty()     // Catch:{ Exception -> 0x0164 }
                        if (r4 != 0) goto L_0x0057
                        if (r5 != 0) goto L_0x0057
                        r4 = 0
                        java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0164 }
                        r5 = r2
                        com.atakmap.comms.j$a r5 = (com.atakmap.comms.j.a) r5     // Catch:{ Exception -> 0x0164 }
                    L_0x0057:
                        if (r5 == 0) goto L_0x005b
                        java.lang.String r3 = r5.d     // Catch:{ Exception -> 0x0164 }
                    L_0x005b:
                        r9 = r3
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.io.File r2 = r2.sdpFile     // Catch:{ Exception -> 0x0164 }
                        if (r2 == 0) goto L_0x0092
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164 }
                        r0.<init>()     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = "Starting stream capture from sdp file... "
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.io.File r2 = r2.sdpFile     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.getCanonicalPath()     // Catch:{ Exception -> 0x0164 }
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.coremap.log.Log.d(r1, r0)     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor r2 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ Exception -> 0x0164 }
                        java.io.File r3 = r0.sdpFile     // Catch:{ Exception -> 0x0164 }
                        r2.<init>(r3)     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor unused = r0.processor = r2     // Catch:{ Exception -> 0x0164 }
                        goto L_0x016a
                    L_0x0092:
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.sourceUri     // Catch:{ Exception -> 0x0164 }
                        if (r2 == 0) goto L_0x00d0
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.sourceUri     // Catch:{ Exception -> 0x0164 }
                        boolean r2 = r2.startsWith(r0)     // Catch:{ Exception -> 0x0164 }
                        if (r2 == 0) goto L_0x00d0
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.sourceUri     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r3 = ""
                        java.lang.String r5 = r2.replace(r0, r3)     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor r2 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ Exception -> 0x0164 }
                        int r6 = r0.sourceTimeout     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r3 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r7 = r3.NETWORK_BUFTIME     // Catch:{ Exception -> 0x0164 }
                        r8 = 0
                        com.atakmap.android.uastool.MpegStreamHandler r3 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.io.File r9 = r3.tmpDir     // Catch:{ Exception -> 0x0164 }
                        r4 = r2
                        r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor unused = r0.processor = r2     // Catch:{ Exception -> 0x0164 }
                        goto L_0x016a
                    L_0x00d0:
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r0 = r0.sourceUri     // Catch:{ Exception -> 0x0164 }
                        if (r0 == 0) goto L_0x00e8
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor r2 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r3 = r0.sourceUri     // Catch:{ Exception -> 0x0164 }
                        r2.<init>(r3)     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor unused = r0.processor = r2     // Catch:{ Exception -> 0x0164 }
                        goto L_0x016a
                    L_0x00e8:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164 }
                        r0.<init>()     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = "Starting stream capture... "
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = r2.sourceAddress     // Catch:{ Exception -> 0x0164 }
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r2 = ":"
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r2 = r2.sourcePort     // Catch:{ Exception -> 0x0164 }
                        r0.append(r2)     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.coremap.log.Log.d(r1, r0)     // Catch:{ Exception -> 0x0164 }
                        if (r9 != 0) goto L_0x013b
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor r9 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r3 = r0.sourceAddress     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r4 = r2.sourcePort     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r5 = r2.sourceTimeout     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r6 = r2.NETWORK_BUFTIME     // Catch:{ Exception -> 0x0164 }
                        r7 = 0
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.io.File r8 = r2.tmpDir     // Catch:{ Exception -> 0x0164 }
                        r2 = r9
                        r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor unused = r0.processor = r9     // Catch:{ Exception -> 0x0164 }
                        goto L_0x016a
                    L_0x013b:
                        com.atakmap.android.uastool.MpegStreamHandler r0 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor r10 = new com.partech.pgscmedia.MediaProcessor     // Catch:{ Exception -> 0x0164 }
                        java.lang.String r3 = r0.sourceAddress     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r4 = r2.sourcePort     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r5 = r2.sourceTimeout     // Catch:{ Exception -> 0x0164 }
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        int r6 = r2.NETWORK_BUFTIME     // Catch:{ Exception -> 0x0164 }
                        r7 = 0
                        com.atakmap.android.uastool.MpegStreamHandler r2 = com.atakmap.android.uastool.MpegStreamHandler.this     // Catch:{ Exception -> 0x0164 }
                        java.io.File r8 = r2.tmpDir     // Catch:{ Exception -> 0x0164 }
                        r2 = r10
                        r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0164 }
                        com.partech.pgscmedia.MediaProcessor unused = r0.processor = r10     // Catch:{ Exception -> 0x0164 }
                        goto L_0x016a
                    L_0x0164:
                        r0 = move-exception
                        java.lang.String r2 = "Error Starting MediaProcessor"
                        com.atakmap.coremap.log.Log.e(r1, r2, r0)
                    L_0x016a:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.MpegStreamHandler.C11301.run():void");
                }
            });
            thread2.start();
            thread2.join();
            MediaProcessor mediaProcessor = this.processor;
            if (mediaProcessor == null) {
                thread2.interrupt();
                this.isRunning = false;
                UASToolDropDownReceiver.toast("Unable to start video, Processor did not start");
                this.mpegStreamKLVListener.streamStartupFailed();
                return;
            }
            try {
                boolean mediaConsumer = mediaProcessor.setMediaConsumer(MediaProcessor.MediaFileType.MEDIATYPE_MPEGTS, this);
                this.recordSupported = mediaConsumer;
                if (!mediaConsumer) {
                    Log.d(TAG, "could not record from this stream, format not supported");
                }
                UASToolDropDownReceiver.onUasItemStatusChanged();
            } catch (Exception e) {
                Log.d(TAG, "could not record from this stream", e);
                this.recordSupported = false;
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
            Log.d(TAG, "Processor initialized...");
            StatusUpdateConsumer statusUpdateConsumer2 = this.currentStatusConsumer;
            if (statusUpdateConsumer2 != null) {
                this.processor.setStatusUpdateConsumer(statusUpdateConsumer2);
            }
            VideoMediaFormat[] trackInfo = this.processor.getTrackInfo();
            int length = trackInfo.length;
            int i = 0;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (i >= length) {
                    break;
                }
                VideoMediaFormat videoMediaFormat = trackInfo[i];
                if (videoMediaFormat.type == MediaFormat.Type.FORMAT_VIDEO) {
                    Log.d(TAG, "Video track found...");
                    setupVideo(videoMediaFormat);
                    z2 = true;
                }
                if (videoMediaFormat.type == MediaFormat.Type.FORMAT_KLV) {
                    Log.d(TAG, "KLV track found...");
                    this.processor.setKLVConsumer(videoMediaFormat.trackNum, this);
                    z3 = true;
                }
                if (z3 && z2) {
                    break;
                }
                i++;
            }
            if (z2) {
                this.processor.start();
                MpegStreamKLVListener mpegStreamKLVListener3 = this.mpegStreamKLVListener;
                if (mpegStreamKLVListener3 != null) {
                    mpegStreamKLVListener3.streamStarted();
                }
                if (!z3) {
                    Log.e(TAG, "KLV track NOT found!");
                }
                z = false;
                if (this.processor != null) {
                    synchronized (this) {
                        while (this.shouldRun) {
                            try {
                                wait();
                            } catch (InterruptedException unused) {
                                Log.e(TAG, "Processor execution interrupted!");
                            }
                        }
                    }
                }
                Log.e(TAG, "Ending stream capture.");
                destroyConnection();
                synchronized (this) {
                    this.isRunning = false;
                    notifyAll();
                }
                if (z && (mpegStreamKLVListener2 = this.mpegStreamKLVListener) != null) {
                    mpegStreamKLVListener2.streamStartupFailed();
                }
                if (z && (statusUpdateConsumer = this.currentStatusConsumer) != null) {
                    statusUpdateConsumer.mediaEOF();
                    return;
                }
                return;
            }
            Log.e(TAG, "Video track NOT found!");
            throw new Exception();
        } catch (Exception e2) {
            Log.e(TAG, "Exception encountered", e2);
        }
    }

    private void setupVideo(VideoMediaFormat videoMediaFormat) {
        Surface surface = this.outputSurface;
        if (surface != null) {
            this.videoConsumer = new SurfaceVideoConsumer(surface) {
                public void mediaVideoFrame(VideoFrameData videoFrameData) {
                    MpegStreamHandler.super.mediaVideoFrame(videoFrameData);
                }
            };
            UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(videoMediaFormat.frameWidth, videoMediaFormat.frameHeight);
        } else if (this.outputImageView != null) {
            this.videoConsumer = new ImageViewRenderer(this.outputImageView, videoMediaFormat, (TextView) null, (SeekBar) null, (i) null, false);
        }
        this.processor.setVideoConsumer(videoMediaFormat.trackNum, this.videoConsumer);
    }

    /* access modifiers changed from: private */
    public void setupTmpDir() {
        File file = new File(Environment.getExternalStorageDirectory(), TEMP_DIR);
        if (!file.exists() && !file.mkdirs()) {
            Log.d(TAG, "could not create: " + file);
        }
        File createTempFile = File.createTempFile("stream", (String) null, file);
        this.tmpDir = createTempFile;
        if (!createTempFile.delete()) {
            Log.d(TAG, "could not delete: " + this.tmpDir);
        }
        if (!this.tmpDir.mkdirs()) {
            Log.d(TAG, "could not create: " + this.tmpDir);
        }
    }

    private void cleanTmpDirs() {
        File file = new File(Environment.getExternalStorageDirectory(), TEMP_DIR);
        if (file.exists()) {
            FileSystemUtils.deleteDirectory(file, true);
        }
    }

    public void setMpegStreamKLVListener(MpegStreamKLVListener mpegStreamKLVListener2) {
        this.mpegStreamKLVListener = mpegStreamKLVListener2;
    }

    private void destroyConnection() {
        try {
            MediaProcessor mediaProcessor = this.processor;
            if (mediaProcessor != null) {
                mediaProcessor.stop();
                final MediaProcessor mediaProcessor2 = this.processor;
                new Thread(new Runnable() {
                    public void run() {
                        mediaProcessor2.destroy();
                    }
                }, "video-resource-reaper").start();
                this.processor = null;
            }
            SurfaceVideoConsumer surfaceVideoConsumer = this.videoConsumer;
            if (surfaceVideoConsumer != null && (surfaceVideoConsumer instanceof SurfaceVideoConsumer)) {
                surfaceVideoConsumer.a();
            } else if (surfaceVideoConsumer != null && (surfaceVideoConsumer instanceof ImageViewRenderer)) {
                ((ImageViewRenderer) surfaceVideoConsumer).destroy();
            }
            this.videoConsumer = null;
            this.metadataDecoder.clear();
            cleanTmpDirs();
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    public void setStatusUpdateConsumer(StatusUpdateConsumer statusUpdateConsumer) {
        this.currentStatusConsumer = statusUpdateConsumer;
        MediaProcessor mediaProcessor = this.processor;
        if (mediaProcessor != null) {
            mediaProcessor.setStatusUpdateConsumer(statusUpdateConsumer);
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void record(boolean z) {
        Log.d(TAG, "Video Recording: " + z);
        if (z) {
            long milliseconds = new CoordinatedTime().getMilliseconds();
            File item = FileSystemUtils.getItem(VIDEO_DIRNAME + File.separator + ((SimpleDateFormat) recdirDateFormatter.get()).format(Long.valueOf(milliseconds)));
            if (!IOProviderFactory.exists(item) && !IOProviderFactory.mkdirs(item)) {
                Log.e(TAG, "Failed to make directory at " + item.getAbsolutePath());
            }
            File file = new File(item.toString() + File.separator + "UASTOOL_" + ((SimpleDateFormat) recDateFormatter.get()).format(Long.valueOf(milliseconds)) + ".mpg");
            try {
                if (!IOProviderFactory.createNewFile(file)) {
                    UASToolDropDownReceiver.toast("Recording file could not be created");
                    Log.e(TAG, "Recording file could not be created");
                    UASToolDropDownReceiver.onUasItemStatusChanged();
                    return;
                }
                UASToolDropDownReceiver.toast("Recording Started");
                Log.i(TAG, "Recording file created: " + file.getAbsolutePath());
                this.recordingStream = new BufferedOutputStream(IOProviderFactory.getOutputStream(file));
            } catch (Exception e) {
                Log.e(TAG, "error starting recording stream", e);
                this.recordingStream = null;
                UASToolDropDownReceiver.toast("Error Starting the Recording");
            }
        } else {
            try {
                OutputStream outputStream = this.recordingStream;
                if (outputStream != null) {
                    outputStream.close();
                }
                this.recordingStream = null;
            } catch (IOException unused) {
                Log.e(TAG, "error closing out the recording stream");
            }
            UASToolDropDownReceiver.toast("Recording stopped");
        }
        UASToolDropDownReceiver.onUasItemStatusChanged();
    }

    public void mediaBytes(int i, byte[] bArr) {
        try {
            OutputStream outputStream = this.recordingStream;
            if (outputStream != null && bArr != null) {
                outputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            Log.e(TAG, "Could not create new file for recording location: " + e);
            this.recordingStream = null;
            UASToolDropDownReceiver.toast("Error Occured Recording");
            UASToolDropDownReceiver.onUasItemStatusChanged();
        }
    }

    public boolean isRecording() {
        return this.recordingStream != null;
    }

    public boolean isRecordingSupported() {
        return this.processor != null && this.recordSupported;
    }
}
