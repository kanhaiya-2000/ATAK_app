package org.droidplanner.services.android.impl.core.survey.grid;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineLatLong;
import org.droidplanner.services.android.impl.core.helpers.geoTools.LineTools;

public class Trimmer {
    List<LineLatLong> trimedGrid = new ArrayList();

    public Trimmer(List<LineLatLong> list, List<LineLatLong> list2) {
        for (LineLatLong next : list) {
            processCrossings(findCrossings(list2, next), next);
        }
    }

    private ArrayList<LatLong> findCrossings(List<LineLatLong> list, LineLatLong lineLatLong) {
        ArrayList<LatLong> arrayList = new ArrayList<>();
        for (LineLatLong FindLineIntersection : list) {
            LatLong FindLineIntersection2 = LineTools.FindLineIntersection(FindLineIntersection, lineLatLong);
            if (FindLineIntersection2 != null) {
                arrayList.add(FindLineIntersection2);
            }
        }
        return arrayList;
    }

    private void processCrossings(ArrayList<LatLong> arrayList, LineLatLong lineLatLong) {
        int size = arrayList.size();
        if (size != 0 && size != 1) {
            if (size != 2) {
                this.trimedGrid.add(LineTools.findExternalPoints(arrayList));
            } else {
                this.trimedGrid.add(new LineLatLong(arrayList.get(0), arrayList.get(1)));
            }
        }
    }

    public List<LineLatLong> getTrimmedGrid() {
        return this.trimedGrid;
    }
}
