package org.droidplanner.services.android.impl.utils;

import android.content.Context;
import android.net.Uri;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.util.ParcelableUtils;
import com.o3dr.services.android.lib.util.UriUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
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
import org.droidplanner.services.android.impl.core.mission.waypoints.CircleImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.DoLandStartImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.LandImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.RegionOfInterestImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.SplineWaypointImpl;
import org.droidplanner.services.android.impl.core.mission.waypoints.WaypointImpl;

public class MissionUtils {
    private static final String WAYPOINT_PROTOCOL_HEADER = "QGC WPL 110";

    private MissionUtils() {
    }

    public static void saveMission(Context context, Mission mission, Uri uri, ICommandListener iCommandListener) {
        saveMissionToWPL(context, mission, uri, iCommandListener);
    }

    public static Mission loadMission(Context context, Uri uri) {
        Mission loadMissionFromWPL = loadMissionFromWPL(context, uri);
        return loadMissionFromWPL == null ? loadMissionFromDpwp(context, uri) : loadMissionFromWPL;
    }

    private static void saveMissionToWPL(Context context, Mission mission, Uri uri, ICommandListener iCommandListener) {
        OutputStream outputStream;
        try {
            outputStream = UriUtils.getOutputStream(context, uri);
            outputStream.write("QGC WPL 110\n".getBytes());
            List<msg_mission_item> fromMission = fromMission(mission);
            int size = fromMission.size();
            int i = 0;
            while (i < size) {
                msg_mission_item msg_mission_item = fromMission.get(i);
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[12];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i == 0 ? 1 : 0);
                objArr[2] = Short.valueOf(msg_mission_item.frame);
                objArr[3] = Integer.valueOf(msg_mission_item.command);
                objArr[4] = Float.valueOf(msg_mission_item.param1);
                objArr[5] = Float.valueOf(msg_mission_item.param2);
                objArr[6] = Float.valueOf(msg_mission_item.param3);
                objArr[7] = Float.valueOf(msg_mission_item.param4);
                objArr[8] = Float.valueOf(msg_mission_item.f8319x);
                objArr[9] = Float.valueOf(msg_mission_item.f8320y);
                objArr[10] = Float.valueOf(msg_mission_item.f8321z);
                objArr[11] = Short.valueOf(msg_mission_item.autocontinue);
                outputStream.write(String.format(locale, "%d\t%d\t%d\t%d\t%f\t%f\t%f\t%f\t%f\t%f\t%f\t%d\n", objArr).getBytes());
                i++;
            }
            CommonApiUtils.postSuccessEvent(iCommandListener);
            outputStream.close();
        } catch (IOException e) {
            cqb.m12015e(e, "Unable to write to uri %s", uri);
            CommonApiUtils.postErrorEvent(4, iCommandListener);
        } catch (Throwable th) {
            outputStream.close();
            throw th;
        }
    }

    private static void saveMissionToDpwp(Context context, Mission mission, Uri uri, ICommandListener iCommandListener) {
        OutputStream outputStream;
        try {
            outputStream = UriUtils.getOutputStream(context, uri);
            outputStream.write(ParcelableUtils.marshall(mission));
            CommonApiUtils.postSuccessEvent(iCommandListener);
            outputStream.close();
        } catch (IOException e) {
            cqb.m12015e(e, "Unable to write to uri %s", uri);
            CommonApiUtils.postErrorEvent(4, iCommandListener);
        } catch (Throwable th) {
            outputStream.close();
            throw th;
        }
    }

    private static Mission loadMissionFromDpwp(Context context, Uri uri) {
        InputStream inputStream;
        try {
            inputStream = UriUtils.getInputStream(context, uri);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            while (inputStream.available() > 0) {
                byte[] bArr = new byte[2048];
                int read = inputStream.read(bArr);
                linkedHashMap.put(bArr, Integer.valueOf(read));
                i += read;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                allocate.put((byte[]) entry.getKey(), 0, ((Integer) entry.getValue()).intValue());
            }
            Mission mission = (Mission) ParcelableUtils.unmarshall(allocate.array(), 0, i, Mission.CREATOR);
            inputStream.close();
            return mission;
        } catch (IOException e) {
            cqb.m12015e(e, "Unable to read from uri %s", uri);
            return null;
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static Mission loadMissionFromWPL(Context context, Uri uri) {
        InputStream inputStream;
        try {
            inputStream = UriUtils.getInputStream(context, uri);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            if (!bufferedReader.readLine().contains(WAYPOINT_PROTOCOL_HEADER)) {
                cqb.m12012d("Invalid waypoint file format for %s", uri);
                inputStream.close();
                return null;
            }
            LinkedList linkedList = new LinkedList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split("\t");
                    msg_mission_item msg_mission_item = new msg_mission_item();
                    msg_mission_item.seq = Short.parseShort(split[0]);
                    msg_mission_item.current = (short) Byte.parseByte(split[1]);
                    msg_mission_item.frame = (short) Byte.parseByte(split[2]);
                    msg_mission_item.command = Short.parseShort(split[3]);
                    msg_mission_item.param1 = Float.parseFloat(split[4]);
                    msg_mission_item.param2 = Float.parseFloat(split[5]);
                    msg_mission_item.param3 = Float.parseFloat(split[6]);
                    msg_mission_item.param4 = Float.parseFloat(split[7]);
                    msg_mission_item.f8319x = Float.parseFloat(split[8]);
                    msg_mission_item.f8320y = Float.parseFloat(split[9]);
                    msg_mission_item.f8321z = Float.parseFloat(split[10]);
                    msg_mission_item.autocontinue = (short) Byte.parseByte(split[11]);
                    linkedList.add(msg_mission_item);
                } else {
                    Mission fromRawMissionItems = fromRawMissionItems(linkedList);
                    inputStream.close();
                    return fromRawMissionItems;
                }
            }
        } catch (IOException e) {
            cqb.m12015e(e, "Unable to load mission from uri %s", uri);
            return null;
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private static List<msg_mission_item> fromMission(Mission mission) {
        if (mission == null) {
            return null;
        }
        List<MissionItem> missionItems = mission.getMissionItems();
        if (missionItems.isEmpty()) {
            return Collections.emptyList();
        }
        MissionImpl missionImpl = new MissionImpl((GenericMavLinkDrone) null);
        ArrayList arrayList = new ArrayList(missionItems.size());
        for (MissionItem missionItemImpl : missionItems) {
            arrayList.addAll(ProxyUtils.getMissionItemImpl(missionImpl, missionItemImpl).packMissionItem());
        }
        return arrayList;
    }

    private static Mission fromRawMissionItems(List<msg_mission_item> list) {
        Mission mission = new Mission();
        if (list != null && !list.isEmpty()) {
            List<MissionItemImpl> processMavLinkMessages = processMavLinkMessages(new MissionImpl((GenericMavLinkDrone) null), list);
            if (!processMavLinkMessages.isEmpty()) {
                for (MissionItemImpl proxyMissionItem : processMavLinkMessages) {
                    MissionItem proxyMissionItem2 = ProxyUtils.getProxyMissionItem(proxyMissionItem);
                    if (proxyMissionItem2 != null) {
                        mission.addMissionItem(proxyMissionItem2);
                    }
                }
            }
        }
        return mission;
    }

    public static List<MissionItemImpl> processMavLinkMessages(MissionImpl missionImpl, List<msg_mission_item> list) {
        ArrayList arrayList = new ArrayList();
        for (msg_mission_item next : list) {
            int i = next.command;
            if (i == 16) {
                arrayList.add(new WaypointImpl(next, missionImpl));
            } else if (i == 18) {
                arrayList.add(new CircleImpl(next, missionImpl));
            } else if (i == 82) {
                arrayList.add(new SplineWaypointImpl(next, missionImpl));
            } else if (i == 115) {
                arrayList.add(new ConditionYawImpl(next, missionImpl));
            } else if (i == 181) {
                arrayList.add(new SetRelayImpl(next, missionImpl));
            } else if (i == 183) {
                arrayList.add(new SetServoImpl(next, missionImpl));
            } else if (i == 189) {
                arrayList.add(new DoLandStartImpl(next, missionImpl));
            } else if (i == 201) {
                arrayList.add(new RegionOfInterestImpl(next, missionImpl));
            } else if (i == 206) {
                arrayList.add(new CameraTriggerImpl(next, missionImpl));
            } else if (i == 211) {
                arrayList.add(new EpmGripperImpl(next, missionImpl));
            } else if (i == 177) {
                arrayList.add(new DoJumpImpl(next, missionImpl));
            } else if (i != 178) {
                switch (i) {
                    case 20:
                        arrayList.add(new ReturnToHomeImpl(next, missionImpl));
                        break;
                    case 21:
                        arrayList.add(new LandImpl(next, missionImpl));
                        break;
                    case 22:
                        arrayList.add(new TakeoffImpl(next, missionImpl));
                        break;
                }
            } else {
                arrayList.add(new ChangeSpeedImpl(next, missionImpl));
            }
        }
        return arrayList;
    }
}
