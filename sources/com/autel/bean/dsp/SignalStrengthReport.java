package com.autel.bean.dsp;

import com.autel.common.dsp.RFData;
import com.autel.common.dsp.evo.SignalInfo;
import java.util.List;

public class SignalStrengthReport implements SignalInfo {
    private static float[] Freq = new float[107];
    private int[] AirRsrpSbler;
    private int AirSnr;
    private List<ChannelInfo> ChannelList;
    private int ConnectStatus;
    private int CurrentDownFrequency;
    private int CurrentFrequencyChannel;
    private int CurrentUpFrequency;
    private int[] DBler;
    private int FrequencyOffset;
    private int[] Gain;
    private int MCS;
    private int MasterSnr;
    private int[] MeanPower;
    private int Role;
    private int[] SignalStrengthList;
    private float Speed;
    private int TeacherMode;
    private int[] rsrp;

    static {
        for (int i = 0; i < 80; i++) {
            Freq[i] = (float) (((double) i) + 2402.5d);
        }
        for (int i2 = 0; i2 < 27; i2++) {
            Freq[i2 + 80] = (float) (i2 + 902);
        }
    }

    public float[] getFreq() {
        return Freq;
    }

    public int[] getSignalStrengthList() {
        return this.SignalStrengthList;
    }

    public void setSignalStrengthList(int[] iArr) {
        this.SignalStrengthList = iArr;
    }

    public void setTeacherMode(int i) {
        this.TeacherMode = i;
    }

    public int getRole() {
        return this.Role;
    }

    public int getTeacherMode() {
        return this.TeacherMode;
    }

    public void setRole(int i) {
        this.Role = i;
    }

    public int[] getRsrp() {
        return this.rsrp;
    }

    public void setRsrp(int[] iArr) {
        this.rsrp = iArr;
    }

    public int[] getAirRsrpSbler() {
        return this.AirRsrpSbler;
    }

    public void setAirRsrpSbler(int[] iArr) {
        this.AirRsrpSbler = iArr;
    }

    public int[] getDBler() {
        return this.DBler;
    }

    public void setDBler(int[] iArr) {
        this.DBler = iArr;
    }

    public int getMasterSnr() {
        return this.MasterSnr;
    }

    public void setMasterSnr(int i) {
        this.MasterSnr = i;
    }

    public int getAirSnr() {
        return this.AirSnr;
    }

    public void setAirSnr(int i) {
        this.AirSnr = i;
    }

    public int getCurrentFrequencyChannel() {
        return this.CurrentFrequencyChannel;
    }

    public void setCurrentFrequencyChannel(int i) {
        this.CurrentFrequencyChannel = i;
    }

    public RFData getCurrentRFData() {
        int currentFrequencyChannel;
        if (this.ChannelList != null) {
            int currentFrequencyChannel2 = getCurrentFrequencyChannel() - 1;
            if (currentFrequencyChannel2 < 0 || currentFrequencyChannel2 >= this.ChannelList.size()) {
                return null;
            }
            return new RFData(this.ChannelList.get(currentFrequencyChannel2).getFreq(), this.ChannelList.get(currentFrequencyChannel2).getStrength());
        } else if (this.SignalStrengthList == null || getCurrentFrequencyChannel() - 1 < 0) {
            return null;
        } else {
            float[] fArr = Freq;
            if (currentFrequencyChannel < fArr.length) {
                return new RFData(fArr[currentFrequencyChannel], this.SignalStrengthList[currentFrequencyChannel]);
            }
            return null;
        }
    }

    public RFData[] getRFDataList() {
        List<ChannelInfo> list = this.ChannelList;
        int i = 0;
        if (list != null) {
            RFData[] rFDataArr = new RFData[list.size()];
            for (ChannelInfo next : this.ChannelList) {
                rFDataArr[i] = new RFData(next.getFreq(), next.getStrength());
                i++;
            }
            return rFDataArr;
        }
        int[] iArr = this.SignalStrengthList;
        if (iArr == null) {
            return null;
        }
        RFData[] rFDataArr2 = new RFData[iArr.length];
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.SignalStrengthList;
            if (i >= iArr2.length) {
                return rFDataArr2;
            }
            rFDataArr2[i2] = new RFData(Freq[i], iArr2[i]);
            i++;
            i2++;
        }
    }

    public int getUpstreamFrequency() {
        return this.CurrentUpFrequency;
    }

    public int getDownstreamFrequency() {
        return this.CurrentDownFrequency;
    }

    public int getFrequencyOffset() {
        return this.FrequencyOffset;
    }

    public int[] getMeanPower() {
        return this.MeanPower;
    }

    public int getMCS() {
        return this.MCS;
    }

    public void setMCS(int i) {
        this.MCS = i;
    }

    public float getSpeed() {
        return this.Speed;
    }

    public void setSpeed(float f) {
        this.Speed = f;
    }

    public void setMeanPower(int[] iArr) {
        this.MeanPower = iArr;
    }

    public int[] getGain() {
        return this.Gain;
    }

    public void setGain(int[] iArr) {
        this.Gain = iArr;
    }

    public int getCurrentUpFrequency() {
        return this.CurrentUpFrequency;
    }

    public void setCurrentUpFrequency(int i) {
        this.CurrentUpFrequency = i;
    }

    public int getCurrentDownFrequency() {
        return this.CurrentDownFrequency;
    }

    public void setCurrentDownFrequency(int i) {
        this.CurrentDownFrequency = i;
    }

    public void setFrequencyOffset(int i) {
        this.FrequencyOffset = i;
    }

    public List<ChannelInfo> getChannelList() {
        return this.ChannelList;
    }

    public void setChannelList(List<ChannelInfo> list) {
        this.ChannelList = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentFrequencyChannel : ");
        sb.append(this.CurrentFrequencyChannel);
        sb.append(", current RFData : ");
        sb.append(getCurrentRFData());
        sb.append(", ChannelList.size : ");
        List<ChannelInfo> list = this.ChannelList;
        sb.append(list != null ? list.size() : this.SignalStrengthList.length);
        sb.append(", MeanPower[0] : ");
        sb.append(this.MeanPower[0]);
        sb.append(" MeanPower[1]:");
        sb.append(this.MeanPower[1]);
        sb.append(", Gain[0] : ");
        sb.append(this.Gain[0]);
        sb.append(" Gain[1]:");
        sb.append(this.Gain[1]);
        sb.append(", CurrentUpFrequency : ");
        sb.append(this.CurrentUpFrequency);
        sb.append(", CurrentDownFrequency : ");
        sb.append(this.CurrentDownFrequency);
        sb.append(", FrequencyOffset : ");
        sb.append(this.FrequencyOffset);
        sb.append(", MCS : ");
        sb.append(this.MCS);
        sb.append(", Speed : ");
        sb.append(this.Speed);
        sb.append(" TeacherMode:");
        sb.append(this.TeacherMode);
        sb.append(" role:");
        sb.append(this.Role);
        return sb.toString();
    }

    public int getConnectStatus() {
        return this.ConnectStatus;
    }

    public void setConnectStatus(int i) {
        this.ConnectStatus = i;
    }
}
