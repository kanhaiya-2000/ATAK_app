package org.droidplanner.services.android.impl.core.survey;

public class CameraInfo {
    public Double focalLength = Double.valueOf(5.0d);
    public boolean isInLandscapeOrientation = true;
    public String name = "Canon SX260";
    public Double overlap = Double.valueOf(50.0d);
    public Double sensorHeight = Double.valueOf(4.22d);
    public Double sensorResolution = Double.valueOf(12.1d);
    public Double sensorWidth = Double.valueOf(6.12d);
    public Double sidelap = Double.valueOf(60.0d);

    public Double getSensorLateralSize() {
        if (this.isInLandscapeOrientation) {
            return this.sensorWidth;
        }
        return this.sensorHeight;
    }

    public Double getSensorLongitudinalSize() {
        if (this.isInLandscapeOrientation) {
            return this.sensorHeight;
        }
        return this.sensorWidth;
    }

    public String toString() {
        return "Camera:" + this.name + " ImageWidth:" + this.sensorWidth + " ImageHeight:" + this.sensorHeight + " FocalLength:" + this.focalLength + " Overlap:" + this.overlap + " Sidelap:" + this.sidelap + " isInLandscapeOrientation:" + this.isInLandscapeOrientation;
    }
}
