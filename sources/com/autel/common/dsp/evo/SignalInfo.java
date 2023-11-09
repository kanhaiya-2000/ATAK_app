package com.autel.common.dsp.evo;

import com.autel.common.dsp.RFData;

public interface SignalInfo {
    RFData getCurrentRFData();

    int getDownstreamFrequency();

    int getFrequencyOffset();

    int[] getGain();

    int getMCS();

    int[] getMeanPower();

    RFData[] getRFDataList();

    float getSpeed();

    int getUpstreamFrequency();
}
