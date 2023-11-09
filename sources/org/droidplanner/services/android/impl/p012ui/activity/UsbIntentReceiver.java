package org.droidplanner.services.android.impl.p012ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: org.droidplanner.services.android.impl.ui.activity.UsbIntentReceiver */
public class UsbIntentReceiver extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView(getApplicationContext());
        textView.setText("Accessing USB Device...");
        textView.setGravity(17);
        setContentView(textView, new ViewGroup.LayoutParams(-1, -1));
        handleIntent(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        finish();
    }
}
