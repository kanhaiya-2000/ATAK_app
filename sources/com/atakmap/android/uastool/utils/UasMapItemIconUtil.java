package com.atakmap.android.uastool.utils;

import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.coremap.maps.assets.Icon;

public class UasMapItemIconUtil {

    public enum ICON_ANCHOR {
        TOP_LEFT(ICON_ANCHOR32.LEFT, ICON_ANCHOR32.TOP),
        TOP_CENTER(ICON_ANCHOR32.CENTER, ICON_ANCHOR32.TOP),
        TOP_RIGHT(ICON_ANCHOR32.RIGHT, ICON_ANCHOR32.TOP),
        MIDDLE_LEFT(ICON_ANCHOR32.LEFT, ICON_ANCHOR32.MIDDLE),
        MIDDLE_CENTER(ICON_ANCHOR32.CENTER, ICON_ANCHOR32.MIDDLE),
        MIDDLE_RIGHT(ICON_ANCHOR32.RIGHT, ICON_ANCHOR32.MIDDLE),
        BOTTOM_LEFT(ICON_ANCHOR32.LEFT, ICON_ANCHOR32.BOTTOM),
        BOTTOM_CENTER(ICON_ANCHOR32.CENTER, ICON_ANCHOR32.BOTTOM),
        BOTTOM_RIGHT(ICON_ANCHOR32.RIGHT, ICON_ANCHOR32.BOTTOM);
        

        /* renamed from: hz */
        final int f8424hz;

        /* renamed from: vt */
        final int f8425vt;

        private ICON_ANCHOR(ICON_ANCHOR32 icon_anchor32, ICON_ANCHOR32 icon_anchor322) {
            this.f8424hz = icon_anchor32.pix;
            this.f8425vt = icon_anchor322.pix;
        }
    }

    public enum ICON_ANCHOR32 {
        TOP(0),
        MIDDLE(16),
        BOTTOM(32),
        LEFT(0),
        CENTER(16),
        RIGHT(32);
        
        final int pix;

        private ICON_ANCHOR32(int i) {
            this.pix = i;
        }
    }

    public enum ICON_SIZE {
        SMALLER(16),
        SMALL(32),
        MEDIUM(48),
        LARGE(72);
        
        final int pix;

        private ICON_SIZE(int i) {
            this.pix = i;
        }
    }

    public static Icon buildIcon(int i, ICON_SIZE icon_size, ICON_ANCHOR icon_anchor, int i2) {
        Icon.Builder builder = new Icon.Builder();
        builder.setImageUri(0, "android.resource://" + SUASIntegratorMapComponent.getInstance().getPluginContext().getPackageName() + "/" + i);
        builder.setColor(0, i2);
        builder.setSize(icon_size.pix, icon_size.pix);
        builder.setAnchor(icon_anchor.f8424hz, icon_anchor.f8425vt);
        return builder.build();
    }

    public static Icon buildIcon(int i, ICON_SIZE icon_size, int i2, int i3, int i4) {
        Icon.Builder builder = new Icon.Builder();
        builder.setImageUri(0, "android.resource://" + SUASIntegratorMapComponent.getInstance().getPluginContext().getPackageName() + "/" + i);
        builder.setColor(0, i4);
        builder.setSize(icon_size.pix, icon_size.pix);
        builder.setAnchor(i2, i3);
        return builder.build();
    }
}
