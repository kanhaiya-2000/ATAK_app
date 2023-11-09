package com.atakmap.android.uastool.mavlink;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class MavlinkOpButtonBar extends ButtonBar {
    public static final String TAG = "MavlinkOpButtonBar";
    private TextView armedTextView;
    private VideoUIButton buttonBarButton;
    private TextView modeTextView;

    public MavlinkOpButtonBar(Context context) {
        super(context);
    }

    public MavlinkOpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MavlinkOpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_mavlink_buttonbar);
        this.buttonBarButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MavlinkOpButtonBar.this.toggleCameraBar();
            }
        });
        C15632 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                View inflate = LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.mavlink_mode_selector, (ViewGroup) null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setView(inflate);
                final PluginSpinner findViewById = inflate.findViewById(C1877R.C1878id.mavlink_mode_spinner);
                MavlinkOpButtonBar mavlinkOpButtonBar = MavlinkOpButtonBar.this;
                mavlinkOpButtonBar.populateMavLinkModes(findViewById, ((MAVLinkUASItem) mavlinkOpButtonBar.uasItem).getModeString());
                builder.setTitle("Change Mode:");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MAVLinkUASItem) MavlinkOpButtonBar.this.uasItem).setMode(((TextView) findViewById.getSelectedView()).getText().toString());
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        };
        TextView textView = (TextView) findViewById(C1877R.C1878id.bottom_op_mavlink_mode_status);
        this.modeTextView = textView;
        textView.setOnClickListener(r0);
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.bottom_op_mavlink_status);
        this.armedTextView = textView2;
        textView2.setOnClickListener(r0);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.buttonBarButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateOSD() {
        super.updateOSD();
    }

    public void onAccessoryChange() {
        updateButtons();
    }

    private void updateButtons() {
        MAVLinkUASItem mAVLinkUASItem = (MAVLinkUASItem) this.uasItem;
        final boolean isArmed = mAVLinkUASItem.isArmed();
        final String modeString = mAVLinkUASItem.getModeString();
        final boolean gimbalLockOn = mAVLinkUASItem.getGimbalLockOn();
        final VideoUIButton gimbalLockButton = getGimbalLockButton();
        final Context pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00a7  */
            /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar r0 = com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar.this
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton r0 = r0.getArmButton()
                    com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar r1 = com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar.this
                    android.widget.TextView r1 = r1.getArmedTextView()
                    com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar r2 = com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar.this
                    android.widget.TextView r2 = r2.getModeTextView()
                    android.content.Context r3 = r3
                    r4 = 2131361800(0x7f0a0008, float:1.8343363E38)
                    java.lang.String r3 = r3.getString(r4)
                    android.content.Context r5 = r3
                    r6 = 2131361831(0x7f0a0027, float:1.8343425E38)
                    java.lang.String r5 = r5.getString(r6)
                    java.lang.String r7 = r4
                    r8 = 1
                    if (r7 == 0) goto L_0x003e
                    java.lang.CharSequence r9 = r2.getText()
                    java.lang.String r9 = r9.toString()
                    boolean r7 = r7.endsWith(r9)
                    if (r7 != 0) goto L_0x003e
                    java.lang.String r7 = r4
                    r2.setText(r7)
                    r2 = 1
                    goto L_0x003f
                L_0x003e:
                    r2 = 0
                L_0x003f:
                    boolean r7 = r5
                    if (r7 == 0) goto L_0x006f
                    java.lang.CharSequence r7 = r1.getText()
                    java.lang.String r7 = r7.toString()
                    boolean r3 = r3.equals(r7)
                    if (r3 != 0) goto L_0x006f
                    android.content.Context r2 = r3
                    r3 = 2130968669(0x7f04005d, float:1.7545998E38)
                    android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
                    if (r0 == 0) goto L_0x005f
                    r0.setImageDrawable(r2)
                L_0x005f:
                    android.content.Context r0 = r3
                    java.lang.String r0 = r0.getString(r4)
                    r1.setText(r0)
                    r0 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
                    r1.setTextColor(r0)
                    goto L_0x0099
                L_0x006f:
                    java.lang.CharSequence r3 = r1.getText()
                    java.lang.String r3 = r3.toString()
                    boolean r3 = r5.equals(r3)
                    if (r3 != 0) goto L_0x009a
                    android.content.Context r2 = r3
                    r3 = 2130968668(0x7f04005c, float:1.7545996E38)
                    android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
                    if (r0 == 0) goto L_0x008b
                    r0.setImageDrawable(r2)
                L_0x008b:
                    android.content.Context r0 = r3
                    java.lang.String r0 = r0.getString(r6)
                    r1.setText(r0)
                    r0 = -65536(0xffffffffffff0000, float:NaN)
                    r1.setTextColor(r0)
                L_0x0099:
                    r2 = 1
                L_0x009a:
                    com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton r0 = r6
                    if (r0 == 0) goto L_0x00a4
                    boolean r1 = r7
                    r0.setOn(r1)
                    goto L_0x00a5
                L_0x00a4:
                    r8 = r2
                L_0x00a5:
                    if (r8 == 0) goto L_0x00ac
                    com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar r0 = com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar.this
                    r0.invalidate()
                L_0x00ac:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.mavlink.MavlinkOpButtonBar.C15663.run():void");
            }
        });
    }

    public VideoUIButton getArmButton() {
        if (this.videoUIView.getSideBar() != null) {
            return (VideoUIButton) this.videoUIView.getSideBar().findViewById(C1877R.C1878id.mavlink_arm_button);
        }
        return null;
    }

    public VideoUIButton getGimbalLockButton() {
        if (this.videoUIView.getSideBar() != null) {
            return (VideoUIButton) this.videoUIView.getSideBar().findViewById(C1877R.C1878id.mavlink_gimbal_lock_button);
        }
        return null;
    }

    public TextView getModeTextView() {
        return this.modeTextView;
    }

    public TextView getArmedTextView() {
        return this.armedTextView;
    }

    /* access modifiers changed from: private */
    public void toggleCameraBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_mavlink_buttonbar));
    }

    /* access modifiers changed from: private */
    public void populateMavLinkModes(PluginSpinner pluginSpinner, String str) {
        String[] modes = ((MAVLinkUASItem) this.uasItem).getModes();
        ArrayAdapter arrayAdapter = new ArrayAdapter(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, modes);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i = 0; i < modes.length; i++) {
                if (str.equals(modes[i])) {
                    pluginSpinner.setSelection(i);
                }
            }
        }
        if (str != null) {
            for (int i2 = 0; i2 < modes.length; i2++) {
                if (str.equals(modes[i2])) {
                    pluginSpinner.setSelection(i2);
                }
            }
        }
    }
}
