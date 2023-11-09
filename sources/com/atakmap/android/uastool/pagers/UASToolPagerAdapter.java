package com.atakmap.android.uastool.pagers;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import java.util.List;

public class UASToolPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "UASToolPagerAdapter";
    private List<Fragment> fragments;

    public int getItemPosition(Object obj) {
        return -2;
    }

    public UASToolPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public synchronized void setFragments(List<Fragment> list) {
        this.fragments = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        List<Fragment> list = this.fragments;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Fragment getItem(int i) {
        if (FileSystemUtils.isEmpty(this.fragments) || i > this.fragments.size()) {
            return null;
        }
        return this.fragments.get(i);
    }
}
