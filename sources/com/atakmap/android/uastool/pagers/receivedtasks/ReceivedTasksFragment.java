package com.atakmap.android.uastool.pagers.receivedtasks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;

public class ReceivedTasksFragment extends TasksFragment {
    private static final String TAG = "ReceivedTasksFragment";

    public ReceivedTasksFragment() {
        this.titleId = C1877R.string.received_tasks;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.received_tasks_layout, viewGroup, false);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.receivedtasks_layout);
        ImageButton imageButton = (ImageButton) this.mainView.findViewById(C1877R.C1878id.receivedtasks_delete_all);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReceivedTasksFragment.this.askDeleteAllReceivedTasks();
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksFragment.this.showHelp("Delete All Tasks", "Deletes all Received Tasks");
                return true;
            }
        });
        this.titleView = (TextView) this.mainView.findViewById(C1877R.C1878id.receivedtasks_title);
        this.filterPlatforms = null;
        if (!this.mode.equals(TasksFragment.MODE.LANDING) && this.selectedUASItem != null) {
            this.filterPlatforms = new String[]{this.selectedUASItem.getPlatformType()};
        }
        this.filterTaskTypes = null;
        this.filterPriorities = null;
        this.filterStates = new UASTask.STATE[]{UASTask.STATE.RECEIVED};
        this.taskAdapter = new ReceivedTasksAdapter(this.pluginContext, this, this.filterPlatforms, this.filterTaskTypes, this.filterPriorities, this.filterStates);
        ((ListView) this.mainView.findViewById(C1877R.C1878id.receivedtasks_list)).setAdapter(this.taskAdapter);
        return this.layoutView;
    }

    public void askDeleteAllReceivedTasks() {
        new AlertDialog.Builder(getActivity()).setTitle("Delete All ReceivedTasks").setMessage("Are you sure you want to delete all received tasks?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ReceivedTasksFragment.this.deleteAllReceivedTasks();
                ReceivedTasksFragment.this.refreshList(false);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deleteAllReceivedTasks() {
        for (int i = 0; i < this.taskAdapter.getCount(); i++) {
            deleteTask((UASTask) this.taskAdapter.getItem(i));
        }
    }
}
