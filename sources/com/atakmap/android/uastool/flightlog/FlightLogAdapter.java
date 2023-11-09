package com.atakmap.android.uastool.flightlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.List;

public class FlightLogAdapter extends ArrayAdapter<String> {
    private static final String TAG = "FlightLogAdapter";
    private final Context context;
    /* access modifiers changed from: private */
    public LinearLayout expandedActions = null;
    /* access modifiers changed from: private */
    public ImageView expandedButton = null;
    /* access modifiers changed from: private */
    public LinearLayout expandedView = null;
    /* access modifiers changed from: private */
    public final FlightLogScreen myScreen;

    public FlightLogAdapter(Context context2, FlightLogScreen flightLogScreen, List<String> list) {
        super(context2, 0, list);
        this.context = context2;
        this.myScreen = flightLogScreen;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final String str = (String) getItem(i);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(C1877R.layout.flight_log_item, viewGroup, false);
        }
        ((TextView) view.findViewById(C1877R.C1878id.flightlog_item_name)).setText(convertNameToTitle(str));
        final ImageView imageView = (ImageView) view.findViewById(C1877R.C1878id.flightlog_item_expand);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(C1877R.C1878id.flightlog_actions);
        final LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C1877R.C1878id.flightlog_view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (linearLayout.getVisibility() == 8) {
                    if (FlightLogAdapter.this.expandedActions != null) {
                        FlightLogAdapter.this.expandedActions.setVisibility(8);
                    }
                    if (FlightLogAdapter.this.expandedView != null) {
                        FlightLogAdapter.this.expandedView.setVisibility(8);
                    }
                    if (FlightLogAdapter.this.expandedButton != null) {
                        FlightLogAdapter.this.expandedButton.setImageResource(C1877R.drawable.item_closed);
                    }
                    LinearLayout unused = FlightLogAdapter.this.expandedActions = linearLayout;
                    LinearLayout unused2 = FlightLogAdapter.this.expandedView = linearLayout2;
                    ImageView unused3 = FlightLogAdapter.this.expandedButton = imageView;
                    linearLayout.setVisibility(0);
                    imageView.setImageResource(C1877R.drawable.item_open);
                } else if (linearLayout.getVisibility() == 0) {
                    linearLayout.setVisibility(8);
                    linearLayout2.setVisibility(8);
                    imageView.setImageResource(C1877R.drawable.item_closed);
                    LinearLayout unused4 = FlightLogAdapter.this.expandedActions = null;
                    LinearLayout unused5 = FlightLogAdapter.this.expandedView = null;
                    ImageView unused6 = FlightLogAdapter.this.expandedButton = null;
                }
                FlightLogAdapter.this.myScreen.hideAllFlightLog();
            }
        });
        final SeekBar seekBar = (SeekBar) linearLayout2.findViewById(C1877R.C1878id.flightlog_seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    FlightLogAdapter.this.myScreen.viewLogIndex(i);
                }
            }
        });
        ((ImageButton) linearLayout.findViewById(C1877R.C1878id.flightlog_view_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (linearLayout2.getVisibility() == 8) {
                    linearLayout2.setVisibility(0);
                    seekBar.setMax(FlightLogger.getInstance().getLogByName(str).getItemCount() - 1);
                    seekBar.setProgress(0);
                    FlightLogAdapter.this.myScreen.viewLog(FlightLogger.getInstance().getLogByName(str), linearLayout2);
                    FlightLogAdapter.this.myScreen.displayFlightLog();
                } else if (linearLayout2.getVisibility() == 0) {
                    FlightLogAdapter.this.myScreen.hideAllFlightLog();
                    linearLayout2.setVisibility(8);
                }
            }
        });
        ((ImageButton) linearLayout2.findViewById(C1877R.C1878id.flightlog_view_prev)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogAdapter.this.myScreen.viewLogPrev();
            }
        });
        ((ImageButton) linearLayout2.findViewById(C1877R.C1878id.flightlog_view_next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogAdapter.this.myScreen.viewLogNext();
            }
        });
        ((ImageButton) linearLayout.findViewById(C1877R.C1878id.flightlog_send_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogAdapter.this.myScreen.sendLog(FlightLogger.getInstance().getLogByName(str));
            }
        });
        ((ImageButton) linearLayout.findViewById(C1877R.C1878id.flightlog_delete_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogAdapter.this.myScreen.askDeleteLog(FlightLogger.getInstance().getLogByName(str));
            }
        });
        return view;
    }

    private String convertNameToTitle(String str) {
        return str.substring(0, str.lastIndexOf("."));
    }

    public void refresh() {
        LinearLayout linearLayout = this.expandedActions;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.expandedView;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        ImageView imageView = this.expandedButton;
        if (imageView != null) {
            imageView.setImageResource(C1877R.drawable.item_closed);
        }
        this.myScreen.hideAllFlightLog();
        this.expandedActions = null;
        this.expandedView = null;
        this.expandedButton = null;
    }
}
