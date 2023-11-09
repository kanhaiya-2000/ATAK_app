package com.atakmap.android.uastool.pagers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;

public class ActionButton {
    private boolean _enabled = true;
    private final ImageView _icon;
    private final View _root;
    private final TextView _selectedText;
    private final TextView _title;

    public ActionButton(View view) {
        this._root = view;
        TextView textView = (TextView) view.findViewById(C1877R.C1878id.selector_title);
        this._title = textView;
        textView.setVisibility(8);
        this._selectedText = (TextView) view.findViewById(C1877R.C1878id.selector_item);
        this._icon = (ImageView) view.findViewById(C1877R.C1878id.selector_icon);
    }

    public void setVisibility(int i) {
        this._root.setVisibility(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this._root.setOnClickListener(onClickListener);
        this._selectedText.setOnClickListener(onClickListener);
        this._icon.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this._title.setText(str);
    }

    public void setTitleVisible(boolean z) {
        if (z) {
            this._title.setVisibility(0);
        } else {
            this._title.setVisibility(8);
        }
    }

    public void setText(String str) {
        this._selectedText.setText(str);
    }

    public void setTextColor(int i) {
        this._selectedText.setTextColor(i);
    }

    public String getText() {
        return this._selectedText.getText().toString();
    }

    public String getTitle() {
        return this._title.getText().toString();
    }

    public boolean isEnabled() {
        return this._enabled;
    }

    public void setEnabled(boolean z) {
        this._enabled = z;
        this._selectedText.setClickable(z);
        this._root.setClickable(z);
        this._icon.setClickable(z);
        if (this._enabled) {
            this._icon.setVisibility(0);
        } else {
            this._icon.setVisibility(4);
        }
    }
}
