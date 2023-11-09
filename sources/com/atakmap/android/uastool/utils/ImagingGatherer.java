package com.atakmap.android.uastool.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import atak.core.agl;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.overlays.moasic.GLSurfaceLayer;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.utils.GLVideoConsumer;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.io.IOProviderFactory;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.layer.opengl.GLLayerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class ImagingGatherer implements Runnable {
    private static final String BASE_DIR = "ImagingGatherer";
    private static final String DIRPATH_IMAGING = (FileSystemUtils.getRoot().getPath() + File.separatorChar + "tools" + File.separatorChar + "uastool" + File.separator + "imaging");
    private static final String KMZ_FOLDER_TAG_DESCRIPTION = "ATAK UASTool Survey Imagery";
    private static final String TAG = "ImagingGatherer";
    private final StringBuilder KMLBuilder;
    private boolean addImageLayerToMap = false;
    private final ControlFragment controlFragment;
    private boolean folderElemAdded;
    private GLVideoConsumer glVideoConsumer;
    private final List<SurfaceLayer> imagingLayers = new ArrayList();
    private final String initalizationDateTimeStr = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(new GregorianCalendar().getTime()).replace(" ", "-").replace("/", "-");
    private boolean isRunning;
    private boolean shouldRun;
    private Thread thread;
    private final Float timerInterval;
    private File tmpDir;
    private final UASItem uasItem;

    private String getKMLEnding() {
        return "</Folder></kml>";
    }

    public ImagingGatherer(UASItem uASItem, ControlFragment controlFragment2, Float f) {
        this.uasItem = uASItem;
        this.timerInterval = Float.valueOf(f.floatValue() * 1000.0f);
        this.controlFragment = controlFragment2;
        this.KMLBuilder = new StringBuilder();
        initializeKMLBuilder();
    }

    public void run() {
        FieldOfView computeFov;
        try {
            startOffscreenVideoConsumer();
            createSessionFolder(this.uasItem.getCallsign());
            UASToolDropDownReceiver.toast("Images stored in device folder - " + this.tmpDir);
            int i = 0;
            while (this.shouldRun) {
                try {
                    if (this.controlFragment.previewSnapshotReady() && (computeFov = this.uasItem.computeFov()) != null && computeFov.isValid()) {
                        Bitmap currentBitmap = this.glVideoConsumer.getCurrentBitmap();
                        if (currentBitmap != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.uasItem.getCallsign());
                            sb.append("-");
                            int i2 = i + 1;
                            try {
                                sb.append(i);
                                String sb2 = sb.toString();
                                addImageToFolder(sb2, computeFov, currentBitmap, !this.addImageLayerToMap);
                                if (this.addImageLayerToMap) {
                                    Log.d("ImagingGatherer", "Creating layer - " + this.imagingLayers.size());
                                    SurfaceLayer surfaceLayer = new SurfaceLayer(UASToolDropDownReceiver.getInstance().getPluginContext(), computeFov, sb2, currentBitmap);
                                    this.imagingLayers.add(surfaceLayer);
                                    MapView.getMapView().a(MapView.a.c, surfaceLayer);
                                    surfaceLayer.setVisible(true);
                                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
                                }
                                i = i2;
                            } catch (InterruptedException unused) {
                                i = i2;
                                Log.e("ImagingGatherer", "Image gathering execution interrupted!");
                            }
                        } else {
                            Log.e("ImagingGatherer", "Failed to get bitmap from video handler. Current number of images saved - " + i);
                        }
                    }
                    Thread.sleep(this.timerInterval.longValue());
                } catch (InterruptedException unused2) {
                    Log.e("ImagingGatherer", "Image gathering execution interrupted!");
                }
            }
            Log.d("ImagingGatherer", "ImageGathering thread stopped");
            stopOffscreenVideoConsumer();
        } finally {
            cleanTmpDirs();
        }
    }

    private void startOffscreenVideoConsumer() {
        try {
            this.glVideoConsumer = new GLVideoConsumer(UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(), UASToolDropDownReceiver.getReflector().usesYUVTexture());
        } catch (agl unused) {
            Log.e("ImagingGatherer", "VideoConsumer init failed");
        }
        try {
            this.glVideoConsumer.start();
        } catch (GLVideoConsumer.VideoConsumerException unused2) {
            this.glVideoConsumer = null;
            Log.e("ImagingGatherer", "VideoConsumer start failed");
        }
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(this.glVideoConsumer);
    }

    private void stopOffscreenVideoConsumer() {
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(this.glVideoConsumer);
        this.glVideoConsumer.stop();
        this.glVideoConsumer = null;
    }

    private void createKMZ(File file, String str) {
        try {
            File file2 = new File(DIRPATH_IMAGING, str);
            FileSystemUtils.delete(file2);
            FileSystemUtils.zipDirectory(file, file2);
        } catch (IOException e) {
            Log.d("ImagingGatherer", "Unable to zip directory files", e);
        }
    }

    private void addImageToFolder(String str, FieldOfView fieldOfView, Bitmap bitmap, boolean z) {
        String sanitizeFilename = FileSystemUtils.sanitizeFilename(str.replaceAll("\\s+", "_"));
        if (this.tmpDir != null) {
            File file = this.tmpDir;
            File file2 = new File(file, sanitizeFilename + ".png");
            saveImage(bitmap, file2, z);
            addKML(str, this.tmpDir.getName() + "_" + this.initalizationDateTimeStr, file2.getName(), this.tmpDir, fieldOfView);
        }
    }

    private void initializeKMLBuilder() {
        StringBuilder sb = this.KMLBuilder;
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<kml xmlns='http://www.opengis.net/kml/2.2' xmlns:gx='http://www.google.com/kml/ext/2.2' xmlns:kml='http://www.opengis.net/kml/2.2' xmlns:atom='http://www.w3.org/2005/Atom'>");
    }

    private void addKMLFolderBeginTags(String str) {
        StringBuilder sb = this.KMLBuilder;
        sb.append("<Folder>");
        sb.append("<name>");
        sb.append(str);
        sb.append("</name>");
        sb.append("<description>");
        sb.append(KMZ_FOLDER_TAG_DESCRIPTION);
        sb.append("</description>");
    }

    /* access modifiers changed from: protected */
    public void saveImage(Bitmap bitmap, File file, boolean z) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            if (z) {
                bitmap.recycle();
            }
        } catch (FileNotFoundException e) {
            Log.e("ImagingGatherer", "File not found", e);
        } catch (IOException e2) {
            Log.e("ImagingGatherer", "File io exception", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x014b, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0154, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addKML(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.io.File r10, com.atakmap.android.uastool.utils.FieldOfView r11) {
        /*
            r6 = this;
            java.util.List r11 = r11.getFieldOfViewList()
            java.lang.String r7 = com.atakmap.coremap.cot.event.CotEvent.escapeXmlText(r7)
            java.lang.String r9 = com.atakmap.coremap.cot.event.CotEvent.escapeXmlText(r9)
            java.lang.String r0 = com.atakmap.coremap.cot.event.CotEvent.escapeXmlText(r8)
            java.lang.String r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.sanitizeForWinTAK(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = ".kml"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ".kmz"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            boolean r2 = r6.folderElemAdded
            r3 = 1
            if (r2 != 0) goto L_0x0040
            r6.addKMLFolderBeginTags(r8)
            r6.folderElemAdded = r3
        L_0x0040:
            java.lang.StringBuilder r8 = r6.KMLBuilder
            java.lang.String r2 = "<GroundOverlay>"
            r8.append(r2)
            java.lang.String r2 = "<name>"
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = "</name>"
            r8.append(r7)
            java.lang.String r7 = "<Icon>"
            r8.append(r7)
            java.lang.String r7 = "<href>"
            r8.append(r7)
            r8.append(r9)
            java.lang.String r7 = "</href>"
            r8.append(r7)
            java.lang.String r7 = "<viewBoundScale>0.75</viewBoundScale>"
            r8.append(r7)
            java.lang.String r7 = "</Icon>"
            r8.append(r7)
            java.lang.String r7 = "<gx:LatLonQuad>"
            r8.append(r7)
            java.lang.String r7 = "<coordinates>"
            r8.append(r7)
            r7 = 3
            java.lang.Object r9 = r11.get(r7)
            com.atakmap.coremap.maps.coords.GeoPoint r9 = (com.atakmap.coremap.maps.coords.GeoPoint) r9
            double r4 = r9.getLongitude()
            r8.append(r4)
            java.lang.String r9 = ","
            r8.append(r9)
            java.lang.Object r7 = r11.get(r7)
            com.atakmap.coremap.maps.coords.GeoPoint r7 = (com.atakmap.coremap.maps.coords.GeoPoint) r7
            double r4 = r7.getLatitude()
            r8.append(r4)
            java.lang.String r7 = ",0 "
            r8.append(r7)
            r2 = 2
            java.lang.Object r4 = r11.get(r2)
            com.atakmap.coremap.maps.coords.GeoPoint r4 = (com.atakmap.coremap.maps.coords.GeoPoint) r4
            double r4 = r4.getLongitude()
            r8.append(r4)
            r8.append(r9)
            java.lang.Object r2 = r11.get(r2)
            com.atakmap.coremap.maps.coords.GeoPoint r2 = (com.atakmap.coremap.maps.coords.GeoPoint) r2
            double r4 = r2.getLatitude()
            r8.append(r4)
            r8.append(r7)
            java.lang.Object r2 = r11.get(r3)
            com.atakmap.coremap.maps.coords.GeoPoint r2 = (com.atakmap.coremap.maps.coords.GeoPoint) r2
            double r4 = r2.getLongitude()
            r8.append(r4)
            r8.append(r9)
            java.lang.Object r2 = r11.get(r3)
            com.atakmap.coremap.maps.coords.GeoPoint r2 = (com.atakmap.coremap.maps.coords.GeoPoint) r2
            double r4 = r2.getLatitude()
            r8.append(r4)
            r8.append(r7)
            r2 = 0
            java.lang.Object r4 = r11.get(r2)
            com.atakmap.coremap.maps.coords.GeoPoint r4 = (com.atakmap.coremap.maps.coords.GeoPoint) r4
            double r4 = r4.getLongitude()
            r8.append(r4)
            r8.append(r9)
            java.lang.Object r9 = r11.get(r2)
            com.atakmap.coremap.maps.coords.GeoPoint r9 = (com.atakmap.coremap.maps.coords.GeoPoint) r9
            double r4 = r9.getLatitude()
            r8.append(r4)
            r8.append(r7)
            java.lang.String r7 = "</coordinates>"
            r8.append(r7)
            java.lang.String r7 = "</gx:LatLonQuad>"
            r8.append(r7)
            java.lang.String r7 = "</GroundOverlay>"
            r8.append(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r8 = r6.KMLBuilder
            java.lang.String r8 = r8.toString()
            r7.append(r8)
            java.lang.String r8 = r6.getKMLEnding()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.io.PrintWriter r8 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0155 }
            java.io.OutputStreamWriter r9 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0155 }
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x0155 }
            r11.<init>(r10, r1)     // Catch:{ IOException -> 0x0155 }
            java.io.FileOutputStream r11 = com.atakmap.coremap.io.IOProviderFactory.getOutputStream(r11)     // Catch:{ IOException -> 0x0155 }
            java.nio.charset.Charset r1 = com.atakmap.coremap.filesystem.FileSystemUtils.UTF8_CHARSET     // Catch:{ IOException -> 0x0155 }
            java.lang.String r1 = r1.name()     // Catch:{ IOException -> 0x0155 }
            r9.<init>(r11, r1)     // Catch:{ IOException -> 0x0155 }
            r8.<init>(r9, r3)     // Catch:{ IOException -> 0x0155 }
            r8.println(r7)     // Catch:{ all -> 0x0149 }
            r8.close()     // Catch:{ IOException -> 0x0155 }
            goto L_0x015d
        L_0x0149:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x014b }
        L_0x014b:
            r9 = move-exception
            r8.close()     // Catch:{ all -> 0x0150 }
            goto L_0x0154
        L_0x0150:
            r8 = move-exception
            r7.addSuppressed(r8)     // Catch:{ IOException -> 0x0155 }
        L_0x0154:
            throw r9     // Catch:{ IOException -> 0x0155 }
        L_0x0155:
            r7 = move-exception
            java.lang.String r8 = "ImagingGatherer"
            java.lang.String r9 = "error occurred writing the doc.xml file"
            com.atakmap.coremap.log.Log.d(r8, r9, r7)
        L_0x015d:
            r6.createKMZ(r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.ImagingGatherer.addKML(java.lang.String, java.lang.String, java.lang.String, java.io.File, com.atakmap.android.uastool.utils.FieldOfView):void");
    }

    private void saveKml(String str, String str2, File file, FieldOfView fieldOfView) {
        List<GeoPoint> fieldOfViewList = fieldOfView.getFieldOfViewList();
        String substring = str2.substring(0, str2.lastIndexOf(46));
        String str3 = "<?xml version='1.0' encoding='UTF-8'?><kml xmlns='http://www.opengis.net/kml/2.2' xmlns:gx='http://www.google.com/kml/ext/2.2' xmlns:kml='http://www.opengis.net/kml/2.2' xmlns:atom='http://www.w3.org/2005/Atom'><GroundOverlay><name>" + CotEvent.escapeXmlText(str) + "</name><Icon><href>" + CotEvent.escapeXmlText(str2) + "</href><viewBoundScale>0.75</viewBoundScale></Icon><gx:LatLonQuad><coordinates>" + fieldOfViewList.get(3).getLongitude() + "," + fieldOfViewList.get(3).getLatitude() + ",0 " + fieldOfViewList.get(2).getLongitude() + "," + fieldOfViewList.get(2).getLatitude() + ",0 " + fieldOfViewList.get(1).getLongitude() + "," + fieldOfViewList.get(1).getLatitude() + ",0 " + fieldOfViewList.get(0).getLongitude() + "," + fieldOfViewList.get(0).getLatitude() + ",0</coordinates></gx:LatLonQuad></GroundOverlay></kml>";
        try {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(IOProviderFactory.getOutputStream(new File(file, substring + ".kml")), FileSystemUtils.UTF8_CHARSET.name()));
            printWriter.println(str3);
            printWriter.close();
        } catch (IOException e) {
            Log.d("ImagingGatherer", "error occurred writing the doc.xml file", e);
        }
    }

    private void setupImagingFolder(String str) {
        File file = new File(new File(DIRPATH_IMAGING), "ImagingGatherer");
        if (!file.isDirectory() && !file.mkdirs()) {
            Log.d("ImagingGatherer", "could not make the directory: " + file);
        }
        File file2 = new File(file, str);
        this.tmpDir = file2;
        if (file2.exists()) {
            FileSystemUtils.delete(this.tmpDir);
        }
        if (!this.tmpDir.isDirectory() && !this.tmpDir.mkdirs()) {
            Log.d("ImagingGatherer", "could not make the directory: " + this.tmpDir);
        }
    }

    private void cleanTmpDirs() {
        File file = new File(new File(DIRPATH_IMAGING), "ImagingGatherer");
        if (IOProviderFactory.exists(file)) {
            FileSystemUtils.deleteDirectory(file, false);
        }
    }

    private void createSessionFolder(String str) {
        setupImagingFolder(str);
    }

    public boolean start() {
        if (this.isRunning) {
            Log.e("ImagingGatherer", "Imaging already started!");
            return false;
        } else if (this.controlFragment == null) {
            Log.e("ImagingGatherer", "No imaging source set.");
            return false;
        } else {
            GLLayerFactory.a(GLSurfaceLayer.SPI);
            this.isRunning = true;
            this.shouldRun = true;
            Thread thread2 = new Thread(this);
            this.thread = thread2;
            thread2.setPriority(5);
            this.thread.start();
            return true;
        }
    }

    public void stop() {
        if (this.isRunning) {
            this.shouldRun = false;
        }
    }
}
