package com.autel.common.dsp.evo;

public interface FrameRateInfo {
    int getBitRate();

    int getFrameRate();

    int getResolution();

    boolean isIFrameEnable();
}
