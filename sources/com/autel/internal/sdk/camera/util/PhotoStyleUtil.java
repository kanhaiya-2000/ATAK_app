package com.autel.internal.sdk.camera.util;

import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;

public class PhotoStyleUtil {
    public static PhotoStyle parserCustomPhotoStyle(String str) {
        PhotoStyle photoStyle = new PhotoStyle();
        photoStyle.type = PhotoStyleType.find(str);
        int i = C48961.$SwitchMap$com$autel$common$camera$media$PhotoStyleType[photoStyle.type.ordinal()];
        if (i == 1) {
            String[] split = str.replace(PhotoStyleType.Custom.value() + ",", "").split(",");
            if (split.length == 3) {
                photoStyle.contrast = Integer.valueOf(split[0]).intValue();
                photoStyle.saturation = Integer.valueOf(split[1]).intValue();
                photoStyle.sharpness = Integer.valueOf(split[2]).intValue();
            }
        } else if (i == 2) {
            photoStyle.contrast = 0;
            photoStyle.saturation = 0;
            photoStyle.sharpness = 0;
        } else if (i == 3) {
            photoStyle.contrast = 0;
            photoStyle.saturation = 0;
            photoStyle.sharpness = -1;
        } else if (i == 4) {
            photoStyle.contrast = 1;
            photoStyle.saturation = 0;
            photoStyle.sharpness = 1;
        }
        return photoStyle;
    }

    /* renamed from: com.autel.internal.sdk.camera.util.PhotoStyleUtil$1 */
    /* synthetic */ class C48961 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$PhotoStyleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.autel.common.camera.media.PhotoStyleType[] r0 = com.autel.common.camera.media.PhotoStyleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$media$PhotoStyleType = r0
                com.autel.common.camera.media.PhotoStyleType r1 = com.autel.common.camera.media.PhotoStyleType.Custom     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$PhotoStyleType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.media.PhotoStyleType r1 = com.autel.common.camera.media.PhotoStyleType.Standard     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$PhotoStyleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.media.PhotoStyleType r1 = com.autel.common.camera.media.PhotoStyleType.Soft     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$PhotoStyleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.camera.media.PhotoStyleType r1 = com.autel.common.camera.media.PhotoStyleType.Landscape     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.sdk.camera.util.PhotoStyleUtil.C48961.<clinit>():void");
        }
    }
}
