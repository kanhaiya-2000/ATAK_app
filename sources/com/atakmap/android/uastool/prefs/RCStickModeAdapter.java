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
import com.atakmap.android.uastool.prefs.DJIPreferenceFragment;

public class RCStickModeAdapter extends ArrayAdapter<DJIPreferenceFragment.DJI_RCSTICK_MODE> {
    DJIPreferenceFragment.DJI_RCSTICK_MODE currentMode;

    public RCStickModeAdapter(Context context, DJIPreferenceFragment.DJI_RCSTICK_MODE dji_rcstick_mode) {
        super(context, C1877R.layout.dji_rcstick_modes, DJIPreferenceFragment.DJI_RCSTICK_MODE.values());
        this.currentMode = dji_rcstick_mode;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final DJIPreferenceFragment.DJI_RCSTICK_MODE dji_rcstick_mode = (DJIPreferenceFragment.DJI_RCSTICK_MODE) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.dji_rcstick_modes, (ViewGroup) null);
        }
        ((TextView) view.findViewById(C1877R.C1878id.dji_rcstick_mode_title)).setText(dji_rcstick_mode.getModeName());
        ((ImageView) view.findViewById(C1877R.C1878id.dji_rcstick_mode_image)).setImageResource(dji_rcstick_mode.getModeDrawableId());
        final RadioButton radioButton = (RadioButton) view.findViewById(C1877R.C1878id.dji_rcstick_mode_select);
        if (dji_rcstick_mode.equals(this.currentMode)) {
            radioButton.setChecked(true);
        } else {
            radioButton.setChecked(false);
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!radioButton.isSelected()) {
                    RCStickModeAdapter.this.modeSelected(dji_rcstick_mode);
                    radioButton.setChecked(true);
                    RCStickModeAdapter.this.notifyDataSetChanged();
                }
                DJIPreferenceFragment.hideRCStickModes();
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    public void modeSelected(DJIPreferenceFragment.DJI_RCSTICK_MODE dji_rcstick_mode) {
        this.currentMode = dji_rcstick_mode;
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putString(DJIPreferenceFragment.DJIPREF_RCSTICK_MODE, this.currentMode.getModeName());
        edit.apply();
    }
}
