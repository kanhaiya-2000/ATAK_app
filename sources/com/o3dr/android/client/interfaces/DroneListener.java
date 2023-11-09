package com.o3dr.android.client.interfaces;

import android.os.Bundle;

public interface DroneListener {
    void onDroneEvent(String str, Bundle bundle);

    void onDroneServiceInterrupted(String str);
}
