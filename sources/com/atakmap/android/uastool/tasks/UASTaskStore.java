package com.atakmap.android.uastool.tasks;

import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UASTaskStore {
    public static final int FILTER_PLATFORM = 2;
    public static final int FILTER_PRIORITY = 4;
    public static final int FILTER_TASK = 1;
    private static final String PERSISTANCE_FILENAME = "UASTaskStore.xml";
    private static final String TAG = "UASTaskStore";
    private static UASTaskStore _instance;
    private final File internalStorage;
    private final ConcurrentHashMap<String, UASTask> tasks;

    public String exportTasks() {
        return null;
    }

    private UASTaskStore() {
        File file = new File(FileSystemUtils.getRoot().getPath() + File.separatorChar + "tools" + File.separatorChar + "uastool");
        this.internalStorage = file;
        if (!file.exists()) {
            file.mkdir();
        }
        this.tasks = new ConcurrentHashMap<>();
    }

    public static synchronized UASTaskStore getInstance() {
        UASTaskStore uASTaskStore;
        synchronized (UASTaskStore.class) {
            if (_instance == null) {
                UASTaskStore uASTaskStore2 = new UASTaskStore();
                _instance = uASTaskStore2;
                uASTaskStore2.init();
            }
            uASTaskStore = _instance;
        }
        return uASTaskStore;
    }

    private void init() {
        loadTasks();
    }

    private void loadTasks() {
        UASTask fromCot;
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(this.internalStorage, PERSISTANCE_FILENAME));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName(UASTask.COTDETAIL_UASTASK);
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Node item = elementsByTagName.item(i);
                if (item.getNodeType() == 1 && (fromCot = UASTask.fromCot(item)) != null && !FileSystemUtils.isEmpty(fromCot.getUID())) {
                    this.tasks.put(fromCot.getUID(), fromCot);
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            String str = TAG;
            Log.d(str, "Exception: " + e.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f A[SYNTHETIC, Splitter:B:27:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0 A[SYNTHETIC, Splitter:B:34:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void storeTasks() {
        /*
            r8 = this;
            java.lang.String r0 = "Unable to close file BufferedWriter: "
            r1 = 0
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            java.io.File r5 = r8.internalStorage     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            java.lang.String r6 = "UASTaskStore.xml"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            r2.<init>(r3)     // Catch:{ Exception -> 0x007f, all -> 0x007a }
            java.lang.String r1 = "<uastasks>"
            r2.write(r1)     // Catch:{ IOException -> 0x004c }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.atakmap.android.uastool.tasks.UASTask> r1 = r8.tasks     // Catch:{ IOException -> 0x004c }
            java.util.Collection r1 = r1.values()     // Catch:{ IOException -> 0x004c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x004c }
        L_0x0025:
            boolean r3 = r1.hasNext()     // Catch:{ IOException -> 0x004c }
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r1.next()     // Catch:{ IOException -> 0x004c }
            com.atakmap.android.uastool.tasks.UASTask r3 = (com.atakmap.android.uastool.tasks.UASTask) r3     // Catch:{ IOException -> 0x004c }
            boolean r4 = r3.deleteOnCompletion     // Catch:{ IOException -> 0x004c }
            if (r4 != 0) goto L_0x0025
            com.atakmap.coremap.cot.event.CotDetail r3 = r3.toCot()     // Catch:{ IOException -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004c }
            r2.write(r3)     // Catch:{ IOException -> 0x004c }
            goto L_0x0025
        L_0x0041:
            java.lang.String r1 = "</uastasks>"
            r2.write(r1)     // Catch:{ IOException -> 0x004c }
            r2.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x006d
        L_0x004a:
            r1 = move-exception
            goto L_0x0083
        L_0x004c:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "Exception writing to or closing UASTaskStore: "
            r3.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r1.getLocalizedMessage()     // Catch:{ Exception -> 0x004a }
            r3.append(r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004a }
            r4 = 0
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r3, r4)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "Exception writing to or closing UASTaskStore"
            com.atakmap.coremap.log.Log.e(r3, r4, r1)     // Catch:{ Exception -> 0x004a }
        L_0x006d:
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x00bc
        L_0x0071:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00ab
        L_0x007a:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00be
        L_0x007f:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x0083:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r4.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "Error while appending file entry: "
            r4.append(r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = r1.getLocalizedMessage()     // Catch:{ all -> 0x00bd }
            r4.append(r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00bd }
            com.atakmap.coremap.log.Log.d(r3, r4, r1)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00bc
            r2.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00bc
        L_0x00a3:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00ab:
            r3.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.atakmap.coremap.log.Log.d(r2, r0)
        L_0x00bc:
            return
        L_0x00bd:
            r1 = move-exception
        L_0x00be:
            if (r2 == 0) goto L_0x00dd
            r2.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00dd
        L_0x00c4:
            r2 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r2.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.atakmap.coremap.log.Log.d(r3, r0)
        L_0x00dd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.UASTaskStore.storeTasks():void");
    }

    public UASTask getTask(String str) {
        if (this.tasks.containsKey(str)) {
            return this.tasks.get(str);
        }
        return null;
    }

    public ArrayList<UASTask> getTasks(String[] strArr, UASTask.TASKTYPE[] tasktypeArr, UASTask.PRIORITY[] priorityArr, UASTask.STATE[] stateArr) {
        ArrayList<UASTask> arrayList = new ArrayList<>();
        for (UASTask next : this.tasks.values()) {
            if (next.matchesFilter(strArr, tasktypeArr, priorityArr, stateArr)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ArrayList<UASTask> getRunningTasks() {
        return getTasks((String[]) null, (UASTask.TASKTYPE[]) null, (UASTask.PRIORITY[]) null, new UASTask.STATE[]{UASTask.STATE.RUNNING, UASTask.STATE.PAUSED});
    }

    public UASTask getLtCLCTask() {
        Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
        while (it.hasNext()) {
            UASTask next = it.next();
            if (next.getTaskType() == UASTask.TASKTYPE.LTCLC_REMOTE) {
                return next;
            }
        }
        return null;
    }

    public UASTask getRunningRoute() {
        Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
        while (it.hasNext()) {
            UASTask next = it.next();
            if (next.getTaskType() == UASTask.TASKTYPE.ROUTE) {
                return next;
            }
        }
        return null;
    }

    public UASTask getRunningRoute(UASItem uASItem) {
        if (!(uASItem == null || uASItem.getUid() == null)) {
            Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
            while (it.hasNext()) {
                UASTask next = it.next();
                if (next.getParentUasItem() != null && next.getParentUasItem().getUid() != null && next.getTaskType() == UASTask.TASKTYPE.ROUTE && uASItem.getUid().equals(next.getParentUasItem().getUid())) {
                    return next;
                }
            }
        }
        return null;
    }

    public void pauseRunningTasks() {
        setAllRunningTaskState(UASTask.STATE.PAUSED);
    }

    public void pauseRunningRoutes() {
        Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
        while (it.hasNext()) {
            UASTask next = it.next();
            if (next.getTaskType() == UASTask.TASKTYPE.ROUTE) {
                next.setState(UASTask.STATE.PAUSED);
            }
        }
        UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().refreshList(false);
    }

    public void stopRunningTasks() {
        setAllRunningTaskState(UASTask.STATE.STORED);
    }

    public void stopRunningRoutes() {
        Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
        while (it.hasNext()) {
            UASTask next = it.next();
            if (next.getTaskType() == UASTask.TASKTYPE.ROUTE) {
                next.setState(UASTask.STATE.STORED);
            }
        }
        UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().refreshList(false);
    }

    public void stopRunningRoutes(UASItem uASItem) {
        if (uASItem != null && uASItem.getUid() != null) {
            Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
            while (it.hasNext()) {
                UASTask next = it.next();
                if (next.getParentUasItem() != null && next.getParentUasItem().getUid() != null && next.getTaskType() == UASTask.TASKTYPE.ROUTE && uASItem.getUid().equals(next.getParentUasItem().getUid())) {
                    next.setState(UASTask.STATE.STORED);
                }
            }
            UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().refreshList(false);
        }
    }

    private void setAllRunningTaskState(UASTask.STATE state) {
        Iterator<UASTask> it = getInstance().getRunningTasks().iterator();
        while (it.hasNext()) {
            it.next().setState(state);
        }
        UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().refreshList(false);
    }

    public ArrayList<UASTask> getReceivedTasks() {
        return getTasks((String[]) null, (UASTask.TASKTYPE[]) null, (UASTask.PRIORITY[]) null, new UASTask.STATE[]{UASTask.STATE.RECEIVED});
    }

    public void saveTask(UASTask uASTask) {
        if (uASTask.getState() != UASTask.STATE.STORED || !uASTask.isDeleteOnCompletion()) {
            if (getTask(uASTask.getUID()) != null) {
                this.tasks.remove(uASTask.getUID());
            }
            this.tasks.put(uASTask.getUID(), uASTask);
            storeTasks();
            return;
        }
        deleteTask(uASTask.getUID());
    }

    public void deleteTask(String str) {
        if (this.tasks.containsKey(str)) {
            this.tasks.remove(str);
            storeTasks();
        }
    }

    public void resetTasks() {
        for (UASTask next : this.tasks.values()) {
            if (next.getState().equals(UASTask.STATE.RUNNING) || next.getState().equals(UASTask.STATE.PAUSED) || next.getState().equals(UASTask.STATE.QUEUED)) {
                if (next.getTaskType().name().startsWith("LTCLC") || next.isDeleteOnCompletion()) {
                    deleteTask(next.getUID());
                } else {
                    next.setState(UASTask.STATE.STORED);
                    saveTask(next);
                }
            } else if (next.getState().equals(UASTask.STATE.RECEIVED)) {
                deleteTask(next.getUID());
            }
        }
    }

    public void gotUASConnection() {
        resetTasks();
    }

    public void lostUASConnection() {
        resetTasks();
    }
}
