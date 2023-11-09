package com.atakmap.android.uastool.tasks;

import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QuickTask extends UASTask {
    public static final String COTDETAIL_POINT = "point";
    public static final String COTDETAIL_QUICKTASK_ACTION = "action";
    private static final String COT_DETAIL_LABEL = "quicktask";
    private static final String TAG = "QuickTask";
    private static final int TASKTYPEICON = 2130968691;
    public ACTION action;
    private double altitudeAgl;
    private boolean orbitClockwise;
    private double orbitRadius;
    private GeoPoint point;

    public void setAltitudeAgl(double d) {
        this.altitudeAgl = d;
    }

    public void setAction(ACTION action2) {
        this.action = action2;
    }

    public void setOrbitCW(boolean z) {
        this.orbitClockwise = z;
    }

    public enum ACTION {
        WAYPOINT(UasC2Event.WaypointDetail.detailName),
        ORBIT("orbitpoint"),
        ALTITUDE(UASPoint.COTDETAIL_ALT),
        QUICKSTOP("quickstop"),
        LAND("land"),
        TAKEOFF("takeoff"),
        RTH("return"),
        STOP("stop"),
        PAUSE("pause"),
        RESUME("resume");
        
        private static final Map map = null;
        private final String stringVal;

        static {
            int i;
            map = new HashMap();
            for (ACTION action : values()) {
                map.put(action.stringVal, action);
            }
        }

        private ACTION(String str) {
            this.stringVal = str;
        }

        public static ACTION fromCotValue(String str) {
            ACTION action = (ACTION) map.get(str);
            return action == null ? QUICKSTOP : action;
        }

        public String getCotValue() {
            return this.stringVal;
        }
    }

    public QuickTask(String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.STATE state) {
        super(str, str2, str3, str4, priority, UASTask.TASKTYPE.QUICKFLY, state, C1877R.drawable.routes, String.valueOf(TaskEdit.viewColor));
        this.point = null;
    }

    public QuickTask(Element element) {
        super(UASTask.TASKTYPE.QUICKFLY, (int) C1877R.drawable.routes, element);
        this.point = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuickTask(com.atakmap.coremap.cot.event.CotDetail r15) {
        /*
            r14 = this;
            com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r0 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY
            r1 = 2130968691(0x7f040073, float:1.7546043E38)
            r14.<init>((com.atakmap.android.uastool.tasks.UASTask.TASKTYPE) r0, (int) r1, (com.atakmap.coremap.cot.event.CotDetail) r15)
            r0 = 0
            r14.point = r0
            r0 = 0
            r14.orbitClockwise = r0
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r14.orbitRadius = r1
            com.atakmap.android.uastool.tasks.QuickTask$ACTION r3 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.QUICKSTOP
            r14.action = r3
            r14.altitudeAgl = r1
            java.lang.String r1 = "quicktask"
            com.atakmap.coremap.cot.event.CotDetail r15 = r15.getFirstChildByName(r0, r1)
            if (r15 == 0) goto L_0x00d3
            java.lang.String r1 = "action"
            java.lang.String r2 = r15.getAttribute(r1)
            if (r2 == 0) goto L_0x00d3
            java.lang.String r1 = r15.getAttribute(r1)
            com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.fromCotValue(r1)
            r14.action = r1
            if (r1 == 0) goto L_0x00d3
            int[] r1 = com.atakmap.android.uastool.tasks.QuickTask.C20921.$SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION
            com.atakmap.android.uastool.tasks.QuickTask$ACTION r2 = r14.action
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L_0x004c
            r2 = 2
            if (r1 == r2) goto L_0x0073
            r0 = 3
            if (r1 == r0) goto L_0x00c1
            r0 = 4
            if (r1 == r0) goto L_0x00c1
            goto L_0x00d3
        L_0x004c:
            java.lang.String r1 = "orbitRadius"
            java.lang.String r2 = r15.getAttribute(r1)
            if (r2 == 0) goto L_0x0073
            java.lang.String r1 = r15.getAttribute(r1)
            double r1 = java.lang.Double.parseDouble(r1)
            r14.orbitRadius = r1
            java.lang.String r1 = "orbitClockwise"
            java.lang.String r2 = r15.getAttribute(r1)
            if (r2 == 0) goto L_0x0071
            java.lang.String r1 = r15.getAttribute(r1)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            r14.orbitClockwise = r1
            goto L_0x0073
        L_0x0071:
            r14.orbitClockwise = r0
        L_0x0073:
            java.lang.String r1 = "point"
            com.atakmap.coremap.cot.event.CotDetail r0 = r15.getFirstChildByName(r0, r1)
            if (r0 == 0) goto L_0x00c1
            java.lang.String r1 = "latitude"
            java.lang.String r1 = r0.getAttribute(r1)     // Catch:{ Exception -> 0x00b9 }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r1 = "longitude"
            java.lang.String r1 = r0.getAttribute(r1)     // Catch:{ Exception -> 0x00b9 }
            double r5 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r1 = "altitude"
            java.lang.String r1 = r0.getAttribute(r1)     // Catch:{ Exception -> 0x00b9 }
            double r7 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r1 = "ce"
            java.lang.String r1 = r0.getAttribute(r1)     // Catch:{ Exception -> 0x00b9 }
            double r10 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00b9 }
            java.lang.String r1 = "le"
            java.lang.String r0 = r0.getAttribute(r1)     // Catch:{ Exception -> 0x00b9 }
            double r12 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x00b9 }
            com.atakmap.coremap.maps.coords.GeoPoint r0 = new com.atakmap.coremap.maps.coords.GeoPoint     // Catch:{ Exception -> 0x00b9 }
            com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r9 = com.atakmap.coremap.maps.coords.GeoPoint.AltitudeReference.HAE     // Catch:{ Exception -> 0x00b9 }
            r2 = r0
            r2.<init>(r3, r5, r7, r9, r10, r12)     // Catch:{ Exception -> 0x00b9 }
            r14.setPoint(r0)     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00c1
        L_0x00b9:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Failed to get point from QuickTask cot: "
            com.atakmap.coremap.log.Log.d(r1, r2, r0)
        L_0x00c1:
            java.lang.String r0 = "agl"
            java.lang.String r1 = r15.getAttribute(r0)
            if (r1 == 0) goto L_0x00d3
            java.lang.String r15 = r15.getAttribute(r0)
            double r0 = java.lang.Double.parseDouble(r15)
            r14.altitudeAgl = r0
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.QuickTask.<init>(com.atakmap.coremap.cot.event.CotDetail):void");
    }

    /* renamed from: com.atakmap.android.uastool.tasks.QuickTask$1 */
    /* synthetic */ class C20921 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.tasks.QuickTask$ACTION[] r0 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION = r0
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.ORBIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.ALTITUDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.LAND     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.RTH     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r1 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.QUICKSTOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.QuickTask.C20921.<clinit>():void");
        }
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail(COT_DETAIL_LABEL);
        cotDetail.setAttribute("action", this.action.getCotValue());
        double d = this.orbitRadius;
        if (d > 0.0d) {
            cotDetail.setAttribute(OrbitPoint.COTDETAIL_ORBITRADIUS, String.valueOf(d));
            cotDetail.setAttribute(OrbitPoint.COTDETAIL_ORBITCLOCKWISE, Boolean.toString(this.orbitClockwise));
        }
        if (!Double.isNaN(this.altitudeAgl)) {
            cotDetail.setAttribute(UASPoint.COTDETAIL_AGL, String.valueOf(this.altitudeAgl));
        }
        if (this.point != null) {
            CotDetail cotDetail2 = new CotDetail("point");
            cotDetail2.setAttribute(UASPoint.COTDETAIL_LAT, String.valueOf(this.point.getLatitude()));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_LON, String.valueOf(this.point.getLongitude()));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_ALT, String.valueOf(this.point.getAltitude()));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_CE, String.valueOf(this.point.getCE()));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_LE, String.valueOf(this.point.getLE()));
            cotDetail.addChild(cotDetail2);
        }
        return super.toCot(cotDetail);
    }

    public GeoPoint getFocusPoint() {
        GeoPoint geoPoint = this.point;
        if (geoPoint != null) {
            return geoPoint;
        }
        return GeoPoint.ZERO_POINT;
    }

    public static UASTask fromCot(Element element) {
        QuickTask quickTask = new QuickTask(element);
        NodeList elementsByTagName = element.getElementsByTagName(COT_DETAIL_LABEL);
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getAttribute("action") != null) {
                    quickTask.action = ACTION.fromCotValue(element2.getAttribute("action"));
                }
                if (element2.getAttribute(UASPoint.COTDETAIL_AGL) != null) {
                    quickTask.altitudeAgl = Double.parseDouble(element2.getAttribute(UASPoint.COTDETAIL_AGL));
                }
                if (element2.getAttribute(OrbitPoint.COTDETAIL_ORBITRADIUS) != null) {
                    quickTask.orbitRadius = Double.parseDouble(element2.getAttribute(OrbitPoint.COTDETAIL_ORBITRADIUS));
                }
                Node item2 = element.getElementsByTagName("point").item(0);
                if (item2.getNodeType() == 1) {
                    Element element3 = (Element) item2;
                    try {
                        quickTask.setPoint(new GeoPoint(Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LAT)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LON)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_CE)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LE))));
                    } catch (Exception e) {
                        Log.d(TAG, "Failed to parse point from task CoT: ", e);
                    }
                }
            }
        }
        return quickTask;
    }

    public GeoPoint getPoint() {
        return this.point;
    }

    public void setPoint(GeoPoint geoPoint) {
        this.point = geoPoint;
    }

    public double getOrbitRadius() {
        return this.orbitRadius;
    }

    public void setOrbitRadius(double d) {
        this.orbitRadius = d;
    }

    public boolean isOrbitClockwise() {
        return this.orbitClockwise;
    }

    public boolean isOrbitTask() {
        return this.orbitRadius > 0.0d;
    }

    public double getAltitudeAgl() {
        return this.altitudeAgl;
    }
}
