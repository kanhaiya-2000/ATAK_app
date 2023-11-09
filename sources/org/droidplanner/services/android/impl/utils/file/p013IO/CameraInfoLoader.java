package org.droidplanner.services.android.impl.utils.file.p013IO;

import android.content.Context;
import com.o3dr.android.client.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;

/* renamed from: org.droidplanner.services.android.impl.utils.file.IO.CameraInfoLoader */
public class CameraInfoLoader {
    private static final String CAMERA_INFO_ASSESTS_FOLDER = "CameraInfo";
    private Context context;
    private HashMap<String, String> filesInAssets = new HashMap<>();
    private HashMap<String, String> filesInSdCard = new HashMap<>();

    public CameraInfoLoader(Context context2) {
        this.context = context2;
    }

    public CameraInfo openFile(String str) {
        if (this.filesInSdCard.containsKey(str)) {
            return readSdCardFile(str);
        }
        if (this.filesInAssets.containsKey(str)) {
            return readAssetsFile(str);
        }
        throw new FileNotFoundException();
    }

    private CameraInfo readSdCardFile(String str) {
        CameraInfoReader cameraInfoReader = new CameraInfoReader();
        FileInputStream fileInputStream = new FileInputStream(this.filesInSdCard.get(str));
        cameraInfoReader.openFile(fileInputStream);
        fileInputStream.close();
        return cameraInfoReader.getCameraInfo();
    }

    private CameraInfo readAssetsFile(String str) {
        CameraInfoReader cameraInfoReader = new CameraInfoReader();
        InputStream open = this.context.getAssets().open(this.filesInAssets.get(str));
        cameraInfoReader.openFile(open);
        open.close();
        return cameraInfoReader.getCameraInfo();
    }

    public List<String> getCameraInfoList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getCameraInfoListFromStorage());
        arrayList.addAll(getCameraInfoListFromAssets());
        return arrayList;
    }

    private List<String> getCameraInfoListFromAssets() {
        try {
            String[] list = this.context.getAssets().list(CAMERA_INFO_ASSESTS_FOLDER);
            this.filesInAssets.clear();
            for (String str : list) {
                this.filesInAssets.put(str, "CameraInfo/" + str);
            }
            return Arrays.asList(list);
        } catch (IOException unused) {
            return new ArrayList();
        }
    }

    private List<String> getCameraInfoListFromStorage() {
        ArrayList arrayList = new ArrayList();
        this.filesInSdCard.clear();
        File[] cameraInfoFileList = FileUtils.getCameraInfoFileList(this.context);
        if (cameraInfoFileList != null && cameraInfoFileList.length > 0) {
            for (File file : cameraInfoFileList) {
                String name = file.getName();
                arrayList.add(name);
                this.filesInSdCard.put(name, file.getAbsolutePath());
            }
        }
        return arrayList;
    }
}
