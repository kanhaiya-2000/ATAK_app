package com.o3dr.android.client.utils.geotag;

import android.util.Log;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.atakmap.android.uastool.MAVLink.common.msg_named_value_int;
import com.o3dr.android.client.utils.data.tlog.TLogParser;
import com.o3dr.android.client.utils.geotag.GeoTagAsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class FilterByTimestampGeoTagAlgorithm implements GeoTagAsyncTask.GeoTagAlgorithm {
    private static final String TAG = "FilterByTimestampGeoTagAlgorithm";

    public HashMap<TLogParser.Event, File> match(List<TLogParser.Event> list, ArrayList<File> arrayList) {
        HashMap<TLogParser.Event, File> hashMap = null;
        if (!list.isEmpty() && !arrayList.isEmpty()) {
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            TLogParser.Event event = null;
            for (TLogParser.Event next : list) {
                MAVLinkMessage mavLinkMessage = next.getMavLinkMessage();
                if (mavLinkMessage instanceof msg_camera_feedback) {
                    treeMap.put(Long.valueOf(next.getTimestamp()), next);
                } else if (mavLinkMessage instanceof msg_named_value_int) {
                    if (event != null) {
                        Log.w(TAG, "There's more than one msg_named_value_int event in the event list.");
                        if (event.getTimestamp() <= next.getTimestamp()) {
                        }
                    }
                    event = next;
                }
            }
            if (event == null) {
                return null;
            }
            long timestamp = event.getTimestamp();
            Log.i(TAG, "Filtering events for mission " + ((msg_named_value_int) event.getMavLinkMessage()).getName() + " with start time " + timestamp);
            SortedMap tailMap = treeMap.tailMap(Long.valueOf(timestamp));
            if (tailMap.isEmpty()) {
                return null;
            }
            long longValue = ((Long) tailMap.lastKey()).longValue();
            if (longValue <= timestamp) {
                return null;
            }
            Calendar instance = Calendar.getInstance();
            long j = (long) (instance.get(15) + instance.get(16));
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next2 = it.next();
                long lastModified = next2.lastModified();
                long j2 = lastModified + j;
                if (timestamp <= j2 && j2 <= longValue) {
                    treeMap2.put(Long.valueOf(lastModified), next2);
                }
            }
            if (treeMap2.isEmpty()) {
                return null;
            }
            hashMap = new HashMap<>();
            ArrayList arrayList2 = new ArrayList(treeMap.values());
            int size = arrayList2.size();
            ArrayList arrayList3 = new ArrayList(treeMap2.values());
            int size2 = arrayList3.size();
            int i = 0;
            int i2 = 0;
            while (i < size && i2 < size2) {
                hashMap.put(arrayList2.get(i), arrayList3.get(i2));
                i++;
                i2++;
            }
        }
        return hashMap;
    }
}
