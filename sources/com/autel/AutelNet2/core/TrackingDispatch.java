package com.autel.AutelNet2.core;

import com.autel.AutelNet2.aircraft.visual.tracking.entity.UploadGoalArea;
import com.autel.AutelNet2.aircraft.visual.tracking.message.UploadGoalAreaPacket;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;

public class TrackingDispatch {
    /* access modifiers changed from: private */
    public TrackingListener listener;

    public interface TrackingListener {
        void receiverData(UploadGoalArea uploadGoalArea);
    }

    private TrackingDispatch() {
    }

    public static TrackingDispatch instance() {
        return TrackingDispatchHolder.s_instance;
    }

    static final class TrackingDispatchHolder {
        /* access modifiers changed from: private */
        public static final TrackingDispatch s_instance = new TrackingDispatch();

        TrackingDispatchHolder() {
        }
    }

    public void registerTrackingListener(TrackingListener trackingListener) {
        this.listener = trackingListener;
    }

    public void onDispatch(final UploadGoalAreaPacket uploadGoalAreaPacket) {
        if (this.listener != null) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    UploadGoalAreaPacket uploadGoalAreaPacket;
                    UploadGoalArea uploadGoalArea;
                    if (TrackingDispatch.this.listener != null && (uploadGoalAreaPacket = uploadGoalAreaPacket) != null && (uploadGoalArea = uploadGoalAreaPacket.getUploadGoalArea()) != null) {
                        TrackingDispatch.this.listener.receiverData(uploadGoalArea);
                    }
                }
            });
        }
    }
}
