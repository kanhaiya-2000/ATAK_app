package com.atakmap.android.uastool.paladin;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.paladin.CommandParser;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

public class PaladinPayloadManager {
    private static final String CONNECTED = "Connected";
    /* access modifiers changed from: private */
    public static final int CONNECTED_COLOR = Color.argb(255, 0, 204, 0);
    private static final long CONNECTION_TIMEOUT_MILLS = 7000;
    private static final String NOT_CONNECTED = "Not Connected";
    /* access modifiers changed from: private */
    public static final int NOT_CONNECTED_COLOR = Color.argb(255, 204, 0, 0);
    private static final String TAG = "PaladinPayloadManager";
    /* access modifiers changed from: private */
    public static Button connectBtn;
    private static PaladinPayloadManager instance;
    /* access modifiers changed from: private */
    public static long lastStatus = 0;
    private TimerTask checkConnectionTimerTask;
    /* access modifiers changed from: private */
    public final TextView connectionStatusTV;
    private Timer connectionTimer;

    /* renamed from: cp */
    private final CommandParser f8408cp;
    private final HashMap<String, LinearLayout> featureCommandLayoutMap = new HashMap<>();
    private final HashMap<String, CommandParser.FeatureCommand> featureMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<String, TextView> featureStatusMap = new HashMap<>();
    private final HashMap<String, View> featureViewMap = new HashMap<>();
    /* access modifiers changed from: private */
    public AlertDialog hubSelectDialog;
    private final LayoutInflater inflater;
    private final View mainPayloadView;
    private final Context pluginContext;

    public static PaladinPayloadManager getInstance() {
        if (instance == null) {
            instance = new PaladinPayloadManager();
        }
        return instance;
    }

    private PaladinPayloadManager() {
        Context pluginContext2 = UASToolDropDownReceiver.getInstance().getPluginContext();
        this.pluginContext = pluginContext2;
        this.inflater = LayoutInflater.from(pluginContext2);
        View inflate = PluginLayoutInflater.inflate(pluginContext2, C1877R.layout.paladin_payload_layout, (ViewGroup) null);
        this.mainPayloadView = inflate;
        File item = FileSystemUtils.getItem("tools" + File.separator + "Paladin" + File.separator + "capabilities.json");
        this.connectionStatusTV = (TextView) inflate.findViewById(C1877R.C1878id.connection_tv);
        connectBtn = (Button) inflate.findViewById(C1877R.C1878id.connect_btn);
        CommandParser commandParser = new CommandParser(item);
        this.f8408cp = commandParser;
        if (hasFeatures()) {
            try {
                setupFeatureUI(commandParser);
                connect();
            } catch (IOException e) {
                Log.e(TAG, "error", e);
            }
        }
    }

    public boolean hasFeatures() {
        try {
            if (this.f8408cp.getFeatureMap() != null) {
                return !this.f8408cp.getFeatureMap().isEmpty();
            }
            return false;
        } catch (IOException e) {
            Log.e(TAG, "error", e);
            return false;
        }
    }

    public void connect() {
        if (hasFeatures()) {
            PaladinCommands.listenForAcks(this, this.f8408cp.getAckIP(), this.f8408cp.getAckPort());
            PaladinCommands.scheduleHeartbeatSend(this.f8408cp.getStatusCommand(), getIP(), getPort());
            startConnectionListener();
        }
    }

    public void cancel() {
        PaladinCommands.stopListenForAcks();
        PaladinCommands.stopHeartbeatSend();
        stopConnectionListener();
    }

    public View getPayloadView() {
        return this.mainPayloadView;
    }

