package org.droidplanner.services.android.impl.core.mission;

import java.util.Collections;
import org.droidplanner.services.android.impl.core.mission.commands.CameraTriggerImpl;
import org.droidplanner.services.android.impl.core.mission.commands.ChangeSpeedImpl;
import org.droidplanner.services.android.impl.core.mission.commands.ConditionYawImpl;
import org.droidplanner.services.android.impl.core.mission.commands.DoJumpImpl;
import org.droidplanner.services.android.impl.core.mission.commands.EpmGripperImpl;
import org.droidplanner.services.android.impl.core.mission.commands.ReturnToHomeImpl;
import org.droidplanner.services.android.impl.core.mission.commands.SetRelayImpl;
import org.droidplanner.services.android.impl.core.mission.commands.SetServoImpl;
import org.droidplanner.services.android.impl.core.mission.commands.TakeoffImpl;
import org.droidplanner.services.android.impl.core.mission.survey.SplineSurveyImpl;
import org.droidplanner.services.android.impl.core.mission.survey.SurveyImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.CircleImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.DoLandStartImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.LandImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.RegionOfInterestImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.SplineWaypointImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.StructureScannerImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.WaypointImpl;

public enum MissionItemType {
    WAYPOINT("Waypoint"),
    SPLINE_WAYPOINT("Spline Waypoint"),
    TAKEOFF("Takeoff"),
    RTL("Return to Launch"),
    LAND("Land"),
    CIRCLE("Circle"),
    ROI("Region of Interest"),
    SURVEY("Survey"),
    SPLINE_SURVEY("Spline Survey"),
    CYLINDRICAL_SURVEY("Structure Scan"),
    CHANGE_SPEED("Change Speed"),
    CAMERA_TRIGGER("Camera Trigger"),
    EPM_GRIPPER("EPM"),
    SET_SERVO("Set Servo"),
    CONDITION_YAW("Set Yaw"),
    SET_RELAY("Set Relay"),
    DO_LAND_START("Do Land Start"),
    DO_JUMP("Do Jump");
    
    private final String name;

    private MissionItemType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    /* renamed from: org.droidplanner.services.android.impl.core.mission.MissionItemType$1 */
    /* synthetic */ class C60041 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$mission$MissionItemType */
        static final /* synthetic */ int[] f8647xc8613e93 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.droidplanner.services.android.impl.core.mission.MissionItemType[] r0 = org.droidplanner.services.android.impl.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8647xc8613e93 = r0
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CAMERA_TRIGGER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.EPM_GRIPPER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x006c }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.ROI     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SURVEY     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SPLINE_SURVEY     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x009c }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CYLINDRICAL_SURVEY     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SET_SERVO     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CONDITION_YAW     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SET_RELAY     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.DO_LAND_START     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f8647xc8613e93     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r1 = org.droidplanner.services.android.impl.core.mission.MissionItemType.DO_JUMP     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.mission.MissionItemType.C60041.<clinit>():void");
        }
    }

    public MissionItemImpl getNewItem(MissionItemImpl missionItemImpl) {
        switch (C60041.f8647xc8613e93[ordinal()]) {
            case 1:
                return new WaypointImpl(missionItemImpl);
            case 2:
                return new SplineWaypointImpl(missionItemImpl);
            case 3:
                return new TakeoffImpl(missionItemImpl);
            case 4:
                return new ChangeSpeedImpl(missionItemImpl);
            case 5:
                return new CameraTriggerImpl(missionItemImpl);
            case 6:
                return new EpmGripperImpl(missionItemImpl);
            case 7:
                return new ReturnToHomeImpl(missionItemImpl);
            case 8:
                return new LandImpl(missionItemImpl);
            case 9:
                return new CircleImpl(missionItemImpl);
            case 10:
                return new RegionOfInterestImpl(missionItemImpl);
            case 11:
                return new SurveyImpl(missionItemImpl.getMission(), Collections.emptyList());
            case 12:
                return new SplineSurveyImpl(missionItemImpl.getMission(), Collections.emptyList());
            case 13:
                return new StructureScannerImpl(missionItemImpl);
            case 14:
                return new SetServoImpl(missionItemImpl);
            case 15:
                return new ConditionYawImpl(missionItemImpl);
            case 16:
                return new SetRelayImpl(missionItemImpl);
            case 17:
                return new DoLandStartImpl(missionItemImpl);
            case 18:
                return new DoJumpImpl(missionItemImpl);
            default:
                throw new IllegalArgumentException("Unrecognized mission item type (" + this.name + ")");
        }
    }
}
