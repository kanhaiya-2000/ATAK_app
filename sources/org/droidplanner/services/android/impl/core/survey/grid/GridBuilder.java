package org.droidplanner.services.android.impl.core.survey.grid;

import com.o3dr.services.android.lib.coordinate.LatLong;
import org.droidplanner.services.android.impl.core.polygon.Polygon;
import org.droidplanner.services.android.impl.core.survey.SurveyData;

public class GridBuilder {
    private Double angle;
    private Grid grid;
    private Double lineDist;
    private LatLong origin;
    private Polygon poly;
    private Double wpDistance;

    public GridBuilder(Polygon polygon, SurveyData surveyData, LatLong latLong) {
        this.poly = polygon;
        this.origin = latLong;
        this.angle = surveyData.getAngle();
        this.lineDist = Double.valueOf(surveyData.getLateralPictureDistance());
        this.wpDistance = Double.valueOf(surveyData.getLongitudinalPictureDistance());
    }

    public GridBuilder(Polygon polygon, double d, double d2, LatLong latLong) {
        this.poly = polygon;
        this.origin = latLong;
        this.angle = Double.valueOf(d);
        this.lineDist = Double.valueOf(d2);
        this.wpDistance = Double.valueOf(d2);
    }

    public void setAngle(double d) {
        this.angle = Double.valueOf(d);
    }

    public Grid generate(boolean z) {
        EndpointSorter endpointSorter = new EndpointSorter(new Trimmer(new CircumscribedGrid(this.poly.getPoints(), this.angle, this.lineDist).getGrid(), this.poly.getLines()).getTrimmedGrid(), this.wpDistance);
        endpointSorter.sortGrid(this.origin, z);
        Grid grid2 = new Grid(endpointSorter.getSortedGrid(), endpointSorter.getCameraLocations());
        this.grid = grid2;
        return grid2;
    }
}
