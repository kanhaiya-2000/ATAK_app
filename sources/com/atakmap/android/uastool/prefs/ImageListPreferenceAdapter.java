package com.atakmap.android.uastool.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.ArrayList;

public class ImageListPreferenceAdapter extends ArrayAdapter<String> {
    private int currentImageId;
    private Dialog dialog;
    private TypedArray imageIds;
    private ArrayList<String> names;
    private RadioButton selectedRadioButton;

    private static class ViewHolder {
        public ImageView imageView;
        public RadioButton radioButton;
        public TextView textView;
    }

    public ImageListPreferenceAdapter(Context context, TypedArray typedArray, int i, ArrayList<String> arrayList) {
        super(context, 0, arrayList);
        this.imageIds = typedArray;
        this.currentImageId = i;
        this.names = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        String str = this.names.get(i);
        boolean z = false;
        final int resourceId = this.imageIds.getResourceId(i, 0);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(getContext()).inflate(C1877R.layout.image_picker_row, (ViewGroup) null);
            viewHolder.imageView = (ImageView) view2.findViewById(C1877R.C1878id.image_list_pref_image);
            viewHolder.textView = (TextView) view2.findViewById(C1877R.C1878id.image_list_pref_text);
            viewHolder.radioButton = (RadioButton) view2.findViewById(C1877R.C1878id.image_list_pref_radio);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(resourceId);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageListPreferenceAdapter.this.setPref(resourceId);
            }
        });
        viewHolder.textView.setText(str);
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageListPreferenceAdapter.this.setPref(resourceId);
            }
        });
        if (resourceId == this.currentImageId) {
            this.selectedRadioButton = viewHolder.radioButton;
        }
        RadioButton radioButton = viewHolder.radioButton;
        if (resourceId == this.currentImageId) {
            z = true;
        }
        radioButton.setChecked(z);
        viewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImageListPreferenceAdapter.this.setPref(resourceId);
            }
        });
        return view2;
    }

    public void setDialog(Dialog dialog2) {
        this.dialog = dialog2;
    }

    /* access modifiers changed from: private */
    public void setPref(int i) {
        RadioButton radioButton = this.selectedRadioButton;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        UASToolDropDownReceiver.getSharedPrefs().edit().putInt(UIPreferenceFragment.PREF_RETICLE_IMAGE, i).apply();
        this.dialog.dismiss();
        this.dialog = null;
    }
}
