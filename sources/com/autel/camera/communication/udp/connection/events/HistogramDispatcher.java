package com.autel.camera.communication.udp.connection.events;

import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.CameraRecMsgDecoder;
import com.autel.camera.protocol.protocol10.engine.HistogramInfo;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.util.log.AutelLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class HistogramDispatcher {
    private static final String TAG = "MessageDisPatcher";
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "data packet procsss thread #" + this.mCount.getAndIncrement());
            thread.setPriority(4);
            return thread;
        }
    };
    private static HistogramDispatcher s_instance;
    private ConcurrentHashMap<String, CallbackWithOneParam<HistogramInfo>> listenerManager = new ConcurrentHashMap<>();
    private ThreadPoolExecutor mProcsssThreadPool;

    private HistogramDispatcher() {
        initProcessThreadPool();
    }

    public static HistogramDispatcher instance() {
        if (s_instance == null) {
            s_instance = new HistogramDispatcher();
        }
        return s_instance;
    }

    private void initProcessThreadPool() {
        if (this.mProcsssThreadPool == null) {
            this.mProcsssThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, sThreadFactory);
        }
    }

    public void onDisPatchPacket(String str) {
        this.mProcsssThreadPool.execute(new ProcessPacketTask(str));
    }

    public void registerReceiveListener(String str, CallbackWithOneParam<HistogramInfo> callbackWithOneParam) {
        this.listenerManager.put(str, callbackWithOneParam);
    }

    public void unRegisterReceiveListener(String str) {
        this.listenerManager.remove(str);
    }

    private class ProcessPacketTask implements Runnable {
        private String msg;

        public ProcessPacketTask(String str) {
            this.msg = str;
        }

        public void run() {
            try {
                BaseCameraMsgParser baseCameraMsgParser = new BaseCameraMsgParser();
                baseCameraMsgParser.parserData(this.msg);
                HistogramInfo histogramInfo = new HistogramInfo();
                histogramInfo.setData(CameraRecMsgDecoder.getCameraHistoResult(baseCameraMsgParser.getParam(CameraConstant10.PARAM_HISTOGRAM)));
                histogramInfo.setPixels(baseCameraMsgParser.getIntParam(CameraConstant10.PARAM_PIXELS));
                HistogramDispatcher.this.dispatchPacket(CameraConstant10.setHistogramListener, histogramInfo);
            } catch (Exception e) {
                e.printStackTrace();
                AutelLog.m15084e(HistogramDispatcher.TAG, "ProcessPacketTask Exception----->>> " + e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchPacket(String str, HistogramInfo histogramInfo) {
        CallbackWithOneParam<HistogramInfo> callbackWithOneParam;
        if (histogramInfo != null && (callbackWithOneParam = this.listenerManager.get(str)) != null && (callbackWithOneParam instanceof CallbackWithOneParam)) {
            callbackWithOneParam.onSuccess(histogramInfo);
        }
    }
}
