package com.autel.camera.protocol.protocol10.request;

import com.autel.camera.communication.udp.connection.events.HistogramDispatcher;
import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.HistogramInfo;
import com.autel.camera.protocol.protocol10.interfaces.r12.ICameraHistogram;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import java.util.concurrent.ConcurrentHashMap;

public class HistogramManager implements ICameraHistogram {
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, CallbackWithOneParam<HistogramInfo>> mapList;

    private HistogramManager() {
        this.mapList = new ConcurrentHashMap<>();
        initListener();
    }

    public static HistogramManager instance() {
        return HistogramManagerHolder.s_instance;
    }

    private static class HistogramManagerHolder {
        /* access modifiers changed from: private */
        public static final HistogramManager s_instance = new HistogramManager();

        private HistogramManagerHolder() {
        }
    }

    public void addHistogramListener(String str, CallbackWithOneParam<HistogramInfo> callbackWithOneParam) {
        if (!this.mapList.contains(str)) {
            this.mapList.put(str, callbackWithOneParam);
        }
    }

    public void removeHistogramListener(String str) {
        if (this.mapList.contains(str)) {
            this.mapList.remove(str);
        }
        if (this.mapList.isEmpty()) {
            HistogramDispatcher.instance().unRegisterReceiveListener(CameraConstant10.setHistogramListener);
        }
    }

    private void initListener() {
        HistogramDispatcher.instance().registerReceiveListener(CameraConstant10.setHistogramListener, new CallbackWithOneParam<HistogramInfo>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(HistogramInfo histogramInfo) {
                if (HistogramManager.this.mapList != null) {
                    for (CallbackWithOneParam onSuccess : HistogramManager.this.mapList.values()) {
                        onSuccess.onSuccess(histogramInfo);
                    }
                }
            }
        });
    }
}
