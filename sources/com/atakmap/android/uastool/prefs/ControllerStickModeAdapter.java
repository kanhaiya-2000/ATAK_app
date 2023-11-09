package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.ControllerPreferenceFragment;

public class ControllerStickModeAdapter extends ArrayAdapter<ControllerPreferenceFragment.CONT_RCSTICK_MODE> {
    ControllerPreferenceFragment.CONT_RCSTICK_MODE currentMode;

    public ControllerStickModeAdapter(Context context, ControllerPreferenceFragment.CONT_RCSTICK_MODE cont_rcstick_mode) {
        super(context, C1877R.layout.dji_rcstick_modes, ControllerPreferenceFragment.CONT_RCSTICK_MODE.values());
        this.currentMode = cont_rcstick_mode;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final ControllerPreferenceFragment.CONT_RCSTICK_MODE cont_rcstick_mode = (ControllerPreferenceFragment.CONT_RCSTICK_MODE) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.dji_rcstick_modes, (ViewGroup) null);
        }
        ((TextView) view.findViewById(C1877R.C1878id.dji_rcstick_mode_title)).setText(cont_rcstick_mode.getModeName());
        ((ImageView) view.findViewById(C1877R.C1878id.dji_rcstick_mode_image)).setImageResource(cont_rcstick_mode.getModeDrawableId());
        final RadioButton radioButton = (RadioButton) view.findViewById(C1877R.C1878id.dji_rcstick_mode_select);
        if (cont_rcstick_mode.equals(this.currentMode)) {
            radioButton.setChecked(true);
        } else {
            radioButton.setChecked(false);
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!radioButton.isSelected()) {
                    ControllerStickModeAdapter.this.modeSelected(cont_rcstick_mode);
                    radioButton.setChecked(true);
                    ControllerStickModeAdapter.this.notifyDataSetChanged();
                }
                ControllerPreferenceFragment.hideRCStickModes();
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    public void modeSelected(ControllerPreferenceFragment.CONT_RCSTICK_MODE cont_rcstick_mode) {
        this.currentMode = cont_rcstick_mode;
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putString(ControllerPreferenceFragment.PREF_MAVLINK_RCSTICK_MODE, this.currentMode.getModeName());
        edit.apply();
    }
}
