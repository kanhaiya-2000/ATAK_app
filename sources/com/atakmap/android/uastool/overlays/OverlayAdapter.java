package com.atakmap.android.uastool.overlays;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.ArrayList;

class OverlayAdapter extends ArrayAdapter<OverlayOption> {
    private final Context context;
    private final ArrayList<OverlayOption> overlayItems;

    OverlayAdapter(Context context2, ArrayList<OverlayOption> arrayList) {
        super(context2, C1877R.layout.overlay_row, arrayList);
        this.context = context2;
        this.overlayItems = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.context).inflate(C1877R.layout.overlay_row, viewGroup, false);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(C1877R.C1878id.checkBoxOverlay);
        checkBox.setText(this.overlayItems.get(i).getName());
        checkBox.setChecked(this.overlayItems.get(i).getValue());
        final OverlayOption overlayOption = this.overlayItems.get(i);
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit();
                edit.putBoolean(OverlayScreen.getOptionName((String) checkBox.getText()), checkBox.isChecked());
                edit.apply();
                overlayOption.setValue(checkBox.isChecked());
            }
        });
        return inflate;
    }
}
