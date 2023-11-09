package com.autel.common.dsp.evo;

public interface EvoDspInfo {
    BandwidthInfo getBandwidthInfo();

    SignalInfo getSignalStrengthInfo();

    FrameRateInfo getVideoRateInfo();
}
