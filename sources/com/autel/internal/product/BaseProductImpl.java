package com.autel.internal.product;

import com.autel.internal.AutelServiceVersion;
import com.autel.internal.album.AlbumFactory;
import com.autel.internal.album.AlbumService4Initialize;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.camera.CameraFactory;
import com.autel.internal.camera.product.CameraManagerService;
import com.autel.internal.video.CodecFactory;
import com.autel.internal.video.CodecService4Initialize;
import com.autel.sdk.album.AutelAlbum;
import com.autel.sdk.camera.AutelCameraManager;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.video.AutelCodec;

public abstract class BaseProductImpl implements BaseProduct {
    protected CameraManagerService cameraManager = CameraFactory.createCameraManager();
    protected AlbumService4Initialize productAlbum = AlbumFactory.createAlbum20();
    protected CodecService4Initialize productCodec = CodecFactory.createCodec();
    protected AutelServiceVersion serviceVersion;
    protected IAutelStateManager stateManager;

    public BaseProductImpl(IAutelStateManager iAutelStateManager) {
        this.stateManager = iAutelStateManager;
    }

    public AutelAlbum getAlbum() {
        return this.productAlbum;
    }

    public AutelCodec getCodec() {
        return this.productCodec;
    }

    public AutelCameraManager getCameraManager() {
        return this.cameraManager;
    }

    public void productConnected() {
        this.productAlbum.connect(this.serviceVersion);
        this.productCodec.connect(this.serviceVersion);
        this.cameraManager.connect(this.serviceVersion);
    }

    public void productDisconnect() {
        this.productAlbum.disconnect();
        this.productCodec.disconnect();
        this.cameraManager.disconnect();
    }

    public void productInit() {
        this.productAlbum.init(this.stateManager);
        this.productCodec.init(this.stateManager);
        this.cameraManager.init(this.stateManager);
    }

    public void productDestroy() {
        this.productAlbum.destroy();
        this.productCodec.destroy();
        this.cameraManager.destroy();
    }
}
