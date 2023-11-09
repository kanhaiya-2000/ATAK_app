package com.atakmap.android.uastool.pagers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;

public abstract class TasksAdapter extends ArrayAdapter<UASTask> {
    private static final String TAG = "TasksAdapter";
    protected LinearLayout expandedActions = null;
    protected ImageView expandedButton = null;
    private boolean isEnabled = true;
    protected TasksFragment myFragment;
    private UASTask.STATE[] states;

    public TasksAdapter(Context context, TasksFragment tasksFragment, ArrayList<UASTask> arrayList) {
        super(context, 0, arrayList);
        this.myFragment = tasksFragment;
        this.states = this.states;
    }

    public TasksAdapter(Context context, TasksFragment tasksFragment, String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        super(context, 0, UASTaskStore.getInstance().getTasks(strArr, tasktypeArr, priorityArr, stateArr));
        this.myFragment = tasksFragment;
        this.states = stateArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASTask uASTask = (UASTask) getItem(i);
        ((ImageView) view.findViewById(C1877R.C1878id.task_icon)).setImageDrawable(getContext().getResources().getDrawable(uASTask.getTaskTypeIcon()));
        TextView textView = (TextView) view.findViewById(C1877R.C1878id.task_name);
        textView.setText(uASTask.getName());
        int i2 = C15924.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$PRIORITY[uASTask.getPriority().ordinal()];
        if (i2 == 1) {
            textView.setTextColor(-7829368);
        } else if (i2 != 2) {
            textView.setTextColor(-1);
        } else {
            textView.setTextColor(TaskEdit.viewColor);
        }
        TextView textView2 = (TextView) view.findViewById(C1877R.C1878id.task_desc);
        textView2.setText(uASTask.getDescription());
        if (uASTask.getColor() != -1) {
            textView2.setTextColor(uASTask.getColor());
        } else {
            textView2.setTextColor(Color.argb(255, 200, 200, 200));
        }
        ImageView imageView = (ImageView) view.findViewById(C1877R.C1878id.task_state);
        imageView.setAlpha(0.5f);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                TasksAdapter tasksAdapter = TasksAdapter.this;
                tasksAdapter.showHelp("Task State", "This task in the " + uASTask.getState() + " state");
                return true;
            }
        });
        int i3 = C15924.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE[uASTask.getState().ordinal()];
        if (i3 == 1) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1877R.drawable.taskstate_running));
        } else if (i3 == 2) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1877R.drawable.taskstate_paused));
        } else if (i3 == 3) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1877R.drawable.taskstate_queued));
        } else if (i3 == 4) {
            imageView.setVisibility(4);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1877R.drawable.taskstate_stored));
        } else if (i3 != 5) {
            UASToolDropDownReceiver.toast("Unknown task state: " + uASTask.getState().name(), 0);
            String str = TAG;
            Log.w(str, "Unknown task state: " + uASTask.getState().name());
            imageView.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(C1877R.drawable.taskstate_received));
        }
        return view;
    }

    /* renamed from: com.atakmap.android.uastool.pagers.TasksAdapter$4 */
    /* synthetic */ class C15924 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$PRIORITY;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$STATE[] r0 = com.atakmap.android.uastool.tasks.UASTask.STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE = r0
                r1 = 1
                com.atakmap.android.uastool.tasks.UASTask$STATE r2 = com.atakmap.android.uastool.tasks.UASTask.STATE.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.QUEUED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.STORED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.RECEIVED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.atakmap.android.uastool.tasks.UASTask$PRIORITY[] r2 = com.atakmap.android.uastool.tasks.UASTask.PRIORITY.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$PRIORITY = r2
                com.atakmap.android.uastool.tasks.UASTask$PRIORITY r3 = com.atakmap.android.uastool.tasks.UASTask.PRIORITY.LOW     // Catch:{ NoSuchFieldError -> 0x004f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$PRIORITY     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.atakmap.android.uastool.tasks.UASTask$PRIORITY r2 = com.atakmap.android.uastool.tasks.UASTask.PRIORITY.HIGH     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.TasksAdapter.C15924.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void setOnClick(View view, final LinearLayout linearLayout, final ImageView imageView) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (linearLayout.getVisibility() == 8) {
                    if (TasksAdapter.this.expandedActions != null) {
                        TasksAdapter.this.expandedActions.setVisibility(8);
                    }
                    if (TasksAdapter.this.expandedButton != null) {
                        TasksAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                    }
                    TasksAdapter.this.expandedActions = linearLayout;
                    TasksAdapter.this.expandedButton = imageView;
                    linearLayout.setVisibility(0);
                    imageView.setImageResource(C1877R.drawable.item_open);
                } else if (linearLayout.getVisibility() == 0) {
                    linearLayout.setVisibility(8);
                    imageView.setImageResource(C1877R.drawable.item_closed);
                    TasksAdapter.this.expandedActions = null;
                    TasksAdapter.this.expandedButton = null;
                    linearLayout.setVisibility(8);
                    imageView.setImageResource(C1877R.drawable.item_closed);
                }
                TasksAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void refresh(String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        if (UASToolDropDownReceiver.getInstance() != null) {
            final String[] strArr2 = strArr;
            final UASTask.TASKTYPE[] tasktypeArr2 = tasktypeArr;
            final UASTask.PRIORITY[] priorityArr2 = priorityArr;
            final UASTask.STATE[] stateArr2 = stateArr;
            ((Activity) UASToolDropDownReceiver.getInstance().getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (TasksAdapter.this.expandedActions != null) {
                        TasksAdapter.this.expandedActions.setVisibility(8);
                    }
                    if (TasksAdapter.this.expandedButton != null) {
                        TasksAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                    }
                    TasksAdapter.this.expandedActions = null;
                    TasksAdapter.this.expandedButton = null;
                    TasksAdapter.this.setFilters(strArr2, tasktypeArr2, priorityArr2, stateArr2);
                    if (TasksAdapter.this.myFragment.tasks.size() > 1) {
                        TasksAdapter.this.myFragment.tasks.sort(TasksAdapter.this.myFragment.sortMode);
                        TasksAdapter.this.myFragment.taskAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    public void setFilters(String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        clear();
        addAll(UASTaskStore.getInstance().getTasks(strArr, tasktypeArr, priorityArr, stateArr));
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public boolean isEnabled(int i) {
        return this.isEnabled;
    }

    /* access modifiers changed from: protected */
    public void storeTask(UASTask uASTask) {
        this.myFragment.askStoreTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void dispatchTask(UASTask uASTask) {
        this.myFragment.dispatchTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void queueTask(UASTask uASTask) {
        this.myFragment.askQueueTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void runTask(UASTask uASTask) {
        this.myFragment.tryToRunTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void pauseTask(UASTask uASTask) {
        this.myFragment.changeTaskState(uASTask, UASTask.STATE.PAUSED);
    }

    /* access modifiers changed from: protected */
    public void stopTask(UASTask uASTask) {
        this.myFragment.askStopTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void viewTask(UASTask uASTask) {
        this.myFragment.viewTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void hideTask(UASTask uASTask) {
        this.myFragment.hideTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void editTask(UASTask uASTask) {
        this.myFragment.editTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void copyTask(UASTask uASTask) {
        this.myFragment.askCopyTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void deleteTask(UASTask uASTask) {
        this.myFragment.askDeleteTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void sendTask(UASTask uASTask) {
        this.myFragment.sendTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void removeTask(UASTask uASTask) {
        this.myFragment.askRemoveTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }
}
