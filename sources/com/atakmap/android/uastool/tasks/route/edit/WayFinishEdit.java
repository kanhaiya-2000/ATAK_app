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
import com.atakmap.android.uastool.tasks.route.UASPoint;

public class WayFinishEdit extends MultiEdit {
    private ArrayAdapter<UASPoint.FINISH_ACTION> finishAdapter;
    private UASPoint.FINISH_ACTION finishMode;
    private PluginSpinner finishSpinner;
    private TextView finishTitle;

    public void refresh() {
    }

    public WayFinishEdit(Context context) {
        super(context);
    }

    public WayFinishEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WayFinishEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(UASPoint.FINISH_ACTION finish_action, boolean z) {
        super.init(z);
        this.finishMode = finish_action;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.finishTitle = (TextView) findViewById(C1877R.C1878id.wayedit_finish_title);
        this.finishSpinner = findViewById(C1877R.C1878id.wayedit_finish_value);
        ArrayAdapter<UASPoint.FINISH_ACTION> arrayAdapter = new ArrayAdapter<>(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, UASPoint.FINISH_ACTION.values());
        this.finishAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.finishSpinner.setAdapter(this.finishAdapter);
        this.finishSpinner.setSelection(this.finishAdapter.getPosition(this.finishMode));
        this.finishSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                WayFinishEdit.this.finishChanged();
            }
        });
        this.finishSpinner.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("WayPoint Finish Action", "Specify what action the aircraft performs after finishing this waypoint.");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.wayedit_select_finish), (CheckBox) findViewById(C1877R.C1878id.wayedit_select_finish_check));
    }

    /* access modifiers changed from: private */
    public void finishChanged() {
        this.finishMode = UASPoint.FINISH_ACTION.fromCotValue(this.finishSpinner.getSelectedItem().toString());
    }

    public UASPoint.FINISH_ACTION getFinish() {
        return this.finishMode;
    }

    public void setFinish(UASPoint.FINISH_ACTION finish_action) {
        this.finishMode = finish_action;
    }

    public void disable(boolean z) {
        if (z) {
            this.finishTitle.setTextColor(-7829368);
        } else {
            this.finishTitle.setTextColor(-1);
        }
        this.finishSpinner.setEnabled(!z);
    }
}