    public void setupFeatureUI(final CommandParser commandParser) {
        LinkedHashMap<String, CommandParser.FeatureCommand> featureMap2 = commandParser.getFeatureMap();
        LinearLayout linearLayout = (LinearLayout) this.mainPayloadView.findViewById(C1877R.C1878id.buttonLayout);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PaladinPayloadManager.this.sendCommand(commandParser.getStatusCommand());
                PaladinCommands.scheduleHeartbeatSend(commandParser.getStatusCommand(), PaladinPayloadManager.this.getIP(), PaladinPayloadManager.this.getPort());
            }
        });
        for (String next : featureMap2.keySet()) {
            final CommandParser.FeatureCommand featureCommand = featureMap2.get(next);
            this.featureMap.put(next, featureCommand);
            View inflate = this.inflater.inflate(C1877R.layout.payload_feature_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(C1877R.C1878id.feature_title_tv)).setText(next);
            this.featureStatusMap.put(next, (TextView) inflate.findViewById(C1877R.C1878id.feature_status_tv));
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(C1877R.C1878id.commandButton_ll);
            this.featureCommandLayoutMap.put(next, linearLayout2);
            for (final int i = 0; i < featureCommand.getNumCommands(); i++) {
                Button button = (Button) this.inflater.inflate(C1877R.layout.payload_command_btn, (ViewGroup) null);
                button.setTag(featureCommand.getCommandName(i));
                linearLayout2.addView(button);
                button.setText(featureCommand.getCommandDisplayName(i));
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        PaladinPayloadManager.this.showOptions(featureCommand.getCommandSet(i));
                    }
                });
            }
            linearLayout.addView(inflate);
        }
    }

    public void resetUI() {
        this.connectionStatusTV.setText(NOT_CONNECTED);
        this.connectionStatusTV.setTextColor(NOT_CONNECTED_COLOR);
        connectBtn.setVisibility(0);
        for (String str : this.featureStatusMap.keySet()) {
            this.featureStatusMap.get(str).setText("Status Unknown");
        }
        for (String str2 : this.featureCommandLayoutMap.keySet()) {
            LinearLayout linearLayout = this.featureCommandLayoutMap.get(str2);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                Button button = (Button) linearLayout.getChildAt(i);
                String charSequence = button.getText().toString();
                if (charSequence.contains(":")) {
                    button.setText(charSequence.substring(0, charSequence.indexOf(":")));
                }
            }
        }
    }

    public void updateFeatureStatus(String str) {
        String str2;
        if (str != null && str.length() != 0) {
            while (str.contains(":")) {
                try {
                    if (str.contains(",")) {
                        String substring = str.substring(0, str.indexOf(44));
                        str2 = str.substring(str.indexOf(",") + 1);
                        str = substring;
                    } else {
                        str2 = "";
                    }
                    String trim = str.trim();
                    final String substring2 = trim.substring(0, trim.indexOf(":"));
                    final String substring3 = trim.substring(trim.indexOf(":") + 1);
                    if (substring3.contains("=")) {
                        while (substring3.contains("=")) {
                            String substring4 = substring3.substring(0, substring3.indexOf("="));
                            final String substring5 = substring3.substring(substring3.indexOf("=") + 1);
                            if (substring3.contains("+")) {
                                substring5 = substring5.substring(0, substring5.indexOf("+"));
                                substring3 = substring3.substring(substring3.indexOf("+") + 1);
                            } else {
                                substring3 = "";
                            }
                            if (!substring4.equals("overall")) {
                                LinearLayout linearLayout = this.featureCommandLayoutMap.get(substring2);
                                if (linearLayout.findViewWithTag(substring4) != null) {
                                    final Button button = (Button) linearLayout.findViewWithTag(substring4);
                                    final String str3 = this.featureMap.get(substring2).getCommandDisplayName(substring4) + ": " + substring5;
                                    MapView.getMapView().post(new Runnable() {
                                        public void run() {
                                            button.setText(str3);
                                        }
                                    });
                                }
                            } else if (this.featureStatusMap.containsKey(substring2)) {
                                MapView.getMapView().post(new Runnable() {
                                    public void run() {
                                        ((TextView) PaladinPayloadManager.this.featureStatusMap.get(substring2)).setText(substring5);
                                        if (!PaladinPayloadManager.this.connectionStatusTV.getText().equals(PaladinPayloadManager.CONNECTED)) {
                                            PaladinPayloadManager.this.connectionStatusTV.setText(PaladinPayloadManager.CONNECTED);
                                            PaladinPayloadManager.this.connectionStatusTV.setTextColor(PaladinPayloadManager.CONNECTED_COLOR);
                                            PaladinPayloadManager.connectBtn.setVisibility(8);
                                        }
                                    }
                                });
                            }
                        }
                    } else if (this.featureStatusMap.containsKey(substring2)) {
                        MapView.getMapView().post(new Runnable() {
                            public void run() {
                                ((TextView) PaladinPayloadManager.this.featureStatusMap.get(substring2)).setText(substring3);
                                if (!PaladinPayloadManager.this.connectionStatusTV.getText().equals(PaladinPayloadManager.CONNECTED)) {
                                    PaladinPayloadManager.this.connectionStatusTV.setText(PaladinPayloadManager.CONNECTED);
                                    PaladinPayloadManager.this.connectionStatusTV.setTextColor(PaladinPayloadManager.CONNECTED_COLOR);
                                    PaladinPayloadManager.connectBtn.setVisibility(8);
                                }
                            }
                        });
                    }
                    str = str2;
                } catch (Exception e) {
                    Log.e(TAG, "error", e);
                }
            }
            lastStatus = System.currentTimeMillis();
        }
    }

    private void stopConnectionListener() {
        TimerTask timerTask = this.checkConnectionTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.checkConnectionTimerTask = null;
        }
        Timer timer = this.connectionTimer;
        if (timer != null) {
            timer.cancel();
            this.connectionTimer = null;
        }
    }

    private void startConnectionListener() {
        this.checkConnectionTimerTask = new CheckConnectionTimerTask(this.connectionStatusTV);
        Timer timer = new Timer(true);
        this.connectionTimer = timer;
        timer.scheduleAtFixedRate(this.checkConnectionTimerTask, 500, 2500);
    }

    static class CheckConnectionTimerTask extends TimerTask {
        TextView connectionTV;

        public CheckConnectionTimerTask(TextView textView) {
            this.connectionTV = textView;
        }

        public void run() {
            MapView.getMapView().post(new Runnable() {
                public void run() {
                    if (PaladinPayloadManager.lastStatus == 0) {
                        CheckConnectionTimerTask.this.connectionTV.setText(PaladinPayloadManager.NOT_CONNECTED);
                        CheckConnectionTimerTask.this.connectionTV.setTextColor(PaladinPayloadManager.NOT_CONNECTED_COLOR);
                        PaladinPayloadManager.connectBtn.setVisibility(0);
                    } else if (System.currentTimeMillis() - PaladinPayloadManager.lastStatus > PaladinPayloadManager.CONNECTION_TIMEOUT_MILLS) {
                        CheckConnectionTimerTask.this.connectionTV.setText(PaladinPayloadManager.NOT_CONNECTED);
                        CheckConnectionTimerTask.this.connectionTV.setTextColor(PaladinPayloadManager.NOT_CONNECTED_COLOR);
                        PaladinPayloadManager.connectBtn.setVisibility(0);
                    } else {
                        CheckConnectionTimerTask.this.connectionTV.setText(PaladinPayloadManager.CONNECTED);
                        CheckConnectionTimerTask.this.connectionTV.setTextColor(PaladinPayloadManager.CONNECTED_COLOR);
                        PaladinPayloadManager.connectBtn.setVisibility(8);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showOptions(LinkedHashMap<String, String> linkedHashMap) {
        ScrollView scrollView = new ScrollView(this.pluginContext);
        LinearLayout linearLayout = new LinearLayout(this.pluginContext);
        linearLayout.setOrientation(1);
        for (final String next : linkedHashMap.keySet()) {
            View inflate = this.inflater.inflate(C1877R.layout.payload_cmd_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(C1877R.C1878id.name_tv)).setText(linkedHashMap.get(next));
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PaladinPayloadManager.this.sendCommand(next);
                    PaladinPayloadManager.this.hubSelectDialog.dismiss();
                }
            });
            linearLayout.addView(inflate);
            this.featureViewMap.put(next, inflate);
        }
        scrollView.addView(linearLayout);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Select which command to send").setView(scrollView);
        AlertDialog create = builder.create();
        this.hubSelectDialog = create;
        create.setCancelable(true);
        this.hubSelectDialog.show();
    }

    /* access modifiers changed from: private */
    public void sendCommand(String str) {
        if (getIP().isEmpty() || getPort() == -1) {
            Toast.makeText(MapView.getMapView().getContext(), "Invalid IP or Port!", 0).show();
        } else {
            PaladinCommands.sendCommand(str, getIP(), getPort());
        }
    }

    /* access modifiers changed from: private */
    public String getIP() {
        return ((EditText) this.mainPayloadView.findViewById(C1877R.C1878id.ip_et)).getText().toString();
    }

    /* access modifiers changed from: private */
    public int getPort() {
        EditText editText = (EditText) this.mainPayloadView.findViewById(C1877R.C1878id.port_et);
        if (editText.getText().toString().isEmpty()) {
            return -1;
        }
        return Integer.parseInt(editText.getText().toString());
    }
}
