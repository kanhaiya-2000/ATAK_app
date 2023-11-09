package com.atakmap.android.uastool.p000av;

import com.atakmap.coremap.log.Log;

/* renamed from: com.atakmap.android.uastool.av.BatteryStatus */
class BatteryStatus extends GCSMessage {
    private static final String TAG = "BatteryStatus";
    private byte commandByte;
    private byte deviceType;
    private boolean intercellVoltageCommand;
    private boolean intercellVoltageOutputs;
    private boolean motorVoltageCommand;
    private boolean motorVoltageOutputs;
    private double outputCurrent;
    private double pcbaTemp;
    private double remainingCapacity;
    private boolean systemCommand;
    private boolean systemVoltageOutput;
    private double temperature;
    private double totalCapacity;
    private double voltage;

    public BatteryStatus(byte[] bArr) {
        boolean z = false;
        try {
            this.deviceType = bArr[0];
            byte b = bArr[1];
            this.commandByte = b;
            this.intercellVoltageCommand = (b & 64) == 64;
            this.motorVoltageCommand = (b & 32) == 32;
            this.systemCommand = (b & 16) == 16;
            this.intercellVoltageOutputs = (b & 4) == 4;
            this.motorVoltageOutputs = (b & 2) == 2;
            this.systemVoltageOutput = (b & 1) == 1 ? true : z;
            this.temperature = getDouble(bArr[2], bArr[3], 0.01d);
            this.voltage = getDouble(bArr[4], bArr[5], 0.001d);
            this.outputCurrent = getDouble(bArr[6], bArr[7], 0.01d);
            this.totalCapacity = getDouble(bArr[8], bArr[9], 1.0d);
            this.remainingCapacity = getDouble(bArr[10], bArr[11], 1.0d);
            this.pcbaTemp = getDouble(bArr[12], bArr[13], 0.01d);
        } catch (Exception e) {
            Log.e(TAG, "Parsing exception", e);
        }
    }

    public double getTotalCapacity() {
        return this.totalCapacity;
    }

    public double getRemainingCapacity() {
        return this.remainingCapacity;
    }

    public double getVoltage() {
        return this.voltage;
    }
}
