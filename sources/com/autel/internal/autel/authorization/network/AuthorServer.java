package com.autel.internal.autel.authorization.network;

import atakplugin.UASTool.bqt;
import atakplugin.UASTool.brm;
import atakplugin.UASTool.brw;
import atakplugin.UASTool.bsb;
import atakplugin.UASTool.bsd;
import atakplugin.UASTool.bsh;
import com.autel.bean.authorization.ValidateBean;
import com.autel.common.CallbackWithOneParam;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.util.SignUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;

public class AuthorServer {
    private static final String authorServerUrlRelease = "https://app.autelrobotics.com/sdk/";
    private static final String authorServerUrlTest = "https://192.168.1.101/sdk/";
    Gson authorGson = new Gson();
    private bqt fetAuthorStateCall;
    brw okHttpClient = new brw.C0231a().mo3323c();
    private bsb validateRequest = null;

    public AuthorServer(bsb bsb) {
        this.validateRequest = bsb;
    }

    public void getAuthorState(CallbackWithOneParam<AuthorityState> callbackWithOneParam) {
        bqt bqt = this.fetAuthorStateCall;
        if (bqt != null) {
            bqt.mo3057c();
        }
        bqt a = this.okHttpClient.mo3060a(this.validateRequest);
        this.fetAuthorStateCall = a;
        if (a != null) {
            try {
                bsh b = a.mo3056b();
                if (b.mo3378c() == 200) {
                    postCall(callbackWithOneParam, (ValidateBean) this.authorGson.fromJson(b.mo3384h().mo3415g(), ValidateBean.class));
                } else if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelErrorUtil.createAuthorKeyFetchError("http server request bad for code : " + b.mo3378c()));
                }
            } catch (IOException e) {
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(AutelErrorUtil.createAuthorKeyFetchError(e.getMessage()));
                }
            }
        }
    }

    private void postCall(CallbackWithOneParam<AuthorityState> callbackWithOneParam, ValidateBean validateBean) {
        if (callbackWithOneParam != null) {
            if (validateBean.code == 1) {
                callbackWithOneParam.onSuccess(AuthorityState.find(validateBean.data.capabilities));
                return;
            }
            callbackWithOneParam.onFailure(AutelErrorUtil.createAuthorKeyFetchError(validateBean.code + validateBean.data.msg));
        }
    }

    public void cancelFetchAuthorState() {
        bqt bqt = this.fetAuthorStateCall;
        if (bqt != null) {
            bqt.mo3057c();
        }
    }

    public static class AuthorServerBuild {
        private String appId;
        private String appKey;
        private String appName;
        private String appVer;

        public AuthorServerBuild setAppId(String str) {
            this.appId = str;
            return this;
        }

        public AuthorServerBuild setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public AuthorServerBuild setAppName(String str) {
            this.appName = str;
            return this;
        }

        public AuthorServerBuild setAppVer(String str) {
            this.appVer = str;
            return this;
        }

        public AuthorServer build() {
            HashMap hashMap = new HashMap();
            hashMap.put("appId", this.appId);
            hashMap.put("appKey", this.appKey);
            hashMap.put("appVer", this.appVer);
            return new AuthorServer(new bsb.C0234a().mo3360a(AuthorServer.authorServerUrlRelease).mo3358a((bsd) new brm.C0224a().mo3157a("a", "validateAppkey").mo3157a("appId", this.appId).mo3157a("appKey", this.appKey).mo3157a("appVer", this.appVer).mo3157a("_sign", SignUtil.getSign(hashMap)).mo3158a()).mo3371d());
        }
    }
}
