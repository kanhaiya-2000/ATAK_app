package com.atakmap.android.uastool.tasks.ltclc;

import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoPoint;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LTCLCRemoteCancelTask extends UASTask {
    private static final String COT_DETAIL_LABEL = "ltclcremotecanceltask";
    private static final String TAG = "LTCLCRemoteCancelTask";
    private static final int TASKTYPEICON = 2130968710;

    public LTCLCRemoteCancelTask(String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.STATE state) {
        super(str, str2, str3, str4, priority, UASTask.TASKTYPE.LTCLC_CANCEL, state, C1877R.drawable.task_ltclc_toggle, String.valueOf(-1));
    }

    public LTCLCRemoteCancelTask(Element element) {
        super(UASTask.TASKTYPE.LTCLC_CANCEL, (int) C1877R.drawable.task_ltclc_toggle, element);
    }

    public LTCLCRemoteCancelTask(CotDetail cotDetail) {
        super(UASTask.TASKTYPE.LTCLC_CANCEL, (int) C1877R.drawable.task_ltclc_toggle, cotDetail);
    }

    public CotDetail toCot() {
        return super.toCot(new CotDetail(COT_DETAIL_LABEL));
    }

    public GeoPoint getFocusPoint() {
        return GeoPoint.ZERO_POINT;
    }

    public static LTCLCRemoteCancelTask fromCot(Element element) {
        LTCLCRemoteCancelTask lTCLCRemoteCancelTask = new LTCLCRemoteCancelTask(element);
        NodeList elementsByTagName = element.getElementsByTagName(COT_DETAIL_LABEL);
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
            }
        }
        return lTCLCRemoteCancelTask;
    }
}
