package com.o3dr.android.client;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.o3dr.services.android.lib.model.IDroidPlannerServices;
import com.o3dr.services.android.lib.util.version.VersionUtils;
import java.util.List;
import org.droidplanner.services.android.impl.api.DroidPlannerService;

class ApiAvailability {
    private static final int INVALID_LIB_VERSION = -1;
    private static final String METADATA_KEY = "com.o3dr.dronekit.android.core.version";
    private static final String SERVICES_CLAZZ_NAME = IDroidPlannerServices.class.getName();

    private static class LazyHolder {
        /* access modifiers changed from: private */
        public static final ApiAvailability INSTANCE = new ApiAvailability();

        private LazyHolder() {
        }
    }

    private ApiAvailability() {
    }

    static ApiAvailability getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public Intent getAvailableServicesInstance(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(SERVICES_CLAZZ_NAME);
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo next : queryIntentServices) {
                Bundle bundle = next.serviceInfo.metaData;
                if (bundle != null && (i = bundle.getInt(METADATA_KEY, -1)) != -1 && i >= VersionUtils.getCoreLibVersion(context)) {
                    intent.setClassName(next.serviceInfo.packageName, next.serviceInfo.name);
                    return intent;
                }
            }
        }
        DroidPlannerService.enableDroidPlannerService(context, true);
        intent.setClass(context, DroidPlannerService.class);
        return intent;
    }
}
