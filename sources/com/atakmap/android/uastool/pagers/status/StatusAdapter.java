package com.atakmap.android.uastool.pagers.status;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.TaskProgressView;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import java.util.ArrayList;

class StatusAdapter extends ArrayAdapter<UASItem> {
    private static final String TAG = "StatusAdapter";
    private final StatusFragment myFragment;

    private static class ViewHolder {
        public ProgressBar batteryProgress;
        public TextView batteryText;
        public TextView callsignText;
        public GradientDrawable gradientDrawable;
        public ImageButton healthButton;
        public RelativeLayout mainLayout;
        public StatusMetaAdapter metaAdapter;
        public ListView metaList;
        public ImageButton panToButton;
        public ImageButton playButton;
        public ImageButton runningToggle;
        public ImageButton settingsButton;
        public ImageView signalImage;
        public RelativeLayout subLayout;
        public TextView summaryText;
        public TaskProgressView taskProgressView;
        public ImageButton topPanToButton;
        public ImageButton topRunningToggle;
        public ImageButton uasTypeButton;
        public ImageButton unlockButton;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return false;
    }

    public StatusAdapter(Context context, StatusFragment statusFragment) {
        super(context, 0, StatusArrayList.getInstance());
        this.myFragment = statusFragment;
    }

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final View view2;
        final ViewHolder viewHolder;
        final UASItem uASItem = (UASItem) getItem(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(getContext()).inflate(C1877R.layout.uas_status, (ViewGroup) null);
            viewHolder.mainLayout = (RelativeLayout) view2.findViewById(C1877R.C1878id.main_layout);
            viewHolder.uasTypeButton = (ImageButton) view2.findViewById(C1877R.C1878id.uastype_button);
            viewHolder.callsignText = (TextView) view2.findViewById(C1877R.C1878id.callsign_value);
            viewHolder.summaryText = (TextView) view2.findViewById(C1877R.C1878id.summary_value);
            viewHolder.runningToggle = (ImageButton) view2.findViewById(C1877R.C1878id.running_toggle);
            viewHolder.topRunningToggle = (ImageButton) view2.findViewById(C1877R.C1878id.top_running_toggle);
            viewHolder.signalImage = (ImageView) view2.findViewById(C1877R.C1878id.signal_value);
            viewHolder.batteryText = (TextView) view2.findViewById(C1877R.C1878id.battery_value);
            viewHolder.batteryProgress = (ProgressBar) view2.findViewById(C1877R.C1878id.battery_progress);
            viewHolder.gradientDrawable = (GradientDrawable) ((RotateDrawable) ((LayerDrawable) viewHolder.batteryProgress.getProgressDrawable().mutate()).findDrawableByLayerId(C1877R.C1878id.progress).mutate()).getDrawable().mutate();
            viewHolder.batteryProgress.setIndeterminate(false);
            viewHolder.batteryProgress.setSecondaryProgress(100);
            viewHolder.batteryProgress.setMax(100);
            viewHolder.topPanToButton = (ImageButton) view2.findViewById(C1877R.C1878id.top_panto_button);
            viewHolder.playButton = (ImageButton) view2.findViewById(C1877R.C1878id.play_button);
            viewHolder.taskProgressView = (TaskProgressView) view2.findViewById(C1877R.C1878id.task_progress);
            viewHolder.subLayout = (RelativeLayout) view2.findViewById(C1877R.C1878id.sub_layout);
            viewHolder.settingsButton = (ImageButton) view2.findViewById(C1877R.C1878id.settings_button);
            viewHolder.healthButton = (ImageButton) view2.findViewById(C1877R.C1878id.health_button);
            viewHolder.unlockButton = (ImageButton) view2.findViewById(C1877R.C1878id.unlock_button);
            viewHolder.panToButton = (ImageButton) view2.findViewById(C1877R.C1878id.panto_button);
            viewHolder.metaAdapter = new StatusMetaAdapter(getContext(), new ArrayList());
            viewHolder.metaList = (StatusMetaList) view2.findViewById(C1877R.C1878id.meta_list);
            viewHolder.metaList.setAdapter(viewHolder.metaAdapter);
            viewHolder.metaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    StatusAdapter.this.setSelectedMeta(uASItem, (StatusMetaItem) viewHolder.metaList.getItemAtPosition(i));
                }
            });
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        if (uASItem.isDefault()) {
            viewHolder.metaAdapter.update(uASItem.getStatusDataList());
            viewHolder.metaAdapter.notifyDataSetChanged();
        } else if (viewHolder.subLayout.getVisibility() == 0) {
            viewHolder.metaAdapter.update(uASItem.getStatusDataList());
            viewHolder.metaAdapter.notifyDataSetChanged();
        }
        if (uASItem.isDefault()) {
            viewHolder.mainLayout.setBackgroundColor(Color.parseColor("#003d55"));
        } else {
            viewHolder.mainLayout.setBackgroundColor(getContext().getResources().getColor(C1877R.color.darker_gray));
        }
        if (uASItem.isStale()) {
            viewHolder.uasTypeButton.setImageDrawable(getContext().getDrawable(C1877R.drawable.uas_blank));
            viewHolder.uasTypeButton.setColorFilter((ColorFilter) null);
            viewHolder.uasTypeButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.uasTypeButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            Drawable uASIcon = uASItem.getUASIcon();
            if (!(viewHolder.uasTypeButton == null || uASIcon == null)) {
                viewHolder.uasTypeButton.setImageDrawable(uASIcon);
            }
        }
        if (uASItem.isDefault()) {
            viewHolder.uasTypeButton.setEnabled(false);
            viewHolder.uasTypeButton.setBackground(new ColorDrawable(0));
        } else {
            viewHolder.uasTypeButton.setEnabled(false);
            viewHolder.uasTypeButton.setBackground(new ColorDrawable(0));
        }
        viewHolder.callsignText.setText(uASItem.getCallsign());
        int i2 = -65536;
        if (uASItem.isStale()) {
            viewHolder.callsignText.setTextColor(-3355444);
            viewHolder.callsignText.setOnClickListener((View.OnClickListener) null);
        } else {
            uASItem.getGeoPoint();
            if (!uASItem.isDefault() || uASItem.getBatteryPercent() > 0.2d) {
                viewHolder.callsignText.setTextColor(-1);
            } else {
                viewHolder.callsignText.setTextColor(-65536);
            }
            viewHolder.callsignText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatusAdapter.this.expand(view2, uASItem);
                }
            });
        }
        if (uASItem.isStale()) {
            viewHolder.summaryText.setTextColor(-3355444);
            viewHolder.summaryText.setOnClickListener((View.OnClickListener) null);
            viewHolder.summaryText.setText(uASItem.getStatusSummary());
        } else {
            if (!uASItem.isDefault()) {
                viewHolder.summaryText.setTextColor(-1);
                viewHolder.summaryText.setText(uASItem.getStatusSummary());
            } else if (viewHolder.metaList.getChildCount() > 0) {
                StatusMetaItem statusMetaItem = (StatusMetaItem) viewHolder.metaList.getItemAtPosition(0);
                if (statusMetaItem == null || !statusMetaItem.isError()) {
                    viewHolder.summaryText.setTextColor(-1);
                    viewHolder.summaryText.setText(uASItem.getStatusSummary());
                } else {
                    viewHolder.summaryText.setTextColor(-65536);
                    viewHolder.summaryText.setText(statusMetaItem.getMeta());
                }
            } else {
                viewHolder.summaryText.setTextColor(-1);
                viewHolder.summaryText.setText(uASItem.getStatusSummary());
            }
            viewHolder.summaryText.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatusAdapter.this.expand(view2, uASItem);
                }
            });
        }
        if (uASItem.isDefault()) {
            viewHolder.topRunningToggle.setVisibility(8);
            if (!uASItem.isStale()) {
                if (uASItem.getCurrentTask() == null || !uASItem.getCurrentTask().getState().equals(UASTask.STATE.RUNNING)) {
                    if (uASItem.getMarker() != null) {
                        uASItem.getMarker().setMetaBoolean("_uastool:activeRoute", false);
                        uASItem.getMarker().notifyMetadataChanged("_uastool:activeRoute");
                        uASItem.setRouteActive(false);
                    }
                } else if (uASItem.getMarker() != null) {
                    uASItem.getMarker().setMetaBoolean("_uastool:activeRoute", true);
                    uASItem.getMarker().notifyMetadataChanged("_uastool:activeRoute");
                    uASItem.setRouteActive(true);
                }
                if (uASItem.getMarker() == null || !uASItem.getMarker().getMetaBoolean("_uastool:activeRoute", false)) {
                    viewHolder.runningToggle.setImageResource(C1877R.drawable.routes);
                } else {
                    viewHolder.runningToggle.setImageResource(C1877R.drawable.taskstate_running);
                }
                if (uASItem.getCurrentTask() != null && uASItem.getCurrentTask().getTaskType().equals(UASTask.TASKTYPE.ROUTE) && ((RouteTask) uASItem.getCurrentTask()).getIsQuickTask()) {
                    viewHolder.runningToggle.setVisibility(0);
                    viewHolder.runningToggle.setEnabled(false);
                    viewHolder.runningToggle.setColorFilter(TaskEdit.viewColor);
                    uASItem.hideRoute();
                } else if (uASItem.hasRouteToShow()) {
                    viewHolder.runningToggle.setVisibility(0);
                    viewHolder.runningToggle.setEnabled(true);
                    viewHolder.runningToggle.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            UASItem uASItem = uASItem;
                            if (UASItem.checkCapability(uASItem, uASItem.getPlatformType(), UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW).booleanValue()) {
                                SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
                                try {
                                    if (uASItem.isRouteShowing()) {
                                        uASItem.hideRoute();
                                        edit.putBoolean(UASToolPreferenceFragment.ROUTES_WAYPOINTS_OVERLAY, false);
                                        viewHolder.runningToggle.setColorFilter(0);
                                    } else {
                                        uASItem.showRoute();
                                        edit.putBoolean(UASToolPreferenceFragment.ROUTES_WAYPOINTS_OVERLAY, true);
                                        viewHolder.runningToggle.setColorFilter(TaskEdit.viewColor);
                                    }
                                } catch (Exception e) {
                                    UASToolDropDownReceiver.toast(e.getMessage(), 0);
                                }
                                edit.apply();
                            }
                        }
                    });
                    viewHolder.runningToggle.setOnLongClickListener(new View.OnLongClickListener() {
                        public boolean onLongClick(View view) {
                            StatusAdapter.this.showHelp("Active Route Running", "Toggle displaying the active route");
                            return true;
                        }
                    });
                    viewHolder.runningToggle.setColorFilter(uASItem.isRouteShowing() ? TaskEdit.viewColor : 0);
                }
            } else {
                viewHolder.runningToggle.setVisibility(8);
                uASItem.hideRoute();
            }
        } else {
            viewHolder.runningToggle.setVisibility(8);
            if (!UASItem.checkCapability(uASItem, uASItem.getPlatformType(), UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW).booleanValue() || !uASItem.hasRouteToShow() || uASItem.isStale()) {
                viewHolder.topRunningToggle.setVisibility(8);
                uASItem.hideRoute();
            } else {
                if (uASItem.getMarker().getMetaBoolean("_uastool:activeRoute", false)) {
                    viewHolder.topRunningToggle.setImageResource(C1877R.drawable.taskstate_running);
                } else {
                    viewHolder.topRunningToggle.setImageResource(C1877R.drawable.routes);
                }
                viewHolder.topRunningToggle.setVisibility(0);
                viewHolder.topRunningToggle.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            if (uASItem.isRouteShowing()) {
                                uASItem.hideRoute();
                                viewHolder.topRunningToggle.setColorFilter(0);
                                return;
                            }
                            uASItem.showRoute();
                            viewHolder.topRunningToggle.setColorFilter(TaskEdit.viewColor);
                        } catch (Exception e) {
                            UASToolDropDownReceiver.toast(e.getMessage(), 0);
                            uASItem.hideRoute();
                        }
                    }
                });
            }
            viewHolder.topRunningToggle.setColorFilter(uASItem.isRouteShowing() ? TaskEdit.viewColor : 0);
        }
        if (!uASItem.supportsSignalStrength()) {
            viewHolder.signalImage.setVisibility(8);
            viewHolder.signalImage.setOnClickListener((View.OnClickListener) null);
            viewHolder.signalImage.setOnLongClickListener((View.OnLongClickListener) null);
        } else if (uASItem.isStale()) {
            viewHolder.signalImage.setVisibility(0);
            viewHolder.signalImage.setImageResource(C1877R.drawable.signal_0);
            viewHolder.signalImage.setOnClickListener((View.OnClickListener) null);
            viewHolder.signalImage.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            viewHolder.signalImage.setVisibility(0);
            viewHolder.signalImage.setImageResource(uASItem.getSignalStrengthImageId(false));
            viewHolder.signalImage.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Signal Strength Help", "Displays the UAS signal strength to GCS.");
                    return true;
                }
            });
        }
        if (!uASItem.isDefault()) {
            viewHolder.signalImage.setVisibility(8);
        }
        if (uASItem.isStale()) {
            viewHolder.batteryProgress.setProgress(0);
            viewHolder.gradientDrawable.setColor(Color.parseColor("#999999"));
            viewHolder.batteryText.setText(C1877R.string.dashdashdash);
            viewHolder.batteryText.setOnClickListener((View.OnClickListener) null);
            viewHolder.batteryText.setOnLongClickListener((View.OnLongClickListener) null);
            viewHolder.batteryProgress.setOnClickListener((View.OnClickListener) null);
            viewHolder.batteryProgress.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            int batteryPercent = (int) (uASItem.getBatteryPercent() * 100.0d);
            viewHolder.batteryProgress.setProgress(batteryPercent);
            if (batteryPercent > 66) {
                i2 = TaskEdit.viewColor;
            } else if (batteryPercent > 33) {
                i2 = -256;
            }
            viewHolder.gradientDrawable.setColor(i2);
            viewHolder.batteryText.setText(uASItem.getBatteryDisplay());
            viewHolder.batteryText.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Battery Help", "Displays the UAS remaining battery level.");
                    return true;
                }
            });
            viewHolder.batteryProgress.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Battery Help", "Displays the UAS remaining battery level.");
                    return true;
                }
            });
        }
        if (uASItem.isDefault()) {
            viewHolder.batteryProgress.setVisibility(0);
            viewHolder.batteryText.setVisibility(0);
        } else {
            viewHolder.batteryProgress.setVisibility(8);
            viewHolder.batteryText.setVisibility(8);
        }
        if (uASItem.isStale()) {
            viewHolder.topPanToButton.setEnabled(true);
        } else {
            viewHolder.topPanToButton.setEnabled(true);
        }
        if (uASItem.isDefault()) {
            viewHolder.topPanToButton.setVisibility(8);
            viewHolder.topPanToButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.topPanToButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            viewHolder.topPanToButton.setVisibility(0);
            viewHolder.topPanToButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatusAdapter.this.panTo(uASItem);
                }
            });
            viewHolder.topPanToButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Pan To Help", "Pans the map to the UAS.");
                    return true;
                }
            });
        }
        if (uASItem.isStale()) {
            viewHolder.playButton.setBackgroundResource(C1877R.drawable.new_dark_button_disabled);
            viewHolder.playButton.setEnabled(false);
            viewHolder.playButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.playButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            if (uASItem.isBroadcastingVideo()) {
                viewHolder.playButton.setBackgroundResource(C1877R.drawable.new_dark_button_video);
            } else {
                viewHolder.playButton.setBackgroundResource(C1877R.drawable.new_dark_button_bg);
            }
            viewHolder.playButton.setEnabled(true);
            viewHolder.playButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatusAdapter.this.showUAS(uASItem);
                }
            });
            viewHolder.playButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Play Help", "Displays the selected UAS in detail.");
                    return true;
                }
            });
        }
        if (uASItem.supportsTaskProgress()) {
            uASItem.addTaskListener(viewHolder.taskProgressView);
            viewHolder.taskProgressView.setTextMode(TaskProgressView.TEXTMODE.NONE);
        }
        if (!uASItem.isDefault() || !uASItem.hasSettings()) {
            viewHolder.settingsButton.setVisibility(8);
            viewHolder.settingsButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.settingsButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            viewHolder.settingsButton.setVisibility(0);
            if (uASItem.isConnected()) {
                viewHolder.settingsButton.setEnabled(true);
                viewHolder.settingsButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatusAdapter.this.showSettings(uASItem);
                    }
                });
                viewHolder.settingsButton.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        StatusAdapter.this.showHelp("Platform Settings Help", "Opens the platform settings for the connected UAS.");
                        return true;
                    }
                });
            } else {
                viewHolder.settingsButton.setEnabled(false);
                viewHolder.settingsButton.setOnClickListener((View.OnClickListener) null);
                viewHolder.settingsButton.setOnLongClickListener((View.OnLongClickListener) null);
            }
        }
        if (!uASItem.isDefault() || !uASItem.supportsHealth()) {
            viewHolder.healthButton.setVisibility(8);
            viewHolder.healthButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.healthButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            viewHolder.healthButton.setVisibility(0);
            if (uASItem.isConnected()) {
                viewHolder.healthButton.setEnabled(true);
                viewHolder.healthButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatusAdapter.this.showHealth(uASItem);
                    }
                });
                viewHolder.healthButton.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        StatusAdapter.this.showHelp("Platform Health Help", "Opens the platform settings for the connected UAS.");
                        return true;
                    }
                });
            } else {
                viewHolder.healthButton.setEnabled(false);
                viewHolder.healthButton.setOnClickListener((View.OnClickListener) null);
                viewHolder.healthButton.setOnLongClickListener((View.OnLongClickListener) null);
            }
        }
        if (!uASItem.isDefault() || !uASItem.isUnlockable()) {
            viewHolder.unlockButton.setVisibility(8);
            viewHolder.unlockButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.unlockButton.setOnLongClickListener((View.OnLongClickListener) null);
        } else {
            viewHolder.unlockButton.setVisibility(0);
            if (uASItem.isConnected()) {
                viewHolder.unlockButton.setEnabled(true);
                viewHolder.unlockButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StatusAdapter.this.unlock(uASItem);
                    }
                });
                viewHolder.unlockButton.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        StatusAdapter.this.showHelp("UAS Unlock Help", "Unlocks the connected UAS.");
                        return true;
                    }
                });
            } else {
                viewHolder.unlockButton.setEnabled(false);
                viewHolder.unlockButton.setOnClickListener((View.OnClickListener) null);
                viewHolder.unlockButton.setOnLongClickListener((View.OnLongClickListener) null);
            }
        }
        if (uASItem.isStale()) {
            viewHolder.panToButton.setEnabled(true);
        } else {
            viewHolder.panToButton.setEnabled(true);
        }
        if (uASItem.isDefault()) {
            viewHolder.panToButton.setVisibility(0);
            viewHolder.panToButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatusAdapter.this.panTo(uASItem);
                }
            });
            viewHolder.panToButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    StatusAdapter.this.showHelp("Pan To Help", "Pans the map to the UAS.");
                    return true;
                }
            });
        } else {
            viewHolder.panToButton.setVisibility(8);
            viewHolder.panToButton.setOnClickListener((View.OnClickListener) null);
            viewHolder.panToButton.setOnLongClickListener((View.OnLongClickListener) null);
        }
        if (uASItem.isStale()) {
            viewHolder.subLayout.setVisibility(8);
        }
        return view2;
    }

    /* access modifiers changed from: private */
    public void setSelectedMeta(UASItem uASItem, StatusMetaItem statusMetaItem) {
        if (!statusMetaItem.isError()) {
            StatusMetaItem statusSummaryItem = uASItem.getStatusSummaryItem();
            if (statusSummaryItem != null) {
                statusSummaryItem.setSelected(false);
                if (!statusSummaryItem.getType().equals(statusMetaItem.getType())) {
                    statusMetaItem.setSelected(!statusMetaItem.isSelected());
                }
            } else {
                statusMetaItem.setSelected(!statusMetaItem.isSelected());
            }
            if (statusMetaItem.isSelected()) {
                uASItem.setStatusSummaryItem(statusMetaItem);
            } else {
                uASItem.setStatusSummaryItem((StatusMetaItem) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showUAS(UASItem uASItem) {
        if (!uASItem.isStale()) {
            UASToolDropDownReceiver.getInstance().showUAS(uASItem);
        }
    }

    private void changeUASIcon(UASItem uASItem) {
        if (uASItem.isDefault()) {
            uASItem.changeIcon();
        } else {
            toast("Unable to change icon for non-connected UAS");
        }
    }

    /* access modifiers changed from: private */
    public void showSettings(UASItem uASItem) {
        if (!uASItem.isStale()) {
            this.myFragment.showPlatformSettings(uASItem);
        }
    }

    /* access modifiers changed from: private */
    public void showHealth(UASItem uASItem) {
        if (!uASItem.isStale()) {
            this.myFragment.showPlatformHealth(uASItem);
        }
    }

    /* access modifiers changed from: private */
    public void unlock(UASItem uASItem) {
        if (!uASItem.isStale()) {
            this.myFragment.unlockPlatform(uASItem);
        }
    }

    /* access modifiers changed from: private */
    public void panTo(UASItem uASItem) {
        UASToolDropDownReceiver.getInstance().panTo(uASItem);
    }

    /* access modifiers changed from: private */
    public void expand(View view, UASItem uASItem) {
        if (uASItem.isStale()) {
            return;
        }
        if (view != null) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (viewHolder != null) {
                if (viewHolder.subLayout.getVisibility() != 8) {
                    viewHolder.subLayout.setVisibility(8);
                    if (viewHolder.taskProgressView.getVisibility() == 0) {
                        viewHolder.taskProgressView.setTextMode(TaskProgressView.TEXTMODE.NONE);
                    }
                } else {
                    viewHolder.subLayout.setVisibility(0);
                    if (viewHolder.taskProgressView.getVisibility() == 0) {
                        viewHolder.taskProgressView.setTextMode(TaskProgressView.TEXTMODE.BELOW);
                    }
                }
                view.invalidate();
                view.requestLayout();
                return;
            }
            toast("Null ViewHolder in expand");
            return;
        }
        toast("Null convertView in expand");
    }

    public void close(View view, UASItem uASItem) {
        ViewHolder viewHolder;
        if (!uASItem.isStale() && view != null && (viewHolder = (ViewHolder) view.getTag()) != null) {
            viewHolder.subLayout.setVisibility(8);
            if (viewHolder.taskProgressView.getVisibility() == 0) {
                viewHolder.taskProgressView.setTextMode(TaskProgressView.TEXTMODE.NONE);
            }
            view.invalidate();
            view.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }
}
