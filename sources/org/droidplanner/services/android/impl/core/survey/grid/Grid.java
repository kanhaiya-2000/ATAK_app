package org.droidplanner.services.android.impl.core.survey.grid;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.PolylineTools;

public class Grid {
    private List<LatLong> cameraLocations;
    public List<LatLong> gridPoints;

    public Grid(List<LatLong> list, List<LatLong> list2) {
        this.gridPoints = list;
        this.cameraLocations = list2;
    }

    public double getLength() {
        return PolylineTools.getPolylineLength(this.gridPoints);
    }

    public int getNumberOfLines() {
        return this.gridPoints.size() / 2;
    }

    public List<LatLong> getCameraLocations() {
        return this.cameraLocations;
    }

    public int getCameraCount() {
        return this.cameraLocations.size();
    }
}
