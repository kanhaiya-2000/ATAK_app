package org.droidplanner.services.android.impl.core.polygon;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineLatLong;
import org.droidplanner.services.android.impl.core.helpers.units.Area;

public class Polygon {
    private List<LatLong> points = new ArrayList();

    public void addPoints(List<LatLong> list) {
        for (LatLong addPoint : list) {
            addPoint(addPoint);
        }
    }

    public void addPoint(LatLong latLong) {
        this.points.add(latLong);
    }

    public void clearPolygon() {
        this.points.clear();
    }

    public List<LatLong> getPoints() {
        return this.points;
    }

    public List<LineLatLong> getLines() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.points.size()) {
            arrayList.add(new LineLatLong(this.points.get(i), this.points.get(i == 0 ? this.points.size() - 1 : i - 1)));
            i++;
        }
        return arrayList;
    }

    public void movePoint(LatLong latLong, int i) {
        this.points.get(i).set(latLong);
    }

    public Area getArea() {
        return GeoTools.getArea(this);
    }

    public void checkIfValid() {
        if (this.points.size() < 3) {
            throw new InvalidPolygon(this.points.size());
        }
    }

    public class InvalidPolygon extends Exception {
        private static final long serialVersionUID = 1;
        public int size;

        public InvalidPolygon(int i) {
            this.size = i;
        }
    }

    public void reversePoints() {
        Collections.reverse(this.points);
    }
}
