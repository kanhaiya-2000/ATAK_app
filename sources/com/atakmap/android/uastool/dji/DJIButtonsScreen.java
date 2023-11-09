package com.atakmap.android.uastool.dji;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.DJIPreferenceFragment;
import com.atakmap.coremap.log.Log;

public class DJIButtonsScreen extends UASToolScreen {
    public static final String DJIBUTTON_C1 = "C1";
    public static final String DJIBUTTON_C2 = "C2";
    public static final String DJIBUTTON_FIVEDDOWN = "FIVE_D_DOWN";
    public static final String DJIBUTTON_FIVEDIN = "FIVE_D_IN";
    public static final String DJIBUTTON_FIVEDLEFT = "FIVE_D_LEFT";
    public static final String DJIBUTTON_FIVEDRIGHT = "FIVE_D_RIGHT";
    public static final String DJIBUTTON_FIVEDUP = "FIVE_D_UP";
    private static final String TAG = "DJIButtonsScreen";

    public DJIButtonsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        final SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        final String[] stringArray = this.pluginContext.getResources().getStringArray(C1877R.array.dji_cbutton_actions);
        final String[] stringArray2 = this.pluginContext.getResources().getStringArray(C1877R.array.dji_5dbutton_actions);
        String string = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_C1, stringArray[0]);
        final TextView textView = (TextView) findViewById(C1877R.C1878id.dji_button_c1);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView.setText(string);
        builder.setTitle("C1 Button Action");
        builder.setItems(stringArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(stringArray[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_C1, stringArray[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_C1, stringArray[i]);
            }
        });
        final AlertDialog create = builder.create();
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.show();
            }
        });
        String string2 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_C2, stringArray[0]);
        final TextView textView2 = (TextView) findViewById(C1877R.C1878id.dji_button_c2);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView2.setText(string2);
        builder2.setTitle("C2 Button Action");
        builder2.setItems(stringArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView2.setText(stringArray[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_C2, stringArray[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_C2, stringArray[i]);
            }
        });
        final AlertDialog create2 = builder2.create();
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create2.show();
            }
        });
        String string3 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP, stringArray2[0]);
        final TextView textView3 = (TextView) findViewById(C1877R.C1878id.dji_button_5dup);
        AlertDialog.Builder builder3 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView3.setText(string3);
        builder3.setTitle("5D Up Button Action");
        builder3.setItems(stringArray2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView3.setText(stringArray2[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP, stringArray2[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP, stringArray2[i]);
            }
        });
        final AlertDialog create3 = builder3.create();
        textView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create3.show();
            }
        });
        String string4 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN, stringArray2[0]);
        final TextView textView4 = (TextView) findViewById(C1877R.C1878id.dji_button_5ddown);
        AlertDialog.Builder builder4 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView4.setText(string4);
        builder4.setTitle("5D Down Button Action");
        builder4.setItems(stringArray2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView4.setText(stringArray2[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN, stringArray2[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN, stringArray2[i]);
            }
        });
        final AlertDialog create4 = builder4.create();
        textView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create4.show();
            }
        });
        String string5 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT, stringArray2[0]);
        final TextView textView5 = (TextView) findViewById(C1877R.C1878id.dji_button_5dleft);
        AlertDialog.Builder builder5 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView5.setText(string5);
        builder5.setTitle("5D Left Button Action");
        builder5.setItems(stringArray2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView5.setText(stringArray2[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT, stringArray2[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT, stringArray2[i]);
            }
        });
        final AlertDialog create5 = builder5.create();
        textView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create5.show();
            }
        });
        String string6 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT, stringArray2[0]);
        final TextView textView6 = (TextView) findViewById(C1877R.C1878id.dji_button_5dright);
        AlertDialog.Builder builder6 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView6.setText(string6);
        builder6.setTitle("5D Right Button Action");
        builder6.setItems(stringArray2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView6.setText(stringArray2[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT, stringArray2[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT, stringArray2[i]);
            }
        });
        final AlertDialog create6 = builder6.create();
        textView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create6.show();
            }
        });
        String string7 = defaultSharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN, stringArray2[0]);
        final TextView textView7 = (TextView) findViewById(C1877R.C1878id.dji_button_5din);
        AlertDialog.Builder builder7 = new AlertDialog.Builder(MapView.getMapView().getContext());
        textView7.setText(string7);
        builder7.setTitle("5D In Button Action");
        builder7.setItems(stringArray2, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                textView7.setText(stringArray2[i]);
                edit.putString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN, stringArray2[i]);
                edit.apply();
                DJIButtonsScreen.customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN, stringArray2[i]);
            }
        });
        final AlertDialog create7 = builder7.create();
        textView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create7.show();
            }
        });
    }

    public static void applyAllCustomButtons(SharedPreferences sharedPreferences, Context context) {
        String[] stringArray = context.getResources().getStringArray(C1877R.array.dji_cbutton_actions);
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_C1, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_C1, stringArray[0]));
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_C2, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_C2, stringArray[0]));
        String[] stringArray2 = context.getResources().getStringArray(C1877R.array.dji_5dbutton_actions);
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP, stringArray2[0]));
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN, stringArray2[0]));
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT, stringArray2[0]));
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT, stringArray2[0]));
        customizeButton(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN, sharedPreferences.getString(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN, stringArray2[0]));
    }

    protected static void customizeButton(String str, String str2) {
        String dJIButtonName = getDJIButtonName(str);
        if (!TextUtils.isEmpty(dJIButtonName)) {
            try {
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    serviceConnection.getService().actionCustom(dJIButtonName, str2);
                }
            } catch (RemoteException e) {
                Log.e(TAG, e.toString());
            }
        } else {
            UASToolDropDownReceiver.toast("Unknown button name: " + str, 1);
        }
    }

    private static String getDJIButtonName(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1565801157:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDDOWN)) {
                    c = 0;
                    break;
                }
                break;
            case -1565572960:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDLEFT)) {
                    c = 1;
                    break;
                }
                break;
            case -1282460509:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDRIGHT)) {
                    c = 2;
                    break;
                }
                break;
            case -996703129:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_C1)) {
                    c = 3;
                    break;
                }
                break;
            case -996703128:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_C2)) {
                    c = 4;
                    break;
                }
                break;
            case 1982726142:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDIN)) {
                    c = 5;
                    break;
                }
                break;
            case 1982726516:
                if (str.equals(DJIPreferenceFragment.DJIBUTTONS_PREF_FIVEDUP)) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return DJIBUTTON_FIVEDDOWN;
            case 1:
                return DJIBUTTON_FIVEDLEFT;
            case 2:
                return DJIBUTTON_FIVEDRIGHT;
            case 3:
                return DJIBUTTON_C1;
            case 4:
                return DJIBUTTON_C2;
            case 5:
                return DJIBUTTON_FIVEDIN;
            case 6:
                return DJIBUTTON_FIVEDUP;
            default:
                return null;
        }
    }

    public void destroy() {
        super.destroy();
    }
}
