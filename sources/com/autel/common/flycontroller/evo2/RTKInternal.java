package com.autel.common.flycontroller.evo2;

import com.autel.common.flycontroller.DroneLocationType;
import com.autel.common.flycontroller.RTKSignalType;

public class RTKInternal {
    public double altSigma;
    public double altitude;
    public int beidouSta;
    public int coordinateSys;
    public int fixSat;
    public int galileoSta;
    public int glonassSta;
    public int gpsSta;
    public int inPos;
    public double latSigma;
    public double latitude;
    public DroneLocationType locationType;
    public double lonSigma;
    public double longitude;
    public int posType;
    public boolean rtkUsed;
    public int sVs;
    public RTKSignalType signalType;
    public int solSta;
    public int solnSVs;
}
