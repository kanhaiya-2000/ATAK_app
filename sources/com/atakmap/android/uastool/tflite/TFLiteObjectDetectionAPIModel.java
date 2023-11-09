package com.atakmap.android.uastool.tflite;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Trace;
import com.atakmap.android.uastool.tflite.Detector;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.task.vision.detector.Detection;
import org.tensorflow.lite.task.vision.detector.ObjectDetector;

public class TFLiteObjectDetectionAPIModel implements Detector {
    private static final int NUM_DETECTIONS = 10;
    private static final String TAG = "TFLiteObjectDetectionAPIModelWithTaskApi";
    private final MappedByteBuffer modelBuffer;
    private ObjectDetector objectDetector;
    private final ObjectDetector.ObjectDetectorOptions.Builder optionsBuilder;

    public void enableStatLogging(boolean z) {
    }

    public String getStatString() {
        return "";
    }

    public static Detector create(Context context, String str, String str2, int i, boolean z) {
        return new TFLiteObjectDetectionAPIModel(context, str);
    }

    private TFLiteObjectDetectionAPIModel(Context context, String str) {
        MappedByteBuffer loadMappedFile = FileUtil.loadMappedFile(context, str);
        this.modelBuffer = loadMappedFile;
        ObjectDetector.ObjectDetectorOptions.Builder maxResults = ObjectDetector.ObjectDetectorOptions.builder().setMaxResults(10);
        this.optionsBuilder = maxResults;
        this.objectDetector = ObjectDetector.createFromBufferAndOptions(loadMappedFile, maxResults.build());
    }

    public List<Detector.Recognition> recognizeImage(Bitmap bitmap) {
        Trace.beginSection("recognizeImage");
        List<Detection> detect = this.objectDetector.detect(TensorImage.fromBitmap(bitmap));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Detection next : detect) {
            arrayList.add(new Detector.Recognition("" + i, next.getCategories().get(0).getLabel(), Float.valueOf(next.getCategories().get(0).getScore()), next.getBoundingBox()));
            i++;
        }
        Trace.endSection();
        return arrayList;
    }

    public void close() {
        ObjectDetector objectDetector2 = this.objectDetector;
        if (objectDetector2 != null) {
            objectDetector2.close();
        }
    }

    public void setNumThreads(int i) {
        if (this.objectDetector != null) {
            this.optionsBuilder.setNumThreads(i);
            recreateDetector();
        }
    }

    public void setUseNNAPI(boolean z) {
        throw new UnsupportedOperationException("Manipulating the hardware accelerators is not allowed in the Task library currently. Only CPU is allowed.");
    }

    private void recreateDetector() {
        this.objectDetector.close();
        this.objectDetector = ObjectDetector.createFromBufferAndOptions(this.modelBuffer, this.optionsBuilder.build());
    }
}
