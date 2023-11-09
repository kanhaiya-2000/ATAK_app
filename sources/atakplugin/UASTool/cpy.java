package atakplugin.UASTool;

import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;

class cpy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ cpx f4870a;

    cpy(cpx cpx) {
        this.f4870a = cpx;
    }

    public void run() {
        try {
            ArOverlayView operatorArOverlay = UASToolDropDownReceiver.getInstance().getOperatorArOverlay();
            GeoPoint centerPoint = operatorArOverlay.getCenterPoint();
            String c = cpx.f4859c;
            Log.d(c, "Center is: " + centerPoint);
            this.f4870a.m11983a(new cpu(centerPoint, operatorArOverlay.getFieldOfViewList()));
            this.f4870a.f4867i.postDelayed(this.f4870a.f4869k, 1000);
        } catch (Exception e) {
            Log.d(cpx.f4859c, "Error during KLV processing: ", e);
        }
    }
}
