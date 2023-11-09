package com.atakmap.android.uastool.tasks;

import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;

public class TaskResponse extends CotEvent {
    public static String TASKMESSAGE_UID_TAG = "-UasTask-";
    private RESPONSETYPE responseType;
    private final UASItem uasItem;
    private final UASTask uasTask;

    public enum RESPONSETYPE {
        DELIVERYRECEIPT("y-a-r"),
        ACCEPTED("y-a-w"),
        HOLDING("y-s-p"),
        EXECUTING("y-s-e"),
        SUCCESS("y-c-s"),
        DENIED("y-c-f-d"),
        CANCELLED("y-c-f");
        
        public final String value;

        private RESPONSETYPE(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }

        public static RESPONSETYPE fromValue(String str) {
            if (str == null) {
                return null;
            }
            for (RESPONSETYPE responsetype : values()) {
                if (responsetype.value.equals(str)) {
                    return responsetype;
                }
            }
            return null;
        }
    }

    public TaskResponse(UASItem uASItem, UASTask uASTask, RESPONSETYPE responsetype) {
        this.uasItem = uASItem;
        this.uasTask = uASTask;
        this.responseType = responsetype;
        init();
    }

    private void init() {
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        String taskMessageUid = this.uasTask.getTaskMessageUid();
        setVersion("2.0");
        setUID(taskMessageUid);
        setType(this.responseType.getValue());
        setTime(coordinatedTime);
        setStart(coordinatedTime);
        setStale(coordinatedTime.addMilliseconds(3500));
        setHow("m-g");
        setQos("1-r-c");
        setPoint(CotPoint.ZERO);
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_flow-tags_");
        cotDetail2.setAttribute("uastaskresponse", coordinatedTime.toString());
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail("request");
        cotDetail3.setAttribute("notify", CotMapComponent.f());
        cotDetail3.setAttribute("_notifyUid", MapView.getDeviceUid());
        UASItem uASItem = this.uasItem;
        if (!(uASItem == null || uASItem.getParent() == null)) {
            cotDetail3.setAttribute("to", this.uasItem.getParent().getUID());
        }
        cotDetail.addChild(cotDetail3);
        setDetail(cotDetail);
    }

    public void setResponseType(RESPONSETYPE responsetype) {
        this.responseType = responsetype;
    }
}
