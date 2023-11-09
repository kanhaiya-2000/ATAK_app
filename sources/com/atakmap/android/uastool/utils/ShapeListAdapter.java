package com.atakmap.android.uastool.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.atakmap.android.drawing.mapItems.b;
import com.atakmap.android.drawing.mapItems.c;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.bb;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.List;

public class ShapeListAdapter extends ArrayAdapter<ai> {
    private static final String TAG = "ShapeListAdapter";

    public ShapeListAdapter(Context context, List<ai> list) {
        super(context, 0, list);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.shape_list_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C1877R.C1878id.shapeName);
        ImageButton imageButton = (ImageButton) view.findViewById(C1877R.C1878id.centerOn);
        if (getItem(i) == null) {
            if (getCount() > 1) {
                textView.setText("Select a shape...");
            } else {
                textView.setText("No shapes found.");
            }
            imageButton.setVisibility(8);
            return view;
        }
        if ((getItem(i) instanceof c) || (getItem(i) instanceof b)) {
            bb bbVar = (bb) getItem(i);
            textView.setText(bbVar.getTitle());
            imageButton.setOnClickListener(new View.OnClickListener(bbVar) {
                public final /* synthetic */ bb f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    MapView.getMapView().getMapController().panTo(this.f$0.getCenter().get(), true);
                }
            });
        }
        return view;
    }
}
