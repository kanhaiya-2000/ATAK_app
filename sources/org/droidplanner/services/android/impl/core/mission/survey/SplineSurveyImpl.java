package org.droidplanner.services.android.impl.core.mission.survey;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class SplineSurveyImpl extends SurveyImpl {
    public SplineSurveyImpl(MissionImpl missionImpl, List<LatLong> list) {
        super(missionImpl, list);
    }

    /* access modifiers changed from: protected */
    public msg_mission_item getSurveyPoint(LatLong latLong, double d) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.autocontinue = 1;
        msg_mission_item.frame = 3;
        msg_mission_item.command = 82;
        msg_mission_item.f8319x = (float) latLong.getLatitude();
        msg_mission_item.f8320y = (float) latLong.getLongitude();
        msg_mission_item.f8321z = (float) d;
        msg_mission_item.param1 = 0.0f;
        msg_mission_item.param2 = 0.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        return msg_mission_item;
    }

    public MissionItemType getType() {
        return MissionItemType.SPLINE_SURVEY;
    }
}
