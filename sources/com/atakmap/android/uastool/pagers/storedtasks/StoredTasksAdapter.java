package com.atakmap.android.uastool.pagers.storedtasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksAdapter;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;

public class StoredTasksAdapter extends TasksAdapter {
    private static final String TAG = TasksAdapter.class.getSimpleName();

    public StoredTasksAdapter(Context context, StoredTasksFragment storedTasksFragment, ArrayList<UASTask> arrayList) {
        super(context, storedTasksFragment, arrayList);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASTask uASTask = (UASTask) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.stored_task_layout, viewGroup, false);
        }
        View view2 = super.getView(i, view, viewGroup);
        final ImageView imageView = (ImageView) view2.findViewById(C1877R.C1878id.task_icon);
        if (uASTask.isViewing()) {
            imageView.setImageResource(C1877R.drawable.overlay_visible);
        } else {
            imageView.setImageResource(C1877R.drawable.overlay_not_visible);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (uASTask.isViewing()) {
                    uASTask.hide();
                    imageView.setImageResource(C1877R.drawable.overlay_not_visible);
                    return;
                }
                uASTask.view((UASPoint) null, false);
                imageView.setImageResource(C1877R.drawable.overlay_visible);
            }
        });
        setOnClick(view2, (LinearLayout) view2.findViewById(C1877R.C1878id.storedtask_actions), (ImageView) view2.findViewById(C1877R.C1878id.task_expand), imageView, uASTask);
        ImageButton imageButton = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_dispatch_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.dispatchTask(uASTask);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Dispatch Task", "Sends this task to the operator of the UAS");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_queue_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.queueTask(uASTask);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Queue Task", "Adds this task to the queue");
                return true;
            }
        });
        ImageButton imageButton3 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_run_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.runTask(uASTask);
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Run Task", "Runs this task");
                return true;
            }
        });
        ImageButton imageButton4 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_pause_button);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.pauseTask(uASTask);
            }
        });
        imageButton4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Pause Task", "Pauses this running task");
                return true;
            }
        });
        ImageButton imageButton5 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_stop_button);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.stopTask(uASTask);
            }
        });
        imageButton5.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Stop Task", "Stops running this task");
                return true;
            }
        });
        ImageButton imageButton6 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_remove_button);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.removeTask(uASTask);
            }
        });
        imageButton6.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Remove Task", "Removes this task from the queue. Task remains Stored on device");
                return true;
            }
        });
        ImageButton imageButton7 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_edit_button);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.editTask(uASTask);
            }
        });
        imageButton7.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Edit Task", "Edit this task");
                return true;
            }
        });
        ImageButton imageButton8 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_copy_button);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.copyTask(uASTask);
            }
        });
        imageButton8.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Copy Task", "Copies this task into a new task");
                return true;
            }
        });
        ImageButton imageButton9 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_delete_button);
        imageButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.deleteTask(uASTask);
            }
        });
        imageButton9.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Delete Task", "Deletes this task permanently");
                return true;
            }
        });
        ImageButton imageButton10 = (ImageButton) view2.findViewById(C1877R.C1878id.storedtask_send_button);
        imageButton10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StoredTasksAdapter.this.sendTask(uASTask);
            }
        });
        imageButton10.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StoredTasksAdapter.this.showHelp("Send Task", "Send this task to another user");
                return true;
            }
        });
        imageButton.setVisibility(8);
        imageButton2.setVisibility(8);
        imageButton3.setVisibility(8);
        imageButton4.setVisibility(8);
        imageButton5.setVisibility(8);
        imageButton6.setVisibility(8);
        imageButton10.setVisibility(0);
        imageButton7.setVisibility(0);
        imageButton8.setVisibility(0);
        imageButton9.setVisibility(0);
        if (uASTask.getState().equals(UASTask.STATE.RUNNING) || uASTask.getState().equals(UASTask.STATE.PAUSED)) {
            imageButton7.setEnabled(false);
            imageButton9.setEnabled(false);
        } else {
            imageButton7.setEnabled(true);
            imageButton9.setEnabled(true);
        }
        int i2 = C173223.$SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE[this.myFragment.getMode().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                imageButton2.setVisibility(0);
                if (uASTask.getState().equals(UASTask.STATE.RUNNING) || uASTask.getState().equals(UASTask.STATE.PAUSED) || uASTask.getState().equals(UASTask.STATE.QUEUED)) {
                    imageButton2.setEnabled(false);
                } else {
                    imageButton2.setEnabled(true);
                }
            } else if (i2 != 3) {
                UASToolDropDownReceiver.toast("Unknown Stored Tasks mode: " + this.myFragment.getMode().name(), 0);
                String str = TAG;
                Log.w(str, "Unknown Stored Tasks mode: " + this.myFragment.getMode().name());
                imageButton.setVisibility(8);
                imageButton2.setVisibility(8);
                imageButton10.setVisibility(0);
            } else {
                imageButton.setVisibility(0);
                imageButton10.setVisibility(8);
            }
        }
        return view2;
    }

    /* renamed from: com.atakmap.android.uastool.pagers.storedtasks.StoredTasksAdapter$23 */
    /* synthetic */ class C173223 {
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
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OPERATOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OBSERVER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.storedtasks.StoredTasksAdapter.C173223.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void setOnClick(View view, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, UASTask uASTask) {
        final ImageView imageView3 = imageView2;
        final LinearLayout linearLayout2 = linearLayout;
        final ImageView imageView4 = imageView;
        final UASTask uASTask2 = uASTask;
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!view.equals(imageView3)) {
                    if (linearLayout2.getVisibility() == 8) {
                        if (StoredTasksAdapter.this.expandedActions != null) {
                            StoredTasksAdapter.this.expandedActions.setVisibility(8);
                        }
                        if (StoredTasksAdapter.this.expandedButton != null) {
                            StoredTasksAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                        }
                        LinearLayout unused = StoredTasksAdapter.this.expandedActions = linearLayout2;
                        ImageView unused2 = StoredTasksAdapter.this.expandedButton = imageView4;
                        linearLayout2.setVisibility(0);
                        imageView4.setImageResource(C1877R.drawable.item_open);
                        if (!uASTask2.isViewing()) {
                            uASTask2.view((UASPoint) null, false);
                            UASTask uASTask = uASTask2;
                            if (uASTask instanceof RouteTask) {
                                ((RouteTask) uASTask).panTo();
                            }
                            imageView3.setImageResource(C1877R.drawable.overlay_visible);
                        }
                    } else if (linearLayout2.getVisibility() == 0) {
                        linearLayout2.setVisibility(8);
                        imageView4.setImageResource(C1877R.drawable.item_closed);
                        LinearLayout unused3 = StoredTasksAdapter.this.expandedActions = null;
                        ImageView unused4 = StoredTasksAdapter.this.expandedButton = null;
                        linearLayout2.setVisibility(8);
                        imageView4.setImageResource(C1877R.drawable.item_closed);
                    }
                    UASTask uASTask2 = uASTask2;
                    if (uASTask2 instanceof RouteTask) {
                        ((RouteTask) uASTask2).panTo();
                    }
                    StoredTasksAdapter.this.notifyDataSetChanged();
                }
            }
        });
    }
}
