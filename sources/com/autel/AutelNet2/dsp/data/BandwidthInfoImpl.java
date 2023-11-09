package com.autel.AutelNet2.dsp.data;

import com.autel.bean.dsp.BandModeWidthInfo;
import com.autel.bean.dsp.ReportBertInfo;
import com.autel.common.dsp.evo.BandMode;
import com.autel.common.dsp.evo.Bandwidth;
import com.autel.common.dsp.evo.BandwidthInfo;
import com.autel.common.dsp.evo.RcType;

public class BandwidthInfoImpl implements BandwidthInfo {
    public BandModeWidthInfo mBandModeWidthInfo = new BandModeWidthInfo();
    public ReportBertInfo mReportBertInfo = new ReportBertInfo();

    public BandMode getBandMode() {
        return BandMode.find(this.mBandModeWidthInfo.getBandMode());
    }

    public Bandwidth getBandwidth() {
        return Bandwidth.find(this.mBandModeWidthInfo.getBandWidth());
    }

    public int getLossPackages() {
        return this.mReportBertInfo.getLossPackages();
    }

    public int getDownRate() {
        return this.mReportBertInfo.getDownRate();
    }

    public int getUpRate() {
        return this.mReportBertInfo.getUpRate();
    }

    public int getVideoRate() {
        return this.mReportBertInfo.getVideoRate();
    }

    public boolean isNorthAmerica() {
        return this.mBandModeWidthInfo.getDistrict() == 1;
    }

    public boolean isEnableBandMode() {
        return this.mBandModeWidthInfo.getDisableSetBandMode() == 0;
    }

    public RcType getRcType() {
        if (this.mBandModeWidthInfo.getRCType() == 2) {
            return RcType.EVO_2;
        }
        return RcType.find(this.mBandModeWidthInfo.getRCType());
    }

    public String toString() {
        return "mReportBertInfo : " + this.mReportBertInfo + ", mBandModeWidthInfo : " + this.mBandModeWidthInfo;
    }
}
