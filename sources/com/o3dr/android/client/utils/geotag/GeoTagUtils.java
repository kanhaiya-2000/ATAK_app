package com.o3dr.android.client.utils.geotag;

import android.media.ExifInterface;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.o3dr.android.client.utils.data.tlog.TLogParser;
import com.o3dr.android.client.utils.geotag.GeoTagAsyncTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoTagUtils {

    public interface GeoTagListener {
        void onProgress(int i, int i2);
    }

    private GeoTagUtils() {
    }

    public static ResultObject geotag(File file, List<TLogParser.Event> list, ArrayList<File> arrayList, GeoTagAsyncTask.GeoTagAlgorithm geoTagAlgorithm, GeoTagListener geoTagListener) {
        ResultObject resultObject = new ResultObject();
        try {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            resultObject.setResult(hashMap, hashMap2, hashMap3);
            if (!file.mkdirs()) {
                resultObject.setException(new IllegalStateException("Failed to create directory for images"));
                return resultObject;
            }
            HashMap<TLogParser.Event, File> match = geoTagAlgorithm.match(list, arrayList);
            if (match != null) {
                if (!match.isEmpty()) {
                    if (!hasEnoughMemory(file, match.values())) {
                        resultObject.setException(new IllegalStateException("Insufficient external storage space."));
                        return resultObject;
                    }
                    int size = match.size();
                    int i = 0;
                    for (Map.Entry next : match.entrySet()) {
                        File file2 = (File) next.getValue();
                        TLogParser.Event event = (TLogParser.Event) next.getKey();
                        File file3 = new File(file, file2.getName());
                        try {
                            copyFile(file2, file3);
                            updateExif(event, file3);
                            hashMap.put(event, file3);
                            hashMap2.put(file2, file3);
                        } catch (Exception e) {
                            hashMap3.put(file2, e);
                        }
                        i++;
                        if (geoTagListener != null) {
                            geoTagListener.onProgress(i, size);
                        }
                    }
                    return resultObject;
                }
            }
            resultObject.setException(new IllegalStateException("Unable to match the media set for geotagging."));
            return resultObject;
        } catch (Exception e2) {
            resultObject.setException(e2);
        }
    }

    private static boolean hasEnoughMemory(File file, Collection<File> collection) {
        long usableSpace = file.getUsableSpace();
        long j = 0;
        for (File length : collection) {
            j += length.length();
        }
        return j <= usableSpace;
    }

    private static void copyFile(File file, File file2) {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            }
        }
    }

    private static void updateExif(TLogParser.Event event, File file) {
        msg_camera_feedback msg_camera_feedback = (msg_camera_feedback) event.getMavLinkMessage();
        double d = ((double) msg_camera_feedback.lat) / 1.0E7d;
        double d2 = ((double) msg_camera_feedback.lng) / 1.0E7d;
        String valueOf = String.valueOf(msg_camera_feedback.alt_msl);
        ExifInterface exifInterface = new ExifInterface(file.getPath());
        exifInterface.setAttribute("GPSLongitude", convertLatLngToDMS(d2));
        exifInterface.setAttribute("GPSLatitude", convertLatLngToDMS(d));
        exifInterface.setAttribute("GPSLatitudeRef", d < 0.0d ? "S" : "N");
        exifInterface.setAttribute("GPSLongitudeRef", d2 < 0.0d ? "W" : "E");
        exifInterface.setAttribute("GPSAltitude", valueOf);
        exifInterface.saveAttributes();
    }

    private static String convertLatLngToDMS(double d) {
        double abs = Math.abs(d);
        int i = (int) abs;
        double d2 = (abs - ((double) i)) * 60.0d;
        int i2 = (int) d2;
        return String.format("%s/1,%s/1,%s/1000", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) ((d2 - ((double) i2)) * 60.0d * 1000.0d))});
    }

    public static class ResultObject {
        private boolean didSucceed;
        private HashMap<TLogParser.Event, File> eventsPhotos;
        private Exception exception;
        private HashMap<File, Exception> failedFiles;
        private HashMap<File, File> geoTaggedPhotos;

        public boolean didSucceed() {
            return this.didSucceed;
        }

        public void setResult(HashMap<TLogParser.Event, File> hashMap, HashMap<File, File> hashMap2, HashMap<File, Exception> hashMap3) {
            this.didSucceed = true;
            this.eventsPhotos = hashMap;
            this.geoTaggedPhotos = hashMap2;
            this.failedFiles = hashMap3;
        }

        public HashMap<File, File> getGeoTaggedPhotos() {
            return this.geoTaggedPhotos;
        }

        public HashMap<TLogParser.Event, File> getEventsPhotos() {
            return this.eventsPhotos;
        }

        public HashMap<File, Exception> getFailedFiles() {
            return this.failedFiles;
        }

        public Exception getException() {
            return this.exception;
        }

        public void setException(Exception exc) {
            this.didSucceed = false;
            this.exception = exc;
        }
    }
}
