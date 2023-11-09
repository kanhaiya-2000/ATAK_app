package com.atakmap.android.uastool.PD100;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.PD100.PD100Parser;
import com.atakmap.android.uastool.RouteDrawPoint;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import indago.serialization.JsonValueConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class PD100UASItem extends UASItem {
    public static final String DETAIL_TAG = "_PD100_";
    public static final String DISPLAY_NAME = "BH3";
    private static PopupWindow subToolbar;
    private static LinearLayout subToolbarView;

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public PD100UASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public PD100UASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_JOYSTICK_VIRTUAL, false);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE, true);
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (PD100SettingsScreen) layoutInflater.inflate(C1877R.layout.pd100_settings_layout, (ViewGroup) null);
    }

    public ArrayList<RouteDrawPoint> getRouteDrawPoints() {
        ArrayList<RouteDrawPoint> arrayList = new ArrayList<>();
        if (this.uasMarker != null) {
            String metaString = this.uasMarker.getMetaString("waypoints", (String) null);
            if (!TextUtils.isEmpty(metaString)) {
                for (String split : metaString.split("\n")) {
                    arrayList.add(new RouteDrawPoint(split.split("\\s*,\\s*")));
                }
            }
        }
        return arrayList;
    }

    public UASItem.SIGNAL_STRENGTH getSignalStrength() {
        if (getMarker() != null) {
            return UASItem.SIGNAL_STRENGTH.OK;
        }
        return super.getSignalStrength();
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            if (C11481.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()] != 1) {
                UASToolDropDownReceiver.toast("Unable to run unknown task type: " + uASTask.getTaskType().name(), 0);
            } else {
                runRouteTask((RouteTask) uASTask);
            }
            if (uASTask.getTaskMessageUid() != null) {
                sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.EXECUTING);
                return;
            }
            return;
        }
        UASToolDropDownReceiver.toast("DJI tasking failed: NULL task", 0);
        Log.w(TAG, "DJI tasking failed: NULL task");
    }

    /* renamed from: com.atakmap.android.uastool.PD100.PD100UASItem$1 */
    /* synthetic */ class C11481 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        static {
            int[] iArr = new int[UASTask.TASKTYPE.values().length];
            $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = iArr;
            try {
                iArr[UASTask.TASKTYPE.ROUTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void runRouteTask(RouteTask routeTask) {
        UASRoute route = routeTask.getRoute();
        ArrayList arrayList = new ArrayList();
        Iterator<UASPoint> it = route.getPoints().iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            GeoPoint C = next.C();
            double d = 0.0d;
            double a = ElevationManager.a(C.getLatitude(), C.getLongitude(), (ElevationManager.b) null);
            if (GeoPoint.isAltitudeValid(a)) {
                d = a;
            }
            String name = next.getName();
            String format = String.format(Locale.US, "%01.7f", new Object[]{Double.valueOf(next.C().getLatitude())});
            String format2 = String.format(Locale.US, "%01.7f", new Object[]{Double.valueOf(next.C().getLongitude())});
            String str = format;
            String str2 = format2;
            arrayList.add(new RouteDrawPoint(name, "Route Waypoint", str, str2, String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(d + ((double) next.getAGL()))}), JsonValueConstants.VERSION));
        }
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
        } else {
            ((PD100Monitor) platformMonitor).uplinkRouteAndTask(PD100Parser.PD100EventType.TASK_RELOCATE, this.uid, route.getName(), arrayList, 20.0d, 40.0d, 30);
        }
    }

    public String getVideoUrl() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_IP, "");
        String string2 = UASToolDropDownReceiver.getSharedPrefs().getString(PD100PrefHandler.PREF_SRC_PORT, "");
        if (!isConnected()) {
            return super.getVideoUrl();
        }
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor != null && (platformMonitor instanceof PD100Monitor)) {
            PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
            string = pD100Monitor.getActiveVideoIP();
            string2 = Integer.toString(pD100Monitor.getActiveVideoPort());
        }
        return "udp://" + string + ":" + string2;
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_bh3_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public boolean isEOStreamAvailable() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
            return false;
        }
        return ((PD100Monitor) platformMonitor).isEOStreamAvailable();
    }

    public boolean isIRStreamAvailable() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
            return false;
        }
        return ((PD100Monitor) platformMonitor).isIRStreamAvailable();
    }

    public boolean isGCSStreamAvailable() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
            return false;
        }
        return ((PD100Monitor) platformMonitor).isGCSStreamAvailable();
    }

    public boolean isStale() {
        if (isConnected()) {
            return false;
        }
        return super.isStale();
    }

    public boolean setVirtualStickMode(boolean z) {
        String str = TAG;
        Log.d(str, "Virtual Joystick Mode not implemented for platform " + this.platformType);
        return false;
    }

    public void joystickForwardIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickForwardCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickBackwardIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickBackwardCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickYawLeftIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickYawLeftCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickPanLeftIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickPanLeftCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickYawRightIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickYawRightCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickPanRightIncr() {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }

    public void joystickPanRightCont(boolean z) {
        String str = TAG;
        Log.d(str, "Joystick Buttons not implemented for platform " + this.platformType);
    }
}
