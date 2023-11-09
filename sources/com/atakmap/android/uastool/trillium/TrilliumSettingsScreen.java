package com.atakmap.android.uastool.trillium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.mavlink.MAVLinkPrefHandler;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TrilliumSettingsScreen extends SettingsScreen {
    private static final ArrayList<String> videoFormatActionStates;
    /* access modifiers changed from: private */
    public final AtomicBoolean disableSpinnerListeners = new AtomicBoolean(false);
    private ImageButton videoDestinationButton;
    private ImageButton videoDestinationPortButton;
    private EditText videoDestinationPortText;
    private TextView videoDestinationPortValue;
    private EditText videoDestinationText;
    private TextView videoDestinationValue;
    /* access modifiers changed from: private */
    public PluginSpinner videoFormatSpinner;
    private TextView videoFormatValue;

    /* access modifiers changed from: private */
    public void getPlatformSettings() {
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        videoFormatActionStates = arrayList;
        arrayList.add(MAVLinkPrefHandler.DEFAULT_MAVLINK_NETWORK_TYPE);
        arrayList.add("RTSP");
        arrayList.add("RTP");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.trilliumsettings_refresh_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TrilliumSettingsScreen.this.getPlatformSettings();
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Refresh All", "Retrieves all current settings stored on the UAS.");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.trilliumsettings_videodestination_port_text)).setText("Video Destination Port");
        this.videoDestinationPortValue = (TextView) findViewById(C1877R.C1878id.trilliumsettings_videodestination_port_value);
        this.videoDestinationPortButton = (ImageButton) findViewById(C1877R.C1878id.trilliumsettings_videodestination_port_button);
        EditText editText = (EditText) findViewById(C1877R.C1878id.trilliumsettings_videodestination_port_edit);
        this.videoDestinationPortText = editText;
        editText.setSelectAllOnFocus(true);
        this.videoDestinationPortButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.videoDestinationPortButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Video Destination Port", "Set the Video Destination Port.");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.trilliumsettings_videodestination_text)).setText("Video Destination IP");
        this.videoDestinationValue = (TextView) findViewById(C1877R.C1878id.trilliumsettings_videodestination_value);
        this.videoDestinationButton = (ImageButton) findViewById(C1877R.C1878id.trilliumsettings_videodestination_button);
        EditText editText2 = (EditText) findViewById(C1877R.C1878id.trilliumsettings_videodestination_edit);
        this.videoDestinationText = editText2;
        editText2.setSelectAllOnFocus(true);
        this.videoDestinationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.videoDestinationButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Video Destination IP", "Set the Video Destination IP.");
                return true;
            }
        });
        this.videoFormatValue = (TextView) findViewById(C1877R.C1878id.trilliumsettings_videoformat_value);
        this.videoFormatSpinner = findViewById(C1877R.C1878id.trilliumsettings_videoformat_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, 17367048, videoFormatActionStates);
        arrayAdapter.setDropDownViewResource(17367049);
        this.videoFormatSpinner.setAdapter(arrayAdapter);
        this.videoFormatSpinner.post(new Runnable() {
            public void run() {
                TrilliumSettingsScreen.this.videoFormatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (TrilliumSettingsScreen.this.disableSpinnerListeners.get()) {
                        }
                    }
                });
            }
        });
        getPlatformSettings();
    }

    public TrilliumSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = TrilliumSettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
