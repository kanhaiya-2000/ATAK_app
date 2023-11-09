package com.autel.internal.mission.evo;

import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.evo.EvoFollowMission;
import com.autel.common.mission.evo.EvoOrbitMission;
import com.autel.common.mission.evo.EvoTrackingMission;
import com.autel.common.mission.evo.EvoWaypointMission;
import com.autel.common.mission.evo.ImageStabilityMission;
import com.autel.common.mission.evo.MotionDelayMission;
import com.autel.common.mission.evo.OneShotVideoMission;
import com.autel.common.mission.evo.TripodMission;
import com.autel.common.mission.evo2.Evo2TrackingMission;
import com.autel.common.mission.evo2.Evo2VisualOrbitMission;
import com.autel.common.mission.evo2.Evo2WaypointMission;
import com.autel.internal.mission.evo2.Evo2TrackingMissionManager;
import com.autel.internal.mission.evo2.Evo2VisualOrbitMissionManager;
import com.autel.internal.mission.evo2.Evo2WaypointMissionManager;
import com.autel.internal.mission.evo2.ImageStabilityMissionManager;
import com.autel.internal.mission.evo2.MotionDelayMissionManager;
import com.autel.internal.mission.evo2.OneShotVideoMissionManager;
import com.autel.internal.mission.evo2.TripodMissionManager;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.FlyControllerStatusInternalParser;

public class MissionManagerFactory20 {
    public static EvoFollowMissionManager createMissionManager(EvoFollowMission evoFollowMission) {
        return new EvoFollowMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static EvoOrbitMissionManager createMissionManager(EvoOrbitMission evoOrbitMission) {
        return new EvoOrbitMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static OneShotVideoMissionManager createMissionManager(OneShotVideoMission oneShotVideoMission) {
        return new OneShotVideoMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static TripodMissionManager createMissionManager(TripodMission tripodMission) {
        return new TripodMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static MotionDelayMissionManager createMissionManager(MotionDelayMission motionDelayMission) {
        return new MotionDelayMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static ImageStabilityMissionManager createMissionManager(ImageStabilityMission imageStabilityMission) {
        return new ImageStabilityMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static EvoWaypointMissionManager createMissionManager(EvoWaypointMission evoWaypointMission) {
        return new EvoWaypointMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static EvoTrackingMissionManager createMissionManager(EvoTrackingMission evoTrackingMission) {
        return new EvoTrackingMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static Evo2TrackingMissionManager createMissionManager(Evo2TrackingMission evo2TrackingMission) {
        return new Evo2TrackingMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static Evo2VisualOrbitMissionManager createMissionManager(Evo2VisualOrbitMission evo2VisualOrbitMission) {
        return new Evo2VisualOrbitMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static Evo2WaypointMissionManager createMissionManager(Evo2WaypointMission evo2WaypointMission) {
        return new Evo2WaypointMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static MissionManager createMissionManager(C2700AutelMission autelMission) {
        if (autelMission instanceof EvoTrackingMission) {
            return createMissionManager((EvoTrackingMission) autelMission);
        }
        if (autelMission instanceof Evo2TrackingMission) {
            return createMissionManager((Evo2TrackingMission) autelMission);
        }
        if (autelMission instanceof Evo2VisualOrbitMission) {
            return createMissionManager((Evo2VisualOrbitMission) autelMission);
        }
        if (autelMission instanceof EvoFollowMission) {
            return createMissionManager((EvoFollowMission) autelMission);
        }
        if (autelMission instanceof EvoOrbitMission) {
            return createMissionManager((EvoOrbitMission) autelMission);
        }
        if (autelMission instanceof EvoWaypointMission) {
            return createMissionManager((EvoWaypointMission) autelMission);
        }
        if (autelMission instanceof Evo2WaypointMission) {
            return createMissionManager((Evo2WaypointMission) autelMission);
        }
        if (autelMission instanceof OneShotVideoMission) {
            return createMissionManager((OneShotVideoMission) autelMission);
        }
        if (autelMission instanceof TripodMission) {
            return createMissionManager((TripodMission) autelMission);
        }
        if (autelMission instanceof ImageStabilityMission) {
            return createMissionManager((ImageStabilityMission) autelMission);
        }
        if (autelMission instanceof MotionDelayMission) {
            return createMissionManager((MotionDelayMission) autelMission);
        }
        return null;
    }
}
