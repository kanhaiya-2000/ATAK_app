package com.o3dr.android.client.utils.geotag;

import com.o3dr.android.client.utils.data.tlog.TLogParser;
import com.o3dr.android.client.utils.geotag.GeoTagAsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SimpleGeoTagAlgorithm implements GeoTagAsyncTask.GeoTagAlgorithm {
    SimpleGeoTagAlgorithm() {
    }

    public HashMap<TLogParser.Event, File> match(List<TLogParser.Event> list, ArrayList<File> arrayList) {
        HashMap<TLogParser.Event, File> hashMap = new HashMap<>();
        int size = list.size() - 1;
        int size2 = arrayList.size() - 1;
        while (size >= 0 && size2 >= 0) {
            hashMap.put(list.get(size), arrayList.get(size2));
            size--;
            size2--;
        }
        return hashMap;
    }
}
