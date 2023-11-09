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

public class WayGotoEdit extends MultiEdit {
    private ArrayAdapter<Object> gotoAdapter;
    private String gotoMode;
    private PluginSpinner gotoSpinner;
    private TextView gotoTitle;

    public void refresh() {
    }

    public WayGotoEdit(Context context) {
        super(context);
    }

    public WayGotoEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WayGotoEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(String str, boolean z) {
        super.init(z);
        this.gotoMode = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gotoTitle = (TextView) findViewById(C1877R.C1878id.wayedit_goto_title);
        this.gotoSpinner = findViewById(C1877R.C1878id.wayedit_goto_value);
        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, getResources().getStringArray(C1877R.array.waypoint_gotomodes));
        this.gotoAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.gotoSpinner.setAdapter(this.gotoAdapter);
        this.gotoSpinner.setSelection(this.gotoAdapter.getPosition(this.gotoMode));
        this.gotoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                WayGotoEdit.this.gotoModeChanged();
            }
        });
        this.gotoSpinner.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("WayPoint Goto Mode", "Specify how the aircraft adjusts its elevation as it moves to this waypoint.");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.wayedit_select_goto), (CheckBox) findViewById(C1877R.C1878id.wayedit_select_goto_check));
    }

    /* access modifiers changed from: private */
    public void gotoModeChanged() {
        this.gotoMode = (String) this.gotoSpinner.getSelectedItem();
    }

    public String getGotoMode() {
        return this.gotoMode;
    }

    public void setGotoMode(String str) {
        this.gotoMode = str;
    }

    public void disable(boolean z) {
        if (z) {
            this.gotoTitle.setTextColor(-7829368);
        } else {
            this.gotoTitle.setTextColor(-1);
        }
        this.gotoSpinner.setEnabled(!z);
    }
}
