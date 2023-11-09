package com.autel.common.flycontroller.evo;

public interface ImuStateInfo {
    float getAbsolutePressure();

    int getFieldsUpdated();

    float getTemperature();

    float getXAccelerometer();

    float getXAccelerometer1();

    float getXGyroscope();

    float getXGyroscope1();

    float getXMagnetometer();

    float getYAccelerometer();

    float getYAccelerometer1();

    float getYGyroscope();

    float getYGyroscope1();

    float getYMagnetometer();

    float getZAccelerometer();

    float getZAccelerometer1();

    float getZGyroscope();

    float getZGyroscope1();

    float getZMagnetometer();
}
