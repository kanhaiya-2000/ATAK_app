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

public class WayHeadingEdit extends MultiEdit {
    private TextView headTitle;
    private String heading;
    private ArrayAdapter<Object> headingAdapter;
    private PluginSpinner headingSpinner;

    public void refresh() {
    }

    public WayHeadingEdit(Context context) {
        super(context);
    }

    public WayHeadingEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WayHeadingEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(String str, boolean z) {
        super.init(z);
        this.heading = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.headTitle = (TextView) findViewById(C1877R.C1878id.wayedit_heading_title);
        this.headingSpinner = findViewById(C1877R.C1878id.wayedit_heading_value);
        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, getResources().getStringArray(C1877R.array.waypoint_headings));
        this.headingAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.headingSpinner.setAdapter(this.headingAdapter);
        this.headingSpinner.setSelection(this.headingAdapter.getPosition(this.heading));
        this.headingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                WayHeadingEdit.this.headingChanged();
            }
        });
        this.headingSpinner.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("WayPoint Heading", "Specify the heading of the aircraft as it moves to this waypoint.");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.wayedit_select_heading), (CheckBox) findViewById(C1877R.C1878id.wayedit_select_heading_check));
    }

    /* access modifiers changed from: private */
    public void headingChanged() {
        this.heading = (String) this.headingSpinner.getSelectedItem();
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public void disable(boolean z) {
        if (z) {
            this.headTitle.setTextColor(-7829368);
        } else {
            this.headTitle.setTextColor(-1);
        }
        this.headingSpinner.setEnabled(!z);
    }
}
