package com.atakmap.android.uastool.pagers.observer;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.UASToolPagerAdapter;
import com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;

public class ObserverPager extends UASToolPager {
    private static final int START_INDEX = 0;
    /* access modifiers changed from: private */
    public static final String TAG = "ObserverPager";
    /* access modifiers changed from: private */
    public int lastPageSelected = 0;
    /* access modifiers changed from: private */
    public View leftDot;
    /* access modifiers changed from: private */
    public View middleDot;
    /* access modifiers changed from: private */
    public ObserverControlFragment observerControlFragment;
    private final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        private boolean isScrolling = false;

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageScrollStateChanged(int i) {
            boolean z = true;
            if (i != 0) {
                if (i != 1) {
                }
                z = false;
            }
            this.isScrolling = !z;
            if (ObserverPager.this.observerControlFragment == null) {
                return;
            }
            if (ObserverPager.this.lastPageSelected == 0) {
                ObserverPager.this.observerControlFragment.setShowing(z);
            } else {
                ObserverPager.this.observerControlFragment.setShowing(false);
            }
        }

        public void onPageSelected(final int i) {
            if (i > 2) {
                String access$300 = ObserverPager.TAG;
                Log.d(access$300, "Unable to select position: " + i);
                return;
            }
            ObserverPager.this.leftDot.setSelected(i == 0);
            ObserverPager.this.middleDot.setSelected(i == 1);
            if (!this.isScrolling && ObserverPager.this.observerControlFragment != null) {
                if (ObserverPager.this.lastPageSelected == 0) {
                    ObserverPager.this.observerControlFragment.setShowing(true);
                } else {
                    ObserverPager.this.observerControlFragment.setShowing(false);
                }
            }
            ObserverPager.this.post(new Runnable() {
                public void run() {
                    ObserverPager.this.pagerAdapter.getItem(i).onPageSelected();
                }
            });
            int unused = ObserverPager.this.lastPageSelected = i;
        }
    };
    private StoredTasksFragment storedTasksFragment;

    public void callsignChanged(String str) {
    }

    public ObserverPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myStartIndex = 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fragments == null) {
            this.fragments = new ArrayList();
            if (!isInEditMode()) {
                ObserverControlFragment observerControlFragment2 = new ObserverControlFragment();
                this.observerControlFragment = observerControlFragment2;
                observerControlFragment2.init(this.pluginContext);
                this.observerControlFragment.setParentPager(this);
                this.fragments.add(this.observerControlFragment);
                StoredTasksFragment storedTasksFragment2 = new StoredTasksFragment();
                this.storedTasksFragment = storedTasksFragment2;
                storedTasksFragment2.init(this.pluginContext, TasksFragment.MODE.OBSERVER);
                this.fragments.add(this.storedTasksFragment);
            }
            this.dotsView = this.parentView.findViewById(C1877R.C1878id.observer_dot_layout);
            View findViewById = this.dotsView.findViewById(C1877R.C1878id.observer_dot_left);
            this.leftDot = findViewById;
            findViewById.setSelected(true);
            View findViewById2 = this.dotsView.findViewById(C1877R.C1878id.observer_dot_middle);
            this.middleDot = findViewById2;
            findViewById2.setSelected(false);
            if (!isInEditMode()) {
                this.pagerAdapter = new UASToolPagerAdapter(MapView.getMapView().getContext().getSupportFragmentManager());
                this.pagerAdapter.setFragments(this.fragments);
            }
            new Handler().post(new Runnable() {
                public void run() {
                    ObserverPager observerPager = ObserverPager.this;
                    observerPager.setAdapter(observerPager.pagerAdapter);
                }
            });
            addOnPageChangeListener(this.pageChangeListener);
            setCurrentItem(0);
            return;
        }
        this.observerControlFragment.resume();
        this.storedTasksFragment.resume();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.observerControlFragment.pause();
        this.storedTasksFragment.pause();
    }

    public void dispose() {
        FragmentManager supportFragmentManager = MapView.getMapView().getContext().getSupportFragmentManager();
        if (this.observerControlFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.observerControlFragment).commitAllowingStateLoss();
            } catch (Exception e) {
                Log.d(TAG, "Could not remove observerControlFragment ", e);
            }
        }
        if (this.storedTasksFragment != null) {
            try {
                supportFragmentManager.beginTransaction().remove(this.storedTasksFragment).commitAllowingStateLoss();
            } catch (Exception e2) {
                Log.d(TAG, "Could not remove storedTasksFragment ", e2);
            }
        }
    }

    public void init() {
        setCurrentItem(0);
        this.observerControlFragment.startObserving();
    }

    public void onDropDownVisible(boolean z) {
        ObserverControlFragment observerControlFragment2 = this.observerControlFragment;
        if (observerControlFragment2 != null && this.lastPageSelected == 0) {
            observerControlFragment2.setShowing(z);
        }
    }

    public void gotUASConnection() {
        this.observerControlFragment.gotUASConnection();
        this.storedTasksFragment.gotUASConnection();
    }

    public void lostUASConnection() {
        this.observerControlFragment.lostUASConnection();
        this.storedTasksFragment.lostUASConnection();
    }

    public void setUASItem(UASItem uASItem) {
        super.setUASItem(uASItem);
        this.observerControlFragment.setUASItem(uASItem);
        this.storedTasksFragment.setUASItem(uASItem);
    }

    public void removeBroadcastUAS(UASItem uASItem) {
        if (uASItem.equals(this.selectedUASItem)) {
            lostUASConnection();
        }
    }

    public void handleWaitingTasks(CotEvent cotEvent) {
        ObserverControlFragment observerControlFragment2 = this.observerControlFragment;
        if (observerControlFragment2 != null) {
            observerControlFragment2.handleWaitingTasks(cotEvent);
        }
    }

    public void resizeFull() {
        super.resizeFull();
        this.observerControlFragment.resizeFull();
    }

    public void resizeHalf() {
        super.resizeHalf();
        this.observerControlFragment.resizeHalf();
    }

    public ObserverControlFragment getObserverControlFragment() {
        return this.observerControlFragment;
    }

    public VideoUIBase getVideoUI() {
        ObserverControlFragment observerControlFragment2 = this.observerControlFragment;
        if (observerControlFragment2 != null) {
            return observerControlFragment2.getVideoUI();
        }
        return null;
    }

    public ObserverFmvComponent getFMVComponent() {
        ObserverControlFragment observerControlFragment2 = this.observerControlFragment;
        if (observerControlFragment2 != null) {
            return observerControlFragment2.getFmvComponent();
        }
        return null;
    }

    public int getPreviewVisibility() {
        ObserverFmvComponent fMVComponent = getFMVComponent();
        if (fMVComponent != null) {
            return fMVComponent.getVisibility();
        }
        return -1;
    }

    public void setPreviewVisibility(int i) {
        ObserverFmvComponent fMVComponent = getFMVComponent();
        if (fMVComponent != null) {
            fMVComponent.setVisibility(i);
        }
    }

    public ArOverlayView getArOverlay() {
        ObserverControlFragment observerControlFragment2 = this.observerControlFragment;
        if (observerControlFragment2 != null) {
            return observerControlFragment2.getArOverlay();
        }
        return null;
    }

    public void stop() {
        this.observerControlFragment.stopObserving();
        this.observerControlFragment.getVideoUI().stopShowing();
    }
}
