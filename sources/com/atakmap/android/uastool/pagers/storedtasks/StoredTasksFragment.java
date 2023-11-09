package com.atakmap.android.uastool.pagers.storedtasks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.Iterator;

public class StoredTasksFragment extends TasksFragment {
    private static final String TAG = "StoredTasksFragment";
    protected ImageButton sortButton;

    public StoredTasksFragment() {
        this.titleId = C1877R.string.stored_tasks;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.stored_tasks_layout, viewGroup, false);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.storedtasks_layout);
        ImageButton imageButton = (ImageButton) this.mainView.findViewById(C1877R.C1878id.storedtasks_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                String str2 = "None Selected";
                if (StoredTasksFragment.this.selectedUASItem != null) {
                    str = StoredTasksFragment.this.selectedUASItem.getPlatformType();
                } else {
                    str = UASToolDropDownReceiver.getSharedPrefs().getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                StoredTasksFragment.this.addNewTask(str2);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksFragment.this.showHelp("Add Task", "Adds a new task to the Stored Tasks");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) this.mainView.findViewById(C1877R.C1878id.storedtasks_sort);
        this.sortButton = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksFragment.this.toggleSort();
            }
        });
        this.sortButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksFragment.this.showHelp("Sort Tasks", "Sorts the task list based on user selected parameters." + "\n\n Alphabetical Sort - Task names are sorted in alphabetical order" + "\n\n Distance Sort - Tasks are sorted by distance from self marker to first waypoint" + "\n\n Time Sort - Most recently modified tasks are shown first");
                return true;
            }
        });
        setUpSortButton();
        ImageButton imageButton3 = (ImageButton) this.mainView.findViewById(C1877R.C1878id.storedtasks_delete_all);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksFragment.this.askDeleteAllStoredTasks();
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksFragment.this.showHelp("Delete All Tasks", "Deletes all Stored Tasks");
                return true;
            }
        });
        this.titleView = (TextView) this.mainView.findViewById(C1877R.C1878id.storedtasks_title);
        this.filterPlatforms = null;
        if (!this.mode.equals(TasksFragment.MODE.LANDING) && this.selectedUASItem != null) {
            this.filterPlatforms = new String[]{this.selectedUASItem.getPlatformType()};
        }
        this.filterTaskTypes = new UASTask.TASKTYPE[]{UASTask.TASKTYPE.ROUTE, UASTask.TASKTYPE.SURVEY};
        this.filterPriorities = null;
        this.filterStates = new UASTask.STATE[]{UASTask.STATE.STORED, UASTask.STATE.QUEUED, UASTask.STATE.RUNNING, UASTask.STATE.PAUSED};
        this.tasks = new TasksArrayList(UASTaskStore.getInstance().getTasks(this.filterPlatforms, this.filterTaskTypes, this.filterPriorities, this.filterStates), this.sortMode);
        this.taskAdapter = new StoredTasksAdapter(this.pluginContext, this, this.tasks);
        ((ListView) this.mainView.findViewById(C1877R.C1878id.storedtasks_list)).setAdapter(this.taskAdapter);
        return this.layoutView;
    }

    public void askDeleteAllStoredTasks() {
        new AlertDialog.Builder(getActivity()).setTitle("Delete All Stored Tasks").setMessage("Are you sure you want to delete all stored tasks?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                StoredTasksFragment.this.deleteAllStoredTasks();
                StoredTasksFragment.this.refreshList(false);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deleteAllStoredTasks() {
        int count = this.taskAdapter.getCount();
        while (true) {
            count--;
            if (count > -1) {
                deleteTask((UASTask) this.taskAdapter.getItem(count));
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void toggleSort() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit();
        int i = C17478.f8403xb8b7226c[this.sortMode.ordinal()];
        if (i == 1) {
            GeoPoint C = MapView.getMapView().getSelfMarker().C();
            if (C == null || C.equals(GeoPoint.ZERO_POINT)) {
                Toast.makeText(MapView.getMapView().getContext(), "No self marker available to sort stored tasks by distance", 0).show();
                this.sortMode = TasksFragment.SORT_MODE.MODIFIED;
                edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT, "MODIFIED");
                this.sortButton.setImageResource(C1877R.drawable.action_sort_time);
            } else {
                this.sortMode = TasksFragment.SORT_MODE.DISTANCE;
                edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT, "DISTANCE");
                this.sortButton.setImageResource(C1877R.drawable.action_sort_prox);
            }
        } else if (i == 2) {
            this.sortMode = TasksFragment.SORT_MODE.MODIFIED;
            edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT, "MODIFIED");
            this.sortButton.setImageResource(C1877R.drawable.action_sort_time);
        } else if (i == 3) {
            this.sortMode = TasksFragment.SORT_MODE.NAME;
            edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT, UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT);
            this.sortButton.setImageResource(C1877R.drawable.action_sort);
        }
        edit.apply();
        if (this.tasks.size() > 1) {
            this.tasks.sort(this.sortMode);
            this.taskAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment$8 */
    /* synthetic */ class C17478 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$SORT_MODE */
        static final /* synthetic */ int[] f8403xb8b7226c;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE[] r0 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8403xb8b7226c = r0
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8403xb8b7226c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.DISTANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8403xb8b7226c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.MODIFIED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment.C17478.<clinit>():void");
        }
    }

    private void setUpSortButton() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT, UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT);
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case 2388619:
                if (string.equals(UASToolPreferenceFragment.PREF_DEFAULT_TASK_SORT)) {
                    c = 0;
                    break;
                }
                break;
            case 167113417:
                if (string.equals("MODIFIED")) {
                    c = 1;
                    break;
                }
                break;
            case 1071086581:
                if (string.equals("DISTANCE")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.sortMode = TasksFragment.SORT_MODE.NAME;
                this.sortButton.setImageResource(C1877R.drawable.action_sort);
                break;
            case 1:
                this.sortMode = TasksFragment.SORT_MODE.MODIFIED;
                this.sortButton.setImageResource(C1877R.drawable.action_sort_time);
                break;
            case 2:
                GeoPoint C = MapView.getMapView().getSelfMarker().C();
                if (C != null && !C.equals(GeoPoint.ZERO_POINT)) {
                    this.sortMode = TasksFragment.SORT_MODE.DISTANCE;
                    this.sortButton.setImageResource(C1877R.drawable.action_sort_prox);
                    break;
                } else {
                    Toast.makeText(MapView.getMapView().getContext(), "No self marker available to sort stored tasks by distance", 0).show();
                    this.sortButton.setImageResource(C1877R.drawable.action_sort);
                    this.sortMode = TasksFragment.SORT_MODE.NAME;
                    break;
                }
                break;
            default:
                this.sortButton.setImageResource(C1877R.drawable.action_sort);
                this.sortMode = TasksFragment.SORT_MODE.NAME;
                break;
        }
        if (this.tasks.size() > 1) {
            this.tasks.sort(this.sortMode);
            this.taskAdapter.notifyDataSetChanged();
        }
    }

    public void hideOverlays() {
        Iterator<UASTask> it = UASTaskStore.getInstance().getTasks(this.filterPlatforms, this.filterTaskTypes, this.filterPriorities, this.filterStates).iterator();
        while (it.hasNext()) {
            it.next().hide();
        }
    }

    public boolean onBackPressed() {
        if (isHidden()) {
            return false;
        }
        return super.onBackPressed();
    }
}
