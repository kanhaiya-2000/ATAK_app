package com.atakmap.android.uastool.pagers.operator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.contact.c;
import com.atakmap.android.contact.n;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.UASToolPagerAdapter;
import com.atakmap.android.uastool.pagers.activetasks.ActiveTasksFragment;
import com.atakmap.android.uastool.pagers.receivedtasks.ReceivedTasksFragment;
import com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.QuickTask;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteCancelTask;
import com.atakmap.commoncommo.CoTSendMethod;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class OperatorPager extends UASToolPager {
    private static final boolean SHOW_TASKING_PANES = true;
    public static final int START_INDEX = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "OperatorPager";
    private ActiveTasksFragment activeTaskFragment;
    /* access modifiers changed from: private */
    public int lastPageSelected = 2;
    /* access modifiers changed from: private */
    public View leftDot;
    /* access modifiers changed from: private */
    public View leftMiddleDot;
    /* access modifiers changed from: private */
    public View middleDot;
    /* access modifiers changed from: private */
    public OperatorControlFragment operatorControlFragment;
    private final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        private boolean notScrolling = true;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageScrollStateChanged(int i) {
            PreviewTextureView previewTexture;
            boolean z = true;
            int i2 = 0;
            if (i != 0) {
                z = false;
            }
            if (!(OperatorPager.this.operatorControlFragment == null || (previewTexture = OperatorPager.this.operatorControlFragment.getPreviewTexture()) == null)) {
                if (OperatorPager.this.lastPageSelected == 2) {
                    if (!z) {
                        i2 = 4;
                    }
                    previewTexture.setVisibility(i2);
                } else {
                    previewTexture.setVisibility(4);
                }
            }
            this.notScrolling = z;
        }

        public void onPageSelected(final int i) {
            PreviewTextureView previewTexture;
            int i2 = 4;
            if (i > 4) {
                String access$300 = OperatorPager.TAG;
                Log.d(access$300, "Unable to select position: " + i);
                return;
            }
            boolean z = true;
            OperatorPager.this.leftDot.setSelected(i == 0);
            OperatorPager.this.leftMiddleDot.setSelected(i == 1);
            OperatorPager.this.middleDot.setSelected(i == 2);
            View access$700 = OperatorPager.this.rightMiddleDot;
            if (i != 3) {
                z = false;
            }
            access$700.setSelected(z);
            OperatorPager.this.post(new Runnable() {
                public void run() {
                    OperatorPager.this.pagerAdapter.getItem(i).onPageSelected();
                }
            });
            int unused = OperatorPager.this.lastPageSelected = i;
            if (OperatorPager.this.operatorControlFragment != null && (previewTexture = OperatorPager.this.operatorControlFragment.getPreviewTexture()) != null) {
                if (OperatorPager.this.lastPageSelected == 2) {
                    if (this.notScrolling) {
                        i2 = 0;
                    }
                    previewTexture.setVisibility(i2);
                    return;
                }
                previewTexture.setVisibility(4);
            }
        }
    };
    /* access modifiers changed from: private */
    public ReceivedTasksFragment receivedTasksFragment;
    /* access modifiers changed from: private */
    public View rightMiddleDot;
    private StoredTasksFragment storedTasksFragment;

    public OperatorPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myStartIndex = 2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fragments == null) {
            this.fragments = new ArrayList();
            if (!isInEditMode()) {
                ReceivedTasksFragment receivedTasksFragment2 = new ReceivedTasksFragment();
                this.receivedTasksFragment = receivedTasksFragment2;
                receivedTasksFragment2.init(this.pluginContext, TasksFragment.MODE.OPERATOR);
                this.fragments.add(this.receivedTasksFragment);
                ActiveTasksFragment activeTasksFragment = new ActiveTasksFragment();
                this.activeTaskFragment = activeTasksFragment;
                activeTasksFragment.init(this.pluginContext, TasksFragment.MODE.OPERATOR);
                this.fragments.add(this.activeTaskFragment);
                OperatorControlFragment operatorControlFragment2 = new OperatorControlFragment();
                this.operatorControlFragment = operatorControlFragment2;
                operatorControlFragment2.init(this.pluginContext);
                this.operatorControlFragment.setParentPager(this);
                this.fragments.add(this.operatorControlFragment);
                StoredTasksFragment storedTasksFragment2 = new StoredTasksFragment();
                this.storedTasksFragment = storedTasksFragment2;
                storedTasksFragment2.init(this.pluginContext, TasksFragment.MODE.OPERATOR);
                this.fragments.add(this.storedTasksFragment);
            }
            this.dotsView = this.parentView.findViewById(C1877R.C1878id.operator_dot_layout);
            View findViewById = this.dotsView.findViewById(C1877R.C1878id.operator_dot_left);
            this.leftDot = findViewById;
            findViewById.setSelected(false);
            View findViewById2 = this.dotsView.findViewById(C1877R.C1878id.operator_dot_leftmiddle);
            this.leftMiddleDot = findViewById2;
            findViewById2.setSelected(false);
            View findViewById3 = this.dotsView.findViewById(C1877R.C1878id.operator_dot_middle);
            this.middleDot = findViewById3;
            findViewById3.setSelected(true);
            View findViewById4 = this.dotsView.findViewById(C1877R.C1878id.operator_dot_rightmiddle);
            this.rightMiddleDot = findViewById4;
            findViewById4.setSelected(false);
            if (!isInEditMode()) {
                this.pagerAdapter = new UASToolPagerAdapter(MapView.getMapView().getContext().getSupportFragmentManager());
                this.pagerAdapter.setFragments(this.fragments);
            }
            new Handler().post(new Runnable() {
                public void run() {
                    OperatorPager operatorPager = OperatorPager.this;
                    operatorPager.setAdapter(operatorPager.pagerAdapter);
                }
            });
            addOnPageChangeListener(this.pageChangeListener);
            setCurrentItem(2);
            return;
        }
        this.receivedTasksFragment.resume();
        this.activeTaskFragment.resume();
        this.operatorControlFragment.resume();
        this.storedTasksFragment.resume();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.receivedTasksFragment.pause();
        this.activeTaskFragment.pause();
        this.operatorControlFragment.pause();
        this.storedTasksFragment.pause();
    }

    public void dispose() {
        FragmentManager supportFragmentManager = MapView.getMapView().getContext().getSupportFragmentManager();
        if (this.operatorControlFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.operatorControlFragment).commitAllowingStateLoss();
            } catch (Exception e) {
                Log.d(TAG, "Could not remove operatorControlFragment ", e);
            }
        }
        if (this.activeTaskFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.activeTaskFragment).commitAllowingStateLoss();
            } catch (Exception e2) {
                Log.d(TAG, "Could not remove activeTaskFragment ", e2);
            }
        }
        if (this.receivedTasksFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.receivedTasksFragment).commitAllowingStateLoss();
            } catch (Exception e3) {
                Log.d(TAG, "Could not remove receivedTasksFragment ", e3);
            }
        }
        if (this.storedTasksFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.storedTasksFragment).commitAllowingStateLoss();
            } catch (Exception e4) {
                Log.d(TAG, "Could not remove storedTasksFragment ", e4);
            }
        }
    }

    public void onDropDownVisible(boolean z) {
        PreviewTextureView previewTexture;
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null && (previewTexture = operatorControlFragment2.getPreviewTexture()) != null) {
            if (!z || this.lastPageSelected != 2) {
                previewTexture.setVisibility(8);
            } else {
                previewTexture.setVisibility(0);
            }
        }
    }

    public void gotUASConnection() {
        this.receivedTasksFragment.gotUASConnection();
        this.activeTaskFragment.gotUASConnection();
        this.operatorControlFragment.gotUASConnection();
        this.storedTasksFragment.gotUASConnection();
    }

    public void lostUASConnection() {
        this.receivedTasksFragment.lostUASConnection();
        this.activeTaskFragment.lostUASConnection();
        this.operatorControlFragment.lostUASConnection();
        this.storedTasksFragment.lostUASConnection();
    }

    public void setUASItem(UASItem uASItem, Reflector reflector) {
        super.setUASItem(uASItem);
        this.receivedTasksFragment.setUASItem(uASItem);
        this.activeTaskFragment.setUASItem(uASItem);
        this.operatorControlFragment.setUASItem(uASItem, reflector);
        this.storedTasksFragment.setUASItem(uASItem);
    }

    public boolean isOnVideoPage() {
        return this.operatorControlFragment != null && getCurrentItem() == 2;
    }

    public void updateUIOnBroadcastChange(boolean z) {
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null) {
            operatorControlFragment2.updateUIOnBroadcastChange(z);
        }
    }

    public void resizeFull() {
        super.resizeFull();
        this.operatorControlFragment.resizeFull();
    }

    public void resizeHalf() {
        super.resizeHalf();
        this.operatorControlFragment.resizeHalf();
    }

    public void callsignChanged(String str) {
        this.receivedTasksFragment.callsignChanged(str);
        this.activeTaskFragment.callsignChanged(str);
        this.operatorControlFragment.callsignChanged(str);
        this.storedTasksFragment.callsignChanged(str);
    }

    public PreviewTextureView getPreviewTexture() {
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null) {
            return operatorControlFragment2.getPreviewTexture();
        }
        return null;
    }

    public int getPreviewVisibility() {
        PreviewTextureView previewTexture = getPreviewTexture();
        if (previewTexture != null) {
            return previewTexture.getVisibility();
        }
        return -1;
    }

    public void setPreviewVisibility(int i) {
        PreviewTextureView previewTexture = getPreviewTexture();
        if (previewTexture != null) {
            previewTexture.setVisibility(i);
        }
    }

    public VideoUIBase getVideoUI() {
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null) {
            return operatorControlFragment2.getVideoUI();
        }
        return null;
    }

    public ArOverlayView getArOverlay() {
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null) {
            return operatorControlFragment2.getArOverlay();
        }
        return null;
    }

    public OperatorControlFragment getOperatorControlFragment() {
        return this.operatorControlFragment;
    }

    public void handleReceivedTask(UASTask uASTask) {
        String taskSourceUid = uASTask.getTaskSourceUid();
        if (this.selectedUASItem == null) {
            if (taskSourceUid == null || !taskSourceUid.equals(MapView.getMapView().getSelfMarker().getUID())) {
                sendTaskDeniedResponse(uASTask, "Operator UAS is no longer available");
                return;
            }
            c b = n.a().b(uASTask.getUser());
            String user = uASTask.getUser();
            if (b != null) {
                user = b.a();
            }
            UASToolDropDownReceiver.toast("Saved task " + uASTask.getName() + " from " + user);
            UASTaskStore.getInstance().saveTask(uASTask);
        } else if (UASItem.getLtclcModeTask(taskSourceUid)) {
            int i = C16674.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i == 1) {
                addTaskToReceivedQueue(uASTask);
            } else if (i == 2) {
                cancelLTCLCMode((LTCLCRemoteCancelTask) uASTask);
            } else if (i == 3) {
                this.selectedUASItem.handleLtclcTask((LTCLCFOVCenterTask) uASTask);
            } else if (i != 4) {
                addTaskToReceivedQueue(uASTask);
            } else {
                this.selectedUASItem.handleQuickTask((QuickTask) uASTask);
            }
        } else {
            int i2 = C16674.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i2 == 1) {
                addTaskToReceivedQueue(uASTask);
            } else if (i2 == 2) {
                cancelLTCLCMode((LTCLCRemoteCancelTask) uASTask);
            } else if (i2 == 3 || i2 == 4) {
                sendTaskDeniedResponse(uASTask, "Operator is not in Remote Gimbal Control mode");
            } else {
                addTaskToReceivedQueue(uASTask);
            }
        }
    }

    /* renamed from: com.atakmap.android.uastool.pagers.operator.OperatorPager$4 */
    /* synthetic */ class C16674 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r0 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r0
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.operator.OperatorPager.C16674.<clinit>():void");
        }
    }

    public void sendTaskDeniedResponse(UASTask uASTask, String str) {
        if (uASTask.getTaskMessageUid() != null && uASTask.getTaskSourceUid() != null) {
            TaskResponse taskResponse = new TaskResponse((UASItem) null, uASTask, TaskResponse.RESPONSETYPE.DENIED);
            String[] strArr = {uASTask.getTaskSourceUid()};
            Bundle bundle = new Bundle();
            bundle.putStringArray("toUIDs", strArr);
            CotMapComponent.h().a(taskResponse, bundle, CoTSendMethod.ANY);
            UASToolDropDownReceiver.toast("Denied remote task request " + uASTask.getName() + " from " + uASTask.getUser(), 1);
        }
    }

    private void addTaskToReceivedQueue(final UASTask uASTask) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                c b = n.a().b(uASTask.getUser());
                String user = uASTask.getUser();
                if (b != null) {
                    user = b.a();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setTitle("New Received Task");
                builder.setMessage("A new task (" + uASTask.getName() + ") has been received from " + user + ", run now or add to queue");
                builder.setPositiveButton("Run Now", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().tryToRunTask(uASTask);
                    }
                });
                builder.setNeutralButton("Queue Task", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        uASTask.setState(UASTask.STATE.RECEIVED);
                        UASTaskStore.getInstance().saveTask(uASTask);
                        OperatorPager.this.receivedTasksFragment.refreshList(false);
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        OperatorPager.this.sendTaskDeniedResponse(uASTask, "Operator denied task");
                        OperatorPager.this.receivedTasksFragment.refreshList(false);
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }

    private void cancelLTCLCMode(LTCLCRemoteCancelTask lTCLCRemoteCancelTask) {
        UASTask ltCLCTask = UASTaskStore.getInstance().getLtCLCTask();
        if (ltCLCTask == null) {
            ArrayList<UASTask> receivedTasks = UASTaskStore.getInstance().getReceivedTasks();
            if (receivedTasks != null && receivedTasks.size() > 0) {
                Iterator<UASTask> it = receivedTasks.iterator();
                while (it.hasNext()) {
                    UASTask next = it.next();
                    if (next.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE) && next.getTaskSourceUid().equals(lTCLCRemoteCancelTask.getTaskSourceUid())) {
                        UASTaskStore.getInstance().deleteTask(next.getUID());
                        this.receivedTasksFragment.refreshList(false);
                        UASToolDropDownReceiver.toast("Remote Gimbal Control mode cancelled", 1);
                    }
                }
            }
        } else if (ltCLCTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE) && ltCLCTask.getTaskSourceUid().equals(lTCLCRemoteCancelTask.getTaskSourceUid())) {
            UASTaskStore.getInstance().deleteTask(ltCLCTask.getUID());
            this.activeTaskFragment.refreshList(false);
            UASToolDropDownReceiver.toast("Remote Gimbal Control mode stopped", 1);
        }
    }

    public void initForShow(UASItem uASItem, Reflector reflector) {
        setUASItem(uASItem, reflector);
        setCurrentItem(2);
        this.pageChangeListener.onPageSelected(2);
    }

    public void stopShowing() {
        OperatorControlFragment operatorControlFragment2 = this.operatorControlFragment;
        if (operatorControlFragment2 != null) {
            operatorControlFragment2.getVideoUI().stopShowing();
        }
    }

    public ActiveTasksFragment getActiveTasksFragment() {
        return this.activeTaskFragment;
    }
}
