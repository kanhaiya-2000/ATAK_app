package org.droidplanner.services.android.impl.core.mission.survey;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;
import org.droidplanner.services.android.impl.core.mission.commands.CameraTriggerImpl;
import org.droidplanner.services.android.impl.core.polygon.Polygon;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.droidplanner.services.android.impl.core.survey.SurveyData;
import org.droidplanner.services.android.impl.core.survey.grid.Grid;
import org.droidplanner.services.android.impl.core.survey.grid.GridBuilder;

public class SurveyImpl extends MissionItemImpl {
    public Grid grid;
    public Polygon polygon = new Polygon();
    private boolean startCameraBeforeFirstWaypoint;
    public SurveyData surveyData = new SurveyData();

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
    }

    public SurveyImpl(MissionImpl missionImpl, List<LatLong> list) {
        super(missionImpl);
        this.polygon.addPoints(list);
    }

    public void update(double d, double d2, double d3, double d4, boolean z) {
        this.surveyData.update(d, d2, d3, d4, z);
    }

    public boolean isStartCameraBeforeFirstWaypoint() {
        return this.startCameraBeforeFirstWaypoint;
    }

    public void setStartCameraBeforeFirstWaypoint(boolean z) {
        this.startCameraBeforeFirstWaypoint = z;
    }

    public void setCameraInfo(CameraInfo cameraInfo) {
        this.surveyData.setCameraInfo(cameraInfo);
    }

    public void build() {
        this.grid = null;
        GridBuilder gridBuilder = new GridBuilder(this.polygon, this.surveyData, new LatLong(0.0d, 0.0d));
        this.polygon.checkIfValid();
        this.grid = gridBuilder.generate(true);
    }

    public List<msg_mission_item> packMissionItem() {
        try {
            ArrayList arrayList = new ArrayList();
            build();
            packSurveyPoints(arrayList);
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private void packSurveyPoints(List<msg_mission_item> list) {
        CameraTriggerImpl cameraTriggerImpl = new CameraTriggerImpl(this.missionImpl, this.surveyData.getLongitudinalPictureDistance());
        if (this.startCameraBeforeFirstWaypoint) {
            list.addAll(cameraTriggerImpl.packMissionItem());
        }
        double altitude = this.surveyData.getAltitude();
        boolean z = !this.startCameraBeforeFirstWaypoint;
        for (LatLong surveyPoint : this.grid.gridPoints) {
            list.add(getSurveyPoint(surveyPoint, altitude));
            if (this.surveyData.getLockOrientation()) {
                list.add(getYawCondition(this.surveyData.getAngle().doubleValue()));
            }
            if (z) {
                list.addAll(cameraTriggerImpl.packMissionItem());
                z = false;
            }
        }
        list.addAll(new CameraTriggerImpl(this.missionImpl, 0.0d).packMissionItem());
    }

    /* access modifiers changed from: protected */
    public msg_mission_item getSurveyPoint(LatLong latLong, double d) {
        return packSurveyPoint(latLong, d);
    }

    public static msg_mission_item packSurveyPoint(LatLong latLong, double d) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.autocontinue = 1;
        msg_mission_item.frame = 3;
        msg_mission_item.command = 16;
        msg_mission_item.f8319x = (float) latLong.getLatitude();
        msg_mission_item.f8320y = (float) latLong.getLongitude();
        msg_mission_item.f8321z = (float) d;
        msg_mission_item.param1 = 0.0f;
        msg_mission_item.param2 = 0.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        return msg_mission_item;
    }

    private msg_mission_item getYawCondition(double d) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.autocontinue = 1;
        msg_mission_item.frame = 4;
        msg_mission_item.command = 115;
        msg_mission_item.f8319x = 0.0f;
        msg_mission_item.f8320y = 0.0f;
        msg_mission_item.f8321z = 0.0f;
        msg_mission_item.param1 = (float) d;
        msg_mission_item.param2 = 30.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        return msg_mission_item;
    }

    public MissionItemType getType() {
        return MissionItemType.SURVEY;
    }
}
