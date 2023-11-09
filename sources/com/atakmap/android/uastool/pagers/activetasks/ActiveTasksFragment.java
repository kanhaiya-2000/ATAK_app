package com.atakmap.android.uastool.pagers.activetasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;

public class ActiveTasksFragment extends TasksFragment {
    private static final String TAG = "ActiveTasksFragment";
    private String[] filterQueuePlatforms;
    private UASTask.PRIORITY[] filterQueuePriorities;
    private UASTask.STATE[] filterQueueStates;
    private UASTask.TASKTYPE[] filterQueueTaskTypes;
    private QueuedTasksAdapter queueAdapter;
    private final int queueTitleId = C1877R.string.queue_tasks;
    private TextView queueTitleView;

    public ActiveTasksFragment() {
        this.titleId = C1877R.string.active_tasks;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.active_tasks_layout, viewGroup, false);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.activetasks_layout);
        this.titleView = (TextView) this.mainView.findViewById(C1877R.C1878id.activetasks_title);
        this.filterPlatforms = null;
        if (!this.mode.equals(TasksFragment.MODE.LANDING) && this.selectedUASItem != null) {
            this.filterPlatforms = new String[]{this.selectedUASItem.getPlatformType()};
        }
        this.filterTaskTypes = null;
        this.filterPriorities = null;
        this.filterStates = new UASTask.STATE[]{UASTask.STATE.RUNNING, UASTask.STATE.PAUSED};
        this.taskAdapter = new ActiveTasksAdapter(this.pluginContext, this, this.filterPlatforms, this.filterTaskTypes, this.filterPriorities, this.filterStates);
        ((ListView) this.mainView.findViewById(C1877R.C1878id.activetasks_list)).setAdapter(this.taskAdapter);
        this.queueTitleView = (TextView) this.mainView.findViewById(C1877R.C1878id.queuetasks_title);
        this.filterQueuePlatforms = this.filterPlatforms;
        this.filterQueueTaskTypes = null;
        this.filterQueuePriorities = null;
        this.filterQueueStates = new UASTask.STATE[]{UASTask.STATE.QUEUED};
        QueuedTasksAdapter queuedTasksAdapter = new QueuedTasksAdapter(this.pluginContext, this, this.filterQueuePlatforms, this.filterQueueTaskTypes, this.filterQueuePriorities, this.filterQueueStates);
        this.queueAdapter = queuedTasksAdapter;
        ((ListView) this.mainView.findViewById(C1877R.C1878id.queuetasks_list)).setAdapter(queuedTasksAdapter);
        return this.layoutView;
    }

    /* access modifiers changed from: protected */
    public void setTitle() {
        super.setTitle();
        if (this.queueTitleView != null) {
            int i = C16181.$SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE[this.mode.ordinal()];
            if (i == 1) {
                this.queueTitleView.setText(this.titleId);
            } else if (i != 2 && i != 3) {
                TextView textView = this.queueTitleView;
                textView.setText("Unknown " + this.pluginContext.getResources().getString(this.queueTitleId));
            } else if (this.selectedUASItem != null) {
                TextView textView2 = this.queueTitleView;
                textView2.setText(this.selectedUASItem.getPlatformType() + " " + this.pluginContext.getResources().getString(this.queueTitleId));
            } else {
                TextView textView3 = this.queueTitleView;
                textView3.setText("??? " + this.pluginContext.getResources().getString(this.queueTitleId));
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.activetasks.ActiveTasksFragment$1 */
    /* synthetic */ class C16181 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.pagers.TasksFragment$MODE[] r0 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE = r0
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.LANDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OBSERVER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OPERATOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.activetasks.ActiveTasksFragment.C16181.<clinit>():void");
        }
    }

    public void refreshList(boolean z) {
        super.refreshList(z);
        QueuedTasksAdapter queuedTasksAdapter = this.queueAdapter;
        if (queuedTasksAdapter != null) {
            queuedTasksAdapter.refresh(this.filterQueuePlatforms, this.filterQueueTaskTypes, this.filterQueuePriorities, this.filterQueueStates);
        }
    }
}
