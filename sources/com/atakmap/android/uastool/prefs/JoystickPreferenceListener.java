package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.atakmap.android.uastool.MAVLink.enums.ESTIMATOR_STATUS_FLAGS;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;

public class JoystickPreferenceListener implements View.OnGenericMotionListener, View.OnKeyListener {
    private final String TAG = "JoystickPreferenceListener";
    private boolean dPadDownHighlighted = false;
    private boolean dPadLeftHighlighted = false;
    private boolean dPadRightHighlighted = false;
    private boolean dPadUpHighlighted = false;
    private final TableLayout keyBindTable;
    private final View layout;
    private boolean leftTrigHighlighted = false;
    private final Context pluginContext;
    private boolean rightTrigHighlighted = false;

    public void dispose() {
    }

    public JoystickPreferenceListener(TableLayout tableLayout, View view, Context context) {
        this.keyBindTable = tableLayout;
        this.layout = view;
        this.pluginContext = context;
    }

    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16777232) == 16777232) {
            Log.d("JoystickPreferenceListener", "event action " + MotionEvent.actionToString(motionEvent.getAction()));
            if (motionEvent.getAxisValue(16) == -1.0f) {
                highlightRow(19);
                this.dPadUpHighlighted = true;
                return true;
            } else if (this.dPadUpHighlighted && motionEvent.getAxisValue(16) == 0.0f) {
                deHighlightRow(19);
                this.dPadUpHighlighted = false;
                return true;
            } else if (motionEvent.getAxisValue(16) == 1.0f) {
                highlightRow(20);
                this.dPadDownHighlighted = true;
                return true;
            } else if (this.dPadDownHighlighted && motionEvent.getAxisValue(16) == 0.0f) {
                deHighlightRow(20);
                this.dPadDownHighlighted = false;
                return true;
            } else if (motionEvent.getAxisValue(15) == -1.0f) {
                highlightRow(21);
                this.dPadLeftHighlighted = true;
                return true;
            } else if (this.dPadLeftHighlighted && motionEvent.getAxisValue(15) == 0.0f) {
                deHighlightRow(21);
                this.dPadLeftHighlighted = false;
                return true;
            } else if (motionEvent.getAxisValue(15) == 1.0f) {
                highlightRow(22);
                this.dPadRightHighlighted = true;
                return true;
            } else if (this.dPadRightHighlighted && motionEvent.getAxisValue(15) == 0.0f) {
                deHighlightRow(22);
                this.dPadRightHighlighted = false;
                return true;
            } else if (((double) motionEvent.getAxisValue(22)) == 1.0d) {
                highlightRow(105);
                this.rightTrigHighlighted = true;
                return true;
            } else if (this.rightTrigHighlighted && motionEvent.getAxisValue(22) == 0.0f) {
                deHighlightRow(105);
                this.rightTrigHighlighted = false;
                return true;
            } else if (((double) motionEvent.getAxisValue(23)) == 1.0d) {
                highlightRow(104);
                this.leftTrigHighlighted = true;
                return true;
            } else if (this.leftTrigHighlighted && motionEvent.getAxisValue(23) == 0.0f) {
                deHighlightRow(104);
                this.leftTrigHighlighted = false;
                return true;
            }
        }
        return false;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if ((keyEvent.getSource() & ESTIMATOR_STATUS_FLAGS.ESTIMATOR_STATUS_FLAGS_ENUM_END) != 1025) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            highlightRow(keyEvent.getKeyCode());
        }
        if (keyEvent.getAction() == 1) {
            deHighlightRow(keyEvent.getKeyCode());
        }
        if ((keyEvent.getSource() & 16777232) != 16777232 && (keyEvent.getSource() & 513) == 513) {
        }
        return true;
    }

    public void highlightRow(int i, int i2) {
        for (int i3 = 0; i3 < this.keyBindTable.getChildCount(); i3++) {
            TableRow tableRow = (TableRow) this.keyBindTable.getChildAt(i3);
            int i4 = -1;
            String str = (String) tableRow.getTag();
            if (!FileSystemUtils.isEmpty(str)) {
                i4 = Integer.parseInt(str);
            }
            if (i4 == i) {
                scrollTo(tableRow.getTop());
                tableRow.setBackgroundColor(i2);
            }
        }
    }

    public void highlightRow(int i) {
        highlightRow(i, this.pluginContext.getResources().getColor(C1877R.color.lightBlueALPHA));
    }

    public void deHighlightRow(int i) {
        highlightRow(i, 0);
    }

    private void scrollTo(int i) {
        this.keyBindTable.getParent().smoothScrollTo(0, i);
    }
}
