package com.atakmap.android.uastool.pagers.receivedtasks;

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

public class ReceivedTasksAdapter extends TasksAdapter {
    private static final String TAG = "ReceivedTasksAdapter";

    public ReceivedTasksAdapter(Context context, ReceivedTasksFragment receivedTasksFragment, String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        super(context, receivedTasksFragment, strArr, tasktypeArr, priorityArr, stateArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASTask uASTask = (UASTask) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.received_task_layout, viewGroup, false);
        }
        View view2 = super.getView(i, view, viewGroup);
        setOnClick(view2, (LinearLayout) view2.findViewById(C1877R.C1878id.receivedtask_actions), (ImageView) view2.findViewById(C1877R.C1878id.task_expand));
        ImageButton imageButton = (ImageButton) view2.findViewById(C1877R.C1878id.receivedtask_run_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReceivedTasksAdapter.this.runTask(uASTask);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksAdapter.this.showHelp("Run Task", "Runs this task");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) view2.findViewById(C1877R.C1878id.receivedtask_store_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReceivedTasksAdapter.this.storeTask(uASTask);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksAdapter.this.showHelp("Store Task", "Saves this task and makes it a Stored Task");
                return true;
            }
        });
        ImageButton imageButton3 = (ImageButton) view2.findViewById(C1877R.C1878id.receivedtask_queue_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReceivedTasksAdapter.this.queueTask(uASTask);
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksAdapter.this.showHelp("Queue Task", "Adds this task to the queue");
                return true;
            }
        });
        ImageButton imageButton4 = (ImageButton) view2.findViewById(C1877R.C1878id.receivedtask_view_button);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (uASTask.isViewing()) {
                    ReceivedTasksAdapter.this.hideTask(uASTask);
                } else {
                    ReceivedTasksAdapter.this.viewTask(uASTask);
                }
            }
        });
        imageButton4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksAdapter.this.showHelp("View Task", "View this task");
                return true;
            }
        });
        ImageButton imageButton5 = (ImageButton) view2.findViewById(C1877R.C1878id.receivedtask_delete_button);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReceivedTasksAdapter.this.deleteTask(uASTask);
            }
        });
        imageButton5.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ReceivedTasksAdapter.this.showHelp("Delete Task", "Deletes this task permanently");
                return true;
            }
        });
        if (uASTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE)) {
            imageButton2.setVisibility(8);
            imageButton3.setVisibility(8);
            imageButton4.setVisibility(8);
            imageButton.setVisibility(0);
        } else {
            imageButton2.setVisibility(0);
            imageButton3.setVisibility(0);
            imageButton.setVisibility(8);
        }
        return view2;
    }
}
