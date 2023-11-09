package com.atakmap.android.uastool.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import transapps.mapi.MapView;
import transapps.maps.plugin.tool.Group;
import transapps.maps.plugin.tool.Tool;
import transapps.maps.plugin.tool.ToolDescriptor;

public class SUASIntegratorTool extends Tool implements ToolDescriptor {
    private final Context context;

    public Tool getTool() {
        return this;
    }

    public void onDeactivate(Tool.ToolCallback toolCallback) {
    }

    public SUASIntegratorTool(Context context2) {
        this.context = context2;
        AddRouteReceiver addRouteReceiver = new AddRouteReceiver(context2);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter.a("com.atakmap.android.uastool.ADD_ROUTE", "Add Route");
        AtakBroadcast.a().a(addRouteReceiver, documentedIntentFilter);
        SendRouteReceiver sendRouteReceiver = new SendRouteReceiver();
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter2 = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter2.a("com.atakmap.android.uastool.SEND_ROUTE", "Send Route");
        AtakBroadcast.a().a(sendRouteReceiver, documentedIntentFilter2);
        GimbalLookReceiver gimbalLookReceiver = new GimbalLookReceiver(context2);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter3 = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter3.a("com.atakmap.android.uastool.GIMBAL_LOOK_TASKING", "Gimbal look tasking");
        AtakBroadcast.a().a(gimbalLookReceiver, documentedIntentFilter3);
        PayloadConfigReceiver payloadConfigReceiver = new PayloadConfigReceiver(context2);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter4 = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter4.a("com.atakmap.android.uastool.PAYLOAD_CONFIG_TASKING", "Payload look tasking");
        AtakBroadcast.a().a(payloadConfigReceiver, documentedIntentFilter4);
        WaypointSetReceiver waypointSetReceiver = new WaypointSetReceiver(context2);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter5 = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter5.a("com.atakmap.android.uastool.GIMBAL_PICTURE_TASKING", "Waypoint set tasking");
        AtakBroadcast.a().a(waypointSetReceiver, documentedIntentFilter5);
    }

    public String getDescription() {
        return this.context.getString(C1877R.string.app_name);
    }

    public Drawable getIcon() {
        Context context2 = this.context;
        if (context2 == null) {
            return null;
        }
        return context2.getResources().getDrawable(C1877R.drawable.ic_launcher);
    }

    public Group[] getGroups() {
        return new Group[]{Group.GENERAL};
    }

    public String getShortDescription() {
        return this.context.getString(C1877R.string.app_name);
    }

    public void onActivate(Activity activity, MapView mapView, ViewGroup viewGroup, Bundle bundle, Tool.ToolCallback toolCallback) {
        if (toolCallback != null) {
            toolCallback.onToolDeactivated(this);
        }
        AtakBroadcast.a().a(new Intent(UASToolDropDownReceiver.SHOW_UASTOOL));
    }
}
