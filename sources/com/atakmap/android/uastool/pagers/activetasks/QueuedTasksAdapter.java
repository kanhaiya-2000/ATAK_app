package com.atakmap.android.uastool.pagers.activetasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.atakmap.android.uastool.pagers.TasksAdapter;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;

public class QueuedTasksAdapter extends TasksAdapter {
    private static final String TAG = "QueuedTasksAdapter";

    public QueuedTasksAdapter(Context context, ActiveTasksFragment activeTasksFragment, String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        super(context, activeTasksFragment, strArr, tasktypeArr, priorityArr, stateArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASTask uASTask = (UASTask) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.queued_task_layout, viewGroup, false);
        }
        View view2 = super.getView(i, view, viewGroup);
        setOnClick(view2, (LinearLayout) view2.findViewById(C1877R.C1878id.queuedtask_actions), (ImageView) view2.findViewById(C1877R.C1878id.task_expand));
        ImageButton imageButton = (ImageButton) view2.findViewById(C1877R.C1878id.queuedtask_run_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QueuedTasksAdapter.this.runTask(uASTask);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                QueuedTasksAdapter.this.showHelp("Run Task", "Runs this task");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) view2.findViewById(C1877R.C1878id.queuedtask_pause_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QueuedTasksAdapter.this.pauseTask(uASTask);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                QueuedTasksAdapter.this.showHelp("Pause Task", "Pauses this running task");
                return true;
            }
        });
        ImageButton imageButton3 = (ImageButton) view2.findViewById(C1877R.C1878id.queuedtask_stop_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QueuedTasksAdapter.this.stopTask(uASTask);
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                QueuedTasksAdapter.this.showHelp("Stop Task", "Stops running this task");
                return true;
            }
        });
        ImageButton imageButton4 = (ImageButton) view2.findViewById(C1877R.C1878id.queuedtask_remove_button);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QueuedTasksAdapter.this.removeTask(uASTask);
            }
        });
        imageButton4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                QueuedTasksAdapter.this.showHelp("Remove Task", "Removes this task from the queue. Task remains Stored on device");
                return true;
            }
        });
        imageButton.setEnabled(true);
        imageButton2.setEnabled(false);
        imageButton3.setEnabled(false);
        imageButton4.setEnabled(true);
        return view2;
    }
}
