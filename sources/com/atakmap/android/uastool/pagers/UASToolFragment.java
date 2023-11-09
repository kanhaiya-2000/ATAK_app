package com.atakmap.android.uastool.pagers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.status.StatusFragment;
import com.atakmap.android.uastool.quickbar.Quickbar;
import com.atakmap.coremap.log.Log;

public abstract class UASToolFragment extends Fragment {
    private static final String TAG = "UASToolFragment";
    protected UASToolScreen currentScreen = null;
    /* access modifiers changed from: protected */
    public ViewGroup layoutView;
    protected View mainView;
    /* access modifiers changed from: protected */
    public Context pluginContext;
    /* access modifiers changed from: protected */
    public UASItem selectedUASItem = null;
    protected UASToolPager viewPager;

    public void callsignChanged(String str) {
    }

    public void gotUASConnection() {
    }

    public void lostUASConnection() {
    }

    public void onPageUnSelected() {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void init(Context context) {
        this.pluginContext = context;
    }

    public void setUASItem(UASItem uASItem) {
        this.selectedUASItem = uASItem;
    }

    public UASToolScreen getCurrentScreen() {
        return this.currentScreen;
    }

    public void setCurrentScreen(UASToolScreen uASToolScreen, UASItem uASItem, UASToolFragment uASToolFragment) {
        int removeCurrentScreen = removeCurrentScreen();
        if (removeCurrentScreen < 0) {
            removeCurrentScreen = 0;
        }
        if (this.viewPager == null) {
            View view = getView();
            if (view != null) {
                this.viewPager = (UASToolPager) view.getParent();
            } else {
                return;
            }
        }
        this.viewPager.setPagingEnabled(false);
        this.currentScreen = uASToolScreen;
        uASToolScreen.init(uASItem, uASToolFragment);
        this.layoutView.addView(this.currentScreen, removeCurrentScreen);
        this.mainView.setVisibility(8);
        this.currentScreen.setVisibility(0);
        this.currentScreen.bringToFront();
        Quickbar quickbar = UASToolDropDownReceiver.getInstance().getQuickbar();
        if (quickbar != null) {
            quickbar.setBackAsClose(false);
        }
    }

    public int removeCurrentScreen() {
        UASToolScreen uASToolScreen = this.currentScreen;
        if (uASToolScreen == null) {
            return -1;
        }
        int indexOfChild = this.layoutView.indexOfChild(uASToolScreen);
        if (indexOfChild >= 0) {
            this.currentScreen.setVisibility(8);
            this.layoutView.removeView(this.currentScreen);
        } else {
            Log.d(TAG, "Removing screen: CURRENT SCREEN HAS NO PARENT");
        }
        UASToolScreen uASToolScreen2 = this.currentScreen;
        if (uASToolScreen2 instanceof UASToolScreen) {
            uASToolScreen2.destroy();
        }
        this.currentScreen = null;
        this.mainView.setVisibility(0);
        if (this.viewPager == null) {
            View view = getView();
            if (view == null) {
                return -1;
            }
            this.viewPager = (UASToolPager) view.getParent();
        }
        this.viewPager.setPagingEnabled(true);
        Quickbar quickbar = UASToolDropDownReceiver.getInstance().getQuickbar();
        if (quickbar != null) {
            if (this instanceof StatusFragment) {
                quickbar.setBackAsClose(true);
            } else {
                quickbar.setBackAsClose(false);
            }
        }
        return indexOfChild;
    }

    /* access modifiers changed from: protected */
    public void helpPopup(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    public void onResume() {
        UASToolFragment.super.onResume();
        View view = getView();
        if (view != null) {
            this.viewPager = (UASToolPager) view.getParent();
        }
    }

    public boolean onBackPressed() {
        return removeCurrentScreen() >= 0;
    }

    public void onDestroyView() {
        UASToolFragment.super.onDestroyView();
    }

    public void onPageSelected() {
        Quickbar quickbar = UASToolDropDownReceiver.getInstance().getQuickbar();
        if (quickbar == null) {
            return;
        }
        if (this instanceof StatusFragment) {
            quickbar.setBackAsClose(true);
        } else {
            quickbar.setBackAsClose(false);
        }
    }

    public ViewPager getPager() {
        if (this.viewPager == null) {
            this.viewPager = (UASToolPager) getView().getParent();
        }
        return this.viewPager;
    }

    public UASItem getSelectedUASItem() {
        return this.selectedUASItem;
    }
}
