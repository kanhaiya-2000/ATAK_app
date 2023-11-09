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

public class ActiveTasksAdapter extends TasksAdapter {
    private static final String TAG = TasksAdapter.class.getSimpleName();

    public ActiveTasksAdapter(Context context, ActiveTasksFragment activeTasksFragment, String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        super(context, activeTasksFragment, strArr, tasktypeArr, priorityArr, stateArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASTask uASTask = (UASTask) getItem(i);
        int i2 = 0;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.active_task_layout, viewGroup, false);
        }
        View view2 = super.getView(i, view, viewGroup);
        ((LinearLayout) view2.findViewById(C1877R.C1878id.activetask_actions)).setVisibility(0);
        ((ImageView) view2.findViewById(C1877R.C1878id.task_expand)).setImageResource(C1877R.drawable.item_open);
        ImageButton imageButton = (ImageButton) view2.findViewById(C1877R.C1878id.activetask_run_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActiveTasksAdapter.this.runTask(uASTask);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ActiveTasksAdapter.this.showHelp("Run Task", "Runs this task");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) view2.findViewById(C1877R.C1878id.activetask_pause_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActiveTasksAdapter.this.pauseTask(uASTask);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ActiveTasksAdapter.this.showHelp("Pause Task", "Pauses this running task");
                return true;
            }
        });
        ImageButton imageButton3 = (ImageButton) view2.findViewById(C1877R.C1878id.activetask_stop_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActiveTasksAdapter.this.stopTask(uASTask);
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                ActiveTasksAdapter.this.showHelp("Stop Task", "Stops running this task");
                return true;
            }
        });
        int i3 = C16177.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE[uASTask.getState().ordinal()];
        if (i3 == 1) {
            imageButton.setEnabled(false);
            imageButton2.setEnabled(true);
            imageButton3.setEnabled(true);
            if (uASTask.getTaskType() == UASTask.TASKTYPE.LTCLC_REMOTE) {
                i2 = 4;
            }
            imageButton2.setVisibility(i2);
            imageButton.setVisibility(i2);
        } else if (i3 != 2) {
            imageButton.setEnabled(false);
            imageButton2.setEnabled(false);
            imageButton3.setEnabled(false);
        } else {
            imageButton.setEnabled(true);
            imageButton2.setEnabled(false);
            imageButton3.setEnabled(true);
        }
        return view2;
    }

    /* renamed from: com.atakmap.android.uastool.pagers.activetasks.ActiveTasksAdapter$7 */
    /* synthetic */ class C16177 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$STATE[] r0 = com.atakmap.android.uastool.tasks.UASTask.STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE = r0
                com.atakmap.android.uastool.tasks.UASTask$STATE r1 = com.atakmap.android.uastool.tasks.UASTask.STATE.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$STATE r1 = com.atakmap.android.uastool.tasks.UASTask.STATE.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.activetasks.ActiveTasksAdapter.C16177.<clinit>():void");
        }
    }
}
