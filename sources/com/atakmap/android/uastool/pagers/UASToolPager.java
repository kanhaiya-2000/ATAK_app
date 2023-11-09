package com.atakmap.android.uastool.pagers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.uastool.UASItem;
import java.util.List;

public abstract class UASToolPager extends ViewPager {
    public static final String TAG = "UASToolPager";
    protected View dotsView;
    protected List<Fragment> fragments;
    protected boolean isPagingEnabled = true;
    protected int myStartIndex = 0;
    /* access modifiers changed from: protected */
    public UASToolPagerAdapter pagerAdapter;
    protected View parentView;
    protected final Context pluginContext;
    protected UASItem selectedUASItem;

    public void callsignChanged(String str) {
    }

    public void dispose() {
    }

    public abstract void gotUASConnection();

    public abstract void lostUASConnection();

    public UASToolPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    public void onAttachedToWindow() {
        UASToolPager.super.onAttachedToWindow();
        this.parentView = getRootView();
    }

    public void onDetachedFromWindow() {
        UASToolPager.super.onDetachedFromWindow();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && UASToolPager.super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && UASToolPager.super.onInterceptTouchEvent(motionEvent);
    }

    public void setUASItem(UASItem uASItem) {
        this.selectedUASItem = uASItem;
    }

    public UASItem getUASItem() {
        return this.selectedUASItem;
    }

    public void setPagingEnabled(boolean z) {
        this.isPagingEnabled = z;
        showDots(z);
    }

    private void showDots(boolean z) {
        View view = this.dotsView;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public boolean onBackPressed() {
        boolean onBackPressed = this.pagerAdapter.getItem(getCurrentItem()).onBackPressed();
        if (onBackPressed) {
            return onBackPressed;
        }
        int currentItem = getCurrentItem();
        int i = this.myStartIndex;
        if (currentItem < i) {
            setCurrentItem(currentItem + 1, true);
        } else if (currentItem <= i) {
            return false;
        } else {
            setCurrentItem(currentItem - 1, true);
        }
        return true;
    }

    public UASToolFragment getCurrentFragment() {
        List<Fragment> list = this.fragments;
        if (list != null) {
            return list.get(getCurrentItem());
        }
        return null;
    }

    public PagerAdapter getAdapter() {
        return this.pagerAdapter;
    }

    public void resizeFull() {
        setPagingEnabled(false);
    }

    public void resizeHalf() {
        setPagingEnabled(true);
    }
}
