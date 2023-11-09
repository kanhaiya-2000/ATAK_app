package com.atakmap.android.uastool.tasks.route.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class WayFlightEdit extends MultiEdit {
    private String flightMode;
    private ArrayAdapter<Object> flightModeAdapter;
    private PluginSpinner flightModeSpinner;
    private TextView flightModeTitle;

    public void refresh() {
    }

    public WayFlightEdit(Context context) {
        super(context);
    }

    public WayFlightEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WayFlightEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(String str, boolean z) {
        super.init(z);
        this.flightMode = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.flightModeTitle = (TextView) findViewById(C1877R.C1878id.wayedit_flightmode_title);
        this.flightModeSpinner = findViewById(C1877R.C1878id.wayedit_flightmode_value);
        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, getResources().getStringArray(C1877R.array.waypoint_flightmodes));
        this.flightModeAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.flightModeSpinner.setAdapter(this.flightModeAdapter);
        this.flightModeSpinner.setSelection(this.flightModeAdapter.getPosition(this.flightMode));
        this.flightModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                WayFlightEdit.this.flightModeChanged();
            }
        });
        this.flightModeSpinner.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("WayPoint Flight Mode", "Specify the path the aircraft follows as it moves to this waypoint.");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.wayedit_select_flightmode), (CheckBox) findViewById(C1877R.C1878id.wayedit_select_flightmode_check));
    }

    /* access modifiers changed from: private */
    public void flightModeChanged() {
        this.flightMode = (String) this.flightModeSpinner.getSelectedItem();
    }

    public String getFlightMode() {
        return this.flightMode;
    }

    public void setFlightMode(String str) {
        this.flightMode = str;
    }

    public void disable(boolean z) {
        if (z) {
            this.flightModeTitle.setTextColor(-7829368);
        } else {
            this.flightModeTitle.setTextColor(-1);
        }
        this.flightModeSpinner.setEnabled(!z);
    }
}
