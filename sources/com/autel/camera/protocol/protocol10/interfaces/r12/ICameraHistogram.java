package com.autel.camera.protocol.protocol10.interfaces.r12;

import com.autel.camera.protocol.protocol10.engine.HistogramInfo;
import com.autel.common.CallbackWithOneParam;

public interface ICameraHistogram {
    void addHistogramListener(String str, CallbackWithOneParam<HistogramInfo> callbackWithOneParam);

    void removeHistogramListener(String str);
}
