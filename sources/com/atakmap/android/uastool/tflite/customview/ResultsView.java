package com.atakmap.android.uastool.tflite.customview;

import com.atakmap.android.uastool.tflite.Detector;
import java.util.List;

public interface ResultsView {
    void setResults(List<Detector.Recognition> list);
}
