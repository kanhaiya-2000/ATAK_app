package com.atakmap.android.uastool.utils;

import android.content.Context;
import android.content.Intent;
import com.atakmap.android.util.q;
import com.atakmap.android.util.y;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import java.io.File;

public class DocUtils {
    private static final String CHANGELOG = ("support" + File.separatorChar + "docs" + File.separatorChar + CHANGELOG_NAME);
    private static final String CHANGELOG_NAME = "CHANGELOG.txt";
    private static final String SUM = ("support" + File.separatorChar + "docs" + File.separatorChar + USER_GUIDE_NAME);
    private static final String TAG = "DocUtils";
    private static final String TOOL_DIR_NAME = "uastool";
    private static final String TOOL_DIR_PATH = ("tools" + File.separator + TOOL_DIR_NAME);
    private static final String USER_GUIDE_NAME = "UAS Tool Plugin Guide.pdf";

    public static void installSupportDocs(Context context) {
        String str = TOOL_DIR_PATH;
        FileSystemUtils.ensureDataDirectory(str, false);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(File.separator);
        String str2 = SUM;
        sb.append(str2);
        FileSystemUtils.copyFromAssetsToStorageFile(context, str2, sb.toString(), true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(File.separator);
        String str3 = CHANGELOG;
        sb2.append(str3);
        FileSystemUtils.copyFromAssetsToStorageFile(context, str3, sb2.toString(), true);
    }

    public static void openSUM(Context context) {
        y.b(context, new File(new File(FileSystemUtils.getItem("tools"), TOOL_DIR_NAME).getAbsolutePath(), SUM).getAbsolutePath());
    }

    public static void openChangelog(Context context) {
        File file = new File(new File(FileSystemUtils.getItem("tools"), TOOL_DIR_NAME).getAbsolutePath(), CHANGELOG);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            q.a(context, intent, new File(file.getAbsolutePath()), "application/txt");
            intent.setFlags(268435457);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "error launching a text file viewer", e);
        }
    }
}
