package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;
import org.droidplanner.services.android.impl.core.mission.survey.SurveyImpl;
import org.droidplanner.services.android.impl.core.polygon.Polygon;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.droidplanner.services.android.impl.core.survey.SurveyData;
import org.droidplanner.services.android.impl.core.survey.grid.GridBuilder;

public class StructureScannerImpl extends SpatialCoordItem {
    private boolean crossHatch = false;
    private double heightStep = 5.0d;
    private int numberOfSteps = 2;
    private double radius = 10.0d;
    SurveyData survey = new SurveyData();

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
    }

    public StructureScannerImpl(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl, latLongAlt);
    }

    public StructureScannerImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public List<msg_mission_item> packMissionItem() {
        ArrayList arrayList = new ArrayList();
        packROI(arrayList);
        packCircles(arrayList);
        if (this.crossHatch) {
            packHatch(arrayList);
        }
        return arrayList;
    }

    private void packROI(List<msg_mission_item> list) {
        list.addAll(new RegionOfInterestImpl(this.missionImpl, new LatLongAlt(this.coordinate, 0.0d)).packMissionItem());
    }

    private void packCircles(List<msg_mission_item> list) {
        double altitude = this.coordinate.getAltitude();
        for (int i = 0; i < this.numberOfSteps; i++) {
            CircleImpl circleImpl = new CircleImpl(this.missionImpl, new LatLongAlt(this.coordinate, altitude));
            circleImpl.setRadius(this.radius);
            list.addAll(circleImpl.packMissionItem());
            altitude += this.heightStep;
        }
    }

    private void packHatch(List<msg_mission_item> list) {
        List<msg_mission_item> list2 = list;
        Polygon polygon = new Polygon();
        for (double d = 0.0d; d <= 360.0d; d += 10.0d) {
            polygon.addPoint(GeoTools.newCoordFromBearingAndDistance(this.coordinate, d, this.radius));
        }
        LatLong newCoordFromBearingAndDistance = GeoTools.newCoordFromBearingAndDistance(this.coordinate, -45.0d, this.radius * 2.0d);
        this.survey.setAltitude(getTopHeight());
        try {
            SurveyData surveyData = this.survey;
            surveyData.update(0.0d, surveyData.getAltitude(), this.survey.getOverlap(), this.survey.getSidelap(), this.survey.getLockOrientation());
            for (LatLong packSurveyPoint : new GridBuilder(polygon, this.survey, newCoordFromBearingAndDistance).generate(false).gridPoints) {
                list2.add(SurveyImpl.packSurveyPoint(packSurveyPoint, getTopHeight()));
            }
            SurveyData surveyData2 = this.survey;
            surveyData2.update(90.0d, surveyData2.getAltitude(), this.survey.getOverlap(), this.survey.getSidelap(), this.survey.getLockOrientation());
            for (LatLong packSurveyPoint2 : new GridBuilder(polygon, this.survey, newCoordFromBearingAndDistance).generate(false).gridPoints) {
                list2.add(SurveyImpl.packSurveyPoint(packSurveyPoint2, getTopHeight()));
            }
        } catch (Exception unused) {
        }
    }

    public List<LatLong> getPath() {
        ArrayList arrayList = new ArrayList();
        for (msg_mission_item next : packMissionItem()) {
            if (next.command == 16) {
                arrayList.add(new LatLong((double) next.f8319x, (double) next.f8320y));
            }
            if (next.command == 18) {
                for (double d = 0.0d; d <= 360.0d; d += 12.0d) {
                    arrayList.add(GeoTools.newCoordFromBearingAndDistance(this.coordinate, d, this.radius));
                }
            }
        }
        return arrayList;
    }

    public MissionItemType getType() {
        return MissionItemType.CYLINDRICAL_SURVEY;
    }

    private double getTopHeight() {
        return this.coordinate.getAltitude() + (((double) (this.numberOfSteps - 1)) * this.heightStep);
    }

    public double getEndAltitude() {
        return this.heightStep;
    }

    public int getNumberOfSteps() {
        return this.numberOfSteps;
    }

    public double getRadius() {
        return this.radius;
    }

    public LatLong getCenter() {
        return this.coordinate;
    }

    public void setRadius(int i) {
        this.radius = (double) i;
    }

    public void enableCrossHatch(boolean z) {
        this.crossHatch = z;
    }

    public boolean isCrossHatchEnabled() {
        return this.crossHatch;
    }

    public void setAltitudeStep(int i) {
        this.heightStep = (double) i;
    }

    public void setNumberOfSteps(int i) {
        this.numberOfSteps = i;
    }

    public void setCamera(CameraInfo cameraInfo) {
        this.survey.setCameraInfo(cameraInfo);
    }

    public String getCamera() {
        return this.survey.getCameraName();
    }

    public SurveyData getSurveyData() {
        return this.survey;
    }
}
