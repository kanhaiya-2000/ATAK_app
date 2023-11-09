package com.atakmap.android.uastool.tflite;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.List;

public interface Detector {
    void close();

    void enableStatLogging(boolean z);

    String getStatString();

    List<Recognition> recognizeImage(Bitmap bitmap);

    void setNumThreads(int i);

    void setUseNNAPI(boolean z);

    public static class Recognition {
        private final Float confidence;

        /* renamed from: id */
        private final String f8416id;
        private RectF location;
        private final String title;

        public Recognition(String str, String str2, Float f, RectF rectF) {
            this.f8416id = str;
            this.title = str2;
            this.confidence = f;
            this.location = rectF;
        }

        public String getId() {
            return this.f8416id;
        }

        public String getTitle() {
            return this.title;
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public RectF getLocation() {
            return new RectF(this.location);
        }

        public void setLocation(RectF rectF) {
            this.location = rectF;
        }

        public String toString() {
            String str = "";
            if (this.f8416id != null) {
                str = str + "[" + this.f8416id + "] ";
            }
            if (this.title != null) {
                str = str + this.title + " ";
            }
            if (this.confidence != null) {
                str = str + String.format("(%.1f%%) ", new Object[]{Float.valueOf(this.confidence.floatValue() * 100.0f)});
            }
            if (this.location != null) {
                str = str + this.location + " ";
            }
            return str.trim();
        }
    }
}
