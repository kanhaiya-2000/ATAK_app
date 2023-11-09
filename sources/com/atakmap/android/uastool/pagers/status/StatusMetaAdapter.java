package com.atakmap.android.uastool.pagers.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.List;

public class StatusMetaAdapter extends ArrayAdapter<StatusMetaItem> {
    private static final String TAG = "StatusMetaAdapter";

    public StatusMetaAdapter(Context context, List<StatusMetaItem> list) {
        super(context, 0, list);
    }

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    private static class ViewHolder {
        public TextView metaLabel;
        public TextView metaText;
        public ImageView selectImage;

        private ViewHolder() {
        }
    }

    /* access modifiers changed from: protected */
    public void update(List<StatusMetaItem> list) {
        if (getCount() < 1) {
            addAll(list);
            return;
        }
        for (StatusMetaItem next : list) {
            if (getExistingItem(next) != null) {
                next.setMeta(next.getMeta());
            } else {
                add(next);
            }
        }
    }

    private StatusMetaItem getExistingItem(StatusMetaItem statusMetaItem) {
        for (int i = 0; i < getCount(); i++) {
            if (((StatusMetaItem) getItem(i)).getLabel().equals(statusMetaItem.getLabel())) {
                return statusMetaItem;
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        StatusMetaItem statusMetaItem = (StatusMetaItem) getItem(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(getContext()).inflate(C1877R.layout.status_meta_item, viewGroup, false);
            viewHolder.selectImage = (ImageView) view2.findViewById(C1877R.C1878id.status_meta_select);
            viewHolder.metaLabel = (TextView) view2.findViewById(C1877R.C1878id.status_meta_label);
            viewHolder.metaText = (TextView) view2.findViewById(C1877R.C1878id.status_meta_text);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.metaLabel.setText(String.format("%s: ", new Object[]{statusMetaItem.getLabel()}));
        viewHolder.metaLabel.setTextColor(statusMetaItem.getColor());
        viewHolder.metaText.setText(statusMetaItem.getMeta());
        viewHolder.metaText.setTextColor(statusMetaItem.getColor());
        if (statusMetaItem.isError()) {
            viewHolder.selectImage.setVisibility(4);
        } else {
            viewHolder.selectImage.setVisibility(0);
            if (statusMetaItem.isSelected()) {
                viewHolder.selectImage.setImageDrawable(UASToolDropDownReceiver.getInstance().getPluginContext().getDrawable(C1877R.drawable.item_selected));
            } else {
                viewHolder.selectImage.setImageDrawable(UASToolDropDownReceiver.getInstance().getPluginContext().getDrawable(C1877R.drawable.item_unselected));
            }
        }
        return view2;
    }
}
