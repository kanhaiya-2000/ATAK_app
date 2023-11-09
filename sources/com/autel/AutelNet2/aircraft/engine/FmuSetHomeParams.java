package com.autel.AutelNet2.aircraft.engine;

public class FmuSetHomeParams extends FmuCmdParams {
    private float Latitude;
    private float Longitude;

    public FmuSetHomeParams(int i, float f, float f2) {
        super(i);
        setLatitude(f);
        setLongitude(f2);
    }

    public float getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(float f) {
        this.Latitude = f;
    }

    public float getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(float f) {
        this.Longitude = f;
    }
}
