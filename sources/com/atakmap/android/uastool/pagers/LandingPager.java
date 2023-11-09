package com.atakmap.android.uastool.pagers;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.pagers.status.StatusFragment;
import com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;

public class LandingPager extends UASToolPager {
    private static final boolean SHOW_TASKING_PANES = true;
    public static final int START_INDEX = 0;
    public static final String TAG = "LandingPager";
    /* access modifiers changed from: private */
    public UASToolFragment currentFragment;
    /* access modifiers changed from: private */
    public View leftDot;
    /* access modifiers changed from: private */
    public View middleDot;
    private final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(final int i) {
            if (i > 2) {
                String str = LandingPager.TAG;
                Log.d(str, "Unable to select position: " + i);
                return;
            }
            boolean z = false;
            LandingPager.this.leftDot.setSelected(i == 0);
            View access$100 = LandingPager.this.middleDot;
            if (i == 1) {
                z = true;
            }
            access$100.setSelected(z);
            LandingPager.this.post(new Runnable() {
                public void run() {
                    if (LandingPager.this.currentFragment != null) {
                        LandingPager.this.currentFragment.onPageUnSelected();
                    }
                    UASToolFragment unused = LandingPager.this.currentFragment = LandingPager.this.pagerAdapter.getItem(i);
                    LandingPager.this.currentFragment.onPageSelected();
                }
            });
        }
    };
    private StatusFragment statusFragment;
    private StoredTasksFragment storedTasksFragment;

    public LandingPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myStartIndex = 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = TAG;
        Log.d(str, "onAttachedToWindow LandingPager: " + this.fragments);
        if (this.fragments == null) {
            this.fragments = new ArrayList();
            if (!isInEditMode()) {
                StatusFragment statusFragment2 = new StatusFragment();
                this.statusFragment = statusFragment2;
                statusFragment2.init(this.pluginContext);
                this.fragments.add(this.statusFragment);
                this.currentFragment = this.statusFragment;
                StoredTasksFragment storedTasksFragment2 = new StoredTasksFragment();
                this.storedTasksFragment = storedTasksFragment2;
                storedTasksFragment2.init(this.pluginContext, TasksFragment.MODE.LANDING);
                this.fragments.add(this.storedTasksFragment);
            }
            this.dotsView = this.parentView.findViewById(C1877R.C1878id.landing_dot_layout);
            View findViewById = this.dotsView.findViewById(C1877R.C1878id.landing_dot_left);
            this.leftDot = findViewById;
            findViewById.setSelected(true);
            View findViewById2 = this.dotsView.findViewById(C1877R.C1878id.landing_dot_middle);
            this.middleDot = findViewById2;
            findViewById2.setSelected(false);
            if (!isInEditMode()) {
                this.pagerAdapter = new UASToolPagerAdapter(MapView.getMapView().getContext().getSupportFragmentManager());
                this.pagerAdapter.setFragments(this.fragments);
            }
            new Handler().post(new Runnable() {
                public void run() {
                    LandingPager landingPager = LandingPager.this;
                    landingPager.setAdapter(landingPager.pagerAdapter);
                }
            });
            addOnPageChangeListener(this.pageChangeListener);
            setCurrentItem(0);
        } else {
            this.statusFragment.resume();
            this.storedTasksFragment.resume();
        }
        if (UASToolDropDownReceiver.getInstance() != null) {
            UASToolDropDownReceiver.getInstance().showStartupWarning();
        }
        Utils.checkInstallDTED();
    }

    public void refreshStoredTasks() {
        StoredTasksFragment storedTasksFragment2 = this.storedTasksFragment;
        if (storedTasksFragment2 != null) {
            storedTasksFragment2.refreshList(false);
        }
    }

    public void onDetachedFromWindow() {
        Log.d(TAG, "onDetachedFromWindow LandingPager");
        super.onDetachedFromWindow();
        this.statusFragment.pause();
        this.storedTasksFragment.pause();
    }

    public void gotUASConnection() {
        StatusFragment statusFragment2 = this.statusFragment;
        if (statusFragment2 != null) {
            statusFragment2.gotUASConnection();
        }
        this.storedTasksFragment.gotUASConnection();
    }

    public void lostUASConnection() {
        StatusFragment statusFragment2 = this.statusFragment;
        if (statusFragment2 != null) {
            statusFragment2.lostUASConnection();
        }
        this.storedTasksFragment.lostUASConnection();
    }

    public void setUASItem(UASItem uASItem) {
        super.setUASItem(uASItem);
        StatusFragment statusFragment2 = this.statusFragment;
        if (statusFragment2 != null) {
            statusFragment2.setUASItem(uASItem);
        }
        this.storedTasksFragment.setUASItem(uASItem);
    }

    public void callsignChanged(String str) {
        StatusFragment statusFragment2 = this.statusFragment;
        if (statusFragment2 != null) {
            statusFragment2.callsignChanged(str);
        }
        StoredTasksFragment storedTasksFragment2 = this.storedTasksFragment;
        if (storedTasksFragment2 != null) {
            storedTasksFragment2.callsignChanged(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (isInEditMode()) {
            return;
        }
        if (i == 0) {
            this.statusFragment.resume();
        } else {
            this.statusFragment.pause();
        }
    }

    public void dispose() {
        FragmentManager supportFragmentManager = MapView.getMapView().getContext().getSupportFragmentManager();
        StatusFragment statusFragment2 = this.statusFragment;
        if (statusFragment2 != null) {
            statusFragment2.dispose();
            StatusArrayList.getInstance().removeDefaultUAS();
            supportFragmentManager.beginTransaction().remove(this.statusFragment).commitAllowingStateLoss();
            this.statusFragment.onDestroyView();
        }
        if (this.storedTasksFragment != null) {
            supportFragmentManager.beginTransaction().remove(this.storedTasksFragment).commitAllowingStateLoss();
            this.storedTasksFragment.onDestroyView();
        }
        Log.d(TAG, "removed the fragments");
    }

    public void showPlatformHealth() {
        this.statusFragment.showPlatformHealth(this.selectedUASItem);
    }
}
