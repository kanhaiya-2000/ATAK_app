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

public class OrbitHeadingEdit extends MultiEdit {
    private TextView headTitle;
    private String heading;
    private ArrayAdapter<Object> headingAdapter;
    private PluginSpinner headingSpinner;

    public void refresh() {
    }

    public OrbitHeadingEdit(Context context) {
        super(context);
    }

    public OrbitHeadingEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitHeadingEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(String str, boolean z) {
        super.init(z);
        this.heading = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.headTitle = (TextView) findViewById(C1877R.C1878id.orbitedit_heading_title);
        this.headingSpinner = findViewById(C1877R.C1878id.orbitedit_heading_value);
        ArrayAdapter<Object> arrayAdapter = new ArrayAdapter<>(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, getResources().getStringArray(C1877R.array.orbitpoint_headings));
        this.headingAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.headingSpinner.setAdapter(this.headingAdapter);
        this.headingSpinner.setSelection(this.headingAdapter.getPosition(this.heading));
        this.headingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                OrbitHeadingEdit.this.headingChanged();
            }
        });
        this.headingSpinner.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("OrbitPoint Heading", "Specify the heading of the aircraft as it moves around this orbitpoint.");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.orbitedit_select_heading), (CheckBox) findViewById(C1877R.C1878id.orbitedit_select_heading_check));
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
