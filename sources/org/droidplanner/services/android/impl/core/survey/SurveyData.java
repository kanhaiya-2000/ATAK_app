package org.droidplanner.services.android.impl.core.survey;

import java.util.Locale;
import org.droidplanner.services.android.impl.core.helpers.units.Area;

public class SurveyData {
    private double altitude;
    private Double angle;
    private CameraInfo camera = new CameraInfo();
    private Footprint footprint;
    private boolean lockOrientation;
    private Double overlap;
    private Double sidelap;

    public SurveyData() {
        update(0.0d, 50.0d, 50.0d, 60.0d, false);
    }

    public void update(double d, double d2, double d3, double d4, boolean z) {
        this.angle = Double.valueOf(d);
        this.overlap = Double.valueOf(d3);
        this.sidelap = Double.valueOf(d4);
        setAltitude(d2);
        this.lockOrientation = z;
    }

    public void setAltitude(double d) {
        this.altitude = d;
        this.footprint = new Footprint(this.camera, d);
    }

    public void setCameraInfo(CameraInfo cameraInfo) {
        this.camera = cameraInfo;
        this.footprint = new Footprint(cameraInfo, this.altitude);
        tryToLoadOverlapFromCamera();
    }

    public CameraInfo getCameraInfo() {
        return this.camera;
    }

    public void setLockOrientation(boolean z) {
        this.lockOrientation = z;
    }

    private void tryToLoadOverlapFromCamera() {
        if (this.camera.overlap != null) {
            this.overlap = this.camera.overlap;
        }
        if (this.camera.sidelap != null) {
            this.sidelap = this.camera.sidelap;
        }
    }

    public double getLongitudinalPictureDistance() {
        return getLongitudinalFootPrint() * (1.0d - (this.overlap.doubleValue() * 0.01d));
    }

    public double getLateralPictureDistance() {
        return getLateralFootPrint() * (1.0d - (this.sidelap.doubleValue() * 0.01d));
    }

    public double getAltitude() {
        return this.altitude;
    }

    public Double getAngle() {
        return this.angle;
    }

    public double getSidelap() {
        return this.sidelap.doubleValue();
    }

    public double getOverlap() {
        return this.overlap.doubleValue();
    }

    public double getLateralFootPrint() {
        return this.footprint.getLateralSize();
    }

    public double getLongitudinalFootPrint() {
        return this.footprint.getLongitudinalSize();
    }

    public Area getGroundResolution() {
        return new Area(this.footprint.getGSD() * 0.01d);
    }

    public String getCameraName() {
        return this.camera.name;
    }

    public boolean getLockOrientation() {
        return this.lockOrientation;
    }

    public String toString() {
        return String.format(Locale.US, "Altitude: %f Angle %f Overlap: %f Sidelap: %f Locked Orientation: %b", new Object[]{Double.valueOf(this.altitude), this.angle, this.overlap, this.sidelap, Boolean.valueOf(this.lockOrientation)});
    }
}
