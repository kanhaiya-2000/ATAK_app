package com.atakmap.android.uastool.tasks;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import atak.core.rd;
import com.atakmap.android.gui.ColorPicker;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.TasksFragment;

public abstract class TaskEdit extends UASToolScreen {
    private static final String TAG = "TaskEdit";
    public static final int viewColor = -16711936;
    protected TasksFragment myTaskFragment;
    protected UASTask uasTask;

    /* access modifiers changed from: protected */
    public abstract boolean onBackButton();

    /* access modifiers changed from: protected */
    public void setNewColor(int i) {
    }

    public TaskEdit(Context context) {
        super(context);
    }

    public TaskEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(TasksFragment tasksFragment, UASItem uASItem, UASTask uASTask) {
        super.init(uASItem, tasksFragment);
        this.myTaskFragment = tasksFragment;
        this.uasTask = uASTask;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    return TaskEdit.this.onBackButton();
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void changeColor() {
        final ColorPicker colorPicker = new ColorPicker(MapView.getMapView().getContext(), this.uasTask.getColor());
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Set Task Color").setMessage("Move the sliders to choose a color").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TaskEdit.this.setNewColor(colorPicker.getColor());
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        negativeButton.setView(colorPicker);
        negativeButton.create().show();
    }

    /* access modifiers changed from: protected */
    public void saveTask(UASTask uASTask) {
        UASTaskStore.getInstance().saveTask(uASTask);
        this.myTaskFragment.refreshList(false);
    }

    /* access modifiers changed from: protected */
    public void save() {
        rd.a().d();
        this.myParentFragment.removeCurrentScreen();
        this.myTaskFragment.refreshList(false);
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        rd.a().d();
        this.myParentFragment.removeCurrentScreen();
        this.myTaskFragment.refreshList(false);
    }

    /* access modifiers changed from: protected */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }
}
