package com.atakmap.android.uastool.tasks.ltclc;

import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.coords.GeoPoint;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LTCLCRemoteTask extends UASTask {
    private static final String COT_DETAIL_LABEL = "ltclcremotetask";
    private static final String TAG = "LTCLCRemoteTask";
    private static final int TASKTYPEICON = 2130968710;

    public LTCLCRemoteTask(String str, String str2, String str3, String str4, UASTask.PRIORITY priority, UASTask.STATE state) {
        super(str, str2, str3, str4, priority, UASTask.TASKTYPE.LTCLC_REMOTE, state, C1877R.drawable.task_ltclc_toggle, String.valueOf(-1));
    }

    public LTCLCRemoteTask(Element element) {
        super(UASTask.TASKTYPE.LTCLC_REMOTE, (int) C1877R.drawable.task_ltclc_toggle, element);
    }

    public LTCLCRemoteTask(CotDetail cotDetail) {
        super(UASTask.TASKTYPE.LTCLC_REMOTE, (int) C1877R.drawable.task_ltclc_toggle, cotDetail);
    }

    public CotDetail toCot() {
        return super.toCot(new CotDetail(COT_DETAIL_LABEL));
    }

    public GeoPoint getFocusPoint() {
        return GeoPoint.ZERO_POINT;
    }

    public static LTCLCRemoteTask fromCot(Element element) {
        LTCLCRemoteTask lTCLCRemoteTask = new LTCLCRemoteTask(element);
        NodeList elementsByTagName = element.getElementsByTagName(COT_DETAIL_LABEL);
        if (elementsByTagName.getLength() != 0) {
            Node item = elementsByTagName.item(0);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
            }
        }
        return lTCLCRemoteTask;
    }
}
