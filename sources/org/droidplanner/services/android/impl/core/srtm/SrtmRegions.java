package org.droidplanner.services.android.impl.core.srtm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.droidplanner.services.android.impl.core.srtm.Srtm;

public class SrtmRegions {
    static final String[] REGIONS = {"Eurasia", "Africa", "Australia", "Islands", "North_America", "South_America"};
    private String path;
    private Map<String, Integer> regionMap = new HashMap();

    public SrtmRegions(String str) {
        this.path = str;
    }

    public String findRegion(String str, Srtm.OnProgressListner onProgressListner) {
        if (this.regionMap.isEmpty()) {
            fillRegionData(onProgressListner);
        }
        String replace = str.replace(".hgt", "");
        if (this.regionMap.containsKey(replace)) {
            return REGIONS[this.regionMap.get(replace).intValue()];
        }
        throw new Exception("Null Region");
    }

    private void fillRegionData(Srtm.OnProgressListner onProgressListner) {
        int i = 0;
        while (true) {
            String[] strArr = REGIONS;
            if (i < strArr.length) {
                String str = SrtmDownloader.getIndexPath(this.path) + strArr[i];
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str + ".index.html");
                if (!file2.exists()) {
                    try {
                        new SrtmDownloader(onProgressListner).downloadRegionIndex(i, this.path);
                    } catch (IOException unused) {
                        this.regionMap.clear();
                        throw new Exception("Null Region");
                    }
                }
                Scanner scanner = new Scanner(file2);
                while (scanner.hasNext()) {
                    String next = scanner.next();
                    if (next.contains("href=\"")) {
                        int indexOf = next.indexOf(".hgt.zip") - 7;
                        if (indexOf >= 0) {
                            this.regionMap.put(next.substring(indexOf, indexOf + 7), Integer.valueOf(i));
                        } else {
                            int indexOf2 = next.indexOf("hgt.zip") - 7;
                            if (indexOf2 >= 0) {
                                this.regionMap.put(next.substring(indexOf2, indexOf2 + 7), Integer.valueOf(i));
                            }
                        }
                    }
                }
                scanner.close();
                i++;
            } else {
                return;
            }
        }
    }
}
