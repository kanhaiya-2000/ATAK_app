package com.atakmap.android.uastool.tasks.ltclc;

import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LTCLCFOVCenterTask extends UASTask {
    public static final String COTDETAIL_POINT = "point";
    private static final String COT_DETAIL_LABEL = "fovcentertask";
    private static final String TAG = "LTCLCFOVCenterTask";
    private static final int TASKTYPEICON = 2130968708;
    private GeoPoint point = null;

    public LTCLCFOVCenterTask(String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.STATE state) {
        super(str, str2, str3, str4, priority, UASTask.TASKTYPE.LTCLC_FOVCENTER, state, C1877R.drawable.task_ltclc, String.valueOf(-1));
    }

    public LTCLCFOVCenterTask(Element element) {
        super(UASTask.TASKTYPE.LTCLC_FOVCENTER, (int) C1877R.drawable.task_ltclc, element);
    }

    public LTCLCFOVCenterTask(CotDetail cotDetail) {
        super(UASTask.TASKTYPE.LTCLC_FOVCENTER, (int) C1877R.drawable.task_ltclc, cotDetail);
        CotDetail firstChildByName;
        CotDetail firstChildByName2 = cotDetail.getFirstChildByName(0, COT_DETAIL_LABEL);
        if (firstChildByName2 != null && (firstChildByName = firstChildByName2.getFirstChildByName(0, "point")) != null) {
            try {
                setPoint(new GeoPoint(Double.parseDouble(firstChildByName.getAttribute(UASPoint.COTDETAIL_LAT)), Double.parseDouble(firstChildByName.getAttribute(UASPoint.COTDETAIL_LON)), Double.parseDouble(firstChildByName.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, Double.parseDouble(firstChildByName.getAttribute(UASPoint.COTDETAIL_CE)), Double.parseDouble(firstChildByName.getAttribute(UASPoint.COTDETAIL_LE))));
            } catch (Exception e) {
                Log.d(TAG, "Failed to get point from FOVCenterTask cot: ", e);
            }
        }
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail(COT_DETAIL_LABEL);
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
        LTCLCFOVCenterTask lTCLCFOVCenterTask = new LTCLCFOVCenterTask(element);
        NodeList elementsByTagName = element.getElementsByTagName(COT_DETAIL_LABEL);
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                Node item2 = element.getElementsByTagName("point").item(0);
                if (item2.getNodeType() == 1) {
                    Element element3 = (Element) item2;
                    try {
                        lTCLCFOVCenterTask.setPoint(new GeoPoint(Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LAT)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LON)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_CE)), Double.parseDouble(element3.getAttribute(UASPoint.COTDETAIL_LE))));
                    } catch (Exception e) {
                        Log.d(TAG, "Failed to parse point from task CoT: ", e);
                    }
                }
            }
        }
        return lTCLCFOVCenterTask;
    }

    public GeoPoint getPoint() {
        return this.point;
    }

    public void setPoint(GeoPoint geoPoint) {
        this.point = geoPoint;
    }
}
