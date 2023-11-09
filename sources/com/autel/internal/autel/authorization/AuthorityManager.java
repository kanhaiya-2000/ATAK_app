package com.autel.internal.autel.authorization;

import android.content.Context;
import android.content.pm.PackageManager;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.authorization.network.AuthorServer;
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.util.jni.Utils;
import java.util.concurrent.atomic.AtomicBoolean;

public class AuthorityManager {
    private static AuthorityManager authorityManager = null;
    private static final long checkTimeLamps = 60000;
    private CheckKeyValidate checkKeyValidate;
    private long lastCheckTimeStamp;

    private AuthorityManager() {
    }

    public static synchronized AuthorityManager getInstance() {
        AuthorityManager authorityManager2;
        synchronized (AuthorityManager.class) {
            if (authorityManager == null) {
                authorityManager = new AuthorityManager();
            }
            authorityManager2 = authorityManager;
        }
        return authorityManager2;
    }

    public void notifyForValidateCheck() {
        CheckKeyValidate checkKeyValidate2 = this.checkKeyValidate;
        if (checkKeyValidate2 != null && !checkKeyValidate2.isStopped()) {
            this.checkKeyValidate.unlock();
        }
    }

    public synchronized void startCheckKeyValidateState(Context context, String str, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
        stopCheckKeyValidateState();
        CheckKeyValidate checkKeyValidate2 = new CheckKeyValidate(context, str, callbackWithOneParam);
        this.checkKeyValidate = checkKeyValidate2;
        checkKeyValidate2.start();
    }

    public synchronized void startCheckKeyValidateState(String str, String str2, String str3, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
        stopCheckKeyValidateState();
        ManualCheckKeyValidate manualCheckKeyValidate = new ManualCheckKeyValidate(str, str2, str3, callbackWithOneParam);
        this.checkKeyValidate = manualCheckKeyValidate;
        manualCheckKeyValidate.start();
    }

    public void stopCheckKeyValidateState() {
        CheckKeyValidate checkKeyValidate2 = this.checkKeyValidate;
        if (checkKeyValidate2 != null) {
            checkKeyValidate2.stopCheck();
        }
    }

    protected static class CheckKeyValidate extends Thread {
        private String appId;
        private String appKey;
        private String appVersion;
        private AuthorServer authorServer;
        /* access modifiers changed from: private */
        public CallbackWithOneParam<AuthorityState> callback;
        private final byte[] lock = new byte[0];
        private Context mContext;
        /* access modifiers changed from: private */
        public AtomicBoolean stopCheck = new AtomicBoolean(false);

        public CheckKeyValidate(String str, String str2, String str3, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
            this.callback = callbackWithOneParam;
            this.appKey = str2;
            this.appId = str;
            this.appVersion = str3;
        }

        public CheckKeyValidate(Context context, String str, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
            this.callback = callbackWithOneParam;
            this.appKey = str;
            this.mContext = context;
        }

        /* access modifiers changed from: protected */
        public void initAppInfo() {
            Context context = this.mContext;
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                try {
                    String packageName = this.mContext.getPackageName();
                    this.appId = packageName;
                    this.appVersion = packageManager.getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                this.mContext = null;
            }
        }

        public boolean isStopped() {
            return this.stopCheck.get();
        }

        public void stopCheck() {
            this.stopCheck.set(true);
            unlock();
        }

        public void run() {
            AuthorServer authorServer2;
            try {
                initAppInfo();
                if (autoApprove(this.appId)) {
                    this.stopCheck.set(true);
                    CallbackWithOneParam<AuthorityState> callbackWithOneParam = this.callback;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(AuthorityState.NORMAL);
                    }
                    if (authorServer2 == null) {
                        return;
                    }
                    return;
                }
                if (this.authorServer == null) {
                    this.authorServer = new AuthorServer.AuthorServerBuild().setAppId(this.appId).setAppKey(this.appKey).setAppVer(this.appVersion).build();
                }
                while (!this.stopCheck.get()) {
                    this.authorServer.getAuthorState(new CallbackWithOneParam<AuthorityState>() {
                        public void onSuccess(AuthorityState authorityState) {
                            CheckKeyValidate.this.stopCheck.set(true);
                            if (CheckKeyValidate.this.callback != null) {
                                CheckKeyValidate.this.callback.onSuccess(authorityState);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            if (CheckKeyValidate.this.callback != null) {
                                CheckKeyValidate.this.callback.onFailure(autelError);
                            }
                        }
                    });
                    lock(AuthorityManager.checkTimeLamps);
                }
                this.callback = null;
                this.mContext = null;
                AuthorServer authorServer3 = this.authorServer;
                if (authorServer3 != null) {
                    authorServer3.cancelFetchAuthorState();
                }
            } finally {
                this.callback = null;
                this.mContext = null;
                authorServer2 = this.authorServer;
                if (authorServer2 != null) {
                    authorServer2.cancelFetchAuthorState();
                }
            }
        }

        public void lock(long j) {
            try {
                if (!this.stopCheck.get()) {
                    synchronized (this.lock) {
                        this.lock.wait(j);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void unlock() {
            synchronized (this.lock) {
                this.lock.notify();
            }
        }

        private boolean autoApprove(String str) {
            return Utils.checkApp(str);
        }
    }

    private static class ManualCheckKeyValidate extends CheckKeyValidate {
        /* access modifiers changed from: protected */
        public void initAppInfo() {
        }

        public ManualCheckKeyValidate(String str, String str2, String str3, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
            super(str, str2, str3, callbackWithOneParam);
        }

        public ManualCheckKeyValidate(Context context, String str, CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
            super(context, str, callbackWithOneParam);
        }
    }
}
