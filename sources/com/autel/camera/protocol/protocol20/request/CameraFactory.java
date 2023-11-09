package com.autel.camera.protocol.protocol20.request;

import com.autel.camera.protocol.protocol20.base.BaseCamera20;

public class CameraFactory {
    public static <T extends BaseCamera20> T getCameraProduct(Class<T> cls) {
        try {
            return (BaseCamera20) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
