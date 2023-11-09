package com.autel.sdk10.AutelNet.AutelBattery.info;

import com.autel.common.battery.xstar.XStarBatteryInfo;
import com.autel.internal.sdk.battery.AutelBatteryStatusInternal;

public abstract class AutelBatteryInfo implements XStarBatteryInfo {
    private int[] BatteryHistoryRecords = new int[33];
    private double criticalBatteryWarning;
    private int dischargeDay;
    protected boolean isBatteryHistoryRecordsChecked = false;
    private double lowBatteryWarning;
    private AutelBatteryStatusInternal mBatteryStatus;

    public AutelBatteryStatusInternal getBatteryStatus() {
        if (this.mBatteryStatus == null) {
            this.mBatteryStatus = new AutelBatteryStatusInternal();
        }
        return this.mBatteryStatus;
    }

    public int getDischargeDay() {
        return this.dischargeDay;
    }

    public int[] getBatteryHistoryRecords() {
        return this.BatteryHistoryRecords;
    }

    public boolean isBatteryHistoryRecordsChecked() {
        return this.isBatteryHistoryRecordsChecked;
    }

    public double getLowBatteryWarning() {
        return this.lowBatteryWarning;
    }

    public double getCriticalBatteryWarning() {
        return this.criticalBatteryWarning;
    }

