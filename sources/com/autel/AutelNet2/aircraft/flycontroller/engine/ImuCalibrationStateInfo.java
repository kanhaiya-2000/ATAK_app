package com.autel.AutelNet2.aircraft.flycontroller.engine;

public class ImuCalibrationStateInfo {
    private int status;
    private int step;

    public int getStep() {
        return this.step;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
