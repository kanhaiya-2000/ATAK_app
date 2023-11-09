package org.droidplanner.services.android.impl.core.mission;

import android.util.Pair;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.Attitude;
import com.o3dr.services.android.lib.drone.property.Gps;
import com.o3dr.services.android.lib.drone.property.Home;
import com.o3dr.services.android.lib.drone.property.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;
import org.droidplanner.services.android.impl.core.mission.commands.ChangeSpeedImpl;
import org.droidplanner.services.android.impl.core.mission.commands.ReturnToHomeImpl;
import org.droidplanner.services.android.impl.core.mission.commands.TakeoffImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.LandImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.RegionOfInterestImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.SpatialCoordItem;
import org.droidplanner.services.android.impl.core.mission.waypoints.WaypointImpl;
import org.droidplanner.services.android.impl.utils.MissionUtils;

public class MissionImpl extends DroneVariable<GenericMavLinkDrone> {
    private final List<MissionItemImpl> componentItems = new ArrayList();
    private List<MissionItemImpl> items = new ArrayList();

    public MissionImpl(GenericMavLinkDrone genericMavLinkDrone) {
        super(genericMavLinkDrone);
    }

    public void removeWaypoint(MissionItemImpl missionItemImpl) {
        this.items.remove(missionItemImpl);
        notifyMissionUpdate();
    }

    public void removeWaypoints(List<MissionItemImpl> list) {
        this.items.removeAll(list);
        notifyMissionUpdate();
    }

    public void addMissionItems(List<MissionItemImpl> list) {
        this.items.addAll(list);
        notifyMissionUpdate();
    }

    public void clearMissionItems() {
        this.items.clear();
        notifyMissionUpdate();
    }

    public void addMissionItem(MissionItemImpl missionItemImpl) {
        this.items.add(missionItemImpl);
        notifyMissionUpdate();
    }

    public void addMissionItem(int i, MissionItemImpl missionItemImpl) {
        this.items.add(i, missionItemImpl);
        notifyMissionUpdate();
    }