    /* access modifiers changed from: protected */
    public void setDischargeDay(byte b) {
        if (b != 0) {
            this.dischargeDay = b;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0081, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setBatteryHistoryRecord(int[] r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 != 0) goto L_0x0005
            monitor-exit(r8)
            return
        L_0x0005:
            com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser r0 = com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser.getInstance_()     // Catch:{ all -> 0x0082 }
            boolean r0 = r0.isBatteryVersionAboveV522()     // Catch:{ all -> 0x0082 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0045
            int[] r0 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            r3 = 20
            if (r0 == 0) goto L_0x001a
            int r0 = r0.length     // Catch:{ all -> 0x0082 }
            if (r0 == r3) goto L_0x001e
        L_0x001a:
            int[] r0 = new int[r3]     // Catch:{ all -> 0x0082 }
            r8.BatteryHistoryRecords = r0     // Catch:{ all -> 0x0082 }
        L_0x001e:
            r0 = r9[r1]     // Catch:{ all -> 0x0082 }
            r3 = 0
        L_0x0021:
            int r4 = r9.length     // Catch:{ all -> 0x0082 }
            int r4 = r4 - r2
            if (r3 >= r4) goto L_0x003f
            if (r0 != 0) goto L_0x0030
            int[] r4 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            int r5 = r3 + 1
            r5 = r9[r5]     // Catch:{ all -> 0x0082 }
            r4[r3] = r5     // Catch:{ all -> 0x0082 }
            goto L_0x003c
        L_0x0030:
            if (r0 != r2) goto L_0x003c
            int[] r4 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            int r5 = r3 + 10
            int r6 = r3 + 1
            r6 = r9[r6]     // Catch:{ all -> 0x0082 }
            r4[r5] = r6     // Catch:{ all -> 0x0082 }
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x003f:
            if (r0 != r2) goto L_0x0042
            r1 = 1
        L_0x0042:
            r8.isBatteryHistoryRecordsChecked = r1     // Catch:{ all -> 0x0082 }
            goto L_0x0080
        L_0x0045:
            int[] r0 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            r3 = 33
            if (r0 == 0) goto L_0x004e
            int r0 = r0.length     // Catch:{ all -> 0x0082 }
            if (r0 == r3) goto L_0x0052
        L_0x004e:
            int[] r0 = new int[r3]     // Catch:{ all -> 0x0082 }
            r8.BatteryHistoryRecords = r0     // Catch:{ all -> 0x0082 }
        L_0x0052:
            r0 = r9[r1]     // Catch:{ all -> 0x0082 }
            r3 = 2
            if (r0 != 0) goto L_0x0067
            int[] r4 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            r5 = r9[r2]     // Catch:{ all -> 0x0082 }
            r4[r1] = r5     // Catch:{ all -> 0x0082 }
            r5 = r9[r3]     // Catch:{ all -> 0x0082 }
            r4[r2] = r5     // Catch:{ all -> 0x0082 }
            r5 = 3
            r9 = r9[r5]     // Catch:{ all -> 0x0082 }
            r4[r3] = r9     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x0067:
            int r4 = r0 * 5
            int r4 = r4 - r3
            r3 = 1
        L_0x006b:
            int r5 = r9.length     // Catch:{ all -> 0x0082 }
            if (r3 >= r5) goto L_0x007a
            int[] r5 = r8.BatteryHistoryRecords     // Catch:{ all -> 0x0082 }
            int r6 = r3 + -1
            int r6 = r6 + r4
            r7 = r9[r3]     // Catch:{ all -> 0x0082 }
            r5[r6] = r7     // Catch:{ all -> 0x0082 }
            int r3 = r3 + 1
            goto L_0x006b
        L_0x007a:
            r9 = 6
            if (r0 != r9) goto L_0x007e
            r1 = 1
        L_0x007e:
            r8.isBatteryHistoryRecordsChecked = r1     // Catch:{ all -> 0x0082 }
        L_0x0080:
            monitor-exit(r8)
            return
        L_0x0082:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelBattery.info.AutelBatteryInfo.setBatteryHistoryRecord(int[]):void");
    }

    /* access modifiers changed from: protected */
    public void setLowBatteryWarning(double d) {
        this.lowBatteryWarning = d;
    }

    /* access modifiers changed from: protected */
    public void setCriticalBatteryWarning(double d) {
        this.criticalBatteryWarning = d;
    }

    public int[] getVoltageCells() {
        return getBatteryStatus().getBatteryCells();
    }

    public float getVoltage() {
        return (float) getBatteryStatus().getVoltage();
    }

    public float getCapacity() {
        return getBatteryStatus().getCapacity();
    }

    public float getCurrent() {
        return getBatteryStatus().getCurrent();
    }

    public float getTemperature() {
        return getBatteryStatus().getBatteryTemperature() / 10.0f;
    }

    public float getNumberOfDischarges() {
        return getBatteryStatus().getNumberOfDischarges();
    }

    public int getFullChargeCapacity() {
        return getBatteryStatus().getFullChargeCapacity();
    }

    public int getRemainingPercent() {
        return getBatteryStatus().getBatteryRemainingPercent();
    }

    public String getSerialNumber() {
        return getBatteryStatus().getSerialNumber();
    }

    public String getVersion() {
        return getBatteryStatus().getVersion();
    }

    public float getDesignedCapacity() {
        return (float) getBatteryStatus().getDesignCap();
    }

    public String toString() {
        return "getVoltageCells : " + cells() + ", getVoltage: " + getVoltage() + ", getCapacity : " + getCapacity() + ", getCurrent : " + getCurrent() + ", getTemperature : " + getTemperature() + ", getNumberOfDischarges : " + getNumberOfDischarges() + ", getFullChargeCapacity : " + getFullChargeCapacity() + ", getRemainingPercent : " + getRemainingPercent() + ", getSerialNumber : " + getSerialNumber() + ", getVersion : " + getVersion() + ", getDesignedCapacity : " + getDesignedCapacity();
    }

    private String cells() {
        StringBuilder sb;
        String str;
        StringBuffer stringBuffer = new StringBuffer("[");
        int i = 0;
        for (int i2 : getVoltageCells()) {
            if (i == 0) {
                str = "{";
            } else {
                sb = new StringBuilder();
                str = ", {";
            }
            sb.append(str);
            sb.append(i);
            stringBuffer.append(sb.toString());
            stringBuffer.append(" : ");
            stringBuffer.append(i2 + "}");
            i++;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
