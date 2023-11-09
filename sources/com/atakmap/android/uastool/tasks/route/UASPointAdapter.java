package com.atakmap.android.uastool.tasks.route;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.ArrayList;
import java.util.Comparator;

public class UASPointAdapter extends ArrayAdapter<UASPoint> {
    private static final String TAG = "UASPointAdapter";
    /* access modifiers changed from: private */
    public LinearLayout expandedActions = null;
    /* access modifiers changed from: private */
    public ImageView expandedButton = null;
    private boolean isEnabled = true;
    private boolean isMultiMode = false;
    private final RouteTaskEdit myEditView;

    public UASPointAdapter(Context context, RouteTaskEdit routeTaskEdit, ArrayList<UASPoint> arrayList) {
        super(context, 0, arrayList);
        this.myEditView = routeTaskEdit;
        sort();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final UASPoint uASPoint = (UASPoint) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.uaspoint_layout, viewGroup, false);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C1877R.C1878id.routepoint_select);
        if (this.isMultiMode) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
        final CheckBox checkBox = (CheckBox) view.findViewById(C1877R.C1878id.routepoint_select_check);
        checkBox.setChecked(uASPoint.getSelected());
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                uASPoint.setSelected(checkBox.isChecked());
            }
        });
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(C1877R.C1878id.routepoint_actions);
        final ImageView imageView = (ImageView) view.findViewById(C1877R.C1878id.routepoint_expand);
        if (this.isMultiMode) {
            imageView.setVisibility(4);
            view.setOnClickListener((View.OnClickListener) null);
        } else {
            imageView.setVisibility(0);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (linearLayout.getVisibility() == 8) {
                        if (UASPointAdapter.this.expandedActions != null) {
                            UASPointAdapter.this.expandedActions.setVisibility(8);
                        }
                        if (UASPointAdapter.this.expandedButton != null) {
                            UASPointAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                        }
                        LinearLayout unused = UASPointAdapter.this.expandedActions = linearLayout;
                        ImageView unused2 = UASPointAdapter.this.expandedButton = imageView;
                        linearLayout.setVisibility(0);
                        imageView.setImageResource(C1877R.drawable.item_open);
                    } else if (linearLayout.getVisibility() == 0) {
                        linearLayout.setVisibility(8);
                        imageView.setImageResource(C1877R.drawable.item_closed);
                        LinearLayout unused3 = UASPointAdapter.this.expandedActions = null;
                        ImageView unused4 = UASPointAdapter.this.expandedButton = null;
                        linearLayout.setVisibility(8);
                        imageView.setImageResource(C1877R.drawable.item_closed);
                    }
                }
            });
        }
        ImageButton imageButton = (ImageButton) view.findViewById(C1877R.C1878id.routepoint_icon_button);
        imageButton.setImageDrawable(getContext().getResources().getDrawable(uASPoint.getIconId()));
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASPointAdapter.this.changePointType(uASPoint);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASPointAdapter.this.showHelp("Change Point Type", "Cycles between the different point types (e.g. WayPoint, OrbitPoint, etc)");
                return true;
            }
        });
        ((TextView) view.findViewById(C1877R.C1878id.routepoint_name)).setText(uASPoint.getName());
        ((TextView) view.findViewById(C1877R.C1878id.routepoint_desc)).setText(uASPoint.getDescription(this.myEditView.getPlatform()));
        ImageButton imageButton2 = (ImageButton) linearLayout.findViewById(C1877R.C1878id.routepoint_edit_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASPointAdapter.this.editPoint(uASPoint);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASPointAdapter.this.showHelp("Edit Point", "Allows the user to edit the values of this point");
                return true;
            }
        });
        ImageButton imageButton3 = (ImageButton) linearLayout.findViewById(C1877R.C1878id.routepoint_copy_button);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASPointAdapter.this.copyPoint(uASPoint);
            }
        });
        imageButton3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASPointAdapter.this.showHelp("Copy Point", "Copies this point and all its values into a new point (new point will be added directly after this point in the execution order)");
                return true;
            }
        });
        ImageButton imageButton4 = (ImageButton) linearLayout.findViewById(C1877R.C1878id.routepoint_delete_button);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASPointAdapter.this.deletePoint(uASPoint);
            }
        });
        imageButton4.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASPointAdapter.this.showHelp("Delete Point", "Deletes this point from the route");
                return true;
            }
        });
        return view;
    }

    /* access modifiers changed from: protected */
    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public boolean isEnabled(int i) {
        return this.isEnabled;
    }

    /* access modifiers changed from: private */
    public void changePointType(UASPoint uASPoint) {
        this.myEditView.askChangePointType(uASPoint);
    }

    private void moveDown(UASPoint uASPoint) {
        this.myEditView.moveDown(uASPoint);
    }

    private void moveUp(UASPoint uASPoint) {
        this.myEditView.moveUp(uASPoint);
    }

    /* access modifiers changed from: private */
    public void editPoint(UASPoint uASPoint) {
        this.myEditView.editPoint(uASPoint);
    }

    /* access modifiers changed from: private */
    public void copyPoint(UASPoint uASPoint) {
        this.myEditView.askCopyPoint(uASPoint);
    }

    /* access modifiers changed from: private */
    public void deletePoint(UASPoint uASPoint) {
        this.myEditView.askDeletePoint(uASPoint);
    }

    public void refresh() {
        ((Activity) UASToolDropDownReceiver.getInstance().getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (UASPointAdapter.this.expandedActions != null) {
                    UASPointAdapter.this.expandedActions.setVisibility(8);
                }
                if (UASPointAdapter.this.expandedButton != null) {
                    UASPointAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                }
                LinearLayout unused = UASPointAdapter.this.expandedActions = null;
                ImageView unused2 = UASPointAdapter.this.expandedButton = null;
                UASPointAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void sort() {
        sort(new Comparator<UASPoint>() {
            public int compare(UASPoint uASPoint, UASPoint uASPoint2) {
                return uASPoint.compareTo(uASPoint2);
            }
        });
    }

    public void showMultiSelect(boolean z) {
        this.isMultiMode = z;
        refresh();
    }

    public UASPoint getPoint(int i) {
        return (UASPoint) getItem(i);
    }

    public void selectAll() {
        boolean z;
        int i = 0;
        while (true) {
            if (i >= getCount()) {
                z = false;
                break;
            } else if (((UASPoint) getItem(i)).getSelected()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        for (int i2 = 0; i2 < getCount(); i2++) {
            ((UASPoint) getItem(i2)).setSelected(!z);
        }
        refresh();
    }

    public ArrayList<UASPoint> getSelectedPoints() {
        ArrayList<UASPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            UASPoint uASPoint = (UASPoint) getItem(i);
            if (uASPoint.getSelected()) {
                arrayList.add(uASPoint);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }
}
