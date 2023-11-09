package org.droidplanner.services.android.impl.core.survey.grid;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.coordinates.CoordBounds;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineLatLong;

public class CircumscribedGrid {
    private static final int MAX_NUMBER_OF_LINES = 300;
    private Double angle;
    private double extrapolatedDiag;
    List<LineLatLong> grid = new ArrayList();
    private LatLong gridLowerLeft;

    public CircumscribedGrid(List<LatLong> list, Double d, Double d2) {
        this.angle = d;
        findPolygonBounds(list);
        drawGrid(d2);
    }

    private void drawGrid(Double d) {
        LatLong latLong = this.gridLowerLeft;
        int i = 0;
        while (((double) i) * d.doubleValue() < this.extrapolatedDiag) {
            this.grid.add(new LineLatLong(latLong, GeoTools.newCoordFromBearingAndDistance(latLong, this.angle.doubleValue(), this.extrapolatedDiag)));
            latLong = GeoTools.newCoordFromBearingAndDistance(latLong, this.angle.doubleValue() + 90.0d, d.doubleValue());
            i++;
            if (i > 300) {
                throw new GridWithTooManyLines();
            }
        }
    }

    private void findPolygonBounds(List<LatLong> list) {
        CoordBounds coordBounds = new CoordBounds(list);
        this.gridLowerLeft = GeoTools.newCoordFromBearingAndDistance(coordBounds.getMiddle(), this.angle.doubleValue() - 135.0d, coordBounds.getDiag());
        this.extrapolatedDiag = coordBounds.getDiag() * 1.5d;
    }

    public List<LineLatLong> getGrid() {
        return this.grid;
    }

    public class GridWithTooManyLines extends Exception {
        private static final long serialVersionUID = 1;

        public GridWithTooManyLines() {
        }
    }
}
