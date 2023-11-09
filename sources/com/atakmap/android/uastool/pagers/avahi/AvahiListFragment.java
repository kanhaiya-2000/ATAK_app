package com.atakmap.android.uastool.pagers.avahi;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ListView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.AvahiService;

public class AvahiListFragment implements AvahiService.AvahiListListener {
    private static final String TAG = "AvahiListFragment";
    AvahiAdapter avahiAdapter;
    AvahiService avahiService;
    protected View mainView;
    Context pluginContext;

    public AvahiListFragment(Context context) {
        this.pluginContext = context;
    }

    public void init(View view, AvahiService avahiService2) {
        this.mainView = view;
        ((ImageButton) view.findViewById(C1877R.C1878id.avahi_list_refresh)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (AvahiListFragment.this.avahiService != null) {
                    AvahiListFragment.this.avahiService.stop();
                    AvahiListFragment.this.avahiService.clear();
                    AvahiListFragment.this.avahiService.start();
                }
            }
        });
        this.avahiService = avahiService2;
        avahiService2.listChangeListeners.add(this);
        AvahiAdapter avahiAdapter2 = new AvahiAdapter(this.pluginContext, this.avahiService.getList());
        this.avahiAdapter = avahiAdapter2;
        ((ListView) this.mainView.findViewById(C1877R.C1878id.avahi_items_list)).setAdapter(avahiAdapter2);
        this.avahiAdapter.notifyDataSetChanged();
    }

    public void dispose() {
        AvahiService avahiService2 = this.avahiService;
        if (avahiService2 != null) {
            avahiService2.dispose();
        }
    }

    public AvahiAdapter getListAdapter() {
        return this.avahiAdapter;
    }

    public void save() {
        AvahiService avahiService2 = this.avahiService;
        if (avahiService2 != null) {
            avahiService2.save();
        }
    }

    public void onListChanged() {
        this.avahiAdapter.notifyDataSetChanged();
        ViewParent parent = this.mainView.getParent();
        if (parent == null || !(parent instanceof View)) {
            this.mainView.invalidate();
        } else {
            ((View) parent).invalidate();
        }
    }

    public void setVisibility(int i) {
        View view = this.mainView;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
