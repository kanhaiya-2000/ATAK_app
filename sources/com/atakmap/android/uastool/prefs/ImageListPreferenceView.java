package com.atakmap.android.uastool.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.ListView;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.ArrayList;

public class ImageListPreferenceView extends ListView {
    private ImageListPreferenceAdapter listApdapter;
    private Context pluginContext;

    public ImageListPreferenceView(Context context, int i) {
        super(context);
        this.pluginContext = context;
        init(i);
    }

    private void init(int i) {
        TypedArray obtainTypedArray = getResources().obtainTypedArray(C1877R.array.reticle_values);
        String[] stringArray = this.pluginContext.getResources().getStringArray(C1877R.array.reticle_names);
        ArrayList arrayList = new ArrayList();
        for (String add : stringArray) {
            arrayList.add(add);
        }
        ImageListPreferenceAdapter imageListPreferenceAdapter = new ImageListPreferenceAdapter(this.pluginContext, obtainTypedArray, i, arrayList);
        this.listApdapter = imageListPreferenceAdapter;
        setAdapter(imageListPreferenceAdapter);
    }

    public void setDialog(Dialog dialog) {
        this.listApdapter.setDialog(dialog);
    }
}
