package com.autel.AutelNet2.aircraft.battery.engine;

import com.autel.AutelNet2.aircraft.flycontroller.parser.ErrorWarningInternalParser2;
import com.autel.AutelNet2.utils.BytesUtils;
import com.autel.common.battery.BatteryWarning;
import com.autel.common.battery.evo.EvoBatteryInfo;

public class BatteryInfoInternal implements EvoBatteryInfo {
    public static BatteryInfoInternal mBatteryInfoInternal;
    private int CellNumber;
    private int Current;
    private int DesignedCapacity;
    private int DeviceStatus;
    private int Error;
    private int FullCapacity;
    private int PowerStatus;
    private int RemainCapacity;
    private int ResidualTime;
    private int RsocRemainPercent;
    private int SafeStatus;
    private int Temperature;
    private int Voltage;
    private int[] VoltageCell;

    public static BatteryInfoInternal instance() {
        if (mBatteryInfoInternal == null) {
            synchronized (BatteryInfoInternal.class) {
                mBatteryInfoInternal = new BatteryInfoInternal();
            }
        }
        return mBatteryInfoInternal;
    }

    public static void setBatteryInfoInternal(BatteryInfoInternal batteryInfoInternal) {
        mBatteryInfoInternal = batteryInfoInternal;
    }

    protected BatteryInfoInternal() {
    }

    public int getSafeStatus() {
        return this.SafeStatus;
    }

    public void setSafeStatus(int i) {
        this.SafeStatus = i;
    }

    public void setVoltage(int i) {
        this.Voltage = i;
    }

    public int[] getVoltageCells() {
        return this.VoltageCell;
    }

    public float getVoltage() {
        return (float) this.Voltage;
    }

    public float getCapacity() {
        return (float) this.RemainCapacity;
    }

    public float getRemainTime() {
        return ((float) this.RemainCapacity) / 204.0f;
    }

    public float getCurrent() {
        return (float) this.Current;
    }

    public void setCurrent(int i) {
        this.Current = i;
    }

    public float getRemainCapacity() {
        return (float) this.RemainCapacity;
    }

    public void setRemainCapacity(int i) {
        this.RemainCapacity = i;
    }

    public float getFullCapacity() {
        return (float) this.FullCapacity;
    }

    public void setFullCapacity(int i) {
        this.FullCapacity = i;
    }

    public float getDesignedCapacity() {
        return (float) this.DesignedCapacity;
    }

    public BatteryWarning getBatteryWarning() {
        return ErrorWarningInternalParser2.getInstance().getBatteryWarning();
    }

    public int getRemainingPercent() {
        return this.RsocRemainPercent;
    }

    public void setDesignedCapacity(int i) {
        this.DesignedCapacity = i;
    }

    public float getTemperature() {
        return ((float) this.Temperature) / 10.0f;
    }

    public void setTemperature(int i) {
        this.Temperature = i;
    }

    public int getDeviceStatus() {
        return this.DeviceStatus;
    }

    public void setDeviceStatus(int i) {
        this.DeviceStatus = i;
    }

    public int getRsocRemainPercent() {
        return this.RsocRemainPercent;
    }

    public void setRsocRemainPercent(int i) {
        this.RsocRemainPercent = i;
    }

    public int getCellNumber() {
        return this.CellNumber;
    }

    private byte[] getByteSaftStatus() {
        return BytesUtils.getBytes(getSafeStatus());
    }

    public boolean isShutdownNotifyOpened() {
        return ((this.SafeStatus >> 31) & 1) == 1;
    }

    public boolean isCommunicationFailed() {
        return ((this.SafeStatus >> 30) & 1) == 1;
    }

    public boolean isCellVoltageExceptional() {
        return ((this.SafeStatus >> 29) & 1) == 1;
    }

    public boolean isUnderTemperatureForDischarge() {
        return ((this.SafeStatus >> 27) & 1) == 1;
    }

    public boolean isUnderTemperatureForDischarge2() {
        return ((this.SafeStatus >> 19) & 1) == 1;
    }

    public boolean isOverTemperatureForCharge() {
        return ((this.SafeStatus >> 26) & 1) == 1;
    }

    public boolean isUnderVoltageForCellCompensated() {
        return ((this.SafeStatus >> 14) & 1) == 1;
    }

    public boolean isOverTemperatureForDischarge() {
        return ((this.SafeStatus >> 13) & 1) == 1;
    }

    public boolean isUnderTemperatureForCharge() {
        return ((this.SafeStatus >> 12) & 1) == 1;
    }

    public boolean isOverTemperatureForCharge2() {
        return ((this.SafeStatus >> 21) & 1) == 1;
    }

    public boolean isShortCircuitForDischargeLatch() {
        return ((this.SafeStatus >> 11) & 1) == 1;
    }

    public boolean isShortCircuitForDischarge() {
        return ((this.SafeStatus >> 10) & 1) == 1;
    }

    public boolean isShortCircuitForCharge() {
        return ((this.SafeStatus >> 8) & 1) == 1;
    }

    public boolean isCellOverVoltage() {
        return ((this.SafeStatus >> 6) & 1) == 1;
    }

    public boolean isOverCurrentForCharge() {
        return ((this.SafeStatus >> 2) & 1) == 1;
    }

    public boolean isOverloadForDischarge() {
        return ((this.SafeStatus >> 1) & 1) == 1;
    }

    public boolean isBatteryOutOfService() {
        return ((this.SafeStatus >> 17) & 1) == 1;
    }

    public boolean isCellUnderVoltage() {
        return (this.SafeStatus & 1) == 1;
    }

    public void setCellNumber(int i) {
        this.CellNumber = i;
    }

    public int getError() {
        return this.Error;
    }

    public void setError(int i) {
        this.Error = i;
    }

    public int[] getVoltageCell() {
        return this.VoltageCell;
    }

    public void setVoltageCell(int[] iArr) {
        this.VoltageCell = iArr;
    }

    public int getResidualTime() {
        return this.ResidualTime;
    }

    public void setResidualTime(int i) {
        this.ResidualTime = i;
    }

    public int getPowerStatus() {
        return this.PowerStatus;
    }

    public void setPowerStatus(int i) {
        this.PowerStatus = i;
    }
}
