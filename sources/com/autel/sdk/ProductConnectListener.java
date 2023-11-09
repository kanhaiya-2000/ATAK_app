package com.autel.sdk;

import com.autel.sdk.product.BaseProduct;

public interface ProductConnectListener {
    void productConnected(BaseProduct baseProduct);

    void productDisconnected();
}
