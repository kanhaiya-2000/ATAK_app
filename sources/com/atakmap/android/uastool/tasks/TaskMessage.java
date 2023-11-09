package com.atakmap.android.uastool.tasks;

import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import java.text.SimpleDateFormat;

public class TaskMessage extends CotEvent {
    public static final String TASKMESSAGE_UID_TAG = "-UasTask-";
    private final UASItem uasItem;
    private final UASTask uasTask;

    public TaskMessage(UASItem uASItem, UASTask uASTask) {
        this.uasItem = uASItem;
        this.uasTask = uASTask;
        init();
    }

    private void init() {
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        setVersion("2.0");
        setUID(makeMessageUid());
        setType("t-c");
        setTime(coordinatedTime);
        setStart(coordinatedTime);
        setStale(coordinatedTime.addMilliseconds(3500));
        setHow("m-g");
        setQos("1-r-c");
        setPoint(CotPoint.ZERO);
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_flow-tags_");
        cotDetail2.setAttribute("uastask", coordinatedTime.toString());
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail("request");
        cotDetail3.setAttribute("notify", CotMapComponent.f());
        cotDetail3.setAttribute("_notifyUid", MapView.getDeviceUid());
        cotDetail3.setAttribute("to", this.uasItem.getParent().getUID());
        cotDetail.addChild(cotDetail3);
        cotDetail.addChild(this.uasTask.toCot());
        setDetail(cotDetail);
    }

    public static String makeMessageUid() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", LocaleUtil.getCurrent()).format(CoordinatedTime.currentDate());
        return MapView.getDeviceUid() + TASKMESSAGE_UID_TAG + format;
    }
}
