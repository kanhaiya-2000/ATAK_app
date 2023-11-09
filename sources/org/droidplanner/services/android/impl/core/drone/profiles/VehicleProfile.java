package org.droidplanner.services.android.impl.core.drone.profiles;

public class VehicleProfile {
    private Default default_ = new Default();
    private String parameterMetadataType;

    public String getParameterMetadataType() {
        return this.parameterMetadataType;
    }

    public Default getDefault() {
        return this.default_;
    }

    public void setDefault(Default defaultR) {
        this.default_ = defaultR;
    }

    public void setParameterMetadataType(String str) {
        this.parameterMetadataType = str;
    }

    public static class Default {
        private int maxAltitude;
        private int wpNavSpeed;

        public int getWpNavSpeed() {
            return this.wpNavSpeed;
        }

        public void setWpNavSpeed(int i) {
            this.wpNavSpeed = i;
        }

        public int getMaxAltitude() {
            return this.maxAltitude;
        }

        public void setMaxAltitude(int i) {
            this.maxAltitude = i;
        }
    }
}
