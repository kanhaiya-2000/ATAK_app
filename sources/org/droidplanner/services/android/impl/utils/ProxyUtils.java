package org.droidplanner.services.android.impl.utils;

import android.util.Log;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.mission.item.command.CameraTrigger;
import com.o3dr.services.android.lib.drone.mission.item.command.ChangeSpeed;
import com.o3dr.services.android.lib.drone.mission.item.command.DoJump;
import com.o3dr.services.android.lib.drone.mission.item.command.EpmGripper;
import com.o3dr.services.android.lib.drone.mission.item.command.ResetROI;
import com.o3dr.services.android.lib.drone.mission.item.command.ReturnToLaunch;
import com.o3dr.services.android.lib.drone.mission.item.command.SetRelay;
import com.o3dr.services.android.lib.drone.mission.item.command.SetServo;
import com.o3dr.services.android.lib.drone.mission.item.command.Takeoff;
import com.o3dr.services.android.lib.drone.mission.item.command.YawCondition;
import com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail;
import com.o3dr.services.android.lib.drone.mission.item.complex.SplineSurvey;
import com.o3dr.services.android.lib.drone.mission.item.complex.StructureScanner;
import com.o3dr.services.android.lib.drone.mission.item.complex.Survey;
import com.o3dr.services.android.lib.drone.mission.item.complex.SurveyDetail;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Circle;
import com.o3dr.services.android.lib.drone.mission.item.spatial.DoLandStart;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Land;
import com.o3dr.services.android.lib.drone.mission.item.spatial.RegionOfInterest;
import com.o3dr.services.android.lib.drone.mission.item.spatial.SplineWaypoint;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Waypoint;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
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
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.droidplanner.services.android.impl.core.survey.SurveyData;

public class ProxyUtils {
    private static final String TAG = "ProxyUtils";

    public static CameraDetail getCameraDetail(CameraInfo cameraInfo) {
        CameraInfo cameraInfo2 = cameraInfo;
        if (cameraInfo2 == null) {
            return null;
        }
        return new CameraDetail(cameraInfo2.name, cameraInfo2.sensorWidth.doubleValue(), cameraInfo2.sensorHeight.doubleValue(), cameraInfo2.sensorResolution.doubleValue(), cameraInfo2.focalLength.doubleValue(), cameraInfo2.overlap.doubleValue(), cameraInfo2.sidelap.doubleValue(), cameraInfo2.isInLandscapeOrientation);
    }

    public static CameraInfo getCameraInfo(CameraDetail cameraDetail) {
        if (cameraDetail == null) {
            return null;
        }
        CameraInfo cameraInfo = new CameraInfo();
        cameraInfo.name = cameraDetail.getName();
        cameraInfo.sensorWidth = Double.valueOf(cameraDetail.getSensorWidth());
        cameraInfo.sensorHeight = Double.valueOf(cameraDetail.getSensorHeight());
        cameraInfo.sensorResolution = Double.valueOf(cameraDetail.getSensorResolution());
        cameraInfo.focalLength = Double.valueOf(cameraDetail.getFocalLength());
        cameraInfo.overlap = Double.valueOf(cameraDetail.getOverlap());
        cameraInfo.sidelap = Double.valueOf(cameraDetail.getSidelap());
        cameraInfo.isInLandscapeOrientation = cameraDetail.isInLandscapeOrientation();
        return cameraInfo;
    }

    public static SurveyDetail getSurveyDetail(SurveyData surveyData) {
        SurveyDetail surveyDetail = new SurveyDetail();
        surveyDetail.setCameraDetail(getCameraDetail(surveyData.getCameraInfo()));
        surveyDetail.setSidelap(surveyData.getSidelap());
        surveyDetail.setOverlap(surveyData.getOverlap());
        surveyDetail.setAngle(surveyData.getAngle().doubleValue());
        surveyDetail.setAltitude(surveyData.getAltitude());
        surveyDetail.setLockOrientation(surveyData.getLockOrientation());
        return surveyDetail;
    }