    public void notifyMissionUpdate() {
        updateComponentItems();
        ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_UPDATE);
    }

    public void replace(MissionItemImpl missionItemImpl, MissionItemImpl missionItemImpl2) {
        int indexOf = this.items.indexOf(missionItemImpl);
        if (indexOf != -1) {
            this.items.remove(indexOf);
            this.items.add(indexOf, missionItemImpl2);
            notifyMissionUpdate();
        }
    }

    public void replaceAll(List<Pair<MissionItemImpl, MissionItemImpl>> list) {
        if (list != null && !list.isEmpty()) {
            boolean z = false;
            for (Pair next : list) {
                int indexOf = this.items.indexOf((MissionItemImpl) next.first);
                if (indexOf != -1) {
                    this.items.remove(indexOf);
                    this.items.add(indexOf, (MissionItemImpl) next.second);
                    z = true;
                }
            }
            if (z) {
                notifyMissionUpdate();
            }
        }
    }

    public void reverse() {
        Collections.reverse(this.items);
        notifyMissionUpdate();
    }

    public void onWriteWaypoints(msg_mission_ack msg_mission_ack) {
        ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_SENT);
    }

    public List<MissionItemImpl> getItems() {
        return this.items;
    }

    public List<MissionItemImpl> getComponentItems() {
        return this.componentItems;
    }

    public int getOrder(MissionItemImpl missionItemImpl) {
        return this.items.indexOf(missionItemImpl) + 1;
    }

    public double getAltitudeDiffFromPreviousItem(SpatialCoordItem spatialCoordItem) {
        int indexOf = this.items.indexOf(spatialCoordItem);
        if (indexOf > 0) {
            MissionItemImpl missionItemImpl = this.items.get(indexOf - 1);
            if (missionItemImpl instanceof SpatialCoordItem) {
                return spatialCoordItem.getCoordinate().getAltitude() - ((SpatialCoordItem) missionItemImpl).getCoordinate().getAltitude();
            }
        }
        throw new IllegalArgumentException("Last waypoint doesn't have an altitude");
    }

    public double getDistanceFromLastWaypoint(SpatialCoordItem spatialCoordItem) {
        int indexOf = this.items.indexOf(spatialCoordItem);
        if (indexOf > 0) {
            MissionItemImpl missionItemImpl = this.items.get(indexOf - 1);
            if (missionItemImpl instanceof SpatialCoordItem) {
                return GeoTools.getDistance(spatialCoordItem.getCoordinate(), ((SpatialCoordItem) missionItemImpl).getCoordinate());
            }
        }
        throw new IllegalArgumentException("Last waypoint doesn't have a coordinate");
    }

    public boolean hasItem(MissionItemImpl missionItemImpl) {
        return this.items.contains(missionItemImpl);
    }

    public void onMissionReceived(List<msg_mission_item> list) {
        if (list != null) {
            ((GenericMavLinkDrone) this.myDrone).processHomeUpdate(list.get(0));
            list.remove(0);
            this.items.clear();
            this.items.addAll(MissionUtils.processMavLinkMessages(this, list));
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_RECEIVED);
            notifyMissionUpdate();
        }
    }

    public void onMissionLoaded(List<msg_mission_item> list) {
        if (list != null) {
            ((GenericMavLinkDrone) this.myDrone).processHomeUpdate(list.get(0));
            list.remove(0);
            this.items.clear();
            this.items.addAll(MissionUtils.processMavLinkMessages(this, list));
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_RECEIVED);
            notifyMissionUpdate();
        }
    }

    public void sendMissionToAPM() {
        List<msg_mission_item> msgMissionItems = getMsgMissionItems();
        ((GenericMavLinkDrone) this.myDrone).getWaypointManager().writeWaypoints(msgMissionItems);
        updateComponentItems(msgMissionItems);
    }

    private void updateComponentItems() {
        updateComponentItems(getMsgMissionItems());
    }

    private void updateComponentItems(List<msg_mission_item> list) {
        this.componentItems.clear();
        if (list != null && !list.isEmpty()) {
            if (list.get(0).seq == 0) {
                list.remove(0);
            }
            this.componentItems.addAll(MissionUtils.processMavLinkMessages(this, list));
        }
    }

    public msg_mission_item packHomeMavlink() {
        Home home = (Home) ((GenericMavLinkDrone) this.myDrone).getAttribute(AttributeType.HOME);
        LatLongAlt coordinate = home.getCoordinate();
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.autocontinue = 1;
        msg_mission_item.command = 16;
        msg_mission_item.current = 0;
        msg_mission_item.frame = 0;
        msg_mission_item.target_system = ((GenericMavLinkDrone) this.myDrone).getSysid();
        msg_mission_item.target_component = ((GenericMavLinkDrone) this.myDrone).getCompid();
        if (home.isValid()) {
            msg_mission_item.f8319x = (float) coordinate.getLatitude();
            msg_mission_item.f8320y = (float) coordinate.getLongitude();
            msg_mission_item.f8321z = (float) coordinate.getAltitude();
        }
        return msg_mission_item;
    }

    public List<msg_mission_item> getMsgMissionItems() {
        ArrayList arrayList = new ArrayList();
        msg_mission_item packHomeMavlink = packHomeMavlink();
        packHomeMavlink.seq = 0;
        arrayList.add(packHomeMavlink);
        int size = this.items.size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            for (msg_mission_item next : this.items.get(i2).packMissionItem()) {
                next.seq = i;
                arrayList.add(next);
                i++;
            }
        }
        return arrayList;
    }

    public double makeAndUploadDronie() {
        Gps gps = (Gps) ((GenericMavLinkDrone) this.myDrone).getAttribute(AttributeType.GPS);
        LatLong position = gps.getPosition();
        if (position == null || gps.getSatellitesCount() <= 5) {
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.WARNING_NO_GPS);
            return -1.0d;
        }
        double yaw = ((Attitude) ((GenericMavLinkDrone) this.myDrone).getAttribute(AttributeType.ATTITUDE)).getYaw() + 180.0d;
        this.items.clear();
        this.items.addAll(createDronie(position, GeoTools.newCoordFromBearingAndDistance(position, yaw, 50.0d)));
        sendMissionToAPM();
        notifyMissionUpdate();
        return yaw;
    }

    private double getSpeedParameter() {
        Parameter parameter = ((GenericMavLinkDrone) this.myDrone).getParameterManager().getParameter("WPNAV_SPEED");
        if (parameter == null) {
            return -1.0d;
        }
        return parameter.getValue() / 100.0d;
    }

    public List<MissionItemImpl> createDronie(LatLong latLong, LatLong latLong2) {
        LatLong latLong3 = latLong;
        LatLong latLong4 = latLong2;
        LatLong pointAlongTheLine = GeoTools.pointAlongTheLine(latLong3, latLong4, 5);
        double speedParameter = getSpeedParameter();
        if (speedParameter == -1.0d) {
            speedParameter = 5.0d;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TakeoffImpl(this, 4.0d));
        arrayList.add(new RegionOfInterestImpl(this, new LatLongAlt(GeoTools.pointAlongTheLine(latLong3, latLong4, -8), 1.0d)));
        arrayList.add(new WaypointImpl(this, new LatLongAlt(latLong4, (GeoTools.getDistance(latLong, latLong2) / 2.0d) + 4.0d)));
        arrayList.add(new WaypointImpl(this, new LatLongAlt(pointAlongTheLine, (GeoTools.getDistance(latLong3, pointAlongTheLine) / 2.0d) + 4.0d)));
        arrayList.add(new ChangeSpeedImpl(this, 1.0d));
        arrayList.add(new WaypointImpl(this, new LatLongAlt(latLong3, 4.0d)));
        arrayList.add(new ChangeSpeedImpl(this, speedParameter));
        arrayList.add(new LandImpl(this, latLong3));
        return arrayList;
    }

    public boolean hasTakeoffAndLandOrRTL() {
        return this.items.size() >= 2 && isFirstItemTakeoff() && isLastItemLandOrRTL();
    }

    public boolean isFirstItemTakeoff() {
        return !this.items.isEmpty() && (this.items.get(0) instanceof TakeoffImpl);
    }

    public boolean isLastItemLandOrRTL() {
        if (this.items.isEmpty()) {
            return false;
        }
        List<MissionItemImpl> list = this.items;
        MissionItemImpl missionItemImpl = list.get(list.size() - 1);
        if ((missionItemImpl instanceof ReturnToHomeImpl) || (missionItemImpl instanceof LandImpl)) {
            return true;
        }
        return false;
    }
}
