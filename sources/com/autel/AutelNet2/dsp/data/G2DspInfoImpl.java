package com.autel.AutelNet2.dsp.data;

import com.autel.bean.dsp.SignalStrengthReport;
import com.autel.bean.dsp.VideoRateInfoImpl;
import com.autel.common.dsp.evo.BandwidthInfo;
import com.autel.common.dsp.evo.EvoDspInfo;
import com.autel.common.dsp.evo.FrameRateInfo;
import com.autel.common.dsp.evo.SignalInfo;

public class G2DspInfoImpl implements EvoDspInfo {
    public BandwidthInfo mBandwidthInfo = new BandwidthInfoImpl();
    public FrameRateInfo mFrameRateInfo = new VideoRateInfoImpl();
    public SignalInfo mSignalStrengthInfo = new SignalStrengthReport();

    public SignalInfo getSignalStrengthInfo() {
        return this.mSignalStrengthInfo;
    }

    public BandwidthInfo getBandwidthInfo() {
        return this.mBandwidthInfo;
    }

    public FrameRateInfo getVideoRateInfo() {
        return this.mFrameRateInfo;
    }

    public String toString() {
        return "SignalInfo : " + this.mSignalStrengthInfo + ", FrameRateInfo : " + this.mFrameRateInfo + ", BandwidthInfo : " + this.mBandwidthInfo;
    }
}
