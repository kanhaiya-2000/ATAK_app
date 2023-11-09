package com.autel.common.dsp.evo;

public interface BandwidthInfo {
    BandMode getBandMode();

    Bandwidth getBandwidth();

    int getDownRate();

    int getLossPackages();

    RcType getRcType();

    int getUpRate();

    int getVideoRate();

    boolean isEnableBandMode();

    boolean isNorthAmerica();
}
