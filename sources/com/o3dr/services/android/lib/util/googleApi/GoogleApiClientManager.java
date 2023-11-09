package com.o3dr.services.android.lib.util.googleApi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiClientManager implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    /* access modifiers changed from: private */
    public static final String TAG = "GoogleApiClientManager";
    /* access modifiers changed from: private */
    public final AtomicBoolean isStarted;
    private ManagerListener listener;
    /* access modifiers changed from: private */
    public Handler mBgHandler;
    private HandlerThread mBgHandlerThread;
    private final Context mContext;
    private final Runnable mDriverRunnable = new Runnable() {
        public void run() {
            while (GoogleApiClientManager.this.isStarted.get()) {
                try {
                    if (!GoogleApiClientManager.this.mGoogleApiClient.isConnected()) {
                        GoogleApiClientManager.this.stop();
                    } else {
                        GoogleApiClientTask googleApiClientTask = (GoogleApiClientTask) GoogleApiClientManager.this.mTaskQueue.take();
                        if (googleApiClientTask != null) {
                            if (googleApiClientTask.mRunOnBackgroundThread) {
                                GoogleApiClientManager.this.mBgHandler.post(googleApiClientTask);
                            } else {
                                GoogleApiClientManager.this.mMainHandler.post(googleApiClientTask);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    Log.v(GoogleApiClientManager.TAG, e.getMessage(), e);
                    return;
                }
            }
        }
    };
    private Thread mDriverThread;
    /* access modifiers changed from: private */
    public final GoogleApiClient mGoogleApiClient;
    /* access modifiers changed from: private */
    public final Handler mMainHandler;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<GoogleApiClientTask> mTaskQueue;
    private final GoogleApiClientTask stopTask = new GoogleApiClientTask() {
        /* access modifiers changed from: protected */
        public void doRun() {
            GoogleApiClientManager.this.stop();
        }
    };

    public interface ManagerListener {
        void onGoogleApiConnectionError(ConnectionResult connectionResult);

        void onManagerStarted();

        void onManagerStopped();

        void onUnavailableGooglePlayServices(int i);
    }

    public void onConnectionSuspended(int i) {
    }

    public GoogleApiClientManager(Context context, Handler handler, Api<? extends Api.ApiOptions.NotRequiredOptions>[] apiArr) {
        this.isStarted = new AtomicBoolean(false);
        this.mTaskQueue = new LinkedBlockingQueue<>();
        this.mContext = context;
        this.mMainHandler = handler;
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(context);
        for (Api<? extends Api.ApiOptions.NotRequiredOptions> addApi : apiArr) {
            builder.addApi(addApi);
        }
        this.mGoogleApiClient = builder.addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    public void setManagerListener(ManagerListener managerListener) {
        this.listener = managerListener;
    }

    private void destroyBgHandler() {
        HandlerThread handlerThread = this.mBgHandlerThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.mBgHandlerThread.quit();
            this.mBgHandlerThread.interrupt();
            this.mBgHandlerThread = null;
        }
        this.mBgHandler = null;
    }

    private void destroyDriverThread() {
        Thread thread = this.mDriverThread;
        if (thread != null && thread.isAlive()) {
            this.mDriverThread.interrupt();
            this.mDriverThread = null;
        }
    }

    private void initializeBgHandler() {
        HandlerThread handlerThread = this.mBgHandlerThread;
        if (handlerThread == null || handlerThread.isInterrupted()) {
            HandlerThread handlerThread2 = new HandlerThread("GAC Manager Background Thread");
            this.mBgHandlerThread = handlerThread2;
            handlerThread2.start();
            this.mBgHandler = null;
        }
        if (this.mBgHandler == null) {
            this.mBgHandler = new Handler(this.mBgHandlerThread.getLooper());
        }
    }

    private void initializeDriverThread() {
        Thread thread = this.mDriverThread;
        if (thread == null || thread.isInterrupted()) {
            Thread thread2 = new Thread(this.mDriverRunnable, "GAC Manager Driver Thread");
            this.mDriverThread = thread2;
            thread2.start();
        }
    }

    public boolean addTask(GoogleApiClientTask googleApiClientTask) {
        if (!isStarted()) {
            Log.d(TAG, "GoogleApiClientManager is not started.");
            return false;
        }
        GoogleApiClient unused = googleApiClientTask.gApiClient = this.mGoogleApiClient;
        LinkedBlockingQueue unused2 = googleApiClientTask.taskQueue = this.mTaskQueue;
        boolean unused3 = googleApiClientTask.mRunOnBackgroundThread = false;
        return this.mTaskQueue.offer(googleApiClientTask);
    }

    public boolean addTaskToBackground(GoogleApiClientTask googleApiClientTask) {
        if (!isStarted()) {
            Log.d(TAG, "GoogleApiClientManager is not started.");
            return false;
        }
        GoogleApiClient unused = googleApiClientTask.gApiClient = this.mGoogleApiClient;
        LinkedBlockingQueue unused2 = googleApiClientTask.taskQueue = this.mTaskQueue;
        boolean unused3 = googleApiClientTask.mRunOnBackgroundThread = true;
        return this.mTaskQueue.offer(googleApiClientTask);
    }

    private boolean isStarted() {
        return this.isStarted.get();
    }

    public void start() {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable == 0) {
            this.mTaskQueue.clear();
            this.isStarted.set(true);
            if (this.mGoogleApiClient.isConnected()) {
                onConnected((Bundle) null);
            } else if (!this.mGoogleApiClient.isConnecting()) {
                this.mGoogleApiClient.connect();
            }
        } else {
            Log.e(TAG, "Google Play Services is unavailable.");
            ManagerListener managerListener = this.listener;
            if (managerListener != null) {
                managerListener.onUnavailableGooglePlayServices(isGooglePlayServicesAvailable);
            }
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        this.isStarted.set(false);
        destroyDriverThread();
        destroyBgHandler();
        this.mTaskQueue.clear();
        if (this.mGoogleApiClient.isConnected() || this.mGoogleApiClient.isConnecting()) {
            this.mGoogleApiClient.disconnect();
        }
        ManagerListener managerListener = this.listener;
        if (managerListener != null) {
            managerListener.onManagerStopped();
        }
    }

    public void stopSafely() {
        addTask(this.stopTask);
    }

    public void onConnected(Bundle bundle) {
        initializeBgHandler();
        initializeDriverThread();
        ManagerListener managerListener = this.listener;
        if (managerListener != null) {
            managerListener.onManagerStarted();
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        ManagerListener managerListener = this.listener;
        if (managerListener != null) {
            managerListener.onGoogleApiConnectionError(connectionResult);
        }
        stop();
    }

    public static abstract class GoogleApiClientTask implements Runnable {
        /* access modifiers changed from: private */
        public GoogleApiClient gApiClient;
        /* access modifiers changed from: private */
        public boolean mRunOnBackgroundThread = false;
        /* access modifiers changed from: private */
        public LinkedBlockingQueue<GoogleApiClientTask> taskQueue;

        /* access modifiers changed from: protected */
        public abstract void doRun();

        /* access modifiers changed from: protected */
        public GoogleApiClient getGoogleApiClient() {
            return this.gApiClient;
        }

        public void run() {
            if (!this.gApiClient.isConnected()) {
                this.taskQueue.offer(this);
            } else {
                doRun();
            }
        }
    }
}
