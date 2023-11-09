package com.atakmap.android.uastool.pagers.storedtasks;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TasksArrayList extends ArrayList<UASTask> {
    public TasksArrayList(ArrayList<UASTask> arrayList, TasksFragment.SORT_MODE sort_mode) {
        super.addAll(arrayList);
        sort(sort_mode);
    }

    public TasksArrayList() {
    }

    public void sort(TasksFragment.SORT_MODE sort_mode) {
        Collections.sort(this, getComparator(sort_mode));
    }

    public static Comparator<UASTask> getComparator(final TasksFragment.SORT_MODE sort_mode) {
        return new Comparator<UASTask>() {
            public int compare(UASTask uASTask, UASTask uASTask2) {
                GeoPoint C;
                int i = C17492.f8404xb8b7226c[TasksFragment.SORT_MODE.this.ordinal()];
                if (i == 1) {
                    return uASTask.getName().toUpperCase().compareTo(uASTask2.getName().toUpperCase());
                }
                if (i == 2) {
                    return String.valueOf(uASTask2.getLastModified()).compareTo(String.valueOf(uASTask.getLastModified()));
                }
                if (i == 3 && (C = MapView.getMapView().getSelfMarker().C()) != null && !C.equals(GeoPoint.ZERO_POINT)) {
                    try {
                        return getDistance(uASTask, C).compareTo(getDistance(uASTask2, C));
                    } catch (NullPointerException unused) {
                    }
                }
                return 0;
            }

            public Double getDistance(UASTask uASTask, GeoPoint geoPoint) {
                if (geoPoint != null && uASTask != null) {
                    return Double.valueOf(uASTask.getFocusPoint().distanceTo(geoPoint));
                }
                throw null;
            }
        };
    }

    /* renamed from: com.atakmap.android.uastool.pagers.storedtasks.TasksArrayList$2 */
    /* synthetic */ class C17492 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$SORT_MODE */
        static final /* synthetic */ int[] f8404xb8b7226c;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE[] r0 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8404xb8b7226c = r0
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.NAME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8404xb8b7226c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.MODIFIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8404xb8b7226c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.pagers.TasksFragment$SORT_MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.SORT_MODE.DISTANCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.storedtasks.TasksArrayList.C17492.<clinit>():void");
        }
    }
}
