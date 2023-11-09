package com.autel.internal.video;

import android.os.Handler;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.sdk.video.AutelCodecListener;

public class CodecInitializeProxy extends AutelInitializeProxy implements CodecService4Initialize {
    private CodecService codecService;

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void setCodecListener(AutelCodecListener autelCodecListener, Handler handler) {
        CodecService codecService2 = this.codecService;
        if (codecService2 != null) {
            codecService2.setCodecListener(autelCodecListener, handler);
        }
    }

    public void cancel() {
        CodecService codecService2 = this.codecService;
        if (codecService2 != null) {
            codecService2.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isProductConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_CAMERA : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CodecService createCodec = CodecFactory.createCodec(autelServiceVersion);
        this.codecService = createCodec;
        return createCodec;
    }
}
