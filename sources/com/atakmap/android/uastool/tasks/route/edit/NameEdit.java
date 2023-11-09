package com.atakmap.android.uastool.tasks.route.edit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class NameEdit extends MultiEdit {
    private String name;
    private Button nameButton;

    public void refresh() {
    }

    public NameEdit(Context context) {
        super(context);
    }

    public NameEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NameEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(String str, boolean z) {
        super.init(z);
        this.name = str;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Button button = (Button) findViewById(C1877R.C1878id.pointedit_name);
        this.nameButton = button;
        button.setText(this.name);
        this.nameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NameEdit.this.askEditName();
            }
        });
        this.nameButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Edit Name", "Edits the name of this point");
                return true;
            }
        });
        setUpMulti((RelativeLayout) findViewById(C1877R.C1878id.pointedit_select_name), (CheckBox) findViewById(C1877R.C1878id.pointedit_select_name_check));
    }

    /* access modifiers changed from: private */
    public void askEditName() {
        final EditText editText = new EditText(MapView.getMapView().getContext());
        editText.setText(this.name);
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Edit Name").setMessage("Enter the name for this point").setView(editText).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                NameEdit.this.editName(editText.getText().toString());
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void editName(String str) {
        this.name = str;
        this.nameButton.setText(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void disable(boolean z) {
        this.nameButton.setEnabled(!z);
    }
}