    public static MissionItemImpl getMissionItemImpl(MissionImpl missionImpl, MissionItem missionItem) {
        SplineSurveyImpl splineSurveyImpl;
        if (missionItem == null) {
            return null;
        }
        switch (C60121.f8654x5ec7fdea[missionItem.getType().ordinal()]) {
            case 1:
                return new CameraTriggerImpl(missionImpl, ((CameraTrigger) missionItem).getTriggerDistance());
            case 2:
                return new ChangeSpeedImpl(missionImpl, ((ChangeSpeed) missionItem).getSpeed());
            case 3:
                return new EpmGripperImpl(missionImpl, ((EpmGripper) missionItem).isRelease());
            case 4:
                ReturnToHomeImpl returnToHomeImpl = new ReturnToHomeImpl(missionImpl);
                returnToHomeImpl.setHeight(((ReturnToLaunch) missionItem).getReturnAltitude());
                return returnToHomeImpl;
            case 5:
                SetServo setServo = (SetServo) missionItem;
                return new SetServoImpl(missionImpl, setServo.getChannel(), setServo.getPwm());
            case 6:
                Takeoff takeoff = (Takeoff) missionItem;
                return new TakeoffImpl(missionImpl, takeoff.getTakeoffAltitude(), takeoff.getTakeoffPitch());
            case 7:
                Circle circle = (Circle) missionItem;
                CircleImpl circleImpl = new CircleImpl(missionImpl, circle.getCoordinate());
                circleImpl.setRadius(circle.getRadius());
                circleImpl.setTurns(circle.getTurns());
                return circleImpl;
            case 8:
                return new LandImpl(missionImpl, (LatLong) ((Land) missionItem).getCoordinate());
            case 9:
                return new DoLandStartImpl(missionImpl, (LatLong) ((DoLandStart) missionItem).getCoordinate());
            case 10:
                return new RegionOfInterestImpl(missionImpl, ((RegionOfInterest) missionItem).getCoordinate());
            case 11:
                return new RegionOfInterestImpl(missionImpl, new LatLongAlt(0.0d, 0.0d, 0.0d));
            case 12:
                SplineWaypoint splineWaypoint = (SplineWaypoint) missionItem;
                SplineWaypointImpl splineWaypointImpl = new SplineWaypointImpl(missionImpl, splineWaypoint.getCoordinate());
                splineWaypointImpl.setDelay(splineWaypoint.getDelay());
                return splineWaypointImpl;
            case 13:
                StructureScanner structureScanner = (StructureScanner) missionItem;
                StructureScannerImpl structureScannerImpl = new StructureScannerImpl(missionImpl, structureScanner.getCoordinate());
                structureScannerImpl.setRadius((int) structureScanner.getRadius());
                structureScannerImpl.setNumberOfSteps(structureScanner.getStepsCount());
                structureScannerImpl.setAltitudeStep((int) structureScanner.getHeightStep());
                structureScannerImpl.enableCrossHatch(structureScanner.isCrossHatch());
                CameraDetail cameraDetail = structureScanner.getSurveyDetail().getCameraDetail();
                if (cameraDetail == null) {
                    return structureScannerImpl;
                }
                structureScannerImpl.setCamera(getCameraInfo(cameraDetail));
                return structureScannerImpl;
            case 14:
                Waypoint waypoint = (Waypoint) missionItem;
                WaypointImpl waypointImpl = new WaypointImpl(missionImpl, waypoint.getCoordinate());
                waypointImpl.setAcceptanceRadius(waypoint.getAcceptanceRadius());
                waypointImpl.setDelay(waypoint.getDelay());
                waypointImpl.setOrbitCCW(waypoint.isOrbitCCW());
                waypointImpl.setOrbitalRadius(waypoint.getOrbitalRadius());
                waypointImpl.setYawAngle(waypoint.getYawAngle());
                return waypointImpl;
            case 15:
                Survey survey = (Survey) missionItem;
                SurveyDetail surveyDetail = survey.getSurveyDetail();
                SurveyImpl surveyImpl = new SurveyImpl(missionImpl, survey.getPolygonPoints());
                surveyImpl.setStartCameraBeforeFirstWaypoint(survey.isStartCameraBeforeFirstWaypoint());
                if (surveyDetail != null) {
                    CameraDetail cameraDetail2 = surveyDetail.getCameraDetail();
                    if (cameraDetail2 != null) {
                        surveyImpl.setCameraInfo(getCameraInfo(cameraDetail2));
                    }
                    surveyImpl.update(surveyDetail.getAngle(), surveyDetail.getAltitude(), surveyDetail.getOverlap(), surveyDetail.getSidelap(), surveyDetail.getLockOrientation());
                }
                try {
                    surveyImpl.build();
                    splineSurveyImpl = surveyImpl;
                    break;
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage(), e);
                    splineSurveyImpl = surveyImpl;
                    break;
                }
            case 16:
                SplineSurvey splineSurvey = (SplineSurvey) missionItem;
                SurveyDetail surveyDetail2 = splineSurvey.getSurveyDetail();
                SplineSurveyImpl splineSurveyImpl2 = new SplineSurveyImpl(missionImpl, splineSurvey.getPolygonPoints());
                splineSurveyImpl2.setStartCameraBeforeFirstWaypoint(splineSurvey.isStartCameraBeforeFirstWaypoint());
                if (surveyDetail2 != null) {
                    CameraDetail cameraDetail3 = surveyDetail2.getCameraDetail();
                    if (cameraDetail3 != null) {
                        splineSurveyImpl2.setCameraInfo(getCameraInfo(cameraDetail3));
                    }
                    splineSurveyImpl2.update(surveyDetail2.getAngle(), surveyDetail2.getAltitude(), surveyDetail2.getOverlap(), surveyDetail2.getSidelap(), surveyDetail2.getLockOrientation());
                }
                try {
                    splineSurveyImpl2.build();
                    splineSurveyImpl = splineSurveyImpl2;
                    break;
                } catch (Exception e2) {
                    Log.e(TAG, e2.getMessage(), e2);
                    splineSurveyImpl = splineSurveyImpl2;
                    break;
                }
            case 17:
                YawCondition yawCondition = (YawCondition) missionItem;
                ConditionYawImpl conditionYawImpl = new ConditionYawImpl(missionImpl, yawCondition.getAngle(), yawCondition.isRelative());
                conditionYawImpl.setAngularSpeed(yawCondition.getAngularSpeed());
                return conditionYawImpl;
            case 18:
                SetRelay setRelay = (SetRelay) missionItem;
                return new SetRelayImpl(missionImpl, setRelay.getRelayNumber(), setRelay.isEnabled());
            case 19:
                DoJump doJump = (DoJump) missionItem;
                return new DoJumpImpl(missionImpl, doJump.getWaypoint(), doJump.getRepeatCount());
            default:
                return null;
        }
        return splineSurveyImpl;
    }

    /* renamed from: org.droidplanner.services.android.impl.utils.ProxyUtils$1 */
    /* synthetic */ class C60121 {

        /* renamed from: $SwitchMap$com$o3dr$services$android$lib$drone$mission$MissionItemType */
        static final /* synthetic */ int[] f8654x5ec7fdea;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$mission$MissionItemType */
        static final /* synthetic */ int[] f8655xc8613e93;

        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(78:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(80:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(81:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(82:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(84:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|(3:109|110|112)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(89:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|(2:69|70)|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|112) */
        /* JADX WARNING: Can't wrap try/catch for region: R(90:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|112) */
        /* JADX WARNING: Can't wrap try/catch for region: R(92:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|112) */
        /* JADX WARNING: Can't wrap try/catch for region: R(93:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|(2:65|66)|67|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|112) */
        /* JADX WARNING: Can't wrap try/catch for region: R(94:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|112) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x016b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x0175 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x0181 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x018b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x0195 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x012f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0139 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0143 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x014d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0157 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0161 */
        static {
            /*
                org.droidplanner.services.android.impl.core.mission.MissionItemType[] r0 = org.droidplanner.services.android.impl.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8655xc8613e93 = r0
                r1 = 1
                org.droidplanner.services.android.impl.core.mission.MissionItemType r2 = org.droidplanner.services.android.impl.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r3 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r4 = org.droidplanner.services.android.impl.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r5 = org.droidplanner.services.android.impl.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r6 = org.droidplanner.services.android.impl.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r7 = org.droidplanner.services.android.impl.core.mission.MissionItemType.DO_LAND_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r8 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r9 = org.droidplanner.services.android.impl.core.mission.MissionItemType.ROI     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x006c }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r10 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SURVEY     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r11 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SPLINE_SURVEY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r12 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CYLINDRICAL_SURVEY     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                r11 = 12
                int[] r12 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r13 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                r12 = 13
                int[] r13 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x009c }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r14 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CAMERA_TRIGGER     // Catch:{ NoSuchFieldError -> 0x009c }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r13[r14] = r12     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                r13 = 14
                int[] r14 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r15 = org.droidplanner.services.android.impl.core.mission.MissionItemType.EPM_GRIPPER     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r14[r15] = r13     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                r14 = 15
                int[] r15 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r16 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SET_SERVO     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r15[r16] = r14     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                r15 = 16
                int[] r16 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r17 = org.droidplanner.services.android.impl.core.mission.MissionItemType.CONDITION_YAW     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r17 = r17.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r16[r17] = r15     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                r16 = 17
                int[] r17 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r18 = org.droidplanner.services.android.impl.core.mission.MissionItemType.SET_RELAY     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r18 = r18.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r17[r18] = r16     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                r17 = 18
                int[] r18 = f8655xc8613e93     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.droidplanner.services.android.impl.core.mission.MissionItemType r19 = org.droidplanner.services.android.impl.core.mission.MissionItemType.DO_JUMP     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r19 = r19.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r18[r19] = r17     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                com.o3dr.services.android.lib.drone.mission.MissionItemType[] r15 = com.o3dr.services.android.lib.drone.mission.MissionItemType.values()
                int r15 = r15.length
                int[] r15 = new int[r15]
                f8654x5ec7fdea = r15
                com.o3dr.services.android.lib.drone.mission.MissionItemType r19 = com.o3dr.services.android.lib.drone.mission.MissionItemType.CAMERA_TRIGGER     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r19 = r19.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r15[r19] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x00f3 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r15 = com.o3dr.services.android.lib.drone.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r15] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x00fd }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.EPM_GRIPPER     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.RETURN_TO_LAUNCH     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0111 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SET_SERVO     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x011b }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x012f }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0139 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.DO_LAND_START     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0143 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.REGION_OF_INTEREST     // Catch:{ NoSuchFieldError -> 0x0143 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0143 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x0143 }
            L_0x0143:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x014d }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.RESET_ROI     // Catch:{ NoSuchFieldError -> 0x014d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x014d }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x014d }
            L_0x014d:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0157 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0157 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0157 }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x0157 }
            L_0x0157:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0161 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.STRUCTURE_SCANNER     // Catch:{ NoSuchFieldError -> 0x0161 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0161 }
                r0[r1] = r12     // Catch:{ NoSuchFieldError -> 0x0161 }
            L_0x0161:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x016b }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x016b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x016b }
                r0[r1] = r13     // Catch:{ NoSuchFieldError -> 0x016b }
            L_0x016b:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0175 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SURVEY     // Catch:{ NoSuchFieldError -> 0x0175 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0175 }
                r0[r1] = r14     // Catch:{ NoSuchFieldError -> 0x0175 }
            L_0x0175:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0181 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SPLINE_SURVEY     // Catch:{ NoSuchFieldError -> 0x0181 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0181 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0181 }
            L_0x0181:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x018b }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.YAW_CONDITION     // Catch:{ NoSuchFieldError -> 0x018b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018b }
                r0[r1] = r16     // Catch:{ NoSuchFieldError -> 0x018b }
            L_0x018b:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x0195 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.SET_RELAY     // Catch:{ NoSuchFieldError -> 0x0195 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0195 }
                r0[r1] = r17     // Catch:{ NoSuchFieldError -> 0x0195 }
            L_0x0195:
                int[] r0 = f8654x5ec7fdea     // Catch:{ NoSuchFieldError -> 0x01a1 }
                com.o3dr.services.android.lib.drone.mission.MissionItemType r1 = com.o3dr.services.android.lib.drone.mission.MissionItemType.DO_JUMP     // Catch:{ NoSuchFieldError -> 0x01a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a1 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a1 }
            L_0x01a1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.ProxyUtils.C60121.<clinit>():void");
        }
    }

    public static MissionItem getProxyMissionItem(MissionItemImpl missionItemImpl) {
        if (missionItemImpl == null) {
            return null;
        }
        boolean z = false;
        switch (C60121.f8655xc8613e93[missionItemImpl.getType().ordinal()]) {
            case 1:
                WaypointImpl waypointImpl = (WaypointImpl) missionItemImpl;
                Waypoint waypoint = new Waypoint();
                waypoint.setCoordinate(waypointImpl.getCoordinate());
                waypoint.setAcceptanceRadius(waypointImpl.getAcceptanceRadius());
                waypoint.setDelay(waypointImpl.getDelay());
                waypoint.setOrbitalRadius(waypointImpl.getOrbitalRadius());
                waypoint.setOrbitCCW(waypointImpl.isOrbitCCW());
                waypoint.setYawAngle(waypointImpl.getYawAngle());
                return waypoint;
            case 2:
                SplineWaypointImpl splineWaypointImpl = (SplineWaypointImpl) missionItemImpl;
                SplineWaypoint splineWaypoint = new SplineWaypoint();
                splineWaypoint.setCoordinate(splineWaypointImpl.getCoordinate());
                splineWaypoint.setDelay(splineWaypointImpl.getDelay());
                return splineWaypoint;
            case 3:
                TakeoffImpl takeoffImpl = (TakeoffImpl) missionItemImpl;
                Takeoff takeoff = new Takeoff();
                takeoff.setTakeoffAltitude(takeoffImpl.getFinishedAlt());
                takeoff.setTakeoffPitch(takeoffImpl.getPitch());
                return takeoff;
            case 4:
                ReturnToLaunch returnToLaunch = new ReturnToLaunch();
                returnToLaunch.setReturnAltitude(((ReturnToHomeImpl) missionItemImpl).getHeight());
                return returnToLaunch;
            case 5:
                Land land = new Land();
                land.setCoordinate(((LandImpl) missionItemImpl).getCoordinate());
                return land;
            case 6:
                DoLandStart doLandStart = new DoLandStart();
                doLandStart.setCoordinate(((DoLandStartImpl) missionItemImpl).getCoordinate());
                return doLandStart;
            case 7:
                CircleImpl circleImpl = (CircleImpl) missionItemImpl;
                Circle circle = new Circle();
                circle.setCoordinate(circleImpl.getCoordinate());
                circle.setRadius(circleImpl.getRadius());
                circle.setTurns(circleImpl.getNumberOfTurns());
                return circle;
            case 8:
                RegionOfInterestImpl regionOfInterestImpl = (RegionOfInterestImpl) missionItemImpl;
                if (regionOfInterestImpl.isReset()) {
                    return new ResetROI();
                }
                RegionOfInterest regionOfInterest = new RegionOfInterest();
                regionOfInterest.setCoordinate(regionOfInterestImpl.getCoordinate());
                return regionOfInterest;
            case 9:
                SurveyImpl surveyImpl = (SurveyImpl) missionItemImpl;
                try {
                    surveyImpl.build();
                    z = true;
                } catch (Exception unused) {
                }
                Survey survey = new Survey();
                survey.setStartCameraBeforeFirstWaypoint(surveyImpl.isStartCameraBeforeFirstWaypoint());
                survey.setValid(z);
                survey.setSurveyDetail(getSurveyDetail(surveyImpl.surveyData));
                survey.setPolygonPoints(surveyImpl.polygon.getPoints());
                if (surveyImpl.grid != null) {
                    survey.setGridPoints(surveyImpl.grid.gridPoints);
                    survey.setCameraLocations(surveyImpl.grid.getCameraLocations());
                }
                survey.setPolygonArea(surveyImpl.polygon.getArea().valueInSqMeters());
                return survey;
            case 10:
                SplineSurveyImpl splineSurveyImpl = (SplineSurveyImpl) missionItemImpl;
                try {
                    splineSurveyImpl.build();
                    z = true;
                } catch (Exception unused2) {
                }
                Survey survey2 = new Survey();
                survey2.setStartCameraBeforeFirstWaypoint(splineSurveyImpl.isStartCameraBeforeFirstWaypoint());
                survey2.setValid(z);
                survey2.setSurveyDetail(getSurveyDetail(splineSurveyImpl.surveyData));
                survey2.setPolygonPoints(splineSurveyImpl.polygon.getPoints());
                if (splineSurveyImpl.grid != null) {
                    survey2.setGridPoints(splineSurveyImpl.grid.gridPoints);
                    survey2.setCameraLocations(splineSurveyImpl.grid.getCameraLocations());
                }
                survey2.setPolygonArea(splineSurveyImpl.polygon.getArea().valueInSqMeters());
                return survey2;
            case 11:
                StructureScannerImpl structureScannerImpl = (StructureScannerImpl) missionItemImpl;
                StructureScanner structureScanner = new StructureScanner();
                structureScanner.setSurveyDetail(getSurveyDetail(structureScannerImpl.getSurveyData()));
                structureScanner.setCoordinate(structureScannerImpl.getCoordinate());
                structureScanner.setRadius(structureScannerImpl.getRadius());
                structureScanner.setCrossHatch(structureScannerImpl.isCrossHatchEnabled());
                structureScanner.setHeightStep(structureScannerImpl.getEndAltitude());
                structureScanner.setStepsCount(structureScannerImpl.getNumberOfSteps());
                structureScanner.setPath(structureScannerImpl.getPath());
                return structureScanner;
            case 12:
                ChangeSpeed changeSpeed = new ChangeSpeed();
                changeSpeed.setSpeed(((ChangeSpeedImpl) missionItemImpl).getSpeed());
                return changeSpeed;
            case 13:
                CameraTrigger cameraTrigger = new CameraTrigger();
                cameraTrigger.setTriggerDistance(((CameraTriggerImpl) missionItemImpl).getTriggerDistance());
                return cameraTrigger;
            case 14:
                EpmGripper epmGripper = new EpmGripper();
                epmGripper.setRelease(((EpmGripperImpl) missionItemImpl).isRelease());
                return epmGripper;
            case 15:
                SetServoImpl setServoImpl = (SetServoImpl) missionItemImpl;
                SetServo setServo = new SetServo();
                setServo.setChannel(setServoImpl.getChannel());
                setServo.setPwm(setServoImpl.getPwm());
                return setServo;
            case 16:
                ConditionYawImpl conditionYawImpl = (ConditionYawImpl) missionItemImpl;
                YawCondition yawCondition = new YawCondition();
                yawCondition.setAngle(conditionYawImpl.getAngle());
                yawCondition.setAngularSpeed(conditionYawImpl.getAngularSpeed());
                yawCondition.setRelative(conditionYawImpl.isRelative());
                return yawCondition;
            case 17:
                SetRelayImpl setRelayImpl = (SetRelayImpl) missionItemImpl;
                SetRelay setRelay = new SetRelay();
                setRelay.setRelayNumber(setRelayImpl.getRelayNumber());
                setRelay.setEnabled(setRelayImpl.isEnabled());
                return setRelay;
            case 18:
                DoJumpImpl doJumpImpl = (DoJumpImpl) missionItemImpl;
                DoJump doJump = new DoJump();
                doJump.setWaypoint(doJumpImpl.getWaypoint());
                doJump.setRepeatCount(doJumpImpl.getRepeatCount());
                return doJump;
            default:
                return null;
        }
    }
}
