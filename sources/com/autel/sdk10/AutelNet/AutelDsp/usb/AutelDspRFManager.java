package com.autel.sdk10.AutelNet.AutelDsp.usb;

import android.os.AsyncTask;
import android.os.Build;
import com.autel.common.dsp.AutelCancellable;
import com.autel.common.dsp.RFData;
import com.autel.sdk10.AutelNet.AutelDsp.usb.connection.AutelDspRFUDPConnection;
import com.autel.sdk10.AutelNet.AutelDsp.usb.engine.AutelDspJsonCommand;
import com.autel.sdk10.AutelNet.AutelDsp.usb.interfaces.AutelRFInterfaces;
import com.autel.util.log.AutelLog;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AutelDspRFManager {
    private static AutelDspRFManager instance;
    private final int RFType_ALL = 0;
    private final int RFType_CUR = 1;
    private GetRFTask scanRFTask;
    private SetCurRFTask setCurRFTask;

    public static AutelDspRFManager getInstance() {
        if (instance == null) {
            instance = new AutelDspRFManager();
        }
        return instance;
    }

    private AutelDspRFManager() {
    }

    public AutelCancellable startScanRFTask(int i, AutelRFInterfaces.OnGetRFTaskListener onGetRFTaskListener) {
        return startRFTask(0, AutelDspJsonCommand.createScanAllRF(), i, onGetRFTaskListener);
    }

    public AutelCancellable startGetCurRFTask(int i, final AutelRFInterfaces.OnGetCurRFTaskListener onGetCurRFTaskListener) {
        return startRFTask(1, AutelDspJsonCommand.createGetCurRF(), i, new AutelRFInterfaces.OnGetRFTaskListener() {
            public void onRFData(ArrayList<RFData> arrayList) {
                AutelRFInterfaces.OnGetCurRFTaskListener onGetCurRFTaskListener = onGetCurRFTaskListener;
                if (onGetCurRFTaskListener != null) {
                    onGetCurRFTaskListener.onCurRFData((arrayList == null || arrayList.size() <= 0) ? new RFData(0.0f, 0) : arrayList.get(0));
                }
            }
        });
    }

    public AutelCancellable startSetCurRFTask(int i, int i2, AutelRFInterfaces.OnSetRFTaskListener onSetRFTaskListener) {
        SetCurRFTask setCurRFTask2 = new SetCurRFTask(i2, onSetRFTaskListener);
        setCurRFTask2.execute(new String[]{AutelDspJsonCommand.createSetRF(Integer.toString(i))});
        return setCurRFTask2;
    }

    private AutelCancellable startRFTask(int i, String str, int i2, AutelRFInterfaces.OnGetRFTaskListener onGetRFTaskListener) {
        GetRFTask getRFTask = new GetRFTask(i, i2, onGetRFTaskListener);
        getRFTask.execute(new String[]{str});
        return getRFTask;
    }

    public void stopAll() {
        stopRFTask();
        stopSetRFTask();
    }

    public void stopRFTask() {
        GetRFTask getRFTask = this.scanRFTask;
        if (getRFTask != null) {
            getRFTask.stopTask();
            this.scanRFTask.cancel(true);
        }
    }

    public void stopSetRFTask() {
        SetCurRFTask setCurRFTask2 = this.setCurRFTask;
        if (setCurRFTask2 != null) {
            setCurRFTask2.stopTask();
            this.setCurRFTask.cancel(true);
        }
    }

    private class GetRFTask extends AsyncTask<String, String, ArrayList<RFData>> implements AutelCancellable {
        private int RFType = 0;
        private AutelDspRFUDPConnection autelDspRFUDPConnection;
        private boolean isRunning = true;
        private int maxRetryCount;
        private AutelRFInterfaces.OnGetRFTaskListener onGetRFTaskListener;
        private int retryCount = 0;

        public GetRFTask(int i, int i2, AutelRFInterfaces.OnGetRFTaskListener onGetRFTaskListener2) {
            this.RFType = i;
            this.autelDspRFUDPConnection = new AutelDspRFUDPConnection();
            this.onGetRFTaskListener = onGetRFTaskListener2;
            this.maxRetryCount = i2;
            this.isRunning = true;
            this.retryCount = 0;
        }

        public void stopTask() {
            this.isRunning = false;
            this.onGetRFTaskListener = null;
        }

        /* access modifiers changed from: protected */
        public ArrayList<RFData> doInBackground(String... strArr) {
            int i;
            ArrayList<RFData> arrayList = null;
            String str = null;
            while (this.isRunning && (i = this.retryCount) < this.maxRetryCount) {
                if (i > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        AutelDspRFUDPConnection autelDspRFUDPConnection2 = this.autelDspRFUDPConnection;
                        if (autelDspRFUDPConnection2 != null) {
                            try {
                                autelDspRFUDPConnection2.closeConnection();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (str == null) {
                            this.retryCount++;
                        } else {
                            arrayList = this.RFType == 0 ? AutelDspJsonCommand.resolveScanAllRFJson(str) : AutelDspJsonCommand.resolveGetCurRFJson(str);
                            if (arrayList == null) {
                                this.retryCount++;
                            } else {
                                this.isRunning = false;
                            }
                        }
                    } catch (Throwable th) {
                        AutelDspRFUDPConnection autelDspRFUDPConnection3 = this.autelDspRFUDPConnection;
                        if (autelDspRFUDPConnection3 != null) {
                            try {
                                autelDspRFUDPConnection3.closeConnection();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (str != null) {
                            if ((this.RFType == 0 ? AutelDspJsonCommand.resolveScanAllRFJson(str) : AutelDspJsonCommand.resolveGetCurRFJson(str)) == null) {
                                this.retryCount++;
                            } else {
                                this.isRunning = false;
                            }
                        } else {
                            this.retryCount++;
                        }
                        throw th;
                    }
                }
                this.autelDspRFUDPConnection.openConnection();
                this.autelDspRFUDPConnection.sendBuffer(strArr[0].getBytes());
                byte[] bArr = new byte[1024];
                String str2 = new String(bArr, 0, this.autelDspRFUDPConnection.readDataBlock(bArr));
                AutelDspRFUDPConnection autelDspRFUDPConnection4 = this.autelDspRFUDPConnection;
                if (autelDspRFUDPConnection4 != null) {
                    try {
                        autelDspRFUDPConnection4.closeConnection();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                arrayList = this.RFType == 0 ? AutelDspJsonCommand.resolveScanAllRFJson(str2) : AutelDspJsonCommand.resolveGetCurRFJson(str2);
                if (arrayList == null) {
                    this.retryCount++;
                } else {
                    this.isRunning = false;
                }
                str = str2;
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ArrayList<RFData> arrayList) {
            AutelRFInterfaces.OnGetRFTaskListener onGetRFTaskListener2 = this.onGetRFTaskListener;
            if (onGetRFTaskListener2 != null) {
                if (arrayList == null) {
                    onGetRFTaskListener2.onRFData((ArrayList<RFData>) null);
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                AutelDspRFManager.this.getRFDatas(arrayList2);
                this.onGetRFTaskListener.onRFData(arrayList2);
            }
        }

        public boolean cancel() {
            if (!this.isRunning) {
                return false;
            }
            stopTask();
            return super.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    public void getRFDatas(ArrayList<RFData> arrayList) {
        Collections.sort(arrayList, new RFDataComparator());
    }

    private class RFDataComparator implements Comparator<RFData> {
        private RFDataComparator() {
        }

        public int compare(RFData rFData, RFData rFData2) {
            return (int) (rFData.frequency - rFData2.frequency);
        }
    }

    private class SetCurRFTask extends AsyncTask<String, String, Boolean> implements AutelCancellable {
        private AutelDspRFUDPConnection autelDspRFUDPConnection = new AutelDspRFUDPConnection();
        private boolean isRunning = true;
        private int maxRetryCount;
        private AutelRFInterfaces.OnSetRFTaskListener onSetRFTaskListener;
        private int retryCount = 0;

        public SetCurRFTask(int i, AutelRFInterfaces.OnSetRFTaskListener onSetRFTaskListener2) {
            this.onSetRFTaskListener = onSetRFTaskListener2;
            this.maxRetryCount = i;
            this.isRunning = true;
            this.retryCount = 0;
        }

        public void stopTask() {
            this.isRunning = false;
            this.onSetRFTaskListener = null;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strArr) {
            int i;
            String str = null;
            boolean z = false;
            while (this.isRunning && (i = this.retryCount) < this.maxRetryCount) {
                if (i > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            this.autelDspRFUDPConnection.closeConnection();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (str == null) {
                            this.retryCount++;
                        } else {
                            z = AutelDspJsonCommand.resolveSetRFJson(str);
                            if (!z) {
                                this.retryCount++;
                            } else {
                                this.isRunning = false;
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            this.autelDspRFUDPConnection.closeConnection();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        if (str == null) {
                            this.retryCount++;
                        } else if (!AutelDspJsonCommand.resolveSetRFJson(str)) {
                            this.retryCount++;
                        } else {
                            this.isRunning = false;
                        }
                        throw th;
                    }
                }
                this.autelDspRFUDPConnection.openConnection();
                this.autelDspRFUDPConnection.sendBuffer(strArr[0].getBytes());
                byte[] bArr = new byte[512];
                int readDataBlock = this.autelDspRFUDPConnection.readDataBlock(bArr);
                AutelLog.m15084e("DSP_RF", "len = " + readDataBlock);
                if (Build.VERSION.SDK_INT >= 19) {
                    AutelLog.m15084e("DSP_RF", new String(bArr, 0, readDataBlock, StandardCharsets.US_ASCII));
                }
                String str2 = new String(bArr, 0, readDataBlock);
                try {
                    this.autelDspRFUDPConnection.closeConnection();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                z = AutelDspJsonCommand.resolveSetRFJson(str2);
                if (!z) {
                    this.retryCount++;
                } else {
                    this.isRunning = false;
                }
                str = str2;
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            AutelRFInterfaces.OnSetRFTaskListener onSetRFTaskListener2 = this.onSetRFTaskListener;
            if (onSetRFTaskListener2 != null) {
                onSetRFTaskListener2.onResult(bool.booleanValue());
            }
        }

        public boolean cancel() {
            if (!this.isRunning) {
                return false;
            }
            stopTask();
            return super.cancel(true);
        }
    }
}
