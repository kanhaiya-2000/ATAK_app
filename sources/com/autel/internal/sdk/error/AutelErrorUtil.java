package com.autel.internal.sdk.error;

import com.autel.common.error.AutelError;
import com.autel.common.error.AutelErrorCode;

public class AutelErrorUtil {
    public static AutelError createCommandFailedError(String str) {
        return new AutelError(AutelErrorCode.COMMAND_FAILED, str);
    }

    public static AutelError createAlbumHttpFetchError(String str) {
        return new AutelError(AutelErrorCode.ALBUM_HTTP_FETCH_SERVER_FAILED, str);
    }

    public static AutelError createAuthorKeyFetchError(String str) {
        return new AutelError(AutelErrorCode.AUTHOR_KEY_FETCH_FAILED, str);
    }

    public static AutelError createAlbumParamsNullError(String str) {
        return new AutelError(AutelErrorCode.ALBUM_PARAMS_ARE_NULL, str);
    }
}
