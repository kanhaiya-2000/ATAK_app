package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.KeyBind;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ControllerPreference extends RelativeLayout {
    private static final String DIRPATH_KEYBINDS = (FileSystemUtils.getRoot().getPath() + File.separatorChar + "tools" + File.separatorChar + "uastool" + File.separator + "keybinds");
    private static final String KEYBINDS_FILE = "keybinds.json";
    public static final String PREFERENCE_KEY = "UASToolControllerPreference";
    private static final String TAG = "ControllerPreference";
    private static final int numControls = 16;
    private JoystickPreferenceListener joystickPreferenceListener;
    private final Context pluginContext;

    public ControllerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pluginContext = context;
    }

    public ControllerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    public ControllerPreference(Context context) {
        super(context);
        this.pluginContext = context;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setUpSpinners();
    }

    private void setUpSpinners() {
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this.pluginContext, C1877R.array.function_array, C1877R.layout.dark_spinner_item);
        createFromResource.setDropDownViewResource(C1877R.layout.dark_spinner_dropdown_item);
        TableLayout tableLayout = (TableLayout) findViewById(C1877R.C1878id.keybinding_table);
        JoystickPreferenceListener joystickPreferenceListener2 = new JoystickPreferenceListener(tableLayout, this, this.pluginContext);
        this.joystickPreferenceListener = joystickPreferenceListener2;
        tableLayout.setOnGenericMotionListener(joystickPreferenceListener2);
        findViewById(C1877R.C1878id.scroller).setOnGenericMotionListener(this.joystickPreferenceListener);
        findViewById(C1877R.C1878id.controller_image).setOnGenericMotionListener(this.joystickPreferenceListener);
        findViewById(C1877R.C1878id.controller_setup_btn).setOnGenericMotionListener(this.joystickPreferenceListener);
        ArrayList<KeyBind> loadKeyBindsFromJSON = loadKeyBindsFromJSON();
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            PluginSpinner childAt = tableRow.getChildAt(1);
            childAt.setAdapter(createFromResource);
            childAt.setOnGenericMotionListener(this.joystickPreferenceListener);
            int i2 = -1;
            String str = (String) tableRow.getTag();
            if (!FileSystemUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
            Iterator<KeyBind> it = loadKeyBindsFromJSON.iterator();
            while (it.hasNext()) {
                KeyBind next = it.next();
                if (i2 == next.getKey()) {
                    childAt.setSelection(getFunctionIndex(next.getFunction()));
                }
            }
        }
    }

    private ArrayList<KeyBind> getCurrentSpinnerSelections() {
        TableLayout tableLayout = (TableLayout) findViewById(C1877R.C1878id.keybinding_table);
        ArrayList<KeyBind> arrayList = new ArrayList<>();
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            arrayList.add(new KeyBind(Integer.parseInt((String) tableRow.getTag()), (String) tableRow.getChildAt(1).getSelectedItem()));
        }
        return arrayList;
    }

    private int getFunctionIndex(String str) {
        String[] stringArray = this.pluginContext.getResources().getStringArray(C1877R.array.function_array);
        for (int i = 0; i < stringArray.length; i++) {
            if (str.equals(stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public void resetKeyBindingTable() {
        TableLayout tableLayout = (TableLayout) findViewById(C1877R.C1878id.keybinding_table);
        Iterator<KeyBind> it = getDefaultKeyBinds().iterator();
        while (it.hasNext()) {
            KeyBind next = it.next();
            int key = next.getKey();
            switch (key) {
                case 19:
                    findViewById(C1877R.C1878id.dpad_up_spinner).setSelection(getFunctionIndex(next.getFunction()));
                    break;
                case 20:
                    findViewById(C1877R.C1878id.dpad_down_spinner).setSelection(getFunctionIndex(next.getFunction()));
                    break;
                case 21:
                    findViewById(C1877R.C1878id.dpad_left_spinner).setSelection(getFunctionIndex(next.getFunction()));
                    break;
                case 22:
                    findViewById(C1877R.C1878id.dpad_right_spinner).setSelection(getFunctionIndex(next.getFunction()));
                    break;
                default:
                    switch (key) {
                        case 96:
                            findViewById(C1877R.C1878id.a_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 97:
                            findViewById(C1877R.C1878id.b_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 98:
                            findViewById(C1877R.C1878id.pause_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 99:
                            findViewById(C1877R.C1878id.x_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 100:
                            findViewById(C1877R.C1878id.y_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 101:
                            findViewById(C1877R.C1878id.home_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 102:
                            findViewById(C1877R.C1878id.left_bumper_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 103:
                            findViewById(C1877R.C1878id.right_bumper_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 104:
                            findViewById(C1877R.C1878id.left_trigger_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 105:
                            findViewById(C1877R.C1878id.right_trigger_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 106:
                            findViewById(C1877R.C1878id.right_analog_click_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 107:
                            findViewById(C1877R.C1878id.right_analog_click_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 108:
                            findViewById(C1877R.C1878id.start_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                        case 109:
                            findViewById(C1877R.C1878id.select_spinner).setSelection(getFunctionIndex(next.getFunction()));
                            break;
                    }
            }
        }
    }

    public void saveKeyBinds() {
        saveKeyBindsToJSON(getCurrentSpinnerSelections());
    }

    private void saveKeyBindsToJSON(ArrayList<KeyBind> arrayList) {
        Gson gson = new Gson();
        Log.d(TAG, gson.toJson((Object) arrayList));
        File file = new File(DIRPATH_KEYBINDS);
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        boolean z = false;
        boolean z2 = sharedPrefs.getBoolean(PREFERENCE_KEY, false);
        if (file.mkdirs()) {
            Log.d(TAG, "Dir created");
        }
        File file2 = new File(file, KEYBINDS_FILE);
        try {
            if (file2.createNewFile()) {
                UASToolDropDownReceiver.toast(file2.getPath() + " created");
            }
            FileWriter fileWriter = new FileWriter(file2);
            gson.toJson((Object) arrayList, (Appendable) fileWriter);
            fileWriter.close();
            UASToolDropDownReceiver.toast(file2.getPath() + " Updated");
            SharedPreferences.Editor edit = sharedPrefs.edit();
            if (!z2) {
                z = true;
            }
            edit.putBoolean(PREFERENCE_KEY, z).apply();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.atakmap.android.uastool.generic.KeyBind> loadKeyBindsFromJSON() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.atakmap.android.uastool.prefs.ControllerPreference$1 r1 = new com.atakmap.android.uastool.prefs.ControllerPreference$1
            r1.<init>()
            java.lang.reflect.Type r1 = r1.getType()
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x002d }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = DIRPATH_KEYBINDS     // Catch:{ Exception -> 0x002d }
            java.lang.String r6 = "keybinds.json"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x002d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.Object r1 = r2.fromJson((java.io.Reader) r3, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x002d }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x002d }
            r3.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x003a
        L_0x002b:
            r0 = move-exception
            goto L_0x0031
        L_0x002d:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0031:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "ControllerPreference"
            com.atakmap.coremap.log.Log.e(r2, r0)
        L_0x003a:
            boolean r0 = com.atakmap.coremap.filesystem.FileSystemUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x0044
            java.util.ArrayList r1 = getDefaultKeyBinds()
        L_0x0044:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.prefs.ControllerPreference.loadKeyBindsFromJSON():java.util.ArrayList");
    }

    private static ArrayList<KeyBind> getDefaultKeyBinds() {
        ArrayList<KeyBind> arrayList = new ArrayList<>();
        arrayList.add(new KeyBind(96, "PITCH DOWN"));
        arrayList.add(new KeyBind(97, "EMERGENCY STOP"));
        arrayList.add(new KeyBind(99, "RTL"));
        arrayList.add(new KeyBind(100, "PITCH UP"));
        arrayList.add(new KeyBind(19, "NO ACTION"));
        arrayList.add(new KeyBind(20, "NO ACTION"));
        arrayList.add(new KeyBind(21, "NO ACTION"));
        arrayList.add(new KeyBind(22, "NO ACTION"));
        arrayList.add(new KeyBind(105, "NO ACTION"));
        arrayList.add(new KeyBind(104, "MAPSHOT"));
        arrayList.add(new KeyBind(103, "NO ACTION"));
        arrayList.add(new KeyBind(102, "NO ACTION"));
        arrayList.add(new KeyBind(107, "NO ACTION"));
        arrayList.add(new KeyBind(106, "NO ACTION"));
        arrayList.add(new KeyBind(108, "NO ACTION"));
        arrayList.add(new KeyBind(109, "NO ACTION"));
        arrayList.add(new KeyBind(98, "NO ACTION"));
        arrayList.add(new KeyBind(101, "NO ACTION"));
        return arrayList;
    }

    public JoystickPreferenceListener getJoystickPreferenceListener() {
        return this.joystickPreferenceListener;
    }
}
