package com.atakmap.android.uastool.toastlog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.List;

class ToastLogAdapter extends ArrayAdapter<ToastLogItem> {
    public ToastLogAdapter(Context context, List<ToastLogItem> list) {
        super(context, 0, list);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final ToastLogItem toastLogItem = (ToastLogItem) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.toastlog_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C1877R.C1878id.toastlog_message_text);
        TextView textView2 = (TextView) view.findViewById(C1877R.C1878id.toastlog_date_text);
        if (toastLogItem != null) {
            textView.setText(toastLogItem.getMessage());
            textView2.setText(toastLogItem.getDateString());
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                    builder.setTitle(toastLogItem.getDateString());
                    builder.setMessage(toastLogItem.getMessage());
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.create().show();
                }
            });
        }
        return view;
    }
}
