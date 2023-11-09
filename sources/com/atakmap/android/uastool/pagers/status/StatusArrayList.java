package com.atakmap.android.uastool.pagers.status;

import android.app.Activity;
import android.text.TextUtils;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.status.StatusFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class StatusArrayList extends ArrayList<UASItem> {
    private static StatusArrayList _instance;
    private final ArrayList<NetworkUASItemListener> NetworkUASItemListenerList = new ArrayList<>();
    /* access modifiers changed from: private */
    public UASItem defaultUASItem;
    private StatusFragment.UAS_SORT_MODE sortField = StatusFragment.UAS_SORT_MODE.CALLSIGN;
    private boolean sortKeepAtTop = true;

    public interface NetworkUASItemListener {
        void onUASListChanged();
    }

    private StatusArrayList() {
    }

    public static StatusArrayList getInstance() {
        StatusArrayList statusArrayList = _instance;
        if (statusArrayList != null) {
            return statusArrayList;
        }
        StatusArrayList statusArrayList2 = new StatusArrayList();
        _instance = statusArrayList2;
        return statusArrayList2;
    }

    public void destroy() {
        removeDefaultUAS();
        Iterator it = iterator();
        while (it.hasNext()) {
            ((UASItem) it.next()).dispose();
        }
        clear();
    }

    public boolean add(UASItem uASItem) {
        if (uASItem.isDefault()) {
            super.add(0, uASItem);
        } else {
            super.add(uASItem);
        }
        sort(this.sortField, this.sortKeepAtTop);
        return true;
    }

    public boolean remove(Object obj) {
        boolean z = false;
        if (obj instanceof UASItem) {
            UASItem uASItem = (UASItem) obj;
            int i = 0;
            while (true) {
                if (i >= size()) {
                    break;
                }
                UASItem uASItem2 = (UASItem) get(i);
                if (uASItem2 != null && uASItem2.getUid().equals(uASItem.getUid())) {
                    if (!uASItem2.isDefault() || !uASItem.isDefault()) {
                        if (!uASItem2.isDefault() && !uASItem.isDefault()) {
                            remove(i);
                            break;
                        }
                    } else {
                        remove(i);
                        break;
                    }
                }
                i++;
            }
            z = true;
        }
        sort(this.sortField, this.sortKeepAtTop);
        return z;
    }

    public boolean containsBroadcasting(ao aoVar) {
        return getBroadcasting(aoVar) != null;
    }

    public UASItem getBroadcasting(ao aoVar) {
        for (int i = 0; i < size(); i++) {
            UASItem uASItem = (UASItem) get(i);
            if (!uASItem.isDefault() && uASItem.getUid().equals(aoVar.getUID())) {
                return uASItem;
            }
        }
        return null;
    }

    public UASItem removeBroadcasting(ao aoVar) {
        int i = 0;
        while (i < size()) {
            UASItem uASItem = (UASItem) get(i);
            if (uASItem.isDefault() || !uASItem.getUid().equals(aoVar.getUID())) {
                i++;
            } else {
                UASItem uASItem2 = (UASItem) remove(i);
                if (uASItem2 != null) {
                    return uASItem2;
                }
                UASToolDropDownReceiver.toast("Error removing broadcasting UAS", 0);
                return uASItem2;
            }
        }
        return null;
    }

    public StatusFragment.UAS_SORT_MODE getSortField() {
        return this.sortField;
    }

    public boolean getSortKeepAtTop() {
        return this.sortKeepAtTop;
    }

    public void sort(StatusFragment.UAS_SORT_MODE uas_sort_mode, boolean z) {
        this.sortField = uas_sort_mode;
        this.sortKeepAtTop = z;
        Collections.sort(this, getComparator(uas_sort_mode, z));
    }

    public static Comparator<UASItem> getComparator(final StatusFragment.UAS_SORT_MODE uas_sort_mode, final boolean z) {
        return new Comparator<UASItem>() {
            public int compare(UASItem uASItem, UASItem uASItem2) {
                if (!z || (!uASItem.isDefault() && !uASItem2.isDefault())) {
                    int i = C17075.f8401xecfaf28a[uas_sort_mode.ordinal()];
                    if (i == 1) {
                        return uASItem.getCallsign().toUpperCase().compareTo(uASItem2.getCallsign().toUpperCase());
                    }
                    if (i != 2) {
                        return 0;
                    }
                    return uASItem.distanceToMe().compareTo(uASItem2.distanceToMe());
                } else if (uASItem.isDefault()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
    }

    /* renamed from: com.atakmap.android.uastool.pagers.status.StatusArrayList$5 */
    /* synthetic */ class C17075 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$status$StatusFragment$UAS_SORT_MODE */
        static final /* synthetic */ int[] f8401xecfaf28a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE[] r0 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8401xecfaf28a = r0
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE r1 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.CALLSIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8401xecfaf28a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE r1 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.UAS_DISTANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.status.StatusArrayList.C17075.<clinit>():void");
        }
    }

    public UASItem getDefaultUasItem() {
        if (this.defaultUASItem == null) {
            addDefaultUAS();
        }
        return this.defaultUASItem;
    }

    public void addDefaultUAS() {
        String defaultPlatform = UASToolDropDownReceiver.getDefaultPlatform();
        if (!TextUtils.isEmpty(defaultPlatform)) {
            UASItem buildItem = UASItem.buildItem(UASItem.NO_UID, UASToolDropDownReceiver.getUASCallsign(), defaultPlatform, false);
            this.defaultUASItem = buildItem;
            if (buildItem != null) {
                ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        if (StatusArrayList.this.defaultUASItem != null) {
                            StatusArrayList.this.defaultUASItem.setDefault(true);
                            StatusArrayList.getInstance().add(StatusArrayList.this.defaultUASItem);
                            StatusArrayList.this.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }

    public void removeDefaultUAS() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (StatusArrayList.this.defaultUASItem != null) {
                    StatusArrayList.this.defaultUASItem.removeAllTaskListeners();
                    StatusArrayList statusArrayList = StatusArrayList.this;
                    statusArrayList.remove(statusArrayList.defaultUASItem);
                    UASItem unused = StatusArrayList.this.defaultUASItem = null;
                    StatusArrayList.this.notifyDataSetChanged();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void notifyDataSetChanged() {
        Iterator<NetworkUASItemListener> it = this.NetworkUASItemListenerList.iterator();
        while (it.hasNext()) {
            it.next().onUASListChanged();
        }
    }

    public void addNetworkUASItemListener(NetworkUASItemListener networkUASItemListener) {
        this.NetworkUASItemListenerList.add(networkUASItemListener);
    }

    public void removeNetworkUASItemListener(NetworkUASItemListener networkUASItemListener) {
        this.NetworkUASItemListenerList.remove(networkUASItemListener);
    }

    public void callsignChanged(String str) {
        UASItem uASItem = this.defaultUASItem;
        if (uASItem != null) {
            uASItem.setCallsign(str);
            notifyDataSetChanged();
        }
    }

    public void lostUASConnection() {
        this.defaultUASItem.updateStatusData();
        notifyDataSetChanged();
    }

    public void gotUASConnection() {
        notifyDataSetChanged();
    }

    public void removeBroadcastingUAS(final ao aoVar) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                UASItem removeBroadcasting;
                ao aoVar = aoVar;
                if (aoVar != null && (removeBroadcasting = StatusArrayList.this.removeBroadcasting(aoVar)) != null) {
                    UASToolDropDownReceiver.getInstance().removeBroadcastUAS(removeBroadcasting);
                    StatusArrayList.this.notifyDataSetChanged();
                }
            }
        });
    }

    public UASItem findUASItem(String str) {
        UASItem uASItem;
        Iterator it = getInstance().iterator();
        while (true) {
            if (!it.hasNext()) {
                uASItem = null;
                break;
            }
            uASItem = (UASItem) it.next();
            if (str.equals(uASItem.getUid())) {
                break;
            }
        }
        if (uASItem != null) {
            return uASItem;
        }
        Iterator it2 = getInstance().iterator();
        while (it2.hasNext()) {
            UASItem uASItem2 = (UASItem) it2.next();
            if (str.equals(uASItem2.getUid())) {
                return uASItem2;
            }
        }
        return uASItem;
    }
}
