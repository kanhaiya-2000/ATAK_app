package com.autel.common.camera.visual;

import com.autel.common.flycontroller.VisualWarnState;

public interface VisualWarningInfo {
    VisualWarnState getWarnState();

    boolean isValid();
}
