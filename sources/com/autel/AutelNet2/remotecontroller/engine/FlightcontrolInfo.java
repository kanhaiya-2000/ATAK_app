package com.autel.AutelNet2.remotecontroller.engine;

public class FlightcontrolInfo {
    private int CombinedKey = 359;
    private int GeneralKey = 359;
    private int GimbalPitch = 1024;
    private int LeftHorizonPole = 1024;
    private int LeftVerticalPole = 1024;
    private int RightHorizonPole = 1024;
    private int RightVerticalPole = 1024;

    public int getRightHorizonPole() {
        return this.RightHorizonPole;
    }

    public void setRightHorizonPole(int i) {
        this.RightHorizonPole = i;
    }

    public int getRightVerticalPole() {
        return this.RightVerticalPole;
    }

    public void setRightVerticalPole(int i) {
        this.RightVerticalPole = i;
    }

    public int getLeftHorizonPole() {
        return this.LeftHorizonPole;
    }

    public void setLeftHorizonPole(int i) {
        this.LeftHorizonPole = i;
    }

    public int getLeftVerticalPole() {
        return this.LeftVerticalPole;
    }

    public void setLeftVerticalPole(int i) {
        this.LeftVerticalPole = i;
    }

    public int getGimbalPitch() {
        return this.GimbalPitch;
    }

    public void setGimbalPitch(int i) {
        this.GimbalPitch = i;
    }

    public int getGeneralKey() {
        return this.GeneralKey;
    }

    public void setGeneralKey(int i) {
        this.GeneralKey = i;
    }

    public int getCombinedKey() {
        return this.CombinedKey;
    }

    public void setCombinedKey(int i) {
        this.CombinedKey = i;
    }
}
