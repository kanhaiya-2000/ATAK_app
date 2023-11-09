package org.droidplanner.services.android.impl.core.survey.grid;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineLatLong;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineSampler;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineTools;

public class EndpointSorter {
    private static final int MAX_NUMBER_OF_CAMERAS = 2000;
    private List<LatLong> cameraLocations = new ArrayList();
    private List<LineLatLong> grid;
    private List<LatLong> gridPoints = new ArrayList();
    private Double sampleDistance;

    public EndpointSorter(List<LineLatLong> list, Double d) {
        this.grid = list;
        this.sampleDistance = d;
    }

    public void sortGrid(LatLong latLong, boolean z) {
        while (this.grid.size() > 0) {
            if (z) {
                latLong = processOneGridLine(LineTools.findClosestLineToPoint(latLong, this.grid), latLong, z);
            } else {
                latLong = processOneGridLine(this.grid.get(0), latLong, z);
            }
        }
    }

    private LatLong processOneGridLine(LineLatLong lineLatLong, LatLong latLong, boolean z) {
        LatLong closestEndpointTo = lineLatLong.getClosestEndpointTo(latLong);
        LatLong farthestEndpointTo = lineLatLong.getFarthestEndpointTo(latLong);
        this.grid.remove(lineLatLong);
        updateCameraLocations(closestEndpointTo, farthestEndpointTo);
        this.gridPoints.add(closestEndpointTo);
        this.gridPoints.add(farthestEndpointTo);
        if (this.cameraLocations.size() <= 2000) {
            return farthestEndpointTo;
        }
        throw new Exception("Too many camera positions");
    }

    private void updateCameraLocations(LatLong latLong, LatLong latLong2) {
        this.cameraLocations.addAll(new LineSampler(latLong, latLong2).sample(this.sampleDistance.doubleValue()));
    }

    public List<LatLong> getSortedGrid() {
        return this.gridPoints;
    }

    public List<LatLong> getCameraLocations() {
        return this.cameraLocations;
    }
}
