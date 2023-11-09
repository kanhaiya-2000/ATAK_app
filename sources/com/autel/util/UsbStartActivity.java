package com.autel.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.autel.common.product.AutelConstant;

public class UsbStartActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        sendBroadcast(new Intent(AutelConstant.USB_ACCESSORY_ATTACHED));
        finish();
    }
}
