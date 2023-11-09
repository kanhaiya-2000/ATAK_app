package com.o3dr.services.android.lib.drone.mission;

import android.os.Bundle;
import android.os.Parcelable;
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
import com.o3dr.services.android.lib.drone.mission.item.complex.SplineSurvey;
import com.o3dr.services.android.lib.drone.mission.item.complex.StructureScanner;
import com.o3dr.services.android.lib.drone.mission.item.complex.Survey;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Circle;
import com.o3dr.services.android.lib.drone.mission.item.spatial.DoLandStart;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Land;
import com.o3dr.services.android.lib.drone.mission.item.spatial.RegionOfInterest;
import com.o3dr.services.android.lib.drone.mission.item.spatial.SplineWaypoint;
import com.o3dr.services.android.lib.drone.mission.item.spatial.Waypoint;
import com.o3dr.services.android.lib.drone.property.Type;
import com.o3dr.services.android.lib.util.ParcelableUtils;

public enum MissionItemType {
    WAYPOINT("Waypoint") {
        public MissionItem getNewItem() {
            return new Waypoint();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<Waypoint> getMissionItemCreator() {
            return Waypoint.CREATOR;
        }
    },
    SPLINE_WAYPOINT("Spline Waypoint") {
        public MissionItem getNewItem() {
            return new SplineWaypoint();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<SplineWaypoint> getMissionItemCreator() {
            return SplineWaypoint.CREATOR;
        }
    },
    TAKEOFF("Takeoff") {
        public MissionItem getNewItem() {
            return new Takeoff();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<Takeoff> getMissionItemCreator() {
            return Takeoff.CREATOR;
        }
    },
    CHANGE_SPEED("Change Speed") {
        public MissionItem getNewItem() {
            return new ChangeSpeed();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<ChangeSpeed> getMissionItemCreator() {
            return ChangeSpeed.CREATOR;
        }
    },
    CAMERA_TRIGGER("Camera Trigger") {
        public MissionItem getNewItem() {
            return new CameraTrigger();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<CameraTrigger> getMissionItemCreator() {
            return CameraTrigger.CREATOR;
        }
    },
    EPM_GRIPPER("EPM Gripper") {
        public MissionItem getNewItem() {
            return new EpmGripper();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<EpmGripper> getMissionItemCreator() {
            return EpmGripper.CREATOR;
        }
    },
    RETURN_TO_LAUNCH("Return to Launch") {
        public MissionItem getNewItem() {
            return new ReturnToLaunch();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<ReturnToLaunch> getMissionItemCreator() {
            return ReturnToLaunch.CREATOR;
        }
    },
    LAND("Land") {
        public MissionItem getNewItem() {
            return new Land();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<Land> getMissionItemCreator() {
            return Land.CREATOR;
        }
    },
    CIRCLE("Circle") {
        public MissionItem getNewItem() {
            return new Circle();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<Circle> getMissionItemCreator() {
            return Circle.CREATOR;
        }
    },
    REGION_OF_INTEREST("Region of Interest") {
        public MissionItem getNewItem() {
            return new RegionOfInterest();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<RegionOfInterest> getMissionItemCreator() {
            return RegionOfInterest.CREATOR;
        }
    },
    SURVEY("Survey") {
        public MissionItem getNewItem() {
            return new Survey();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<Survey> getMissionItemCreator() {
            return Survey.CREATOR;
        }
    },
    STRUCTURE_SCANNER("Structure Scanner") {
        public MissionItem getNewItem() {
            return new StructureScanner();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<StructureScanner> getMissionItemCreator() {
            return StructureScanner.CREATOR;
        }
    },
    SET_SERVO("Set Servo") {
        public MissionItem getNewItem() {
            return new SetServo();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<SetServo> getMissionItemCreator() {
            return SetServo.CREATOR;
        }
    },
    YAW_CONDITION("Set Yaw") {
        public MissionItem getNewItem() {
            return new YawCondition();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<YawCondition> getMissionItemCreator() {
            return YawCondition.CREATOR;
        }
    },
    SET_RELAY("Set Relay") {
        public MissionItem getNewItem() {
            return new SetRelay();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<SetRelay> getMissionItemCreator() {
            return SetRelay.CREATOR;
        }
    },
    DO_LAND_START("Do Land start") {
        public boolean isTypeSupported(Type type) {
            return MissionItemType.super.isTypeSupported(type) && type.getDroneType() == 1;
        }

        public MissionItem getNewItem() {
            return new DoLandStart();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<DoLandStart> getMissionItemCreator() {
            return DoLandStart.CREATOR;
        }
    },
    SPLINE_SURVEY("Spline Survey") {
        public MissionItem getNewItem() {
            return new SplineSurvey();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<SplineSurvey> getMissionItemCreator() {
            return SplineSurvey.CREATOR;
        }
    },
    DO_JUMP("Do Jump") {
        public MissionItem getNewItem() {
            return new DoJump();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<DoJump> getMissionItemCreator() {
            return DoJump.CREATOR;
        }
    },
    RESET_ROI("Reset ROI") {
        public MissionItem getNewItem() {
            return new ResetROI();
        }

        /* access modifiers changed from: protected */
        public Parcelable.Creator<ResetROI> getMissionItemCreator() {
            return ResetROI.CREATOR;
        }
    };
    
    private static final String EXTRA_MISSION_ITEM = "extra_mission_item";
    private static final String EXTRA_MISSION_ITEM_TYPE = "extra_mission_item_type";
    private final String label;

    /* access modifiers changed from: protected */
    public abstract <T extends MissionItem> Parcelable.Creator<T> getMissionItemCreator();

    public abstract MissionItem getNewItem();

    public boolean isTypeSupported(Type type) {
        return type != null;
    }

    private MissionItemType(String str) {
        this.label = str;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        return getLabel();
    }

    public final Bundle storeMissionItem(MissionItem missionItem) {
        Bundle bundle = new Bundle(2);
        storeMissionItem(missionItem, bundle);
        return bundle;
    }

    public void storeMissionItem(MissionItem missionItem, Bundle bundle) {
        bundle.putString(EXTRA_MISSION_ITEM_TYPE, name());
        bundle.putByteArray(EXTRA_MISSION_ITEM, ParcelableUtils.marshall(missionItem));
    }

    public static <T extends MissionItem> T restoreMissionItemFromBundle(Bundle bundle) {
        MissionItemType valueOf;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(EXTRA_MISSION_ITEM_TYPE);
        byte[] byteArray = bundle.getByteArray(EXTRA_MISSION_ITEM);
        if (string == null || byteArray == null || (valueOf = valueOf(string)) == null) {
            return null;
        }
        return (MissionItem) ParcelableUtils.unmarshall(byteArray, valueOf.getMissionItemCreator());
    }
}
