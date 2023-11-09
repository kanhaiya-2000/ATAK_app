package com.bbn.vehicleinterface.types;

import java.util.concurrent.ConcurrentHashMap;

public class GeoPosition {
    private final double altitude;
    private final AltitudeReference altitudeReference;
    private final double latitude;
    private final double longitude;

    public enum AltitudeReference {
        AGL("AGL"),
        MSL("MSL"),
        HAE("HAE");
        
        private static final ConcurrentHashMap<String, AltitudeReference> map = null;
        private final String referenceString;

        static {
            int i;
            map = new ConcurrentHashMap<>();
            for (AltitudeReference altitudeReference : values()) {
                map.put(altitudeReference.toString().toUpperCase(), altitudeReference);
            }
        }

        private AltitudeReference(String str) {
            this.referenceString = str;
        }

        public String toString() {
            return this.referenceString;
        }

        public AltitudeReference fromString(String str) {
            return map.get(str.toUpperCase());
        }
    }

    public GeoPosition(double d, double d2, double d3, AltitudeReference altitudeReference2) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.altitudeReference = altitudeReference2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public AltitudeReference getAltitudeReference() {
        return this.altitudeReference;
    }
}
