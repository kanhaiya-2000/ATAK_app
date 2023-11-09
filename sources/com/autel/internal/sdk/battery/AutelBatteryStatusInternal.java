package com.autel.internal.sdk.battery;

public class AutelBatteryStatusInternal {
    private float CycleCount;
    private int DesignCap;
    private int FullChgCap;
    private int RSOC;
    private int Timestamp;
    private int[] batteryCells = new int[0];
    private float capacity_mah;
    private float current_ma;

    /* renamed from: sn */
    private String f8479sn;
    private float temperature;
    private String ver;
    private double voltage_mv;

    public int getTimestamp() {
        return this.Timestamp;
    }

    public void setTimestamp(int i) {
        this.Timestamp = i;
    }

    public int[] getBatteryCells() {
        return this.batteryCells;
    }

    public double getVoltage() {
        return this.voltage_mv;
    }

    public float getCapacity() {
        return this.capacity_mah;
    }

    public float getCurrent() {
        return this.current_ma;
    }

    public float getBatteryTemperature() {
        return this.temperature;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getNumberOfDischarges() {
        return this.CycleCount;
    }

    public int getFullChargeCapacity() {
        return this.FullChgCap;
    }

    public int getBatteryRemainingPercent() {
        return this.RSOC;
    }

    public String getSerialNumber() {
        return this.f8479sn;
    }

    public String getVersion() {
        return this.ver;
    }

    public int getDesignCap() {
        return this.DesignCap;
    }

    public void setBatteryCells(int[] iArr) {
        if (iArr != null) {
            this.batteryCells = iArr;
        }
    }

    public void setVoltage_mv(double d) {
        this.voltage_mv = d;
    }

    public void setCapacity_mah(float f) {
        this.capacity_mah = f;
    }

    public void setCurrent_ma(float f) {
        this.current_ma = f;
    }

    public void setTemperature(float f) {
        this.temperature = f;
    }

    public void setCycleCount(float f) {
        this.CycleCount = f;
    }

    public void setDesignCap(int i) {
        this.DesignCap = i;
    }

    public void setFullChgCap(int i) {
        this.FullChgCap = i;
    }

    public void setRSOC(int i) {
        this.RSOC = i;
    }

    public void setSn(String str) {
        this.f8479sn = str;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public String toString() {
        int length = this.batteryCells.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            sb.append(",");
            sb.append("电池组");
            int i2 = i + 1;
            sb.append(i2);
            sb.append("(voltage of battery cell ");
            sb.append(i2);
            sb.append(")= ");
            sb.append(i);
            i = i2;
        }
        return "CellBattery [电压(battery voltage)=" + this.voltage_mv + ", 电流(battery current)=" + this.current_ma + ", 设计容量(designed capacity)=" + this.DesignCap + ", 温度(temperature)=" + this.temperature + ", 充满容量(FullChgCap)=" + this.FullChgCap + "mAh, 序列号(sn)=" + this.f8479sn + ", 当前容量(battery capacity)=" + this.capacity_mah + ", 容量百分比(battery level)=" + this.RSOC + "% , 放电次数(charged times of battery)=" + this.CycleCount + sb + "]";
    }
}
