package com.atakmap.android.uastool.tasks;

import android.text.TextUtils;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteCancelTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class UASTask {
    public static final String COTDETAIL_COLOR = "color";
    public static final String COTDETAIL_MODIFIED = "modified";
    public static final String COTDETAIL_NAME = "name";
    public static final String COTDETAIL_PLATFORM = "platform";
    public static final String COTDETAIL_PRIORITY = "priority";
    public static final String COTDETAIL_STATE = "state";
    public static final String COTDETAIL_TASKTYPE = "tasktype";
    public static final String COTDETAIL_UASTASK = "_uastask";
    public static final String COTDETAIL_UID = "uid";
    public static final String COTDETAIL_USER = "user";
    private static final String TAG = "UASTask";
    protected int color;
    protected boolean deleteOnCompletion;
    protected boolean isViewing;
    protected long lastModified = 0;
    protected String name;
    private UASItem parentUasItem;
    protected String platform;
    protected PRIORITY priority;
    protected STATE state;
    private String taskMessageUid;
    private String taskSourceUid;
    protected TASKTYPE taskType;
    protected int taskTypeIcon;
    protected String uid;
    protected String user;

    public enum PRIORITY {
        LOW,
        NORMAL,
        HIGH
    }

    public enum STATE {
        STORED,
        QUEUED,
        RUNNING,
        PAUSED,
        RECEIVED
    }

    public enum TASKTYPE {
        ROUTE,
        QUICKFLY,
        SURVEY,
        LTCLC_FOVCENTER,
        LTCLC_REMOTE,
        LTCLC_CANCEL
    }

    public abstract GeoPoint getFocusPoint();

    public boolean showsProgress() {
        return false;
    }

    public abstract CotDetail toCot();

    public void setParentUasItem(UASItem uASItem) {
        this.parentUasItem = uASItem;
    }

    public UASItem getParentUasItem() {
        return this.parentUasItem;
    }

    protected UASTask(String str, String str2, String str3, String str4, PRIORITY priority2, TASKTYPE tasktype, STATE state2, int i, String str5) {
        init(tasktype, i, str, str2, str3, str4, priority2.toString(), state2.toString(), str5, "0");
    }

    protected UASTask(String str, String str2, String str3, String str4, PRIORITY priority2, TASKTYPE tasktype, STATE state2, int i, String str5, String str6) {
        init(tasktype, i, str, str2, str3, str4, priority2.toString(), state2.toString(), str5, str6);
    }

    protected UASTask(TASKTYPE tasktype, int i, Element element) {
        TASKTYPE tasktype2 = tasktype;
        int i2 = i;
        init(tasktype2, i2, element.getAttribute(COTDETAIL_UID), element.getAttribute(COTDETAIL_USER), element.getAttribute(COTDETAIL_NAME), element.getAttribute("platform"), element.getAttribute(COTDETAIL_PRIORITY), element.getAttribute(COTDETAIL_STATE), element.getAttribute(COTDETAIL_COLOR), element.getAttribute(COTDETAIL_MODIFIED));
    }

    protected UASTask(TASKTYPE tasktype, int i, CotDetail cotDetail) {
        TASKTYPE tasktype2 = tasktype;
        int i2 = i;
        init(tasktype2, i2, cotDetail.getAttribute(COTDETAIL_UID), cotDetail.getAttribute(COTDETAIL_USER), cotDetail.getAttribute(COTDETAIL_NAME), cotDetail.getAttribute("platform"), cotDetail.getAttribute(COTDETAIL_PRIORITY), cotDetail.getAttribute(COTDETAIL_STATE), cotDetail.getAttribute(COTDETAIL_COLOR), cotDetail.getAttribute(COTDETAIL_MODIFIED));
    }

    private void init(TASKTYPE tasktype, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        PRIORITY priority2 = PRIORITY.NORMAL;
        if (str5 != null) {
            try {
                if (!str5.isEmpty()) {
                    priority2 = PRIORITY.valueOf(str5);
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        STATE state2 = STATE.RECEIVED;
        if (str6 != null) {
            try {
                if (!str6.isEmpty()) {
                    state2 = STATE.valueOf(str6);
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        this.uid = str;
        this.user = str2;
        this.name = str3;
        this.platform = str4;
        this.priority = priority2;
        this.taskType = tasktype;
        this.state = state2;
        this.taskTypeIcon = i;
        this.color = Utils.parseInt(str7, -1);
        if (str8 != null && str8.length() > 0) {
            try {
                this.lastModified = Long.parseLong(str8);
            } catch (NumberFormatException unused3) {
            }
        }
        this.isViewing = false;
    }

    public static UASTask buildTask(CotDetail cotDetail) {
        TASKTYPE taskTypeFromString = getTaskTypeFromString(cotDetail.getAttribute(COTDETAIL_TASKTYPE));
        if (taskTypeFromString != null) {
            int i = C21041.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[taskTypeFromString.ordinal()];
            if (i == 1) {
                return new RouteTask(cotDetail);
            }
            if (i == 2) {
                return new LTCLCFOVCenterTask(cotDetail);
            }
            if (i == 3) {
                return new QuickTask(cotDetail);
            }
            if (i == 4) {
                return new LTCLCRemoteTask(cotDetail);
            }
            if (i == 5) {
                return new LTCLCRemoteCancelTask(cotDetail);
            }
            UASToolDropDownReceiver.toast("Unable to build task - unknown task type: " + taskTypeFromString, 0);
        }
        return null;
    }

    /* renamed from: com.atakmap.android.uastool.tasks.UASTask$1 */
    /* synthetic */ class C21041 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r0 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r0
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.UASTask.C21041.<clinit>():void");
        }
    }

    public String getUID() {
        return this.uid;
    }

    public String getUser() {
        return this.user;
    }

    public PRIORITY getPriority() {
        return this.priority;
    }

    public void setPriority(PRIORITY priority2) {
        this.priority = priority2;
    }

    public static PRIORITY getPriorityFromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (PRIORITY priority2 : PRIORITY.values()) {
                if (str.trim().equals(priority2.name())) {
                    return priority2;
                }
            }
        }
        return null;
    }

    public TASKTYPE getTaskType() {
        return this.taskType;
    }

    public static TASKTYPE getTaskTypeFromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (TASKTYPE tasktype : TASKTYPE.values()) {
                if (str.trim().equals(tasktype.name())) {
                    return tasktype;
                }
            }
        }
        return null;
    }

    public STATE getState() {
        return this.state;
    }

    public void setState(STATE state2) {
        this.state = state2;
        if (state2 == STATE.STORED) {
            this.parentUasItem = null;
        }
        UASTaskStore.getInstance().saveTask(this);
        UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().refreshList(false);
    }

    public static STATE getStateFromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (STATE state2 : STATE.values()) {
                if (str.trim().equals(state2.name())) {
                    return state2;
                }
            }
        }
        return null;
    }

    public int getTaskTypeIcon() {
        return this.taskTypeIcon;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPlatformShort() {
        if (this.platform.length() <= 13) {
            return this.platform;
        }
        return this.platform.substring(0, 9) + "...";
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public String getDescription() {
        return this.name + " / " + this.platform + " / " + this.taskType.name();
    }

    public int compareTo(UASTask uASTask) {
        return getName().toUpperCase().compareTo(uASTask.getName().toUpperCase());
    }

    /* access modifiers changed from: protected */
    public CotDetail toCot(CotDetail cotDetail) {
        CotDetail cotDetail2 = new CotDetail(COTDETAIL_UASTASK);
        cotDetail2.setAttribute(COTDETAIL_UID, this.uid);
        cotDetail2.setAttribute(COTDETAIL_USER, this.user);
        cotDetail2.setAttribute(COTDETAIL_NAME, this.name);
        cotDetail2.setAttribute("platform", this.platform);
        cotDetail2.setAttribute(COTDETAIL_COLOR, String.valueOf(this.color));
        cotDetail2.setAttribute(COTDETAIL_TASKTYPE, this.taskType.name());
        cotDetail2.setAttribute(COTDETAIL_PRIORITY, this.priority.name());
        cotDetail2.setAttribute(COTDETAIL_STATE, this.state.name());
        if (this.lastModified == 0) {
            this.lastModified = System.currentTimeMillis();
        }
        cotDetail2.setAttribute(COTDETAIL_MODIFIED, String.valueOf(this.lastModified));
        cotDetail2.addChild(cotDetail);
        return cotDetail2;
    }

    public static UASTask fromCot(String str) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            parse.getDocumentElement().normalize();
            NodeList elementsByTagName = parse.getElementsByTagName(COTDETAIL_UASTASK);
            if (elementsByTagName.getLength() != 0) {
                return fromCot(elementsByTagName.item(0));
            }
            return null;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            String str2 = TAG;
            Log.d(str2, "Exception: " + e.getMessage());
            return null;
        }
    }

    public static UASTask fromCot(Node node) {
        if (node.getNodeType() != 1) {
            return null;
        }
        Element element = (Element) node;
        TASKTYPE taskTypeFromString = getTaskTypeFromString(element.getAttribute(COTDETAIL_TASKTYPE));
        if (taskTypeFromString == null) {
            return null;
        }
        int i = C21041.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[taskTypeFromString.ordinal()];
        if (i == 1) {
            return RouteTask.fromCot(element);
        }
        if (i == 2) {
            return LTCLCFOVCenterTask.fromCot(element);
        }
        if (i == 3) {
            return QuickTask.fromCot(element);
        }
        if (i == 4) {
            return LTCLCRemoteTask.fromCot(element);
        }
        if (i != 5) {
            return null;
        }
        return LTCLCRemoteCancelTask.fromCot(element);
    }

    public boolean matchesFilter(String[] strArr, TASKTYPE[] tasktypeArr, PRIORITY[] priorityArr, STATE[] stateArr) {
        if (strArr != null && strArr.length > 0 && !Arrays.asList(strArr).contains(this.platform)) {
            return false;
        }
        if (tasktypeArr != null && tasktypeArr.length > 0 && !Arrays.asList(tasktypeArr).contains(this.taskType)) {
            return false;
        }
        if (priorityArr != null && priorityArr.length > 0 && !Arrays.asList(priorityArr).contains(this.priority)) {
            return false;
        }
        if (stateArr == null || stateArr.length <= 0) {
            return true;
        }
        if ((!Arrays.asList(stateArr).contains(STATE.STORED) || !isDeleteOnCompletion()) && Arrays.asList(stateArr).contains(this.state)) {
            return true;
        }
        return false;
    }

    public UASTask copy(String str, boolean z) {
        UASToolDropDownReceiver.toast("Task type " + this.taskType + " has not yet implemented copy", 0);
        return null;
    }

    public boolean isViewing() {
        return this.isViewing;
    }

    public void view(UASPoint uASPoint, boolean z) {
        this.isViewing = true;
    }

    public void hide() {
        this.isViewing = false;
    }

    public void setTaskMessageUid(String str) {
        this.taskMessageUid = str;
    }

    public String getTaskMessageUid() {
        return this.taskMessageUid;
    }

    public void setTaskSourceUid(String str) {
        this.taskSourceUid = str;
    }

    public String getTaskSourceUid() {
        return this.taskSourceUid;
    }

    public void setDeleteOnCompletion(boolean z) {
        this.deleteOnCompletion = z;
    }

    public boolean isDeleteOnCompletion() {
        return this.deleteOnCompletion;
    }

    public void setQuickTaskType() {
        this.taskType = TASKTYPE.QUICKFLY;
    }
}
