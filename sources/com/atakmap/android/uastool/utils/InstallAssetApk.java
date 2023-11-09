package com.atakmap.android.uastool.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.update.b;
import com.atakmap.android.util.a;
import com.atakmap.android.util.q;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.o3dr.android.client.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class InstallAssetApk {
    private static final String TAG = "InstallAssetApk";
    private static final Map<Integer, Pair<String, String>> androidVersionMap;
    private static InstallAssetApk instance = null;
    private static final MapView mapView = MapView.getMapView();
    private static final List<PackageNameVersion> missingApps = new ArrayList();
    private boolean initialized = false;
    private boolean isBusy = false;
    Map<String, ArrayList<PackageNameVersion>> platformSupportAppMap = new HashMap();
    private Context pluginContext;

    static /* synthetic */ void lambda$waitForIt$10(DialogInterface dialogInterface, int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        androidVersionMap = hashMap;
        hashMap.put(26, new Pair("8.0", "Oreo"));
        hashMap.put(25, new Pair("7.1", "Nougat++"));
    }

    public static InstallAssetApk getInstance() {
        if (instance == null) {
            instance = new InstallAssetApk();
        }
        return instance;
    }

    private static class PackageNameVersion {
        final String filename;
        final String name;
        final String packageName;
        final String platform;
        String status = null;
        final int version;

        PackageNameVersion(String str, String str2, int i, String str3, String str4) {
            this.name = str;
            this.packageName = str2;
            this.version = i;
            this.filename = str3;
            this.platform = str4;
        }
    }

    private void init() {
        this.pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = UASItem.getPlatformList().iterator();
        while (it.hasNext()) {
            UASItem buildItem = UASItem.buildItem(UASItem.NO_UID, "", it.next(), false);
            if (buildItem != null) {
                arrayList.add(buildItem.getSafeName());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (findApkPlatformFolder(str)) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            getPlatformSupportAppList((String) it3.next());
        }
        this.initialized = true;
    }

    private void getPlatformSupportAppList(String str) {
        int version;
        AssetManager assets = this.pluginContext.getAssets();
        ArrayList arrayList = new ArrayList();
        try {
            String[] list = assets.list("apks/" + str);
            if (list != null && list.length != 0) {
                for (String str2 : list) {
                    if (str2.endsWith(FileUtils.CAMERA_FILENAME_EXT)) {
                        String readXmlSupportFile = readXmlSupportFile(str, str2);
                        String displayName = getDisplayName(readXmlSupportFile);
                        String packageName = getPackageName(readXmlSupportFile);
                        String apkName = getApkName(readXmlSupportFile);
                        if (!(apkName == null || (version = getVersion(readXmlSupportFile)) == -1)) {
                            arrayList.add(new PackageNameVersion(displayName, packageName, version, apkName, str));
                        }
                    }
                }
                this.platformSupportAppMap.put(str, arrayList);
            }
        } catch (IOException e) {
            Log.d(TAG, "Exception: " + e.getMessage());
        }
    }

    private int getVersion(String str) {
        return getSupportFileAttributeInt(str, "versionCode");
    }

    private String getApkName(String str) {
        return getSupportFileAttribute(str, "apkname");
    }

    private String getPackageName(String str) {
        return getSupportFileAttribute(str, "packagename");
    }

    private String getDisplayName(String str) {
        return getSupportFileAttribute(str, "displayname");
    }

    private String getSupportFileAttribute(String str, String str2) {
        String str3 = null;
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName("supportfile");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                if (item.getNodeType() == 1) {
                    str3 = ((Element) item).getAttribute(str2);
                }
            }
        } catch (IOException | ParserConfigurationException e) {
            Log.d(TAG, "Exception: " + e.getMessage());
        } catch (SAXException unused) {
        }
        return str3;
    }

    private int getSupportFileAttributeInt(String str, String str2) {
        int i = -1;
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName("supportfile");
            int i2 = 0;
            int i3 = -1;
            while (i2 < elementsByTagName.getLength()) {
                try {
                    Node item = elementsByTagName.item(i2);
                    if (item.getNodeType() == 1) {
                        i3 = Utils.parseInt(((Element) item).getAttribute(str2), -1);
                    }
                    i2++;
                } catch (IOException | ParserConfigurationException e) {
                    e = e;
                    i = i3;
                    Log.d(TAG, "Exception: " + e.getMessage());
                    return i;
                } catch (SAXException unused) {
                    i = i3;
                    return i;
                }
            }
            return i3;
        } catch (IOException | ParserConfigurationException e2) {
            e = e2;
            Log.d(TAG, "Exception: " + e.getMessage());
            return i;
        } catch (SAXException unused2) {
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[SYNTHETIC, Splitter:B:24:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0080 A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085 A[Catch:{ IOException -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String readXmlSupportFile(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Exception: "
            java.lang.String r1 = "InstallAssetApk"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r3 = r7.pluginContext
            android.content.res.AssetManager r3 = r3.getAssets()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0089 }
            r4.<init>()     // Catch:{ IOException -> 0x0089 }
            java.lang.String r5 = "apks/"
            r4.append(r5)     // Catch:{ IOException -> 0x0089 }
            r4.append(r8)     // Catch:{ IOException -> 0x0089 }
            java.lang.String r8 = "/"
            r4.append(r8)     // Catch:{ IOException -> 0x0089 }
            r4.append(r9)     // Catch:{ IOException -> 0x0089 }
            java.lang.String r8 = r4.toString()     // Catch:{ IOException -> 0x0089 }
            java.io.InputStream r8 = r3.open(r8)     // Catch:{ IOException -> 0x0089 }
            r9 = 0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0058, all -> 0x0053 }
            java.nio.charset.Charset r4 = com.atakmap.coremap.filesystem.FileSystemUtils.UTF8_CHARSET     // Catch:{ IOException -> 0x0058, all -> 0x0053 }
            r3.<init>(r8, r4)     // Catch:{ IOException -> 0x0058, all -> 0x0053 }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004e, all -> 0x0049 }
            r8.<init>(r3)     // Catch:{ IOException -> 0x004e, all -> 0x0049 }
            java.lang.String r9 = r8.readLine()     // Catch:{ IOException -> 0x0047 }
        L_0x003d:
            if (r9 == 0) goto L_0x0072
            r2.append(r9)     // Catch:{ IOException -> 0x0047 }
            java.lang.String r9 = r8.readLine()     // Catch:{ IOException -> 0x0047 }
            goto L_0x003d
        L_0x0047:
            r9 = move-exception
            goto L_0x005c
        L_0x0049:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x007e
        L_0x004e:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x005c
        L_0x0053:
            r8 = move-exception
            r3 = r9
            r9 = r8
            r8 = r3
            goto L_0x007e
        L_0x0058:
            r8 = move-exception
            r3 = r9
            r9 = r8
            r8 = r3
        L_0x005c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r4.<init>()     // Catch:{ all -> 0x007d }
            r4.append(r0)     // Catch:{ all -> 0x007d }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x007d }
            r4.append(r9)     // Catch:{ all -> 0x007d }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x007d }
            com.atakmap.coremap.log.Log.d(r1, r9)     // Catch:{ all -> 0x007d }
        L_0x0072:
            if (r8 == 0) goto L_0x0077
            r8.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0077:
            if (r3 == 0) goto L_0x00a0
            r3.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x00a0
        L_0x007d:
            r9 = move-exception
        L_0x007e:
            if (r8 == 0) goto L_0x0083
            r8.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0083:
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0088:
            throw r9     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.atakmap.coremap.log.Log.d(r1, r8)
        L_0x00a0:
            java.lang.String r8 = r2.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.InstallAssetApk.readXmlSupportFile(java.lang.String, java.lang.String):java.lang.String");
    }

    private boolean findApkPlatformFolder(String str) {
        AssetManager assets = this.pluginContext.getAssets();
        try {
            String[] list = assets.list("apks/" + str);
            if (list == null || list.length == 0) {
                return false;
            }
            return true;
        } catch (IOException e) {
            Log.d(TAG, "Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean checkDependencies(String str) {
        if (!this.initialized) {
            init();
        }
        if (str == null) {
            return false;
        }
        boolean z = true;
        String j = a.j();
        Log.d(TAG, "Version brand: " + j);
        if (this.platformSupportAppMap.get(str) != null) {
            Iterator it = this.platformSupportAppMap.get(str).iterator();
            while (it.hasNext()) {
                if (!isInstalled((PackageNameVersion) it.next())) {
                    z = false;
                }
            }
        }
        return z;
    }

    public void checkAndInstallDependencies(String str) {
        String str2 = str;
        if (!this.initialized) {
            init();
        }
        if (!this.isBusy) {
            int i = 1;
            this.isBusy = true;
            ArrayList arrayList = new ArrayList();
            if (str2 == null) {
                arrayList.addAll(this.platformSupportAppMap.keySet());
            } else {
                arrayList.add(str2);
            }
            SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (!sharedPrefs.getBoolean("uastool.DONT_WARN_" + str3, false)) {
                    if (!CheckSdkVersionSupport(str3)) {
                        arrayList3.add(str3);
                    } else if (!checkDependencies(str3)) {
                        arrayList2.add(str3);
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                checkUnknown(mapView.getContext());
                ArrayList arrayList4 = new ArrayList();
                View inflate = LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.install_apk_layout, (ViewGroup) null);
                StringBuilder sb = new StringBuilder("One or more applications are not installed or are out of date. The platforms below require these apps to run correctly. Please select the platforms you would like to use and click OK to install.");
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C1877R.C1878id.install_apk_layout);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str4 = (String) it2.next();
                    CheckBox checkBox = new CheckBox(this.pluginContext);
                    StringBuilder sb2 = new StringBuilder(str4);
                    Iterator it3 = this.platformSupportAppMap.get(str4).iterator();
                    while (it3.hasNext()) {
                        PackageNameVersion packageNameVersion = (PackageNameVersion) it3.next();
                        Iterator it4 = it2;
                        if (!packageNameVersion.status.equals("Up to Date")) {
                            sb2.append("\n   ");
                            sb2.append(packageNameVersion.name);
                            sb2.append(" ");
                            sb2.append(packageNameVersion.status);
                        }
                        it2 = it4;
                    }
                    checkBox.setText(sb2);
                    checkBox.setTag(str4);
                    checkBox.setGravity(48);
                    checkBox.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(arrayList4) {
                        public final /* synthetic */ ArrayList f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            InstallAssetApk.lambda$checkAndInstallDependencies$0(this.f$0, compoundButton, z);
                        }
                    });
                    linearLayout.addView(checkBox, i);
                    i++;
                    it2 = it2;
                }
                Iterator it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    String str5 = (String) it5.next();
                    UASItem buildItem = UASItem.buildItem(UASItem.NO_UID, "", str5, false);
                    CheckBox checkBox2 = new CheckBox(this.pluginContext);
                    StringBuilder sb3 = new StringBuilder(str5);
                    sb3.append(" - ANDROID VERSION OUT OF DATE\n");
                    sb3.append("Android version ");
                    Map<Integer, Pair<String, String>> map = androidVersionMap;
                    sb3.append((String) map.get(Integer.valueOf(buildItem.getRequiredSdkVersion())).first);
                    sb3.append(" (");
                    sb3.append((String) map.get(Integer.valueOf(buildItem.getRequiredSdkVersion())).second);
                    sb3.append(") or newer is required to fly ");
                    sb3.append(str5);
                    sb3.append(" with UAS Tool\n");
                    sb3.append("Current API Level: ");
                    sb3.append(Build.VERSION.SDK_INT);
                    sb3.append(", Required: ");
                    sb3.append(buildItem.getRequiredSdkVersion());
                    checkBox2.setEnabled(false);
                    checkBox2.setText(sb3);
                    checkBox2.setTag(str5);
                    checkBox2.setGravity(48);
                    checkBox2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    linearLayout.addView(checkBox2, i);
                    i++;
                }
                ((TextView) inflate.findViewById(C1877R.C1878id.install_apk_message)).setText(sb.toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(mapView.getContext());
                AlertDialog.Builder view = builder.setTitle("UAS Tool Missing Applications").setCancelable(false).setView(inflate);
                CheckBox checkBox3 = (CheckBox) inflate.findViewById(C1877R.C1878id.install_apk_dont_warn);
                SharedPreferences sharedPreferences = sharedPrefs;
                ArrayList arrayList5 = arrayList2;
                ArrayList arrayList6 = arrayList3;
                view.setNegativeButton("Ignore", new DialogInterface.OnClickListener(checkBox3, sharedPreferences, arrayList5, arrayList6) {
                    public final /* synthetic */ CheckBox f$1;
                    public final /* synthetic */ SharedPreferences f$2;
                    public final /* synthetic */ ArrayList f$3;
                    public final /* synthetic */ ArrayList f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InstallAssetApk.this.lambda$checkAndInstallDependencies$1$InstallAssetApk(this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
                    }
                }).setPositiveButton("OK", new DialogInterface.OnClickListener(checkBox3, sharedPreferences, arrayList5, arrayList6, arrayList4) {
                    public final /* synthetic */ CheckBox f$1;
                    public final /* synthetic */ SharedPreferences f$2;
                    public final /* synthetic */ ArrayList f$3;
                    public final /* synthetic */ ArrayList f$4;
                    public final /* synthetic */ ArrayList f$5;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InstallAssetApk.this.lambda$checkAndInstallDependencies$4$InstallAssetApk(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
                    }
                });
                builder.create().show();
                return;
            }
            this.isBusy = false;
        }
    }

    static /* synthetic */ void lambda$checkAndInstallDependencies$0(ArrayList arrayList, CompoundButton compoundButton, boolean z) {
        String str = (String) compoundButton.getTag();
        if (z) {
            arrayList.add(str);
        } else {
            arrayList.remove(str);
        }
    }

    public /* synthetic */ void lambda$checkAndInstallDependencies$1$InstallAssetApk(CheckBox checkBox, SharedPreferences sharedPreferences, ArrayList arrayList, ArrayList arrayList2, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                edit.putBoolean("uastool.DONT_WARN_" + ((String) it.next()), true);
                edit.apply();
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                edit.putBoolean("uastool.DONT_WARN_" + ((String) it2.next()), true);
                edit.apply();
            }
        }
        this.isBusy = false;
    }

    public /* synthetic */ void lambda$checkAndInstallDependencies$4$InstallAssetApk(CheckBox checkBox, SharedPreferences sharedPreferences, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, DialogInterface dialogInterface, int i) {
        if (checkBox.isChecked()) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                edit.putBoolean("uastool.DONT_WARN_" + ((String) it.next()), true);
                edit.apply();
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                edit.putBoolean("uastool.DONT_WARN_" + ((String) it2.next()), true);
                edit.apply();
            }
        }
        if (UASToolDropDownReceiver.getInstance().getPlatformMonitor() != null) {
            UASToolDropDownReceiver.getInstance().getPlatformMonitor().endMonitoring();
        }
        new Thread(new Runnable(arrayList3) {
            public final /* synthetic */ ArrayList f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                InstallAssetApk.this.lambda$null$3$InstallAssetApk(this.f$1);
            }
        }, "UASTool-required").start();
        this.isBusy = false;
    }

    public /* synthetic */ void lambda$null$3$InstallAssetApk(ArrayList arrayList) {
        missingApps.clear();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = this.platformSupportAppMap.get((String) it.next()).iterator();
            while (it2.hasNext()) {
                PackageNameVersion packageNameVersion = (PackageNameVersion) it2.next();
                if (!packageNameVersion.status.equals("Up to Date")) {
                    missingApps.add(packageNameVersion);
                }
            }
        }
        for (PackageNameVersion next : missingApps) {
            File unrollAPK = unrollAPK(this.pluginContext, next.filename, next.platform);
            if (unrollAPK != null) {
                arrayList2.add(unrollAPK);
            }
        }
        holdAndWaitInstall(arrayList2, $$Lambda$InstallAssetApk$nNdhMacRvY0GGSch4tcY8Tis_Cc.INSTANCE);
    }

    private boolean CheckSdkVersionSupport(String str) {
        UASItem buildItem = UASItem.buildItem(UASItem.NO_UID, "", str, false);
        if (buildItem == null || Build.VERSION.SDK_INT >= buildItem.getRequiredSdkVersion()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void holdAndWaitInstall(List<File> list, Runnable runnable) {
        if (!FileSystemUtils.isEmpty(list)) {
            File remove = list.remove(0);
            if (remove.exists()) {
                MapView mapView2 = mapView;
                install(mapView2.getContext(), remove);
                AlertDialog.Builder builder = new AlertDialog.Builder(mapView2.getContext());
                builder.setTitle("Installation Finish").setCancelable(false).setMessage("Click OK to install the next required application.").setPositiveButton("OK", new DialogInterface.OnClickListener(list, runnable) {
                    public final /* synthetic */ List f$0;
                    public final /* synthetic */ Runnable f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InstallAssetApk.holdAndWaitInstall(this.f$0, this.f$1);
                    }
                });
                if (!FileSystemUtils.isEmpty(list)) {
                    mapView2.post(new Runnable(builder) {
                        public final /* synthetic */ AlertDialog.Builder f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            this.f$0.create().show();
                        }
                    });
                } else {
                    runnable.run();
                }
            } else {
                holdAndWaitInstall(list, runnable);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ba A[SYNTHETIC, Splitter:B:34:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6 A[SYNTHETIC, Splitter:B:42:0x00d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File unrollAPK(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "failed to close: "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unrolling: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "InstallAssetApk"
            com.atakmap.coremap.log.Log.d(r2, r1)
            android.content.res.AssetManager r7 = r7.getAssets()
            java.lang.String r1 = "apks"
            java.io.File r1 = com.atakmap.coremap.filesystem.FileSystemUtils.getItem(r1)
            boolean r3 = r1.mkdir()
            if (r3 != 0) goto L_0x0040
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to create directory"
            r3.append(r4)
            java.lang.String r4 = r1.getAbsolutePath()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.atakmap.coremap.log.Log.w(r2, r3)
        L_0x0040:
            java.io.File r3 = new java.io.File
            r3.<init>(r1, r8)
            r1 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            r4.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.lang.String r5 = "apks/"
            r4.append(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            r4.append(r9)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.lang.String r9 = "/"
            r4.append(r9)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            r4.append(r8)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.lang.String r9 = r4.toString()     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.io.InputStream r7 = r7.open(r9)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x0098 }
            r9.<init>(r3)     // Catch:{ all -> 0x0098 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0096 }
        L_0x006c:
            int r5 = r7.read(r4)     // Catch:{ all -> 0x0096 }
            r6 = -1
            if (r5 == r6) goto L_0x0078
            r6 = 0
            r9.write(r4, r6, r5)     // Catch:{ all -> 0x0096 }
            goto L_0x006c
        L_0x0078:
            r7.close()     // Catch:{ Exception -> 0x009e }
            r9.flush()     // Catch:{ Exception -> 0x009e }
            r9.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0095
        L_0x0082:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.atakmap.coremap.log.Log.e(r2, r8, r7)
        L_0x0095:
            return r3
        L_0x0096:
            r3 = move-exception
            goto L_0x009a
        L_0x0098:
            r3 = move-exception
            r9 = r1
        L_0x009a:
            r7.close()     // Catch:{ Exception -> 0x009e }
            throw r3     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            r7 = move-exception
            goto L_0x00a4
        L_0x00a0:
            r7 = move-exception
            goto L_0x00d4
        L_0x00a2:
            r7 = move-exception
            r9 = r1
        L_0x00a4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r3.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "failed to unroll: "
            r3.append(r4)     // Catch:{ all -> 0x00d2 }
            r3.append(r8)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d2 }
            com.atakmap.coremap.log.Log.e(r2, r3, r7)     // Catch:{ all -> 0x00d2 }
            if (r9 == 0) goto L_0x00d1
            r9.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00d1
        L_0x00be:
            r7 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.atakmap.coremap.log.Log.e(r2, r8, r7)
        L_0x00d1:
            return r1
        L_0x00d2:
            r7 = move-exception
            r1 = r9
        L_0x00d4:
            if (r1 == 0) goto L_0x00ed
            r1.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00ed
        L_0x00da:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            com.atakmap.coremap.log.Log.e(r2, r8, r9)
        L_0x00ed:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.InstallAssetApk.unrollAPK(android.content.Context, java.lang.String, java.lang.String):java.io.File");
    }

    /* access modifiers changed from: private */
    public static void postCheckAndInstall() {
        MapView mapView2 = mapView;
        AlertDialog.Builder builder = new AlertDialog.Builder(mapView2.getContext());
        builder.setTitle("Post Installation - Please Read").setCancelable(false).setMessage("Wait for android to install the missing files.  If you had trouble installing any of the applications or android reported an error during installation due to mismatched signatures, please click Uninstall and Reinstall to attempt to correct the error.").setPositiveButton("OK", $$Lambda$InstallAssetApk$AbpmyKki_WIHccc1xHxKH3nJWmg.INSTANCE).setNegativeButton("Uninstall and Reinstall", $$Lambda$InstallAssetApk$FEqtpEII61fGwr9S9qYs6rol9U.INSTANCE);
        mapView2.post(new Runnable(builder) {
            public final /* synthetic */ AlertDialog.Builder f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.create().show();
            }
        });
    }

    static /* synthetic */ void lambda$postCheckAndInstall$7(DialogInterface dialogInterface, int i) {
        if (UASToolDropDownReceiver.getInstance().getPlatformMonitor() != null) {
            UASToolDropDownReceiver.getInstance().getPlatformMonitor().beginMonitoring(false);
        }
    }

    static /* synthetic */ void lambda$postCheckAndInstall$8(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        while (true) {
            List<PackageNameVersion> list = missingApps;
            if (i2 < list.size()) {
                uninstall(mapView.getContext(), list.get(i2).packageName);
                i2++;
            } else {
                waitForIt();
                return;
            }
        }
    }

    private static void install(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        q.a(context, intent, file, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    private static void waitForIt() {
        MapView mapView2 = mapView;
        AlertDialog.Builder builder = new AlertDialog.Builder(mapView2.getContext());
        builder.setCancelable(false).setTitle("Uninstall").setMessage("Please press OK when the uninstall is complete.").setPositiveButton("OK", $$Lambda$InstallAssetApk$VPhaSgWf5C6U2PQPqAlHMivJzrA.INSTANCE);
        mapView2.post(new Runnable(builder) {
            public final /* synthetic */ AlertDialog.Builder f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.create().show();
            }
        });
    }

    private static void checkUnknown(Context context) {
        try {
            if (!(Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps") == 1)) {
                UASToolDropDownReceiver.toast("Enable allow UNKNOWN SOURCES to continue", 1);
                context.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
            }
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    private static void uninstall(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.DELETE", Uri.fromParts("package", str, (String) null)));
    }

    private static boolean isInstalled(PackageNameVersion packageNameVersion) {
        String str = packageNameVersion.packageName;
        int i = packageNameVersion.version;
        MapView mapView2 = mapView;
        boolean z = false;
        if (b.h(mapView2.getContext(), str)) {
            if (b.d(mapView2.getContext(), str) >= i) {
                z = true;
            }
            if (z) {
                packageNameVersion.status = "Up to Date";
            } else {
                packageNameVersion.status = "Out of Date";
            }
            return z;
        }
        packageNameVersion.status = "Not Installed";
        return false;
    }
}
