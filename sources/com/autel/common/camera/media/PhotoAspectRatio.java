package com.autel.common.camera.media;

import com.autel.common.camera.CameraProduct;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum PhotoAspectRatio {
    Aspect_16_9("4000*2250 (16:9)", "5376x3024", "4000x2250", "5472x3078", "7680x4320", "5472x3648", "7680x4320"),
    Aspect_4_3("4000*3000 (4:3)", "4864x3648", "4000x3000", "4864x3648", "8000x6000", "", "8000x6000"),
    Aspect_4_3_xt("", "", "", "", "4000x3000", "", "4000x3000"),
    Aspect_3_2("", "5376x3584", "", "5472x3648", "", "5472x3076", ""),
    Aspect_16_9_HDR("", "", "", "", "3840x2160", "3840x2160", "3840x2160"),
    Aspect_2720_1528("", "", "", "", "2720x1528", "", "2720x1528"),
    Aspect_1920_1080("", "", "", "", "1920x1080", "", "1920x1080"),
    Aspect_1280_720("", "", "", "", "", "", "1280x720"),
    Aspect_640_512("", "", "", "", "", "", "640x512"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private String currentStr;
    private String r12;
    private String xb008;
    private String xb015;
    private String xb016;
    private String xt701;
    private String xt705;
    private String xt706;

    private PhotoAspectRatio(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.r12 = str;
        this.xb008 = str2;
        this.xb015 = str3;
        this.xb016 = str4;
        this.xt701 = str5;
        this.xt705 = str6;
        this.xt706 = str7;
    }

    public void setCurrentValue(String str) {
        this.currentStr = str;
    }

    public String toFormat() {
        return this.currentStr;
    }

    /* renamed from: com.autel.common.camera.media.PhotoAspectRatio$1 */
    /* synthetic */ class C26991 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$CameraProduct = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.autel.common.camera.CameraProduct[] r0 = com.autel.common.camera.CameraProduct.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$CameraProduct = r0
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.R12     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XB015     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT701     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT705     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x003e }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT706     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT709     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.common.camera.media.PhotoAspectRatio.C26991.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r1.xt706.equals(r3) != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (r1.xt705.equals(r3) != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d1, code lost:
        if (r1.xt701.equals(r3) != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e7, code lost:
        if (r1.xb015.equals(r3) != false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
        if (r1.r12.equals(r3) != false) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.autel.common.camera.media.PhotoAspectRatio find(java.lang.String r3, com.autel.common.camera.CameraProduct r4) {
        /*
            com.autel.common.camera.media.PhotoAspectRatio r0 = UNKNOWN
            int[] r1 = com.autel.common.camera.media.PhotoAspectRatio.C26991.$SwitchMap$com$autel$common$camera$CameraProduct
            int r2 = r4.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x00ea;
                case 2: goto L_0x00d4;
                case 3: goto L_0x0092;
                case 4: goto L_0x006f;
                case 5: goto L_0x000f;
                case 6: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0101
        L_0x000f:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001b
            goto L_0x00f4
        L_0x001b:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0027
            goto L_0x00f4
        L_0x0027:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9_HDR
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0033
            goto L_0x00f4
        L_0x0033:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_640_512
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x003f
            goto L_0x00f4
        L_0x003f:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3_xt
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004b
            goto L_0x00f4
        L_0x004b:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_1920_1080
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0057
            goto L_0x00f4
        L_0x0057:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_1280_720
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0063
            goto L_0x00f4
        L_0x0063:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_2720_1528
            java.lang.String r2 = r1.xt706
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0101
            goto L_0x00f4
        L_0x006f:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x007b
            goto L_0x00f4
        L_0x007b:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_3_2
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0087
            goto L_0x00f4
        L_0x0087:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9_HDR
            java.lang.String r2 = r1.xt705
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0101
            goto L_0x00f4
        L_0x0092:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x009d
            goto L_0x00f4
        L_0x009d:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00a8
            goto L_0x00f4
        L_0x00a8:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9_HDR
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b3
            goto L_0x00f4
        L_0x00b3:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3_xt
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00be
            goto L_0x00f4
        L_0x00be:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_2720_1528
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c9
            goto L_0x00f4
        L_0x00c9:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_1920_1080
            java.lang.String r2 = r1.xt701
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0101
            goto L_0x00f4
        L_0x00d4:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.xb015
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00df
            goto L_0x00f4
        L_0x00df:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3
            java.lang.String r2 = r1.xb015
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0101
            goto L_0x00f4
        L_0x00ea:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.r12
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f6
        L_0x00f4:
            r0 = r1
            goto L_0x0101
        L_0x00f6:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3
            java.lang.String r2 = r1.r12
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0101
            goto L_0x00f4
        L_0x0101:
            java.lang.String r3 = r0.value(r4)
            r0.setCurrentValue(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.common.camera.media.PhotoAspectRatio.find(java.lang.String, com.autel.common.camera.CameraProduct):com.autel.common.camera.media.PhotoAspectRatio");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r1.xt706.equals(r3) != false) goto L_0x0107;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.autel.common.camera.media.PhotoAspectRatio find(java.lang.String r3) {
        /*
            com.autel.common.camera.media.PhotoAspectRatio r0 = UNKNOWN
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9
            java.lang.String r2 = r1.xb008
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.r12
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xb015
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0036
            goto L_0x0107
        L_0x0036:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3
            java.lang.String r2 = r1.xb008
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.r12
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xb015
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x006a
            goto L_0x0107
        L_0x006a:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_3_2
            java.lang.String r2 = r1.xb008
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.r12
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xb015
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x009e
            goto L_0x0107
        L_0x009e:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_16_9_HDR
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt705
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b9
            goto L_0x0107
        L_0x00b9:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_4_3_xt
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00cc
            goto L_0x0107
        L_0x00cc:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_2720_1528
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00df
            goto L_0x0107
        L_0x00df:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_1920_1080
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0107
            java.lang.String r2 = r1.xt701
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f2
            goto L_0x0107
        L_0x00f2:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_1280_720
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00fd
            goto L_0x0107
        L_0x00fd:
            com.autel.common.camera.media.PhotoAspectRatio r1 = Aspect_640_512
            java.lang.String r2 = r1.xt706
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0108
        L_0x0107:
            r0 = r1
        L_0x0108:
            r0.setCurrentValue(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.common.camera.media.PhotoAspectRatio.find(java.lang.String):com.autel.common.camera.media.PhotoAspectRatio");
    }

    public String value(CameraProduct cameraProduct) {
        switch (C26991.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()]) {
            case 1:
                return this.r12;
            case 2:
                return this.xb015;
            case 3:
                return this.xt701;
            case 4:
                return this.xt705;
            case 5:
            case 6:
                return this.xt706;
            default:
                return this.r12;
        }
    }
}
